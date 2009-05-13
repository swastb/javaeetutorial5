<%@ page language="java" import="java.util.*,com.baosight.mode.TbUser"
	pageEncoding="GBK"%>
<HTML><HEAD><TITLE>上海市水务业务受理中心电子政务系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<STYLE type=text/css>TD {
	FONT-SIZE: 12px; COLOR: #333333; LINE-HEIGHT: 145%; TEXT-DECORATION: none
}
</STYLE>
<script type="text/javascript">
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
</script>
<SCRIPT><%--
function setLeft1(){

parent.leftFrame.src="left1.htm";

}

    Cookie[] cookies = request.getCookies();

	for (int i = 0; i < cookies.length; i++) {
		String loginUser = cookies[i].getName();
		String userName = cookies[i].getValue();

        alert(loginUser);
		alert(userName);

	}	



--%>
</SCRIPT>
<link href="css/index-css.css" rel="stylesheet" type="text/css">
<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>
<BODY leftMargin=0 background=imagine/bg_02.jpg topMargin=0 
MARGINHEIGHT="0" MARGINWIDTH="0">
 <input type="hidden" id="loginUser" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getUserAcc()%>"/>
	<input type="hidden" id="password" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getPwd()%>"/>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="loginType" value="<%=session.getAttribute("loginType") %>"/>
<TABLE height=120 cellSpacing=0 cellPadding=0 align="center" width="1014" 
background=imagine/top_slzx.jpg border=0>
  <TBODY>
  <TR>
    <TD vAlign=top colSpan=2 height=24>
      <TABLE cellSpacing=0 cellPadding=0 align=right border=0>
        <TBODY>
        <TR>
          <TD width=31><IMG height=24 alt="" src="imagine/top_03.gif" 
            width=31></TD>
          <TD noWrap width=300 background=imagine/top_04.gif>
            <DIV align=left><!--  <A href="http://31.16.1.138:66/main.jsp" 
            target=_parent><IMG height=24 alt="" 
            src="imagine/top_icon_06.gif" width=49 border=0></A>--><IMG height=24 alt="" 
            src="imagine/top_icon_06.gif" width=49 border=0><!--<A 
            href="http://31.16.1.138:66/open/auth/individualAction.do?doType=0" 
            target=mainFrame><IMG height=24 alt="" 
            src="imagine/top_icon_09.gif" width=70 border=0></A>--><IMG height=24 alt="" 
            src="imagine/top_icon_09.gif" width=70 border=0><!--<A 
            href="http://31.16.1.138:66/content/content/contentListAction3.do?categoryId=SW_CONTENT_007" 
            target=mainFrame><IMG height=24 src="imagine/top_icon_10.gif" 
            width=44 border=0></A>--><IMG height=24 src="imagine/top_icon_10.gif" 
            width=44 border=0><!--<A 
            href="http://31.16.1.138:66/logOutAction.do" target=_parent><IMG 
            height=24 alt="" src="imagine/top_icon_11.gif" width=45 
            border=0></A>--><IMG 
            height=24 alt="" src="imagine/top_icon_11.gif" width=45 
            border=0><!--<A href="http://31.16.1.138:66/open" 
            target=_parent><IMG height=24 src="imagine/top_icon_12.gif" 
            width=70 border=0></A>--><IMG height=24 src="imagine/top_icon_12.gif" 
            width=70 border=0></DIV></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD vAlign=bottom width="90%" height=48>
      <DIV align=right>
      <TABLE cellSpacing=0 cellPadding=0 width="35%" align=right border=0>
        <TBODY>
        <TR><!-- <td width="100%" height="22"> 


	  <marquee direction="left" width="96%" onMouseOut="this.start();" height="17" 
       onmouseover="this.stop();" scrollamount="1" scrolldelay="1"><html>
<head>
<title>JSP parse error</title>
</head>
<body>

<b>Parsing of JSP File '/inc/tqbg.jsp' <font color=#FF0000>failed</font>:</b><HR>
<font face="Courier New, Courier, mono" size="2">
/inc/tqbg.jsp(4): Could not parse deployment descriptor: org.xml.sax.SAXException: [HTTP:101248][ServletContext(id=31513128,name=web,context-path=)]: Deployment descriptor "/WEB-INF/list.tld" is malformed. Check against the DTD: Content is not allowed in prolog. (line 1, column 1).<br>
probably occurred due to an error in /inc/tqbg.jsp line 4:<br>
<font color="#FF0000">
&lt;%@ taglib uri= &quot;List&quot; prefix=&quot;Tag&quot; %&gt;
</font>
<hr><i>Mon May 26 16:02:47 CST 2008</i>
</body>
</html>
            </marquee>

            </td>-->
          <TD width="4%">&nbsp;</TD></TR></TBODY></TABLE></DIV></TD>
    <TD width="10%" rowSpan=2>
      <DIV align=center>
      <TABLE height=86 cellSpacing=0 cellPadding=0 width=92 
      background=imagine/calend.gif border=0>
        <TBODY>
        <TR>
          <TD>
            <DIV align=center>
            <SCRIPT language=JavaScript>
