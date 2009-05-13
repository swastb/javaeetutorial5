<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/jsp/infopublic/commJs.jsp"%>
<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String parentid = (String) request.getAttribute("parentid");
	String p_name = (String) request.getParameter("p_name");
	String type = request.getParameter("type");
	//addType表示所添加信息是新闻 水务情况 重要文稿 法规 招标 照片 影片 声音 幻灯片中一种类型
	String addType = request.getParameter("addType");
%>
<script type="text/javascript">
<!--

//-->
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript" src="<%=path%>/js/calendar.js"></script>
	</head>
	<body onload="init('<%=addType %>')">
		<html:form action="/infopubContentaction.do">
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
									<%=p_name%>
									信息
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
											<th width="94%" height="30" align="right" valign="bottom">
												<img src="<%=path%>/images/fh.gif" width="46" height="25"
													border="0" onclick="returnList();"
													onmouseover="this.style.cursor='hand'" />
											</th>
											<th width="6%" valign="bottom"></th>
										</tr>

										<tr>
											<td colspan="2" align="center" valign="top">
											<table width="99%" border="0" cellpadding="0"
													cellspacing="0" class="tabin1_in">
													<tr><td>
												<table width="99%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in" style="border: 0px">
													<tr>
														<td width="20%" align="left" style="noswap">
															栏目
														</td>
														<td valign="top">
															<html:text property="infocla" styleClass="shuruk2"
																size="50" readonly="true" />
															<input type="button" class="button0" value="栏目选择"
																width="50" height="20"
																onclick="selectCla('one','infopub');" align="top">
														</td>

													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															标题
														</td>
														<td>
															<html:text property="title" size="50"
																styleClass="shuruk2" onkeydown="notNull();"
																onblur="chk()" />
															<font color="red"> <span align="left" id="ftitle"></span>
																<span align="left" id="infocommNameCheck"></span> </font>
														</td>

													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															作者
														</td>
														<td>
															<html:text property="authorName" size="50"
																styleClass="shuruk2" />
														</td>
													</tr>
													<tr>
														<td width="20%" align="left" nowrap>
															创建时间
														</td>
														<td colspan="1">
															<html:text property="createTime" styleClass="shuruk2"
																size="50" onfocus="setday(this)" readonly="true"
																onkeydown="notNull();" onblur="chk()" />
															<font color="red"> <span align="left"
																id="fcreateTime"></span>
															</font>
														</td>
													</tr>
													<tr>
														<td width="10%" align="left" nowrap>
															关键字
														</td>
														<td width="90%">
															<table>
																<tr>
																	<td nowrap>
																		第一类
																	</td>
																	<td nowrap>
																		<html:select property="keyword1"
																			styleClass="bot_select">
																			<html:option value="0">--</html:option>
																			<html:option value="1">规划</html:option>
																			<html:option value="2">建设</html:option>
																			<html:option value="3">管理</html:option>
																			<html:option value="4">改革</html:option>
																		</html:select>
																	</td>
																	<td nowrap>
																		第二类
																	</td>
																	<td nowrap>
																		<html:select property="keyword2"
																			styleClass="bot_select">
																			<html:option value="0">--</html:option>
																			<html:option value="1">水安全</html:option>
																			<html:option value="2">水资源</html:option>
																			<html:option value="3">水环境</html:option>
																			<html:option value="4">水景观</html:option>
																		</html:select>
																	</td>
																</tr>
																<tr>
																	<td nowrap>
																		第三类（人物）
																	</td>
																	<td nowrap>
																		<html:select property="keyword3"
																			styleClass="bot_select">
																			<html:option value="0">--</html:option>
																			<html:option value="1">中央领导</html:option>
																			<html:option value="2">省（部）级领导</html:option>
																			<html:option value="3">市领导</html:option>
																			<html:option value="4">局领导</html:option>
																			<html:option value="5">专家</html:option>
																			<html:option value="6">劳模</html:option>
																			<html:option value="7">团队</html:option>
																			<html:option value="8">其他</html:option>
																		</html:select>
																	</td>
																	<td nowrap >
																		第四类（事件）
																	</td>
																	<td style="border-bottom: 0px">
																		<html:select property="keyword4"
																			styleClass="bot_select">
																			<html:option value="0">--</html:option>
																			<html:option value="1">水利设施</html:option>
																			<html:option value="2">供水设施</html:option>
																			<html:option value="3">排水设施</html:option>
																			<html:option value="4">江河湖泊</html:option>
																			<html:option value="5">其他</html:option>
																		</html:select>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
												</table>
												<div id="xw" style="display:none;position:relative;">
													<table width="99%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in" style="border:0px">
														<tr>
															<td width="20%" align="left" nowrap>
																简要标题
															</td>
															<td>
																<html:text property="summaryTitle" size="50"
																	styleClass="shuruk2" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																标题颜色
															</td>
															<td valign="top">
																<html:text property="titleColor" size="50"
																	styleClass="shuruk2" readonly="true" />
																<input type="button" class="button0" value="选择颜色"
																	width="60" height="20" onclick="callColorDlg()"
																	align="top">
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																置顶时间
															</td>
															<td>
																<html:text property="topTime" size="50"
																	styleClass="shuruk2" onfocus="setday(this)"
																	onkeydown="notNull();" onblur="chk()" />
																<font color="red"> <span align="left"
																	id="ftopTime"></span>
																</font>
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																信息来源
															</td>
															<td>
																<html:text property="infoSource" size="50"
																	styleClass="shuruk2" />
															</td>
														</tr>
														<tr>
															<td width="20%" align="left" nowrap>
																是否有版权
															</td>
															<td>
																<html:radio property="iscopyright" value="0">否</html:radio>
																<html:radio property="iscopyright" value="1">是</html:radio>
															</td>
														</tr>
													</table>
												</div>
												<div id="addType" style="display:none;position:relative; padding-top: 2px;padding-bottom: ">
													<table width="99%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in" style="border: 0px">
														<tr >
															<td id="col0" width="20%"></td>
															<td id="col01" width="30%"><html:text property="col0V" size="25" styleClass="shuruk2" maxlength="100"/></td>
															<td id="col1" width="20%"></td>
															<td width="30%" id="col11"><html:text property="col1V" size="25" styleClass="shuruk2" maxlength="100"/></td>
														</tr>
														<tr>
															<td id="col2"></td><td id="col21"><html:text property="col2V" size="25" styleClass="shuruk2" maxlength="100"/></td>
															<td id="col3"></td><td id="col31"><html:text property="col3V" size="25" styleClass="shuruk2" maxlength="100"/></td>
														</tr>
														<tr>
															<td id="col4"></td><td id="col41"><html:text property="col4V" size="25" styleClass="shuruk2" maxlength="100"/></td>
															<td id="col5"></td><td id="col51"><html:text property="col5V" size="25" styleClass="shuruk2" maxlength="100"/></td>
														</tr>
														<tr>
															<td id="col6"></td><td id="col61"><html:text property="col6V" size="25" styleClass="shuruk2" maxlength="100"/></td>
															<td id="col7"></td><td id="col71"><html:text property="col7V" size="25" styleClass="shuruk2" maxlength="100"/></td>
														</tr>
														<tr>
															<td id="col8"></td>
															<td colspan="2" id="col81" ><html:text property="col8V" size="25" styleClass="shuruk2" maxlength="100"/></td>
														</tr>
													</table>
												</div>
												<div style="position:relative;">
												<table width="98%" border="0" cellpadding="0"
													cellspacing="1" class="tabin1_in" style="border: 0px">
													<tr>
														<td width="20%" align="left" nowrap>信息类型</td>
														<td>
															<html:select property="infoType" styleClass="bot_select">
																<html:option value="11">综合新闻</html:option>
																<html:option value="12">一句话新闻</html:option>
																<html:option value="10">水务要闻</html:option>
																<html:option value="40">荣誉</html:option>
																<html:option value="38">科技动态</html:option>
																<html:option value="13">其他</html:option>
															</html:select>
														</td>
													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															简介
														</td>
														<td>
															<html:text property="summary" size="50"
																styleClass="shuruk2" />
														</td>
													</tr>
													<tr>
														<td width="20%" align="left" style="noswap">
															审批
														</td>
														<td>
															<html:select property="sendTo" styleClass="bot_select">
																<html:option value="1">不用审核</html:option>
																<html:option value="2">待审核</html:option>
																<html:option value="3">报送</html:option>
															</html:select>
														</td>
													</tr>
													<tr>
														<td width="100%" align="center" colspan="2" style="noswap">
															信息内容
														</td>
													</tr>
													<tr>
														<td colspan="2" align="center" align="left">
															<IFRAME ID="eWebEditor1" name="content_html"
																src="eWebEditor/eWebEditor.jsp?id=content&style=standard&from=<%=type%>"
																frameborder="0" scrolling="no" width="667" height="350"></IFRAME>
															<html:hidden property="content" styleClass="shuruk2" />
														</td>
													</tr>
													<tr>
														<td align="left">
															<BUTTON ID="ofntColor" class="button0" TITLE="多栏目发布"
																onclick="selectCla('more','infopub');"
																onmouseover="this.style.cursor='hand'">
																多栏目发布
															</BUTTON>
														</td>
														<td align="left">
															<BUTTON ID="a" class="button0" TITLE="发布为公开信息"
																onclick="pubforcominfo();"
																onmouseover="this.style.cursor='hand'">
																发布为公开信息
															</BUTTON>
														</td>
													</tr>
													<tr>
														<td colspan="2" align="center">
															<a onclick="CheckForm();"
																onmouseover="this.style.cursor='hand'"><img
																	src="<%=path%>/imagine/tj.gif" width="52" height="23">
															</a>
														</td>
													</tr>
												</table>
												</div>
												</td>
												</tr>
												</table>
										</td>
										</tr>
										<tr>
											<td height="20" colspan="2"></td>
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
			<html:hidden property="clasel" />
			<!-- 多栏目 -->
			<html:hidden property="infoclas" />
			<!-- 多栏目 -->
			<input type="hidden" name="claId" />
			<!-- 栏目选择 -->
			<input type="hidden" name="pubcominfo" />
			<!-- 信息种类 -->
			<input type="hidden" name="addType" value="<%=addType%>"/>
			<input type="hidden" name="attr2" />
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="publishFlag" value="<%=type%>" />
			<input type="hidden" name="p_name" value=<%=p_name%> />
			<input type="hidden" name="parentid" value="<%=parentid%>" />
			<html:hidden property="id" />

			<input type="hidden" name="org.apache.struts.taglib.html.TOKEN"
				value="6aa35341f25184fd996c4c918255c3ae">

		</html:form>
		<OBJECT id="dlgHelper"
			CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" width="0px"
			height="0px"></OBJECT>
	</body>
