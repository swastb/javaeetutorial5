<%@ page contentType="text/html; charset=gb2312" pageEncoding="GBK" %>
<%@include file="commons.jsp"%>
<%@ page import="java.util.*"%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html locale="true">
  <head>
    <html:base />
    
    <title>主题分类</title>
    <LINK href="catalog.files/dtree.css" type=text/css rel=StyleSheet>
    <SCRIPT src="catalog.files/dtree.js" type=text/javascript></SCRIPT>
    <SCRIPT src="catalog.files/op.js" type=text/javascript></SCRIPT>
    <META content="MSHTML 6.00.2800.1593" name=GENERATOR>

  	<LINK REL="STYLESHEET" HREF="<%= request.getContextPath() %>/css/CSS1.css" TYPE="text/css">
  </head>  
  <body onload="javascript: d.openAll();">
  <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="219" height="533" valign="top" background="../imagine/l-dt.gif"><table width="90%" align="center" cellpadding="0" cellspacing="0">
 <tr>
          <td height="20">
		  </td>
        </tr>
        <tr>
          <td valign="top">
<table width="100%" cellpadding="0" cellspacing="0">
              <tr align="center" class="bg-zwbt"> 
 <td width="50%" height="18"><a href="javascript: d.openAll();">全部打开</a></td>
 <td height="18"> <a href="javascript: d.closeAll();">全部折叠</a></td>
               </tr>
              <tr> 
                <td height="1" colspan="2" bgcolor="8ccbd9" ></td>
              </tr>
            </table></td>
        </tr>
        
</table>
<SCRIPT type=text/javascript>
    d = new dTree('d');
    
	d.config.folderLinks=true;
	
	//id, pid, name, url, title, target, icon, iconOpen, open	

	d.add('a0','-1',' ','','Govment Resource','right');	
	
	d.add('b0','a0','参数管理','','参数管理','right');
		d.add('b1','b0','职务等级管理','<%=path%>/pstlvlaction.do?method=list','职务等级管理','right');
		d.add('b2','b0','权限类型管理','<%=path%>/righttypeaction.do?method=list','权限类型管理','right');
		d.add('b3','b0','用户级别管理','<%=path%>/userlvlaction.do?method=list','用户级别管理','right');
		d.add('b4','b0','权限级别管理','<%=path%>/authlvlaction.do?method=list','用户级别管理','right');
		d.add('b5','b0','部门级别管理','<%=path%>/deptlvlaction.do?method=list','用户级别管理','right');
		d.add('b6','b0','应用系统管理','<%=path%>/allappSys.do?method=list','应用系统管理','right');
		
	d.add('c0','a0','资源管理','','资源管理','right');
		d.add('c1','c0','功能资源管理','<%=path%>/base/function/navigation.do','功能资源管理','right');	
		d.add('c2','c0','角色管理','<%=path%>/roleaction.do?method=list','角色管理','right');
	d.add('d0','a0','权限管理','','权限管理','right');
		d.add('d1','d0','组织机构管理','<%=path%>/orgmainaction.do','组织机构管理','right');	
		d.add('d2','d0','角色权限管理','<%=path%>/base/roleAuth/navigation.do','角色权限管理','right');	
		d.add('d3','d0','角色用户管理','<%=path%>/roleusermainaction.do','角色用户管理','right');		
	
	
	d.selectedNode=Node('b0','a0','参数管理','','参数管理','right');
	document.write(d);
	
</SCRIPT>
</td>
</tr>

</table>



</body>
</html:html>
