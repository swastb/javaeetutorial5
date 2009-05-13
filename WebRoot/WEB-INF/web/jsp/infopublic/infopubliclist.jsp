<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="GBK"%>
<jsp:directive.page
	import="com.baosight.mode.TbInfoPubCla,com.baosight.mode.TbUser" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String parentid = (String)request.getAttribute("parentid");
	String p_name = (String) request.getAttribute("p_name");
	String name = (String) request.getAttribute("name");
	String id = (String) request.getAttribute("id");
	String type = (String) request.getParameter("type");
	String claname = (String) request.getParameter("claname");

	if (parentid == null || "".equals(parentid))
		parentid = request.getParameter("parentid");
	if (p_name == null || "".equals(p_name))
		p_name = (String) request.getParameter("p_name");
	if (type == null || "".equals(type))
		type = (String) request.getParameter("type");

	System.out.println("type-publist-" + type);

	String sessionID = "";
	int curPage = 0;
	long count=0;
	try {
		sessionID = (String) request.getAttribute("sessionID");
		curPage = (Integer) session.getAttribute(sessionID + "No");
		count=(Long)session.getAttribute(sessionID+"Count");

	} catch (Exception ex) {
		ex.printStackTrace();
	}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%
		List infoClaList = (List) request.getAttribute("curPageList");
		%>
		<base href="<%=basePath%>">
		<title>栏目列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script type='text/javascript'
			src='<%=path%>/dwr/interface/iscannotdo.js'></script>
		<script type="text/javascript">
		// 在左边的树中增加节点
	function addOrUpdateNode(parentid, p_name, name, id, action,type) {
			
			if (action != 'null' && action == 'add') {
				if (name != 'null' && id != 'null') {
					
						parent.left.addNodes(parentid, p_name, name,id,type);
					
				} else {
					//alert("not add node");
				}
			} else {
				if (name != 'null' && id != 'null') {
					parent.left.changeNodeName(parentid, name,id,type);
				}
			}
		}
		
	function delNode(parentid,id) {
			document.getElementById("rightcode").value="214";
			//isCanNotdo();
			//alert("权限判断");
			//if (this.isCanNotdoFlag==true) {alert("你没有此操作权限！");}
			startRequest();
			if (document.getElementById("result").value=="true"){alert("你没有此操作权限！");}
			parent.left.delNode(id);
			window.location.href="<%=path%>/infopubclaaction.do?method=modifyC&p_name=<%=p_name%>&parentid="+parentid+"&id="+id+"&type=<%=type%>";
			
			}
	
	function selectByName()
			{
				var claname=document.getElementById("claname").value;
            	window.location.href="<%=path%>/infopubclaaction.do?method=clalist&claname="+claname+"&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
			}
	function upDownMove(parentId,nodeId,type){
		document.getElementById("rightcode").value="213";
		startRequest();
		if (document.getElementById("result").value=="true") {alert("你没有修改操作权限！");}
		else
		window.location.href="<%=path%>/infopubclaaction.do?method=upAndDownCla&parentid="+parentId+"&nodeId="+nodeId+"&move="+type+"&p_name=<%=p_name%>&type=<%=type%>";
	}
	
	function add() {
		document.getElementById("rightcode").value="212";
		startRequest();
		if (document.getElementById("result").value=="true"){alert("你没有添加操作权限！");}
		else
		window.location.href="<%=path%>/infopubclaaction.do?method=add&action=add&p_name=<%=p_name%>&parentid=<%=parentid%>&type=<%=type%>";
		
	}
	function modify(id) {
		document.getElementById("rightcode").value="213";
		startRequest();
		if (document.getElementById("result").value=="true") {alert("你没有修改操作权限！");}
		else
		window.location.href="<%=path%>/infopubclaaction.do?method=modify&id="+id+"&p_name=<%=p_name%>&parentid=<%=parentid%>&type=<%=type%>";
		
	}

