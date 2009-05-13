<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib prefix="logic" uri="/WEB-INF/tld/struts-logic.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path%>/js/calendar-dong.js"></script>
<script type="text/javascript">
<!--
var num = 1;
function additem(id){
	var row,cell,str; 
	row = eval("document.all["+'"'+id+'"'+"]").insertRow();
	if(row != null ){
		cell = row.insertCell();
		str="<input type="+'"'+"file"+'"'+" name=uploadFile["+ num +"].file onkeydown="+'"'+"event.returnValue=false;"+'"'+" onpaste="+'"'+" return false"+'"'+"><input type="+'"'+"button"+'"'+" value="+'"'+"删除"+'"'+" onclick='deleteitem(this,"+'"'+id+'"'+");' class='button0'>";
		cell.innerHTML=str;
	}
	num++;
}
function deleteitem(obj,id){
	var rowNum,curRow;
	curRow = obj.parentNode.parentNode;
	rowNum = eval("document.all."+id).rows.length - 1;
	eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex); 
}
function deleteFile(obj){
	var tr=document.getElementById("tr"+obj);
	var fileId=document.getElementById("hid"+obj).value;
	var fileName = document.getElementById("fileName"+obj).value;
	if(confirm("你确定要删除附件\""+fileName+"\"吗？")){
		tr.style.display='none';
		//删除文件
		try{
			xmlHttp = getXMLHTTPObj();
			if(xmlHttp){
				var url = "<%=path%>/docAttach.do?method=delete&id="+fileId;
				xmlHttp.open("GET", url, true);
				xmlHttp.onreadystatechange = new function(){};
				xmlHttp.send(null);
			}
		}catch (e){
		}
	}
}
function getXMLHTTPObj(){
	var xmlHttp = null;
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}else{
		xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return xmlHttp;
}

function leaderSay(opinion){
	if(event.srcElement.checked){
		return;
	}
	var obj = document.getElementById("leaderAudit");
	obj.value="";
	if(opinion=="1"){
		obj.value="已阅";
		document.getElementById("mainDept4").value="";
		document.getElementById("mainDeptName4").value="";
		document.getElementById("secendDept4").value="";
		document.getElementById("secendDeptName4").value="";
	}else if(opinion=="2"){
		var mainDeptName = document.getElementById("mainDeptName4").value;
		var secendDeptName = document.getElementById("secendDeptName4").value;
		if(mainDeptName!=""){
			if(obj.value!="")obj.value+="，";
			obj.value+="报"+mainDeptName+"主办部门";
		}
		if(secendDeptName!=""){
			if(obj.value!="")obj.value+="，";
			obj.value+="报"+secendDeptName+"协办部门";
		}
	}
	today = new Date();
	sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
	stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
	obj.value+="---${SYSTEM_USER_SESSION.name}同志  "+sday+" "+stime;
}

