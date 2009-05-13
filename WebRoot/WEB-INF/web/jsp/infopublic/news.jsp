<%@ page language="java"
	import="java.util.*,java.sql.SQLException,java.io.IOException,java.io.*"
	import="org.hibernate.lob.SerializableClob" 
	import="java.sql.Clob"
	import="java.io.BufferedReader"
	import="java.io.Reader" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbInfoPubContent" />
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%!public String ClobToString(Clob clob) {
		String reString = "";
		try {
		if(clob!=null){
			Reader reader = clob.getCharacterStream();
			char[] buffer = new char[(int) clob.length()];
			reader.read(buffer);
			reader.close();
			return new String(buffer).replaceAll("\\\\\"", "\"");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reString;
	}%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List resultList1 = (List) request.getAttribute("resultList1");
	List resultList2 = (List) request.getAttribute("resultList2");
	List resultList3 = (List) request.getAttribute("resultList3");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>contentresult</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/index-css.css" rel="stylesheet"
			type="text/css">
	</head>

	<body leftmargin="0" topmargin="5" bgcolor="eefaff">

	<table width="305" align="center" border="0" cellpadding="0" cellspacing="0">
		<%--<tr>
			<td height="15" colspan="3" class="xb">
			<a href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=新闻中心&code=xwzx" 
			target="_blank">&nbsp;新闻中心</a>
			</td>
		</tr>
		--%><tr>
			<td colspan="3" align="center">
			 <div id=oTransContainer 
            style="FILTER: progid:DXImageTransform.Microsoft.Wipe(GradientSize=1.0,wipeStyle=0, motion='forward'); WIDTH: 165px; HEIGHT: 103px">
            <table width="305" border="0" align="center" cellpadding="0" cellspacing="0">
		<%
		 	if (resultList1 != null && !resultList1.isEmpty()) {
		 		int size = resultList1.size();
		 		if (size>3)
		 			size = 3;
				for (int i = 0; i < size; i++) {
					TbInfoPubContent item1 = (TbInfoPubContent) resultList1.get(i);
					java.sql.Clob clob = null;
					String content = "";
					if(item1.getContent()!=null){
						clob=item1.getContent();
						content = ClobToString(clob);
					}
					String imageUrl = path+"/imagine/sy-tp3.gif";
					String contentStr = content.replace("<BR>","").replace("<P>","").replace("</P>","").replace("<DIV>","").replace("</DIV>","");
					if (contentStr.indexOf("<IMG")!=1 && contentStr.indexOf("/sso/UploadFile")!=-1) {
						List list = new ArrayList();
						int imgHZM = 0;
						list.add(contentStr.indexOf(".JPG"));
						list.add(contentStr.indexOf(".GIF"));
						list.add(contentStr.indexOf(".BMP"));
						list.add(contentStr.indexOf(".jpg"));
						list.add(contentStr.indexOf(".gif"));
						list.add(contentStr.indexOf(".bmp"));
						for (int k=0;k<list.size();k++) {
							if (((Integer)list.get(k)).intValue() > 1)
							imgHZM = ((Integer)list.get(k)).intValue();
						}
						if (imgHZM > 0)
							imageUrl = contentStr.substring(contentStr.indexOf("/sso/UploadFile"),imgHZM+3);
					}
					else 
					{
						imageUrl=path+"/imagine/szy_"+(i+1)+".jpg";
					}
			if (i==0){%>
		  <tr><td align="center">
            <a 
            href="<%=path%>/infopubContentaction.do?method=view&id=<%=item1.getId()%>" 
            target=_blank><img id="oDIV<%=i+1 %>" 
            style="BORDER-RIGHT: white 1px solid; BORDER-TOP: white 1px solid; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid" 
            height=140 src="<%=imageUrl %>" 
            width=280 border=0></a>
            </td></tr>
            <tr>
            <td class="zw" align="center">
            <a id="title<%=i+1 %>" style="display:block;"
            href="<%=path%>/infopubContentaction.do?method=view&id=<%=item1.getId()%>" 
            target=_blank><%=item1.getTitle() %></a>
            </td></tr>
            <%
            }else{%>
            <tr><td align="center">
             <a 
            href="<%=path%>/infopubContentaction.do?method=view&id=<%=item1.getId()%>" 
            target=_blank><img id="oDIV<%=i+1 %>" 
            style="BORDER-RIGHT: white 1px solid; BORDER-TOP: white 1px solid; DISPLAY: none; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid" 
            height=140 src="<%=imageUrl %>" 
            width=280 border=0></a>
            </td></tr>
            <tr>
            <td class="zw" align="center">
            <a id="title<%=i+1 %>" style="display:none;"
            href="<%=path%>/infopubContentaction.do?method=view&id=<%=item1.getId()%>" 
            target=_blank><%=item1.getTitle() %></a>
             </td></tr>
            <%}
            }%>
            <tr>
			<td width="100%" valign="top" align="right">
				<a href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=新闻中心&code=xwzx"
					target="_blank"><img src="<%=path%>/imagine/more.gif"
					width="41" height="11" border="0"></a>&nbsp;
			</td>
		</tr>
            <%}%>
           </table>
		</div>
			</td>
		</tr>
	</table>

	<table width="305" align="center" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="20" colspan="3" class="xb">
					<a
						href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=水务动态&code=swdt"
						target="_blank">水务动态</a>
				</td>
			</tr>
			<%
					if (resultList3 != null && !resultList3.isEmpty()) {
					for (int i = 0; i < resultList3.size(); i++) {
						TbInfoPubContent item3 = (TbInfoPubContent) resultList3
						.get(i);
						String title = "";
						title = item3.getTitle();
						if (title.trim().length() > 10) {
					title = title.substring(0, 12) + "...";
						}
			%>
			<tr>
				<td width="10" height="18">
					<img src="<%=path%>/imagine/ddddd2.gif" width="4" height="4">
				</td>
				<td height="22" class="zw">
					<a
						href="<%=path%>/infopubContentaction.do?method=view&id=<%=item3.getId()%>"
						target="_blank"><%=title%> </a>
				</td>
				<td width="72" height="18" align="right" class="zw-time">[<%=item3.getRecordTime() == null ? "" : item3.getRecordTime().toString().substring(5, 10)%>]
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" background="<%=path%>/imagine/ddddd3.gif">
				</td>
			</tr>
			<%
				}
				}
			%>

			 <table  width="320" height="5" valign="top" align="center" border="0" cellpadding="0" cellspacing="0"> 
                                          <td width="225" ></td>
                                              <td height="20" vaign="top" align="center">&nbsp;&nbsp;<a href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=水务动态&code=swdt" target="_blank"><img src="<%=path%>/imagine/more.gif" width="41" height="11" border="0"></a></td>
                                            </table>
		</table>
		<!--<td height="20" valign="top" align="right">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a
				href="<%=path%>/infopubContentaction.do?method=wzdt_more&name=水务动态&code=swdt"
				target="_blank"><img src="<%=path%>/imagine/more.gif" width="41"
					height="11" border="0"> </a>
		</td>-->

	</body>
</html>
<script>
var NowFrame = 1;
var MaxFrame = 3;
var bStart = 0;
function fnToggle()
{var next = NowFrame + 1;
if(next == MaxFrame+1) 
{NowFrame = MaxFrame;next = 1;}
if(bStart == 0)
{bStart = 1;setTimeout('fnToggle()', 2000);return;}
else
{oTransContainer.filters[0].Apply();
document.images['oDIV'+next].style.display = "";
document.getElementById('title'+next).style.display = "";
document.images['oDIV'+NowFrame].style.display = "none";
document.getElementById('title'+NowFrame).style.display = "none";
oTransContainer.filters[0].Play(duration=2);
if(NowFrame == MaxFrame){NowFrame = 1;}else{NowFrame++;}}
	setTimeout('fnToggle()', 6000);}fnToggle();
</script>