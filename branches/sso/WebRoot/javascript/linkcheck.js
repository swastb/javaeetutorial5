var roleNameflag="true";
var roleCodeflag="true";
var deptNameflag="true";
var deptCodeflag="true";
var postNameflag="true";
var postCodeflag="true";
var userAccflag="true";
var funKeyflag="true";
var userlvlEnameflag="true";
var userlvlCodeflag="true";
var	authlvlCodeflag="true";
var authlvlEnameflag="true";
var rightTypeCodeflag="true";
var deptlvlEnameflag="true";
var deptlvlCodeflag="true";
var pstlvlNameflag="true";
var pstlvlCodeflag="true";
var sendMessageflag="true";
var authCAflag="true";
var individualcommNameflag="true";
var commonalityCommNameFlag="true";
var infocommNameflag="true";
var infoClacommNameflag="true";
var meetingRoomNameflag="true";
var isCanNotdoFlag="false";

function sendMessage()
{
	checkCode.checkCode(DWRUtil.getValue('id'),DWRUtil.getValue('code'), cb);
}

function cb(data)
{
    var checkMessage;
             if(data==("false"))
    {
    
      sendMessageflag="false";
      checkMessage="代码不能重复!";
  
      
    }
    else{
     sendMessageflag="true";
    }
    
	DWRUtil.setValue('sendMessage' ,checkMessage);
}


function pstlvlNameCheck()
{
	var flag="name";
	pstlvl.checkPstlvl(DWRUtil.getValue('id'),DWRUtil.getValue('name'),flag, pslvlName);
}
function pslvlName(data)
{
    var checkMessage;
         if(data==("false"))
    {
    
      pstlvlNameflag="false";
      checkMessage="职务等级名称不能重复!";
  
      
    }
    else{
     pstlvlNameflag="true";
    }
	DWRUtil.setValue('pstlvlNameCheck' ,checkMessage);
}

function pstlvlCodeCheck()
{
	var flag="code";
	pstlvl.checkPstlvl(DWRUtil.getValue('id'),DWRUtil.getValue('code'),flag, pslvlCode);
}
function pslvlCode(data)
{
    var checkMessage;
             if(data==("false"))
    {
    
      pstlvlCodeflag="false";
      checkMessage="职务等级代码名称不能重复!";
  
      
    }
    else{
     pstlvlCodeflag="true";
    }
    
    DWRUtil.setValue('pstlvlCodeCheck' ,checkMessage);
}

function userlvlEnameCheck()
{
	var flag="ename";
	userlvl.checkUserlvl(DWRUtil.getValue('id'),DWRUtil.getValue('ename'),flag, userlvlEname);
}

function userlvlEname(data)
{
    var checkMessage;
     if(data==("false"))
    {
    
      userlvlEnameflag="false";
      checkMessage="用户级别缩写名称不能重复!";
  
      
    }
    else{
     userlvlEnameflag="true";
    }
    DWRUtil.setValue('userlvlEnameCheck' ,checkMessage);
}

function userlvlCodeCheck()
{
	var flag="code";
	userlvl.checkUserlvl(DWRUtil.getValue('id'),DWRUtil.getValue('code'),flag, userlvlCode);
}

function userlvlCode(data)
{
    var checkMessage;
         if(data==("false"))
    {
    
      userlvlCodeflag="false";
      checkMessage="用户等级代码不能重复!";
  
      
    }
    else{
     userlvlCodeflag="true";
    }

    DWRUtil.setValue('userlvlCodeCheck' ,checkMessage);
}


function roleNameCheck()
{
	var field="name";
	roleCheck.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('name'),field, roleName);
}
function roleName(data)
{
    var checkMessage;
    if(data==("false"))
    {
     
      roleNameflag="false";
      checkMessage="角色名重复!";
    }
    else{
     roleNameflag="true";
    }
	DWRUtil.setValue('roleNameCheck' ,checkMessage);
	return data;
}

function roleCodeCheck()
{
	var field="code";
	roleCheck.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('code'),field, roleCode);
}
function roleCode(data)
{
    var checkMessage;
    if(data==("false"))
    {
      roleCodeflag="false";
      checkMessage="CODE重复!";
    }
    else{
     roleCodeflag="true";
    }
    
    DWRUtil.setValue('roleCodeCheck' ,checkMessage);
    return data;
}


function deptCodeCheck()
{
	var field="code";
	deptCheck.checkName(DWRUtil.getValue('nodeid'),DWRUtil.getValue('code'),DWRUtil.getValue('parCode'),field, deptCode);
}
function deptCode(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      deptCodeflag="false";
      checkMessage="CODE重复!";
  
      
    }
    else{
     deptCodeflag="true";
    }
    DWRUtil.setValue('deptCodeCheck' ,checkMessage);
    return data;
}

function deptNameCheck()
{
	var field="name";
	deptCheck.checkName(DWRUtil.getValue('nodeid'),DWRUtil.getValue('name'),DWRUtil.getValue('parentid'),field, deptName);
}
function deptName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      deptNameflag="false";
      checkMessage="部门名重复!";
	
 
    }
    else{
     deptNameflag="true";
    }

	DWRUtil.setValue('deptNameCheck' ,checkMessage);
	return data;
}



