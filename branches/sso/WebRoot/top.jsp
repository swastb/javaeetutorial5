<%@ page language="java" import="java.util.*,java.lang.*,com.baosight.mode.TbUser,com.baosight.mode.TbUserdept"
	pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	String path = request.getContextPath();
    TbUser user=(TbUser)session.getAttribute("SYSTEM_USER_SESSION");
    System.out.println("top:"+user.getName());
    System.out.println("top:"+user.getUserAcc());
    String isfx = (String)request.getParameter("ISFXZHB");
    String commedName = request.getParameter("commedName");
 %>
<head>
	<script type="text/javascript">
function getXMLHTTPObj(){
	var xmlHttp = null;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return xmlHttp;
}

function logoutForums() {
	try{
		xmlHttp = getXMLHTTPObj();
		if( xmlHttp ){
			var url = "/JForum/user/logout.page";
			xmlHttp.open("GET", url, true);
			xmlHttp.onreadystatechange = new function(){};
			xmlHttp.send(null);
		}
	}catch (e){
	}
}

	function logout(){
		logoutForums();
		var path = document.getElementById("path").value;
		var loginType = document.getElementById("loginType").value;
		var url = path + "/loginoutAction.do?loginType="+loginType;
		window.open(url,"_self");
	}
function initMessage(){
	try{
		xmlHttp = getXMLHTTPObj();
		if( xmlHttp ){
			var url = "<%=path%>/messages.do?method=messageLogin";
			xmlHttp.open("GET", url, true);
			xmlHttp.onreadystatechange = doSetMessage;
			xmlHttp.send(null);
		}
	}catch (e){
	}
}
function doSetMessage(){
	if (xmlHttp.readyState == 4){
		var re = xmlHttp.responseText;
		//alert(re);
		if(re!="" && re.indexOf("</a>")<0){
			openMessage(re);
		}else if(re!=""){
			document.getElementById("newMessage").innerHTML = "您有新的消息："+re;
		}
	}
}
function openMessage(mid){
	window.open ('<%=path%>/messages.do?method=lookupMessages&id='+mid+'&source=receivers&forwardFlag=messagelogin', '新消息', 'height=240, width=400, top=100, left=100, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no');
}
function modPassWord() {
	var pop = window.open ('<%=path%>/userpwdaction.do?method=passwdModReq','newwindow', 'left=0,height=160, width=360, top=100, left=100, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no');
	//pop.moveTo((screen.width-360)/2,(screen.height-160)/2);
}
	</script>
	<!-- gcl实现菜单切换 -->
	<script type="text/javascript">
		function changeMenu(type){
			switch(type){
				case 'index':{
					document.getElementById('index').style.display="block";
					document.getElementById('zwzl').style.display="none";
					document.getElementById('fxzl').style.display="none";
					document.getElementById('szyzl').style.display="none";
					document.getElementById('bg').background="<%=path %>/images/top/center.png";
					break;
				}
				case 'zwzl':{
					document.getElementById('index').style.display="none";
					document.getElementById('zwzl').style.display="block";
					document.getElementById('fxzl').style.display="none";
					document.getElementById('szyzl').style.display="none";
					document.getElementById('bg').background="<%=path %>/images/top/center_zw.png";
					break;
				}
				case 'fxzl':{
					document.getElementById('index').style.display="none";
					document.getElementById('zwzl').style.display="none";
					document.getElementById('fxzl').style.display="block";
					document.getElementById('szyzl').style.display="none";
					document.getElementById('bg').background="<%=path %>/images/top/center_fx.png";
					break;
				}
				case 'szyzl':{
					document.getElementById('index').style.display="none";
					document.getElementById('zwzl').style.display="none";
					document.getElementById('fxzl').style.display="none";
					document.getElementById('szyzl').style.display="block";
					document.getElementById('bg').background="<%=path %>/images/top/center_szy.png";
					break;
				}
				default:{
					document.getElementById('index').style.display="block";
					document.getElementById('zwzl').style.display="none";
					document.getElementById('fxzl').style.display="none";
					document.getElementById('szyzl').style.display="none";
					document.getElementById('bg').background="<%=path %>/images/top/center.png";
					break;
				}
			}
			
		}
	</script>
	
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>上海水务</title>
<link href="css/index-css.css;css/style1.css" rel="stylesheet"
		type="text/css">
		
				<style>
