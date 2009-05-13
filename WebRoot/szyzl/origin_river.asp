<html>
<head>
<LINK href="../css/index-css.css" type=text/css rel=StyleSheet>
<meta http-equiv="refresh" content="300">
<SCRIPT LANGUAGE="Javascript">
		var tt;
		var tName = "";
		
		if (opener) {
			if (opener.name=="MapFrame") {
				tt = opener.parent.MapFrame;
			
				tName = "opener.parent.MapFrame.";
			} else {
				tt = opener;
				
				tName = "opener.";
			}
		} else {
			
			if (parent.MapFrame!=null) {
				tt = parent.MapFrame;
			
				tName = "parent.MapFrame.";
			} else {
				tt=document;
			}
		}
		
	function refreshmap(ii,xx,yy,xp,yp,content,imp) {
		name="layer_" + ii;
		/tt.lab_XX[ii] = xx;
		tt.lab_YY[ii] = yy;
		tt.lab_XP[ii] = xp;
		tt.lab_YP[ii] = yp;
		tt.lab_important[ii] = imp; 
		
		tt.replaceLayerContent(name, content); 
	}		
	
function hideold()  {
			if(tt.lab_num>0)
				{	
					for (ii=0;ii<tt.lab_num;ii++)
					{
						layername = "layer_" + ii ;
						tt.replaceLayerContent(name, ""); 
						tt.hideLayer(layername);
					}
				}
}
</script>
<title>咸潮监测</title>
<!-----<meta http-equiv="Content-Type" content="text/html; charset=gb2312">----->
</head>

