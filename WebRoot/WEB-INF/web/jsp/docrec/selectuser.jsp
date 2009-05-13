<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbDept" />
<jsp:directive.page import="com.baosight.mode.TbPst" />
<jsp:directive.page import="com.baosight.mode.TbUser" />
<jsp:directive.page import="com.baosight.tools.UserNodeForCheckedbox" />
<jsp:directive.page import="com.baosight.tools.DeptNodeForCheckedbox" />
<jsp:directive.page import="com.baosight.tools.PstNodeForCheckedbox" />
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	TbDept system = (TbDept) request.getAttribute("system");
	List orgList = (List) request.getAttribute("orglist");
	String roleId = (String) request.getAttribute("roleid");
	String nameText = (String)request.getParameter("nameText");
	String idText = (String)request.getParameter("idText");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>选择人员</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/xtreeforpeople.js"></script>
		<script type='text/javascript'
			src='<%=strpath%>/dwr/interface/weeksecheduleselectuser.js'></script>
		<script type='text/javascript'
			src='<%=strpath%>/dwr/interface/weeksecheduleselectdept.js'></script>
	</head>

	<script type="text/javascript">
	  //sText, sAction, sBehavior, sIcon, sOpenIcon, sNid, isDep
	  var tree = new WebFXTree('<%=system.getName()%>','javascript:xClick(\'<%=system.getId()%>\');','','','','<%=system.getId()%>','1');
	  //alert(tree);
	  tree.setBehavior('classic');
	  
	  var myTree = null;
	  var checkedboxUser = null;
	  
	  <%
	  	//int count = 0;
	  	for (Iterator iter = orgList.iterator(); iter.hasNext();) {
	  		//if (count > 10) {break;}
	  		//count++;
	  		Object node = iter.next();
	  		if (node instanceof DeptNodeForCheckedbox) {
	  			DeptNodeForCheckedbox deptCheckedbox = (DeptNodeForCheckedbox)node;
	  			TbDept dept = deptCheckedbox.getDept();
	  			String parentId = dept.getParCode();
	  			%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			<%if (deptCheckedbox.isChecked()) {
				%>myTree.add(new WebFXCheckBoxTreeItem('<%=dept.getName()%>','javascript:xClick(\'' +'<%=dept.getId()%>' +'\');',false,'<%=dept.getId()%>','1',''));	  			
	  			<%} else {
	  			%>
	  			myTree.add(new WebFXCheckBoxTreeItem('<%=dept.getName()%>','javascript:xClick(\'' +'<%=dept.getId()%>' +'\');',false,'<%=dept.getId()%>','1',''));	  			
	  			<%
	  			}%>
	  			<%
	  		} else if (node instanceof PstNodeForCheckedbox && "user".equals(request.getParameter("deptOrUser")) ) {
	  			PstNodeForCheckedbox pstCheckedbox = (PstNodeForCheckedbox)node;
	  			TbPst pst = pstCheckedbox.getPst();
	  			String parentId = pst.getDeptid();
	  			%>
	  			myTree = tree.getNodeID('<%=parentId%>');
	  			<%if (pstCheckedbox.isChecked()) {
	  			%>
				myTree.add(new WebFXCheckBoxTreeItem('<%=pst.getName()%>','javascript:pstNodeClick(\'' +'<%=pst.getId()%>' +'\');',false,'<%=pst.getId()%>','2',''));	  			
	  			<%} else {
	  			%>
	  			myTree.add(new WebFXCheckBoxTreeItem('<%=pst.getName()%>','javascript:pstNodeClick(\'' +'<%=pst.getId()%>' +'\');',false,'<%=pst.getId()%>','2',''));
	  			<%
	  			}%>
	  			<%
	  		} else if (node instanceof UserNodeForCheckedbox && "user".equals(request.getParameter("deptOrUser"))) {
	  			UserNodeForCheckedbox userCheckbox = (UserNodeForCheckedbox)node;
	  			TbUser user = userCheckbox.getUser();
	  			String parentId = user.getDeptCode();
	  			String pstId=user.getPst();
	  			if (parentId != null && !parentId.equals("") && (pstId==null||pstId.equals(""))) {
	  				%>
	  				myTree = tree.getNodeID('<%=parentId%>');
	  				<%if (userCheckbox.isChecked()) {
	  				%>
	  				myTree.add(new WebFXCheckBoxTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');',false,'<%=user.getId()%>','0',''));
	  				<%
	  				} else {
	  				%>
					myTree.add(new WebFXCheckBoxTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');',false,'<%=user.getId()%>','0',''));	  				
	  				<%
	  				}%>
	  				<%
	  			} else {
	  				parentId = user.getPst();
	  				%>
	  				myTree = tree.getNodeID('<%=parentId%>');
	  				<%if (userCheckbox.isChecked()) {
	  				%>
	  				myTree.add(new WebFXCheckBoxTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');',false,'<%=user.getId()%>','0',''));
	  				<%
	  				} else {
	  				%>
	  				myTree.add(new WebFXCheckBoxTreeItem('<%=user.getName()%>','javascript:userNodeClick(\'' +'<%=user.getId()%>' +'\');',false,'<%=user.getId()%>','0',''));
	  				<%
	  				}%>
	  				
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
		<input type="hidden" name="userids" value="">
		<input type="hidden" name="attendance" value="">
		<input type="hidden" name="deptids" value="">
		<input type="hidden" name="deptnames" value="">
		<table>
			<tr>
				<td>
				<%
					if ("presider".equals(request.getParameter("flag"))) 
					{
						if("user".equals(request.getParameter("deptOrUser")))
						{
							%>					
							<input type="button" value="提交" onclick="presidersub();" />
							<%
						}
						else
						{
							%>					
							<input type="button" value="提交" onclick="presiderdeptsub();" />
							<%
						}						
					}
					else 
					{
						if("user".equals(request.getParameter("deptOrUser")))
						{
							%>					
							<input type="button" value="提交" onclick="participantsub();" />
							<%
						}
						else
						{
							%>					
							<input type="button" value="提交" onclick="participantdeptsub();" />
							<%
						}	
					}
					%>
				
			</tr>
		</table>
		<form name="form4tree" method="post" action="">
		</form>
	</body>



	<script type="text/javascript">
