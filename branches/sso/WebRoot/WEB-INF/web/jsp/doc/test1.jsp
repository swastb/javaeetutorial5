<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
				document.all.WebOffice1.LoadOriginalFile("${contextPath}", "doc");
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
			document.all.WebOffice1.SetFieldValue("mark_1", "书签？", "::ADDMARK::");			
		}

		// -------------------------=== 设置书签套加红头 ===------------------------------ //
		function addRedHead() {
			document.all.WebOffice1.SetFieldValue("mark_1", "", "::ADDMARK::");			// 添加书签
			document.all.WebOffice1.SetFieldValue("mark_1", "tmp1.doc", "::FILE::");
		}

		// -----------------------------== 返回首页 ==------------------------------------ //
		function return_onclick() {
			document.all.WebOffice1.Close();
			window.close();
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
		function saveDoc() {
			var myform = document.forms[0];		 
			 if(myform.docName.value ==""){
				alert("名称不可为空")
				myform.DocTitle.focus();
				return false;
			}
			document.all.WebOffice1.HttpInit();		//初始化Http引擎
			// 添加相应的Post元素 
			document.all.WebOffice1.HttpAddPostString("DocSendId", myform.docId.value);
			document.all.WebOffice1.HttpAddPostString("DocAttId",myform.fileId.value);
			document.all.WebOffice1.HttpAddPostString("DocTitle", myform.docName.value);
			document.all.WebOffice1.HttpAddPostString("DocType","doc");
			document.all.WebOffice1.HttpAddPostCurrFile("DocContent","");
			// 上传文件
			var result = document.all.WebOffice1.HttpPost("<%=basePath%>docSendBook.do?method=uploadWebOfficeFile");
			
			if("failed" == result){
				alert("文件上传失败!");	
			}else{
				if(myform.fileId.value==""){
					myform.fileId.value=result;
					var tb = opener.document.getElementById("docContextTb");
					var row = tb.insertRow();
					var cell = row.insertCell();
					cell.className="bg-zw";
					cell.innerHTML="<a href=\"#\" onclick=\"moddoc('"+myform.fileId.value+"');return false;\">"+myform.docName.value+"</a>";
				}else{
					opener.document.getElementById(myform.fileId.value).innerHTML="<a href=\"#\" onclick=\"moddoc('"+myform.fileId.value+"');return false;\">"+myform.docName.value+"</a>";
				}
				alert("文件上传成功!")
			}
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

<body leftmargin="0">
		<html:form action="/docEditTest.do?method=upload" enctype="multipart/form-data" 
			method="post">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="102" align="left" valign="middle" background="imagine/doc/b1.gif">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="20%" align="center" valign="middle"><table width="96%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td class="zw"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- <td align="right" class="zw">文号</td>
                      <td width="90"><input name="DocID" type="text" class="srk"></td> -->
                      <td align="right" class="zw">文件名称：</td>
                      <td width="90"><input name="docName" type="text" class="srk" value="${fileName}"></td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr> 
                <td height="5"> </td>
              </tr>
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td width="90"></td>
                      <td>&nbsp;</td>
                      <td width="49" align="center" background="bt1.gif" class="zw">
						<input name="DocFilePath" type="file" size="14" onpaste="return false" >
					  </td>
                      <td>&nbsp;</td>
                      <td width="86" align="center" background="bt2.gif" class="zw">
						<input type="button" value="打开本地文件" onClick="return docOpen()">
					  </td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          <td width="1%">&nbsp;</td>
          <td width="50%"><table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td align="center"><table border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td class="zw">用户名:</td>
                      <td><input name="UserName" type="text" class="srk">&nbsp;</td>
                      <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                      <a onclick="return SetUserName()" onmouseover="this.style.cursor='hand'">设置用户</a>
					  </td>
                      <td class="zw">&nbsp;&nbsp;保护密码:</td>
                      <td><input name="docPwd" type="text" class="srk">&nbsp;</td>
                      <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                      <a onclick="return ProtectFull()" onmouseover="this.style.cursor='hand'">保护文档</a>
					  </td>
                      <td width="5"> </td>
                      <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                      <a onclick="return UnProtect()" onmouseover="this.style.cursor='hand'">解除保护</a>
					  </td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
              </tr>
              <tr> 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr> 
                      <td align="center">
<table width="88%" height="22" border="0" cellpadding="0" cellspacing="0">
                          <tr> 
                            <td width="70%" align="center">
<table height="22" border="0" cellpadding="0" cellspacing="0">
                                <tr> 
                                  <td width="1" background="imagine/doc/fgx.gif"> </td>
                                  <td width="10"> </td>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return ProtectRevision()" onmouseover="this.style.cursor='hand'">修订文档</a>
								  </td>
                                  <td width="8">&nbsp;</td>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return ShowRevisions()" onmouseover="this.style.cursor='hand'">显示修订</a>
								  </td>
                                  <td width="8">&nbsp;</td>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return UnShowRevisions()" onmouseover="this.style.cursor='hand'">隐藏修订</a>
								  </td>
                                  <td width="8">&nbsp;</td>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return AcceptAllRevisions()" onmouseover="this.style.cursor='hand'">接受修订</a>
								  </td>
                                  <td width="10"> </td>
                                  <td width="1" background="imagine/doc/fgx.gif"> </td>
                                </tr>
                              </table></td>
                            <td align="center">
<table height="22" border="0" align="right" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return addBookmark()" onmouseover="this.style.cursor='hand'">设置书签</a>
								  </td>
                                  <td>&nbsp;</td>
                                  <td width="67" align="center" background="imagine/doc/bt3.gif" class="zw">
                                  <a onclick="return addRedHead()" onmouseover="this.style.cursor='hand'">套加红头</a>
								  </td>
                                </tr>
                              </table></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
          <td>&nbsp;</td>
          <td valign="bottom"> 
            <table border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="89" height="24" align="center" background="imagine/doc/bt4.gif" class="zw">
                <a onclick="return saveDoc()" onmouseover="this.style.cursor='hand'">上传到服务器</a>
				</td>
              </tr>
              <tr> 
                <td height="24" align="center" background="imagine/doc/bt4.gif" class="zw">
                <a onclick="return return_onclick()" onmouseover="this.style.cursor='hand'">退  出</a>>
				</td>
              </tr>
            </table></td>
        </tr>
      </table> </td>
  </tr>
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
<input type="hidden" name="docId" value="${param.docId}">
<input type="hidden" name="fileId" value="${param.fileId}">
		</html:form>
</body>
</html>
