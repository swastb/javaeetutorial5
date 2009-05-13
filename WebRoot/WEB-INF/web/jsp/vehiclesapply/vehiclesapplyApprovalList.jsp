<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
    String sessionID = "";
    int curPage = 0;
    long count=0;
  	sessionID = (String)request.getAttribute("sessionID");
    curPage = (Integer)session.getAttribute(sessionID+"No");
    count=(Long)session.getAttribute(sessionID+"Count");
    int i=0;//序号
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
	     		<tr>
		            <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif">
		            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		                		<tr>
		                  			<td width="5%" align="center" valign="middle">&nbsp;</td>
	                  				<td width="11%" height="12" align="center" valign="middle">
	             	     				<img src="images/icon5.gif" width="7" height="7" />
	                  				</td>
									<td width="84%" class="table2_topic" align="right">用车审批管理</td>
	               				</tr>
		            		</table>
		            </td>
	            	<td background="images/8-2.gif">&nbsp;</td>
	       		</tr>
			</table>
<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9"><tr><td>			
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
        		<tr>
        		<td align="center" valign="top">
        			<table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
        				<tr><th height="30" valign="bottom"></th></tr>
				           
						<tr>
						<td align="center" valign="bottom">
							<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
								<tr>
									<th width="10%" align="center" height="25" >序号</th>
									<th align="center">车牌号</th>
									<th align="center">申请时间</th>
									<th align="center">申请人</th>
									<th align="center">审批状态</th>
									<th align="center" width="7%">操作</th>
								</tr>
								
								<logic:present name="curPageList">								
								<logic:iterate id="VehiclesApplyRecord" name="curPageList" type="com.baosight.mode.TbVehiclesApply" >
								
								<tr align="center">
									<td  align="center" height="25">
										<%=i + 1%><%i++;%>
									</td>
									<td align="center">
										<bean:write name="VehiclesApplyRecord" property="license"/>
									</td>
									<td align="center">
										<bean:write name="VehiclesApplyRecord" property="applyTime" format="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td align="center">
										<bean:write name="VehiclesApplyRecord" property="applyer"/>
									</td>
									<td align="center">
										<logic:equal value="1" name="VehiclesApplyRecord" property="status" >未提交</logic:equal>	
										<logic:equal value="2" name="VehiclesApplyRecord" property="status" >已提交未审核</logic:equal>											
										<logic:equal value="4" name="VehiclesApplyRecord" property="status" >审核通过</logic:equal>
										<logic:equal value="8" name="VehiclesApplyRecord" property="status" >驳回</logic:equal>
									</td>
									<td align="center">
										<html:link page="/tbVehiclesApply.do?method=modify&action=approval" 
											paramId="id" paramName="VehiclesApplyRecord" paramProperty="id">
											<img src="<%=path%>/images/sh.gif" width="37" height="18" border="0" />
										</html:link>
									</td>
								</tr>
								
								</logic:iterate>
								</logic:present>
							</table>
							
							<table width="99%" border="0" cellspacing="0" cellpadding="0">
							    <tr><td height="10"></td></tr>
							    <tr>
							        <td class="tabin_page">
										<a href="<%=path%>/tbVehiclesApplyApproval.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>"><span class="bg-zw">上一页</span></a>
										<a href="<%=path%>/tbVehiclesApplyApproval.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>"><span class="bg-zw">下一页</span></a>
										<span class="bg-zw">第<%=curPage+1%>页</span>
										&nbsp;&nbsp;&nbsp;&nbsp;
										<span class="bg-zw">每页显示</span>
										<a href="<%=path%>//tbVehiclesApplyApproval.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>"><span class="bg-zw">10</span></a>
										<a href="<%=path%>//tbVehiclesApplyApproval.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>"><span class="bg-zw">20</span></a>
										<a href="<%=path%>//tbVehiclesApplyApproval.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>"><span class="bg-zw">30</span></a>
										<span class="bg-zw">条</span> 
										<span class="bg-zw">共<%=count %>条</span>                      
									</td>
								</tr>
							</table>
						</td>
						</tr>
					</table>	
        		</td>
        		</tr>
        		
        		<tr height="8"><td><td></tr>
        	</table>
</td></tr></table>        		
		</td>
		</tr>
	</table>

</body>
</html>

