var newVer="090221";
if (parseInt(curVer,10)<parseInt(newVer,10)) {
	if (confirm("当前版本 "+curVer+"\n发现新版 "+newVer+"\n\n是否下载？")) {
		window.location.href="http://code.google.com/p/jquery-api-zh-cn/downloads/list";
	}
	$("#update").html("你当前的版本为 "+curVer+"，发现新版 "+newVer+"<br /><a href='http://code.google.com/p/jquery-api-zh-cn/downloads/list'>下载新版</a> <a href='http://jquery-api-zh-cn.googlecode.com/svn/trunk/xml/changelog.txt'>更新日志</a>");
}else {
	alert("当前已是最新版。");
}