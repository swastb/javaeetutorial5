<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String action=request.getParameter("action");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'weekSecheduleedit.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" media="all" href="<%=path %>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />
		
		<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-zh.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/calendar-setup.js"></script>
		<script type="text/javascript" src="<%=path %>/js/common.js"></script>
		<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
		<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	
	function CheckForm(){
		if(tbVehiclesApplyForm.applyDept.value==""){
			alert("使用部门不能为空");
			return false;
		}
		
		if(tbVehiclesApplyForm.model.value==""){
			alert("车工型不能为空");
			return false;
		}
		if(tbVehiclesApplyForm.capacity.value==""){
			alert("人数不能为空");	
			return false;
		}
		if(tbVehiclesApplyForm.startTime.value==""){
			alert("时间不能为空");	
			return false;
		}
		
		if(document.all.id.value=='')
			document.all.method.value='add';
		else
			document.all.method.value='modify';
		document.all.action.value='submit';
		document.forms[0].submit();
		return true;
	}
	
	function setPage(){
		var action="<%=action%>";
		//设置页面为查看页面
		if(action=='view'){
			tbVehiclesApplyForm.startTime.setAttribute('onfocus',null);
			var obj=document.forms[0].getElementsByTagName("input"); 
			for (i=0;i<obj.length;i++){ 
				if (obj[i].type=="text") 
					obj[i].setAttribute('readOnly',true);
			}
			//提交按钮设为隐藏
            divSubmit.style.display="none";
		}
		//设置页面为审批页面
		if(action=='approval'){
			tbVehiclesApplyForm.startTime.setAttribute('onfocus',null);
			var obj=document.forms[0].getElementsByTagName("input"); 
			len=obj.length-9;
			for (i=0;i<len;i++){ 
				if (obj[i].type=="text") 
					obj[i].setAttribute('readOnly',true);
			}
            divSubmit.style.display="none";
			trAdr.style.display="";
			trOpinion.style.display="";
			tableApproval.style.display="";
			titleTop.innerText='用车审批管理';
			tdAdr.innerText='起始地点';
		}
	}
	
	function returnPage(){
		var action="<%=action%>";
		if(action=='approval')
			window.location='<%=path%>/tbVehiclesApplyApproval.do?method=list';
		else
			window.location='<%=path%>/tbVehiclesApply.do?method=list&action=all';
	}
	
	
