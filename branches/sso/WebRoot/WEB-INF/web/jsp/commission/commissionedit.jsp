<%@ page language="java" import="java.util.*,java.text.*,com.baosight.mode.TbUser" pageEncoding="GBK"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ include file="/WEB-INF/web/inc/ajaxInclude.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<script src="../../../../javascript/validate.js"></script>
		<script type="text/javascript" src="<%=path%>/js/common.js"></script>
		<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	</head>
	<body>
		<html:form action="/commission.do">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">委托办理</td>
            </tr>
          </table></td>
          <td background="images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnList();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    		<td width="20%" align="left" style="noswap">委托名</td>
			    		<td valign="top"><html:text property="commTitle" styleClass="shuruk2" size="50" maxlength="64"/>
			   				<font color="red">
    		            <span align="left" id="fcommTitle"></span></font>　　　　　　
			   			</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">委托人</td>
			    		<td><html:text property="commName" size="50" styleClass="shuruk2" onkeydown="notNull();" onblur="chk()" readonly="true" maxlength="32"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">被委托人</td>
			    		<td><html:text property="becommedName" size="50" styleClass="shuruk2" onkeydown="notNull();" onblur="chk()" onclick="selectuser('presider','becommedId','becommedName')"/>
			    		<font color="red">
    		            <span align="left" id="fbecommedName"></span></font></td>
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">开始时间</td>
			    		<td colspan="1"><html:text property="begintime" styleClass="shuruk2" size="50" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
			    		<font color="red">
    		            <span align="left" id="fbeginTime"></span></font>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left" style="noswap">结束时间</td>
			    		<td><html:text property="endtime" size="50" styleClass="shuruk2" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
			    		<font color="red">
    		            <span align="left" id="fendTime"></span></font>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td width="20%" align="left"style="noswap">委托事项</td>
			    		<td>
			    		<html:textarea  property="commMatters" styleClass="shuruk5" cols="74" rows="12" onkeydown="notNull();" onblur="chk();"/>
			    		</td>
			    		
			    	</tr>
					
					<tr>
						<td colspan="2" align="center">
							<input type="button" class="button0" value="同意" onclick="CheckForm('1')">&nbsp;&nbsp;
							<input type="button" class="button0" value="暂存" onclick="CheckForm('2')">
						</td>
					</tr>
				 </table></td>
                </tr>
                <tr>
                  <td height="20" colspan="2"></td>
                </tr>
                
              </table></td>
            </tr>
            <tr>
              <td height="10" ></td>
            </tr>
          </table></td>
        </tr>
      </table>
			<html:hidden property="commId"/><!-- 委托人ID -->
			<html:hidden property="becommedId" /><!-- b委托人ID -->
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="saveType" />
			<input type="hidden" id="result" name="result"/>
			<html:hidden property="id" />

<input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="6aa35341f25184fd996c4c918255c3ae">
		
		</html:form>      
	</body>
</html>
<script  language="javascript">
	
	function chk(){
		var commTitle = document.getElementById("commTitle").value;
		var becommedName = document.getElementById("becommedName").value;
		var beginTime = document.getElementById("begintime").value;
		var endTime = document.getElementById("endtime").value;
		if(commTitle == ""){
			document.getElementById("fcommTitle").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
		}
		if(becommedName == ""){
			document.getElementById("fbecommedName").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
		}
		if(beginTime == ""){
			document.getElementById("fbeginTime").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
		}
		if(endTime == ""){
			document.getElementById("fendTime").innerHTML = "<font color='red'>"+"*不能为空"+"</font>";
			return false;	
		}
	}

	function CheckForm(saveType){
		var commTitle = document.getElementById("commTitle").value;
		var becommedName = document.getElementById("becommedName").value;
		var beginTime = document.getElementById("begintime").value;
		var endTime = document.getElementById("endtime").value;
		document.getElementById("saveType").value=saveType;
		//isSameDept();
		if(commTitle == "" || becommedName == "" || beginTime == "" || endTime == "") {
			alert("输入数据不完整！"); return false;
		}
		if (compareDate(beginTime,endTime)) {
			alert("开始时间要小于结束时间！"); return false;
		}
		if(document.all.id.value=='')
		{
			document.all.method.value='addCommission';
		}
		else
		{
			document.all.method.value='modCommission';
		}
			document.all.action.value='submit';
			document.forms[0].submit();
			return  true;
	}	
	function returnList(){
      window.location.replace("<%=path%>/commission.do?method=commissionList&type=1");
      
	}
	function compareDate(DateOne,DateTwo)
	{ 
		var OneMonth = DateOne.substring(5,DateOne.lastIndexOf ("-"));
		var OneDay = DateOne.substring(DateOne.length,DateOne.lastIndexOf ("-")+1);
		var OneYear = DateOne.substring(0,DateOne.indexOf ("-"));
		
		var TwoMonth = DateTwo.substring(5,DateTwo.lastIndexOf ("-"));
		var TwoDay = DateTwo.substring(DateTwo.length,DateTwo.lastIndexOf ("-")+1);
		var TwoYear = DateTwo.substring(0,DateTwo.indexOf ("-"));
		
		if (Date.parse(OneMonth+"/"+OneDay+"/"+OneYear) >
		Date.parse(TwoMonth+"/"+TwoDay+"/"+TwoYear))
		{
		return true;
		}
		else
		{
		return false;
		}

	}
	function selectuser(flag,tid,tname){
		window.showModalDialog("<%=path%>/commission.do?method=userTreeForSameDept&idText="+tid+"&nameText="+tname+"&flag="+flag,window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
	}
	function isSameDept() {
		startRequest();
		if (document.getElementById("result").value=="false") {alert("请选择同部门的被委托人！");}
	}
	var http_request;
function createXMLHttpRequest(){
	if(window.XMLHttpRequest) {
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
			http_request.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) { 	
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}	
function startRequest(){
	var url = "";
	var becommedId = document.getElementById("becommedId").value;
	url = "commission.do?method=isSameDept&becommedId="+becommedId;
	createXMLHttpRequest();
	http_request.onreadystatechange = handlestatechange
	http_request.open("post",url,false);
	http_request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	http_request.setRequestHeader("Cache-Control","no-cache"); 
	http_request.send(null);				  		
}
function handlestatechange(){
	if (http_request.readyState==4){
		if (http_request.status==200){
			var result = http_request.responseText;
			document.getElementById("result").value=result;									
		}
	}
}
</script>


