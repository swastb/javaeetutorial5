
<html>
<head>
<script language="javascript"> 
function subchk() // 
{ 
document.form1.content.value= window.content_html.getHTML(); 
alert("jjj--"+document.form1.content.value);
} 
</script> 

</head>
<body>
<form name="form1" action="">
<table>
<tr>
<td width="100%">
<IFRAME ID="eWebEditor1" name="content_html" src="../web/eWebEditor/eWebEditor.jsp?id=content&style=standard" frameborder="0" scrolling="no" width="650" height="350"></IFRAME> 
<input type="hidden" name="content" /> 
</td>
</tr>
</table>

<input type="button" value="tijiao" onclick=" subchk()"/>
</form>
</body>
</html>