
<%@ page language="java" import="java.util.*,com.baosight.tools.ChangeUtil" pageEncoding="GBK"%>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	int i=1;
	String xzxkpath=ChangeUtil.xzxkurl;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<%=path%>/js/calendar-dong.js"></script>
		<script type="text/javascript">
		
		function selectdept(flag,argDeptOrUser)
		{
			window.showModalDialog("<%=path%>/orgtreeaction.do?method=listCheckedUser&nodetype=deptnode&nodeid=e584b88cc02f49c0b0da6db657f8fd83&roleid=851a36fb19078db2011907a09e390003&source=meetingeditdept&deptOrUser="+argDeptOrUser+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}
   		var num = 0; 
	  	
	    function additem(id){
     		var row,cell,str; 
			row = eval("document.all["+'"'+id+'"'+"]").insertRow();
     		if(row != null ){
	        	cell = row.insertCell();
				str="<input type='file' name=uploadFile["+ num +"].file onkeydown='event.returnValue=false;' onpaste='return false'><input type='button' class='button0' value=' 删除 ' onclick='deleteitem(this,"+'"'+"tb"+'"'+");'>";
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
    
		function CheckForm(){

			if(archivesEditForm.title.value==""){
				alert("标题不能为空");
				return false;
			}
			if(archivesEditForm.fileId.value==""){
				alert("文号不能为空");
				return false;
			}
			if(!CheckDate(archivesEditForm.createTime.value)) 
				return false;
			if(archivesEditForm.keywords.value==""){
				alert("关键字不能为空");
				return false;
			}
			if(archivesEditForm.presidername.value==""){
				alert("发文机关不能为空");
				return false;
			}
			if(archivesEditForm.abstract.value.length >= 100){
				alert("内容描述长度不能大于100字符或文字");
				return false;
			}
			var objInput=document.forms[0].getElementsByTagName("input"); 
			for (i=0;i<objInput.length;i++){ 
				if (objInput[i].type=="file"){
					var len=objInput[i].value.length;
					var filename=objInput[i].value.substr(len-4,len).toLowerCase();
					if(filename=='.exe'){
						alert("不能上传可执行文件");
						return false;
					}
				} 
			}
			if(document.all.id.value=='')
				document.all.method.value='add';
			else
				document.all.method.value='modify';
			document.all.action.value='submit';
			document.forms[0].submit();
			return true;
		}
		
		function init(){
			var view=<%=request.getParameter("view")%>;
			var method="<%=request.getParameter("method")%>";
			var objInput=document.forms[0].getElementsByTagName("input"); 
			var objSel=document.forms[0].getElementsByTagName("select"); 
			if(view==1||view==2){
				for (i=0;i<objInput.length;i++){ 
					if (objInput[i].type=="text") 
						objInput[i].setAttribute('readOnly',true);
					if (objInput[i].type=="button") 
						objInput[i].style.display="none";
				}
				for (i=0;i<objSel.length;i++){ 
					
						objSel[i].setAttribute('disabled',true);
				}
				document.forms[0].abstract.setAttribute('disabled',true);
				document.forms[0].createTime.setAttribute('onclick',null);
				//提交按钮设为隐藏
				divBtnAdd.style.display="none";
	            divSubmit.style.display="none";
	            DivBtn.style.display='none';
	            linkdept.style.display='none';
	            linkclear.style.display='none';
			}
			if(method=='add'){
				DivBtn.style.display='none';
			}
			isNopubdescDisabled();
			messageInit();
			
		}
		function deleteFile(obj){
			if(confirm('确认删除?')){
				var tr=document.getElementById("tr"+obj);
				var hidden=document.getElementById("hid"+obj);
				tr.style.display='none';
				archivesEditForm.delId.value=archivesEditForm.delId.value+hidden.value+'-';
			}
		}
		function dispatch(){
			var view=<%=request.getParameter("view")%>;
			if(view==1)
				window.location='<%=path%>/pigeonholedArchivesListAction.do?method=pigeonholedArchivesList';
			else if(view==2)
				window.location='<%=path%>/auditListAction.do?method=auditList';
			else
				window.location='<%=path%>/archivesListAction.do?method=noPigeonholeList';
		}
	
function CheckDate(strDate)
{	
    var reg=/^(\d{4})([-])(\d{2})([-])(\d{2})/;
    if(!reg.test(strDate)||strDate.length!=10)  {
        alert("日期格式不正确!\n正确格式为:2004-01-01");
        return false;
    }
    
    var ss=strDate.split("-");
    var year=ss[0];
    var month=ss[1];
    var date=ss[2];
    if(!checkYear(year)){return false;}
    if(!checkMonth(month)){return false;}
    if(!checkDate(year,month,date)){return false;}
    return true;
}

function checkYear(year)
{
    if(isNaN(parseInt(year)))
    {
        alert("年份输入有误,请重新输入!"); 
        return false;
    }
    else if(parseInt(year)<1950 || parseInt(year) >2050)
    { 
        alert("年份应该在1950-2050之间!"); 
        return false
    }
    else 
        return true;
}

function checkMonth(month)
{
	if(month=="08"||month=="09") 
		return true; 
    if(isNaN(parseInt(month)))
    {
        alert("月份输入有误,请重新输入!"); 
        return false;
    }
    else if(parseInt(month)<1 || parseInt(month) >12)
    { 
    	
        alert("月份应该在1-12之间!"); 
        return false
    }
    else 
        return true;
}

function checkDate(year,month,date)
{
    var daysOfMonth=CalDays(parseInt(year),parseInt(month));
    if(isNaN(parseInt(date)))
    {
        alert("日期输入有误,请重新输入!"); 
        return false;
    }
    else if(parseInt(date)<0||parseInt(date)>daysOfMonth)
    { 
        alert("日期应该在1-"+daysOfMonth+"之间!"); 
        return false;
    }
    else 
        return true;
}

function CalDays(year,month)
{
    var date= new Date(year,month,0);
    return date.getDate();
}

function isLeapYear(year)
{
    if((year %4==0 && year %100!=0) || (year %400==0)) return true;
    else return false;
}
//根据判断公开类别的选择内空来设置免于公开理由是否可选
function isNopubdescDisabled(){
	var nopubdesc=document.getElementById("nopubdescId");
	var pub=document.getElementById("pubId");
	if(pub.value=='2')
		nopubdesc.removeAttribute("disabled");
	else
		nopubdesc.setAttribute("disabled","disabled")
}
function temp(id){
	window.open("<%=path %>/archivesEdit.do?method=download&id="+id,"_blank");
	//window.open("<%=path %>/UploadFile/Document Management/"+filename,"_blank");
}

function xzxk(id){
	window.open("<%=path %>/archivesEdit.do?method=download&id="+id+"&state=xzxk","_blank");
}

function messageInit(){

  if("${applyid}"!='')
  {
	  var xmlResult=httpGet("<%=xzxkpath%>/byid.do?method=messageInit&processid=${applyid}");
	  if(xmlResult!=null)
	  {
			var fun =xmlResult.getElementsByTagName("function");
			var len = fun.length;
	
			for (i = 0; i < len; i++) 
			{
	            var buzstatus = getData(i, "buzstatus", fun);
	            var sdststus = getData(i, "sdststus", fun);
				var xzxkstatus = getData(i, "xzxkstatus", fun);
				var nxzxkstatus = getData(i, "nxzxkstatus", fun);
				var gqstatus = getData(i, "gqstatus", fun);
			    if(buzstatus=="2")
			    {
			       document.getElementById("buzstatus").style.display="block";;
			    }
			    
			    if(sdststus=="1")
			    {
			       document.getElementById("sdststus").style.display="block";;
			    }
			    
			    if(gqstatus=="2")
			    {
			       document.getElementById("gqstatus").style.display="block";;
			    }
	        }
	   }
   }

}

function jds(){
	window.open("<%=xzxkpath%>/xzxk.do?method=xzxkFindbyiddayin&action=before&id=${applyid}","_blank");
}
function sjpz(){
	window.open("<%=xzxkpath%>/stuff.do?method=sjpz&action=before&id=${applyid}&iframeid=sxclframe","_blank");
}
function clqd(){
	window.open("<%=xzxkpath%>/stuff.do?method=list&id=${applyid}&iframeid=sxclframe&title="+"材料清单"+"&go=listdayins&action=before&f_shoulihao=${applyno}","_blank");
}
function lzd(){
	window.open("<%=xzxkpath%>/stuff.do?method=prossList&action=before&activateid=&type=prosslistdayin&id=${applyid}&table=${type}&f_linkman=${f_linkman}","_blank");
}

function bzcl(){
	window.open("<%=xzxkpath%>/bzcltz.do?method=bzclFindbyiddayin&action=before&id=${applyid}","_blank");
}

function gqtz(){
	window.open("<%=xzxkpath%>/gqtz.do?method=gqFindbyiddayin&action=before&id=${applyid}","_blank");
}

function sdhz(){
	window.open("<%=xzxkpath%>/songda.do?method=findbyid&action=before&type=1&id=${applyid}","_blank");
}

function sqbDayin(){
	window.open("<%=xzxkpath%>/stuff.do?method=sqbDayin&porcessid=${applyid}&flag=MAINTABLE&type=${type}","_blank");
}


function httpGet(sUrl)
{

var sErrXML="<?xml version=\"1.0\" encoding=\"GBK\" ?><xml><msg>link error</msg><data></data></xml>";
var activex=getXmlHttp();
var oXML;
try
{
activex.Open("GET",sUrl,false);
activex.send();
oXML=activex.responseXML.documentElement;
if(oXML==null || !oXML.childNodes.length){throw "";}
}
catch(e)
{
activex=getXmlDocument();
activex.loadXML(sErrXML);
oXML=activex.documentElement;
}
return oXML;
}

function getXmlHttp()
{
var activex;
try
{
activex=new ActiveXObject("Microsoft.XMLHTTP");
activex.abort();
}
catch(e)
{
activex=new ActiveXObject("Msxml2.XMLHTTP");
}
return activex;
}

function getXmlDocument()
{
var activex=new ActiveXObject("Microsoft.XMLDOM");
if (activex==null || activex.documentElement==null || activex.documentElement.childNodes==null)
  {
   activex=new ActiveXObject("Msxml2.DOMDocument");
   //activex=new ActiveXObject("Msxml2.DOMDocument.3.0");
  }
return activex;
}

function getData(index, tagName, obj) {
	
	if (index >= obj.count) {
		return "index overflow";
	}
	var node = obj[index];
	
	
	
	if(node.getElementsByTagName(tagName)[0].firstChild==null || tagName+"tagName="+node.getElementsByTagName(tagName)[0].firstChild=="null")
	{
	  var str="";
	  
	}else
	{
	  if(node.getElementsByTagName(tagName)[0].firstChild.data==null || node.getElementsByTagName(tagName)[0].firstChild.data=="null")
	  {
	     var str="";
	     
	  }else
	  {
	     var str = node.getElementsByTagName(tagName)[0].firstChild.data;
	  }
	}

	
	return str;
}




	</script>
	</head>
	<body onload="init();">
		<html:form action="/archivesEdit.do" enctype="multipart/form-data" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin:0px">
		     	<tr>
			    	<td width="288" height="40" align="left" valign="middle" background="images/8-1.gif">
			        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
				        	<tr>
				            	<td width="5%" align="center" valign="middle">&nbsp;</td>
				            	<td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
				            	<td width="84%" class="table2_topic">档案编辑</td>
				            </tr>
			          	</table>
					 </td>
			         <td background="images/8-2.gif">&nbsp;</td>
		        </tr>
		    </table>
			<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
			    <tr>
			    <td align="center" valign="top">
				    <table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
		                <tr>
		                	<th width="94%" height="30" align="right" valign="bottom">
			                	<img src="<%=path%>/images/fh.gif" width="46" height="25" onclick="dispatch();" onmouseover="this.style.cursor='hand'">
								&nbsp;
						  	</th>
		                    <th width="6%" valign="bottom"></th>
		                </tr>
		                <tr>
		                	<td colspan="2" align="center" valign="top">
								<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
									<tr>
										<td width="15%" height="25">索取号</td>
										<td colspan="2">
											<html:text property="applyId" maxlength="25"  styleClass="shuruk1"/>
										</td>
									</tr>
									<tr>
										<td height="25" >标题</td>
										<td colspan="2">
											<html:text property="title" maxlength="100" styleClass="shuruk1"></html:text>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="25">文号</td>
										<td colspan="2">
											<html:text property="fileId" maxlength="25" styleClass="shuruk1" />
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="25">成文日期</td>
										<td colspan="2">
											<html:text property="createTime" styleClass="shuruk1"  onclick="setday(this)" />
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="25">发文机关</td>
										<td colspan="2">
											<table width="100%" >
												<tr>
													<td width="25%">
										    			<html:text property="presidername" readonly="true" styleClass="shuruk1" />
									    				<font color="red">*</font>
									    				<input type="hidden" name="presider"/>
										    			<html:hidden property="presideDept"/>
										    		</td>
								    				<td>
														<div id="linkdept" ><input onclick="selectdept('presider','dept');"  type="button" class="button0" value="选择部门"><br/><br></div>
														<div id="linkclear"><input onclick="archivesEditForm.presidername.value='';archivesEditForm.presideDept.value=''"  type="button" class="button0" value="清空"></div>
													</td>
									    		</tr>
								    		</table>
										</td>
									</tr>
									<tr>
										<td height="25">主题</td>
										<td colspan="2">
											<html:select property="topicId" name="archivesEditForm">
												<html:options collection="topicList" property="topicId" labelProperty="topicName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">公文种类</td>
										<td colspan="2">
											<html:select property="cateId" name="archivesEditForm">
												<html:options collection="offDocCateList" property="cateId" labelProperty="cateName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">公开类别</td>
										<td colspan="2">
											<html:select property="pubId" name="archivesEditForm" onchange="isNopubdescDisabled();" >
												<html:options collection="pubList" property="pubId" labelProperty="pubName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">免于公开理由</td>
										<td colspan="2">
											<html:select  property="nopubdescId" name="archivesEditForm">
												<html:options collection="nopubdescList" property="nopubdescId" labelProperty="nopubdescName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">关键词</td>
										<td colspan="2">
											<html:text property="keywords" maxlength="30" styleClass="shuruk1"></html:text>
											<font color="red">*</font>
										</td>
									</tr>
									<tr>
										<td height="25">载体类型</td>
										<td colspan="2">
											<html:select property="formatId" name="archivesEditForm">
												<html:options collection="formatList" property="formatId" labelProperty="formatName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">记录形式</td>
										<td colspan="2">
											<html:select property="typeId" name="archivesEditForm">
												<html:options collection="typeList" property="typeId" labelProperty="typeName" />
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">是否为规范性文档</td>
										<td colspan="2">
											<html:select property="normalsign">
												<html:option value="1">是</html:option>
												<html:option value="0">否</html:option>
											</html:select>
										</td>
									</tr>
									<tr>
										<td height="25">是否为重大决定草案</td>
										<td colspan="2">
												<html:select property="draftsign">
													<html:option value="1">是</html:option>
													<html:option value="0">否</html:option>
												</html:select>
										</td>
									</tr>
									<tr>
										<td align="center">内容描述</td>
										<td colspan="2">
												<html:textarea property="abstract" rows="5" cols="35" style="border: 1px none;color: 4c6a95;text-indent: 1pt;height: 100px;width: 50%;border: 1px solid #a5a5a5;" /><br>
												<font color="red">内容描述长度不能大于100字符或文字</font>
										</td>
									</tr>
									
									<tr>
										<td align="center">附件</td>
										<td colspan="2">
											<table>	
												<c:forEach var="content" items="${files}" varStatus="loop">
													<tr id="tr<%=i%>">
														<td>
														<a onmouseover="this.style.cursor='hand'" onclick="temp('${content.id}');">${content.originallyName}</a>
										    			<input type="button" class="button0" onclick="deleteFile(<%=i%>)" value=" 删除 "  />
														<input type="hidden" id="hid<%=i%>" value="${content.id}" />
														<td>
													</tr>
													<%i++; %>
													</c:forEach>	
											</table>

											<table>
									       		<c:forEach var="content" items="${stuffList}" varStatus="loop">
									       		  <c:if test="${content.upload != '' && content.upload != null}">
											   		<tr>
														<td>
														<a onmouseover="this.style.cursor='hand'" onclick="xzxk('${content.id}');">${content.name}</a>
														<td>
													</tr>
												 </c:if>
											    </c:forEach>
											    <c:if test="${applyid != '' && applyid != null}">
											   		<tr>
														<td>
														<a onmouseover="this.style.cursor='hand'" onclick="jds();">决定书</a>
														<td>
													</tr>
													
													<tr>
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="sjpz();">收件凭证</a>
														<td>
													</tr>
													
													<tr>
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="clqd();">材料清单</a>
														<td>
													</tr>
													<tr>
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="lzd();">流转单</a>
														<td>
													</tr>
													
													<tr id="buzstatus" style="display:none">
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="bzcl();">补正材料通知</a>
														<td>
													</tr>
													
													<tr id="gqstatus" style="display:none">
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="gqtz();">挂起</a>
														<td>
													</tr>
													<tr id="sdststus" style="display:none">
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="sdhz();">送达回执</a>
														<td>
													</tr>
													<tr>
													    <td>
														<a onmouseover="this.style.cursor='hand'" onclick="sqbDayin();">申请表</a>
														<td>
													</tr>
												 </c:if>
			                                </table>
			    
											<table id="tb"></table>
											<div id="divBtnAdd">
												<input type="button" class="button0" name="btnAddFile" value="添加附件" onclick="additem('tb')"/>
												<font color="red">上传附件文件不能大于10M!</font>
											</div>
										</td>
									</tr>
								
									<tr>
										<%--<td colspan="3" align="center">
											<div id="DivBtn">
												<input type="button" class="button0" value=" 归档 " onclick="window.location='archivesEdit.do?method=archivesStatus&id='+document.all.id.value;"/>
											</div>
											<div id="divSubmit">
												<input type="button" class="button0" value=" 提交 " onclick="CheckForm();"/>
											</div>
										</td>
									--%>
									<td colspan="3" align="center">
										<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
									
											<tr>
												<td align="right" width="30%" height="25">
											<div id="DivBtn">
												<input type="button" class="button0" value=" 归档 " onclick="window.location='archivesEdit.do?method=archivesStatus&id='+document.all.id.value;"/>
											</div>
												</td>
												<td width="10%"></td>
												<td  width="60%">
											<div id="divSubmit">
												<input type="button" class="button0" value=" 提交 " onclick="CheckForm();"/>
											</div>
												</td>
											</tr>
											
										</table>
									</td>
									
									
									</tr>
								</table>
							</td>
						</tr>	
					</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="delId"  />
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="path" value="<%=path%>" />
			<html:hidden property="id" />
		</html:form>
		
	</body>
</html>
