<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbDept"/>
<jsp:directive.page import="com.baosight.mode.TbPst"/>
<jsp:directive.page import="com.baosight.mode.TbUser"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	TbDept system = (TbDept)request.getAttribute("system");
	List orgList = (List)request.getAttribute("orglist");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>部门列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css"/>
		<script src="<%=path%>/javascript/xtree.js"></script>
	</head>
	<script type="text/javascript">
	  //sText, sAction, sBehavior, sIcon, sOpenIcon, sNid, isDep
	  var tree = new WebFXTree('<%=system.getName()%>','javascript:xClick(\'<%=system.getId()%>\',\'<%=system.getName()%>\');','','','','<%=system.getId()%>','1');
	  //alert(tree);
	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  <%
	  	for (Iterator iter = orgList.iterator(); iter.hasNext();) {
	  		Object node = iter.next();
	  		if (node instanceof TbDept) {
	  			TbDept dept = (TbDept)node;
	  			String parentId = dept.getParCode();
	  			%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			myTree.add(new WebFXTreeItem('<%=dept.getName()%>','javascript:xClick(\'' +'<%=dept.getId()%>' +'\',\'<%=dept.getName()%>\');','<%=dept.getId()%>','1'));
	  			<%
	  		}
	  %>
	  <%
	  	}
	  %>
	  
	  
	  document.write(tree);
	  tree.expandAll(-1);
	</script>
	<body>
		<form name="form4tree" method="post" action=""></form>
	</body>



<script type="text/javascript">

// Ajax 
        var xmlHttp;
		function getXMLHTTPObj(){
			var xmlHttp = null;
			if (window.ActiveXObject) {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			}else if(window.XMLHttpRequest){
				xmlHttp = new XMLHttpRequest();
			}else{
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
			return xmlHttp;
		}
		function logoutForums(deptId) {
			try{
				xmlHttp = getXMLHTTPObj();
				if( xmlHttp ){
					var url = "<%=path%>/orgrightdetailaction.do?method =resultUser?deptId="+deptId;
					xmlHttp.open("post", url, true);
					xmlHttp.onreadystatechange = resultOut;
					xmlHttp.send(null);
				}
			}catch(e){
			}
		}
		
		function logout(){
				logoutForums();
				var path = document.getElementById("path").value;
				var loginType = document.getElementById("loginType").value;
				var url = path+"/loginoutAction.do?loginType="+loginType;
				window.open(url,"_self");
		}





function xClick(id,name){
    if(id=="")return;
	window.dialogArguments.document.getElementById("method").value = "resultUser";
	window.dialogArguments.document.getElementById("departid").value =id;	
	window.dialogArguments.document.getElementById("deptName").value =name;	
	window.dialogArguments.document.getElementById("queryStatisticsForm").submit();	
	window.close();
}
 

function  addNode(Name,iID) {
	if (tree.getSelected()) {
		var h = new WebFXTreeItem(Name,'javascript:userNodeClick(\'' +iID +'\');',iID,'0');
		tree.getSelected().add(h);
		return h.id;
	}
}

function addDutyNode(Name,iID) {
	if (tree.getSelected()) {
		var h = new WebFXTreeItem(Name,'javascript:pstNodeClick(\'' +iID +'\');',iID,'2');
		tree.getSelected().add(h);
		return h.id;
	}
}

function addNodes(Name,iID) {
	if (tree.getSelected()) {
		var h = new WebFXTreeItem(Name,'javascript:xClick(\'' +iID +'\');',iID,'1');
		tree.getSelected().add(h);
		return h.id;
	}
}

function changeNodeName(Name,iID) {
	var foo;
	foo = tree.getNodeID(iID);
	if (foo){

		foo.changeName (Name);
	}
}


function isHasChild(){
	if (tree.getSelected()) {
		var strID ;
		strID = tree.getSelected().getChildrenID();
		if (strID.indexOf("#")>0) return 0;
		return 1;
	}
}
function delNode(ID) {
	var delN ;
	delN = tree.getNodeID(ID);
	if (delN) {
		var strID ;
		strID = delN.getChildrenID();
		if (strID.indexOf("#")>0){
			alert("该部门包含有人员或者子部门，不能删除，请先删除人员和子部门！");
			return -1;
		}
		delN.remove();
		return strID;
	}
}
function delDutyNode(ID) {
	var delN ;
	delN = tree.getNodeID(ID);
	if (delN) {
		var strID ;
		strID = delN.getChildrenID();
		if (strID.indexOf("#")>0){
			alert("该职务包含有人员，不能删除，请先删除人员！");
			return -1;
		}
		delN.remove();
		return strID;
	}
}

function pstNodeClick(p_url){
	//alert(p_url);
	if(p_url==""){return ;}
	document.form4tree.target="detail";
	document.form4tree.action="<%=path%>/orgrightdetailaction.do?method=list&nodetype=pstnode&nodeid="+p_url;
	document.form4tree.submit();
//	this.parent.main.location.href="Detail.jsp?ID="+p_url;
}

function userNodeClick(p_url){
	//alert(p_url);
	if(p_url==""){return ;}
	document.form4tree.target="detail";
	document.form4tree.action="<%=path%>/orgrightdetailaction.do?method=list&nodetype=usernode&nodeid="+p_url;
	document.form4tree.submit();
//	this.parent.main.location.href="Detail.jsp?ID="+p_url;
}

function addDepart(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("人员不能增加下级部门！");
			return ;
		}
		if (isDpm == '2'){
			alert("职务不能增加下级部门！");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addDepartment.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("请选择待增加部门的上级部门！");
	}
}

function addDuty(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("只有部门才能增加职务！");
			return ;
		}
		if (isDpm == '2'){
			alert("只有部门才能增加职务！");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addDuty.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("请选择待增加职务的部门！");
	}
}


function addPeople(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("只有职务才能增加下级人员！");
			return ;
		}
		if (isDpm == '1'){
			alert("只有职务才能增加下级人员！");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addPeople.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("请选择待增加人员的职务！");
	}
}

function  showNode() {
	if (tree.getSelected()) {
		return tree.getSelected().id;
	}
}

function  isSelDpm() {
	if (tree.getSelected()) {
		return tree.getSelected().isDpm;
	}
}

function  showtree(ndid) {
	var f;
	f = tree.getNodeID(ndid);
	if (f){
		return f;
	}
}

</script>


</html>
