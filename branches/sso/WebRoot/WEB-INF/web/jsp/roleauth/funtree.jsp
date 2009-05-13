<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<html>
	<head>
		<html:base target="_self" />
		<script language="javascript" type="text/javascript"
			src="../../../../javascript/functionTreeForAuth.js"></script>
	</head>
	<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">	
		<form id="list" name="list" method="post">
			<input type="hidden" id="rid" name="rid" value="${rid }" />
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
					var rid = document.getElementById("rid").value;
					//alert("rid:"+rid);
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
					dhATV.postUrl = "/sso/base/roleAuth/forwardRoleAuth.do?method=showFunTree&rid="+rid+"&fid=";
					//设置节点事件
					//dhATV.nodeEvent = function(cs){edit(cs);}
					dhATV.nodeEvent = function(cs){
						var fid = cs.getAttribute("atid");
						var funName = cs.getAttribute("textvalue");					
						if(fid!=""){
							var url = "/sso/base/roleAuth/forwardRoleAuth.do?method=showDetailFun&fid="+fid+"&rid="+rid;
							//alert(url);
							selectFun(url);	
						}	
					}
					dhATV.nodeEventForAll = true;
					//加载树根节点
					dhATV.setup(document.getElementById("tree"));
					dhATV.showNode(document.getElementById("tree").childNodes[0]);			
				</script>
				<script type="text/javascript" language="javascript">
					function add(path){
						
						
						
						var flagSub = false;
						var flagDel = true;
						var obj = document.list.elements;
						var funFrm  = document.getElementById("funFrm");
						var rid = document.getElementById("rid").value;
						var isSel = "";
						var fVlaue = "";
						while(flagDel){
							delEle();
							var funListBefore = document.getElementsByName("fun");
							var selFunListBefore = document.getElementsByName("isDef");
							var selFunList = document.getElementsByName("selFun");	
							if(funListBefore.length==0||selFunListBefore.length==0|| selFunList.length==0){
								flagDel = false;
							}
						}
						var selFunList = document.getElementsByName("selFun");
						//for(var i=0;i<selFunList.length;i++){
						//	alert(i+"-----------"+selFunList[i].value+"-----------"+selFunList[i].fid);
						//}						
						for (var i = 0; i < obj.length; i++) {		
							if(typeof(obj[i]) != "undefined" && obj[i].tagName=="INPUT"){
								//alert(i+"----------"+obj[i].tagName+"--------"+obj[i].rname+"-----------"+obj[i].id);
								var fun;
								//var isE;
								if(obj[i].checked==true){
									fun = document.createElement("<input type=\"hidden\" name=\"fun\" id=\"fun\"/>");
									//isE = document.createElement("<input type=\"hidden\" name=isEx id=\"fun\" value=true/>");
								}
								if(obj[i].checked==false){
									fun = document.createElement("<input type=\"hidden\" name=\"fun\" id=\"fun\"/>");
									//isE = document.createElement("<input type=\"hidden\" name=isEx id=\"fun\" value=false/>");
								}	
								//funFrm.appendChild(isE); 							
								isSel = "";
								for(var k=0;k<selFunList.length;k++){
									//alert(obj[i].id+"--------------"+selFunList[k].fid	);
									//alert(selFunList[k].notFull);
									if(selFunList[k].notFull=="1"){
										if(obj[i].id==selFunList[k].fid){
											isSel = "1";
											fVlaue = selFunList[k].value;
											//alert(fVlaue);
											break;
										}									
									}
									if(selFunList[k].notFull=="2"){
										isSel = "2";
									}																	
								}
								if(obj[i].parId!="null" && obj[i].isNode=="false"){
									if (isSel=="" && obj[i].checked){
										//alert(obj[i].rname+"项作权限类型不能为空，请为其设置操作权限类型");	
										//var url = "/sso/base/roleAuth/forwardRoleAuth.do?method=showDetailFun&fid="+obj[i].id+"&rid="+rid;				
										//selectFun(url);
										//return false;
										isSel="1";
										fVlaue="ff8080811a04e4c3011a05022aba0005";
									}
								}
								if(obj[i].checked==true){
									fun.value = obj[i].id+":true";
								}
								if(obj[i].checked==false){
									fun.value = obj[i].id+":false";
								}								
								
								funFrm.appendChild(fun); 
									
								
								if(isSel=="1"){
									var isDef = document.createElement("<input type=\"hidden\" name=\"isDef\" id=\"isDef\" />");						
									isDef.value = fVlaue;							
									funFrm.appendChild(isDef);
								}else if (isSel=="2"){
									var isDef = document.createElement("<input type=\"hidden\" name=\"isDef\" id=\"isDef\" />");						
									isDef.value = "2";							
									funFrm.appendChild(isDef); 									
								}else{
									var isDef = document.createElement("<input type=\"hidden\" name=\"isDef\" id=\"isDef\" />");						
									isDef.value = "1";							
									funFrm.appendChild(isDef);								
								}														
							}
							fVlaue = "";
						}	
										
						var funListAfter = document.getElementsByName("fun");
						
						//if(funListAfter.length!=0){
						//	if (confirm("您确认提交吗？")){
						//		flagSub = true;
						//	}	
						//}
						if (confirm("您确认提交吗？")){
							flagSub = true;
						}							
							
				    	if(flagSub){
							var role = document.createElement("<input type=\"hidden\" name=\"role\" id=\"role\" />");
							role.value = rid;
							funFrm.appendChild(role); 					    	
				    		funFrm.action=path + "/base/roleAuth/toAuth.do";
				    		funFrm.submit();	
				    	}						
						
					}		
					function delEle(){
						var funFrm  = document.getElementById("funFrm");
						var funList = document.getElementsByName("fun");
						var isDefList = document.getElementsByName("isDef");
						for(var k=0;k<funList.length;k++){
							funFrm.removeChild(funList[k]);
							funFrm.removeChild(isDefList[k]);
							
						}
						//var selFunList = document.getElementsByName("selFun");	
						//alert(selFunList.length);
						//for(var i=0;i<selFunList.length;i++){
						//	funFrm.removeChild(selFunList[i]);
						//}										
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
								<input type="button" value="提交"
									onclick="add('<%=request.getContextPath()%>');">
							</td>
						</tr>
					</thead>
				</table>
			</DIV>
		</form>
		<form id="funFrm" method="post">
		</form>			
	</body>
</html>

