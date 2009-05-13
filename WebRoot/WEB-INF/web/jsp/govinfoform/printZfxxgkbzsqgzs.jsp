<%@ page language="java" import="org.apache.struts.validator.DynaValidatorForm;" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infoId = request.getParameter("id");
String sqTime = (String)request.getAttribute("sqTime");
String dfTime = (String)request.getAttribute("dfTime");
String lsNo = (String)request.getAttribute("lsNo");
DynaValidatorForm form =(DynaValidatorForm)  request.getAttribute("form");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'printZfxxgkbzsqgzs.jsp' starting page</title>
    
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

<p class=MsoNormal align=center style='text-align:center;line-height:26.0pt;
mso-line-height-rule:exactly'><b><span style='font-size:18.0pt;font-family:
宋体'>政府信息公开补正申请告知书<span lang=EN-US><o:p></o:p></span></span></b></p>

<p class=MsoNormal align=right style='text-align:right;line-height:26.0pt;
mso-line-height-rule:exactly'><b><span lang=EN-US style='font-size:18.0pt;
font-family:华文中宋'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></b><span style='font-size:15.0pt;font-family:楷体_GB2312;
mso-bidi-font-weight:bold'>沪水务信补</span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>（</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'><%=lsNo.substring(0,4) %> </span></span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>）第</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=lsNo.substring(4,lsNo.length()) %> </span></span></u><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>号</span><b><span
lang=EN-US style='font-size:18.0pt;font-family:华文中宋'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></b><span lang=EN-US style='font-size:15.0pt;font-family:楷体_GB2312;
mso-bidi-font-weight:bold'><span style='mso-spacerun:yes'>&nbsp;&nbsp;</span></span><b><span
lang=EN-US style='font-size:18.0pt;font-family:华文中宋'><o:p></o:p></span></b></p>

<p class=MsoNormal><u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'><%=form.get("applicant") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</span></u><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0'><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>本机关（机构）于</span><u><span lang=EN-US
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:仿宋_GB2312'><span
style='mso-spacerun:yes'><%=sqTime.substring(0,4) %>&nbsp;&nbsp; </span></span></u><span
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
style='mso-spacerun:yes'><%=form.get("attr1") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span></u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>的申请。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>经审查，您（单位）填写的政府信息公开申请未明确特定政府信息的文件名称、文号或者其他特征描述。根据《中华人民共和国政府信息公开条例》第二十一条第（四）项、《上海市政府信息公开规定》第二十三条第（八）项的规定，请您（单位）在</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal><span lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:
12.0pt;mso-fareast-font-family:仿宋_GB2312'>10</span><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>个工作日内补正相关申请内容。逾期未补正的，视为放弃申请。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:22.5pt;mso-char-indent-count:1.5'><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>自本机关（机构）发出本告知书之日起至收到您（单位）补正申请之日止的期间，不计入本机关（机构）作出答复的期限。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt'><span style='font-size:15.0pt;
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

<p class=MsoNormal style='margin-right:15.0pt;text-indent:21.0pt;mso-char-indent-count:
2.0'><span style='mso-bidi-font-size:10.5pt;font-family:黑体'>使用指南：<span
lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal><span style='mso-bidi-font-size:10.5pt;font-family:楷体_GB2312'>本文本适用于《上海市政府信息公开规定》第二十三条第（八）项关于“政府信息公开申请内容不明确”情形的答复。</span></p>

</div>

</body>
</html>
