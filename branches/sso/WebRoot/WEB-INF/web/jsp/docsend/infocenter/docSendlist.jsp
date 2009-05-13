<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List list = (List)request.getAttribute("list");
String type = (String)request.getAttribute("type");
if (type==null||"".equals(type))
	type = (String)request.getParameter("type");
String listName = null;
String lightNum="5";
if("newAndDoing".equals(type)){
	listName="新收到和正在办理的发文";
}else if("1".equals(type)){
	listName="新收到的发文";
	lightNum="1";
}else if("2".equals(type)){
	listName="正在办理的发文";
	lightNum="2";
}else if("0".equals(type)) {
	listName="已办理的发文";
	lightNum="3";
}else{
	listName="新起草的发文";
	lightNum="4";
}

String sessionID = "";
	int curPage = 0;
	long count=0;
	try {
		sessionID = (String) request.getAttribute("sessionID");
		curPage = (Integer) session.getAttribute(sessionID + "No");
		count=(Long)session.getAttribute(sessionID+"Count");

	} catch (Exception ex) {
		ex.printStackTrace();
	}
	List list = (List) request.getAttribute("curPageList");
	
//String lightNum = request.getParameter("lightNum");//高亮判断用
//if (lightNum==null||"".equals(lightNum))
//	lightNum="1";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'pstlvllist.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="images/style.css" rel="stylesheet" type="text/css">
<script language="javascript">
function docSendDispose(docId,controlId,statetype) {
	if (statetype==1)
		window.location.href="<%=path%>/xdocSendCharger.do?method=input&controlId="+controlId;
	else if(statetype==2)
		window.location.href="<%=path%>/xdocSendLeader.do?method=input&controlId="+controlId;
	else if(statetype==3)
		window.location.href="<%=path%>/xdocSendPrinter.do?method=input&controlId="+controlId;
}

function newBookDoc(controlId){
	window.location.href="<%=path%>/xdocSendBook.do?method=input&controlId="+controlId;
}

function docSendView(docId){
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=docSendView&docId="+docId;
}

function delDoc(docId) {
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=delSendDoc&docId="+docId;
}

function argue(docTitle,docId) {
	window.open("<%=path%>/xdocSendRelatedAction.do?method=argueNoticeInput&docId="+docId+"&docTitle="+docTitle,'newwindow', 'height=200, width=630, top=250, left=280, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');
}