function presidersub() {
	//得到所选
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var userId = "";
	var userName="";
	var count=0;
	var nodes = document.getElementsByTagName("input");
	//alert(nodes[10].value+" ,"+nodes[10].text+" ,"+nodes[10].name+" ,"+nodes[10].nodeName+" ,"+nodes[10].nodeText);
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '0'){
			
			if(userId.length==0)
			{
				userId=userId+nodes[i].id;
				count++;
			}else
			{
				userId=userId+","+nodes[i].id;
				count++;
			}
			//userId += nodes[i].id +",";
		}
	}
	if(userId=="")
	{
		alert("至少选择一个");
		return false;
	}
	document.all.userids.value=userId;

	if(count>1){
		alert("只能选择一个");
		return false;
	}
	
	window.dialogArguments.document.getElementById('<%=nameText%>').value="";
	window.dialogArguments.document.getElementById('<%=idText%>').value="";

	if(window.dialogArguments.document.getElementById('<%=idText%>').value=="")
	{
		window.dialogArguments.document.getElementById('<%=idText%>').value=window.dialogArguments.document.getElementById('<%=idText%>').value+userId;
	}
	else
	{
	
		window.dialogArguments.document.getElementById('<%=idText%>').value=window.dialogArguments.document.getElementById('<%=idText%>').value+","+userId;
	}
	
	
	document.all.attendance.value=weekSecheduleSelectUser();
	
	alert("选择成功！");
	
	if(window.dialogArguments.document.getElementById('<%=nameText%>').value=="")
	{
		window.dialogArguments.document.getElementById('<%=nameText%>').value=window.dialogArguments.document.getElementById('<%=nameText%>').value+document.all.attendance.value;
	}
	else
	{
		window.dialogArguments.document.getElementById('<%=nameText%>').value=window.dialogArguments.document.getElementById('<%=nameText%>').value+","+document.all.attendance.value;
	}
	
	window.close();
}

function presiderdeptsub() {
	//得到所有选中的主持部门id
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var deptId = "";
	var deptName="";
	var nodes = document.getElementsByTagName("input");
	var count=0;
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '1'){
			
			if(deptId.length==0)
			{
				deptId=deptId+nodes[i].id;
				count++;
			}else
			{
				deptId=deptId+","+nodes[i].id;
				count++;
			}
		}
	}
	
	document.all.deptids.value=deptId;
	if(count>2){
		alert("只能选择一个部门");
		return false;
	}
	window.dialogArguments.document.getElementById("presidername").value="";
	window.dialogArguments.document.getElementById("presider").value="";
	window.dialogArguments.document.getElementById("presideDept").value="";	
	
	if(window.dialogArguments.document.getElementById("presideDept").value=="")
	{
		window.dialogArguments.document.getElementById("presideDept").value=window.dialogArguments.document.getElementById("presideDept").value+deptId;
	}
	else
	{
		window.dialogArguments.document.getElementById("presideDept").value=window.dialogArguments.document.getElementById("presideDept").value+","+deptId;
	}
	
	
	document.all.deptnames.value=weekSecheduleSelectDept();
	
	alert("部门选择成功！");
	//alert(document.all.deptnames.value);
	//window.dialogArguments.document.getElementById("attendance").value="";
	//window.dialogArguments.document.getElementById("attendance").value=document.all.attendance.value;
	
	window.dialogArguments.document.getElementById("presidername").value=window.dialogArguments.document.getElementById("presidername").value+"  ["+document.all.deptnames.value+"] ";
	
	window.close();
	
}


