<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbCommonalityComm"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type = (String)request.getParameter("type");
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
		<link href="<%=path%>/css/index-css.css" rel="stylesheet" type="text/css">
		<link href="images/style.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/css/CSS2.css" rel="stylesheet" type="text/css">
		<script src="<%=path %>/javascript/validate.js"></script>
	  	<script type="text/javascript" src="<%=path %>/javascript/cs.js"></script>
	  	<script type="text/javascript" src="<%=path %>/js/calendar.js"></script>
	  	<script type="text/javascript" src="<%=path%>/js/common.js"></script>

	</head>
	<body>
		<html:form action="/commonalityaction.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="5%" align="center" valign="middle">&nbsp;</td>
              <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
              <td width="84%" class="table2_topic">公共通讯录</td>
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
                  <th width="94%" height="30" align="right" valign="bottom"><img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnlist();" onmouseover="this.style.cursor='hand'"/></th>
                  <th width="6%" valign="bottom"></th>
                </tr>
			
			<tr>
                  <td colspan="2" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
					<tr>
			    		<td nowrap align="center"height="25" width="20%" class="bg-zwbt">姓名</td>
			    		<td colspan="2"><html:text property="name" maxlength="200" styleClass="shuruk4" onkeydown="" onblur="chk('name','fname',200,'true')"></html:text>
			    		<font color="red">*</font><font color="red">
    		            <span id="fname"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
					<tr>
			    		<td nowrap align="center" height="25"width="20%" class="bg-zwbt">职务</td>
			    		<td colspan="2"><html:text property="duty" maxlength="200" styleClass="shuruk4" onkeydown="" onblur="chk('duty','fduty',200,'false')"></html:text>
			    		<font color="red">
    		            <span id="fduty"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
			    	<tr>
			    		<td nowrap align="center" height="25" width="20%" class="bg-zwbt">联系电话</td>
			    		<td colspan="2"><html:text property="movePhone" maxlength="200" styleClass="shuruk4"  onkeydown="onlyNum();" onblur="chk('movePhone','fmovePhone',200,'true')"/>		
			    		<font color="red">*</font><font color="red">
    		            <span id="fmovePhone"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap align="center" height="25" width="20%" class="bg-zwbt">传真</td>
			    		<td colspan="2" align="left"><html:text property="fax" maxlength="200" styleClass="shuruk4"  onkeydown="onlyNum();" onblur="chk('fax','ffax',200,'false')"/>		
			    		<font color="red">
    		            <span id="ffax"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td nowrap align="center" width="20%" class="bg-zwbt">备注</td>
			    		<td colspan="2"><html:textarea property="remark" styleClass="shuruk5" cols="60" rows="5" onblur="chk('remark','fremark',200,'false')"></html:textarea>
			    		<font color="red">
    		            <span id="fremark"></span>
    		            </font>
			    		</td>
			    		
			    	</tr>
			    	
			    	<tr>
			    		<td colspan="3">
			    			<table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
								<tr><td colspan="3" align="left">所在组列表</td></tr>
								<%
								List selectedZu = (List)request.getAttribute("selectedZu");
								if (selectedZu!=null&&!selectedZu.isEmpty()&&selectedZu.size()>0)
								for (int i=0;i<selectedZu.size();i++){
									TbCommonalityComm obj = (TbCommonalityComm)selectedZu.get(i);
								%>
								<tr>
									<td align="center"><input type="checkbox" id="selectZuIdStr" name="selectZuIdStr" value="<%=obj.getId() %>" checked/></td>
									<td align="center"><%=obj.getName() %></td>
									<td align="center"><%=obj.getRemark()==null?"":obj.getRemark() %></td>
								</tr>
								<%} %>
			    		
			    		</table>
			    		</td>
			    	</tr>
			    	<tr>
					 <td align="left">
						<BUTTON ID="ofntColor" class="button0" TITLE="多组添加" onclick="selectZu();" onmouseover="this.style.cursor='hand'">多组添加</BUTTON>						
					 </td>
					 <td align="left" colspan="2">
					 </td>
					</tr>
					<tr>
						<td colspan="3" align="center">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>&nbsp;&nbsp;
						</td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="20" colspan="3"></td>
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
			<input type="hidden" name="parentid" value="<%=request.getAttribute("parentid") %>"/>
			<html:hidden property="id" />
			<input type="hidden" name="zuIds"/><!--组ids  -->
		</html:form>
		
		<script type="text/javascript">
		<!--
		
			//非空和长度验证
			function chk(id,fid,len,notnull)
			{
				if( notnull=="true"&&document.getElementById(id).value == "")
				{
					document.getElementById(fid).innerHTML = "不能为空";
					return false;	
				}
				else
				{
				    if(getLen(document.getElementById(id).value) > len)
				    {
						document.getElementById(fid).innerHTML = "长度不能大于"+len+"个字符,中文占2个字符,数字&字母占1个字符";
						return false;
					}
					else
					{
						document.getElementById(fid).innerHTML = "";
					}									
				}
			}
		
			function CheckForm()
				{
					var name = document.getElementById("name").value;
		    		var duty = document.getElementById("duty").value;
		    		var movePhone = document.getElementById("movePhone").value;
		    		var remark = document.getElementById("remark").value;
		    		var fax = document.getElementById("fax").value;
				
					if( name == ''||movePhone == '')
					{
						alert("数据输入不完整");
						return false;
					}
					if( getLen(name) > 200||getLen(duty) > 200||getLen(movePhone) > 200||getLen(fax) > 200||getLen(remark) > 200)
					{
						alert("数据输入过长");
						return false;
					}
					
					if(document.all.id.value=='')
					{
						document.all.method.value='add';
					}
					else
					{
						document.all.method.value='modify';
					}
					document.all.action.value='submit';
					document.forms[0].submit();
					return  true;
				}
			function onlyNum() 
				{ 
				if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39)) 
				if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105))) 
				event.returnValue=false; 
				}
				
			function returnlist(){
					
					window.location.replace("<%=path%>/commonalityaction.do?method=list&action=all&parentid=<%=request.getAttribute("parentid") %>");
	
					}
			function selectZu(){
	
			window.showModalDialog("<%=path %>/commonalityCommAction.do?method=treeList&type=<%=type%>&towhich=selectZu",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		
			}
		//-->
		</script>
	</body>
</html>