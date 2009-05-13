<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/tld/struts-logic.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>选择人员</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link type="text/css" rel="stylesheet" href="<%=path%>/css/xtree.css">
		<script src="<%=path%>/javascript/webFXTree.js"></script>
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
	</head>
<logic:present name="root">	
<script type="text/javascript">
	//sText, sAction, sBehavior, sIcon, sOpenIcon, sNid, isDep
	var tree = new WebFXTree('${root.name}','','','','','${root.id}','1');
	//alert(tree);
	tree.setBehavior('classic');

	var myTree = null;
	<logic:iterate id="item" indexId="i" name="deptList" type="com.baosight.mode.TbDept" >
	myTree = tree.getNodeID("${item.parCode}");
	myTree.add(new WebFXCheckBoxTreeItem('${item.name}','',false,'${item.id}','1',''));
	</logic:iterate>
	<logic:iterate id="item" indexId="i" name="userList" type="com.baosight.mode.TbUser" >
	myTree = tree.getNodeID("${item.deptCode}");
	myTree.add(new WebFXCheckBoxTreeItem('${item.name}','',false,'${item.id}','1',''));
	</logic:iterate>
	document.write(tree);
	tree.expandAll(-1);
</script>
</logic:present>
	<body>
		<table>
			<tr>
				<td>			
					<input type="button" value="提交" onclick="submitTree()" class="button0"/>
					<input type="button" value="取消" onclick="cancelTree()" class="button0"/>
				</td>
			</tr>
		</table>
		<form name="form4tree" method="post" action="">
		</form>
	</body>

<script type="text/javascript">
var chooseIds;
var chooseNames;
function submitTree(){
	chooseIds="";
	chooseNames="";
	var root = tree.getNodeID("${root.id}");
	bleveryNode(root);
	//alert(chooseIds);
	//alert(chooseNames);
	if(chooseIds==""){
		alert("请选了人再提交！");
		return;
	}
	if("${param.flag}"=="presider" && chooseIds.split(",").length>1){
		alert("只能选择一个人！");
		return;
	}
	window.dialogArguments.document.getElementById("${param.idText}").value=chooseIds;
	window.dialogArguments.document.getElementById("${param.nameText}").value=chooseNames;
	window.close();
}
function bleveryNode(node){
	var childs = node.childNodes;
	for(var i=0;i<childs.length;i++){
		var myNode = childs[i];
		if(myNode && myNode.childNodes.length==0){
			doMyAction(myNode);
		}else{
			bleveryNode(myNode);
		}
	}
}
function doMyAction(node){
	//alert("叶子节点:"+node.id+" "+node.text);
	//alert(node.toString());
	if(document.getElementById(node.id+"-checkbox").checked){
		if(chooseIds!=""){
			chooseIds+=",";
			chooseNames+=",";
		}
		chooseIds+=node.id;
		var name = node.text;
		chooseNames+=name;
	}
}
function cancelTree(){
	window.close();
}
</script>
</html>