</html>
<script language="javascript">
function chk(){
		var title = document.getElementById("title").value;
		var createTime = document.getElementById("createTime").value;
		//var keyword = document.getElementById("keyword").value;
		
		if(title == ""){
			document.getElementById("ftitle").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
				
		}else{
			if(getLen(document.getElementById("title").value) > 100){
				document.getElementById("ftitle").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";			
				return false;	
			}
			else{document.getElementById("ftitle").innerHTML = "";}
		}
		
		if(createTime == ""){
			document.getElementById("fcreateTime").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
		}
		//if(keyword == ""){
		//	document.getElementById("fkeyword").innerHTML = "<font color='red'>"+"关键字以逗号分割"+"</font>";
		//	return false;	
		//}
}

function CheckForm(){
	var title = document.getElementById("title").value;
	var createTime = document.getElementById("createTime").value;
	if(title == ""){alert("数据输入不完整"); return false;}
	if(getLen(document.getElementById("title").value) > 100){alert("字符输入过长"); return false;}
	if(createTime == ""){alert("数据输入不完整"); return false;}
   // infocommNameCheck();
	//if(this.infocommNameflag=="false"){alert("信息标题不能重复"); return false;}
	document.all.content.value= window.content_html.getHTML();
	if(document.all.id.value=='')
	{
		document.all.method.value='add';
	}
	else
	{
		document.all.method.value='modify';
	}
		document.all.action.value='submit';
		document.forms[0].submit();
		return  true;
				
	}	
