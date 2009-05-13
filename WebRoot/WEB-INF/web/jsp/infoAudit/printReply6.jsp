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
<html:form action="/reply6.do"> 
<div class=Section1 style='layout-grid:15.6pt'>
<p class=MsoNormal align=center style='text-align:center;line-height:26.0pt;
mso-line-height-rule:exactly'><b><span style='font-size:18.0pt;font-family:
宋体'>政府信息公开申请答复书（六）</span></b><b><span lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:
12.0pt'><span style='mso-spacerun:yes'>&nbsp;&nbsp; </span></span></b><b><span
lang=EN-US style='font-size:18.0pt;font-family:宋体'><o:p></o:p></span></b></p>


<p class=MsoNormal align=right style='text-align:right;
line-height:20.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
font-family:楷体_GB2312;mso-bidi-font-weight:bold'>　 沪水务部答</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>（</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("year") %> </span></span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>）第</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("applyNo") %> </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>号</span><span lang=EN-US
style='font-size:15.0pt;font-family:楷体_GB2312;mso-bidi-font-weight:bold'><span
style='mso-spacerun:yes'>&nbsp; </span></span><span lang=EN-US
style='font-size:15.0pt;font-family:仿宋_GB2312;mso-bidi-font-weight:bold'><o:p></o:p></span></p>

<p class=MsoNormal style='line-height:20.0pt;mso-line-height-rule:exactly'><u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'><%=form.get("applicant") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：</span></u><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:20.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>本机关（机构）于</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("applyYear") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("applyMonth") %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("applyDay") %>&nbsp;&nbsp; </span></span></u><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日收到了您（单位）要求获取</span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("applyTitle") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>的申请。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:20.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>经审查，您（单位）申请获取的政府信息中有部分内容属于</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:20.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><html:checkbox property="type" value="1"></html:checkbox> 国家秘密<span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp; </span></span><html:checkbox property="type" value="2"></html:checkbox>商业秘密<span lang=EN-US><span
style='mso-spacerun:yes'>&nbsp; </span></span><html:checkbox property="type" value="3"></html:checkbox>个人隐私 <html:checkbox property="type" value="4"></html:checkbox>法律法规规定的不予公开的其他情形<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:20.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>根据《中华人民共和国政府信息公开条例》第二十二条、《上海市政府信息公开规定》第二十三条第（六）项的规定，本机关（机构）对该部分信息不予公开，其余信息予以公开。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:20.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>对属于公开范围的政府信息，根据《上海市政府信息公开规定》第二十六条的规定，</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><html:checkbox property="sendWay" value="1"></html:checkbox>本机关将当场提供
<span style='mso-spacerun:yes'>&nbsp;</span> <html:checkbox property="sendWay" value="2"></html:checkbox>通过电子邮件 <html:checkbox property="sendWay" value="3"></html:checkbox>邮寄方式 </span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>予以提供。</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>如对本答复不服，可以在收到本答复之日起</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'>60</span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>日内向上海市人民政府</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'>
</span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>或者中华人民共和国水利部申请行政复议，或者在</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'>3</span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>个月内向人民法院提起行政诉讼。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:20.0pt;mso-line-height-rule:
exactly'><span lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
mso-fareast-font-family:仿宋_GB2312'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;text-indent:86.25pt'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("signYear") %>
</span></span><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>年</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=form.get("signMonth") %> </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>月</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=form.get("signDay") %> </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>日</span><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0;
line-height:21.0pt;mso-line-height-rule:exactly'><span style='mso-bidi-font-size:
10.5pt;font-family:黑体'>使用指南：<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>本文本适用于《上海市政府信息公开规定》第二十三条第（六）项关于“含有不应当公开的内容，但能够区分处理，应当部分告知申请人；对不予公开的，应当说明理由的”情形的答复。<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
lang=EN-US style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal style='line-height:21.0pt;mso-line-height-rule:exactly'><b><span
lang=EN-US style='font-size:12.0pt;font-family:楷体_GB2312;mso-hansi-font-family:
华文中宋'><o:p>&nbsp;</o:p></span></b></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>
</div>
</html:form>
</body>
</html>


