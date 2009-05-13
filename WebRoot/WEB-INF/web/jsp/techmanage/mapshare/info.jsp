<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
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

		<title>科研成果</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">

	</head>
	
	<script type="text/javascript">
function init(){
	var readonly = "${param.readonly}";
	if(readonly=="true"){
		var inputs = document.getElementsByTagName("input");
		var inputs = document.getElementsByTagName("input");
		for(i in inputs){
			var obj = inputs[i];
			if(obj.type=="text"){
				obj.readOnly = true;
			}else if(obj.type=="button"){
				obj.style.display="none";
			}
		}
		document.getElementById("applyReason").readOnly = true;
		document.getElementById("mapScope").readOnly = true;
		document.getElementById("mapContent").readOnly = true;
		document.getElementById("approveBtnAdd").style.display = "none";
		document.getElementById("agbookBtnAdd").style.display = "none";
	}
}
</script>
	<body onload="init()">

		<html:form action="/techMapShare" enctype="multipart/form-data" method="post">
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
											<td width="84%" class="table2_topic" align="left">
												添加地图申请信息
											</td>
										</tr>
									</table>
								</td>
								<td background="images/8-2.gif">
									&nbsp;
								</td>
							</tr>
						</table>
						<table width="100%" align="center" border="0" cellpadding="0"
							cellspacing="1" bgcolor="#0e88b9">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<th height="10" valign="bottom"></th>
													</tr>
													<tr>
														<td align="center" valign="bottom">
														<table width="98%" border="0" cellpadding="0"
													cellspacing="0" >
													<tr><td align="right"><img src="<%=path %>/images/fh.gif" onclick="history.back();" onmouseover="this.style.cursor='hand'" /></td></tr>
													</table>
																<table width="99%" border="0" cellpadding="0"
																cellspacing="1" class="tabin_in">
																<tr>
																	<td align="center" class="bg-zw" width="20%">
																	单位名称:
																	</td>
																	<td class="bg-zw" align="left">
																	<html:text property="unitName" size="30" styleClass="shuruk1" ></html:text>
																	</td>
																</tr>
																<tr>	
																	<td align="center" class="bg-zw">
																	领取时间:
																	</td>
																	<td class="bg-zw" align="left">
																	<html:text property="getTime" size="30" styleClass="shuruk1" ></html:text>
																	</td>
																</tr>
																
																
																<tr>	
																	<td align="center" class="bg-zw">
																	申请理由:
																	</td>
																	<td class="bg-zw" align="left">
																	<html:textarea property="applyReason" styleClass="shuruk2" cols="40" rows="5"></html:textarea>
																	</td>
																</tr>
																<tr>	
																	<td align="center" class="bg-zw">
																	图号范围:
																	</td>
																	<td class="bg-zw" align="left">
																	<html:textarea property="mapScope" styleClass="shuruk2" cols="40" rows="5"></html:textarea>
																	</td>
																</tr>
																<tr>	
																	<td align="center" class="bg-zw">
																	数据内容:
																	</td>
																	<td class="bg-zw" align="left">
																	<html:textarea property="mapContent" styleClass="shuruk2" cols="40" rows="5"></html:textarea>
																	</td>
																</tr>
																<tr>	
																	<td align="center" class="bg-zw">审批表：
																	</td>
																	<td class="bg-zw" align="left">
<script type="text/javascript" charset="utf-8" src="<%=path%>/javascript/attach.js"></script>
<logic:present name="files1">	
<table>
	<logic:iterate id="Record" indexId="i" name="files1" type="com.baosight.mode.TbDocAttach" >
		<tr id="trapprove${i}">
			<td>
			<html:link page="/docAttach.do?method=download" paramId="id" paramName="Record" paramProperty="id">
				<bean:write name="Record" property="originallyName"/>
			</html:link>
			<input type="button" onclick="deleteFile('approve${i}')" value="删除" class="button0" />
			<input type="hidden" id="hidapprove${i}" value="${Record.id}" />
			<input type="hidden" id="fileNameapprove${i}" value="${Record.originallyName}">
			<td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
			<table id="approvetb" cellpadding="0" cellspacing="1"></table>
			<div id="approveBtnAdd">
				<input type="button" value="添加附件" onclick="_sFileName('approve');additem('approvetb')" class="button0"/>
				<font color="red">上传附件文件不能大于10M!</font>
			</div>
																	</td>
																</tr>
																<tr>	
																	<td align="center" class="bg-zw">承诺书：
																	</td>
																	<td class="bg-zw" align="left">
<logic:present name="files2">	
<table>
	<logic:iterate id="Record" indexId="i" name="files2" type="com.baosight.mode.TbDocAttach" >
		<tr id="tragbook${i}">
			<td>
			<html:link page="/docAttach.do?method=download" paramId="id" paramName="Record" paramProperty="id">
				<bean:write name="Record" property="originallyName"/>
			</html:link>
			<input type="button" onclick="deleteFile('agbook${i}')" value="删除" class="button0" />
			<input type="hidden" id="hidagbook${i}" value="${Record.id}" />
			<input type="hidden" id="fileNameagbook${i}" value="${Record.originallyName}">
			<td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
			<table id="agbooktb" cellpadding="0" cellspacing="1"></table>
			<div id="agbookBtnAdd">
				<input type="button" value="添加附件" onclick="_sFileName('agbook');additem('agbooktb')" class="button0"/>
				<font color="red">上传附件文件不能大于10M!</font>
			</div>
																	</td>
																</tr>
																<tr>
																<td align="center" colspan="2" height="25">
																	<span id="tijiao"><input  type="button" class="button0"
																			value="提交" onclick="document.forms[0].submit();"
																			onmouseover="this.style.cursor='hand'" />
																			<html:hidden property="id"/></span>
															<input type="hidden" name="method" value="add"/>
																</td>
																</tr>
															</table>
															</td>
													</tr>
													<tr>
														<td height="10"></td>
													</tr>
												</table>
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
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
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