*{font-size:12px}
.dragTable{
    font-size:12px;
    border-top:1px solid #3366cc;
    margin-bottom: 10px;
    width:100%;
    background-color:#FFFFFF;
}
.dragTR{
    cursor:move;
    color:#7787cc;
   
}

#parentTable{
    border-collapse:collapse;
    letter-spacing:25px;
}
.tabl_atab{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #2f475f;
	background-image: url(imagine/xx_tab1.gif);
	
	background-repeat:no-repeat;	
}
.tabl_atabno{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #8a95a1;
	
}
.tab2_atab{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #2f475f;
	
	background-image: url(imagine/xx_tab2.gif);
	background-repeat: no-repeat;
}
.tab2_atabno{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #8a95a1;
	
}
.tab3_atab{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #2f475f;
	
	background-image: url(imagine/xx_tab3.gif);
	background-repeat: no-repeat;
	
}
.tab3_atabno{
	font-family: "宋体";
	font-size: 12px;
	text-align: left;
	vertical-align: bottom;
	font-weight: bold;
	text-decoration: none;
	color: #8a95a1;
	
	background-image: url(xx_tab3a.gif);
	background-repeat: no-repeat;
	
}

</style>

</head>
<%String pic="logo_sw.png";
String isShow=isfx;
if(isfx.equals("true")!=true){
	if("b205f4e34f4f4d2da5bd89e2e10af37a".equals(user.getUserdept())){
		pic="logo_sw.png";
	}else if("f410b42455464f8487ee4f86da49b571".equals(user.getUserdept())){
		pic="logo_slzx.png";
	}else if("ae5532af92f8488994fb632c62423759".equals(user.getUserdept())){
		pic="logo_swfx.png";
	}
}else{
	pic="logo_fx.png";
}

 %>
<script type="text/javascript">
var sw="b205f4e34f4f4d2da5bd89e2e10af37a";
var userDept="<%=user.getUserdept()%>";
function init(){
	if(<%=isShow%>!=true){
		if(userDept==sw){
			document.getElementById('index').style.display="block";
			document.getElementById('fxzl').style.display="none";
			document.getElementById('bg').background="<%=path %>/images/top/center.png";
		}
		else{
			document.getElementById('index').style.display="block";
			document.getElementById('fxzl').style.display="none";
			document.getElementById('bg').background="<%=path %>/images/top/center.png";
		}
	}else{
			document.getElementById('index').style.display="none";
			document.getElementById('fxzl').style.display="block";
			document.getElementById('bg').background="<%=path %>/images/top/center_fx.png";
	}
}
function showMenu(){
	document.getElementById('menu').style.display="block";
	document.getElementById('bgRight').background="<%=path %>/images/top/top_c.png";
}
function hideMenu(){
	document.getElementById('menu').style.display="none";
	document.getElementById('bgRight').background="<%=path %>/images/top/top_r.png";
}

</script>

