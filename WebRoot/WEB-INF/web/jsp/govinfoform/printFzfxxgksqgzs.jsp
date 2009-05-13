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
    
    <title>My JSP 'printFzfxxgksqgzs.jsp' starting page</title>
    
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

<p class=MsoNormal align=center style='margin-right:15.0pt;text-align:center'><b><span
style='font-size:18.0pt;font-family:宋体'>非政府信息公开申请告知书<span lang=EN-US><o:p></o:p></span></span></b></p>

<p class=MsoNormal align=right style='text-align:right;'><span style='font-size:
15.0pt;font-family:仿宋_GB2312;mso-bidi-font-weight:bold'>沪水务非申告（<span
lang=EN-US><span style='mso-spacerun:yes'><%=lsNo.substring(0,4) %> </span></span>）第<u><span
lang=EN-US><span style='mso-spacerun:yes'><%=lsNo.substring(4,lsNo.length()) %> </span></span></u>号</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span style='mso-spacerun:yes'>&nbsp; </span></span><span
lang=EN-US style='font-size:15.0pt;font-family:仿宋_GB2312;mso-bidi-font-weight:
bold'><o:p></o:p></span></p>

<p class=MsoNormal><u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'><%=form.get("applicant") %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</span></u><u><span
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
15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>日收到您（单位）通过</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312'><%if(null!=form.get("attr2") && form.get("attr2").equals("17")){ %><input type="checkbox" name="attr2" id="attr2" value="50" checked disabled="disabled"/><%}else { %><input type="checkbox" name="attr2" id="attr2" value="50" disabled="disabled"/><%} %>电子邮件<span
lang=EN-US><span style='mso-spacerun:yes'>&nbsp; </span></span><%if(null!=form.get("attr2") && form.get("attr2").equals("20")){ %><input type="checkbox" name="attr2" id="attr2" value="10" checked/><%}else { %><input type="checkbox" name="attr2" id="attr2" value="10" /><%} %>邮寄<span
lang=EN-US><span style='mso-spacerun:yes'>&nbsp; </span></span><%if(null!=form.get("attr2") && form.get("attr2").equals("19")){ %><input type="checkbox" name="attr2" id="attr2" value="20" checked/><%}else { %><input type="checkbox" name="attr2" id="attr2" value="20" /><%} %>传真<span
lang=EN-US><span style='mso-spacerun:yes'>&nbsp; </span></span><%if(null!=form.get("attr2") && form.get("attr2").equals("21")){ %><input type="checkbox" name="attr2" id="attr2" value="30" checked/><%}else { %><input type="checkbox" name="attr2" id="attr2" value="30" /><%} %>当面领取<span
lang=EN-US><span style='mso-spacerun:yes'>&nbsp; </span></span><%if(null!=form.get("attr2") && form.get("attr2").equals("18")){ %><input type="checkbox" name="attr2" id="attr2" value="40" checked/><%}else { %><input type="checkbox" name="attr2" id="attr2" value="40" /><%} %>现</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>场查阅提出要求获取<u><span
style='mso-spacerun:yes'><%=form.get("attr1") %>
</span>　　　</u><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;
font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>的材料。</span></span><u><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></u></p>

<p class=MsoNormal style='text-indent:30.0pt;line-height:25.0pt;mso-line-height-rule:
exactly'><span style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:
仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>经审查，</span><span
style='font-size:15.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>您提交的材料不符合</span><span
style='font-size:15.0pt;mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;
mso-ascii-font-family:"Times New Roman"'>《上海市政府信息公开规定》第二十一条规定的政府信息公开的申请要求，不适用于《上海市政府信息公开规定》，本机关不再按照《上海市政府信息公开规定》作出答复。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal style='text-indent:30.0pt;mso-char-indent-count:2.0;
line-height:25.0pt;mso-line-height-rule:exactly'><span style='font-size:15.0pt;
mso-bidi-font-size:12.0pt;font-family:仿宋_GB2312;mso-ascii-font-family:"Times New Roman"'>特此告知。</span><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><o:p></o:p></span></p>

<p class=MsoNormal align=right style='text-align:right;word-break:break-all'><span
lang=EN-US style='font-size:15.0pt;mso-bidi-font-size:12.0pt;mso-fareast-font-family:
仿宋_GB2312'><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span><span
style='mso-spacerun:yes'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><o:p></o:p></span></p>

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

<p class=MsoNormal align=center style='text-align:center;text-indent:86.25pt'><span
lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal align=center style='text-align:center;text-indent:86.25pt'><span
lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal align=center style='text-align:center;text-indent:86.25pt'><span
lang=EN-US><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span style='font-family:黑体'>使用指南：<span lang=EN-US><o:p></o:p></span></span></p>

<p class=MsoNormal style='text-indent:21.0pt;mso-char-indent-count:2.0'><span
style='font-family:仿宋_GB2312'>本文本适用于公民、法人或其他组织提交的书面材料中，未按照《中华人民共和国政府信息公开条例》和《上海市政府信息规定》的规定，提出任何政府信息公开申请事项。</span></p>

<p class=MsoNormal><span lang=EN-US style='mso-bidi-font-size:10.5pt;
font-family:楷体_GB2312'><o:p>&nbsp;</o:p></span></p>

<p class=MsoNormal><span lang=EN-US><o:p>&nbsp;</o:p></span></p>

</div>

</body>

</html>
