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

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/xtree.js"></script>
	</head>
	<script type="text/javascript">
	  //sText, sAction, sBehavior, sIcon, sOpenIcon, sNid, isDep
	  var tree = new WebFXTree('<%=system.getName()%>','javascript:xClick(\'<%=system.getId()%>\');','','','','<%=system.getId()%>','1');
	  //alert(tree);
	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  
	  //sText, sAction,sNid, isDep, sIcon, sOpenIcon, eParent
	  //
	  //sNid:节点的id
	  //isDep:节点的icon标记，
	  //当为1时：
	  //this.icon = webFXTreeConfig.folderIcon; 
	  //this.openIcon = webFXTreeConfig.openFolderIcon;
	  //当为2时：
	  //this.icon = webFXTreeConfig.dutyIcon;
	  //this.openIcon = webFXTreeConfig.openDutyIcon;
	  //当为其他值时：
	  //this.icon = webFXTreeConfig.fileIcon;
	  //this.openIcon = webFXTreeConfig.fileIcon;           
	  //var danwei = new WebFXTreeItem('单位','javascript:xClick(\'D1\');','D1','1');
	  //tree.add(danwei);
	  //var bumen = new WebFXTreeItem('部门','javascript:xClick(\'D2\');','D2','1');
	  //danwei.add(bumen);
	  //var zhiwu = new WebFXTreeItem('职务','javascript:xClick(\'D3\');','D3','2')
	  //bumen.add(zhiwu)
	  //var ren = new WebFXTreeItem('人员','javascript:xClick(\'D4\');','D4','3');
	  //zhiwu.add(ren);
	  //var ren2 = new WebFXTreeItem('人员2','javascript:xClick(\'D5\');','D5','3');
	  //ren.add(ren2);
	  
	  
	  <%
	  	for (Iterator iter = orgList.iterator(); iter.hasNext();) {
	  		Object node = iter.next();
	  		if (node instanceof TbDept) {
	  			TbDept dept = (TbDept)node;
	  			String parentId = dept.getParCode();
	  			%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			myTree.add(new WebFXTreeItem('<%=dept.getName()%>','javascript:xClick(\'' +'<%=dept.getId()%>' +'\');','<%=dept.getId()%>','1','1'));
	  			<%
	  		} else if (node instanceof TbPst) {
	  			TbPst pst = (TbPst)node;
	  			String parentId = pst.getDeptid();
	  			%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			myTree.add(new WebFXTreeItem('<%=pst.getName()%>','javascript:pstNodeClick(\'' +'<%=pst.getId()%>' +'\');','<%=pst.getId()%>','2','2'));
	  			<%
	  		} else {
	  			TbUser user = (TbUser)node;
	  			String parentId = user.getDeptCode();
	  			String pstId=user.getPst();
	  			if ((parentId != null && !parentId.equals("")) && (pstId==null||pstId.equals(""))) {
	  				%>
	  				myTree = tree.getNodeID('<%=parentId%>');
	  				myTree.add(new WebFXTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');','<%=user.getId()%>','0','0'));
	  				<%
	  			} else {
	  				parentId = user.getPst();
	  				%>
	  				myTree = tree.getNodeID('<%=parentId%>');
	  				myTree.add(new WebFXTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');','<%=user.getId()%>','0','0'));
	  				<%
	  			}
	  			%>
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

function xClick(p_url){
	//alert(p_url);
	if(p_url==""){return ;}
	document.form4tree.target="detail";
	document.form4tree.action="<%=path%>/orgrightdetailaction.do?method=list&nodetype=deptnode&nodeid="+p_url;
	document.form4tree.submit();
//	this.parent.main.location.href="Detail.jsp?ID="+p_url;
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
