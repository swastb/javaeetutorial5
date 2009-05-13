<%@ page contentType="text/html; charset=gb2312" language="java"errorPage="" %>
<%@ page import="com.baosight.mode.TbDocsendListitems"%>
<%@ page import="com.baosight.mode.TbDocsendSubject"%>
<%@ page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List areatypelist = (List)request.getAttribute("areatypelist");
List leibieciList = (List)request.getAttribute("leibieciList");
List leishuciList = (List)request.getAttribute("leishuciList");
//List gongwenTypeList = (List)request.getAttribute("gongwenTypeList");

%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>主题词</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link href="images/style.css" rel="stylesheet" type="text/css">
<script language="javascript">

function tijiao(){
	if (document.f1.choose1.value =="") {
		alert("请选择类别词！");
		return false;
	}
	if (document.f1.choose.value =="") {
		alert("请选择类属词！");
		return false;
	}
	if (document.f1.choose2.value =="") {
		alert("请选择公文种类！");
		return false;
	}
	window.dialogArguments.document.getElementById("topicWord").value=document.f1.choose1.value+","+document.f1.choose.value+","+document.f1.choose2.value;
	window.close();	 
}


function add(leng){
	  var pur = "";
  if(leng > 1){
	  for (var i=0; i<document.f1.del.length; i++) {
		if (document.f1.del[i].checked == true) {
			pur += document.f1.del[i].value + ",";	
		  }  
	  }
  }else if(document.f1.del.checked == true){
	pur = document.f1.del.value + ",";
  }
  if(pur!=""){
	pur=pur.substring(0,pur.length-1);
  }
     document.f1.choose.value=pur;  
}

