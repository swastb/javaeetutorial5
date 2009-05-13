<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ include file="/WEB-INF/web/inc/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<html:base target="_self" />
		<link href="../../../../css/list.css" rel="stylesheet" type="text/css">
		<script src="../../../../javascript/checkbox.js"></script>
		<link href="<%=path %>/images/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
							
		    function add(path){
		    	//alert(document.list.);
		    	//alert(document.getElementById("opf").elements);
		    	alert(document.all.opf);
		    	//alert(document.frames[1].document.all.);
		   	 	
		    }
		    function addRoot(path){
		   		var funId = document.getElementById("funId").value; 
		    	window.open(path+"/base/function/forwardFunction.do?method=inputAddFun&root=true","opf");
		    }		    
		    function update(){
		    	var path = document.getElementById("path").value;
		    	var funId = document.getElementById("funId").value;
		    	if (funId == "" || funId == '0'){
		    		alert("当前没有选择修改的资源");
		    	}else{
		    		window.open(path+"/base/function/forwardFunction.do?method=inputUpdateFun&id="+funId,"opf"); 
		    	}
		    }
		    function del(path){
		    	var funId = document.getElementById("funId").value;
		    	var isNode = document.getElementById("isNode").value;
		    	if (funId == "" || funId == '0'){
		    		alert("当前没有选择删除的资源！");
		    	}else{
		    		if(isNode=="true"){
		    			alert("当前资源有下级资源，请删除下级资源后再进行此操作！");
		    		}else{
		    			if (confirm("您是否确认删除此信息?")){
		    				window.open(path+"/base/function/forwardFunction.do?method=deleteFun&id="+funId,"opf"); 
		    			}	
		    		}
		    	}	
		    }		    
	</script>
		<style type="text/css">
<!--
.STYLE4 {color: #E43223}
-->
        </style>
	</head>
	<body>
		<input type="hidden" id="path" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="op" value="${op }" />
		
		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="288" height="40" align="left" valign="middle" background="<%=path %>/images/8-1.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="4%" align="center" valign="middle">&nbsp;</td>
              <td width="9%" height="12" align="center" valign="middle"><img src="<%=path %>/images/icon5.gif" width="7" height="7"></td>
              <td width="87%" class="table2_topic">统一权限管理系统——角色权限管理</td>
            </tr>
          </table></td>
          <td background="<%=path %>/images/8-2.gif">&nbsp;</td>
        </tr>
      </table>
	  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#0e88b9">
        <tr>
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="table2bg">
            <tr>
              <td align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin">
                   <tr>
              <th height="30" valign="bottom"></th>
           </tr>
           <tr>
         <td width="49%" align="center" valign="top">
         <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                      <td width="1%" height="24">&nbsp;</td> 
                      <td width="16%" class="tabin_atabno"><a href="<%=path %>/roleaction.do?method=list">角色管理</a></td>
                      <td width="16%" class="tabin_atab"><span class="bg-zw">角色权限管理</span></td>
                      <td width="16%" class="tabin_atabno"><a href="<%=path %>/roleusermainaction.do"><span class="bg-zw">角色用户管理</span></a></td>
                   <td width="1%">&nbsp;</td>
                   </table>
                <tr>
                  <td width="41%" align="center" valign="top">
                  <table width="99%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin_a">
                    <tr>
						<th>您选中的角色名称为</th>
						   </tr>
						    <tr>
						    <td height="300" align="center" valign="top"><table width="99%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="1"></td>
                        </tr>
                        <tr>
                          <td align="left" valign="top">
                         <iframe width="100%" height="400" frameborder="0" scrolling="auto"
							name="negi"
							src="<%=request.getContextPath()%>/base/roleAuth/forwardRoleAuth.do?method=inputShowRoleTree">
						</iframe>
						</td>
                        </tr>
                      </table></td>
                    </tr>
                  </table></td>
                  <td width="59%" align="center" valign="top"><table width="99%" border="0" cellpadding="0" cellspacing="0" class="tabtre2bgin_b">
                    <tr>
                          
						<th><div id="roleName"></div>
						</th>
						</tr>
                    <tr>
                      <td height="300" border="0" align="center" valign="top">
					
					  <table width="99%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="1"></td>
                        </tr>
                        <tr>
                          <td align="left" valign="top">
                         <form id="list" name="list" method="post">
							<iframe width="100%" height="400" frameborder="0"
								scrolling="auto" name="opf" src="" id="opf">
							</iframe>
						</form>
						</td>
                        </tr>
                      </table></td>
                    </tr>
                  </table></td>
                </tr>
               
                
              </table></td>
            </tr>
            <tr>
              <td height="1"></td>
            </tr>
          </table></td>
        </tr>
      </table>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="30"></td>
        </tr>
      </table></td>
  </tr>
</table>

		<input type="hidden" id="roleId" name="roleId" value="" />
	</body>
</html>
