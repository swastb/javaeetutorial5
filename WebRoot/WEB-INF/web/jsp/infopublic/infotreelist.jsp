<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubCla"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//TbInfoPubCla system = (TbInfoPubCla)request.getAttribute("system");
	List claList1 = (List)request.getAttribute("claList");
	List claList = null;
	Object[] system =null;
	if (claList1!=null && !claList1.isEmpty()) {
	claList = claList1.subList(1,claList1.size());
	system = (Object[])claList1.get(0);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%if (claList1!=null && !claList1.isEmpty()) {%>
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

	  var tree = new WebFXTree('<%=system[2]%>','','','','','<%=system[1]%>','1');

	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  
	
	  <%
	  	for (Iterator iter = claList.iterator(); iter.hasNext();) {
	  		Object node = iter.next();
	 
	  			Object[] infoCla = (Object[])node;
	  			String parentId = (String)infoCla[4];
	  			//int enable = 1;
	  			String enable = infoCla[8].toString();
	  			if (enable.equals("1")){%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			myTree.add(new WebFXTreeItem('<%=infoCla[2]%>','javascript:xClick(\'' +'<%=infoCla[1]%>' +'\',\'' +'<%=infoCla[2]%>' +'\',\'' +'<%=infoCla[10]%>' +'\');','<%=infoCla[1]%>','1'));
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
	//alert(p_url);
	if(p_url==""){return ;}
	document.form4tree.target="detail";
	if (type=="root")
		document.form4tree.action="<%=path%>/infopubclaaction.do?method=clalist&parentid="+p_url+"&p_name="+p_name+"&type="+type;
	else if(type!="govinfopub")
		document.form4tree.action="<%=path%>/infopubContentaction.do?method=list&parentid="+p_url+"&p_name="+p_name+"&type="+type;
	else
		document.form4tree.action="<%=path%>/govinfopubContentaction.do?method=list&parentid="+p_url+"&p_name="+p_name+"&type="+type;
	document.form4tree.submit();
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
