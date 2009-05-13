<%@ page contentType="text/html;charset=GBK"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String busId = request.getParameter("busId");
	pageContext.setAttribute("busId",busId);
%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
	<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
	<script language="javascript" src="<%=basePath%>js/prototype.js"></script>
	<script type="text/javascript" src="<%=path %>/javascript/calendar.js"></script>
	<script language="javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	
	<style type="text/css">
			  table{
			FONT: 仿宋_GB2312 小三;
	        line-height: 2.5;
			border-collapse: collapse;
		}
	.wtitle {
	FONT-WEIGHT: bold;
	FONT: 小二 方正小标宋简体;
	text-align: center;
    }
	</style>
  <title>非本机关掌握政府信息告知书</title>
  </head>
  
  <body><div align="center">
      <input type="button" name="bSave" value="保存" onClick="javascript:doSubmit();">
      <input type="button" name="bEdit" value="修改">
      <input type="button" name="bPrint" value="打印"></div><form action="<%=path%>/writ8Action.do" method="post" name="oF" id="oF">
     <center><table width="600" border="0">
    <tr>
      <td>
	  <div class="wtitle">非本机关掌握政府信息告知书</div>
<div align="right">
        <input type="text" name="wsh" value="<c:out value="${tbWrit8.wsh}"/>">
      </div>
<br><input type="text" name="textfield4" value="<c:out value="${tbWrit8.wsh}"/>"><br>
      &nbsp;&nbsp;&nbsp;&nbsp;您（单位）于 
      <input name="applydate" type="text" id="applydate" size="9" onfocus="new WdatePicker(this,null,false,'whyGreen')" value="<fmt:formatDate value="${govInfoPub.startTime}" pattern="yyyy-MM-dd"/>">
      收到了您（单位）获<br>得<input type="text" name="sqmc" value="<c:out value="${tbWrit8.sqmc}"/>">
	  的申请，见《收<br>
      件证明》
      <input type="text" name="sjzm" value="<c:out value="${tbWrit8.sjzm}"/>">
       <p>&nbsp;&nbsp;&nbsp;&nbsp;经查，您（单位）申请获取的政府信息不属于本机关的掌握<br>
        范围。本机关根据《上海市政府信息公开规定》第十二条第（三）<br>
        项的规定，予以告知。建议您向 
        <input type="text" name="zx" value="<c:out value="${tbWrit8.zx}"/>">
        咨<br>
        询，联系方式为
        <input type="text" name="lxfs" value="<c:out value="${tbWrit8.lxfs}"/>">
      </p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;特此告知。 
      <div align="right">（机关印章）</div>
	  <div align="right"><input value="<fmt:formatDate value="${tbWrit8.createdate}" pattern="yyyy-MM-dd"/>" name="createdate" type="text" id="createdate" size="9" onfocus="new WdatePicker(this,null,false,'whyGreen')"></div>
	  </td>
    </tr>
  </table></center>
  <input name="method" type="hidden" id="method">
      <input type="hidden" name="id" value="<c:out value="${tbWrit8.id}"/>">
      <input type="hidden" name="busId" value="<c:out value="${tbWrit8.busId}" default="${busId}"/>">
  </form>
  <script type="text/javascript">
  var writId = $('id').value;
  var oF1=document.forms[0];
  function doSubmit(){
     if(IsEmpty(writId))
     $('method').value = "CreateWrit8";
     else
     $('method').value = "UpdateWrit8";
     
     oF1.submit();
     
  }
   function IsEmpty(s){
        return (s=='')?true:false;
      }
  </script>
  </body>
</html>
