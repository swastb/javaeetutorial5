<%@ page language="java" import="java.util.*,com.baosight.mode.TbUser" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<TITLE></TITLE>
		<LINK href="imagine/style.htm" type=text/css rel=stylesheet>
		<SCRIPT language=javascript src="imagine/function.htm"></SCRIPT>

		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<SCRIPT language=javascript>
function OpenWindow1(url,str)
{
  window.open(url,str,"height=400,width=700,status=no,toolbar=no,menubar=no,location=no,left=100,top=100");
}
function OpenWindow2(url,str)
{
  window.open(url,str,"height=400,width=800,status=no,toolbar=no,menubar=no,location=no,left=100,top=100");
}
	function logout(){
		var path = document.getElementById("path").value;
		var loginType = document.getElementById("loginType").value;
		var url = path+"/loginoutAction.do?loginType="+loginType;
		window.open(url,"_self");
	}
   function personOff(){
		var path = document.getElementById("path").value;
		var loginUser = document.getElementById("loginUser").value;
		var password = document.getElementById("password").value;
		var loginType = document.getElementById("loginType").value;
		var url = path+"/login.do?loginUser="+loginUser+"&password="+password+"&loginType="+loginType;
		window.parent.open(url,"_self")
	}
</SCRIPT>

		<SCRIPT language=JavaScript src="imagine/coolbuttons.htm"></SCRIPT>


		<SCRIPT language=javascript>
<!--
var curObj= null;
function document_onclick() {
 if(window.event.srcElement.tagName=='A'||window.event.srcElement.tagName=='FONT'){
  if(curObj!=null)
   curObj.style.background='';
  curObj=window.event.srcElement;
  curObj.style.background='#D6CDA7';
    }
}

//-->
 </SCRIPT>
		<link href="css/index-css.css" rel="stylesheet" type="text/css">
		<META content="MSHTML 6.00.2900.2180" name=GENERATOR>
	</HEAD>
	<BODY onclick=document_onclick(); leftMargin=0 topMargin=0
		marginheight="0" marginwidth="0">
	<input type="hidden" id="loginUser" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getUserAcc()%>"/>
	<input type="hidden" id="password" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getPwd()%>"/>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="loginType" value="<%=session.getAttribute("loginType") %>"/>
		<TABLE height=73 cellSpacing=0 align="center" cellPadding=0
			width="1014" border=0>
			<TBODY>
				<TR>
					<TD vAlign=top width=778 background=imagine/top_ju.gif height=49>
						<TABLE height=49 cellSpacing=0 cellPadding=2 width=300 align=right
							border=0>
							<TBODY>

								<TR>
									<TD>
										<MARQUEE onmouseover=stop(); onmouseout=start();
											scrollDelay=180>
											<FONT color=#ccffff><STRONG> </STRONG>
											</FONT>
										</MARQUEE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					<TD align=middle width=0 background=imagine/top_bg.gif rowSpan=2>
						<IFRAME name=clock src="imagine/clock1.htm" frameBorder=NO
							width=138 height=73 allowTransparency></IFRAME>
					</TD>
					<TD align=middle width=0 background=imagine/top_bg.gif rowSpan=2>
						<IFRAME name=clock src="imagine/clock2.htm" frameBorder=NO
							width=80 height=73 allowTransparency></IFRAME>
					</TD>
				</TR>
				<FORM name=form1 method=post>
				<TR>
					<TD
						style="BACKGROUND-POSITION: left top; BACKGROUND-IMAGE: url(images/top_down.gif); BACKGROUND-REPEAT: no-repeat"
						height=24>
						<TABLE cellSpacing=0 cellPadding=2 width=600 align=right border=0>
							<TBODY>
								<TR>
									<TD align=right>
									<TD>
										<%--<A href="http://31.16.1.66/oadocument/ju_left.jsp" target=left><IMG
												height=20 src="imagine/xt_dh_02.gif" width=68 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_02.gif" width=68 border=0/>
									</TD>
									<TD>
										<%--<A href="http://31.16.1.66/oadocument/gr_left.jsp" target=left><IMG
												height=20 src="imagine/xt_dh_03.gif" width=67 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_03.gif" width=67 border=0/>
									</TD>
									<TD>
										<%--<A href="http://www.shanghaiwater.gov.cn/" target=_blank><IMG
												height=20 src="imagine/xt_dh_04.gif" width=68 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_04.gif" width=68 border=0/>
									</TD>
									<TD width=68>
										<%--<A href="http://31.16.1.66/oadocument/xxgk_left.jsp"
											target=left><IMG height=20 src="imagine/xt_dh_05.gif"
												width=68 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_05.gif" width=68 border=0/>
									</TD>
									<TD>
										<%--<A href="http://31.16.1.66/oadocument/ws_left.jsp" target=left><IMG
												height=20 src="imagine/xt_dh_06.gif" width=69 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_06.gif" width=69 border=0/>
									</TD>
									<TD align=middle width=71>
										<%--<A onclick=toDxinpt1()
											href="http://31.16.1.66/oadocument/top.jsp#"><IMG
												height=20 src="imagine/xt_dh_12.gif" width=69 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_12.gif" width=69 border=0/>
										<INPUT type=hidden value=admin name=username>
										<INPUT type=hidden value=y4yhl9t name=passwrd>
									</TD>
									<TD>
										<%--<A href="http://31.16.1.66/oadocument/ju_left_bgs.jsp"
											target=left><IMG height=20 src="imagine/bgszl.gif"
												width=82 border=0>
										</A>
										--%><img height=20 src="imagine/bgszl.gif" width=82 border=0/>
									</TD>
									<TD>
										<%--<A href="http://31.16.1.7/" target=_blank resizable="yes"><IMG
												height=20 src="imagine/xt_dh_07.gif" width=68 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_07.gif" width=68 border=0/>
									</TD>
									<TD>
										<%--<A href="http://31.16.1.66/oadocument/xt_left.jsp" target=left><IMG
												height=20 src="imagine/xt_dh_08.gif" width=68 border=0>
										</A>
										--%><img height=20 src="imagine/xt_dh_08.gif" width=68 border=0/>
									</TD>
								</TR>
								</FORM>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>

		<table width="1014" class="b" align="center" height="23" cellpadding="0"
			cellspacing="0" background="imagine/gdt-1.gif">

			<tr>
				<td width="120" class="xb" nowrap="nowrap">
					欢迎您
					<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION"))
							.getName()%>
				</td>
               <td class="xb" onclick="personOff()" onmouseover="this.style.cursor='hand'">个人公务</td>
				
				<td colspan="3">
					<marquee behavior="scroll" direction="left" scrollamount="3"
						style="font-size: 12px;color: 2c6b9e;" onMouseOver="this.stop();"
						onMouseOut="this.start();">
						<strong><jsp:include flush="true" page="tqbg.jsp" /></strong>
					</marquee>
				</td>
				<td width="36" onmouseover="this.style.cursor='hand'">
					<img src="imagine/dl4.gif" width="36" height="20" onclick="logout();">
				</td>
			</tr>



		</table>
	</BODY>
</HTML>
