<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	List allindividual = (List) request.getAttribute("curPageList");

	String pername = "";
	String perphone = "";
	pername = (String) request.getAttribute("pername");
	perphone = (String) request.getAttribute("perphone");
	if (pername == null || pername.equals("")) {
		pername = (String) request.getParameter("pername");
	}
	if (perphone == null || perphone.equals("")) {
		perphone = (String) request.getParameter("perphone");
	}

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
%>

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
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
	<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:active {text-decoration: none;}
a:hover {text-decoration: none;}
</style> 
	</head>

	<body>
		<html:form action="/individualaction.do">
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
								通讯录管理
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
                      <td width="2%" height="24">&nbsp;</td> 
                      <td width="16%" class="tabin_atab">个人通讯录</td>
                      <td width="16%" class="tabin_atabno"><a href="individualcommaction.do?method=list&groupname="><span class="bg-zw">个人通讯组</span></a></td>
                       <td width="61%" colspan="3">&nbsp;</td>
                   </table> 
                   <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
                   <tr>
		
			<td height="25" colspan="6" valign="bottom" bgcolor="#f7f7f7" align="left">
						<span class="bg-zw">请输入姓名：</span>
						<html:text property="pername" styleClass="shuruk1"></html:text>
						<span class="bg-zw">请输入移动电话：</span>
						<html:text property="perphone" styleClass="shuruk1"></html:text>

						<input name="Submit2" type="submit" class="button0" value="查 询" onclick="selectName();"
	    		 		 onmouseover="this.style.cursor='hand'"/>
						</td>
						<td height="25" colspan="7" valign="bottom" bgcolor="#f7f7f7" align="right">&nbsp;
			      <input name="Submit2" type="submit" class="button0" value="增 加" onclick="add();"
	    		 		 onmouseover="this.style.cursor='hand'"/>
					</td>
				</tr>
				<tr  align="center">
											<th width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												序号
											</th>
											<th width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												组名
											</th>
											<th width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												姓名
											</th>
											<th width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												职务
											</th>
											<th width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												移动电话
											</th>
											<th width="35%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												备注
											</th>
											<th width="10%" align="center" colspan="4">
												操作
											</th>
										</tr>
										<%
												for (int i = 0; i < allindividual.size(); i++) {
												Object[] item = (Object[]) allindividual.get(i);
										%>
										<tr align="center" class="bg-zw">
											<td width="5%" height="25" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=i + 1%>
											</td>
											<td width="15%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=item[1]%>
											</td>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<a
													href="<%=path%>/individualaction.do?method=view&id=<%=item[0]%>&pername=<%=pername%>&perphone=<%=perphone%>"><%=item[2]%>
												</a>
											</td>
											<%
											if (item[3] == null) {
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;"></td>
											<%
											} else {
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=item[3]%>
											</td>
											<%
													}
													if (item[4] == null) {
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;"></td>
											<%
											} else {
											%>
											<td width="10%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=item[4]%>
											</td>
											<%
											}
											%>
											
											<%
											if (item[5] == null) {
											%>
											<td width="35%" align="center"
												style="word-break: break-all; word-wrap:break-word;"></td>
											<%
											} else {
											%>
											<td width="35%" align="center"
												style="word-break: break-all; word-wrap:break-word;">
												<%=item[5]%>
											</td>
											<%
											}
											%>
											<td width="5%" align="center">
												<a title="修改"
													href="<%=path%>/individualaction.do?method=modify&id=<%=item[0]%>&pername=<%=pername%>&perphone=<%=perphone%>"><img
														src="<%=path%>/imagine/xg.gif" width="15" height="15"
														border="0"> </a>
											</td>
											<td width="5%" align="center">
												<a title="删除"
													href="<%=path%>/individualaction.do?method=delete&id=<%=item[0]%>&pername=<%=pername%>&perphone=<%=perphone%>"
													onclick="return confirm('是否确认删除');"><img
														src="<%=path%>/imagine/sc.gif" width="15" height="15"
														border="0"> </a>
											</td>
										</tr>
										<%
										}
										%>
									
				<tr>
					<td colspan="13">
						<table align="right">
							<tr>
								<td>
									<a
										href="<%=path%>/individualaction.do?method=movePage&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&pername=<%=pername%>&perphone=<%=perphone%>"><span
										class="bg-zw">上一页</span> </a>
									<a
										href="<%=path%>/individualaction.do?method=movePage&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&pername=<%=pername%>&perphone=<%=perphone%>"><span
										class="bg-zw">下一页</span> </a>
									<span class="bg-zw">第<%=curPage + 1%>页</span>
									<span class="bg-zw">每页显示</span>
									<a
										href="<%=path%>/individualaction.do?method=resetPageSize&pageSize=10&sessionID=<%=sessionID%>&pername=<%=pername%>&perphone=<%=perphone%>"><span
										class="bg-zw">10</span> </a>
									<a
										href="<%=path%>/individualaction.do?method=resetPageSize&pageSize=20&sessionID=<%=sessionID%>&pername=<%=pername%>&perphone=<%=perphone%>"><span
										class="bg-zw">20</span> </a>
									<a
										href="<%=path%>/individualaction.do?method=resetPageSize&pageSize=30&sessionID=<%=sessionID%>&pername=<%=pername%>&perphone=<%=perphone%>"><span
										class="bg-zw">30</span> </a>
									<span class="bg-zw">条</span>
									<span class="bg-zw">共<%=count %>条</span>
								</td>
								</tr>
             			</table>
             	 	</td>
            	</tr>
            
          </table>
         <table width="99%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="10"></td>
  </tr>


</table>
</td></tr>
<%--<tr>
<td height="10"></td>
</tr>
--%></table>
</td></tr>
</table>
  <tr>
    <td height="10"></td>
  </tr>
</table>
</td></tr></table></html:form>
</body>
</html>


<script type="text/javascript">

			function selectName(){

			var pername=document.getElementById("pername").value;
			var perphone=document.getElementById("perphone").value;
		
            var form=document.forms[0];
				form.action="<%=path%>/individualaction.do?method=listSelect&pername="+pername+"&perphone="+perphone;
				form.target="_self";
				form.submit();
          
			}
			
			function add()
			{
				var form=document.forms[0];
				form.action="<%=path %>/individualaction.do?method=add&action=add";
				form.target="_self";
				form.submit();
            
			}

	
</script>

