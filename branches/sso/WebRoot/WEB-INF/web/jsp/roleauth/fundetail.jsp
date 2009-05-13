<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<html>
	<head>
		<html:base target="_self" />
		<link href="../../../../css/font.css" rel="stylesheet" type="text/css">
		<link href="../../../../css/list.css" rel="stylesheet" type="text/css">
		<script src="../../../../javascript/checkbox.js"></script>
		<script type="text/javascript">
			function checkFun(){
				var chkLen = checkRightType();
				if(chkLen==0){
					alert("权限类型不能为空，请选择！");
					return false;
				}			
				delSel();
				var funFrm = window.dialogArguments.document.getElementById("funFrm");
				var funDoc = window.dialogArguments.document;
				var obj = window.dialogArguments.document.list.elements;
				//alert(funFrm.length);
				var es = document.getElementsByName("right_type");
				var chkLen = 0;
				var rValue = "";
				for (var i = 0; i < es.length ; i++){		
					if(es[i].checked){
						rValue = rValue + es[i].value + ",";
						//alert(selFun.value);
					}
				}
				var fid = document.getElementById("id").value;

				if(rValue!=""){
					rValue = rValue.substring(0,rValue.length-1);
					var selFun = funDoc.createElement("<input type=\"hidden\" fid=\"" + fid + "\" name=\"selFun\" notFull=1 id=\"selFun\" />");
					selFun.value = rValue;
					funDoc.appendChild(selFun); 
					
				}else{
					var selFun = funDoc.createElement("<input type=\"hidden\" fid=\"" + fid + "\" name=\"selFun\" notFull=2 id=\"selFun\" />");
					selFun.value = "5";
					funDoc.appendChild(selFun); 				
				}				
				window.close();
				
				
				
			}
			function delSel(){
				var funDoc = window.dialogArguments.document;
				var selFunList = funDoc.getElementsByName("selFun");
				var fid = document.getElementById("id").value;
				for(var i=0;i<selFunList.length;i++){
				//alert(selFunList[i].fid+"--------------"+fid);
					if(selFunList[i].fid==fid){
						funDoc.removeChild(selFunList[i]);
						//alert("1");
					}
				}
			}
			function checkall(id){
				var es = document.getElementsByName("right_type");
				var tocheck = id.checked;
				var totle = es.length;
				for (var i = 0; i < es.length ; i++){
					es[i].checked = tocheck; 
					setID(es[i]);
				}
			}			

			function checkRightType(){
				var es = document.getElementsByName("right_type");
				var chkLen = 0;
				for (var i = 0; i < es.length ; i++){
					if(es[i].checked){
						chkLen++;
					}
				}	
				return chkLen;
			}			
		</script>
		<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px;
	color: #FF0000;
}
.STYLE2 {
	font-size: 12px;
	color: #666666;
}
-->
        </style>
	</head>

	<body>

		<input id="path" type="hidden" value="<%=request.getContextPath()%>">
		<input id="sure" type="hidden" value="${tbFunction.inuse }">
		<input type="hidden" id="rTypeLen" name="couting"
			value="${fn:length(rightTypeListByFun)}" />
		<input id="id" type="hidden" value="${tbFunction.id }">
		<input id="par_id" type="hidden" value="${tbFunction.parId }">
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table_bar">
			<tr>
				<td height="30" align="left">
					&nbsp;
					<span class="STYLE1">角色权限管理 </span>&nbsp;&nbsp;&nbsp;&nbsp;
					<a class="font_underline" onClick="checkFun();"
						onmouseover="this.style.cursor='hand'"> 提交</a> &nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="1" class="table3">

			<thead class="t">
				<tr>
					<td width="50%">
						资源名称
					</td>
					<td colspan="2">
						${tbFunction.name }
					</td>
					<td>
						<font color="red" size="2"><div id="fname"></div> </font>
					</td>
				</tr>
				<tr>
					<td width="50%">
						子系统唯一标识
					</td>
					<td colspan="2">
						${tbFunction.funKey }
					</td>
					<td>
						<font color="red" size="2"><div id="ffun_key"></div> </font>
					</td>
				</tr>
				<tr>
					<td width="50%">
						所属应用系统
					</td>
					<td colspan="2">
						${tbFunction.sysId }
					</td>
					<td>
						<font color="red" size="2"><div id="fsys_key"></div> </font>
					</td>
				</tr>
				<tr>
					<td width="50%">
						资源是否被启用
					</td>
					<td colspan="2">
						<c:if test="${tbFunction.inuse!=null}">
							<c:if test="${tbFunction.inuse==1}">
									启用
								</c:if>
							<c:if test="${tbFunction.inuse==0}">
									未启用
								</c:if>
						</c:if>
						<c:if test="${tbFunction.inuse==null}">
								--
							</c:if>
					</td>
					<td>
						<font color="red" size="2"><div id="finsure"></div> </font>
					</td>
				</tr>
			</thead>
		</table>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="table_bar">
			<tr>
				<td height="30" align="left" width="25%">
					&nbsp;
					<span class="STYLE1">权限类型信息 </span>
				</td>
			</tr>
			<tr>
				<td width="50%" height="25" align="center" class="t1">
					<input name="allbox" type="checkbox" id="allbox"
						onClick="checkall(this);">
				</td>
				<td align="center" class="t1">
					权限名称
				</td>
			</tr>
			<c:forEach var="content" items="${rightTypeListByFun}"
				varStatus="loop">
				<tr>
					<td width="50%" align="center" class="t1">
						<input type="checkbox" name="right_type" id="right_type"
							value="${content.id}" onclick="setID(this)"></input>
					</td>
					<td align="center" class="t1">
						${content.name }
					</td>
				</tr>
			</c:forEach>
		</table>
		<form id="typeFrm">
			<c:forEach var="content1" items="${rightTypeListSelect}" varStatus="loop">
				<input type='hidden' name='rightType' value="${content1.id }" />
			</c:forEach>
		</form>		
	</body>
		<script type="text/javascript">	
			var right_type = document.getElementsByName("right_type");
			var rightType = document.getElementsByName("rightType");
			for(i=0;i<right_type.length;i++){
				if(right_type[i].value=='ff8080811a04e4c3011a05022aba0005'){
					right_type[i].checked=true;
					continue;
				}
				for(j=0;j<rightType.length;j++){
					if(right_type[i].value==rightType[j].value){
						right_type[i].checked=true;
					}
				}
			}
			//document.getElementById("insure").checked='true';
		</script>	
</html>

