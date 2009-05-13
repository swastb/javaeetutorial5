<%@ page language="java"  pageEncoding="GBK"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String needPrintURL =(String) request.getAttribute("needPrintURL");
	String isOrNotPrint =(String) request.getAttribute("isOrNotPrint");
	String printPath=needPrintURL+"&isOrNotPrint="+isOrNotPrint;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<head>
		<base href="<%=basePath%>">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<SCRIPT LANGUAGE=javascript>
		<!--
		// ---------------------=== 控件初始化WebOffice方法 ===---------------------- //
		function WebOffice1_NotifyCtrlReady() {
			document.all.WebOffice1.LoadOriginalFile("<%=printPath%>", "doc");
		}
		
		
		// ---------------------== 关闭页面时调用此函数，关闭文件 ==---------------------- //
		function window_onunload() {
			document.all.WebOffice1.Close();
		}
		 
		// ---------------------------== 解除文档保护 ==---------------------------------- //
		function UnProtect() {
			document.all.WebOffice1.ProtectDoc(0,1, myform.docPwd.value);
		}
		
		// ---------------------------== 设置文档保护 ==---------------------------------- //
		function ProtectFull() {
			document.all.WebOffice1.ProtectDoc(1,1, myform.docPwd.value);
		}
		// -----------------------------== 修订文档 ==------------------------------------ //
		function ProtectRevision() {
			document.all.WebOffice1.SetTrackRevisions(1) 
		}
		
		// -----------------------------== 隐藏修订 ==------------------------------------ //
		function UnShowRevisions() {
			document.all.WebOffice1.ShowRevisions(0);
		}
		
		// --------------------------== 显示当前修订 ==---------------------------------- //
		function ShowRevisions() {
			document.all.WebOffice1.ShowRevisions(1);
		
		}
		
		// -------------------------== 接受当前所有修订 ==------------------------------- //
		function AcceptAllRevisions() {
		 	document.all.WebOffice1.SetTrackRevisions(4);
		}
		
		// ---------------------------== 设置当前操作用户 ==------------------------------- //
		function SetUserName() {
			if(myform.UserName.value ==""){
				alert("用户名不可为空")
				myform.UserName.focus();
				return false;
			}
		 	document.all.WebOffice1.SetCurrUserName(myform.UserName.value);
		}
		
		// -------------------------=== 设置书签套加红头 ===------------------------------ //
		function addBookmark() {
			document.all.WebOffice1.SetFieldValue("mark_1", "北京点聚信息技术有限公司", "::ADDMARK::");			
		}
		
		// -------------------------=== 设置书签套加红头 ===------------------------------ //
		function addRedHead() {
			document.all.WebOffice1.SetFieldValue("mark_1", "", "::ADDMARK::");			// 添加书签
			document.all.WebOffice1.SetFieldValue("mark_1", "tmp1.doc", "::FILE::");
		}
		
		// -----------------------------== 返回首页 ==------------------------------------ //
		function return_onclick() {
			//alert("操作成功!");
			history.back();
		}
		// 打开本地文件
		function docOpen() {
		var myform = document.forms[0];
			if(myform.DocFilePath.value == "") {
				alert("文件路径不可以为空");
				myform.DocFilePath.focus();
				return false;
			}
			if( 0 == document.all.WebOffice1.LoadOriginalFile(myform.DocFilePath.value,"doc")){
				alert("文件打开失败，请检查路径是否合法");
				myform.DocFilePath.focus();
				return false;
			}
				
		}
		// -----------------------------== 保存文档 ==------------------------------------ //
		function SaveDoc() {
			 var myform = document.forms[0];		 
			 if(myform.DocTitle.value ==""){
				alert("标题不可为空")
				myform.DocTitle.focus();
				return false;
			}
			if(myform.DocID.value ==""){
				alert("文号不可为空")
				myform.DocID.focus();
				return false;
			}
			
			document.all.WebOffice1.HttpInit();			//初始化Http引擎
			// 添加相应的Post元素 
			document.all.WebOffice1.HttpAddPostString("DocTitle", myform.DocTitle.value);
			document.all.WebOffice1.HttpAddPostString("DocID", myform.DocID.value);
			document.all.WebOffice1.HttpAddPostString("DocType","doc");
			document.all.WebOffice1.HttpAddPostString("DocFilePath",myform.DocFilePath.value);
			document.all.WebOffice1.HttpAddPostCurrFile("DocContent","");		// 上传文件
			
			document.all.WebOffice1.HttpPost("<%=path%>/docEditTest.do?method=upload");
			
			if("OK" == document.all.WebOffice1.HttpPost("<%=path%>/docEditTest.do?method=upload")){
				//alert("文件上传成功");	
			}else{
				//alert("文件上传失败")
			}
			return_onclick(); 
			}
		//-->
		</SCRIPT>
		<!-- --------------------=== 调用Weboffice初始化方法 ===--------------------- -->
		<SCRIPT LANGUAGE=javascript FOR=WebOffice1 EVENT=NotifyCtrlReady>
		<!--
		 WebOffice1_NotifyCtrlReady()			// 在装载完Weboffice(执行<object>...</object>)控件后执行 "WebOffice1_NotifyCtrlReady"方法
		//-->
		</SCRIPT>
	<link href="<%=path%>/css/wd-css.css" rel="stylesheet" type="text/css">
	</head>

<body leftmargin="0" marginwidth="1024">
		<html:form action="/docEditTest.do?method=upload" enctype="multipart/form-data" 
			method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
					<td colspan="3" valign="top">
						<!-- -----------------------------== 装载weboffice控件 ==--------------------------------- -->
						<object id=WebOffice1 height=560 width="100%"
							style="LEFT: 0px; TOP: 0px"
							classid="clsid:E77E049B-23FC-4DB8-B756-60529A35FAD5"
							codebase=WebOffice.ocx#V3,0,0,0>
							<param name="_ExtentX" value="6350">
							<param name="_ExtentY" value="6350">
							<param name="BorderColor" value="-2147483632">
							<param name="BackColor" value="-2147483643">
							<param name="ForeColor" value="-2147483640">
							<param name="TitlebarColor" value="-2147483635">
							<param name="TitlebarTextColor" value="-2147483634">
							<param name="BorderStyle" value="1">
							<param name="Titlebar" value="1">
							<param name="Toolbars" value="1">
							<param name="Menubar" value="1">
						</object>
						<!-- --------------------------------== 结束装载控件 ==----------------------------------- -->
					</td>

  </tr>
</table>
		</html:form>
</body>
</html>