var  bsYear;
var  bsDate;
var  bsWeek;
var  arrLen=8;	//数组长度
var  sValue=0;	//当年的秒数
var  dayiy=0;	//当年第几天
var  miy=0;	//月份的下标
var  iyear=0;	//年份标记
var  dayim=0;	//当月第几天
var  spd=86400;	//每天的秒数
var  year1999="30;29;29;30;29;29;30;29;30;30;30;29";	//354
var  year2000="30;30;29;29;30;29;29;30;29;30;30;29";	//354
var  year2001="30;30;29;30;29;30;29;29;30;29;30;29;30";	//384
var  year2002="30;30;29;30;29;30;29;29;30;29;30;29";	//354
var  year2003="30;30;29;30;30;29;30;29;29;30;29;30";	//355
var  year2004="29;30;29;30;30;29;30;29;30;29;30;29;30";	//384
var  year2005="29;30;29;30;29;30;30;29;30;29;30;29";	//354
var  year2006="30;29;30;29;30;30;29;29;30;30;29;29;30";
var  year2007="29;29;30;29;29;30;29;30;30;30;29;30";    //354
var  year2008="30;29;29;30;29;29;30;29;30;30;29;30";    //354

var  month1999="正月;二月;三月;四月;五月;六月;七月;八月;九月;十月;十一月;十二月"
var  month2001="正月;二月;三月;四月;闰四月;五月;六月;七月;八月;九月;十月;十一月;十二月"
var  month2004="正月;二月;闰二月;三月;四月;五月;六月;七月;八月;九月;十月;十一月;十二月"
var  month2006="正月;二月;三月;四月;五月;六月;七月;闰七月;八月;九月;十月;十一月;十二月"
var  Dn="初一;初二;初三;初四;初五;初六;初七;初八;初九;初十;十一;十二;十三;十四;十五;十六;十七;十八;十九;二十;廿一;廿二;廿三;廿四;廿五;廿六;廿七;廿八;廿九;三十";

var  Ys=new  Array(arrLen);
Ys[0]=919094400;Ys[1]=949680000;Ys[2]=980265600;
Ys[3]=1013443200;Ys[4]=1044028800;Ys[5]=1074700800;
Ys[6]=1107878400;Ys[7]=1138464000;Ys[8]=1171728000;
Ys[9]=1202313600;

var  Yn=new  Array(arrLen);      //农历年的名称
Yn[0]="农历 ";Yn[1]="农历 ";Yn[2]="农历 ";
Yn[3]="农历 ";Yn[4]="农历 ";Yn[5]="农历 ";
Yn[6]="农历 ";Yn[7]="农历 ";Yn[8]="农历 ";
Yn[9]="农历 ";
var  D=new  Date();
var  yy=D.getYear();
var  mm=D.getMonth()+1;
var  dd=D.getDate();
var  ww=D.getDay();
if  (ww==0)  ww="<font  color=RED>星期日</font>";
if  (ww==1)  ww="星期一";
if  (ww==2)  ww="星期二";
if  (ww==3)  ww="星期三";
if  (ww==4)  ww="星期四";
if  (ww==5)  ww="星期五";
if  (ww==6)  ww="<font  color=green>星期六</font>";
ww=ww;
var  ss=parseInt(D.getTime()  /  1000);
if  (yy<100)  yy="19"+yy;

for  (i=0;i<arrLen;i++)
if  (ss>=Ys[i]){
iyear=i;
sValue=ss-Ys[i];        //当年的秒数
}
dayiy=parseInt(sValue/spd)+1;        //当年的天数

var  dpm=year1999;
if  (iyear==1)  dpm=year2000;
if  (iyear==2)  dpm=year2001;
if  (iyear==3)  dpm=year2002;
if  (iyear==4)  dpm=year2003;
if  (iyear==5)  dpm=year2004;
if  (iyear==6)  dpm=year2005;
if  (iyear==7)  dpm=year2006;
if  (iyear==8)  dpm=year2007;
if  (iyear==9)  dpm=year2008;
dpm=dpm.split(";");

var  Mn=month1999;
if  (iyear==2)  Mn=month2001;
if  (iyear==5)  Mn=month2004;
if  (iyear==7)  Mn=month2006;
Mn=Mn.split(";");

