<%@ page language="java"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<script type="text/javascript">
<!--
var swqk = new Array("期数","版次","编辑","审签","编辑部门","政府审批","档号","","");
var zywg = new Array("来源","级别","发生事件","特别推荐","档号","","","","");
var fg = new Array("发布机关","实行时间","类型","级别","类别","名称","内容","标准号","");
var zhb = new Array("招标单位","代理单位","关键子","内容","类型","有效期限","New标志","","");
var zhp = new Array("发生事件","图象尺寸","拍摄地点","文件大小","拍摄内容","文件类型","档号","","");
var yx = new Array("摄影主题","发生事件","拍摄内容","拍摄地点","文件类型","文件大小","图象尺寸","档号","播放时间");
var shy = new Array("声音主题","发生事件","录制内容","文件类型","文件大小","录制地点","档号","播放时间","");
var hdp = new Array("幻灯片主题","发生事件","制作地点","档号","内容","","","","");
var swqkSel = new Array(["23","专题会议纪要"],["20","水务杂志"],["14","水务情况"],["18","水务青年"],["21","水务年鉴"],
["17","水务工会"],["15","水务动态"],["19","水务报"],["22","局长办公会议纪要"],["24","党政联席会议纪要"],["16","党务简讯"]);
var zywgSel =new Array(["28","文摘"],["25","讲话"],["27","汇报"],["26","工作报告"]);
var fgSel = new Array(["29","法规"],["30","标准"]);
var zhbSel = new Array(["31","招标"],["32","公告"]);
var zhpSel = new Array(["34","照片"],["33","图片"]);
var yxSel = new Array(["35","影像"]);
var shySel = new Array(["36","声音"]);
var hdpSel = new Array(["37","幻灯片"]);
var selectOps;
var showText ;//要显示的信息文本
function init(addType){//showText.length
	if ("xw"==addType) {
		document.getElementById("xw").style.display="block";
	}
	else {
	showTextSet(addType);
	 for (var i=0;i<9;i++) {
	 	if (showText[i]!="")
			document.getElementById("col"+i).innerHTML=showText[i];
		else {
			document.getElementById("col"+i).style.display="none";
			document.getElementById("col"+i+'1').style.display="none";
		}
		document.getElementById("addType").style.display="block";
	}
	initOptions(selectOps);
	}
}
function showTextSet(addType) {
	if ("swqk"==addType) {
		showText=swqk;
		selectOps=swqkSel;
	}
	else if ("zywg"==addType) {
		showText=zywg;
		selectOps=zywgSel;
	}
	else if ("fg"==addType) {
		showText=fg;
		selectOps=fgSel;
	}
	else if ("zhb"==addType) {
		showText=zhb;
		selectOps=zhbSel;
	}
	else if ("zhp"==addType) {
		showText=zhp;
		selectOps=zhpSel;
	}
	else if ("yx"==addType) {
		showText=yx;
		selectOps=yxSel;
	}
	else if ("shy"==addType) {
		showText=shy;
		selectOps=shySel;
	}
	else if ("hdp"==addType) {
		showText=hdp;
		selectOps=hdpSel;
	}
	
}
function initOptions(xmlDoc) {
				var initS1 = document.getElementById("infoType");
				for (var j = initS1.options.length; j > 0; j--) {
					initS1.removeChild(initS1.options[j - 1]);
				}
				var currentElement = null;
				for (var i = 0; i < xmlDoc.length; i++) {
					currentElement = document.createElement("option");
					var value = xmlDoc[i][0];
					var text = xmlDoc[i][1];;
					currentElement.setAttribute("value", value);
					var txtInfo = document.createTextNode(text);
					currentElement.appendChild(txtInfo);
					initS1.appendChild(currentElement);
				}
			}
			//-->
</script>
	</head>

	<body>
	</body>
</html>

