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
String parentid=(String)request.getAttribute("parentid");
String p_name=(String)request.getParameter("p_name");
String type=(String)request.getParameter("type");
String fromWhere = (String)request.getAttribute("fromOther");
String lsh_type = (String)request.getAttribute("lsh_type");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
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
		<html:form action="/govinfopubContentaction.do">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="100%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="288" height="40" align="left" valign="middle" background="images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="5%" align="center" valign="middle">&nbsp;</td>
                  <td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
                  <td width="84%" class="table2_topic">政府信息发布</td>
                </tr>
            </table></td>
            <td background="images/8-2.gif">&nbsp;</td>
          </tr>
        </table>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td>
          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
                <tr>
                  <th height="30" valign="bottom"></th>
                </tr>
                <tr>
                  <td align="center" valign="top">
                  <table width="99%" border="0" cellspacing="0" cellpadding="0">
                    	 <tr>
             				<td align="right">
							<img src="<%=path%>/images/fh.gif" width="46" height="25" border="0"  onclick="returnList();" onmouseover="this.style.cursor='hand'"/>
							
							&nbsp;&nbsp;</td>
          				</tr>
        			  </table> 
                  
  	    <table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin1_in">
				   <tr>
			    		<td width="10%" align="left" style="noswap">公开类型</td>
			    		<td colspan="3">
			    		<html:select property="publishType" styleClass="bot_select"> 
			    		<html:option value="10">主动公开信息</html:option>
			    		<html:option value="20">申请公开信息</html:option>
			    		<html:option value="30">免于公开信息</html:option>
			    		</html:select>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">标题</td>
			    		<td colspan="3"><html:text property="title" styleClass="shuruk1" onkeydown="notNull();" onblur="chk()"/>
			    		<font color="red">
    		            <span align="left" id="ftitle"></span>
    		            <span align="left" id="infocommNameCheck"></span>
    		            </font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">文件编号</td>
			    		<td width="40%"><html:text property="fileCode" styleClass="shuruk1"/></td>
			    		<td width="10%" align="left" style="noswap">发布机构</td>
			    		<td width="40%"><html:text property="infoSource" styleClass="shuruk1"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">索取号</td>
			    		<td width="40%"><html:text property="applyId" styleClass="shuruk1" readonly="true"/></td>
			    		<td width="10%" align="center" style="noswap">载体类型</td>
			    		<td width="40%">
			    		<html:select property="offerWay" styleClass="bot_select">
			    		<html:option value="4">纸制</html:option>
			    		<html:option value="5">胶卷</html:option>
			    		<html:option value="6">磁带</html:option>
			    		<html:option value="7">磁盘</html:option>
			    		<html:option value="8">光盘</html:option>
			    		</html:select>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">关键字</td>
			    		<td colspan="3"><html:text property="keyword" styleClass="shuruk1"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">审批</td>
			    		<td width="40%">
			    		<html:select property="status" styleClass="bot_select">
			    		<html:option value="1">不用审核</html:option>
			    		<html:option value="2">待审核</html:option>
			    		</html:select>
			    		</td>
			    		<td width="10%" align="left" style="noswap">作者</td>
			    		<td width="40%"><html:text property="authorName" styleClass="shuruk1"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">创建时间</td>
			    		<td colspan="3"><html:text property="createTime" styleClass="shuruk1" onfocus="setday(this)" readonly="true" onkeydown="notNull();" onblur="chk()"/>
			    		<font color="red">
    		            <span align="left" id="fcreateTime"></span></font>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td width="10%" align="left" style="noswap">简介</td>
			    		<td colspan="3"><html:text property="summary" styleClass="shuruk1"/>
			    		</td>
			    	</tr>
			    	<tr>
			    		<td align="center" colspan="4" style="noswap">信息内容</td>
			    	</tr>
			    	<tr>
						<td colspan="4">
						<IFRAME ID="eWebEditor1" name="content_html" src="eWebEditor/eWebEditor.jsp?id=content&style=standard&from=govInfoPub" frameborder="0" scrolling="no" width="670" height="350"></IFRAME>
						<html:hidden property="content" styleClass="shuruk2"/>
						
						</td>
					</tr>
					<tr>
					 <td colspan="4" align="left">
						<BUTTON class="button0" ID="ofntColor" TITLE="发布为其他信息" onclick="selectCla('more','infopub');" onmouseover="this.style.cursor='hand'">发布为其他信息</BUTTON>						
					 </td>
					</tr>
					<tr>
							<td colspan="4" align="center">
								<a onclick="CheckForm();"
    		 		onmouseover="this.style.cursor='hand'"><img src="<%=path%>/imagine/tj.gif" width="52" height="23"></a>
						
						</td>
					</tr>
			</table>
			</td>
                </tr>
                <tr>
                  <td height="20"></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="8"></td>
            </tr>
          </table>
          </td>
      </tr>
    </table>
      </td>
  </tr>
</table> 
			<html:hidden property="clasel"/>
			<input type="hidden" name="infoclas" /><!-- 多栏目 -->
			<input type="hidden" name="action" />
			<input type="hidden" name="method" />
			<input type="hidden" name="p_name" value=<%=p_name %> />
            <input type="hidden" name="parentid" value="<%=parentid %>"/>
            <input type="hidden" name="lsh_type" value="<%=lsh_type %>"/>
			<html:hidden property="id" />

<input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="6aa35341f25184fd996c4c918255c3ae">
		
		</html:form> 
        <OBJECT id="dlgHelper" CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" width="0px" height="0px"></OBJECT> 	    	
	</body>
</html>
<script  language="javascript">
function chk(){
		var title = document.getElementById("title").value;
		var createTime = document.getElementById("createTime").value;
		
		if(title == ""){
			document.getElementById("ftitle").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
			return false;	
				
		}else{
			if(getLen(document.getElementById("title").value) > 100){
				document.getElementById("ftitle").innerHTML = "<font color='red'>"+"长度不能大于100个字符,中文占2个字符,数字&字母占1个字符"+"</font>";			
				return false;	
			}
			else{document.getElementById("ftitle").innerHTML = "";}
		}
		
		if(createTime == ""){
			document.getElementById("fcreateTime").innerHTML = "<font color='red'>"+"不能为空"+"</font>";
			return false;	
		}
		
}

function CheckForm(){
	var title = document.getElementById("title").value;
	var createTime = document.getElementById("createTime").value;
	
	if(title == ""){alert("数据输入不完整"); return false;}
	if(getLen(document.getElementById("title").value) > 100){alert("字符输入过长"); return false;}
	if(createTime == ""){alert("数据输入不完整"); return false;}
	
   // infocommNameCheck();
	//if(this.infocommNameflag=="false"){alert("信息标题不能重复"); return false;}
	document.all.content.value= window.content_html.getHTML();
	if(document.all.id.value=='')
	{
		document.all.method.value='add';
	}
	else
	{
		if ("<%=fromWhere%>"=="fromOther")
			document.all.method.value='add';
		else
			document.all.method.value='modify';
	}
		document.all.action.value='submit';
		document.forms[0].submit();
		return  true;
				
	}	
function returnList(){

      window.location.replace("<%=path%>/govinfopubContentaction.do?method=list&parentid=<%=parentid%>&p_name=<%=p_name%>");
      
	}
	
	function selectCla(oneormore,type)
		{
			window.showModalDialog("<%=path%>/infopubclaaction.do?method=list&oneormore="+oneormore+"&type="+type+"&source=doubleClaPub",window,'dialogwidth:450px;dialogheight:480px;help:0;center:yes;resizable:0;status:0;scroll:yes');
		}	
</script>


