<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<html>
	<head>
		<%
			String path = request.getContextPath();
			String method = request.getParameter("method");
			String action = request.getParameter("action");
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
					String  remark =(String)request.getAttribute("remark");
					
				List ja =(List)request.getAttribute("sujectList");	
		%>
		<base href="<%=basePath%>">
		<title>短信种类管理</title>
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
		<link href="<%=path%>/images/style.css" rel="stylesheet"
			type="text/css" />
		<script language="javascript">
			function OptionChange(){
			   document.form1.action="subject_select.jsp";
			   document.form1.submit();
			}
			  function addItem(){
			     var content = "";
			     var contentId = "";
				if(document.smsSubscribeForm.subName.length>0){
				    for (var i=0; i<document.smsSubscribeForm.subName.length; i++) {
						if (document.smsSubscribeForm.subName[i].checked == true) {
						    content=document.smsSubscribeForm.subName[i].value;
						    contentId = document.smsSubscribeForm.subName[i]
						}  
				    }
			    }
			   
			    window.dialogArguments.document.getElementById("content").value=content;
			    window.close();
			  }
			 function chooseSubjectName(){
			     var flag = document.smsSubscribeForm.subjectFlag.value;
			     for(var i = 0; i<<%=ja.size()%>; i++){
				   if(document.smsSubscribeForm.styleInfo[i].value==flag ){
				         document.getElementById("styleId"+i).style.display ="block";
				   }else{
			       		document.getElementById("styleId"+i).style.display ="none";
			       }
			     }
			    
			     
				// window.showModalDialog("<%=path%>/smsSubscribe.do?method=selectSubjectName&subjectFlag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');					
			}
		</script>
	</head>

	<body>
		<html:form action="/smsSubscribe?method=executeInput&state=true"
			method="Post">
			<input type="hidden" name="id" />
			<input type="hidden" name="name" />
			<table width="100%" border="0"  cellpadding="4" cellspacing="0">
				<tr>
					<td colspan="2" bgcolor="f7f7f7">
						<table width="100%" border="1" cellspacing="0"
							cellpadding="4" id="question1">
							<tr>
								<td colspan="2">
								  <strong>栏目类型</strong> 
								 <select id="subjectFlag" onchange="chooseSubjectName();"> 
								    <option value=""></option>
								  	<option value="TQYB">天气预报</option>
								    <option value="CWYB">潮位预报</option>
								    <option value="CWYJ">潮位预警</option>
								    <option value="SCSW">实测水位</option>
								    <option value="SCYL">实时雨量</option>
								    <option value="FSFX">风速风向</option>
								</select>
								</td>
							</tr>
						</table>
						<table width="100%" border="1" cellpadding="4" cellspacing="0">
							<tr>
								<td colspan="2" bgcolor="f7f7f7">
									<strong> 所有信息订阅条目列表</strong>
								</td>
							</tr>
							<tr>
								<td colspan="2" bgcolor="f7f7f7">
									<table width="100%" border="1" cellspacing="0"
										cellpadding="4">
										<logic:iterate id="item" name="sujectList" indexId ="i">
											<tr id="styleId${i}" >
												<td>
													<logic:iterate id="it" name="item" indexId="index">
														<logic:equal name="index" value="0">
															<input type="hidden" name="subNameId"
																value="<bean:write name="it"/>" />
														</logic:equal>
														<logic:equal name="index" value="1">
															<input type="checkbox" name="subName"
																value="<bean:write name="it" />" />
															<bean:write name="it" />
														</logic:equal>
														<logic:notEmpty name="it">
															<logic:equal name="index" value="2">
																<input type="hidden" name="feeTypeId"
																	value="<bean:write name="it"/>" />
															</logic:equal>
														</logic:notEmpty>
														<logic:notEmpty name="it">
															<logic:equal name="index" value="3">
																<input type="hidden" name="styleInfo"
																	value="<bean:write name="it"/>" />
															</logic:equal>
														</logic:notEmpty>
													</logic:iterate>
												</td>
												
											</tr>
										</logic:iterate>
									</table>
								</td>
							</tr>
						</table>
						<table width="100%" border="0" cellpadding="4" cellspacing="0">
							<tr>
								<td>
									&nbsp;
									<input type="button" value="提交" onclick="addItem();">
									<input type="button" value="返回" onclick="javascript:window.close();">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>
