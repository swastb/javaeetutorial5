<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<HTML>
	<script language="JavaScript">
	if   (top.frames.length!=0)   top.location=self.document.location; 
	function submit1(){
	var loginUser = document.getElementById("loginUser").value;
	var password = document.getElementById("password").value;
	if(loginUser==""){
		alert("用户名不能为空");
		document.getElementById("loginUser").focus();
		return false;
	}
	if(password==""){
		alert("密码不能为空");
		document.getElementById("password").focus();
		return false;
	}	
	var frm = document.forms[0];
	var goto = document.getElementById("goto").value;
	frm.action = frm.action+"?goto="+goto+"&loginType=3";
	frm.submit();
}
</script>
	<HEAD>
		<TITLE>水务信息中心电子办公系统登录</TITLE>

		<STYLE type=text/css>TD {
	FONT-SIZE: 14px; TEXT-DECORATION: none
}
.input {
	BORDER-RIGHT: #526542 1px solid; BORDER-TOP: #526542 1px solid; BORDER-LEFT: #526542 1px solid; COLOR: #000000; BORDER-BOTTOM: #526542 1px solid; BACKGROUND-COLOR: #f7f7f7
}
</STYLE>

		<STYLE type=text/css>.FONT {
	FONT-SIZE: 10pt
}
</STYLE>

		<META content="MSHTML 6.00.2900.2180" name=GENERATOR>
	</HEAD>
	<BODY leftMargin=0 background=imagine/bg4.gif topMargin=0
		onload=setfocus() MARGINHEIGHT="0" MARGINWIDTH="0">
		<input type="hidden" value="" id="resultFlag" />
		<input type="hidden" value="" id="resultInfo" />
		<input type="hidden" value="<%=request.getContextPath()%>" id="path" />
		<input type="hidden" name="goto" id="goto"
			value="<%=request.getParameter("goto")%>">
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD>
						<TABLE cellSpacing=4 cellPadding=0 width=700 align=center
							bgColor=#e7e7e7 border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE cellSpacing=0 cellPadding=0 width=700 border=0>
											<TBODY>
												<TR>
                <TD vAlign=bottom background=imagine/login_01.jpg 
                height=92></TD></TR>
              <TR>
                <TD><IMG height=14 alt="" src="imagine/login_06.gif" 
                  width=700></TD></TR>
              <TR>
                <TD><IMG height=217 alt="" src="imagine/login_03.jpg" 
                  width=700></TD></TR>
											</TBODY>
										</TABLE>
										<TABLE cellSpacing=0 cellPadding=0 width=700 border=0>
											<FORM name="form1" action="login.do" method=post>
											<TBODY>
												<TR>
													<TD width=700 bgColor=#ffffff>
														<TABLE cellSpacing=0 cellPadding=4 width=560 align=center
															border=0>
															<TBODY>
																<TR>
																	<TD align=right width=60>
																		<IMG height=23 src="imagine/log.gif" width=26>
																	</TD>

																	<TD align=middle width=480 colSpan=2>
																		<STRONG>用户名：</STRONG>
																		<input name="loginUser" type="text"
																			value="" class="denglu"
																			onkeypress="javascript:if(event.keyCode==13){submit1();}" />
																		<STRONG>密码：</STRONG>
																		<input name="password" type="password" value=""
																			class="denglu"
																			onkeypress="javascript:if(event.keyCode==13){submit1();}" />
																		<img src="imagine/dl1.gif" height=18 width=42
																			onclick="submit1();">
																	</TD>
																</TR>
															</TBODY>
														</TABLE>
													</TD>
												</TR>
												<TR>
													<TD background=imagine/dothx.gif colSpan=2 height=1></TD>
												</TR>
												<TR>
													<TD class=FONT align=middle bgColor=#f7f7f7 height=50>
														（最佳浏览方式：IE6.0 1024*768）
														<BR>
														copyright &copy; 2004 上海市水务局 版权所有 Email:
														webmaster@shanghaiwater.net.cn
													</TD>
												</TR>
												</FORM>
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
		<SCRIPT language=javascript>
function setfocus() {  
	document.all.loginUser.focus();  
	document.all.loginUser.select();
} 
</SCRIPT>
	</BODY>
</HTML>
