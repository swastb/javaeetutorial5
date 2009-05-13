<%@ page language="java" import="java.util.*,com.baosight.mode.TbUser"
	pageEncoding="GBK"%>
<HTML>
	<HEAD>
		<TITLE>欢迎进入上海市水务局电子政务系统！</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<SCRIPT language=JavaScript src="imagine/coolbuttons.htm"></SCRIPT>
		<SCRIPT language=javascript>
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
	<BODY style='overflow:scroll;overflow-x:hidden'  onclick=document_onclick(); leftMargin=0 topMargin=0
		marginheight="0" marginwidth="0">
		<input type="hidden" id="loginUser" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getUserAcc()%>"/>
	<input type="hidden" id="password" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getPwd()%>"/>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="loginType" value="<%=session.getAttribute("loginType") %>"/>
		<TABLE height=82 cellSpacing=0 cellPadding=0 align="center"
			width="1000"  border=0>
			<FORM name=form1 action=/smslogin.do method=post target=_blank>
			<TBODY>
				<TR>
					<TD>
						<TABLE height=82 cellSpacing=0 cellPadding=0 width="1014"
							background=imagine/top_xxzx.jpg border=0>
							<TBODY>
								<TR>
									<TD vAlign=top align=right width=1000 
										background= height=82>
										<TABLE height=82 cellSpacing=0 cellPadding=0 width="100%"
											border=0>
											<TBODY>
												<TR>
													<TD vAlign=top>
														<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
															<TBODY>
																<TR>
																	<TD>
																		<TABLE cellSpacing=0 cellPadding=0 width=100
																			align=right border=0>
																			<TBODY>


																				<TR>
																					<TD></TD>
																				</TR>
																			</TBODY>
																		</TABLE>
															<TBODY>
																<TR>
																	<TD>
																		<TABLE cellSpacing=0 cellPadding=0 align=right
																			border=0>
																			<TBODY>
																				<TR>
																					<TD align=middle colSpan=8 height=38>
																						<TABLE cellSpacing=0 cellPadding=4 width=300
																							align=right border=0>
																							<TBODY>
																								<TR>
																									<TD>
																										<MARQUEE onmouseover=stop();
																											onmouseout=start(); scrollDelay=180>
																											<FONT color=#ffff00><STRONG></STRONG>
																											</FONT>
																										</MARQUEE>
																								<TR>
																								</TR>
																								<TR>
																									<TD>
																										<MARQUEE onmouseover=stop();
																											onmouseout=start(); scrollDelay=180>
																											<FONT color=#0066cc><STRONG>
																											</STRONG>
																											</FONT>
																										</MARQUEE>
																									</TD>
																								</TR>
																								
																								</FONT>
																								</MARQUEE>
																								</TD>
																								</TR>
																							</TBODY>
																						</TABLE>
																					</TD>
																				</TR>

																				<!-- <TD WIDTH="70" align="center"><a href="http://31.16.1.59/" target="_blank">物资管理</a></TD>-->
																				</TR>
																			</TBODY>
																		</TABLE>
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
									<TD align=middle>
										<IFRAME name=clock src="imagine/clock1.htm"  frameBorder=NO
											width=137 height=82  allowTransparency></IFRAME>
									</TD>
									<TD align=middle width=0>
										<IFRAME name=clock src="imagine/clock3.htm" frameBorder=NO
											width=85 height=82 allowTransparency></IFRAME>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<table width="1014" class="b" align="center" height="23"
							cellpadding="0" cellspacing="0" background="imagine/gdt-1.gif">

							<tr><td width="120" class="xb" nowrap="nowrap">
									欢迎您<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION"))
							.getName()%> </td>
								<td class="xb" onclick="personOff()" onmouseover="this.style.cursor='hand'">个人公务</td>
								
								<td colspan="3">
									<marquee behavior="scroll" direction="left" scrollamount="3"
										style="font-size: 12px;color: 2c6b9e;"
										onMouseOver="this.stop();" onMouseOut="this.start();">
										<strong><jsp:include flush="true" page="tqbg.jsp" />
										</strong>
									</marquee>
								</td>
								<td width="36" onmouseover="this.style.cursor='hand'">
									<img src="imagine/dl4.gif" width="36" height="20" onclick="logout();">
								</td>
							</tr>



						</table>
	</BODY>
</HTML>