</script>	
	
	</head>
	
	<body onload="setPage();">
	
		<html:form action="/tbVehiclesApply.do" >
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">用车申请</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnPage();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
				    		<td height="25" align="center">使用部门<span style="color: red">*</span></td>
				    		<td colspan="2" >
				    			<html:text property="applyDept" styleClass="shuruk1" size="12" maxlength="12"/>
				    		</td>
				    		<td align="center">核准人</td>
				    		<td>
				    			<html:text property="auditor" styleClass="shuruk1" size="10" maxlength="10"/>
							</td>
				    		<td  align="center" width="70">车型<span style="color: red">*</span></td>
				    		<td>
				    			<html:text property="model" styleClass="shuruk1" size="9" maxlength="9"/>
							</td>
				    	</tr>
				    	
				    	<tr>
				    		<td align="center" height="25" >人 数<span style="color: red">*</span></td>
				    		<td>
				    			<html:text property="capacity" styleClass="shuruk1" size="8" maxlength="8" onkeypress="if((event.keyCode<48||event.keyCode>57) && event.keyCode!=46){return false;}"    />
				    		</td>
				    		<td  align="center" >&nbsp;用车人</td>
				    		<td>
				    			<input type="text" size="10" class="shuruk1">
				    		</td>
				    		<td align="center">联系电话</td>
				    		<td colspan="2">
				    			<html:text property="phone" styleClass="shuruk1" size="18"/>
				    		</td>
				    	</tr>
				    	
				    	<tr>
				    		<td width="100" align="center"height="25" >时 间<span style="color: red">*</span></td>
				    		<td colspan="6">
				    			<html:text property="startTime" styleClass="shuruk1" size="20" onfocus="setday(this)" readonly="true" />
				    		</td>
				    	</tr>
				    	
				    	<tr>
				    		<td width="100" align="center"height="25" id="tdAdr">候车地点</td>
				    		<td colspan="2">
				    			<html:text property="startLoc" styleClass="shuruk1" size="18" />
				    		</td>
				    		<td align="center">目的地</td>
				    		<td colspan="3">
				    			<html:text property="dest" styleClass="shuruk1" size="31" />
				    		</td>
				    	</tr>
				    	
				    	<tr>
				    		<td width="100" align="center" height="25" >事   由</td>
				    		<td colspan="6">
				    			<html:text property="reason" styleClass="shuruk1" size="67"/>
				    		</td>
				    	</tr>
				
				    	<tr>
				    	
				    		<td  colspan="7" height="25" align="center"><b>以下由驾驶员填写</b></td>
				    	</tr>
				    	
				    	
				    	<tr>
				    		<td  align="center" height="25">营运里程</td>
				    		<td colspan="2" >
				    			<html:text property="attr1" styleClass="shuruk1" size="15" />公里
				    		</td>
				    		<td colspan="2" align="center">
				    			路桥费<html:text property="attr1" styleClass="shuruk1" size="10" /> 元
				    		</td>
				    		<td colspan="2" align="center">
				    			停车费<html:text property="attr1" styleClass="shuruk1" size="8" />元
				    		</td>
				    	</tr>
				    	
						<tr>
				    		<td  align="center" height="25" >出 省</td>
				    		<td colspan="2" >
				    			<html:text property="attr1" styleClass="shuruk1" size="18"/>
				    		</td>
				    		<td align="center">住宿</td>
				    		<td>
				    			<html:text property="attr1" styleClass="shuruk1" size="10" />
				    		</td>
				    		<td align="center">加班情况</td>
				    		<td>
				    			<html:text property="attr1" styleClass="shuruk1" size="7" />
				    		</td>
				    	</tr>
				    	
				    	<tr>
				    		<td colspan="7" align="center" height="25" class="bg-zwbt"><b>以下由调度员填写</b></td>
				    	</tr>
				    	
				    	<tr>
				    		<td  align="center" height="25">调度员</td>
				    		<td colspan="2" >
				    			<html:text property="dispatcher" styleClass="shuruk1" size="18" />
				    		</td>
				    		<td align="center">驾驶员</td>
				    		<td>
				    			<html:text property="driver" styleClass="shuruk1" size="18"/>
				    		</td>
				    		<td align="center">车号</td>
				    		<td><html:text property="license" styleClass="shuruk1" size="8"/></td>
				    	</tr>
				    	
				    	<tr id="trOpinion" style="display: none;">
				    		<td width="100" height="25"align="center">审批意见</td>
				    		<td colspan="6"><input type="text" class="shuruk1" size="67"></td>
				    	</tr>
				    	<tr>
				    		<td width="100" height="25"align="center">备  注</td>
				    		<td colspan="6"><html:text property="rem" styleClass="shuruk1" size="67"/>
				    		</td>
				    	</tr>
				    	<tr id="trAdr" style="display:none;">
				    		<td width="100" height="25"align="center">候车地点</td>
				    		<td colspan="6"><input type="text" class="shuruk1" size="67"></td>
				    	</tr>
				    	<tr>
				    		<td colspan="7"height="25" align="left" class="bg-zwbt">&nbsp;用车后签字:</td>
				    	</tr>
					
						<tr>
							<td colspan="7" align="center">
								<div id="divSubmit">
									<a onclick="CheckForm();">
									<img src="<%=path%>/imagine/tj.gif" width="52" height="23">
		    		 				</a>
	    		 				</div>
	    		 				<table id="tableApproval" style="display:none;">
									<tr class="bg-zwbt">
										<td width="66" onclick="window.location='<%=path%>/tbVehiclesApplyApproval.do?method=modify&action=4&id='+tbVehiclesApplyForm.id.value" onmouseover="this.style.cursor='hand'" align="center" height="21" background="<%=path%>/imagine/bt-d.gif">同意</td>
										<td width="26"></td>
										<td width="66" onclick="window.location='<%=path%>/tbVehiclesApplyApproval.do?method=modify&action=8&id='+tbVehiclesApplyForm.id.value" onmouseover="this.style.cursor='hand'" align="center" height="21" background="<%=path%>/imagine/bt-d.gif">驳回</td>
									</tr>
								</table>
								
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
              <td height="10"></td>
            </tr>
          </table></td>
        </tr>
      </table>
				<input type="hidden" name="action" />
				<input type="hidden" name="method" />
</table>
				<html:hidden property="id" />
		</html:form>
	</body>
</html>



