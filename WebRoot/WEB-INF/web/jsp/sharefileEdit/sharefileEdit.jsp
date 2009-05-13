<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbMeetingroom" />
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%
	String path = request.getContextPath();
	String method = request.getParameter("method");
	String action = request.getParameter("action");
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
<!--
	function checkForm(){
		
		if(sharefileForm.explanation.value==""){
			alert("附件说明不能为空!");
			return false;
		}
		if(sharefileForm.explanation.value.length >= 250){
			alert("附件说明长度不能大于250字符或文字!");
			return false;
		}
		if(document.all.method.value!='modify'){
			var len=sharefileForm.file.value.length;
			var filename=sharefileForm.file.value.substr(len-4,len).toLowerCase();
			if(filename=='.exe'){
				alert("不能上传可执行文件");
				return false;
			}
		}
		document.forms[0].submit();
		return true;
	}
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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
			<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
	
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<html:form action="/sharefileEdit.do" enctype="multipart/form-data"
			method="post">
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
											<td width="84%" class="table2_topic" align="right">
												共享空间
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
								<td align="center">
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="table2bg">
										<tr>
											<td align="center" valign="top">
												<table width="98%" border="0" cellpadding="0"
													cellspacing="0" class="table2bgin">
													<tr>
														<td>

<table width="98%"><tr><td width="17%" align="right" valign="bottom">
						<img src="<%=path%>/images/fh.gif" width="46" height="25" onclick="window.location='<%=path%>/shareFileListAction.do?method=list&type=1';"  onmouseover="this.style.cursor='hand'">
						&nbsp;
					</td></tr></table>
															<table align="center" width="98%" border="0"
																cellpadding="0" cellspacing="1" 
																class="tabin_in">
																<thead class="bg-zw">

																	<tr>
																		<td nowrap width="80" height="25" align="center"
																			class="bg-zwbt">
																			附件类型
																		</td>
																		<td colspan="2" align="left">
																			<html:select property="type">
																				<html:option value="1">文件

</html:option>
																				<html:option value="2">图片

</html:option>
																				<html:option value="3">动画

</html:option>
																				<html:option value="4">视频

</html:option>
																				<html:option value="5">音乐

</html:option>
																			</html:select>
																		</td>
																	</tr>
																	<tr>
																		<td nowrap width="80" height="25" align="center"
																			class="bg-zwbt">
																			是否共享
																		</td>
																		<td colspan="2" align="left">
																			<html:radio property="isShare" value="0">是

</html:radio>
																			<html:radio property="isShare" value="1">否

</html:radio>
																		</td>
																	</tr>

																	<tr>
																		<td nowrap width="80" align="center"
																			class="bg-zwbt">
																			附件说明
																		</td>
																		<td colspan="2" align="left">
																			<html:textarea styleClass="shuruk7" property="explanation" rows="3"
																				cols="55" />
																			<br />
																			<font color="red">附件说明长度不能大于250字 符或文字</font>
																		</td>
																	</tr>

																	<tr>
																		<td nowrap width="80" align="center" class="bg-zwbt">
																			附件
																		</td>
																		<td colspan="2" align="left">
																			<logic:empty name="fileName">
																				<html:file property="file"
																					onkeydown="event.returnValue=false;" />
																			</logic:empty>
																			<logic:notEmpty name="fileName">
																				<bean:write name="fileName" />
																			</logic:notEmpty>
																		</td>
																	</tr>

																</thead>

																<thead class="bg-zwbt">
																	<tr>
																		<td colspan="3" align="center">
																			<img src="<%=path%>/imagine/tj.gif"
																				onclick="checkForm();"
																				onmouseover="this.style.cursor='hand'">
																		</td>
																	</tr>
																</thead>
															</table>

<table><tr><td height="20"></td></tr></table>


														</td>
													</tr>
												</table>
											</td>
										</tr>


										<tr>
											<td height="8" colspan="2"></td>
										</tr>

									</table>
									
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

			<input type="hidden" name="action" value="submit" />
			<input type="hidden" name="method" value="<%=method%>" />

			<html:hidden property="id" />

		</html:form>
	</body>
</html>