var http_request;
function createXMLHttpRequest(){
	if(window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
			http_request.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) { 	
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}	
function startRequest(){
	var url = "";
	var rightcode=document.getElementById("rightcode").value;
	url = "infopubclaaction.do?method=isCanNotDo&claId=<%=parentid%>&rightcode="+rightcode;
	createXMLHttpRequest();
	http_request.onreadystatechange = handlestatechange
	http_request.open("post",url,false);
	http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	http_request.setRequestHeader("Cache-Control","no-cache"); 
	http_request.send(null);		  					  		
}
function handlestatechange(){
	if (http_request.readyState==4){
		if (http_request.status==200){
			var result = http_request.responseText;
			document.getElementById("result").value=result;	  					  												
		}
	}
}
</script>
	</head>
	<body
		onload="addOrUpdateNode('<%=parentid%>','<%=p_name%>','<%=name%>', '<%=id%>', '<%=((String) request.getAttribute("act"))%>','<%=type%>');">
		<form>
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
												<%=p_name%>
												子栏目列表
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
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="30" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="top">
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="2%" height="25">
																		&nbsp;
																	</td>
																	<td width="18%" height="25" class="tabin_atab">
																		<span onclick="javascript:infoClaList();"
																			onmouseover="this.style.cursor='hand'">栏目管理</span>
																	</td>
																	<td width="18% height=" 25" align="left"
																		class="tabin_atabno">
																		<%
																		if ("root".equals(type)) {
																		%>
																		<span onmouseover="this.style.cursor='hand'">
																			信息管理 </span>&nbsp;&nbsp;
																		<%
																		} else {
																		%>
																		<span onclick="javascript:infoConList();"
																			onmouseover="this.style.cursor='hand'"> 信息管理 </span>&nbsp;&nbsp;
																		<%
																		}
																		%>
																	</td>
																	<td colspan="5"></td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td align="left" valign="middle" bgcolor="#f7f7f7"
																		colspan="7" height="25"><span class="bg-zw">
																		栏目名称：</span>
																		<input type="text" name="claname"
																			value="<%=claname == null ? "" : claname%>"   class="shuruk1"/>
																			
																			<input name="Submit2" type="button" class="button0" value="查 询" onclick="selectByName();"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																	
																	</td>
																	<td align="center" width="5%" height="25"
																		bgcolor="#f7f7f7">
																		<%
																		if ("root".equals(type)) {
																		%>
																		<input name="Submit2" type="button" class="button0" value="新 增" 
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																		<%
																		} else {
																		%>
																		<input name="Submit2" type="button" class="button0" value="新 增" onclick="add();"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																		
																		<%
																		}
																		%>
																	</td>
																</tr>
																<tr align="center">
																	<th width="5%" height="25" align="center">
																		序号
																	</th>
																	<th align="center" width="25%">
																		子拦目名称
																	</th>
																	<th align="center" width="25%">
																		子栏目编号
																	</th>
																	<th align="center" width="25%">
																		创建时间
																	</th>
																	<th align="center" width="20%" colspan="4">
																		操作
																	</th>
																</tr>
																<%
																		for (int i = 0; i < infoClaList.size(); i++) {
																		TbInfoPubCla item = (TbInfoPubCla) infoClaList.get(i);
																		Long enable = item.getEnable();
																		if (enable == 1) {
																%>
																<tr align="center">
																	<td width="5%" height="25" align="center">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getName()%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getCode()%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getCreateTime() == null ? "" : sdf.format(item.getCreateTime())%>
																	</td>
																	<%
																	if (i == 0) {
																	%>
																	<td width="5%" align="center">
																		<img src="images/icon8.gif" width="14" height="14"
																			border="0" />
																	</td>
																	<%
																	} else {
																	%>
																	<td align="center" width="5%">
																		<a
																			href="javascript:upDownMove('<%=parentid%>','<%=item.getId()%>','up')"><img
																				src="images/icon8.gif" width="14" height="14"
																				border="0" />
																		</a>
																	</td>
																	<%
																	}
																	%>
																	<%
																	if (i == infoClaList.size()) {
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
																			href="javascript:upDownMove('<%=parentid%>','<%=item.getId()%>','down')"><img
																				src="images/icon7.gif" width="14" height="14"
																				border="0" />
																		</a>
																	</td>
																	<%
																	}
																	%>
																	<td align="center" width="5%">
																		<a href="javascript:modify('<%=item.getId()%>')"><img
																				src="images/icon9.gif" width="15" height="15"
																				border="0" />
																		</a>
																	</td>
																	<td align="center" width="5%" nowrap>
																		<a
																			href="javascript:delNode('<%=parentid%>','<%=item.getId()%>')"
																			onclick="return confirm('是否关闭此栏目');">禁用</a>
																	</td>

																</tr>
																<%
																} else {
																%>
																<tr align="center">
																	<td width="5%" height="25" align="center"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getName()%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getCode()%>
																	</td>
																	<td align="center" width="25%">
																		<%=item.getCreateTime()%>
																	</td>
																	<%
																	if (i == 0) {
																	%>
																	<td width="5%" align="center">
																		<%="up"%>
																	</td>
																	<%
																	} else {
																	%>
																	<td align="center" width="5%">
																		<a
																			href="javascript:upDownMove('<%=parentid%>','<%=item.getId()%>','up')"><img
																				src="images/icon8.gif" width="14" height="14"
																				border="0" />
																		</a>
																	</td>
																	<%
																	}
																	%>
																	<%
																	if (i == infoClaList.size()) {
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
																			href="javascript:upDownMove('<%=parentid%>','<%=item.getId()%>','down')"><img
																				src="images/icon7.gif" width="14" height="14"
																				border="0" />
																		</a>
																	</td>
																	<%
																	}
																	%>
																	<td align="center" height="25" width="5%" colspan="2"
																		nowrap="nowrap">
																		<a
																			href="<%=path%>/infopubclaaction.do?method=modifyS&id=<%=item.getId()%>&p_name=<%=p_name%>&parentid=<%=parentid%>&type=<%=type%>"
																			onclick="return confirm('是否启动此栏目');">启动</a>
																	</td>
																</tr>
																<%
																	}
																	}
																%>
															</table>
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0" align="right">
																<tr>
																	<td height="10"></td>
																</tr>
																<tr>
																	<td class="tabin_page">
																		<a
																			href="<%=path%>/infopubclaaction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">上一页</span>
																		</a>
																		<a
																			href="<%=path%>/infopubclaaction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">下一页</span>
																		</a> 第
																		<%=curPage + 1%>
																		页 每页显示
																		<a
																			href="<%=path%>/infopubclaaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">10</span>
																		</a>
																		<a
																			href="<%=path%>/infopubclaaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">20</span>
																		</a>
																		<a
																			href="<%=path%>/infopubclaaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">30</span>
																		</a> 条 共<%=count %>条
																	</td>
																</tr>
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
											<td height="8"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						</td>
						</tr>
						</table>
		</form>
		<input type="hidden" name="rightcode" value="">
		<input type="hidden" name="result" value="">
		<input type="hidden" name="parentid" value="<%=parentid%>">
		<input type="hidden" name="userId"
			value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION"))
							.getId()%>">
	</body>
</html>

<script language="javascript">
function infoClaList()
{
	window.location.href="<%=path%>/infopubclaaction.do?method=clalist&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}

function infoConList()
{
	if ("<%=type%>"!="govinfopub")
		window.location.href="<%=path%>/infopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
	else
		window.location.href="<%=path%>/govinfopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}
</script>