function personSay(){
	if(event.srcElement.checked){
		return;
	}
	var obj = document.getElementById("assUserRemark");
	today = new Date();
	sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
	stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
	if(obj.value!=""){
		obj.value+="\r\n";
	}
	obj.value+="已阅---${SYSTEM_USER_SESSION.name}  "+sday+" "+stime;
}
function clearSay(stext){
	document.getElementById(stext).value="";
}
function fmtl(s,l){
	ss = ""+s;
	if(ss.length<l){
		for(i=0;i<l-ss.length;i++){
			ss = "0"+ss;
		}
	}
	return ss;
}
function returnback(){
	docRecBookForm.method.value="rollback";
	window.showModalDialog("<%=path%>/docRecRelateAction.do?method=lcljdRollBack&showText=backControl&docId="+docRecBookForm.docId.value,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
function selectuser(flag,argDeptOrUser,tid,tname){
	window.showModalDialog("<%=path%>/userTree.do?method=input&idText="+tid+"&nameText="+tname+"&rootId=${treeRootId==null?"":treeRootId}&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
function selectdept(flag,argDeptOrUser,tid,tname){
	window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&roleid=851a36fb19078db2011907a09e390003&source=shouwendept&idText="+tid+"&nameText="+tname+"&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
function disposerSay(type){
	var obj = document.getElementById("draftOpinion");
	obj.value="";
	var radios = document.getElementsByName("draftRadio");
	var hasChoose = false;
	for(i=0;i<radios.length;i++){
		if(radios[i].checked){
			hasChoose = true;
			break;
		}
	}
	if(!hasChoose){
		if(type=="1"){
			radios[0].checked=true;
		}else if(type=="2"){
			radios[1].checked=true;
		}else if(type=="3"){
			radios[2].checked=true;
		}
	}
	if(radios[0].checked){
		var leaderName = document.getElementById("leaderName1").value;
		var personName = document.getElementById("personName1").value;
		if(leaderName!=""){
			obj.value+="请"+leaderName+"同志阅";
		}
		if(leaderName!="" && personName!=""){
			obj.value+="，";
		}
		if(personName!=""){
			obj.value+="请"+personName+"相关人员阅";
		}
	}else if(radios[1].checked || radios[2].checked){
		var leaderName = document.getElementById("leaderName"+type).value;
		var mainDeptName = document.getElementById("mainDeptName"+type).value;
		var secendDeptName = document.getElementById("secendDeptName"+type).value;
		if(leaderName!=""){
			obj.value+="请"+leaderName+"同志阅";
		}
		if(mainDeptName!=""){
			if(obj.value!="")obj.value+="，";
			obj.value+="报"+mainDeptName+"主办部门";
		}
		if(secendDeptName!=""){
			if(obj.value!="")obj.value+="，";
			obj.value+="报"+secendDeptName+"协办部门";
		}
	}
	today = new Date();
	sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
	stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
	obj.value+=" "+"--${SYSTEM_USER_SESSION.name} "+sday+" "+stime;
}
function cleanChoose(){
	var osrc = event.srcElement;
	if(osrc.checked){
		return;
	}
	clearSay('draftOpinion');
	if(osrc.value!="1"){
		document.getElementById("leader1").value="";
		document.getElementById("leaderName1").value="";
		document.getElementById("person1").value="";
		document.getElementById("personName1").value="";
	}
	if(osrc.value!="2"){
		document.getElementById("leader2").value="";
		document.getElementById("leaderName2").value="";
		document.getElementById("mainDept2").value="";
		document.getElementById("mainDeptName2").value="";
		document.getElementById("secendDept2").value="";
		document.getElementById("secendDeptName2").value="";
	}
	if(osrc.value!="3"){
		document.getElementById("leader3").value="";
		document.getElementById("leaderName3").value="";
		document.getElementById("mainDept3").value="";
		document.getElementById("mainDeptName3").value="";
		document.getElementById("secendDept3").value="";
		document.getElementById("secendDeptName3").value="";
	}
	//document.getElementById("person4").value="";
	//document.getElementById("personName4").value="";
}
function chooseDept(tname,type){
	window.showModalDialog("<%=path%>/docSendRelatedAction.do?method=deptSel&type="+type+"&nameText="+tname,window,'dialogwidth:650px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
function changeOpinion(){
	var u = "--${SYSTEM_USER_SESSION.name} ";
	var obj = event.srcElement;
	if(obj.value.indexOf(u)<0){
		today = new Date();
		sday = fmtl(today.getYear(),4)+"-"+fmtl(today.getMonth()+1,2)+"-"+fmtl(today.getDate(),2);
		stime = fmtl(today.getHours(),2)+":"+fmtl(today.getMinutes(),2);
		obj.value+=" "+u+sday+" "+stime;
	}
}
function showColor(){
	return "red";
}
function alertError(){
	var errorString = "${errorString}";
	if(errorString!="" && errorString!="null"){
		alert(errorString);
	}
}
alertError();
function getInputTag(){
	return "<font color='red'>*</font>";
}
function selectleader(tid,tname,flag) {
	window.showModalDialog("<%=path%>/docRecRelateAction.do?method=selDealUser&fromDocRec=docRec&docId="+docRecBookForm.docId.value+"&idText="+tid+"&nameText="+tname+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
}
//-->
</script>
			<table width="99%" border="0" cellpadding="0" cellspacing="1">
				<tr><td align="center"><logic:equal name="isUrgent" value="1">
						<font color="red">加急!</font>
						</logic:equal></td>
				<td align="right">
			信息等级:
			<logic:empty name="docRecBookForm" property="infoLevel">
			<html:select property="infoLevel" onblur="chk();">
				<html:options collection="infoLevelList" property="id.code"/>
			</html:select>
			</logic:empty>
			<logic:notEmpty name="docRecBookForm" property="infoLevel">
			<bean:write name="docRecBookForm" property="infoLevel"/>
			</logic:notEmpty>
			&nbsp;
			</td></tr></table>
			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
				<thead>
					<tr>
			    		<td nowrap id="td_writeTime" width="100" height="24" align="center">成文日期</td>
			    		<td colspan="2">
			    			<html:text property="writeTime" onfocus="setday(this)" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" onblur="chk();" readonly="true"/>
			    		<font color="red">
    		            <span id="fwriteTime"></span>
    		            </font>
			    		</td>
			    	</tr>
					<tr>
			    		<td nowrap id="td_docDept" height="24" align="center">来文单位</td>
			    		<td colspan="2">
			    		<html:text property="docDept" maxlength="100" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" onblur="chk();" readonly="true"></html:text>
			    		<font color="red">
    		            <span id="fdocDept"></span>
    		            </font>
			    		<input id="selectDept" type="button" value="选择单位" onclick="chooseDept('docDept',2)" style="display:none" class="button0">
			    		</td>

			    	</tr>
			    	<tr>
			    		<td nowrap id="td_docCode" height="24" align="center">来文编号</td>
			    		<td colspan="2"><html:text property="docCode" maxlength="100" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" onblur="chk();" readonly="true"/>
			    		<font color="red">
    		            <span id="fdocCode"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_docNum" height="24" align="center">份数</td>
			    		<td colspan="2"><html:text property="docNum" maxlength="10" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" onkeydown="onlyNum();" onblur="chk();" readonly="true"></html:text>
			    		<font color="red">
    		            <span id="fdocNum"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_docPage" height="24" align="center">页数</td>
			    		<td colspan="2"><html:text property="docPage" maxlength="10" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" onkeydown="onlyNum();" onblur="chk();" readonly="true"></html:text>
			    		<font color="red">
    		            <span id="fdocPage"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_docType" height="24" align="center">归档类别</td>
			    		<td colspan="2">
			    		<html:select property="docType" onblur="chk();">
			    			<html:options collection="archiveTypeList" property="name"/>
			    		</html:select>
			    		<input id="docTypeName" name="docTypeName" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:200px" style="display:none" readonly>
			    		<font color="red">
    		            <span id="fdocType"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_docName" height="24" align="center">文件名称</td>
			    		<td colspan="2"><html:text property="docName" maxlength="100" style="color: 4c6a95;ext-indent: 1pt;height: 20px;border: 1px solid #a5a5a5;width:400px" onblur="chk();" readonly="true"/>
			    		<font color="red">
    		            <span id="fdocName"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_draftOpinion" align="center">拟办意见</td>
			    		<td colspan="2">
			    		<html:textarea property="draftOpinion" styleClass="tabin_textarea2"  readonly="true" cols="60" rows="5"></html:textarea>
			    		<table id="draftSelect" border="0" cellpadding="3" style="display:none" cellspacing="0" width="100%">
			    		<tr>
			    		<td width="200" nowrap>
			    		<html:radio property="draftRadio" value="1" onfocus="cleanChoose();" onchange="	disposerSay(this.value)">请领导阅</html:radio><br>
						</td>
						<td height="24">
						<input type="hidden" id="leader1" name="leader1" value="" />
			    		<input type="text" id="leaderName1" name="leaderName1" value="" class="tab_input2" readonly/>
			    		<input type="button" value="报领导" onclick="selectleader('leader1','leaderName1','1');disposerSay('1');" class="button0">
						<br>
						<input type="hidden" id="person1" name="person1" value="" />
			    		<input type="text" id="personName1" name="personName1" value="" class="tab_input2" readonly/>
			    		<input type="button" value="报其他人员" onclick="selectuser('participant','user','person1','personName1');disposerSay('1');" class="button0">
						</td>
						</tr>
						<tr><td>
			    		<html:radio property="draftRadio" value="2" onfocus="cleanChoose();" onchange="	disposerSay(this.value)">请领导阅示，拟请部门阅处</html:radio>
			    		</td>
			    		<td height="24">
			    		<input type="hidden" id="leader2" name="leader2" value="" />
			    		<input type="text" id="leaderName2" name="leaderName2" value="" class="tab_input2" readonly/>
			    		<input type="button" value="报领导" onclick="selectleader('leader2','leaderName2','0');disposerSay('2');" class="button0">
						<br>
			    		<input type="hidden" id="mainDept2" name="mainDept2" value="" />
			    		<input type="text" id="mainDeptName2" name="mainDeptName2" value="" class="tab_input2" readonly/>
			    		<input type="button" value="选择主办部门" onclick="selectdept('presider','dept','mainDept2','mainDeptName2');disposerSay('2');" class="button0">
						<br>
			    		<input type="hidden" id="secendDept2" name="secendDept2" value="" />
			    		<input type="text" id="secendDeptName2" name="secendDeptName2" value="" class="tab_input2" readonly/>
						<input type="button" value="选择协办部门" onclick="selectdept('participant','dept','secendDept2','secendDeptName2');disposerSay('2');" class="button0">
			    		</td></tr>
			    		<tr><td>
			    		<html:radio property="draftRadio" value="3" onfocus="cleanChoose();" onchange="	disposerSay(this.value)">请部门阅处，报领导</html:radio>
			    		</td>
			    		<td height="24">
			    		<input type="hidden" id="mainDept3" name="mainDept3" value="" />
			    		<input type="text" id="mainDeptName3" name="mainDeptName3" value="" class="tab_input2" readonly/>
			    		<input type="button" value="选择主办部门" onclick="selectdept('presider','dept','mainDept3','mainDeptName3');disposerSay('3');" class="button0">
						<br>
			    		<input type="hidden" id="secendDept3" name="secendDept3" value="" />
			    		<input type="text" id="secendDeptName3" name="secendDeptName3" value="" class="tab_input2" readonly/>
						<input type="button" value="选择协办部门" onclick="selectdept('participant','dept','secendDept3','secendDeptName3');disposerSay('3');" class="button0">
						<br>
			    		<input type="hidden" id="leader3" name="leader3" value="" />
			    		<input type="text" id="leaderName3" name="leaderName3" value="" class="tab_input2" readonly/>
			    		<input type="button" value="报领导" onclick="selectleader('leader3','leaderName3','0');disposerSay('3');" class="button0">
						</td></tr>
						<!--
						<tr>
			    		<td rowspan="2" width="200" nowrap height="24">
			    		<html:radio property="draftRadio" value="4" onfocus="cleanChoose();">传阅</html:radio><br>
						</td>
						<td>
						<input type="hidden" id="person4" name="person4" value="" />
			    		<input type="text" id="personName4" name="personName4" value="" class="tab_input2" readonly/>
			    		<input type="button" value="选择人员" onclick="selectuser('participant','user','person4','personName4');disposerSay('4');" class="button0">
						</td>
						</tr>
						-->
			    		</table>
			    		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			    		<tr><td></td></tr>
			    		<tr>
			    		<td nowrap id="td_bookUser" height="24" width="8%">登记人：</td>
			    		<td width="18%"><html:text property="bookUser" styleClass="tab_input3" readonly="true"/></td>
			    		<td nowrap id="td_auditUser" width="8%">&nbsp;拟办人：</td>
			    		<td width="18%"><html:text property="auditUser"  maxlength="100" styleClass="tab_input3" readonly="true"/></td>
			    		<td nowrap id="td_overDate" width="12%">&nbsp;拟办结日期：</td>
			    		<td><html:text property="overDate" maxlength="100" styleClass="tab_input3" readonly="true" onfocus="setday(this)"/>
			    		<font color="red">
    		            <span id="foverDate"></span>
    		            </font></td>
			    		</tr>
			    		</table>
		    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_leaderAudit" align="center" >领导批示</td>
			    		<td colspan="2">
			    		<html:textarea property="leaderAudit" styleClass="tabin_textarea2" readonly="true" cols="60" rows="5"></html:textarea>
			    		<table id="leaderSelect" border="0" cellpadding="0" style="display:none"
			    			cellspacing="1" width="100%">
			    		<tr>
			    		<td colspan="2" nowrap>
			    		<html:radio property="leaderRadio" value="1" onfocus="leaderSay('1')">已阅</html:radio><span id="leaderRidioLabel">，同意拟办意见</span><br>
						</td>
						</tr>
						<tr id="leaderChooseDept1"><td rowspan="2">
			    		<html:radio property="leaderRadio" value="2" onfocus="leaderSay('2')">阅处</html:radio>
			    		</td>
			    		<td>
			    		<input type="hidden" id="mainDept4" name="mainDept4" value="" />
			    		<input type="text" id="mainDeptName4" name="mainDeptName4" value="" class="tab_input2" readonly/>
			    		<input type="button" value="选择主办部门" onclick="selectdept('presider','dept','mainDept4','mainDeptName4');leaderSay('2');" class="button0">
						</td></tr>
						<tr id="leaderChooseDept2"><td>
			    		<input type="hidden" id="secendDept4" name="secendDept4" value="" />
			    		<input type="text" id="secendDeptName4" name="secendDeptName4" value="" class="tab_input2" readonly/>
			    		<input type="button" value="选择协办部门" onclick="selectdept('participant','dept','secendDept4','secendDeptName4');leaderSay('2');" class="button0">
			    		</td></tr>
			    		<tr><td colspan="2">
			    		<input type="button" value="驳回" onclick="clearSay('leaderAudit');returnback()" class="button0">
			    		</td></tr>
			    		</table>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_assUserRemark" align="center">相关人员记录</td>
			    		<td colspan="2">
			    		<html:textarea property="assUserRemark" styleClass="tabin_textarea2" readonly="true" cols="60" rows="5"></html:textarea>
			    		<table id="personSelect" border="0" cellpadding="0" style="display:none"
			    			cellspacing="1" width="100%">
			    		<tr>
			    		<td nowrap>
			    		<input type="radio" name="personRadio" id="personRadio" value="1" onfocus="personSay()">已阅<br>
						</td>
						</tr>
			    		<tr><td>
			    		<input type="button" value="驳回" onclick="clearSay('assUserRemark');returnback()" class="button0">
			    		</td></tr>
			    		</table>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_mainDeptOpinion" align="center">主办科室意见</td>
			    		<td colspan="2">
			    		<html:textarea property="mainDeptOpinion" styleClass="tabin_textarea2" readonly="true" cols="60" rows="5" onchange="changeOpinion()"></html:textarea>
			    		<table id="mainDeptSelect" border="0" cellpadding="0" style="display:none"
			    			cellspacing="1" width="100%">
			    		<tr><td>
			    		<input type="button" value="驳回" onclick="returnback()" class="button0">
			    		</td></tr>
			    		</table>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap id="td_dealState" align="center">办理情况</td>
			    		<td colspan="2"><html:textarea property="dealState" styleClass="tabin_textarea2" readonly="true" cols="60" rows="5" onchange="changeOpinion()"></html:textarea>
    		            <span id="fdealState"></span>
			    		</td>
			    	</tr>
					<tr>
						<td nowrap align="center">
							附件
						</td>
						<td colspan="2">
<logic:present name="files">	
<table>
	<logic:iterate id="Record" indexId="i" name="files" type="com.baosight.mode.TbDocAttach" >
		<tr id="tr${i}">
			<td>
			<html:link page="/docAttach.do?method=download" paramId="id" paramName="Record" paramProperty="id">
				<bean:write name="Record" property="originallyName"/>
			</html:link>
			<input type="button" onclick="deleteFile(${i})" value="删除" class="button0" />
			<input type="hidden" id="hid${i}" value="${Record.id}" />
			<input type="hidden" id="fileName${i}" value="${Record.originallyName}">
			<td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
							<table id="tb" cellpadding="0" cellspacing="0"></table>
							<div id="divBtnAdd">
								<input type="button" name="btnAddFile" value="添加附件" onclick="additem('tb')" class="button0"/>
								<font color="red">上传附件文件不能大于10M!</font>
							</div>
						</td>
					</tr>
				</thead>
			</table>
			<input type="hidden" id="backControl" name="backControl">
		<html:hidden property="docId"/>
		<html:hidden property="controlId"/>
		<html:hidden property="auditUserId"/>