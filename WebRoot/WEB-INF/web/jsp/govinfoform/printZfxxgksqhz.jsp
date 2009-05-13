<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
String sqTime = (String)request.getAttribute("sqTime");
String year = (String)request.getAttribute("year");
String no = (String)request.getAttribute("no");
String attr1 = (String)request.getAttribute("attr1");
String dfTime = (String)request.getAttribute("dfTime");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'printZfxxgksqhz.jsp' starting page</title>
    
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
style='font-size:18.0pt;font-family:宋体'>政府信息公开申请收件回执<span
lang=EN-US><o:p></o:p></span></span></b></p>

<p class=MsoNormal align=right style='text-align:right;
mso-char-indent-count:3.0'><span style='font-size:15.0pt;font-family:楷体_GB2312;
mso-bidi-font-weight:bold'>沪水务信收</span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>（</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>${year } </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>）第</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'>${no } </span></span></u><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>号</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>&nbsp; </span><o:p></o:p></span></p>

<p class=MsoNormal><u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>${applicant }&nbsp;&nbsp;&nbsp;&nbsp;：</span></u><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
style='font-size:15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>本机关（机构）于</span><u><span
lang=EN-US style='font-size:15.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(0,4) %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><u><span
lang=EN-US style='font-size:15.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(5,7) %>&nbsp; </span></span></u><span style='font-size:
15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>月</span><u><span
lang=EN-US style='font-size:15.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(8,10) %>&nbsp; </span></span></u><span style='font-size:
15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>日收到您（单位）</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>提出要求获取<u>${applyManner }　　　　　　　　　　　　　　　　　　　　</u>的申请。</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='margin-left:30.0pt'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>特此告知。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;text-indent:86.25pt'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%="".equals(dfTime) ? "" :dfTime.substring(0,4)%>&nbsp;
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

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='mso-bidi-font-size:10.5pt;font-family:黑体'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='mso-bidi-font-size:10.5pt;font-family:黑体'>使用指南：<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>1</span><span
style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>、本文本适用于行政机关对申请人提出政府信息公开申请的受理行为。<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>2</span><span
style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>、根据工作实际需要，行政机关可以直接出具政府信息公开申请答复书<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>

</body>
</html>
