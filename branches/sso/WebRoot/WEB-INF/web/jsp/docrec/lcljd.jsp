<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
List list = (List)request.getAttribute("sclzdList");
String showText = request.getParameter("showText");
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
 <body>

 <form>
 	
    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in" align="center">
       
       <tr class="bg-zwbt">
        	<td width="20%" colspan="1" align="center">文件标题</td>
        	<td width="80%" colspan="5" align="center"><%=list!=null?((Object[])list.get(0))[0]:"" %></td>
       </tr>
       <tr class="bg-zwbt">
       		<td width="5%" colspan="1" align="center"></td>
    		<td width="19%" colspan="1" align="center">步骤名</td>
    		<td width="19%" colspan="1" align="center">流入时间</td>
    		<td width="19%" height="25" align="center">签收时间</td>
    	　　 <td width="19%" height="25" align="center">流出时间</td>
    	   	<td width="19%" align="center" nowrap="nowrap">处理人</td>
    	</tr>
    	<%for (int i = 0; list!=null&&list.size()>0&&i < list.size(); i++) {
    		Object[] item = (Object[])list.get(i);
    	%>
    	<tr align="center" class="bg-zw">
    		<td width="5%" colspan="1" align="center"><input type="radio" name="docControlId" value="<%=item[6]==null?"":item[6] %>"></td>
		    <td width="19%" height="25" align="center"><%=item[1]==null?"":item[1] %></td>
    		<td width="19%" height="25" align="center"><%=item[2]==null?"":item[2] %></td>
    		<td width="19%" height="25" align="center"><%=item[3]==null?"":item[3] %></td>
    		<td width="19%" height="25" align="center"><%=item[4]==null?"":item[4] %></td>
    		<td width="19%" align="center" height="25" nowrap="nowrap"><%=item[5]==null?"":item[5] %></td>
		 </tr><%}%>
		<tr class="bg-zw">
			<td colspan="6" align="center">
				<input type="button" value="提交" onclick="submit1();" class="button0">
			</td>
		</tr>
 	 </table> 
</form>
</body>
</html>

<script language="javascript">
function delDoc(docId) {

	window.location.href="<%=path%>/docRecListAction.do?method=delRecDoc&docId="+docId;
}
function submit1() {
var controlId;
var objs = document.forms[0].docControlId;
for(i=0;i<objs.length;i++){
	if(objs[i].checked){
		controlId=objs[i].value;
		break;
	}
}
window.dialogArguments.document.getElementById("<%=showText%>").value=controlId;
window.dialogArguments.document.docRecBookForm.submit();
window.close();
}
</script>
