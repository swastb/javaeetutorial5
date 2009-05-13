<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbDept" />
<jsp:directive.page import="com.baosight.mode.TbPst" />
<jsp:directive.page import="com.baosight.mode.TbUser" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List children = (List) request.getAttribute("children");
	String parentId = (String) request.getAttribute("parentid");
	String nodeType = request.getParameter("nodetype");
	String addType = request.getParameter("addtype");
	String name = (String) request.getAttribute("name");
	String nodeId = (String) request.getAttribute("id");
	int i = 0;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'list.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		// 在左边的树中增加节点
		function addOrUpdateNode(name, nodeId, addType, action) {
			//alert("name=" + name + "nodeId=" + nodeId);
			//alert("addType=" + addType);
			if (action != 'null' && action == 'addnode') {
				if (name != 'null' && nodeId != 'null') {
					//alert("add node");
					//根据所添加节点的类型来调用对应的方法
					if ("dept" == addType) {
						//deptNode
						parent.left.addNodes(name,nodeId);
					} else if ("pst" == addType) {
						//pstNode
						parent.left.addDutyNode(name,nodeId);
					} else {
						//userNode
						parent.left.addNode(name,nodeId);
					}
				} else {
					//alert("not add node");
				}
			} else {
				if (name != 'null' && nodeId != 'null') {
					parent.left.changeNodeName(name,nodeId);
				}
			}
		}
		
		// 在左边的树中删除节点
		function delNode(parentId,nodeId) {
		window.location.href="<%=path%>/orgrightdetailaction.do?method=delete&parentid="+parentId+"&nodeid="+nodeId;
			return parent.left.delNode(nodeId);
		}
		
		function delPstNode(parentId,nodeId) {
		window.location.href="<%=path%>/orgrightdetailaction.do?method=delete&parentid="+parentId+"&nodeid="+nodeId;
			return parent.left.delDutyNode(nodeId);
		}
		
		// 在左边的树中修改节点
		//接点排序
	function upDownMove(parentId,nodeId,defOrder,nodeType,type,num){
	var nextNType="";
	if(type=="up")
		nextNType=document.getElementById(parseInt(num)-parseInt(1)).innerText;
	if(type=="down"){
		nextNType=document.getElementById(parseInt(num)+parseInt(1)).innerText;
		}
	if(trim(nextNType)=="部门")
		nextNType="dept";
	if(trim(nextNType)=="职务")
		nextNType="post";
	if(trim(nextNType)=="人员")
		nextNType="user";
	window.location.href="<%=path%>/orgrightdetailaction.do?method=upDownMove&defOrder="+defOrder+"&nodeType="+nodeType+"&pNodeType=<%=nodeType%>&parentId="+parentId+"&nextNType="+nextNType+"&nodeid="+nodeId+"&type="+type;
	}
	function trim(str) 
	{ 
		return str.replace(/(^\s*)|(\s*$)/g, ""); 
	} 
	</script>
	</head>
	<body
		onload="addOrUpdateNode('<%=name%>', '<%=nodeId%>', '<%=addType%>', '<%=((String) request.getAttribute("action"))%>');">
		<table width="100%" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="288" height="40" align="left" valign="middle"
								background="images/8-1.gif">
								<table width="288" border="0" cellspacing="0" cellpadding="0"
										height="31">
									<tr>
										<td width="5%" align="center" valign="middle">
											&nbsp;
										</td>
										<td width="11%" height="12" align="center" valign="middle">
											<img src="images/icon5.gif" width="7" height="7" />
										</td>
										<td width="84%" class="table2_topic">
											组织机构管理
										</td>
									</tr>
								</table>
							</td>
							<td background="images/8-2.gif">
								&nbsp;
							</td>
						</tr>
					</table>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#0e88b9">
						<tr>
							<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="table2bg">
									<tr>
										<td align="center" valign="top">
											<table width="98%" border="0" cellpadding="0" cellspacing="0"
												class="table2bgin">
												<tr>
													<th height="30" valign="bottom"></th>
												</tr>
												<tr>
													<td align="center" valign="top">
														<table width="99%" border="0" cellpadding="0"
															cellspacing="1" class="tabin_in">
															<tr>
																<%
																if (nodeType.equals("pstnode")) {
																%>

																<td height="25" colspan="8" valign="middle"
																	bgcolor="#e8f0f1" class="tabin_toptext">
																	<a
																		href="<%=path%>/orgrightdetailaction.do?method=add&parentnodetype=<%=nodeType%>&addtype=user&parentid=<%=parentId%>"><span
																		class="tabin_toptext">增加人员</span></a>
																</td>

																<%
																} else {
																%>
																<td height="25" colspan="8" valign="middle"
																	bgcolor="#e8f0f1" class="tabin_toptext">
																	<a
																		href="<%=path%>/orgrightdetailaction.do?method=add&addtype=dept&parentid=<%=parentId%>"><span
																		class="tabin_toptext">增加部门</span></a>
																	<a
																		href="<%=path%>/orgrightdetailaction.do?method=add&addtype=pst&parentid=<%=parentId%>"><span
																		class="tabin_toptext">增加职务</span></a>
																	<a
																		href="<%=path%>/orgrightdetailaction.do?method=add&parentnodetype=<%=nodeType%>&addtype=user&parentid=<%=parentId%>"><span
																		class="tabin_toptext">增加人员&nbsp;</span></a>
																</td>
																<%
																}
																%>
															</tr>
															<tr align="center">
																<th width="20%" height="25" align="center">
																	类型
																</th>
																<th width="40%" align="center" colspan="3">
																	名称
																</th>
																<th width="20%" align="center" colspan="4">
																	操作
																</th>
															</tr>
															<%
																	for (Iterator iter = children.iterator(); iter.hasNext();) {
																	Object item = iter.next();
																	i++;
															%>
															<tr align="center" class="bg-zw">
																<%
																if (item instanceof TbDept) {
																%>
																<td width="20%" align="center" id="<%=i%>">
																	<%="部门"%>
																</td>
																<td width="40%" align="center" colspan="3">
																	<%=((TbDept) item).getName()%>
																</td>
																<%
																if (i == 1) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon8.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbDept) item).getId()%>','<%=((TbDept) item).getDefOrder()%>','dept','up','<%=i%>')"><img
																			src="images/icon8.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<%
																if (i == children.size()) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon7.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbDept) item).getId()%>','<%=((TbDept) item).getDefOrder()%>','dept','down','<%=i%>')"><img
																			src="images/icon7.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<td width="5%" align="center">
																	<a title="编辑"
																		href="<%=path%>/deptEdit.do?method=deptEdit&parentid=<%=parentId%>&nodeid=<%=((TbDept) item).getId()%>"><img
																			src="images/icon9.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<td width="5%" align="center">
																	<a title="删除"
																		href="javascript:delNode('<%=parentId%>','<%=((TbDept) item).getId()%>')"
																		onclick="return confirm('是否确认删除')"><img
																			src="images/icon6.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<%
																} else if (item instanceof TbPst) {
																%>
																<td width="20%" align="center" id="<%=i%>">
																	<%="职务"%>
																</td>
																<td width="40%" align="center" colspan="3">
																	<%=((TbPst) item).getName()%>
																</td>
																<%
																if (i == 1) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon8.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbPst) item).getId()%>','<%=((TbPst) item).getDefOrder()%>','post','up','<%=i%>')"><img
																			src="images/icon8.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<%
																if (i == children.size()) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon7.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbPst) item).getId()%>','<%=((TbPst) item).getDefOrder()%>','post','down','<%=i%>')"><img
																			src="images/icon7.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<td width="5%" align="center">
																	<a title="编辑"
																		href="<%=path%>/postEdit.do?method=postEdit&parentid=<%=parentId%>&nodeid=<%=((TbPst) item).getId()%>"><img
																			src="images/icon9.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<td width="5%" align="center">
																	<a title="删除"
																		href="javascript:delPstNode('<%=parentId%>','<%=((TbPst) item).getId()%>')"
																		onclick="return confirm('是否确认删除')"><img
																			src="images/icon6.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<%
																} else if (item instanceof TbUser) {
																%>
																<td width="20%" align="center" id="<%=i%>">
																	<%="人员"%>
																</td>
																<td width="40%" align="center" colspan="3">
																	<%=((TbUser) item).getName()%>
																</td>
																<%
																if (i == 1) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon8.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbUser) item).getId()%>','<%=((TbUser) item).getDefOrder()%>','user','up','<%=i%>')"><img
																			src="images/icon8.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<%
																if (i == children.size()) {
																%>
																<td width="5%" align="center">
																	<img src="images/icon7.gif" width="14" height="14"
																		border="0" />
																</td>
																<%
																} else {
																%>
																<td width="5%" align="center">
																	<a
																		href="javascript:upDownMove('<%=parentId%>','<%=((TbUser) item).getId()%>','<%=((TbUser) item).getDefOrder()%>','user','down','<%=i%>')"><img
																			src="images/icon7.gif" width="14" height="14"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
																<td width="5%" align="center">
																	<a title="编辑"
																		href="<%=path%>/orgrightdetailaction.do?method=modify&parentid=<%=parentId%>&nodeid=<%=((TbUser) item).getId()%>&type=<%=nodeType%>"><img
																			src="images/icon9.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<td width="5%" align="center">
																	<a title="删除"
																		href="javascript:delNode('<%=parentId%>','<%=((TbUser) item).getId()%>')"
																		onclick="return confirm('是否确认删除')"><img
																			src="images/icon6.gif" width="15" height="15"
																			border="0" /> </a>
																</td>
																<%
																}
																%>
															</tr>
															<%
															}
															%>
														</table>
													</td>
												</tr>
												<tr>
													<td height="20"></td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>


