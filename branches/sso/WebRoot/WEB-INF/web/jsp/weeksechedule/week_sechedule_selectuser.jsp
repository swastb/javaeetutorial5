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
	String action=(String)request.getAttribute("action");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>ѡ����Ա/ѡ����</title>

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
	  
	  //sText, sAction,sNid, isDep, sIcon, sOpenIcon, eParent
	  //
	  //sNid:�ڵ��id
	  //isDep:�ڵ��icon��ǣ�
	  //��Ϊ1ʱ��
	  //this.icon = webFXTreeConfig.folderIcon; 
	  //this.openIcon = webFXTreeConfig.openFolderIcon;
	  //��Ϊ2ʱ��
	  //this.icon = webFXTreeConfig.dutyIcon;
	  //this.openIcon = webFXTreeConfig.openDutyIcon;
	  //��Ϊ����ֵʱ��
	  //this.icon = webFXTreeConfig.fileIcon;
	  //this.openIcon = webFXTreeConfig.fileIcon;           
	  //var danwei = new WebFXTreeItem('��λ','javascript:xClick(\'D1\');','D1','1');
	  //tree.add(danwei);
	  //var bumen = new WebFXTreeItem('����','javascript:xClick(\'D2\');','D2','1');
	  //danwei.add(bumen);
	  //var zhiwu = new WebFXTreeItem('ְ��','javascript:xClick(\'D3\');','D3','2')
	  //bumen.add(zhiwu)
	  //var ren = new WebFXTreeItem('��Ա','javascript:xClick(\'D4\');','D4','3');
	  //zhiwu.add(ren);
	  //var ren2 = new WebFXTreeItem('��Ա2','javascript:xClick(\'D5\');','D5','3');
	  //ren.add(ren2);
	  
	  
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
	  		} else if (node instanceof PstNodeForCheckedbox && "user".equals(request.getParameter("deptOrUser"))) {
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
		<input type="hidden" name="action" value="<%=action %>">
		<table>
			<tr>
				<td>
					<%
					if ("user".equals(request.getParameter("deptOrUser"))) {
					%>
					<input type="button" value="�ύ" onclick="usersub();" />
					<%
					} else {
					%>
					<input type="button" value="�ύ" onclick="deptsub();" />
					<%
					}
					%>
				
			</tr>
		</table>
		<form name="form4tree" method="post" action="">
		</form>
	</body>



	<script type="text/javascript">
function deptsub() {
	//�õ�����ѡ�еĲ���id
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var deptId = "";
	var deptName="";
	var nodes = document.getElementsByTagName("input");

	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '1'){
			
			if(deptId.length==0)
			{
				deptId=deptId+nodes[i].id;
			}else
			{
				deptId=deptId+","+nodes[i].id;
			}
		}
	}
	
	document.all.deptids.value=deptId;
	//alert(document.all.deptids.value);
	//window.dialogArguments.document.getElementById("userids").value="";
	if(document.all.action.value=='modify'&& window.dialogArguments.document.getElementById("userids").value=="")
	{
		window.dialogArguments.document.getElementById("deptids").value="";
		window.dialogArguments.document.getElementById("attendance").value="";
	}
	if(window.dialogArguments.document.getElementById("deptids").value=="")
	{
		window.dialogArguments.document.getElementById("deptids").value=window.dialogArguments.document.getElementById("deptids").value+deptId;
	}
	else
	{
		window.dialogArguments.document.getElementById("deptids").value=window.dialogArguments.document.getElementById("deptids").value+","+deptId;
	}
	
	
	document.all.deptnames.value=weekSecheduleSelectDept();
	//alert("bumen===="+document.all.deptnames.value);
	
	alert("����ѡ��ɹ���");
	//alert(document.all.deptnames.value);
	//window.dialogArguments.document.getElementById("attendance").value="";
	//window.dialogArguments.document.getElementById("attendance").value=document.all.attendance.value;
	
	window.dialogArguments.document.getElementById("attendance").value=window.dialogArguments.document.getElementById("attendance").value+"  ["+document.all.deptnames.value+"] ";
	//alert("bumen==fff=="+window.dialogArguments.document.getElementById("attendance").value);
	window.close();
	
}


