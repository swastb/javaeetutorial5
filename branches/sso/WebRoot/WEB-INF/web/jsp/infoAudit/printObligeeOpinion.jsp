<%@ page language="java" import="org.apache.struts.validator.DynaValidatorForm;" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
DynaValidatorForm form =(DynaValidatorForm)  request.getAttribute("form");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
    <link href="<%=path %>/css/govinfoform.css" rel="stylesheet" type="text/css">
    <script src="../../../../javascript/validate.js"></script>
	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

  </head>
 <body lang=ZH-CN style='tab-interval:21.0pt;text-justify-trim:punctuation'>
  <html:form action="/obligeeOpinion.do">
<div class=Section1 style='layout-grid:15.6pt'>

<p class=MsoNormal align=center style='text-align:center;line-height:26.0pt;
mso-line-height-rule:exactly'><b><span style='font-size:18.0pt;font-family:
宋体'>权利人意见征询单</span></b><b><span lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:
12.0pt'><span style='mso-spacerun:yes'>&nbsp;&nbsp; </span></span></b><b><span
lang=EN-US style='font-size:18.0pt;font-family:宋体'><o:p></o:p></span></b></p>

<p class=MsoNormal align=right style='text-align:right;word-break:break-all'><span style='font-size:15.0pt;
font-family:楷体_GB2312;mso-bidi-font-weight:bold'>沪水务征询</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>（</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("year") %> </span></span><span style='font-size:
15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:
"Times New Roman"'>）第</span><u><span lang=EN-US style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("autoNo") %> </span></span></u><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>号</span><span
style='font-size:15.0pt;font-family:楷体_GB2312;mso-bidi-font-weight:bold'> <span
style='mso-spacerun:yes'>&nbsp;</span></span><span lang=EN-US style='font-size:
15.0pt;font-family:仿宋_GB2312;mso-bidi-font-weight:bold'><o:p></o:p></span></p>

<p class=MsoNormal style='line-height:24.0pt;mso-line-height-rule:exactly'><u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'><%=form.get("consultName") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>：</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>本机关（机构）在处理政府信息公开申请工作中，经审查发现，申请公开的关于</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("contentMsg") %>
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>的政府信</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'>
</span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>息：</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312'><html:checkbox property="involveMsg" value="1"></html:checkbox></span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>涉及您个人的信息</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>&nbsp; </span><span
style='mso-spacerun:yes'>&nbsp;</span></span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><html:checkbox property="involveMsg" value="2"></html:checkbox></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>涉及您单位的信息</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>根据《中华人民共和国政府信息公开条例》第二十三条、《上海市政府信息公开规定》第十二条第二款的规定，需征求您（单位）的意见。您（单位）的意见是：</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312'><html:checkbox property="opinion" value="1"></html:checkbox></span><span style='font-size:15.0pt;font-family:仿宋_GB2312;
mso-bidi-font-weight:bold'>同意向申请人提供<span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp;&nbsp; </span></span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><html:checkbox property="opinion" value="2"></html:checkbox></span><span
style='font-size:15.0pt;font-family:仿宋_GB2312;mso-bidi-font-weight:bold'>不同意向申请人提供<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:24.0pt;mso-line-height-rule:
exactly'><span lang=EN-US style='font-size:15.0pt;font-family:仿宋_GB2312;
mso-bidi-font-weight:bold'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='text-indent:15.0pt;mso-char-indent-count:1.0;
line-height:24.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>请您（单位）在</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("replyYear") %>&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("replyMonth") %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("replyDay") %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日前予以答复，并将意见邮寄至本机关（机构），（地址：</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("address") %>
</span><span style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;</span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>，邮政编码：</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("postalcode") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>）。</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:22.0pt;mso-line-height-rule:exactly'><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;text-indent:86.25pt'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("signYear") %>
</span></span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("signMonth") %>&nbsp;&nbsp; </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("signDay") %>&nbsp;&nbsp; </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='mso-bidi-font-size:10.5pt;font-family:黑体'>使用指南：<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>本文本适用于《上海市政府信息公开规定》第十二条第二款关于“对涉及商业秘密、个人隐私的政府信息需征询权利人意见”的情形。</span><b><span
lang=EN-US style='font-size:22.0pt;mso-bidi-font-size:12.0pt'><o:p></o:p></span></b></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>
</div>
</html:form>
</body>
</html>

