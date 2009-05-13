<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<html>
	<head>
		<html:base target="_self" />
		<script language="javascript" type="text/javascript"
			src="../../../../javascript/roleauthTree.js"></script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
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
			dhATV.rootText = "上海市水务局统";			
			//设置结点文字大小
			dhATV.textsize = "12px";
			//设置图标文件夹
			dhATV.icoFolder = "../../../../imagine/tree";
			//设置请求地址
			dhATV.postUrl = "/sso/base/roleAuth/forwardRoleAuth.do?method=showRoleAuthTree&rid=";
			//设置节点事件
			//dhATV.nodeEvent = function(cs){edit(cs);}
			dhATV.nodeEvent = function(cs){
				var id = cs.getAttribute("atid");
				var roleName = cs.getAttribute("textvalue");
				window.parent.document.getElementById("roleId").value = id;				
				window.parent.document.getElementById("roleName").innerHTML = roleName;
				//alert("roleId:"+id+"-----------roleName:"+roleName);
				if(id!=null && roleName!=null ){
					//alert("/sso/base/roleAuth/forwardRoleAuth.do?method=inputShowFunTree&rid="+id);
					window.parent.document.getElementById("opf").src="/sso/base/roleAuth/forwardRoleAuth.do?method=inputShowFunTree&rid="+id;
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