function participantsub() {
	//得到所有选中的参与人员id
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var userId = "";
	var userName="";
	var nodes = document.getElementsByTagName("input");
	//alert(nodes[10].value+" ,"+nodes[10].text+" ,"+nodes[10].name+" ,"+nodes[10].nodeName+" ,"+nodes[10].nodeText);
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '0'){
				var pvalue=window.dialogArguments.document.getElementById('<%=idText%>').value;
				if(pvalue.length==0)
				{
						if(userId.length==0)
						{
							userId=userId+nodes[i].id;
						}
						else
						{
							userId=userId+","+nodes[i].id;
						}
				}
				if(pvalue.length==32)
				{
					if(nodes[i].id!=pvalue)
					{
						if(userId.length==0)
						{
							userId=userId+nodes[i].id;
						}
						else
						{
							userId=userId+","+nodes[i].id;
						}					
					}
				}
				if(pvalue.length>32)
				{
					var pvalues=pvalue.split(",");
					var flag=1;
					for(var j=0;j<pvalues.length;j++)
					{
						if(nodes[i].id==pvalues[j])
						{
							flag=0;
						}
					}
					if(flag==1)
					{
						if(userId.length==0)
						{
							userId=userId+nodes[i].id;
						}
						else
						{
							userId=userId+","+nodes[i].id;
						}
					}
					
				}			
			//userId += nodes[i].id +",";
		}
	}
	
	if(userId=="")
	{
		alert("至少选择一个参与人,或选择人员已经存在!");
		return false;
	}
	document.all.userids.value=userId;
	
	if(window.dialogArguments.document.getElementById('<%=idText%>').value=="")
	{
		window.dialogArguments.document.getElementById('<%=idText%>').value=window.dialogArguments.document.getElementById('<%=idText%>').value+userId;
	}
	else
	{
		window.dialogArguments.document.getElementById('<%=idText%>').value=window.dialogArguments.document.getElementById('<%=idText%>').value+","+userId;	
	}
	document.all.attendance.value=weekSecheduleSelectUser();
	
	alert("参加人员选择成功！");
	
	if(window.dialogArguments.document.getElementById('<%=nameText%>').value=="")
	{
		window.dialogArguments.document.getElementById('<%=nameText%>').value=window.dialogArguments.document.getElementById('<%=nameText%>').value+document.all.attendance.value;
	}
	else
	{
		window.dialogArguments.document.getElementById('<%=nameText%>').value=window.dialogArguments.document.getElementById('<%=nameText%>').value+","+document.all.attendance.value;
	}
	
	window.close();
	
}

function participantdeptsub() {
	//得到所有选中的参与部门id
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var deptId = "";
	var deptName="";
	var nodes = document.getElementsByTagName("input");

	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '1'&& nodes[i].isNode == '0'){
			if(deptId.length==0)
			{
				deptId=deptId+nodes[i].id;
			}else
			{
				deptId=deptId+","+nodes[i].id;
			}
		}
	}
	aletr(deptId);
	document.all.deptids.value=deptId;
	//alert(document.all.deptids.value);
	//window.dialogArguments.document.getElementById("userids").value="";
	//if(document.all.action.value=='modify'&& window.dialogArguments.document.getElementById("userids").value=="")
	//{
		//window.dialogArguments.document.getElementById("deptids").value="";
		//window.dialogArguments.document.getElementById("attendance").value="";
	//}
	if(window.dialogArguments.document.getElementById("participantDept").value=="")
	{
		window.dialogArguments.document.getElementById("participantDept").value=window.dialogArguments.document.getElementById("participantDept").value+deptId;
	}
	else
	{
		window.dialogArguments.document.getElementById("participantDept").value=window.dialogArguments.document.getElementById("participantDept").value+","+deptId;
	}
	
	
	document.all.deptnames.value=weekSecheduleSelectDept();
	
	alert("部门选择成功！");
	//alert(document.all.deptnames.value);
	//window.dialogArguments.document.getElementById("attendance").value="";
	//window.dialogArguments.document.getElementById("attendance").value=document.all.attendance.value;
	
	window.dialogArguments.document.getElementById("participantname").value=window.dialogArguments.document.getElementById("participantname").value+"  ["+document.all.deptnames.value+"] ";
	
	window.close();
	
}


function getUserId(node) {
	if (node.childNodes.length > 0) {
		return getUserId(node);
	} else {
		if (node.getChecked == 'checked') {
			return node.id;
		}
	}
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

function xClick(p_url){
	//alert(p_url);
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
