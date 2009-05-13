<%@ page language="java" import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script language="javascript" type="text/javascript">
	function go()
	{
		window.location.replace("/sso/jsp/login.jsp");
	}
	go();
</script>
<body>
</body>


