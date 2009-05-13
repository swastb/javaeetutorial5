<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List treeList1 = (List)request.getAttribute("treeList");
	List treeList = null;
	Object[] system =null;
	if (treeList1!=null && !treeList1.isEmpty()) {
	treeList = treeList1.subList(1,treeList1.size());
	system = (Object[])treeList1.get(0);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title><%=system[2] %>树列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/clatree.js"></script>
	</head>
	<script type="text/javascript">

	  var tree = new WebFXTree('<%=system[2]%>','','','','','<%=system[0]%>','1');

	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  
	
	  <%
	  	for (Iterator iter = treeList.iterator(); iter.hasNext();) {
	  		Object node = iter.next();
	 
	  			Object[] obj = (Object[])node;
	  			String parentId = (String)obj[1];
	  			String enable = obj[3].toString();
	  			if (enable.equals("1")){%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			myTree.add(new WebFXCheckBoxTreeItem('<%=obj[2]%>','',false,'<%=obj[0]%>','1','',''));
	  			<%}
 }
	  %>
	  document.write(tree);
	  tree.expandAll(-1);
	</script>
	<body>
		<table>
			<tr>
				<td>				
				 <input type="button" value="提交" onclick="zuSelSub();" />
				</td>
			</tr>
		</table>
		<form name="form4tree" method="post" action="">
		</form>
	</body>



<script type="text/javascript">
function zuSelSub() {
	//得到所有选中的参与人员id
	var zuIdstr = "";
	var nodes = document.getElementsByTagName("input");
	var num=0;
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '1'){
			if(zuIdstr.length==0)
			{
				zuIdstr=zuIdstr+nodes[i].id;
			}else
			{
				zuIdstr=zuIdstr+","+nodes[i].id;
			}
		}
	}
	
		if(window.dialogArguments.document.getElementById("zuIds").value=="")
		{
			window.dialogArguments.document.getElementById("zuIds").value=zuIdstr;
		}
		else
		{
			window.dialogArguments.document.getElementById("zuIds").value=window.dialogArguments.document.getElementById("zuIds").value+","+zuIdstr;
		}
			alert("多组选择成功！");
		window.close();
}
</script>


</html>
