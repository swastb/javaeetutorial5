<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="com.baosight.mode.TbOaHoliday"/>
<jsp:directive.page import="com.baosight.tools.YearListForm"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="java.text.DecimalFormat"/>

<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List allOaHoliday = (List)request.getAttribute("allOaHoliday");

List yearList = (List)request.getAttribute("yearList");
List yearListE = (List)request.getAttribute("yearListE");
List monthList = (List)request.getAttribute("monthList");
String yearS=(String)request.getAttribute("year");
String yearE=(String)request.getAttribute("yearE");

String monthS=(String)request.getAttribute("month");


%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP  starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/CSS1.css" rel="stylesheet" type="text/css">
	<link href="images/style.css" rel="stylesheet" type="text/css" />
	<script src="<%=path %>/javascript/validate.js"></script>
  </head>
  
  <body>
<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
	 		<td>
	 			<table width="100%" border="0" cellspacing="0" cellpadding="0">
          			<tr>
            			<td width="288" height="40" align="left" valign="middle" background="images/8-1.gif">
            				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                				<tr>
                  					<td width="5%" align="center" valign="middle">&nbsp;</td>
                  					<td width="11%" height="12" align="center" valign="middle"><img src="images/icon5.gif" width="7" height="7" /></td>
                  					<td width="84%" class="table2_topic" align="right">节假日管理</td>
                				</tr>
            				</table>
            			</td>
            			<td background="images/8-2.gif">&nbsp;</td>
          		   </tr>
        		</table>
        		<table width="100%" border="0" cellpadding="0" cellspacing="1"
							bgcolor="#0e88b9">
							<tr>
								<td>
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
      				<tr>
        				<td align="center" valign="top">
        					<table width="98%" border="0" cellpadding="0" cellspacing="0" class="table2bgin">
			           			<tr>
			              			<th height="30" valign="bottom"></th>
			           			</tr>
			           			<tr>
			         				<td align="center" valign="bottom"><table width="99%" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
			         			<tr>
			        				
                       <td height="27" colspan="3" valign="middle"  bgcolor="#f7f7f7" align="left">
                      	<select name="year">
	          		<%
	          			for(int i=0;i<yearList.size();i++)
	          			{
	          				int year = ((YearListForm)yearList.get(i)).getYear();
	          				
							
							
	          				
	          				if (yearS == null){

	          				
		          				%>
		          				<option value="<%=year %>"><%=year %></option>
		          	
		          			<%
	          			}if(yearS !=null){
	          			int yearSS = Integer.parseInt(yearS);

	          			if(yearSS == year){
	          			%>
	          			<option value="<%=year %>" selected="selected"><%=year %></option>
	          			<%
	          			}else{
	          			%>
	          				<option value="<%=year %>"><%=year %></option>
	          				<%
	          				}
	          				}
	          			}
	          		 %>
	          	</select>
	          	<span class="tabin_toptext"><strong>年</strong></span>
	          	<select name="month">
	          		<%
	          			for(int i=0;i<monthList.size();i++)
	          			{
	          				int month = ((YearListForm)monthList.get(i)).getMonth();
	          				
							
							
	          				
	          				if (monthS == null){

	          				
		          				%>
		          				<option value="<%=month %>"><%=month %></option>
		          	
		          			<%
	          			}if(monthS !=null){
	          			int monthSS = Integer.parseInt(monthS);

	          			if(monthSS == month){
	          			%>
	          			<option value="<%=month %>" selected="selected"><%=month %></option>
	          			<%
	          			}else{
	          			%>
	          				<option value="<%=month %>"><%=month %></option>
	          				<%
	          				}
	          				}
	          			}
	          		 %>
	          	</select>
	          	<span class="tabin_toptext"><strong>月</strong></span>
	          	
	          	 <input name="Submit2" type="submit" class="button0" value="查 询" onclick="selectDate();"
	    		 		onmouseover="this.style.cursor='hand'"/>
	          	  </td>
                       
                        <td height="27" colspan="2" valign="middle"  bgcolor="#f7f7f7">
                      	<select name="yearE">
	          		<%
	          			for(int i=0;i<yearListE.size();i++)
	          			{
	          				int year = ((YearListForm)yearListE.get(i)).getYear();
	          				
							
							
	          				
	          				if (yearE == null){

	          				
		          				%>
		          				<option value="<%=year %>"><%=year %></option>
		          	
		          			<%
	          			}if(yearE !=null){
	          			int yearEE = Integer.parseInt(yearE);

	          			if(yearEE == year){
	          			%>
	          			<option value="<%=year %>" selected="selected"><%=year %></option>
	          			<%
	          			}else{
	          			%>
	          				<option value="<%=year %>"><%=year %></option>
	          				<%
	          				}
	          				}
	          			}
	          		 %>
	          	</select>
	          	<span class="tabin_toptext"><strong>年</strong></span>

					<input name="Submit2" type="submit" class="button0" value="双休日导入" onclick="selectsunsat();"
	    		 		onmouseover="this.style.cursor='hand'"/>
	    		    </td>
                 <td height="25" colspan="2" valign="bottom" bgcolor="#f7f7f7" align="right">&nbsp;
                 <input name="Submit2" type="submit" class="button0" value="增 加" onclick="add();"
	    		 		onmouseover="this.style.cursor='hand'"/>
	    		 		</td>
				     </tr>
  
			<tr align="center">
    		<th width="5%" height="25" align="center" style="word-break: break-all; word-wrap:break-word;">序号</th>
    		<th width="15%"  align="center" style="word-break: break-all; word-wrap:break-word;">节假日日期</th>
    		<th width="10%" align="center" style="word-break: break-all; word-wrap:break-word;">放假时间段</th>
    		<th width="10%" align="center" style="word-break: break-all; word-wrap:break-word;">放假天数</th>
    		<th width="50%" align="center" style="word-break: break-all; word-wrap:break-word;">说明</th>
    		<th width="10%" align="center"  colspan="2">操作</th>
    	</tr>
    	<%for (int i = 0; i < allOaHoliday.size(); i++) {
    		TbOaHoliday item = (TbOaHoliday)allOaHoliday.get(i);
    		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy");
    		SimpleDateFormat sf2 = new SimpleDateFormat("M");
    		
    		DecimalFormat df = new DecimalFormat("#0.0");
             String str = df.format(item.getDay()) + "";
             if (str.split("\\.")[1].equals("0")){
             str = str.split("\\.")[0];
             }
           

            
    		%>
    		<tr align="center" class="bg-zw">
    			<td width="5%"  height="25" align="center" style="word-break: break-all; word-wrap:break-word;"><%=i+1 %></td>
    			<td width="15%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=sf.format(item.getHoliday())%></td>
    			<td width="10%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getAmPm() %></td>
    			<td width="10%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=str %>天</td>
    			<td width="50%" align="center" style="word-break: break-all; word-wrap:break-word;"><%=item.getDescription() %></td>
    			<td width="5%" align="center"><a title="修改" href="<%=path %>/oaholidayaction.do?method=modify&id=<%=item.getId() %>&year=<%=sf1.format(item.getHoliday())%>&month=<%=sf2.format(item.getHoliday())%>"><img src="<%=path %>/imagine/xg.gif" width="15" height="15" border="0"></a></td>
    			<td width="5%" align="center"><a title="删除" href="<%=path %>/oaholidayaction.do?method=delete&id=<%=item.getId() %>&year=<%=sf1.format(item.getHoliday())%>&month=<%=sf2.format(item.getHoliday())%>" onclick="return confirm('是否确认删除')"><img src="<%=path %>/imagine/sc.gif" width="15" height="15" border="0"></a></td>
    		</tr>
    		<%
    	} %>

             			</table>
             	 	</td>
            	</tr>
            <tr>
              <td height="10"></td>
            </tr>
          </table>
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="8"></td>
            </tr>
          </table></td>
      </tr>
    </table>
    </td>
    </tr>
    </table>
    </td>
    </tr>
    </table>
</body>
</html>


<script type="text/javascript">

			function selectDate(){

			var year=document.getElementById("year").value;
            var month=document.getElementById("month").value;

            window.location.replace("<%=path%>/oaholidayaction.do?method=selectDate&year="+year+"&month="+month);
            
			}
			
			function add(){
            window.location.replace("<%=path %>/oaholidayaction.do?method=add&action=add");
            
			}
			
			function selectsunsat(){

			var yearE=document.getElementById("yearE").value;
		   if (confirm("将导入"+yearE+"双休日信息，是否导入")){
   　　　　　　　　　window.location.replace("<%=path%>/oaholidayaction.do?method=selectsunsat&yearE="+yearE);
		   }
  
			}
			
</script>
