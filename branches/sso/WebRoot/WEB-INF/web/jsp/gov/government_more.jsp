<%@ page language="java" import="java.util.*,java.sql.SQLException,java.io.IOException"
	import="org.hibernate.lob.SerializableClob" import="java.sql.Clob"
	import="oracle.sql.CLOB" import="java.io.BufferedReader"
	import="java.io.Reader" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbGovInfoPubContent;"/>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%!public String ClobToString(CLOB clob) {
		String reString = "";
		try {
			if (clob != null && !clob.isEmptyLob()) {
				Reader is = clob.getCharacterStream();//得到流
				BufferedReader br = new BufferedReader(is);
				String s = br.readLine();
				StringBuffer sb = new StringBuffer();
				while (s != null) {//执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING 
					sb.append(s);
					s = br.readLine();
				}
				reString = sb.toString();
				br.close();
				is.close();
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String sessionID = "";
int curPage = 0;
long count=0;
try{
  sessionID = (String)request.getAttribute("sessionID");
  curPage = (Integer)session.getAttribute(sessionID+"No");
  count=(Long)session.getAttribute(sessionID+"Count");
  
}catch(Exception ex){
  ex.printStackTrace();
}
String name="";

	name = (String)request.getAttribute("name");
if(name == null || name.equals("")){
	name=(String)request.getParameter("name");
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<%
  	List infoConList = (List)request.getAttribute("curPageList");
  %>
    <base href="<%=basePath%>">

    <title>政府信息公开</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="<%=path %>/css/index-css.css" rel="stylesheet" type="text/css">
	</head>
<jsp:include flush="true" page="../infopublic/top.jsp"></jsp:include>
	<body topmargin="0" leftmargin="0">
	<table width="1000"  align="center" border="0"
			cellpadding="0" cellspacing="0"  class="tableborder">
			<tr>
    <td height="10" align="center" bgcolor="#e3eaf1"></td>
  </tr>
  <tr>
    <td height="130" align="center" bgcolor="#e3eaf1"><table width="90%" height="581" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" class="tabp_yy">
      <tr>
        <td valign="top" bgcolor="#f1f8fc"><table width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr>
              <td height="50" align="center" valign="bottom" background="imagine/tab_bg1.gif"><table width="94%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="1%" align="left" valign="top" background="imagine/tab_bg_a.gif"><img src="imagine/tab_bg_b.gif" width="5" height="34" /></td>
                    <td width="8%" align="center" background="imagine/tab_bg_a.gif"><img src="imagine/icon19.gif" width="29" height="30" /></td>
                    <td width="90%" background="imagine/tab_bg_a.gif" class="tabp_tit"><%=name %></td>
                    <td width="1%" align="right" valign="top" background="imagine/tab_bg_a.gif"><img src="imagine/tab_bg_c.gif" width="5" height="34" /></td>
                  </tr>
              </table></td>
            </tr>
          </table>
          <table width="82%" border="0" align="center" cellpadding="0" cellspacing="0">
			<br>
                                                 
            <%
			
					if (infoConList != null && !infoConList.isEmpty()) {
					for (int i = 0; i < infoConList.size(); i++) {
						TbGovInfoPubContent item = (TbGovInfoPubContent) infoConList
						.get(i);
						if(item.getContent()==null || "".equals(item.getContent())){
						String content = "";
						}else{
						SerializableClob sc = (SerializableClob) item.getContent();
						Clob wrapclob = sc.getWrappedClob();
						CLOB clob = (CLOB) wrapclob;
						String content = ClobToString(clob);
						}
						
						
			%>
                                                  <tr>
                                                  
                                                    <td height="22" width="91%" class="zw" onmouseover="bgColor='#76c5eb'" onmousedown="bgColor='#76c5eb'"  onmouseout="bgColor='#f1f8fc'">
                                                    ■
					                               &nbsp;
                                                    <a href="<%=path%>/govern.do?method=view&id=<%=item.getFileId()%>" target="_blank"><%=item.getTitle() == null ? "" : (item.getTitle().length() > 15 ? item.getTitle().substring(0, 15)+"...": item.getTitle())%>..</a></td>
                                                    <td  width="72" height="18" align="center" class="zw-time">[<%=item==null ? "":item.getCreateTime().toString().substring(5,10)%>]</td>
                                                    
                                                  </tr>
                                                  <tr ><td  align="center" height="1" colspan="3" background="<%=path%>/imagine/ddddd3.gif"></tr>
                                                  
     <% }
                                            }%>
                                         </table>
		<table width="818">
		
					<tr align="right">
						<td>
							<a
								href="<%=path%>/govern.do?method=movePageMore&moveTo=<%=curPage - 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">上一页</span>
							</a>
							<a
								href="<%=path%>/govern.do?method=movePageMore&moveTo=<%=curPage + 1%>&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">下一页</span>
							</a>
							<span class="zw">第<%=curPage + 1%>页</span>
							<span class="zw">每页显示</span>
							<a
								href="<%=path%>/govern.do?method=resetPageSizeMore&pageSize=10&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">10</span>
							</a>
							<a
								href="<%=path%>/govern.do?method=resetPageSizeMore&pageSize=20&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">20</span>
							</a>
							<a
								href="<%=path%>/govern.do?method=resetPageSizeMore&pageSize=30&sessionID=<%=sessionID%>&name=<%=name%>"><span
								class="zw">30</span>
							</a>
							<span class="zw">条</span>
							<span class="zw">共<%=count %>条</span>
						</td>
					</tr>
			</table>
  
                     
		
	</body>
</html>