<body leftmargin="0" topmargin="0" onload="init();">
    <input type="hidden" id="loginUser" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getUserAcc()%>"/>
	<input type="hidden" id="password" value="<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getPwd()%>"/>
	<input type="hidden" id="path" value="<%=request.getContextPath() %>"/>
	<input type="hidden" id="loginType" value="<%=session.getAttribute("loginType") %>"/>
 <table width="1014" border="0" cellpadding="0" cellspacing="0"
			bgcolor="#FFFFFF" align="center">
			<tr>
				<td valign="top" height="140">
					<table width="1000" border="0" cellpadding="0" cellspacing="0" bordercolor="#0000FF">
  <tr>
    <td height="140"><table width="1000" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="27" background="<%=path %>/images/top/top.png"><table width="1000" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="820" height="27"><table width="820" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="27">&nbsp;</td>
                <td width="75" valign="middle"><img src="<%=path %>/images/top/point.png" width="7" height="5" />&nbsp;<a href="http://www.shanghai.gov.cn" target="_Blank">中国上海</a></td>
                <td width="88" valign="middle"><img src="<%=path %>/images/top/point.png" width="7" height="5" />&nbsp;<a href="#" target="_Blank">水利部网站</a></td>
                <td width="88" valign="middle"><img src="<%=path %>/images/top/point.png" width="7" height="5" />&nbsp;<a href="#" target="_Blank">建设部网站</a></td>
                <td width="75" valign="middle"><img src="<%=path %>/images/top/point.png" width="7" height="5" />&nbsp;<a href="http://www.shanghaiwater.gov.cn:7300/web/homepage/index.jsp" target="_Blank">水务网站</a></td>
                <td width="484" valign="middle" onmouseover="showMenu();" onmouseout="hideMenu();" onmousemove="showMenu();"><table width="484" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="4" height="18" background="<%=path %>/images/top/top_l.png"></td>
                    <td width="70" valign="middle" align="center" background="<%=path %>/images/top/top_c.png" >
                   		 <font color="#c14721">个性化定制</font>
                    </td>
                    <td width="16" align="left" valign="middle" background="<%=path %>/images/top/top_c.png"><img src="<%=path %>/images/top/arrow.gif" width="14" height="11" /></td>
                    <td id="bgRight" width="5" background="<%=path %>/images/top/top_r.png"></td>
                    <td width="389" >
                    	<table id="menu" style="display:none" width="389" border="0" cellspacing="0" cellpadding="0" >
                    		<tr height="18">
                    		<td width="62" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="<%=path %>/index.jsp" class="topmenu" onmouseover="changeMenu('index');" >门户首页</td>
	                        <td width="62" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="<%=path %>/zwzl/zwzl.jsp" class="topmenu" onmouseover="changeMenu('zwzl');">政务专栏</a></td>
	                        <td width="62" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="<%=path %>/fxzl/fxzl.jsp" class="topmenu" onmouseover="changeMenu('fxzl');">防汛专栏</a></td>
	                        <td width="74" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="<%=path %>/szyzl/szyzl.jsp" class="topmenu" onmouseover="changeMenu('szyzl');">水资源专栏</a></td>
	                        <td width="62" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="#" class="topmenu">海洋专栏</a></td>
	                        <td width="62" align="center" valign="middle" background="<%=path %>/images/top/top_c.png"><a href="http://31.16.1.74/website/shsw_webgis/viewer.htm" class="topmenu" target="_Blank">数字地图</a></td>
                    		<td width="5" background="<%=path %>/images/top/top_r.png"></td>
                    		</tr>
                    	</table>
                    </td>
                    </tr>
                   </table>
                 </td>
                <td width="5" align="center"></td>
              </tr>
            </table></td>
            <td><table width="180" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="90">
                    <input name="textfield" type="text" class="search" id="textfield" />                </td>
                <td valign="bottom">&nbsp;<img src="<%=path %>/images/top/search.png" width="73" height="17" onmouseover="this.style.cursor='hand'" /></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="89"><table width="1014" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="235" height="89" background="<%=path %>/images/top/<%=pic %>">&nbsp;</td>
            <td width="655"><table width="655" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="6" background="<%=path %>/images/top/top_m.png"></td>
              </tr>
              <tr>
                <td height="76" id="bg" background="<%=path %>/images/top/center.png" align="center">
                
                 <!-- 门户首页 -->
                <table id="index"  style="display:block" width="600" border="0" cellpadding="0"
													cellspacing="0" >
													<tr  >
														<td width="60"  align="left" class="top_infor">
															<a class="toptablemeun"
																href="<%=path %>/index.jsp"
																target="_blank">&nbsp;&nbsp;门户首页</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun"
																href="http://www.shanghaiwater.gov.cn/web/wsbsdefault.jsp"
																target="_blank">网上办事</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="<%=path %>/infopubContentaction.do?method=fxdt_more&name=防汛动态&code=fxdt"
																target="_blank">防汛动态</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="http://31.16.1.7/fx/qxxx/default.jsp?id=6" target="_blank">气象信息</a>

														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="http://31.16.1.41"
																target="_blank">水情信息 </a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=szydt_more&name=水资源动态&code=szydt" target="_blank">水资源动态</a>
															
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="http://31.16.1.138:7001/oademo/CAsoft.zip"
																target="_blank">相关软件</a>
														</td>
														</tr><tr>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=新闻中心&code=xwzx" target="_blank">&nbsp;&nbsp;水务新闻</a>
														</td>
													<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left"> 
															<a class="toptablemeun"
																href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=信息公开&code=xxgk"
																target="_blank">信息公开</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=区县动态&code=qxdt"
																target="_blank">区县动态 </a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="#"
																target="_blank">风情信息</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="#"
																target="_blank">雨情信息</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="62" class="top_infor" align="left">
															<a class="toptablemeun"
																href="#"
																target="_blank">水资源监测</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="#" target="_blank">培训手册</a>
															
														</td>
														</tr><tr>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun"
																href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水务情况&code=watersituation"
																target="_blank">&nbsp;&nbsp;水务情况</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=网站动态&code=wzdt"
																target="_blank">网站动态</a>
														</td>
													<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun"
																href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=汛情通告&code=xqtg"
																target="_blank">汛情通告</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="#"
																target="_blank">云情信息</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="#"
																target="_blank">工情信息 </a>
														</td>
													<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=水资源预警&code=szyyj"
																target="_blank">水资源预警</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="#" target="_blank"></a>
															
														</td>
														</tr><tr>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水务动态&code=swdt" target="_blank">&nbsp;&nbsp;水务动态 </a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun" href="#" target="_blank">信息化动态</a>



															
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="64" class="top_infor" align="left">
															<a class="toptablemeun"
																href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水情通报&code=sqtb"
																target="_blank">水情通报</a>
														</td>
													<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left"> 
															<a class="toptablemeun"
																href="http://31.16.1.74/website/taifeng/viewer.htm"
																target="_blank">台风路径</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left"> 
															<a class="toptablemeun"
																href="http://31.16.1.7/zqkb.jsp"
																target="_blank">灾情信息</a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="60" class="top_infor" align="left">
															<a class="toptablemeun"
																href="#"
																target="_blank">水资源评价 </a>
														</td>
														<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
														<td width="54" class="top_infor" align="left">
															<a class="toptablemeun" href="#" target="_blank"></a>
															
														</td>
													</tr>

												</table>
                			<!-- 政务专栏 -->
                 <table id="zwzl"  style="display:none" width="500" border="0" cellpadding="0" cellspacing="0" >
                                <tr> 
                                  <td  width="63" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=新闻中心&code=xwzx" target="_blank">水务新闻</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td  width="88" class="top_infor"><a class="toptablemeun" href="http://www.shanghaiwater.gov.cn/web/wsbsdefault.jsp" target="_blank">网上办事</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td  width="75" class="top_infor"><a class="toptablemeun" href="#" target="_blank">信息化动态</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td  width="92" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=fxdt_more&name=防汛动态&code=fxdt" target="_blank">防汛动态</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td  width="88" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=史志年鉴&code=sznj" target="_blank">史志年鉴</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="68" class="top_infor"><a class="toptablemeun" href="#" target="_blank">政风行风</a></td>
                                  
                                </tr>
                                <tr> 
                                  <td  class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水务情况&code=watersituation" target="_blank">水务情况</a></td>
                                 <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=信息公开&code=xxgk" target="_blank">信息公开</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源动态&code=szydt" target="_blank">水资源动态</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=汛情通告&code=xqtg" target="_blank">汛情通告</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=大事记&code=dsj" target="_blank">大事记</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=公示&code=gongshi" target="_blank">公示</a></td>
                                  
                                </tr>
                                <tr> 
                                  <td  class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水务动态&code=swdt" target="_blank">水务动态</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=网站动态&code=wzdt" target="_blank">网站动态</a></td>
                                 <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源公报&code=szygb" target="_blank">水资源公报</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水情通报&code=sqtb" target="_blank">水情通报</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水务杂志&code=swzz" target="_blank">水务杂志</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=法律法规&code=law" target="_blank">法律法规</a></td>
                             </tr>
                            
                              </table>
                <!-- 防汛专栏 -->
                	<table id="fxzl"  style="display:none" width="500" border="0" cellpadding="0"
																		cellspacing="0">
																		<tr>
																		<td width="55" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.7/fx/news/list_ssxw.jsp"
																					target="_blank">防汛动态</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="54" nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=重要文件&code=zywj"
																					target="_blank">重要文件</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="55" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.7/fx/qxxx/default.jsp?id=6"
																					target="_blank">气象报告</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="54" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.41/"
																					target="_blank">水情信息</a>
																			</td>
																		<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="54" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.7/fx/yuan/yuan.jsp"
																					target="_blank" onClick="">应急预案</a>
																			</td>
														</tr><tr>
																			<td width="54" nowrap class="top_infor">
																				
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=汛情通告&code=xqtg"
																					target="_blank">汛情通告</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="54" nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=各地防汛&code=gdfx" 
																				target="_blank">各地防汛</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="54" nowrap class="top_infor">
																				<a class="toptablemeun" href="#" 
																				target="_blank">风情信息</a>
																			</td>
															
																			

																										<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																		<td width="53" nowrap class="top_infor">
																				<a class="toptablemeun" href="#" target="_blank">雨情信息</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="53" nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=防汛知识&code=fxzs"
																					target="_blank">防汛知识</a>
																			</td>
														</tr><tr>
																			<td width="55" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.41/"
																					target="_blank">水情信息</a>
																				
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=交流交往&code=jljw"
																					target="_blank">交流交往</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="55" nowrap class="top_infor">
																				<a class="toptablemeun" href="#"
																					target="_blank">云情信息</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td nowrap class="top_infor">
																				<a class="toptablemeun" href="#"
																					target="_blank">工情信息</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.7/fx/zcfg//fxlc.jsp"
																					target="_blank">防汛历程</a>
																			</td>
															</tr><tr>
																			<td nowrap class="top_infor">
																					<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=区县动态&code=qxdt"
																					target="_blank">区县动态</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=重大活动&code=zdhd"
																					target="_blank">重大活动</a>
																			</td>
																		<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td nowrap class="top_infor">
																				<a class="toptablemeun"  href="http://31.16.1.74/website/taifeng/"
																					target="_blank">台风路径</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="53" nowrap class="top_infor">
																				<a class="toptablemeun" href="http://31.16.1.7/zqkb.jsp"
																					target="_blank">灾情信息</a>
																			</td>
																			<td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
																			<td width="53" nowrap class="top_infor">
																				<a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=政策法规&code=law"
																				target="_blank">政策法规</a>
																			</td>


																		</tr>
																		
																	</table>
							<!--水资源专栏 -->
                		<table id="szyzl"  style="display:none" width="600" border="0" cellpadding="0" cellspacing="0">
                                <tr> 
                                  <td width="65" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源动态&code=szydt" target="_blank">水资源动态</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="66" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=长江原水&code=cjys" target="_blank">长江原水</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="59" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水厂压力&code=scyl" target="_blank">水厂压力</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="73" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=骨干河道水质&code=gghdsz" target="_blank">骨干河道水质</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="78" class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=雨量基础评价&code=yljcpj" target="_blank">雨量基础评价</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td width="119" class="top_infor"><a class="toptablemeun" href="#">公共信息平台</a></td>
                                  
                                </tr>
                                <tr> 
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源预警&code=szyyj" target="_blank">水资源预警</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=黄浦江原水&code=hpjys" target="_blank">黄浦江原水</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=泵站压力&code=bzyl" target="_blank">泵站压力</a></td>
                                 <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水功能区达标&code=sgnqdb" target="_blank">水功能区达标</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水位利用评价&code=swlypj" target="_blank">水位利用评价</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源统计报表&code=syztjbb" target="_blank">水资源统计报表</a></td>
                                  
                                </tr>
                                <tr> 
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水资源公报&code=szygb" target="_blank">水资源公报</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=上游来水&code=syls" target="_blank">上游来水</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=管网压力&code=gwyl" target="_blank">管网压力</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水质趋势&code=szqs" target="_blank">水质趋势</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															|
														</td>
                                  <td class="top_infor"><a class="toptablemeun" href="<%=path %>/infopubContentaction.do?method=wzdt_more&name=水量利用评价&code=sllypj" target="_blank">水量利用评价</a></td>
                                  <td width="11" align="center" class="top_infor" style="color: #fff">
															
														</td>
                                  <td class="top_infor"></td>
                                </tr>
							  </table>
                					
                
                
                
                
                
                
                
                </td>
              </tr>
              <tr>
                <td height="7" background="<%=path %>/images/top/top_b.png">
                </td>
              </tr>
            </table></td>
            <td width="124" height="76" valign="middle" align="right" background="<%=path %>/images/top/right.png">
            <jsp:include flush="true" page="imagine/clock6.htm"></jsp:include>
            </td>
            </tr>
            </table>
        </td>
      </tr>
      <tr>
        <td height="24" valign="bottom"  background="<%=path %>/images/top/bottom_sy3.png">
 <table width="1014" border="0" cellspacing="0" cellpadding="0">
        <tr><td height="1" bgcolor="#dcdcdc"></td></tr>
          <tr>
            <td height="24" background="">
            <table width="100%" class="b" align="left" height="23"
							cellpadding="0" cellspacing="0">
							
							<tr>
								<td width="480" class="b">
									<table width="1000" class="b" align="left" height="23"
										cellpadding="0" cellspacing="0" >
												
													<tr>
														<td width="300" class="xb" nowrap="nowrap" align="center">
														欢迎您 
										<%
											if (commedName == null || "null".equals(commedName)) {%>
											<%=((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getName()%>
											<%}
											else {%><%=commedName+" 受"+((TbUser) session.getAttribute("SYSTEM_USER_SESSION")).getName()+"委托"%><%}
										 %>
										 &nbsp;&nbsp;
										 <span onclick="javascript:modPassWord();" style="color:red" onmouseover="this.style.cursor='hand'">修改密码</span>
										 &nbsp;&nbsp;
										 <a href="right.jsp" target="rightFrame" class="topmenu">【回到首页】</a>
														</td>
														<td colspan="2" >
												<marquee behavior="scroll" direction="left" scrollamount="3"
													style="font-size: 12px;color: 2c6b9e;"
													onMouseOver="this.stop();" onMouseOut="this.start();">
													<span id="newMessage"></span>
												</marquee>
											</td>
									
														<td width="36" >
															<a href="#"><img src="images/tc.gif" width="50" height="19" onclick="logout();" border="0" onmouseover="this.style.cursor='hand'"></a>&nbsp;
														</td>
													</tr>
									
											
					
					</table></td></table>
						
						</td>
        </tr>
    </table></td>
  </tr>
</table>
					
					
					
					</td></tr></table>


</body>
<script>
initMessage();
</script>
</html>