function postCodeCheck()
{
	var field="code";
	postCheck.checkName(DWRUtil.getValue('nodeid'),DWRUtil.getValue('code'),DWRUtil.getValue('parentid'),field, postCode);
}
function postCode(data)
{
    var checkMessage;
    if(data==("false"))
    {
      postCodeflag="false";
      checkMessage="CODE重复!";
    }
    else{
     postCodeflag="true";
    }
    DWRUtil.setValue('postCodeCheck' ,checkMessage);
    return data;
}

function postNameCheck()
{
	var field="name";
	postCheck.checkName(DWRUtil.getValue('nodeid'),DWRUtil.getValue('name'),DWRUtil.getValue('parentid'),field, postName);
}
function postName(data)
{
    var checkMessage;
    if(data==("false"))
    {
     
      postNameflag="false";
      checkMessage="职务名重复!";
    }
    else{
     postNameflag="true";
    }

	DWRUtil.setValue('postNameCheck' ,checkMessage);
	return data;
}

function userAccCheck()
{
	var field="userAcc";
	userCheck.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('userAcc'),field, userAcc);
}
function userAcc(data)
{
    var checkMessage;
    if(data==("false"))
    {
     
      userAccflag="false";
      checkMessage="帐号重复!";
    }
    else{
     userAccflag="true";
    }

	DWRUtil.setValue('userAccCheck' ,checkMessage);
	return data;
}

function funKeyCheck()
{
	var field="fun_key";
	funCheck.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('fun_key'),DWRUtil.getValue('fid'),field, funKey);
}
function funKey(data)
{
    var checkMessage;
    if(data==("false"))
    {
     
      funKeyflag="false";
      checkMessage="子系统唯一重复!";
    }
    else{
     funKeyflag="true";
    }

	DWRUtil.setValue('funKeyCheck' ,checkMessage);
	return data;
}

function funKeyCheckU()
{
	var field="fun_key";
	funCheck.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('fun_key'),DWRUtil.getValue('par_id'),field, funKeyU);
}
function funKeyU(data)
{
    var checkMessage;
    if(data==("false"))
    {
     
      funKeyflag="false";
      checkMessage="子系统唯一重复!";
    }
    else{
     funKeyflag="true";
    }

	DWRUtil.setValue('funKeyCheckU' ,checkMessage);
	return data;
}



function authlvlEnameCheck()
{
    var flag="ename";  
    
	authlvl.checkAuthlvl(DWRUtil.getValue('id'),DWRUtil.getValue('ename'),flag,authlvlEname);
	
}

function authlvlEname(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      authlvlEnameflag="false";
      checkMessage="权限级别缩写名称不能重复!";
  
      
    }
    else{
     authlvlEnameflag="true";
    }

    DWRUtil.setValue('authlvlEnameCheck' ,checkMessage);
}


function authlvlCodeCheck()
{
    var flag="code";  
    authlvl.checkAuthlvl(DWRUtil.getValue('id'),DWRUtil.getValue('code'),flag,authlvlCode);
	
}

function authlvlCode(data)
{
    var checkMessage;
             if(data==("false"))
    {
    
      authlvlCodeflag="false";
      checkMessage="权限级别代码不能重复!";
  
      
    }
    else{
     authlvlCodeflag="true";
    }
    
    DWRUtil.setValue('authlvlCodeCheck' ,checkMessage);
}


function deptlvlEnameCheck()
{
    var flag="ename";  
    
	deptlvl.checkDeptlvl(DWRUtil.getValue('id'),DWRUtil.getValue('ename'),flag,deptlvlEname);
	
}

function deptlvlEname(data)
{
    var checkMessage;
      if(data==("false"))
    {
    
      deptlvlEnameflag="false";
      checkMessage="部门级别缩写名称不能缩写!";
  
      
    }
    else{
     deptlvlEnameflag="true";
    }

    DWRUtil.setValue('deptlvlEnameCheck' ,checkMessage);
}

function deptlvlCodeCheck()
{
    var flag="code";  
    
	deptlvl.checkDeptlvl(DWRUtil.getValue('id'),DWRUtil.getValue('code'),flag,deptlvlCode);
	
}

function deptlvlCode(data)
{
    var checkMessage;
          if(data==("false"))
    {
    
      deptlvlCodeflag="false";
      checkMessage="部门级别代码不能重复!";
  
      
    }
    else{
     deptlvlCodeflag="true";
    }

    DWRUtil.setValue('deptlvlCodeCheck' ,checkMessage);
}

function rightTypeCodeCheck()
{   
	righttype.checkRighttypeCode(DWRUtil.getValue('id'),DWRUtil.getValue('code'),DWRUtil.getValue('funid'),rightTypeCode);	
}

function rightTypeCode(data)
{
    var checkMessage;
         if(data==("false"))
    {
    
      rightTypeCodeflag="false";
      checkMessage="权限类型代码不能重复!";
  
      
    }
    else{
     rightTypeCodeflag="true";
    }
    

    DWRUtil.setValue('rightTypeCodeCheck' ,checkMessage);
}

