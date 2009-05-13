<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<jsp:directive.page import="com.baosight.mode.TbGroup"/>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List allgroup = (List)request.getAttribute("allgroup");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <table width="97%" align="center" cellpadding="0" cellspacing="0">

		<tr>
			<td height="10"></td>
		</tr>
          <tr> 
          <td><img src="<%=path %>/imagine/r-bt.gif" width="11.5" height="14"><span class="bg-zw">&nbsp;&nbsp;组管理</span></td>
        </tr>
        <tr> 
          <td colspan="2"><table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="97cdda" class="tableborder">
              <tr>
                <td valign="top"> <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="d8ecf2" class="tableborder">
                    <tr> 
                      <td height="27" colspan="7" valign="middle" background="<%=path %>/imagine/bg-bt.gif">
                      <a href="<%=path %>/groupaction.do?method=add&action=add"><span class="bg-zw">增 
                        加</span></a></td>
                    </tr>
        <tr align="center" class="bg-zwbt">
    		<td width="20%" align="center">组编号</td>
    		<td width="15%" align="center">组名称</td>
    		<td width="15%" align="center">所属部门</td>
    		<td width="15%" align="center">级别</td>
    		<td width="15%" align="center">说明</td>
    		<td width="20%" align="center"  colspan="2">操作</td>
					</tr>
    	<%for (int i = 0; i < allgroup.size(); i++) {
    		TbGroup item = (TbGroup)allgroup.get(i);
    		%>
    		<tr align="center" class="bg-zw">
    			<td width="20%" align="center"><%=item.getCode() %></td>
    			<td width="15%" align="center"><%=item.getName() %></td>
    			<td width="15%" align="center"><%=item.getDeptCode() %></td>
    			<td width="15%" align="center"><%=item.getLvl() %></td>
    			<td width="15%" align="center"><%=item.getRem() %></td>
    			<td width="10%" align="center"><a title="修改" href="<%=path %>/groupaction.do?method=modify&id=<%=item.getId() %>"><img src="<%=path %>/imagine/xg.gif" width="15" height="15" border="0"></a></td>
    			<td width="10%" align="center"><a title="删除" href="<%=path %>/groupaction.do?method=delete&id=<%=item.getId() %>"><img src="<%=path %>/imagine/sc.gif" width="15" height="15" border="0"></a></td>
    		</tr>
    		<%
    	} %>
 </table>
                </td>
              </tr>
            </table></td>
        </tr>


</table>
</body>
</html>
