<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
String sqTime = (String)request.getAttribute("sqTime");
String year = (String)request.getAttribute("year");
String no = (String)request.getAttribute("no");
String applyManner = (String)request.getAttribute("applyManner");
String attr1 = (String)request.getAttribute("attr1");
String dfTime = (String)request.getAttribute("dfTime");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'printZfxxgksqdfs1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body lang=ZH-CN link=blue vlink=purple style='tab-interval:21.0pt;text-justify-trim:
punctuation'>

<div class=Section1 style='layout-grid:15.6pt'>

<p class=MsoNormal align=center style='text-align:center'><b><span
style='font-size:18.0pt;font-family:宋体'>政府信息公开申请答复书（一）<span lang=EN-US><o:p></o:p></span></span></b></p>

<p class=MsoNormal align=right style='text-align:right;
mso-char-indent-count:3.0'><span style='font-size:15.0pt;font-family:楷体_GB2312;
mso-bidi-font-weight:bold'>沪水务信答</span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>（</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>${year } </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>）第</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'>${no } </span></span></u><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>号</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='line-height:25.0pt;mso-line-height-rule:exactly'><u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>${applicant }&nbsp;&nbsp;&nbsp;&nbsp;：</span></u><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>本机关（机构）于</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=sqTime.substring(0,4) %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>年</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(5,7) %>&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(8,10) %>&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日收到了您（单位）要求获取</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'>${applyManner }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>的申请。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp; </span></span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体;
color:#3366FF'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>经审查，现答复如下：</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'><%if(null!=request.getAttribute("offer1") && request.getAttribute("offer1").equals("1")){ %><input type="checkbox" name="offer1" id="offer1" value="1" checked/><%}else { %><input type="checkbox" name="offer1" id="offer1" value="1" /><%} %>您（单位）要求获取的信息属于《中华人民共和国政府信息公开条例》第九条、《上海市政府信息公开规定》第十一条规定的主动公开的政府信息<span
style='color:red'>。您（单位）可以通过上海水务网（</span></span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312;
color:red'><a href="http://www.shanghai.gov.cn/"><span style='color:red'>www.shanghaiwater.gov.cn</span></a></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman";color:red'>获取。</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:25.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'><%if(null!=request.getAttribute("offer1") && request.getAttribute("offer1").equals("2")){ %><input type="checkbox" name="offer1" id="offer1" value="2" checked/><%}else { %><input type="checkbox" name="offer1" id="offer1" value="2" /><%} %>您（单位）要求获取的信息属于本机关（机构）依申请公开的政府信息。<span
style='color:red'>根据《上海市政府信息公开规定》第二十六条的规定，</span></span><span style='font-size:
15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;color:red'><%if(null!=request.getAttribute("offer2") && request.getAttribute("offer2").equals("1")){ %><input type="checkbox" name="offer2" id="offer2" value="1" checked/><%}else { %><input type="checkbox" name="offer2" id="offer2" value="1" /><%} %>本机关将当场提供<span
lang=EN-US><span style='mso-spacerun:yes'>&nbsp; </span></span><%if(null!=request.getAttribute("offer2") && request.getAttribute("offer2").equals("2")){ %><input type="checkbox" name="offer2" id="offer2" value="2" checked/><%}else { %><input type="checkbox" name="offer2" id="offer2" value="2" /><%} %>本机关将通过电子邮件 <%if(null!=request.getAttribute("offer2") && request.getAttribute("offer2").equals("3")){ %><input type="checkbox" name="offer2" id="offer2" value="3" checked/><%}else { %><input type="checkbox" name="offer2" id="offer2" value="3" /><%} %>邮寄方式</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman";color:red'> &nbsp;予以提供。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>特此告知。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;text-indent:86.25pt'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=dfTime.equals("")?"":dfTime.substring(0,4) %>&nbsp;&nbsp;
</span></span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=dfTime.equals("")?"":dfTime.substring(5,7) %>&nbsp; </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=dfTime.equals("")?"":dfTime.substring(8,10) %>&nbsp; </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal><span lang=EN-US style='mso-bidi-font-size:10.5pt;
font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='mso-bidi-font-size:10.5pt;font-family:黑体'>使用指南：<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>1</span><span
style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>、本文本适用于《上海市政府信息公开规定》第二十三条第（一）项关于“属于行政机关（机构）政府信息公开范围”情形以及第二十六规定的答复。<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>

</body>

</html>
