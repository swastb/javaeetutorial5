<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ page import="com.baosight.layout.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%
//String fly_id=request.getParameter("fly_id");
//String user_id=request.getParameter("user_id");
//System.out.println(user_id);
%>
<html>
<head>
<link href="image/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/prototype-1.4.0.js"></script>
<title>个性化定制OA首页</title>
<script language=javascript>
 function insert()
 {
 	
 	var selectId = getSelected();
 	addPortlet(selectId);
	window.returnValue = 'success';
	window.close();
 }
 
 //获取选择的小窗口ID
 function getSelected(){
 	var arr = new Array();
 	var cbos = document.getElementsByName("checkbox2");
 	var n = 0;
 	for(var i=0; i<cbos.length;i++){
 		if(cbos[i].checked){
 			arr[n] = cbos[i].value;
 			n++;
 		}
 	}
 	
 	return arr.toString();
 }
 
function SelectAll()
{
     oEl = event.srcElement;                      //获取当前单击的元素
     for(i = 0;i < document.all.length; i++)
      {
          // 遍历所有的checkbox
          if(document.all(i).id.indexOf("cbo") != -1)
          {
                if(oEl.checked)                   //如果选择了全选
                document.all(i).checked = true;  //全选
                else
                document.all(i).checked = false; //全不选
           }
       }
}
function addPortlet(selectId)
{
   var url="layout.do?action=add&id="+selectId;
   var myAjax = new Ajax.Request(
				url,
				{
					//请求方式：POST
					method:'post',				
					//是否异步发送请求
					asynchronous:true
				});
}

</script>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
</head>
<body bgcolor="#80ffdf" style="overflow-x:hidden;overflow-y:hidden" topmargin="0">
<table align='center' id='table1'>
<tr>
<td colspan='3'><input name='checkbox' type='checkbox' id='Checkbox6' onClick='SelectAll()'/>
<span class='STYLE1'>全选</span>
</td>
</tr>
<tr>

<%
	String params = request.getParameter("params");
	String [] para = params.split(",");
	String strSql=(String)request.getSession().getAttribute("SYSTEM_USER_PERSONALINFO");
	String userDeptInfo=(String)request.getSession().getAttribute("SYSTEM_USER_PERSONALINFO_DEPT");
	System.out.println("SYSTEM_USER_PERSONALINFO_DEPT:"+userDeptInfo);
	String isFXZL = "false";
	String isSZYZL = "false";
	String isZWZL = "false";
	Map fxzlList = new HashMap();
	Map szyzlList = new HashMap();
	Map zwlList = new HashMap();
	int n=1;
	DbManager db= new DbManager();
	if(para!=null){
			try
			{
				ResultSet rs = db.getResultSet(strSql);
				if(rs!=null){
				if(userDeptInfo!=null){
					out.println("<tr><td>-----"+userDeptInfo+"用户-----</td></tr>");
				}
				while(rs.next())
				{
					String belong = rs.getString("BELONG");
					if(belong.equals("500")){
						isFXZL = "true";
						fxzlList.put(rs.getString("PORTLET_ID"),rs.getString("display_name"));
					}else if(belong.equals("600")){
						isSZYZL = "true";
						szyzlList.put(rs.getString("PORTLET_ID"),rs.getString("display_name"));
					}else if(belong.equals("700")){
						isZWZL = "true";
						zwlList.put(rs.getString("PORTLET_ID"),rs.getString("display_name"));
					}else{
						String checked = "";
						String id = rs.getString("PORTLET_ID");
						for(int i=0;i<para.length;i++){
							if(para[i].equals(id)){
								checked = "checked";
							break;
							}
						}
						out.println("<td width='20%'><input name='checkbox2' type='checkbox' "+ checked + " id='cbo"+n+"' value='"+id+"' />"+rs.getString("display_name")+" </td>");
						if(n%4==0)
						{
							out.println("</tr><tr>");
						}
						n++;					
					}
				}					
				}			
			}
			catch(SQLException el) 
			{
				out.println(el);
			}
	
				if(zwlList.keySet().size()!=0){
					out.println("<tr><td>-----政务专栏-----</td></tr>");
				}
				for(Iterator it = zwlList.keySet().iterator();it.hasNext();){
					String key = (String)it.next();
					String value = (String)zwlList.get(key);
					String checked = "";
					for(int i=0;i<para.length;i++){
						if(para[i].equals(key)){
							checked = "checked";
						break;
						}
					}
					out.println("<td width='20%'><input name='checkbox2' type='checkbox' "+ checked + " id='cbo"+n+"' value='"+key+"' />"+value+" </td>");
					if(n%4==0)
					{
						out.println("</tr><tr>");
					}
					n++;						
				}
				if(fxzlList.keySet().size()!=0){
					out.println("<tr><td>-----防汛专栏-----</td></tr>");
				}
				for(Iterator it = fxzlList.keySet().iterator();it.hasNext();){
					String key = (String)it.next();
					String value = (String)fxzlList.get(key);
					String checked = "";
					for(int i=0;i<para.length;i++){
						if(para[i].equals(key)){
							checked = "checked";
						break;
						}
					}
					out.println("<td width='20%'><input name='checkbox2' type='checkbox' "+ checked + " id='cbo"+n+"' value='"+key+"' />"+value+" </td>");
					if(n%4==0)
					{
						out.println("</tr><tr>");
					}
					n++;						
				}
				if(szyzlList.keySet().size()!=0){
					out.println("<tr><td>-----水资源专栏-----</td></tr>");
				}
				for(Iterator it = szyzlList.keySet().iterator();it.hasNext();){
					String key = (String)it.next();
					String value = (String)szyzlList.get(key);
					String checked = "";
					for(int i=0;i<para.length;i++){
						if(para[i].equals(key)){
							checked = "checked";
						break;
						}
					}
					out.println("<td width='20%'><input name='checkbox2' type='checkbox' "+ checked + " id='cbo"+n+"' value='"+key+"' />"+value+" </td>");
					if(n%4==0)
					{
						out.println("</tr><tr>");
					}
					n++;						
				}				
				out.println("<tr></tr>");	
	}
 %>
</tr>
<td colspan='3' align='center'>
<input name="button" type="button" id="Button1" onClick="insert()" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input name="button" type="button" id="Button1" onClick="window.close();" value="取消" />	</td>
</tr>
</table>
</body>
</html>