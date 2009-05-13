<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.baosight.mode.*"%>
<%@ page import="com.baosight.tools.ChangeUtil"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  TbUser user=(TbUser)session.getAttribute("SYSTEM_USER_SESSION");
  System.out.println("loginafter:"+user.getName());
  System.out.println("loginafter:"+user.getUserAcc());
  String logName=user.getUserAcc();
  String realityName=user.getName();
  String deptId=(String)session.getAttribute("SYSTEM_USER_DEPT_ID");
  String deptName=(String)session.getAttribute("SYSTEM_USER_DEPT_NAME");
  String xzxkurl=ChangeUtil.xzxkurl+"/login.do?loginName="+logName+"&realityName="+realityName+"&deptId="+deptId+"&deptName="+deptName+"&userid="+user.getId();
  String destorySession=ChangeUtil.xzxkurl+"/byid.do?method=destorySession";
  //String url_88_login="http://31.16.1.88/login.do?userName="+logName+"&password="+user.getPwd();
  String url_88_login="http://31.16.1.88/login.do?userName=admin&password=y4yhl9t";
  String ISFXZHB = request.getAttribute("ISFXZHB").toString();
  String commedName = request.getParameter("commedName");
  %>
<html>
	<head>
	    <base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>上海水务</title>
		
		<script type="text/javascript" src="<%=path %>/javascript/hmanager.js"></script>
		<script type="text/javascript">
		  this.httpGet('<%=url_88_login%>');
		  this.httpGet('<%=xzxkurl%>');
		  function window.onbeforeunload()
		  {
	        this.httpGet('<%=destorySession%>');
          }
		</script>
	</head>
	
		<%		
		String loginType = (String)request.getAttribute("loginType");	
		if(loginType!=null && loginType.equals("1")){
		%>
		<frameset rows="100,*" frameborder="NO" border="0" framespacing="0">
		<frame src="top_ju.jsp" name="topFrame" scrolling="NO" noresize>
		<%
		}else if(loginType!=null && loginType.equals("2")){
		%>
		<frameset rows="105,*" frameborder="NO" border="0" framespacing="0">
		<frame src="top_xxzx.jsp" name="topFrame" scrolling="NO" noresize>
		<%		
		}else if(loginType!=null && loginType.equals("3")){
		%>
		<frameset rows="143,*" frameborder="NO" border="0" framespacing="0">
		<frame src="top_slzx.jsp" name="topFrame" scrolling="NO" noresize>
		<%		
		}else{%>
		<frameset rows="140,*" frameborder="NO" border="0" framespacing="0">
		<frame src="top.jsp?ISFXZHB=<%=ISFXZHB %>&commedName=<%=commedName %>" name="topFrame" scrolling="NO" noresize>
		<%
		} %>
		<frameset cols="1*,1014,1*" border="0px" frameborder="NO" framespacing="0">
    		<frame src="blank.html" scrolling="no" noresize>
			<frameset cols="114,3,890" frameborder="NO"  border="0" framespacing="0">
				<frame src="outlook.jsp" name="leftFrame" scrolling="no" marginwidth="0" marginheight="0" />
				<frame src="blank.html" scrolling="no" noresize>
				<frame src="right.jsp" name="rightFrame" scrolling="auto" marginwidth="0" marginheight="0" />
			</frameset>
			<frame src="blank.html">
		</frameset>
	</frameset>
	
	
</html>