<body background="./images/bg02.gif" text="#000000">
<script> hideold();</script><script> refreshmap(0,-24833.1577,68011.5541,5,-5,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left rowspan=2><strong>青龙港</strong></td><td><b>(高)</b></td><td bgcolor=#B3FFB3 align=center><font color=#000000><b>89.00</b></font></td></tr><tr><td><b>(低)</b></td><td bgcolor=#F6F64C align=center><font color=#FF0000><b>907.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(1,-22853.3778,54708.5028,5,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>崇头</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>29.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(2,-23666.1919,44251.7922,5,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>太仓石化</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>19.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(3,-7685.0713,42411.2217,5,-20,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>南门</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>22.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(4,13301.4564,31757.5271,5,-20,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>堡镇</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>24.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(5,-10646.0601,29707.3438,-70,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>长江取水口</strong></td></tr><tr><td bgcolor=#F6F64C align=center><font color=#FF0000><b>341.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(6,10309.3661,26565.8857,-50,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>青草沙A</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>26.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(7,13567.2977,26333.1761,5,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>青草沙B</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>15.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(8,7654.4844,16711.4916,5,-15,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>凌桥水厂</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>166.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(9,3096.0213,16116.3113,-55,-10,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>吴淞水厂</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>114.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(10,5336.4597,12172.3814,5,-5,'<form><table border=0 cellspacing=0 cellpadding=0><tr><td align=left><strong>闸北水厂</strong></td></tr><tr><td bgcolor=#B3FFB3 align=center><font color=#000000><b>139.00</b></font></td></tr></table></form>',1);</script><script> refreshmap(11,-14105.0352,-27905.5049,-3,-3,'<form><img src="legImgs/yuliangpaishuigongsi.gif"><strong> 松浦原水厂</strong><table cellSpacing=0 borderColorDark=#e4edf3 cellPadding=3 bgColor=#ffffff borderColorLight=#5999c8 border=1><tr><td align=center colspan=2><tr><td bgcolor=#B3FFB3 align=left><font color=#000000>黄浦江潮位</font></td><td bgcolor=#B3FFB3 align=right><font color=#000000>2.00m</font></td></tr><tr><td bgcolor=#B3FFB3 align=left><font color=#000000>原水浊度</font></td><td bgcolor=#B3FFB3 align=right><font color=#000000>47.80NTU</font></td></tr><tr><td bgcolor=#B3FFB3 align=left><font color=#000000>原水氨氮</font></td><td bgcolor=#B3FFB3 align=right><font color=#000000>1.30mg/L</font></td></tr><tr><td bgcolor=#B3FFB3 align=left><font color=#000000>原水溶解氧</font></td><td bgcolor=#B3FFB3 align=right><font color=#000000>2.14mg/L</font></td></tr></table></form>',1);</script><script> refreshmap(12,-1,-1,0,0,'<form><table border=0 align=left cellpadding=3 cellspacing=1 bgcolor=#a7b1ff><tr align=center bgcolor=#ffffff><td colspan=2><strong>原水监测图例<strong></td><tr align=center bgcolor=#ffffff><td><IMG alt=""  src="legImgs/yuliangpaishuigongsi.gif"></td><td>原水监测点</td></tr><tr align=center bgcolor=#ffffff><td><table border=0><tr><td bgcolor=#F6F64C><font color=#FF0000><b>250</b></font></td></tr></table></td><td>盐度大于250mg/L超标</td></tr> </table></form>',1);</script><script> tt.lab_num = 13;</script><script>tt.sendMapXML();</script>

<div valign="top" style="LEFT: 5px; RIGHT: 5px; POSITION: absolute; TOP: 0px">          
<form name="f1" method="post">
<TABLE align="center" width="100%" cellSpacing=0 borderColorDark=#e4edf3 cellPadding=0 align=center bgColor=#ffffff borderColorLight=#5999c8 border=0>
<tr><td>
<input type="hidden" name="datestr" value="2008-5-23">
</td></tr>
<tr height=2><td></td></tr>
</table>
<table width="100%" align="center">
<tr><td style="font-size:14px" align=center><b>5月27日原水监测信息</b></td></tr>
</table>
<SCRIPT language="Javascript">
	if(tt.hostTag>0)
	{
			document.write("<table width=100% align=center><tr><td align=left>");
			document.write("注:点击站名查询曲线");
			document.write("</td><td align=right>");
			document.write("<a style=\"cursor:hand\" onclick=\"javascript:show_details('detail/yuanshui_detail.asp');\" onmouseout=\"javascript:this.style.background='none';\" target = \"_blank\"><u><font color = blue>详细信息</font></u></a>");

			document.write("</td></tr></table>");
	}
</SCRIPT>
<table border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#a7b1ff">
<tr bgcolor="#ffffff" height=30><td class="a" rowspan=2>上游来水</td><td>
<SCRIPT language="Javascript">
	if(tt.hostTag>0)
		document.write("<a style=\"cursor:hand\" onclick=\"javascript:show_curve('detail/chartmain_cjls.asp?datatime=2008-5-23');\" target=_blank><font color=\"#0000ff\">大通流量</font></a>");
	else
		document.write("大通流量");
</SCRIPT>

</td><td align=center>8:00</td><td align=right>22800m3/s
</td></tr>
<tr bgcolor="#ffffff" height=30><td>
太浦闸流量</td><td align=center>8:00</td><td align=right>65m3/s
</td></tr>
</table>

</body>
</html>

<script language="vbscript">
  function seldate()
		Dim MyDate
		MyDate = showmodaldialog("./Calender.asp","","status:no;center:yes;help:no;minimize:no;maximize:no;dialogWidth:220px;dialogHeight:400px")
		if MyDate <> "" Then
			MyDate=cstr(cdate(MyDate))
		'	f1.action="rain_yaoce.asp?time1=" & MyDate & "&r_swzz=" & swzz & "&r_psb3=" & psb3
			F1.action="water_baoxun.asp?time1=" & MyDate 
			f1.submit 
		end if
	End function
   function CallPreviousDay()
       stm1 = CStr(CDate(f1.datestr.value)-1)
       F1.action="water_baoxun.asp?time1=" & stm1 
'	   F1.action="rain_yaoce.asp?time1=" & stm
	   F1.submit 
   end function
   function CallNextDay()
       stm1 = CStr(CDate(f1.datestr.value)+1)
       
       F1.action="water_baoxun.asp?time1=" & stm1 
'	   F1.action="rain_yaoce.asp?datestr=" & stm
	   F1.submit 
   end function 
</script>


<script LANGUAGE="javascript">
<!--
function show_details(myurl)
{
	var detail_window;
	detail_window = window.open( myurl, '详细信息', 'status=no,menubar=no,toolbar=no,location=no,left=0,top=0,width=650,height=600,scrollbars=yes,resizable=yes',true);
	detail_window.focus();

}

function show_curve(myurl)
{
	var detail_window;
	detail_window = window.open( myurl, '详细信息', 'status=no,menubar=no,toolbar=no,location=no,left=0,top=0,width=750,height=520,scrollbars=yes,resizable=yes',true);
	detail_window.focus();
	
}
//-->
</script>