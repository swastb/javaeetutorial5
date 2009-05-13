
<%
		if (request.getProtocol().compareTo("HTTP/1.0") == 0)
		response.setHeader("Pragma", "no-cache");
	else if (request.getProtocol().compareTo("HTTP/1.1") == 0)
		response.setHeader("Cache-Control", "no-cache");

	response.setDateHeader("Expires", 0);
%>
<%@ page contentType="text/html; charset=gb2312"%>
<HTML>
	<HEAD>
		<%@ page import="java.util.*"%>
		<%@ page import="shecasafeapi.*"%>
		<TITLE>Test page</TITLE>
	</HEAD>

	<BODY>
		<%
			//System.out.println(System.getProperty("java.library.path")); 
			shecasafeapi.SafeEngine myobj = new shecasafeapi.SafeEngine();
			String strServerCert = "", strRandom = "", strCert = "", strSigned = "", strEnvelope = "";
			int i = 0;

			i = myobj.shecaInitEnviroment(9, "com1", "1234", 0, 9, "com1",
					"1234");

			if (i != 0) {
		%>
		<script>alert("初始化safeengine错误:<%=i%>");</script>
		<%
				} else {
				//获取服务器证书
				strServerCert = myobj.shecaGetSelfCertificate(9, "com1",
				"537acebd");
				if (myobj.getErrorCode() != 0) {
		%>
		<script>alert("读取服务器证书错误");</script>
		<%
					myobj.shecaClearEnviroment();
					//myobj.SEH_ClearSession;
				} else {
					//产生随机数
					Random RandNum = new java.util.Random();
					int RandomData = RandNum.nextInt(1000000);
					strRandom = RandomData + "我们大家"; //
					/*String strRandom = myobj.shecaGenRandomBytes();
					 if (myobj.getErrorCode()!=0) 
					 {
		%>
		<script>alert("产生随机数错误");</script>
		<%
					 myobj.SEH_ClearSession;
					 }
					 */

					session.putValue("random", strRandom);
		%>
		<p align="center">
			<OBJECT ID="SafeEngineCtl"
				CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="0"
				height="0" border=0 codebase="SafeEngineCOM.cab#Version=1,2,0,0"></OBJECT>
		</p>


		<p align="center">
		<form name=form1 method=post action="server.jsp"
			onsubmit="return doTest()">

			<input type=hidden name=sCert value="<%=strCert%>">
			<input type=hidden name=sSign value="<%=strSigned%>">
			<input type=hidden name=sEnvelope value="<%=strEnvelope%>">
			<input type=submit value="开始">
			<br>
			<br>

		</form>
		</p>
		<script languang="javascript">
function doTest()
{
	/* Change the path and password below */
	/*strpassword=document.form1.pwd.value;*/
	SafeEngineCtl.SEH_InitialSession(9,"com1","537acebd",1000,2,"com1","537acebd");
	if(SafeEngineCtl.ErrorCode!=0)
	{
		alert("SEH_InitialSession Error. Return:" + SafeEngineCtl.ErrorCode);
		return false;
	}
	/* 获取自己证书 */
	strCert = SafeEngineCtl.SEH_GetSelfCertificate(9, "com1", "537acebd");
	if(SafeEngineCtl.ErrorCode!=0)
	{
		alert("SEH_GetSelfCertificate Error. Return:" + SafeEngineCtl.ErrorCode);
		return false;
	}
	document.form1.sCert.value = strCert;
	
	/* 验证服务器证书 */
	SafeEngineCtl.SEH_VerifyCertificate("<%=strServerCert%>");	
	if(SafeEngineCtl.ErrorCode!=0)
	{
		alert("SEH_VerifyCertificate Errorhhhhhh. Return:" + SafeEngineCtl.ErrorCode);
		SafeEngineCtl.SEH_ClearSession();
		return false;
	}

	/* 签名随机数 */
	strSigned = SafeEngineCtl.SEH_SignData("<%=strRandom%>", 3);	
	if(SafeEngineCtl.ErrorCode!=0)
	{
		alert("SEH_SignData Error. Return:" + SafeEngineCtl.ErrorCode);
		SafeEngineCtl.SEH_ClearSession();
		return false;
	}
	document.form1.sSign.value = strSigned;

	/* 用服务器证书加密随机数 */
	strEnvelope = SafeEngineCtl.SEH_Envelope(1, "<%=strRandom%>", "<%=strServerCert%>");	
	if(SafeEngineCtl.ErrorCode!=0)
	{
		alert("SEH_Envelope(Enc) Error. Return:" + SafeEngineCtl.ErrorCode);
		SafeEngineCtl.SEH_ClearSession();
		return false;
	}
	document.form1.sEnvelope.value = strEnvelope;
	
	/* 释放 */
	SafeEngineCtl.SEH_ClearSession();
	return true;
}



</script>
		<%
			}
			}
		%>
	</BODY>
</HTML>