function add1(pur){	 
     document.f1.choose1.value=pur;  
}
function add2(pur){	 
     document.f1.choose2.value=pur;  
}
function OptionChange()
{
	var style1=f1.type1;
	var style2=f1.type2;
	obj1tr=f1.all.tb1.getElementsByTagName("tr");
	obj2tr=f1.all.tb2.getElementsByTagName("tr");
	for (var i=1;i<obj1tr.length;i++) {
		child=obj1tr[i];
		if ((child.py==style2.value || style2.value=="") && (child.cls==style1.value || style1.value=="")){
			child.style.display="block";
		}else{
			child.style.display="none";
		}
	}
	for (var i=1;i<obj2tr.length;i++) {
		child=obj2tr[i];
		if ((child.py==style2.value || style2.value=="") && (child.cls==style1.value || style1.value=="")){
			child.style.display="block";
		}else{
			child.style.display="none";
		}
	}
}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="f1" method="Post">
  <table width="99%" align="center" border="0" cellpadding="0" cellspacing="1" class="tabin_in">
    <tr> 
      <th colspan="2" height="24">请选择主题词的类别/音序</th>
    </tr>
    <tr> 
      <td width="13%" nowrap align="left" height="24"><b>区域类别：</b></td>
      <td align="left" > 
        <select name="type1" style="width:110px " onChange="OptionChange();">
        <option value="">全部</option>
          <%
	               //循环输出区域分类的各个值
				    long class2;String title2;
					
	                for(int m=1;m<areatypelist.size();m++){
					   class2 = ((TbDocsendSubject)areatypelist.get(m)).getClass_();
					  
					   title2 = ((TbDocsendSubject)areatypelist.get(m)).getTitle();
    	  %>
          <option value="<%=class2%>"><%=title2%></option>
          <%                 }
	%>
        </select>
      </td>
    </tr>
    <tr> 
      <td align="left" height="24"><b>音序：</b></td>
      <td align="left" > 
        <select name="type2" onChange="OptionChange();">
		  <option value="">全部 </option>
          <option value="A"> A </option>
          <option value="B"> B </option>
          <option value="C"> C </option>
          <option value="D"> D </option>
          <option value="E"> E </option>
          <option value="F"> F </option>
          <option value="G"> G </option>
          <option value="H"> H </option>
          <option value="I"> I </option>
          <option value="J"> J </option>
          <option value="K"> K </option>
          <option value="L"> L </option>
          <option value="M"> M </option>
          <option value="N"> N </option>
          <option value="O"> O </option>
          <option value="P"> P </option>
          <option value="Q"> Q </option>
          <option value="R"> R </option>
          <option value="S"> S </option>
          <option value="T"> T </option>
          <option value="U"> U </option>
          <option value="V"> V </option>
          <option value="W"> W </option>
          <option value="X"> X </option>
          <option value="Y"> Y </option>
          <option value="Z"> Z </option>
        </select> </td>
    </tr>
    <tr> 
      <td align="left" height="24"><b>选择结果：</b></td>
        <td align="left">类别词:<input type="text" name="choose1" class="top_input" value=''>&nbsp;类属词:<input type="text" name="choose" class="tab_input" value=''>&nbsp;公文种类:<input type="text" name="choose2" class="top_input" value=''>
		<input type="button" value="提交" class="button0" onclick="tijiao()">
		<input type="button" value="返回" class="button0" onclick="window.close()">
		</td>
    </tr>
  </table>
  <table width="99%" align="center">
  <tr><td width="33%" valign="top">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" id="tb1" class="tabin_in">
    <tr> 
      <th colspan="2">类别词列表</th>
    </tr>
    <% 
		// 输出所有满足条件的列表		
		for(int i=0;i<leibieciList.size();i++){
			TbDocsendSubject item1 = (TbDocsendSubject)leibieciList.get(i);
	
	if(!"".equals(item1.getPinyin())&&(item1.getPinyin()!=null)){%>
    <tr py="<%=item1.getPinyin() %>" cls="<%=item1.getClass_() %>"> 
      <td nowrap="nowrap"><input type="radio" name="del1" onclick="add1('<%=item1.getTitle()%>')">
        <%=item1.getPinyin()%></td>
      <td nowrap><%=item1.getTitle()%></td>
      <%}%>
    </tr><%}%>
  </table>
  </td>
  <td width="33%" valign="top">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" id="tb2" class="tabin_in">
    <tr> 
      <th colspan="2">类属词列表</th>
    </tr>
    <% 
		// 输出所有满足条件的列表		
		for( int i=0;i<leishuciList.size();i++){
				TbDocsendSubject item2 = (TbDocsendSubject)leishuciList.get(i);    
	if(!"".equals(item2.getTitle())){%>
    <tr py="<%=item2.getPinyin() %>" cls="<%=item2.getClass_() %>" > 
      <td nowrap="nowrap"><input type="checkbox" value="<%=item2.getTitle()%>" name="del" onclick="add(<%=leishuciList.size()%>)">
        <%=item2.getPinyin()%></td>
      <td nowrap><%=item2.getTitle()%></td>
      <% } %>
    </tr>
    <%}%>
  </table>
  </td>
  <td width="33%" valign="top">
  <table width="100%" border="0" cellpadding="2" cellspacing="1" class="tabin_in">
    <tr> 
      <th colspan="2">公文种类列表</th>
    </tr>
	<tr> 
      <td><input type="radio" name="del2" onclick="add2('报告')">
        B</td>
      <td nowrap>报告</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('办法、细则')">
        B</td>
      <td nowrap>办法、细则</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('公报')">
        G</td>
      <td nowrap>公报</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('规定')">
        G</td>
      <td nowrap>规定</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('函')">
        H</td>
      <td nowrap>函</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('会议纪要')">
        H</td>
      <td nowrap>会议纪要</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('决议')">
        J</td>
      <td nowrap>决议</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('决定')">
        J</td>
      <td nowrap>决定</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('批复')">
        P</td>
      <td nowrap>批复</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('请示')">
        Q</td>
      <td nowrap>请示</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('通知')">
        T</td>
      <td nowrap>通知</td>
    </tr>
    <tr>
      <td><input type="radio" name="del2" onclick="add2('通报')">
        T</td>
      <td nowrap>通报</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('意见')">
        Y</td>
      <td nowrap>意见</td>
    </tr>
    <tr> 
      <td><input type="radio" name="del2" onclick="add2('指示')">
        Z</td>
      <td nowrap>指示</td>
    </tr>
  </table>
  </td>
  </tr>
  </table>
  </form>
</body>
</html>
