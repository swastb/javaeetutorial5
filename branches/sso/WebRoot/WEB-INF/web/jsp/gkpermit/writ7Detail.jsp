<%@ page contentType="text/html;charset=GBK"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String busId = request.getParameter("busId");
	pageContext.setAttribute("busId", busId);
%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
		<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
		<script language="javascript" src="<%=basePath%>js/prototype.js"></script>
		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script language="javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

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
		<title>政府信息不予公开告知书</title>
	</head>

	<body>
		<div align="center">
			<input type="button" name="bSave" value="保存"
				onClick="javascript:doSubmit();">
			<input type="button" name="bEdit" value="修改">
			<input type="button" name="bPrint" value="打印">
		</div>
		<form action="<%=path%>/writ7Action.do" method="post" name="oF"
			id="oF">
			<center>
				<table width="600" border="0">
					<tr>
						<td>
							<div class="wtitle">
								政府信息不予公开告知书
							</div>
							<div align="right">
								（ ）第 号-不告
							</div>
							<br>
							（申请人姓名或者名称）
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;本机关于
							<input name="applydate" type="text" id="applydate" size="9"
								onfocus="new WdatePicker(this,null,false,'whyGreen')"
								value="<fmt:formatDate value="${govInfoPub.startTime}" pattern="yyyy-MM-dd"/>">
							收到了您（单位）获
							<br>
							件回执》 （ ）第 号-收
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;经查，您（单位）申请获取的政府信息：
							<p></p>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason1">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason1">
								&nbsp;属于国家秘密
							</label>
							<input name="method" type="hidden" id="method">
							<input type="hidden" name="id"
								value="<c:out value="${tbWrit7.id}"/>">
							<input type="hidden" name="busId"
								value="<c:out value="${tbWrit7.busId}" default="${busId}"/>">
							<input type="hidden" name="checkbox"
								value="<c:out value="${tbWrit7.checkbox}"/>">
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason2">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason2">
								&nbsp;属于商业秘密或者公开可能导致商业秘密被泄露的
							</label>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason3">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason3">
								&nbsp;属于个人隐私或者公开可能导致对个人隐私权造成不当侵害的
							</label>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason4">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason4">
								&nbsp;属于正在调查、讨论、处理过程中的
							</label>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason5">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason5">
								&nbsp;与行政执法有关，公开后可能会影响检查、调查、取证等执法活动或者会威胁个人生命安全的
							</label>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label for="reason6">
								<input type="checkbox" name="reason" value="checkbox"
									id="reason6">
								&nbsp;有法律、法规规定免予公开的其他情形，具体为
							</label>
							<br>
							<textarea name="text1" cols="70" rows="2" wrap="VIRTUAL">
								<c:out value="${tbWrit7.text1}" />
							</textarea>
							<br>
							&nbsp;&nbsp;&nbsp;&nbsp;根据《上海市政府信息公开规定》第十条第一款第
							<input name="text2" type="text" size="4"
								value="<c:out value="${tbWrit7.text2}"/>">
							项和
							<br>
							第十二条第（二）项，对于您（单位）申请获取的政府信息，本
							<br>
							机关不予公开。
							<p>
								&nbsp;&nbsp;&nbsp;&nbsp;如对本决定不服，可以在收到本决定之日起60日内申请行
								<br>
								政复议或者在3个月内向人民法院提起行政诉讼。
							</p>
							&nbsp;&nbsp;&nbsp;&nbsp;特此告知。
							<div align="right">
								（机关印章）
							</div>
							<div align="right">
								<input
									value="<fmt:formatDate value="${tbWrit7.createdate}" pattern="yyyy-MM-dd"/>"
									name="createdate" type="text" id="createdate" size="9"
									onfocus="new WdatePicker(this,null,false,'whyGreen')">
							</div>
						</td>
					</tr>
				</table>
			</center>
		</form>
		<script type="text/javascript">
  var writId = $('id').value;
  var oF1=document.forms[0];
  function doSubmit(){
     if(IsEmpty(writId))
     $('method').value = "CreateWrit7";
     else
     $('method').value = "UpdateWrit7";
     
     oF1.submit();
     
  }
   function IsEmpty(s){
        return (s=='')?true:false;
      }
  </script>
	</body>
</html>
