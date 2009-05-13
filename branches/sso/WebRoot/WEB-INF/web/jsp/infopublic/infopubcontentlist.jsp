<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String parentid = request.getParameter("parentid");
	String p_name = (String) request.getParameter("p_name");
	String name = (String) request.getAttribute("name");
	String id = (String) request.getAttribute("id");
	String type = (String) request.getParameter("type");
	String infoname = (String) request.getParameter("infoname");//chaxunbaoliu

	System.out.println("type=cccc=" + type);
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
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%
		List infoConList = (List) request.getAttribute("curPageList");
		%>
		<base href="<%=basePath%>">

		<title>My JSP 'pstlvllist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<form>
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="288" height="40" align="left" valign="middle"
									background="images/8-1.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="5%" align="center" valign="middle">
												&nbsp;
											</td>
											<td width="11%" height="12" align="center" valign="middle">
												<img src="images/icon5.gif" width="7" height="7" />
											</td>
											<td width="84%" class="table2_topic">
												<%=p_name %>	信息列表
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
																	<td width="18%" class="tabin_atabno">
																		<span onclick="javascript:infoClaList();"
																			onmouseover="this.style.cursor='hand'">栏目管理</span>
																	</td>
																	<td width="18%" class="tabin_atab">
																		<span onclick="javascript:infoConList();"
																			onmouseover="this.style.cursor='hand'"> 信息管理 </span>
																	</td>
																	<td colspan="5"></td>
																</tr>
															</table>
															<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td align="left" valign="bottom" width="10%"
																		colspan="2" height="25">
																		标题：&nbsp;
																		<input type="text" name="infoname" maxlength="100"
																			value="<%=infoname == null ? "" : infoname%>"   class="shuruk1"/>
																			<input name="Submit2" type="button" class="button0" value="&nbsp;查 询&nbsp;" onclick="selectByName();"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																
																	</td>
																	<td align="right">
																		<select name="addType" class="bot_select">
																			<option value="xw">新闻</option>
																			<option value="swqk">水务情况</option>
																			<option value="zywg">重要文稿</option>
																			<option value="fg">法规</option>
																			<option value="zhb">招标</option>
																			<option value="zhp">照片</option>
																			<option value="yp">影片</option>
																			<option value="shy">声音</option>
																			<option value="hdp">幻灯片</option>
																		</select> 
																	</td><td align="center" colspan="2">
																		<input name="Submit2" type="button" class="button0" value="新 增" onclick="javascript:add();" onmouseover="this.style.cursor='hand'"/>
																	</td>
																</tr>
																<tr align="center">
																	<th width="10%" align="center" height="25">
																		序号
																	</th>
																	<th align="center" width="35%">
																		标题
																	</th>
																	<th align="center" width="35%">
																		发布日期
																	</th>
																	<th align="center" width="20%" colspan="2">
																		操作
																	</th>
																</tr>
																<%
																		for (int i = 0; i < infoConList.size(); i++) {
																		TbInfoPubContent item = (TbInfoPubContent) infoConList.get(i);
																%>
																<tr align="center">
																	<td width="10%" height="25" align="center">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="35%">
																		<%=item.getTitle()%>
																	</td>
																	<td align="center" width="35%">
																		<%=sdf.format(item.getPublishTime())%>
																	</td>
																	<td align="center" width="10%">
																		<a
																			href="javascript:modify('<%=item.getAttr2()%>','<%=item.getInfoSubject()%>','<%=item.getId()%>','<%=item.getAddType() %>')"><img
																				src="images/icon9.gif" width="15" height="15"
																				border="0" />
																		</a>
																	</td>
																	<td align="center" width="10%">
																		<a
																			href="javascript:del('<%=item.getAttr2()%>','<%=item.getInfoSubject()%>','<%=item.getId()%>');"><img
																				src="images/icon6.gif" width="15" height="15"
																				border="0" />
																		</a>
																	</td>
																</tr>
																<%
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
																			href="<%=path%>/infopubContentaction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">上一页</span>
																		</a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">下一页</span>
																		</a>
																		<span class="bg-zw">第<%=curPage + 1%>页</span>
																		<span class="bg-zw">每页显示</span>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">10</span>
																		</a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">20</span>
																		</a>
																		<a
																			href="<%=path%>/infopubContentaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">30</span>
																		</a>
																		<span class="bg-zw">条</span>
																		<span class="bg-zw">共<%=count %>条</span>
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
	</body>
</html>

<script language="javascript">
function infoClaList()
{
	window.location.href="<%=path%>/infopubclaaction.do?method=clalist&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}

function infoConList()
{
	window.location.href="<%=path%>/infopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}

function selectByName()
			{

				var infoname=document.getElementById("infoname").value;
            	window.location.href="<%=path%>/infopubContentaction.do?method=list&type=<%=type%>&infoname="+infoname+"&parentid=<%=parentid%>&p_name=<%=p_name%>";
			}
function add() {
		var addType = document.getElementById("addType").value;
		document.getElementById("rightcode").value="212";
		startRequest();
		if (document.getElementById("result").value=="true"){alert("你没有添加操作权限！");}
		else
		location.href="<%=path%>/infopubContentaction.do?method=add&action=add&p_name=<%=p_name%>&parentid=<%=parentid%>&type=<%=type%>&addType="+addType;
		
	}
	function modify(pname,parentId,id,addType) {
		document.getElementById("rightcode").value="213";
		startRequest();
		if (document.getElementById("result").value=="true") {alert("你没有修改操作权限！");}
		else
		window.location.href="<%=path%>/infopubContentaction.do?method=modify&p_name="+pname+"&parentid="+parentId+"&id="+id+"&addType="+addType;
		
	}
function del(pname,parentId,id) {
			document.getElementById("rightcode").value="214";
			startRequest();
			if (document.getElementById("result").value=="true"){alert("你没有此操作权限！");}
			else {
			if(confirm('是否确认删除')) 
			window.location.href="<%=path%>/infopubContentaction.do?method=delete&p_name="+pname+"&parentid="+parentId+"&id="+id;
		}
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
