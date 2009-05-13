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
<%if (treeList1!=null && !treeList1.isEmpty()) {%>
	<head>
		<base href="<%=basePath%>">
		
		<title><%=system[2] %>树列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/infotree.js"></script>
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
	  			myTree.add(new WebFXTreeItem('<%=obj[2]%>','javascript:xClick(\'' +'<%=obj[0]%>' +'\',\'' +'<%=obj[2]%>' +'\',\'' +'<%=obj[6]%>' +'\');','<%=obj[0]%>','1'));
	  			<%}
 }
	  %>
	  
	  document.write(tree);
	  tree.expandAll(-1);
	</script>
	<%} %>
	<body>
		<form name="form4tree" method="post" action=""></form>
	</body>



<script type="text/javascript">


function xClick(p_url,p_name,type){
	 window.dialogArguments.document.getElementById("commDepartListName").value = p_name;	
	 window.dialogArguments.document.getElementById("commDepartList").value = p_url;
	 window.close();	
}

function addNodes(parentid,p_name,Name,id,type) {
	if (tree.getNodeID(parentid)) {
		var h = new WebFXTreeItem(Name,'javascript:xClick(\'' +id +'\',\'' +Name +'\',\'' +type +'\');',id,'1');
		tree.getNodeID(parentid).add(h);
		return h.id;
	}
}

function changeNodeName(parentid,Name,id,type) {
	var foo;
	foo = tree.getNodeID(id);
	if (foo){

		foo.changeName (Name);
	}
}

function delNode(ID) {
	var delN ;
	delN = tree.getNodeID(ID);
	if (delN) {
		var strID ;
		strID = delN.getChildrenID();
		if (strID.indexOf("#")>0){
			alert("该栏目列表包含子栏目，不能关闭，请先关闭子栏目！");
			return -1;
		}
		delN.remove();
		return strID;
	}
}


</script>


</html>
