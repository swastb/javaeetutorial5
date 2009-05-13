<%@ page language="java"  pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String disply=request.getParameter("disply");
	
%>
<% %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>政府信息公开申请表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" media="all" href="<%=path %>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
		<script type="text/javascript" src="<%=path %>/js/common.js"></script>
</head>

<body>
		<h3>政府信息公开申请表</h3>
	<html:form action="/tbGovInfoPubMain.do">
	<table height="491" border="2" align="center" cellpadding="0" cellspacing="0" bordercolor="black" class="tableborder">
		<tr>
			<td colspan="3">
				申请人（个人）姓名
			</td>
			<td colspan="10" align="center">
			<c:if test="${govInfoPub.applyType==10 }">
				&nbsp;<c:out value="${govInfoPub.applicant }"></c:out>
			</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				申请人（法人或者其他组织）名称
			</td>
			<td colspan="3">
			&nbsp;
			<c:if test="${govInfoPub.company_Name==20 }">
				<c:out value="${govInfoPub.company_Name }"></c:out>
			</c:if>
			</td>
			<td colspan="5">
				法定代表人
			</td>
			<td colspan="2">
			<c:if test="${govInfoPub.company_Name==20 }">
				&nbsp;<c:out value="${govInfoPub.company_Name }"></c:out>
			</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="2" rowspan="3">
				联系方式
			</td>
			<td colspan="8">
				<input type="checkbox" />通信地址:
				<c:out value="${govInfoPub.applyAddr }"></c:out>
			</td>
			<td colspan="2">
				邮政编码:
			</td>
			<td width="625">
				&nbsp;<c:out value="${govInfoPub.postcode }"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="8">
				<input type="checkbox" />联系电话:
				<c:out value="${govInfoPub.phone }"></c:out>
			</td>
			<td colspan="6">
				联系人:<c:out value="${govInfoPub.applicant }"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="11">
				<input type="checkbox" />电子邮箱:<c:out value="${govInfoPub.email }"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				政府信息公开义务机关（机构）名称:<c:out value="${govInfoPub.applicant }"></c:out>
			</td>
			<td colspan="9">
				&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="4" rowspan="2">
				所需的政府信息
			</td>
			<td colspan="4">
				名称:<c:out value="${govInfoPub.doc_Name }"></c:out>
			</td>
			<td colspan="5">
				文号:<c:out value="${govInfoPub.doc_Num }"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="9">
				或者其他特征描述:<c:out value="${govInfoPub.descr }"></c:out>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				获取政府信息的方式
			</td>
			<td colspan="9">
			<c:if test="${govInfoPub.applyManner==null }">
				<input type="radio"  name="way"/>邮寄
				<input type="radio"  name="way" />传真
				<input type="radio"  name="way"/>当面领取
				<input type="radio"  name="way"/>现场查阅
			</c:if>	
			<c:if test="${govInfoPub.applyManner==10 }">
				<input type="radio" checked="checked" name="way"/>邮寄
				<input type="radio"  name="way" />传真
				<input type="radio"  name="way"/>当面领取
				<input type="radio"  name="way"/>现场查阅					
			</c:if>
			<c:if test="${govInfoPub.applyManner==20 }">
				<input type="radio"  name="way"/>邮寄
				<input type="radio" checked="checked" name="way" />传真
			<input type="radio"  name="way"/>当面领取
			<input type="radio"  name="way"/>现场查阅					
			</c:if>
			<c:if test="${govInfoPub.applyManner==30 }">
				<input type="radio"  name="way"/>邮寄
				<input type="radio"  name="way" />传真					
				<input type="radio" checked="checked" name="way"/>当面领取			
				<input type="radio"  name="way"/>现场查阅						
			</c:if>
			<c:if test="${govInfoPub.applyManner==40 }">
				<input type="radio"  name="way"/>邮寄
				<input type="radio"  name="way" />传真
				<input type="radio"  name="way"/>当面领取				
				<input type="radio" checked="checked" name="way"/>现场查阅
			</c:if>					
			</td>
		</tr>
		<tr>
			<td colspan="4">
				政府信息的载体形式
			</td>
			<td colspan="9">
			<c:if test="${govInfoPub.offerWay==null }">
				<input type="radio" name="offerway"/>电子邮件
				<input type="radio" name="offerway"/>纸质文本
			</c:if>
			<c:if test="${govInfoPub.offerWay==20 }">
				<input type="radio" name="offerway"/>纸质文本
				<input type="radio" name="offerway" checked="checked"/>电子邮件
			</c:if>
			<c:if test="${govInfoPub.offerWay==10 }">
				<input type="radio" name="offerway"/>电子邮件
				<input type="radio" name="offerway" checked="checked"/>纸质文本
			</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				所需政府信息的用途
			</td>
			<td colspan="9">
			<c:if test="${govInfoPub.reason==10 }"></c:if>
				<input type="checkbox" name="reason1"/>生产的需要<input type="checkbox" name="reason2"/>
				生活的需要 <input type="checkbox" name="reason3"/>科研的需要<input type="checkbox" name="reason4"/>查验自身信息
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<strong>特别声明：</strong>个人需申请免除收费，主要理由
			</td>
			<td colspan="9">
				本局暂不收费
			</td>
		</tr>
		<tr>
			<td width="121" height="51">
				申请人签名（盖章）
			</td>
			<td colspan="4">
				&nbsp;<c:out value="${govInfoPub.applicant }"></c:out>
			</td>
			<td colspan="4">
				申请时间
			</td>
			<td colspan="4">
				<c:out value="${govInfoPub.startTime }"></c:out>
			</td>
		</tr>
	</table>
</html:form>
</body>
</html>
