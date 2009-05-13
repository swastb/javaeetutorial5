<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib prefix="logic" uri="/WEB-INF/tld/struts-logic.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//List list = (List)request.getAttribute("list");
String state = (String)request.getParameter("state");
String listName = null;
String stateName = null;
String lightNum = "1";
if(state==null || "".equals(state) || "000".equals(state)){
	listName="发送中的传真";
	stateName="发送中";
	state="000";
}else if("001".equals(state)){
	listName="已发送成功的传真";
	lightNum="2";
	stateName="成功";
}else if("002".equals(state)){
	listName="发送失败的传真";
	lightNum="3";
	stateName="失败";
}

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
	<script type="text/javascript" src="<%=path%>/js/calendar-dong.js"></script>
<script language="javascript">
function deleteFax(faxId){
	window.location.href="<%=path%>/faxSchedule.do?method=delete&id="+faxId;
}
function secBoard(n){
 	document.all.secTable.cells[n].className="tabin_atab";
}
function deleteAll(){
	var obj = faxScheduleForm.faxcheck;
	var ids = document.getElementById("allId");
	if(obj){
		if(obj.length){
			ids.value="";
			for(var i=0;i<obj.length;i++){
				if(obj[i].checked){
					if(ids.value!="")ids.value+=",";
					ids.value+=obj[i].value;
				}
			}
		}else{
			if(obj.checked){
				ids.value=obj.value;
			}
		}
	}
	//alert(ids.value);
	document.getElementById("method").value="deleteAll";
	faxScheduleForm.submit();
}
function checkAll(){
	var obj = faxScheduleForm.faxcheck;
	var osrc = event.srcElement;
	if(obj){
		if(obj.length){
			for(var i=0;i<obj.length;i++){
				obj[i].checked=osrc.checked;
			}
		}else{
			obj.checked=osrc.checked;
		}
	}
}
function otherList(state){
	window.location.href="<%=path%>/faxSchedule.do?method=list&state="+state;
}
function doSearch(){
	faxScheduleForm.submit();
}
</script>
 </head>  
 <body onload="secBoard(<%=lightNum%>)">
 <html:form action="/faxSchedule">
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
                  <td align="center" valign="top">
                  <p align="left" style="padding-left: 5px">
                  <table border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                  <tr><th align="left" height="23">查询条件</th></tr>
				<tr>
				<td align="left" height="25">时间：<input type="text" name="startTime" onfocus="setday(this)" class="top_input" readonly>
				到 <input type="text" name="endTime" onfocus="setday(this)" class="top_input" readonly>
				传真号码:<input type="text" name="faxNum" class="tab_input">
				</td>
				</tr>
				<tr>
				<td align="left" height="25">
				<input type="button" class="button0" value="查询" onclick="doSearch()">
				</td>
				</tr>
				</table>
				</p>
                  <table width="99%" border="0" cellspacing="0" cellpadding="0" id="secTable">
				<tr>
				<td width="2%" height="24">&nbsp;</td>
			<td width="15%" class="tabin_atabno">
                <span onclick="otherList('000')" onmouseover="this.style.cursor='hand'">发送中的传真</span> 
			</td>
			<td width="15%" class="tabin_atabno">
                <span onclick="otherList('001')" onmouseover="this.style.cursor='hand'">已发送成功的传真</span>
			</td>
			<td width="15%" class="tabin_atabno">
                <span onclick="otherList('002')" onmouseover="this.style.cursor='hand'">发送失败的传真</span>
			</td>
			<td>&nbsp;</td>
         </tr>
	</table>
                    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                      	<tr><td colspan="9" align="left" height="23">
						<input type="checkbox" name="chooseAll" value="1" onclick="checkAll()">全部选择
						<input type="button" class="button0" value="批量删除" onclick="deleteAll()">
						</td></tr>
                      <tr>
                      	<th width="5%" height="25">&nbsp;</th>
                        <th width="20%">传真内容</th>
                        <th width="10%">发送人</th>
                        <th width="10%">发送部门</th>
                        <th width="15%">发送时间</th>
                        <th width="10%">发送状态</th>
                        <th width="10%">接收人</th>
                        <th width="15%">接收号码</th>
                        <th>操作</th>
                      </tr>
<logic:present name="list">
<logic:iterate id="item" indexId="i" name="list" type="com.baosight.fax.mode.TbFaxSchedule" length="10" offset="${10*(param.pageNum-1)}">
                      <tr>
                     	<td><input type="checkbox" name="faxcheck" value="${item.id}"/></td>
                        <td height="25"><a href="${item.content}">${item.fileName}</a></td>
                        <td>${item.sender}&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><bean:write name="item" property="senddate" format="yyyy-MM-dd HH:mm"/>&nbsp;</td>
                        <td><%=stateName%><%=item.getFaxflag()==null?"":("("+item.getFaxflag()+")")%>&nbsp;</td>
                        <td>${item.recman}&nbsp;</td>
                        <td>${item.fax}&nbsp;</td>
                        <td align="center" valign="middle">
                        <input type="button" class="button0" value="删除" onclick="deleteFax('${item.id}')">
                        </td>
                      </tr>
</logic:iterate>
</logic:present>
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
      <input type="hidden" name="method" value="list"/>
      <input type="hidden" name="allId" />
      <input type="hidden" name="state" value="<%=state%>"/>
      </html:form>
</body>
</html>

