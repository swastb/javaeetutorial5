<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
//List list = (List)request.getAttribute("list");
String who = (String)request.getAttribute("who");
if (who==null || "".equals(who))
	who = (String)request.getParameter("who");
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
    <link href="images/style.css" rel="stylesheet" type="text/css" />
    
 </head>  
 <body onload="secBoard(1)">

 <form>
 	
 	<div style="position:relative;">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">新收到的收文</td>
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
                  <td align="center" valign="top"><jsp:include flush="true" page="commMenu.jsp"></jsp:include>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                      <tr>
                        <th width="30%" height="25">文件标题</th>
                        <th width="17%">流入时间</th>
                        <th width="17%">签收时间</th>
                        <th width="17%">当前流程步骤</th>
                        <th>操作</th>
                      </tr>
    	<%for (int i = 0; !list.isEmpty()&&list.size()>0&&i < list.size(); i++) {
    		Object[] item = (Object[])list.get(i);
    	%>
                      <tr>
                        <td height="25"><%=item[0]==null?"&nbsp;":item[0] %></td>
                        <td><%=item[1]==null?"&nbsp;":item[1] %></td>
                        <td><%=item[2]==null?"&nbsp;":item[2] %></td>
                        <td><%=item[3]==null?"&nbsp;":item[3] %></td>
                        <td align="center" valign="middle">
    					<input type="button" class="button1" value="办理" onclick="docRecDispose('<%=item[4] %>','<%=item[5] %>','<%=item[6] %>')"/>
    					</td>
                      </tr>
		<%}%>

                    </table>
                   <table width="99%" border="0" cellspacing="0" cellpadding="0" align="right">
						<tr>
							<td height="10"></td>
						</tr>
						<tr>
							<td class="tabin_page">
							<a href="<%=path%>/docRecListAction.do?method=movePageDocRec&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&pageName=newReceiveList&who=<%=who %>">上一页</a>
							<a href="<%=path%>/docRecListAction.do?method=movePageDocRec&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&pageName=newReceiveList&who=<%=who %>">下一页
							</a> 第 1 页 每页显示
							<a href="<%=path%>/docRecListAction.do?method=resetPageSizeDocRec&pageSize=10&sessionID=<%=sessionID%>&pageName=newReceiveList&who=<%=who %>">10</a>
							<a href="<%=path%>/docRecListAction.do?method=resetPageSizeDocRec&pageSize=20&sessionID=<%=sessionID%>&pageName=newReceiveList&who=<%=who %>">20</a>
							<a href="<%=path%>/docRecListAction.do?method=resetPageSizeDocRec&pageSize=30&sessionID=<%=sessionID%>&pageName=newReceiveList&who=<%=who %>">30</a> 条 共<%=count %>条
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
</div>
</form>
</body>
</html>

<script language="javascript">
function docRecDispose(docId,controlId,statetype) {
if (statetype==1)
	window.location.href="<%=path%>/docRecLeader.do?method=input&controlId="+controlId;
else if(statetype==2)
	window.location.href="<%=path%>/docRecMainDept.do?method=input&controlId="+controlId;
else if(statetype==3)
	window.location.href="<%=path%>/docrecwritedeal.do?method=input&controlId="+controlId;
else if(statetype==4)
	window.location.href="<%=path%>/docRecPerson.do?method=input&controlId="+controlId;
else if(statetype==5)
	window.location.href="<%=path%>/docRecReadonly.do?method=input&controlId="+controlId;
else if(statetype==6)
	window.location.href="<%=path%>/docrecBook.do?method=input&controlId="+controlId;
else 
	window.location.href="<%=path%>/docRecDispose.do?method=input&controlId="+controlId;
	
}
function secBoard(n)
{
 for(i=1;i<secTable.cells.length-2;i++)
  	secTable.cells[i].className="tabin_atabno";
 	secTable.cells[n].className="tabin_atab";
}
</script>