function usersub() {
	//�õ�����ѡ�е���Աid
	var uidHidden = document.createElement("<input type=\"hidden\" name=\"userid\" />");
	var roleId = document.createElement("<input type=\"hidden\" name=\"role\" />");
	var userId = "";
	var userName="";
	var nodes = document.getElementsByTagName("input");
	//alert(nodes[10].value+" ,"+nodes[10].text+" ,"+nodes[10].name+" ,"+nodes[10].nodeName+" ,"+nodes[10].nodeText);
	for (var i = 0; i < nodes.length; i++) {
		var check = nodes[i];
		if(typeof(nodes[i]) != "undefined" && nodes[i].id!="" && nodes[i].checked==true && nodes[i].isDpm == '0'){
			
			var pvalue=window.dialogArguments.document.getElementById("userids").value;
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
		alert("����ѡ��һ��������,��ѡ����Ա�Ѿ�����!");
		return false;
	}
	
	document.all.userids.value=userId;
	//alert(document.all.userids.value);
	//	window.dialogArguments.document.getElementById("userids").value="";
	//window.dialogArguments.document.getElementById("userids").value=userId;
	
	if(document.all.action.value=='modify' && window.dialogArguments.document.getElementById("deptids").value=="")
	{
		window.dialogArguments.document.getElementById("userids").value="";
		window.dialogArguments.document.getElementById("attendance").value="";
	}
	
	if(window.dialogArguments.document.getElementById("userids").value=="")
	{
		window.dialogArguments.document.getElementById("userids").value=window.dialogArguments.document.getElementById("userids").value+userId;
	}
	else
	{
		window.dialogArguments.document.getElementById("userids").value=window.dialogArguments.document.getElementById("userids").value+","+userId;
	}
	
	document.all.attendance.value=weekSecheduleSelectUser();
	
	//alert(document.all.attendance.value);
	alert("��Աѡ��ɹ���");
	//window.dialogArguments.document.getElementById("attendance").value="";
	//window.dialogArguments.document.getElementById("attendance").value=document.all.attendance.value;
	
	window.dialogArguments.document.getElementById("attendance").value=window.dialogArguments.document.getElementById("attendance").value+"  <"+document.all.attendance.value+"> ";
	
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
			alert("�ò��Ű�������Ա�����Ӳ��ţ�����ɾ��������ɾ����Ա���Ӳ��ţ�");
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
			alert("��ְ���������Ա������ɾ��������ɾ����Ա��");
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
//	this.parent.main.location.href="Detail.jsp?ID="+p_url;
}

function userNodeClick(p_url){
	//alert(p_url);
//	this.parent.main.location.href="Detail.jsp?ID="+p_url;
}

function addDepart(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("��Ա���������¼����ţ�");
			return ;
		}
		if (isDpm == '2'){
			alert("ְ���������¼����ţ�");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addDepartment.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("��ѡ������Ӳ��ŵ��ϼ����ţ�");
	}
}

function addDuty(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("ֻ�в��Ų�������ְ��");
			return ;
		}
		if (isDpm == '2'){
			alert("ֻ�в��Ų�������ְ��");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addDuty.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("��ѡ�������ְ��Ĳ��ţ�");
	}
}


function addPeople(){
	if(tree.getSelected()){
		var isDpm = '';
		isDpm = isSelDpm();
		if (isDpm == '0'){
			alert("ֻ��ְ����������¼���Ա��");
			return ;
		}
		if (isDpm == '1'){
			alert("ֻ��ְ����������¼���Ա��");
			return ;
		}
		document.form4tree.target="main";
		document.form4tree.action="addPeople.jsp?ID=" + tree.getSelected().id;
		document.form4tree.submit();
	}else{
		alert("��ѡ���������Ա��ְ��");
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