<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();

%>
<html>
	<head>
		<html:base target="_self" />
		<title>个人通讯录组</title>
		<script language="javascript" type="text/javascript"
			src="../../../../javascript/individualcommforSMS.js"></script>
			<link href="<%=path %>/images/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body bgcolor="#f2f9f9" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<form id="list" name="list" method="post">
			<DIV id="tree"
				style="position: absolute; width: 100%; top: 0px; left: 0px; height: 100%; padding: 5px; overflow: auto;">
				<table border="0">
					<tr>
						<td>
							<font size="-2"><a
								style="font-size:7pt;text-decoration:none;color:silver;"
								href="http://www.treemenu.net/" target="_blank">&nbsp;</a> </font>
						</td>
					</tr>
				</table>
				<script language="javascript" type="text/javascript">
					//定义对象实例
					
					var dhATV = new dhAjaxTreeView();
					//返回对象实例名
					dhATV.treeTagName = "dhATV";
					//设置根节点文字
					dhATV.rootText = "个人通讯录组";			
					//设置结点文字大小
					dhATV.textsize = "12px";
					//设置图标文件夹
					dhATV.icoFolder = "../../../../imagine/tree";
					//设置请求地址
					dhATV.postUrl = "/sso/shortInfo.do?method=showIndualGroupTree&cid";
					//设置节点事件
					//dhATV.nodeEvent = function(cs){edit(cs);}
					dhATV.nodeEvent = function(cs){
						var cid = cs.getAttribute("atid");					
					}
					dhATV.nodeEventForAll = true;
					//加载树根节点
					dhATV.setup(document.getElementById("tree"));
					dhATV.showNode(document.getElementById("tree").childNodes[0]);			
				</script>
				<script type="text/javascript" language="javascript">
					function add(path){
						var chkCount = 0;
						var chkId = "";
						var chkName = "";
						var obj = document.list.elements;	
						var frm = window.dialogArguments.document;				
						for (var i = 0; i < obj.length; i++) {		
							if(typeof(obj[i]) != "undefined" && obj[i].tagName=="INPUT"){								
								if(obj[i].checked==true){
								chkId = chkId + obj[i].id + ",";
								chkName = chkName + obj[i].rname + ";";
									chkCount++;
								}
							}
						}	
						if(chkCount==0){
							alert("请选择公共通讯录组")
							return false;
						}
						if(chkCount!=0){
							delEle();
							chkId = chkId.substring(0,chkId.length-1);
							chkName = chkName.substring(0,chkName.length-1);
							frm.getElementById("destNumberObject").value = chkName;
							frm.getElementById("chkInduId").value = chkId;
							window.close();
						}					
					}							
					function delEle(){
						var frm = window.dialogArguments.document;
						frm.getElementById("destNumberObject").value = "";
						frm.getElementById("chkInduId").value = "";								
					}
					
					function selectFun(url){
						openWin(url,"600px","600px","");
					}
					function openWin(url,width,height,other){
						var win = window.showModalDialog(url,window,"dialogWidth:"+width+";dialogHeight:"+height+";center:yes;resizable:no;status:no;scroll:auto;help:no;edge:raised"+other);
					}					
				</script>				
				<NOSCRIPT>
					显示失败,请激活浏览器JavaScript功能．
				</NOSCRIPT>
				<table width="98%" border="0" align="center" cellpadding="0"
					cellspacing="1" class="table3">
					<thead class="t">
						<tr>
							<td width="60%" align="left">
							
							 <input  type="button" class="button0" value="&nbsp;提交&nbsp;" onclick="add('<%=request.getContextPath()%>');" onmouseover="this.style.cursor='hand'">
                     
							</td>
						</tr>
					</thead>
				</table>
			</DIV>
		</form>
		<form id="funFrm">
		</form>
	</body>
</html>

