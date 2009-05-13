
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
		<TITLE>Test page</TITLE>
		<%@ page import="java.util.*"%>
		<%@ page import="java.lang.*"%>
		<%@ page import="shecasafeapi.*"%>
	</HEAD>

	<body>

		<%
			shecasafeapi.SafeEngine myobj = new shecasafeapi.SafeEngine();
			//初始化服务器私钥
			int i = 0;
			i = myobj.shecaInitEnviroment(9, "com1", "537acebd", 0, 9, "com1",
					"537acebd");
			if (i != 0) {
		%>
		<script>alert("初始化safeengine错误：<%=i%>");</script>
		<%
				} else {
				//获取服务器证书
				String strServerCert = myobj.shecaGetSelfCertificate(9, "com1",
				"537acebd");
				if (myobj.getErrorCode() != 0) {
		%>
		<script>alert("获取服务器证书错误：");</script>
		<%
					myobj.shecaClearEnviroment();
					;
				} else {
					String strClientCert = request.getParameter("sCert");
					String strSigned = request.getParameter("sSign");
					String strEnvelope = request.getParameter("sEnvelope");
					String CertUniqueID = myobj
					.shecaGetCertUniqueID(strServerCert);
		%>
		收到的加密数据：
		<%=strEnvelope%>
		<br>
		<br>
		收到的签名数据：
		<%=strSigned%>
		<br>
		<br>
		收到的客户端证书：
		<%=strClientCert%>
		<br>
		<br>
		收到的证书唯一标识：
		<%=CertUniqueID%>
		<br>
		<br>

		<%
					//验证客户端证书
					i = myobj.shecaVerifyCertificate(strClientCert);
					if (i != 0) {
		%>
		<script>alert("验证客户端证书错误：");</script>
		<%
					myobj.shecaClearEnviroment();
					} else //解密数字信封	
					{
				//byte[] shecaPEMDecode(byte[] indata)byte[] shecaPEMDecode(byte[]pemdata)

				//byte[] shecaEnvelopeByte(int intEnvelopetype, byte[] byteIndata, byte[] //byteCertificate 

				byte[] Envelop = null;
				byte[] Signed = null;
				byte[] ClientCert = null;
				Signed = myobj.shecaPEMDecode(strSigned.getBytes());
				Envelop = myobj.shecaPEMDecode(strEnvelope.getBytes());
				ClientCert = myobj.shecaPEMDecode(strClientCert
						.getBytes());
				String strData = new String(myobj.shecaEnvelopeByte(2,
						Envelop, strServerCert.getBytes()));
				if (myobj.getErrorCode() != 0) {
		%>
		<script>alert("解数字信封错误：");</script>
		<%
				myobj.shecaClearEnviroment();
				} else {
		%>
		明文数据：
		<br>
		<%=strData%>
		<br>
		<br>
		<%
					//验证客户端签名
					i = myobj.shecaVerifySignDataByte(strData
					.getBytes(), 3, Signed, ClientCert);
					if (i != 0) {
		%>
		<script>alert("验证签名错误：");</script>
		<%
					myobj.shecaClearEnviroment();
					} else {
						myobj.shecaClearEnviroment();
		%>
		验证签名通过。
		<br>
		<br>
		<%
						//String a=session.getValue("random");
						if (!(session.getValue("random")
						.equals(strData))) {
		%>
		随机数错误strData is
		<%=strData%>
		session is
		<%=session.getValue("random")%>
		<%
		} else {
		%>

		客户端登陆成功！
		<br>
		<%
					} //  end if !(strData.equals(a))
					} // end if VerifySignData
				} //end if Envelope
					} //end if VerifyCertificate
				} //end if GetSelfCertificate
			} //end if InitEnviroment
		%>

	</body>
</html>
