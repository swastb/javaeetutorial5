<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbGovInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	String parentid = request.getParameter("parentid");
	String p_name = (String) request.getParameter("p_name");
	String type = (String) request.getParameter("type");
	String infoname = (String) request.getParameter("infoname");//chaxunbaoliu
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
		List govInfoConList = (List) request.getAttribute("curPageList");
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
												������Ϣ�����б�
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
																			onmouseover="this.style.cursor='hand'">��Ŀ����</span>
																	</td>
																	<td width="18%" class="tabin_atab">
																		<span onclick="javascript:infoConList();"
																			onmouseover="this.style.cursor='hand'"> ��Ϣ���� </span>
																	</td>
																	<td colspan="5"></td>
																</tr>
															</table>
															<table width="100%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td align="left" valign="bottom" width="10%"
																		colspan="4" height="25">
																		���⣺&nbsp;
																		<input type="text" name="infoname" maxlength="100"
																			value="<%=infoname == null ? "" : infoname%>" class="shuruk1"/>
																			<input name="Submit2" type="button" class="button0" value="�� ѯ" onclick="selectByName();"
	    		 	                                                      	 onmouseover="this.style.cursor='hand'"/>
																	</td>
																	<td colspan="2">
																		<input name="Submit2" type="button" class="button0" value="�� ��" onclick="javascript:add();"/>
				
																	</td>
																</tr>
																<tr align="center" class="bg-zwbt">
																	<th width="10%" align="center" height="25"
																		style="word-break: break-all; word-wrap:break-word;">
																		���
																	</th>
																	<th align="center" width="30%">
																		����
																	</th>
																	<th align="center" width="30%">
																		��������
																	</th>
																	<th align="center" width="10%">
																		����
																	</th>
																	<th align="center" width="20%" colspan="2">
																		����
																	</th>
																</tr>
																<%
																		for (int i = 0; i < govInfoConList.size(); i++) {
																		TbGovInfoPubContent item = (TbGovInfoPubContent) govInfoConList
																		.get(i);
																%>
																<tr align="center" class="bg-zw">
																	<td width="10%" align="center" height="25"
																		style="word-break: break-all; word-wrap:break-word;">
																		<%=i + 1%>
																	</td>
																	<td align="center" width="30%">
																		<%=item.getTitle()%>
																	</td>
																	<td align="center" width="30%">
																		<%=sdf.format(item.getCreateTime())%>
																	</td>
																	<td align="center" width="10%">
																		<%=item.getAuthorName()==null?"":item.getAuthorName()%>
																	</td>
																	<td align="center" width="10%">
																		<a
																			href="javascript:modify('<%=p_name%>','<%=parentid%>','<%=item.getFileId()%>');"><img
																				src="<%=path%>/imagine/xg.gif" width="15"
																				height="15" border="0">
																		</a>
																	</td>
																	<td align="center" width="10%">
																		<a
																			href="javascript:del('<%=p_name%>','<%=parentid%>','<%=item.getFileId()%>');"><img
																				src="<%=path%>/imagine/sc.gif" width="15"
																				height="15" border="0">
																		</a>
																	</td>
																</tr>
																<%
																}
																%>
															</table>
													<tr>
														<td>
															<table width="99%" border="0" cellspacing="0"
																cellpadding="0" align="right">
																<tr>
																	<td height="10"></td>
																</tr>
																<tr>
																	<td class="tabin_page">
																		<a
																			href="<%=path%>/govinfopubContentaction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">��һҳ</span>
																		</a>
																		<a
																			href="<%=path%>/govinfopubContentaction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">��һҳ</span>
																		</a>
																		<span class="bg-zw">��<%=curPage + 1%>ҳ</span>
																		<span class="bg-zw">ÿҳ��ʾ</span>
																		<a
																			href="<%=path%>/govinfopubContentaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">10</span>
																		</a>
																		<a
																			href="<%=path%>/govinfopubContentaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">20</span>
																		</a>
																		<a
																			href="<%=path%>/govinfopubContentaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>"><span
																			class="bg-zw">30</span>
																		</a>
																		<span class="bg-zw">��</span>
																		<span class="bg-zw">��<%=count %>��</span>
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

function govInfoConList()
{
	window.location.href="<%=path%>/govinfopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>&type=<%=type%>";
}

function selectByName()
			{

				var infoname=document.getElementById("infoname").value;
            	window.location.href="<%=path%>/govinfopubContentaction.do?method=list&infoname="+infoname+"&parentid=<%=parentid%>&p_name=<%=p_name%>";
			}
function add() {
		document.getElementById("rightcode").value="212";
		startRequest();
		if (document.getElementById("result").value=="true"){alert("��û�����Ӳ���Ȩ�ޣ�");}
		else
		location.href="<%=path%>/govinfopubContentaction.do?method=add&action=add&p_name=<%=p_name%>&parentid=<%=parentid%>&type=<%=type%>";
		
	}
	function modify(pname,parentId,id) {
		document.getElementById("rightcode").value="213";
		startRequest();
		if (document.getElementById("result").value=="true") {alert("��û���޸Ĳ���Ȩ�ޣ�");}
		else
		window.location.href="<%=path%>/govinfopubContentaction.do?method=modify&p_name="+pname+"&parentid="+parentId+"&id="+id;
		
	}
function del(pname,parentId,id) {
			document.getElementById("rightcode").value="214";
			startRequest();
			if (document.getElementById("result").value=="true"){alert("��û�д˲���Ȩ�ޣ�");}
			else {
			if(confirm('�Ƿ�ȷ��ɾ��')) 
			window.location.href="<%=path%>/govinfopubContentaction.do?method=delete&p_name="+pname+"&parentid="+parentId+"&id="+id;
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