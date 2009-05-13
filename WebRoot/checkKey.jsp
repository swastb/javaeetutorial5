<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>测试key</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/ext/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=path%>/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="<%=path%>/ext/ext-all.js"></script>
</head>
<body onload="checkKey();">
<OBJECT ID="SafeEngineCtl" CLASSID="CLSID:B48B9648-E9F0-48A3-90A5-8C588CE0898F" width="0" height="0" border=0 ></OBJECT>
<script type="text/javascript">
function intoPage(keyPassword){
	if(!keyPassword || keyPassword=="null"){
		history.back();
	}
	SafeEngineCtl.SEH_InitialSession(9,"com1", keyPassword, 0, 2, "", "");
	if(SafeEngineCtl.ErrorCode!=0){
		if((""+SafeEngineCtl.ErrorCode).match(/7069/)){			
			alert("密码错误！");
		}else{
			alert("该模块需要插入key才能进入！");
		}
		history.back();
		SafeEngineCtl.SEH_ClearSession();
	}else{
		SafeEngineCtl.SEH_ClearSession();
		parent.leftFrame.document.getElementById("keyPassword").value = keyPassword;
		location.href="${param.goto}";
	}
}
function checkKey(){
	Ext.MessageBox.prompt("输入提示框","请输入key密码:",function(button,text){
		if(button=="ok"){
			intoPage(text);
		}else{
			history.back();
		}
	});
}
</script>
</body>
</html>