<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<jsp:directive.page import="java.text.SimpleDateFormat" />
<jsp:directive.page import="com.baosight.mode.TbUser"/>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	List userlist=(List)request.getAttribute("userlist");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>选择人员</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path%>/css/CSS1.css" rel="stylesheet" type="text/css">

		<link rel="stylesheet" type="text/css" media="all"
			href="<%=path%>/css/calendar-win2k-cold-1.css" title="win2k-cold-1" />

		<script type="text/javascript" src="<%=path%>/javascript/calendar.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-zh.js"></script>
		<script type="text/javascript"
			src="<%=path%>/javascript/calendar-setup.js"></script>

		<script type="text/javascript">
		function checkform()
		{
			flag=false;
			var ids="";
			var es = document.getElementsByName("userchecked");
			for (var i = 0; i < es.length ; i++){
				if(es[i].checked == true)
				{
					flag=true;
				} 
			}
			if(flag==false)
			{
				alert("您没有选择任何人员!请选择人员。");
			}else
			{
				
				for (var j = 0; j < es.length ; j++){
					if(es[j].checked == true)
					{
						if(ids.length!=0)
						{
							ids=ids+","+es[j].id;
						}
						if(ids.length==0)
						{
							ids=ids+es[j].id;
						}
					} 
				}
				
				window.dialogArguments.document.getElementById("userids").value="";
				window.dialogArguments.document.getElementById("userids").value=ids;
				//alert(window.dialogArguments.document.getElementById("userids").value);
				window.close();
			}
		}
		
		
		function allcheck()
		{
			var len=document.forms[0].length;
			
			for (var i = 0; i < len; i++)
		    {
		        if (form.allchecked.checked == true)
		        {
		            if (form.elements[i].type == "checkbox"&&form.elements[i].name!="allchecked")
		            {
		                form.elements[i].checked = true;
		            }
		        }
		        else
		        {
		            if (form.elements[i].type == "checkbox"&&form.elements[i].name!="allchecked")
		            {
		                form.elements[i].checked = false;
		            }
		        }
		    }
		}
	    
	    
	</script>

	</head>

	<body>
		<form action="" name="form">
		<table width="60%" border="2" cellpadding="0" cellspacing="0"
			bordercolor="97cdda" class="tableborder">
			<thead class="bg-zwbt">
				<tr>
					<td width="50%">
						<span style="font-size: 10.5pt; font-family: 宋体;">选择人员</span>
						<br>
						<input type="checkbox" name="allchecked" onclick="allcheck();" onchange="allchecked();">全选/全否&nbsp;&nbsp;
						<a	onclick="checkform();"
							onmouseover="this.style.cursor='hand'">提交</a>&nbsp;&nbsp;
					</td>
				</tr>
			</thead>
		</table>
		<table width="60%" border="2" cellpadding="0" cellspacing="0"
			bordercolor="97cdda" class="tableborder">
			<thead class="bg-zwbt">
			<%
				if(userlist!=null)
				{
					if(userlist.size()>0)
					{
						Iterator it=userlist.iterator();
						while(it.hasNext())
						{
							TbUser user=(TbUser)it.next();
							%>
								<tr>
									<td width="50%">
										<input type="checkbox" name="userchecked" id="<%=user.getId() %>"><span style="font-size: 10.5pt; font-family: 宋体;"><%=user.getName() %></span>
									</td>
								</tr>
							<%
						}
					}
				}
			 %>
			 </thead>
		</table>
		</form>
	</body>
</html>