var  Dn="初一;初二;初三;初四;初五;初六;初七;初八;初九;初十;十一;十二;十三;十四;十五;十六;十七;十八;十九;二十;廿一;廿二;廿三;廿四;廿五;廿六;廿七;廿八;廿九;三十";
Dn=Dn.split(";");

dayim=dayiy;

var  total=new  Array(13);
total[0]=parseInt(dpm[0]);
for  (i=1;i<dpm.length-1;i++)  total[i]=parseInt(dpm[i])+total[i-1];
for  (i=dpm.length-1;i>0;i--)
if  (dayim>total[i-1]){
dayim=dayim-total[i-1];
miy=i;
}
bsWeek=ww;
bsDate=yy+"年"+mm+"月";
bsDate2=dd;
bsYear=Yn[iyear];
bsYear2=Mn[miy]+Dn[dayim-1];
if  (ss>=Ys[7]||ss<Ys[0])  bsYear=Yn[7];
function  time(){
document.write("<table  width='92' height='86' border='0' cellpadding='0' cellspacing='0'>" );
document.write("<tr><td  align='center'>"+bsDate+"<br><span  style='color:#FF0000'><b><font size='3'>"+bsDate2+"</font></b></span><br>");
document.write(bsWeek+"<br>");
document.write(""+bsYear+bsYear2+"</td></tr></table>");
}
</SCRIPT>

            <SCRIPT>time()</SCRIPT>
            </DIV></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width="50%" border=0>
        <TBODY>
        <TR>
          <TD height=3></TD></TR></TBODY></TABLE></DIV></TD></TR>
  <TR>
    <TD vAlign=bottom height=48>
      <TABLE cellSpacing=0 cellPadding=0 width=903 border=0>
        <TBODY>
        <TR>
          <TD><IMG height=48 alt="" src="imagine/nav_03.gif" 
          width=45></TD>
          <TD><IMG height=48 alt="" 
            src="imagine/nav_04.gif" width=84 border=0></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left2.htm';parent.mainFrame.location='/personal/personal/calendar.jsp';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_05.gif" width=88 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_05.gif" width=88 border=0></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left6.htm';parent.mainFrame.location='/workflow/workflow2/acceptProjectListAll.jsp';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_06.gif" width=87 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_06.gif" width=87 border=0></TD>
          <TD><IMG height=48 alt="" src="imagine/nav_07.gif" 
          width=88></TD>
          <TD><IMG height=48 alt="" src="imagine/nav_08.gif" 
          width=70></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left3.htm';parent.mainFrame.location='/content/content/contentListAction3.do?categoryId=SW_CONTENT_001001';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_09.gif" width=88 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_09.gif" width=88 border=0></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left4.htm';parent.mainFrame.location='/content/content/contentListAction3.do?categoryId=SW_CONTENT_002001';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_10.gif" width=87 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_10.gif" width=87 border=0></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left5.htm';parent.mainFrame.location='/content/content/contentListAction3.do?categoryId=SW_CONTENT_003001';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_11.gif" width=87 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_11.gif" width=87 border=0></TD>
          <TD><%--<A 
            onclick="parent.leftFrame.location='left9.htm';parent.mainFrame.location='/message/message/messageListAction.do?doType=2';return false;" 
            href="http://31.16.1.138:66/top.jsp#"><IMG height=48 alt="" 
            src="imagine/nav_12.gif" width=135 border=0></A>--%><IMG height=48 alt="" 
            src="imagine/nav_12.gif" width=135 border=0></TD>
          <TD><IMG height=48 alt="" src="imagine/nav_13.gif" 
          width=44></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
          <table width="1014" class="b" align="center" height="23"
										cellpadding="0" cellspacing="0" background="imagine/gdt-1.gif">
												
													<tr>
														<td width="120" class="xb" nowrap="nowrap">
									欢迎您
								<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION"))
							.getName()%>
														</td>
														<td class="xb" onclick="personOff();" onmouseover="this.style.cursor='hand'">个人公务</td>
														
														<td colspan="3">
												<marquee behavior="scroll" direction="left" scrollamount="3"
													style="font-size: 12px;color: 2c6b9e;"
													onMouseOver="this.stop();" onMouseOut="this.start();">
													<strong><jsp:include flush="true" page="tqbg.jsp" /></strong>
												</marquee>
											</td><td width="36" onmouseover="this.style.cursor='hand'">
															<img src="imagine/dl4.gif" width="36" height="20" onclick="logout();">
														</td>
													</tr>
									
											
					
					</table>
          </BODY></HTML>
