
function dhAjaxTreeView() {
	//author:dh20156
	var dh = this;
	//定义实例名
	this.treeTagName = null;
	//定义结点图标文件夹
	this.icoFolder = "/tree/imagine/tree";
	//定义根结点文字
	this.rootText = "Root";
	//定义结点文字大小
	this.textsize = "12px";
	this.textcolor = "black";
	//定义请求地址
	this.postUrl = "/sso/base/function/forwardFunction.do?method=showFunTree&fid=";
	//定义客户端指定结点事件
	this.nodeEvent = function (cs) {
		//alert(cs);
	};
	//是否所有节点允许客户端事件
	this.nodeEventForAll = false;
	//定义当前选定结点
	this.selectedNode = null;
	//设置焦点
	this.setFocus = function (obj) {
	//alert("setFocus");
		if (this.selectedNode != null) {
			this.selectedNode.childNodes[2].style.border = "none";
			this.selectedNode.childNodes[2].style.backgroundColor = "";
			this.selectedNode.childNodes[2].style.color = "";
		}
		this.selectedNode = obj;
		this.selectedNode.childNodes[2].style.border = "1px solid buttonshadow";
		this.selectedNode.childNodes[2].style.backgroundColor = "highlight";
		this.selectedNode.childNodes[2].style.color = "white";
	};
	//点击节点事件
	this.clickNode = function (obj, title, l, sobj) {
	//alert("clickNode");
		var otype = obj.className;
		//alert("otype:"+otype);
		otype = otype.toLowerCase();
		if (otype != "childvalue" && otype != "lastvalue") {
			var ocsd = obj.childNodes[obj.childNodes.length - 1].style.display;
			ocsd == "block" ? this.hideNode(obj) : this.showNode(obj);
			if (sobj != "icon") {
				this.setFocus(obj);
				if (this.nodeEventForAll) {
					this.nodeEvent(obj, title, l);
				}
			}
		} else {
			this.setFocus(obj);
			this.nodeEvent(obj);
		}
	};
	//双击节点事件
	this.dbupdate = function (id) {
	//alert("dbupdate");
					if (id == "" || id == "0") {
						alert("\u5f53\u524d\u6ca1\u6709\u9009\u62e9\u4fee\u6539\u7684\u90e8\u95e8\uff01");
					} else {
						window.open("/sso/base/function/forwardFunction.do?method=showFunTree&fid=" + id, "opf");
					}
	};
	//关闭节点
	this.hideNode = function (obj) {
		//alert("hideNode");
		obj.childNodes[obj.childNodes.length - 1].style.display = "none";
		this.setIcon(obj, "close");
	};
	//展开节点
	this.showNode = function (obj) {
		//alert("showNode");
		obj.childNodes[obj.childNodes.length - 1].style.display = "block";
		var nl = obj.childNodes[obj.childNodes.length - 1].childNodes.length;
		if (nl == 0) {
			this.getNode(obj);
		}
		this.setIcon(obj, "open");
	};
	//设置节点样式
	this.setIcon = function (obj, com) {
	//alert("setIcon");
		var rootIconOpen0 = this.icoFolder + "/dashminus.gif";
		var rootIconClose0 = this.icoFolder + "/dashplus.gif";
		var nodeIconOpen0 = this.icoFolder + "/tminus.gif";
		var nodeIconClose0 = this.icoFolder + "/tplus.gif";
		var nodeIconOpen1 = this.icoFolder + "/no.gif";
		var nodeIconClose1 = this.icoFolder + "/nc.gif";
		var lnodeIconOpen0 = this.icoFolder + "/lminus.gif";
		var lnodeIconClose0 = this.icoFolder + "/lplus.gif";
		var otype = obj.className;
		otype = otype.toLowerCase();
		switch (otype) {
		  case "root":
			if (com == "open") {
				obj.childNodes[0].src = rootIconOpen0;
			} else {
				obj.childNodes[0].src = rootIconClose0;
			}
			break;
		  case "childnode":
			if (com == "open") {
				obj.childNodes[0].src = nodeIconOpen0;
				obj.childNodes[1].src = nodeIconOpen1;
			} else {
				obj.childNodes[0].src = nodeIconClose0;
				obj.childNodes[1].src = nodeIconClose1;
			}
			break;
		  case "lastnode":
			if (com == "open") {
				obj.childNodes[0].src = lnodeIconOpen0;
				obj.childNodes[1].src = nodeIconOpen1;
			} else {
				obj.childNodes[0].src = lnodeIconClose0;
				obj.childNodes[1].src = nodeIconClose1;
			}
			break;
		  default:
			break;
		}
	};
	//初始化XMLHTTPREQUEST
	var Try = {these:function () {
		var returnValue;
		for (var i = 0; i < arguments.length; i++) {
			var lambda = arguments[i];
			try {
				returnValue = lambda();
				break;
			}
			catch (e) {
			}
		}
		return returnValue;
	}};
	this.ajaxInitRV = function () {
		//alert("ajaxInitRV");
		return Try.these(function () {
			return new ActiveXObject("MSXML2.XMLHttp.6.0");
		}, function () {
			return new ActiveXObject("MSXML2.XMLHttp.3.0");
		}, function () {
			return new XMLHttpRequest();
		}, function () {
			return new ActiveXObject("MSXML2.XMLHttp.5.0");
		}, function () {
			return new ActiveXObject("MSXML2.XMLHttp.4.0");
		}, function () {
			return new ActiveXObject("Msxml2.XMLHTTP");
		}, function () {
			return new ActiveXObject("MSXML.XMLHttp");
		}, function () {
			return new ActiveXObject("Microsoft.XMLHTTP");
		}) || null;
	};
	//加载节点
	this.getNode = function (obj) {
		var ajaxRV = null;
		var reqRV = this.ajaxInitRV();
		var atid = obj.getAttribute("atid");
		var url = this.postUrl + atid;
		var args = url.substr(url.indexOf("?") + 1);
		obj.childNodes[obj.childNodes.length - 1].innerHTML = "<div><img src='" + this.icoFolder + "/l.gif' align='absmiddle' /><img src='" + this.icoFolder + "/topic.gif' align='absmiddle' /> loading...</div>";
		if (reqRV != null) {
			reqRV.onreadystatechange = function () {
				if (reqRV.readyState == 4) {
					if (reqRV.status == 200) {
						ajaxRV = reqRV.responseText;
						ajaxRV = unescape(ajaxRV);
						obj.childNodes[obj.childNodes.length - 1].innerHTML = parseTypeXML(reqRV, dh.treeTagName, dh.icoFolder);
						reqRV = null;
					} else {
						//failed
						obj.childNodes[obj.childNodes.length - 1].innerHTML = "";
					}
				}
			};
			//异步加载
			//alert("url:"+url);
			reqRV.open("POST", encodeURI(url), true);
			reqRV.setRequestHeader("Content-Length", args.length);
			reqRV.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
			reqRV.send(args);
		}
	};
	//对象实例化
	this.setup = function (obj) {
		//alert("setup");	
		this.selectedNode = null;
		if (typeof document.styleSheets == "undefined" || document.styleSheets != "OBJECT") {
			var styleObj = document.createElement("STYLE");
			document.getElementsByTagName("HEAD")[0].appendChild(styleObj);
		}
		var oStyleSheet = document.styleSheets[0];
		if (-1 != navigator.userAgent.toLowerCase().indexOf("msie")) {
			oStyleSheet.addRule(".root", "margin:0px;white-space: nowrap;");
			oStyleSheet.addRule(".root *", "font-size:" + this.textsize + ";color:" + this.textcolor + ";white-space: nowrap;");
			oStyleSheet.addRule(".childnode", "background:url(" + this.icoFolder + "/i.gif) left top repeat-y;}");
			oStyleSheet.addRule(".childvalue", "background:url(" + this.icoFolder + "/i.gif) left top repeat-y;");
			oStyleSheet.addRule(".nodetext", "padding-left:5px;cursor:pointer;");
			oStyleSheet.addRule(".nodepanel_root", "display:none;");
			oStyleSheet.addRule(".nodepanel_root div", "margin-left:-2px;");
			oStyleSheet.addRule(".nodepanel", "display:none;");
			oStyleSheet.addRule(".nodepanel div", "margin-left:17px;");
		} else {
			oStyleSheet.insertRule(".root{margin:0px;white-space: nowrap;}", 0);
			oStyleSheet.insertRule(".root *{font-size:" + this.textsize + ";color:" + this.textcolor + ";white-space: nowrap;}", 1);
			oStyleSheet.insertRule(".childnode{background:url(" + this.icoFolder + "/i.gif) left top repeat-y;}}", 2);
			oStyleSheet.insertRule(".childvalue{background:url(" + this.icoFolder + "/i.gif) left top repeat-y;}", 3);
			oStyleSheet.insertRule(".nodetext{padding-left:5px;cursor:pointer;}", 4);
			oStyleSheet.insertRule(".nodepanel_root{display:none;}", 5);
			oStyleSheet.insertRule(".nodepanel_root div{margin-left:-2px;}", 6);
			oStyleSheet.insertRule(".nodepanel{display:none;}", 7);
			oStyleSheet.insertRule(".nodepanel div{margin-left:17px;}", 8);
		}
		//var rootStr = "<div class=\"root\" atid=\"0\" textvalue=\"" + this.rootText + "\"><img src=\"" + this.icoFolder + "/dashplus.gif\" align=\"absmiddle\" style=\"display:none;\" /><img src=\"" + this.icoFolder + "/rp.gif\" align=\"absmiddle\" /><span class=\"nodetext\" onclick=\"" + this.treeTagName + ".clickNode(this.parentNode);\">" + this.rootText + "</span><span class=\"nodepanel_root\" /></div>";
		var rootStr = "<div class=\"root\" atid=\"0\" textvalue=\"" + this.rootText + "\"><img src=\"" + this.icoFolder + "/dashplus.gif\" align=\"absmiddle\" style=\"display:none;\" /><img src=\"" + this.icoFolder + "/rp.gif\" align=\"absmiddle\" /><span class=\"nodetext\">" + this.rootText + "</span><span class=\"nodepanel_root\" /></div>";
		obj.innerHTML = rootStr;
	};
}
function parseTypeXML(reqRV, tagName, folder) {
//alert("parseTypeXML");	
	var fun = reqRV.responseXML.getElementsByTagName("function");
	var len = fun.length;
	var tempStr = "";
	for (i = 0; i < len; i++) {
		id = getData(i, "id", fun); //本身id
		name = getData(i, "title", fun);//资源名称
		funKey = getData(i, "funKey", fun);//功能在各个子系统的唯一比阿什
		sysId = getData(i, "sysId", fun);//所属应用系统 
		isNode = getData(i, "isnode", fun);//判断是否是跟节点
		insure = getData(i, "insure", fun);//当前是否被启用
		parId = getData(i, "parId", fun);//父节点id
		if (i == len - 1) {
			if (isNode == "true") {
				tempStr = tempStr + "<div class=\"lastnode\" atid=\"" + id + "\" textvalue=\"" + name + "\" funKey=\"" + funKey + "\" parId=\"" + parId + "\" insure=\"" +insure + "\" isNode=\"" + isNode + "\" sysId=\"" + sysId + "\"><img src=\"[dhfolder]/lplus.gif\" align=\"absmiddle\" onclick=\"[dhATV].clickNode(this.parentNode,'icon');\" /><img src=\"[dhfolder]/nc.gif\" align=\"absmiddle\" /><span class=\"nodetext\" onclick=\"[dhATV].clickNode(this.parentNode,'" + name + "');\" >" + name + "</span><span class=\"nodepanel\"></span></div>";
			} else {
				tempStr = tempStr + "<div class=\"lastvalue\" atid=\"" + id + "\" textvalue=\"" + name + "\" funKey=\"" + funKey + "\" parId=\"" + parId + "\" insure=\"" +insure + "\" isNode=\"" + isNode + "\" sysId=\"" + sysId + "\"><img src=\"[dhfolder]/l.gif\" align=\"absmiddle\" /><img src=\"[dhfolder]/topic.gif\" align=\"absmiddle\" /><span class=\"nodetext\" onclick=\"[dhATV].clickNode(this.parentNode,'" + name + "');\" >" + name + "</span></div>";
			}
		} else {
			if (isNode == "true") {
				tempStr = tempStr + "<div class=\"childnode\" atid=\"" + id + "\" textvalue=\"" + name + "\" funKey=\"" + funKey + "\" parId=\"" + parId + "\" insure=\"" +insure + "\" isNode=\"" + isNode + "\" sysId=\"" + sysId + "\"><img src=\"[dhfolder]/tplus.gif\" align=\"absmiddle\" onclick=\"[dhATV].clickNode(this.parentNode,'icon');\" /><img src=\"[dhfolder]/nc.gif\" align=\"absmiddle\" /><span class=\"nodetext\" onclick=\"[dhATV].clickNode(this.parentNode,'" + name + "');\" >" + name + "</span><span class=\"nodepanel\"></span></div>";
			} else {
				tempStr = tempStr + "<div class=\"childvalue\" atid=\"" + id + "\" textvalue=\"" + name + "\" funKey=\"" + funKey + "\" parId=\"" + parId + "\" insure=\"" +insure + "\" isNode=\"" + isNode + "\" sysId=\"" + sysId + "\"><img src=\"[dhfolder]/t.gif\" align=\"absmiddle\" /><img src=\"[dhfolder]/topic.gif\" align=\"absmiddle\" /><span class=\"nodetext\" onclick=\"[dhATV].clickNode(this.parentNode,'" + name + "');\" >" + name + "</span></div>";
			}
		}
	}
	//alert(tempStr);
	tempStr = tempStr.replace(/\[dhATV\]/ig, tagName);
	tempStr = tempStr.replace(/\[dhfolder\]/ig, folder);
	return tempStr;
}
function getData(index, tagName, obj) {
	if (index >= obj.count) {
		return "index overflow";
	}
	var node = obj[index];
	var str = node.getElementsByTagName(tagName)[0].firstChild.data;
	return str;
}

