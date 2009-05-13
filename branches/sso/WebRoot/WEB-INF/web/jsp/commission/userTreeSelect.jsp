<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbDept"/>
<jsp:directive.page import="com.baosight.mode.TbUser"/>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	TbDept root = (TbDept)request.getAttribute("root");
	List userTree = (List)request.getAttribute("userTree");

	String action=(String)request.getAttribute("action");
	String nameText = (String)request.getParameter("nameText");
	String idText = (String)request.getParameter("idText");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><%=root.getName() %>人员树</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/clatree.js"></script>
		<script type='text/javascript'
			src='<%=strpath%>/dwr/interface/weeksecheduleselectuser.js'></script>
	</head>
	<script type="text/javascript">

	  var tree = new WebFXTree('<%=root.getName()%>','','','','','<%=root.getId()%>','1');

	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  
	  <%
	  	for (Iterator iter = userTree.iterator(); iter.hasNext();) {
	  		
	  			Object node = iter.next();
	  			TbUser user = (TbUser)node;
	  			String parentId = (String)user.getDeptCode();
	  				%>
	  				myTree = tree.getNodeID('<%=parentId%>');
	  				myTree.add(new WebFXCheckBoxTreeItem('<%=user.getName()%>','',false,'<%=user.getId()%>','1','',''));
	  				<%
	  			}%>
	  document.write(tree);
	  tree.expandAll(-1);
	</script>
	
	<body>

		<input type="hidden" name="userids" value="">
		<input type="hidden" name="attendance" value="">
		<input type="hidden" name="action" value="<%=action %>">
		<table>
			<tr>
				<td>				
				 <input type="button" value="提交" onclick="claSelSub();" />
				</td>
			</tr>
		</table>
		<form name="form4tree" method="post" action="">
		</form>
	</body>


<script type="text/javascript">
function claSelSub() {
	//得到所有选中的参与人员id
	var userId = "";
	var nodes = document.getElementsByTagName("input");
	var num=0;
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '1'){
			if(userId.length==0)
			{
				userId=userId+nodes[i].id;
				num++;
			}else
			{
				userId=userId+","+nodes[i].id;
				num++;
			}
		}
	}
	
	if(userId=="")
	{
		alert("至少选择一个");
		return false;
	}
	document.all.userids.value=userId;
	if (num>1){
		alert("人员选择不能够多于一个！");
		return false;
	}
	document.all.attendance.value=weekSecheduleSelectUser();
	alert("人员选择成功！");	
	window.dialogArguments.document.getElementById('<%=idText%>').value=userId
	window.dialogArguments.document.getElementById('<%=nameText%>').value=document.all.attendance.value;

	window.close();
}
</script>


</html>
