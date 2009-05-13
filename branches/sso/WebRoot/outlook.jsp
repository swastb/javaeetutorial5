<%@ page language="java" import="java.util.*,com.baosight.mode.TbFunction" pageEncoding="GBK"%>
<%

	//System.out.println("KOALCert:"+KOALCert);
	//System.out.println("CACert:"+CACert);
	
	String path = request.getContextPath();
	List firstLevelList = (List) session.getAttribute("firstLevelList");
	Map functionMap = (Map) session.getAttribute("functionMap");

	StringBuffer strBuf = new StringBuffer("");
	strBuf.append("\"format\"");
	strBuf.append(":{");
	strBuf.append("target:'rightFrame',");
	strBuf.append("blankImage:'imagine/b.gif',");
	strBuf.append("rollback:true,");
	strBuf.append("animationSteps:3,");
	strBuf.append("animationDelay:20,");
	strBuf.append("templates:{");
	strBuf.append("panel:{");
	strBuf.append("common:'<table width=\"114\" height=\"20\" align=\"center\" valign=\"bottom\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" background=\"imagine/dl-l.gif\"><tr><td align=\"center\"><div style=\"font: bold 9pt;font-weight: normal;color: #FFFFFF;text-align: center;vertical-align: middle;\">{text}</div></td></tr></table>',");
	strBuf.append("normal:{state:'n'}");
	strBuf.append("},");
	strBuf.append("item:{");
	strBuf.append("common:'<table border=\"0\" width=\"100%\" height=\"20\" cellspacing=\"0\" cellpadding=\"0\" ><table width=\"100%\"  height=\"67\" bgcolor=\"#f3f8fe\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><table width=\"100%\" height=\"67\"  border=\"0\" bgcolor=\"#f3f8fe\" cellspacing=\"0\" cellpadding=\"0\"><tr align=\"center\"><td><img src=\"imagine/icon_{icon}_{state}.gif\" width=\"35\" height=\"35\" /></td></tr><tr align=\"center\"><td><span style=\"font: 9pt;color: #1e548b;vertical-align: middle;text-align: center;font-weight: normal;\">{text}</span></td></tr></table></table></table>',");
	strBuf.append("normal:{borderColor:'#f3f8fe', backgroundColor:'#f3f8fe', state:'n'}");
	strBuf.append("},");
	strBuf.append("upArrow:{");
	strBuf.append("common:'<img src=\"imagine/btn_up_{state}.gif\" width=\"24\" height=\"24\" />',");
	strBuf.append("normal:{state:'n'}");
	strBuf.append("},");
	strBuf.append("downArrow:{");
	strBuf.append("common:'<img src=\"imagine/btn_down_{state}.gif\" width=\"24\" height=\"24\" />',");
	strBuf.append("normal:{state:'n'}");
	strBuf.append("}");
	strBuf.append("}");
	strBuf.append("},");
	strBuf.append("\"panels\"").append(":[");
	for (int i = 0; i < firstLevelList.size(); i++) {
		TbFunction fun = (TbFunction) firstLevelList.get(i);
		strBuf
		.append("{\"text\":" + "\"" + fun.getName() + "\"")
		.append(
				",\"url\":\"\",");
		strBuf.append("\"items\":[");
		List secondLevelList = (List) functionMap.get(fun.getId());
		if (!secondLevelList.isEmpty() && secondLevelList.size() > 0) {
			for (int j = 0; j < secondLevelList.size(); j++) {
				TbFunction item = (TbFunction)secondLevelList.get(j);
				String url = item.getUrl();
				//url = url.replaceAll(".do",".do;jsessionid="+session.getId());
				if ((j + 1) != secondLevelList.size()) {
					strBuf.append("{\"text\":"
					+ "\""
					+ item.getName() + "\"");
					strBuf.append(",\"icon\":\""+ item.getImageName() + "\",\"url\":"
							+ "\""
							+ url + "\"");
					strBuf.append(",\"needKey\":\"").append(item.getNeedKey()).append("\"");
					strBuf.append("},");
				} else {
					strBuf.append("{\"text\":"
					+ "\""
					+ ((TbFunction) secondLevelList.get(j))
							.getName() + "\"");
					strBuf.append(",\"icon\":\""+ item.getImageName() + "\",\"url\":"
							+ "\""
							+ url + "\"");
					strBuf.append(",\"needKey\":\"").append(item.getNeedKey()).append("\"");
					strBuf.append("}]}");
				}
			}
		} else {
			strBuf.append("]}");
		}
		strBuf.append(",");
	}
	String resultStr = strBuf.toString().substring(0,
			strBuf.toString().lastIndexOf(","))
			+ "]";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base target="main">
		<meta http-equiv="Content-Type" content="text/html"><%--
		<LINK REL="stylesheet" TYPE="text/css" href="css/style.css"> 
		<script type="text/javascript" src="Scripts/outlookbar_definition.js"></script>--%>
		<script type="text/javascript" src="Scripts/outlook.js"></script>
		<script type="text/javascript">
		var OutlookBar={<%=resultStr%>};
		</script>
<link rel="stylesheet" type="text/css" href="<%=path%>/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=path%>/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=path%>/ext/ext-all.js"></script>
<script type="text/javascript">
function testKey(obj){
	var keyPassword = document.getElementById("keyPassword").value;
	//alert(keyPassword);
	if(!keyPassword || keyPassword=="null"){
		alert("该模块需要插入key才能使用！\r\n如果您已插入key，请直接点击确定！\r\n如果您未插入key，请插入key后再按确定!");
		window.open("<%=path%>/checkKey.jsp?goto="+obj._F,"rightFrame");
	}else{
		intoPage(obj,keyPassword,true);
	}
}
function testKey1(obj){
	var keyPassword = document.getElementById("keyPassword").value;
	if(!keyPassword || keyPassword=="null"){
		Ext.MessageBox.prompt("输入提示框","请输入key密码:",function(button,text){
			if(button=="ok"){
				keyPassword = text;
				intoPage(obj,keyPassword,fasle);
			}
		});
	}else{
		intoPage(obj,keyPassword,true);
	}
}
function intoPage(obj,keyPassword,isFirst){
	if(!keyPassword || keyPassword=="null"){
		return;
	}
	SafeEngineCtl.SEH_InitialSession(9,"com1", keyPassword, 0, 2, "", "");
	if(SafeEngineCtl.ErrorCode!=0){
		if((""+SafeEngineCtl.ErrorCode).match(/7069/)){
			document.getElementById("keyPassword").value = "";
			if(isFirst){
				alert("密码有错，需要重新输入！");
				window.open("<%=path%>/checkKey.jsp?goto="+obj._F,"rightFrame");
			}else{
				alert("密码错误！");
			}
		}else{
			alert("该模块需要插入key才能进入！");
		}
	}else{
		if(!isFirst){
			window.open(obj._F,"rightFrame");
		}
	}
	SafeEngineCtl.SEH_ClearSession();
}
</script>
	</head>
	<body marginwidth="0" marginheight="0" bgcolor="#f3f8fe">
		<script type="text/javascript">
		new COOLjsOutlookBar(OutlookBar);
		</script>
<OBJECT ID="SafeEngineCtl" CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="0" height="0" border=0 ></OBJECT>
<input type="hidden" id="keyPassword" name="keyPassword" value="${keyPassword}"/>
<input type="hidden" id="abc" name="abc" value="abc"/>
	</body>
</html>
