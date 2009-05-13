<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<jsp:directive.page import="com.baosight.mode.TbAppsys"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pstlvllist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
	<link href="images/style.css" rel="stylesheet" type="text/css" />
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
                  					<td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
                  					<td width="84%" class="table2_topic">应用系统管理</td>
                				</tr>
            				</table>
            			</td>
            			<td background="images/8-2.gif">&nbsp;</td>
          		   </tr>
        		</table>
        		 <table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#0e88b9">
							<tr>
								<td>
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
      				<tr>
        				<td align="center" valign="top">
        					<table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
			           			<tr>
			              			<th height="30" valign="bottom"></th>
			           			</tr>
			           			<tr>
			         				<td align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
			         			<tr>
			        				<td height="25" colspan="7" valign="bottom" bgcolor="#f7f7f7" align="right">&nbsp;
			      <input name="Submit2" type="submit" class="button0" value="&nbsp;增 加&nbsp;" onclick="add();"
	    		 		 onmouseover="this.style.cursor='hand'"/>

					</td></tr>
    	<tr align="center" class="bg-zwbt">
    		<th width="5%" height="25" align="center" style="word-break: break-all; word-wrap:break-word;">序号</th>
    		<th width="25%" align="center" style="word-break: break-all; word-wrap:break-word;">应用系统名称</th>
    		<th width="30%" align="center" style="word-break: break-all; word-wrap:break-word;">应用系统URL</th>
    		<th width="15%" align="center" style="word-break: break-all; word-wrap:break-word;">CODE</th>
    		<th width="15%" align="center" style="word-break: break-all; word-wrap:break-word;">是否为子系统</th>
    		<th width="10%" align="center"  colspan="2">操作</th>
    	</tr>

    	<c:forEach var="content" items="${allappSys}" varStatus="loop">
    		<tr align="center" class="bg-zw">
    			<td width="5%" height="25" align="center" style="word-break: break-all; word-wrap:break-word;">${loop.index+1}</td>
    			<td width="25%" align="center" style="word-break: break-all; word-wrap:break-word;">${content.name}</td>
    			<td width="30%" align="center" style="word-break: break-all; word-wrap:break-word;">${content.url}</td>
    			<td width="15%" align="center" style="word-break: break-all; word-wrap:break-word;">${content.code}</td>
    			<td width="15%" align="center" style="word-break: break-all; word-wrap:break-word;">
    			<c:choose>
    			  <c:when test="${content.ischild == 1}">是</c:when>
    			  <c:otherwise>否</c:otherwise>
    			</c:choose>
    			<td width="5%" align="center"><a title="修改" href="<%=path %>/allappSys.do?method=modify&id=${content.id}"><img src="<%=path%>/images/icon9.gif" width="15" height="15" border="0"></a></td>
    			<td width="5%" align="center">
    				<c:choose>
    					<c:when test="${content.insure== 0}"><a title="删除" href="<%=path %>/allappSys.do?method=delete&id=${content.id}" onclick="return confirm('是否确认删除')"><img src="<%=path%>/images/icon6.gif" width="15" height="15" border="0"></a></c:when>
    			  		<c:otherwise>&nbsp;</c:otherwise>
    				</c:choose>
    			</td>
    		</tr>
    	</c:forEach>
 <tr>
			                  		<td height="20"></td>
			                	</tr>
             			</table>
             	 	</td>
            	</tr>
            <tr>
              <td height="10"></td>
            </tr>
          </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="8"></td>
            </tr>
          </table></td>
      </tr>
    </table>
    </td>
    </tr>
    </table>
</body>
</html>

<script type="text/javascript">

			function add()
			{
			
             window.location.replace("<%=path %>/allappSys.do?method=add&action=add");
           
			}

	
</script>