function sendCAPass()
{
	caAuth.authCA(DWRUtil.getValue('capassword'), checkCA);
}

function checkCA(data)
{
    if(data=="")
    {   
    	authCAflag="true"; 
    }
    else{
     	authCAflag="false";
    }
	DWRUtil.setValue('sendMessage' ,data);
}



function individualcommNameCheck()
{
    var flag="name";  
    
	individualcomm.checkIndividualCommName(DWRUtil.getValue('id'),DWRUtil.getValue('name'),DWRUtil.getValue('userid'),flag,individualcommName);
	
}

function individualcommName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      individualcommNameflag="false";
      checkMessage="组名不能重复!";
  
      
    }
    else{
     individualcommNameflag="true";
    }

    DWRUtil.setValue('individualcommNameCheck' ,checkMessage);
}



function weekSecheduleSelectUser()
{
	weeksecheduleselectuser.selectUsers(DWRUtil.getValue('userids'), SelectUser);
}
function SelectUser(data)
{
    var usernames=data;
	DWRUtil.setValue('attendance',usernames);
	return data;
}

function weekSecheduleSelectDept()
{
	weeksecheduleselectdept.selectDepts(DWRUtil.getValue('deptids'), SelectDept);
}
function SelectDept(data)
{
    var deptnames=data;
	DWRUtil.setValue('deptnames',deptnames);
	return data;
}


function commonalityCommCheck()
{
	commonalityComm.checkName(DWRUtil.getValue('id'),DWRUtil.getValue('parentId'),DWRUtil.getValue('name'),commonalityCommName);
}

function commonalityCommName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    	commonalityCommNameFlag="false";
      	checkMessage="组名称不能重复!";
    }
    else
    {
    	commonalityCommNameFlag="true";
    }

    DWRUtil.setValue('cname' ,checkMessage);
}

function infoClacommNameCheck()
{
    var flag="name"; 
	infocomm.checkInfoClaCommName(DWRUtil.getValue('id'),DWRUtil.getValue('title'),flag,infoClacommName);
	
}

function infoClacommName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      infoClacommNameflag="false";
      checkMessage="信息标题不能重复!";
  
      
    }
    else{
     infoClacommNameflag="true";
    }

    DWRUtil.setValue('infoClacommNameCheck' ,checkMessage);
}

function infocommNameCheck()
{
    var flag="name";  
	infocomm.checkInfoCommName(DWRUtil.getValue('parentid'),DWRUtil.getValue('id'),DWRUtil.getValue('name'),flag,infocommName);
	
}

function infocommName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      infocommNameflag="false";
      checkMessage="信息标题不能重复!";
  
      
    }
    else{
     infocommNameflag="true";
    }

    DWRUtil.setValue('infocommNameCheck' ,checkMessage);
}

function meetingRoomNameCheck()
{
    var flag="roomName";
	meetingRoomCheck.checkMeetingRoomName(DWRUtil.getValue('id'),DWRUtil.getValue('roomName'),meetingRoomName);
	
}

function meetingRoomName(data)
{
    var checkMessage;
    if(data==("false"))
    {
    
      meetingRoomNameflag="false";
      checkMessage="会议室名称不能重复!";
  
      
    }
    else{
     meetingRoomNameflag="true";
    }

    DWRUtil.setValue('meetingRoomNameCheck' ,checkMessage);
}

function selectCla()
{
	selectcla.selectClas(DWRUtil.getValue('infoClaIds'), SelectClaName);
}
function SelectClaName(data)
{
    var infocla=data;
	DWRUtil.setValue('infocla',infocla);
	return data;
}
function selectClas()
{
	selectcla.selectClas(DWRUtil.getValue('infoClaIds'), SelectClaNames);
}
function SelectClaNames(data)
{
    var infocla=data;
	DWRUtil.setValue('infoclas',infocla);
	return data;
}
function selectGovCla()
{
	selectcla.selectClas(DWRUtil.getValue('infoClaIds'), SelectGovClaName);
}
function SelectGovClaName(data)
{
    var infocla=data;
	DWRUtil.setValue('attr2',infocla);
	return data;
}
function isCanNotdo()
{
	iscannotdo.isCanNotdo(DWRUtil.getValue('parentid'),DWRUtil.getValue('rightcode'),DWRUtil.getValue('userId'), IsCanNotDo);
}
function IsCanNotDo(data)
{
   isCanNotdoFlag=data;
   return isCanNotdoFlag;
}
function infoClaCodeCheck()
{
    var flag="code"; 
	infocomm.checkInfoClaCommName(DWRUtil.getValue('parentid'),DWRUtil.getValue('id'),DWRUtil.getValue('code'),flag,infoClacommCode);
	
}

function infoClacommCode(data)
{
    var checkMessage;
    if(data==("false"))
    {
      infoClacommCodeflag="false";
      checkMessage="栏目代码不能重复!";
    }
    else{
     infoClacommCodeflag="true";
    }

    DWRUtil.setValue('infoClaCodeCheck' ,checkMessage);
}