function returnList(){

      window.location.replace("<%=path%>/infopubContentaction.do?method=list&type=infopub&p_name=<%=p_name%>&parentid=<%=parentid%>");
      
	}
	
	function selectCla(oneormore,type){
	
			window.showModalDialog("<%=path%>/infopubclaaction.do?method=list&oneormore="+oneormore+"&type="+type+"&source=doubleClaPub",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		
	}
	function pubforcominfo(){
		selectCla('one','govinfopub');
		if (confirm("你确认要此信息发布为公开信息吗?")) {
		var pubcominfo=document.getElementById('pubcominfo').value;
		if (pubcominfo==""){alert("请选择政府信息公开栏目！"); return false;}
		//CheckForm();
		}
		else
		document.getElementById('pubcominfo').value="";
	}
	
  	var   sInitColor   =   null;  
  	var oBject='<OBJECT id="dlgHelper" CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" width="0px" height="0px"></OBJECT>'; 
  	function   callColorDlg(){   
    if(!document.getElementById('dlgHelper'))document.body.insertAdjacentHTML("BeforeEnd",oBject);
  	if (sInitColor == null)     
  		//display   color   dialog   box   
  		var   sColor = dlgHelper.ChooseColorDlg();   
 		else   
 		var   sColor = dlgHelper.ChooseColorDlg(sInitColor);   
 		//change   decimal   to   hex   
		sColor = sColor.toString(16);   
  		if (sColor.length < 6) {   
      	var sTempString = "000000".substring(0,6-sColor.length);   
     	sColor = sTempString.concat(sColor);   
  		}   
  		document.getElementById("titleColor").value = sColor;
  	}  
</script>