function rollBack(docId,closetime) {
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=rollBack&docId="+docId+"&closetime="+closetime;
}
</script>
<script language="javascript">
function docSendList(type,n)
{
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=docSendList&type="+type+"&lightNum="+n;
}
function docSendBook()
{
	window.location.href="<%=path%>/xdocSendBook.do?method=input&lightNum=1";
}
function back(n)
{
	window.location.href="<%=path%>/xdocSendRelatedAction.do?method=docSendList&type=newAndDoing&lightNum=1";
}
function secBoard(n)
{
 for(i=1;i<secTable.cells.length-3;i++)
  	secTable.cells[i].className="tabin_atabno";
 	secTable.cells[n].className="tabin_atab";
}
</script>
 </head>  
 <body onload="secBoard(<%=Integer.parseInt(lightNum) %>)">
 <form action="/xdocSendRelatedAction.do">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic"><%=listName%></td>
            </tr>
          </table></td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0" id="secTable">
				<tr>
				<td width="2%" height="24">&nbsp;</td>
			<td width="15%" class="tabin_atab">
                <span class="bg-zw" onclick="javascript:docSendList('1',1);" onmouseover="this.style.cursor='hand'">新收到的发文</span> 
			</td>
			<td width="15%" class="tabin_atabno">
                <span class="bg-zw" onclick="javascript:docSendList('2',2);" onmouseover="this.style.cursor='hand'">正在办理的发文</span>
			</td>
			<td width="15%" class="tabin_atabno">
                <span class="bg-zw"  onclick="javascript:docSendList('0',3);" onmouseover="this.style.cursor='hand'">已办理的发文</span>
			</td>
			<td width="15%" class="tabin_atabno">
                <span class="bg-zw" onclick="javascript:docSendList('3',4);" onmouseover="this.style.cursor='hand'">新起草的发文 </span>
            </td>
            <td width="15%" class="tabin_atabno">
            	<span class="bg-zw" onclick="javascript:back(1);" onmouseover="this.style.cursor='hand'">返回</span>
            </td>
            <td colspan="2" align="center">
             
			<input name="Submit2" type="button" class="button0" value="发文起草" onclick="docSendBook();" onmouseover="this.style.cursor='hand'"/>
			</td>
         </tr>
	</table>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                      <tr>
                        <th width="20%" height="25">文件标题</th>
                        <th width="17%">流入时间</th>
                        <th width="17%">签收时间</th>
                        <th width="17%">当前流程步骤</th>
                        <th>操作</th>
                      </tr>
        <%for (int i=0; !list.isEmpty()&&list.size()>0&&i<list.size(); i++) {
    		Object[] item = (Object[])list.get(i);
    	%>
                      <tr>
                        <td height="25"><%=item[2]==null?"&nbsp;":item[2] %></td>
                        <td><%=item[3]==null?"&nbsp;":item[3] %></td>
                        <td><%=item[4]==null?"&nbsp;":item[4] %></td>
                        <td><%=item[5]==null?"&nbsp;":item[5] %></td>
                        <td align="center" valign="middle">
            <%  if ("newAndDoing".equals(type) || "1".equals(type) || "2".equals(type)){%>
                <input type="button" class="button1" value="办理" onclick="docSendDispose('<%=item[0] %>','<%=item[1] %>','<%=item[6] %>')"/>
    		<%}else if ("0".equals(type)) {%>
    			<input type="button" class="button1" value="查看" onclick="docSendView('<%=item[0] %>')"/>
    			<%if ("1".equals(item[6])) {%>
    				<input type="button" class="button1" value="催办" onclick="argue('<%=item[2] %>','<%=item[0] %>')"/>
    				<input type="button" class="button1" value="取回" onclick="rollBack('<%=item[0] %>','<%=item[7] %>')"/>
				<%}
			} else {%>
				<input type="button" class="button1" value="查看" onclick="newBookDoc('<%=item[1] %>')"/>
				<input type="button" class="button1" value="删除" onclick="delDoc('<%=item[0] %>')"/>
    		<%}%></td>
                      </tr>
		<%}%>
		<%  if ("newAndDoing".equals(type)) {%>
 	 	<tr>
 	 		<td colspan="5" align="center">
 	 			新收到的文书&nbsp;<%=request.getAttribute("size1") %>&nbsp;正在办理&nbsp;<%=request.getAttribute("size2") %>&nbsp;
 	 		</td>
 	 	</tr><%}%>
                    </table>
                   <table width="99%" border="0" cellspacing="0"
																cellpadding="0" align="right">
																<tr>
																	<td height="10"></td>
																</tr>
																<tr>
																	<td class="tabin_page">
																		<a
																			href="<%=path%>/xdocSendRelatedAction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&type=<%=type%>&lightNum=<%=lightNum %>"><span
																			class="bg-zw">上一页</span>
																		</a>
																		<a
																			href="<%=path%>/xdocSendRelatedAction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&type=<%=type%>&lightNum=<%=lightNum %>"><span
																			class="bg-zw">下一页</span>
																		</a> 第
																		<%=curPage + 1%>
																		页 每页显示
																		<a
																			href="<%=path%>/xdocSendRelatedAction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&type=<%=type%>&lightNum=<%=lightNum %>"><span
																			class="bg-zw">10</span>
																		</a>
																		<a
																			href="<%=path%>/xdocSendRelatedAction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&type=<%=type%>&lightNum=<%=lightNum %>"><span
																			class="bg-zw">20</span>
																		</a>
																		<a
																			href="<%=path%>/xdocSendRelatedAction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&type=<%=type%>&lightNum=<%=lightNum %>"><span
																			class="bg-zw">30</span>
																		</a> 条 共<%=count %>条
																	</td>
																</tr>
															</table>
                    </td>
                </tr>
                <tr>
                  <td height="20"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="10"></td>
            </tr>
          </table></td>
        </tr>
      </table>
      </form>
</body>
</html>

