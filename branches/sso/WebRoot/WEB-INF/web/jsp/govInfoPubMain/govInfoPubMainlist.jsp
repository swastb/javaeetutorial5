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
    try{
      sessionID = (String)request.getAttribute("sessionID");
      curPage = (Integer)session.getAttribute(sessionID+"No");
      count=(Long)session.getAttribute(sessionID+"Count");
    }catch(Exception ex){
      ex.printStackTrace();
    }
	
    int i=0;//序号
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="<%=path%>/javascript/validate.js"></script>

<script type="text/javascript">

	function selectByName()
	{
		var name=document.getElementById("name").value;
        var phone=document.getElementById("phone").value;
        //window.location.replace("<%=path%>/tbGovInfoPubMain.do?method=list&action=conditionSelect&name="+name+"&phone="+phone);
	}
			
</script>	
		<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style>	
	</head>

<body>
 	<table width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40"  valign="middle" background="images/8-1.gif">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="5%" align="center" valign="middle">
								&nbsp;
							</td>
							<td width="11%" height="12" align="center" valign="middle">
								<img src="images/icon5.gif" width="7" height="7" />
							</td>
							<td width="84%" class="table2_topic">
								政府信息公开
							</td>
						</tr>
					</table>
				</td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
       <table width="100%" align="center" border="1" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">			
			<tr>
          <td>
		 <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0" bgcolor="#0e88b9">			
			<tr>
          <td><table width="98%" align="center" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top"><table width="98%" border="0" cellspacing="0" cellpadding="0"> 
                    <tr>
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="16%" class="tabin_atab">待审核信息列表</td>
                      <td width="16%" class="tabin_atabno"><a href="infoAudit.do?method=findAuditList&condition=auditing"><span class="bg-zw">审核中信息列表</span></a></td>
                      <td width="16%" class="tabin_atabno"><a href="infoAudit.do?method=findAuditList&condition=audited_pass"><span class="bg-zw">审核通过列表</span></a></td>
                      <td width="16%" class="tabin_atabno"><a href="infoAudit.do?method=findAuditList&condition=audited_notPass"><span class="bg-zw">审核未通过列表</span></a></td>
                      <td width="16%" class="tabin_atabno"><a href="infoAudit.do?method=findAuditList&condition=invalidApply"  ><span class="bg-zw">无效申请列表</span></a></td>
                     <td width="16%" class="tabin_atabno"><a href="<%=path %>/infoAudit.do?method=findAuditList&condition=notAccept"  ><span class="bg-zw">不予受理列表</span></a></td>
                     <td width="">&nbsp;</td>
                     </tr>
                   </table> 
                   <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                   <tr>
										<th width="5%" height="25" align="center">
											序号
										</th>
										<th align="center" width="15%">
											名称(申请人)
										</th>
										<th align="center" width="20%">
											身份证/组织机构代码
										</th>
										<th align="center" width="10%">
											申请主体
										</th>
										<th align="center" width="15%">
											申请日期
										</th>
										<th align="center" width="15%">
											收费
										</th>
										<th width="10%" align="center" colspan="2" width="20%">
											操作
										</th>
									</tr>
									
<logic:present name="curPageList">								
<logic:iterate id="Record" name="curPageList" type="com.baosight.mode.TbGovInfoPubAudit" >
									<tr align="center" >
										<td width="5%"  height="25" align="center">
											<%=i + 1%>
										</td>
										<td align="center">
<bean:write name="Record" property="tbGovInfoPub.applicant"/>
										</td>
										<td align="center">
<bean:write name="Record" property="tbGovInfoPub.certNo"/>
										</td>
										<td align="center" >
<logic:equal name="Record" property="tbGovInfoPub.applyType" value="10">个人</logic:equal>
<logic:equal name="Record" property="tbGovInfoPub.applyType" value="20">企业</logic:equal>
										</td>
										<td align="center" >
<bean:write name="Record" property="tbGovInfoPub.startTime" format="yyyy-MM-dd"/>
										</td>
										<td align="center" >
<bean:write name="Record" property="tbGovInfoPub.fee" />
										</td>
										<td width="10%" align="center" >
<html:link page="/tbGovInfoPubMain.do?method=delete" paramId="id" paramName="Record" paramProperty="tbGovInfoPub.id" onclick="return confirm('确认该申请为无效申请');">
	<img src="<%=path %>/images/icon6.gif" width="15" height="15" border="0" alt="无效申请">
</html:link>
										</td>
										<td width="10%" align="center" >
<html:link page="/tbGovInfoPubMain.do?method=view&status=1&disply=willAudit" paramId="id" paramName="Record" paramProperty="tbGovInfoPub.id">
	<img src="<%=path%>/images/sh.gif" width="37" height="18" border="0" />
</html:link>
										</td>
										
									</tr>
<%i++; %>
</logic:iterate>
</logic:present>			
</table>
<table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>
  <tr>
	<td class="tabin_page" align="right">
	<a href="<%=path%>/tbGovInfoPubMain.do?method=movePage&moveTo=<%=curPage-1%>&sessionID=<%=sessionID %>"><span class="bg-zw">上一页</span></a>
	<a href="<%=path%>/tbGovInfoPubMain.do?method=movePage&moveTo=<%=curPage+1%>&sessionID=<%=sessionID %>"><span class="bg-zw">下一页</span></a>
	<span class="bg-zw">第<%=curPage+1%>页</span>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="bg-zw">每页显示</span>
	<a href="<%=path%>/tbGovInfoPubMain.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID %>"><span class="bg-zw">10</span></a>
	<a href="<%=path%>/tbGovInfoPubMain.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID %>"><span class="bg-zw">20</span></a>
	<a href="<%=path%>/tbGovInfoPubMain.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID %>"><span class="bg-zw">30</span></a>
	<span class="bg-zw">条</span>
	<span class="bg-zw">共<%=count %>条</span>
	</td>
 </tr>					
</table></td>
</tr><tr>
    <td height="20"></td>
  </tr>	

</table>
</td></tr>
<%--<tr>
<td height="10"></td>
</tr>
--%></table>
</td></tr><tr>
<td height="10"></td>
</tr>
</table></td></tr></table>

</body>
</html>

