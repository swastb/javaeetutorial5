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
			
			      var name = "";
				  var id="";
				  var type="";
				  var feeTypeId = "";
				  var infoType = "";
				if(document.smsSubscribeForm.subName.length>0){
				    for (var i=0; i<document.smsSubscribeForm.subName.length; i++) {
						if (document.smsSubscribeForm.subName[i].checked == true) {
						
								id += document.smsSubscribeForm.subNameId[i].value + ",";	
								name += document.smsSubscribeForm.subName[i].value + ",";
								type += document.smsSubscribeForm.subNameType[i].value + ",";
								feeTypeId += document.smsSubscribeForm.feeTypeId[i].value + ",";
								infoType += document.smsSubscribeForm.remark.value + ",";
						}  
				    }
			    }else{
			    	if (document.smsSubscribeForm.subName.checked == true) {
								id += document.smsSubscribeForm.subNameId.value + ",";	
								name += document.smsSubscribeForm.subName.value + ",";
								type += document.smsSubscribeForm.subNameType.value + ",";
								//feeTypeId += document.smsSubscribeForm.feeTypeId.value + ",";
								infoType += document.smsSubscribeForm.remark.value + ",";
						}  
			    
			    }
			    var remark = document.smsSubscribeForm.remark.value;
			    if(remark=='0'){
			      
			      window.opener.document.getElementById("subjectnameType").value +=type;
			      window.opener.document.getElementById("subjectnameId").value +=id;
			      var perentName = window.opener.document.getElementById("subjectname").value;
			      var subname;
			      if(perentName!=null && perentName!=""){
			           perentName+=",";
			           subname = perentName+name;
			      }else{
			           subname = name;
			      }
			      subname = subname.substring(0,subname.length-1);
			      window.opener.document.getElementById("subjectname").value = subname;	
			      window.opener.document.getElementById("subjectname").title += name;	
			      window.opener.document.getElementById("subjectFeeTypeId").value +=feeTypeId;	
			    }else if(remark=='1'){
			      window.opener.document.getElementById("subjectnameOptionalType").value +=type;
			      window.opener.document.getElementById("subjectnameOptionalId").value +=id;
			      var perentName =  window.opener.document.getElementById("subjectnameOptional").value;
			      var subname;
			      if(perentName!=null && perentName!=""){
			           perentName+=",";
			           subname = perentName+name;
			      }else{
			           subname = name;
			      }
			      subname = subname.substring(0,subname.length-1);
			      window.opener.document.getElementById("subjectnameOptional").value = subname;	
			      window.opener.document.getElementById("subjectOptionalFeeTypeId").value +=feeTypeId;		   
			    } 
			    //dialogArguments
			     window.opener.document.getElementById("infoType").value += infoType;
			    
			     window.close();
			     
			  }
		</script>
	</head>

	<body>
		<html:form action="/smsSubscribe?method=executeInput&state=true"
			method="Post">
			<input type="hidden" name="id" />
			<input type="hidden" name="name" />
			<input type="hidden" name="remark" value="<%=remark%>" />
			<table width="100%" border="0"  cellpadding="4" cellspacing="0">
				<tr>
					<td colspan="2" bgcolor="f7f7f7">
						<table width="100%" border="1" cellspacing="0"
							cellpadding="4" id="question1">
							<tr>
								<td colspan="2">
									<strong></strong>
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

										<logic:iterate id="item" name="sujectList">
											<tr>
												<td>
													<logic:iterate id="it" name="item" indexId="index">
														<logic:equal name="index" value="0">
															<input type="hidden" name="subNameId"
																value="<bean:write name="it"/>" />
																<input type="hidden" name="subNameType"
																value="<bean:write name="subjectState"/>" />
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
