<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<html>
	<head>
		<html:base target="_self" />
		<script language="javascript" type="text/javascript"
			src="../../../../javascript/functionTree.js"></script>
	</head>
	<body bgcolor="#f2f9f9" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<input type="hidden" id="path" value="<%=request.getContextPath()%>" />
		<DIV id="tree"
			style="position: absolute; width: 100%; top: 0px; left: 0px; height: 100%; padding: 5px; overflow: auto;">
			<table border="0">
				<tr>
					<td>
						<font size="-2"><a
							style="font-size:7pt;text-decoration:none;color:silver;"
							href="http://www.treemenu.net/" target="_blank">&nbsp;</a>
						</font>
					</td>
				</tr>
			</table>
		</DIV>
		<script language="javascript" type="text/javascript">
			//定义对象实例
			var dhATV = new dhAjaxTreeView();
			//返回对象实例名
			dhATV.treeTagName = "dhATV";
			//设置根节点文字
			dhATV.rootText = "上海市水务局";			
			//设置结点文字大小
			dhATV.textsize = "12px";
			//设置图标文件夹
			dhATV.icoFolder = "../../../../imagine/tree";
			//设置请求地址
			dhATV.postUrl = "/sso/base/function/forwardFunction.do?method=showFunTree&fid=";
			//设置节点事件
			//dhATV.nodeEvent = function(cs){edit(cs);}
			dhATV.nodeEvent = function(cs){
				var funId = cs.getAttribute("atid");
				var funName = cs.getAttribute("textvalue");
				var funKey = cs.getAttribute("funKey");
				var sysId = cs.getAttribute("sysId");
				var parId = cs.getAttribute("parId");
				var isNode = cs.getAttribute("isNode");
				var insure= cs.getAttribute("insure");
				
				window.parent.document.getElementById("funId").value = funId;
				window.parent.document.getElementById("funKey").value = funKey;
				window.parent.document.getElementById("sysId").value = sysId;
				window.parent.document.getElementById("parId").value = parId;
				window.parent.document.getElementById("isNode").value = isNode;
				window.parent.document.getElementById("insure").value = insure;
				
				window.parent.document.getElementById("funName").innerHTML = funName;
				//alert("funId:"+funId+"-----------funName:"+funName+"----------funKey:"+funKey+"---------sysId:"+sysId+"-------parId:"+parId+"--------isNode:"+isNode+"---------insure:"+insure);
		    	var path = document.getElementById("path").value;
		    	if (funId == "" || funId == '0'){
		    		alert("当前没有选择修改的资源");
		    	}else{
		    		window.open(path+"/base/function/forwardFunction.do?method=inputUpdateFun&id="+funId+"&sid="+sysId,"opf"); 
		    	}				
			}
			dhATV.nodeEventForAll = true;
			//加载树根节点
			dhATV.setup(document.getElementById("tree"));
			dhATV.showNode(document.getElementById("tree").childNodes[0]);
		</script>
		<NOSCRIPT>
			显示失败,请激活浏览器JavaScript功能．
		</NOSCRIPT>
	</body>
</html>

