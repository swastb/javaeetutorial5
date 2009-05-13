//特殊提交，本页面使用
function tSubmint() {
	var objects = opener.document.body.getElementsByTagName("object");
	var i;
	for(i = 0; i < objects.length; i++) {
		var classid = objects[i].getAttribute("classid");
		if(classid == "clsid:49C1B3F0-4F6D-4907-9CE8-CD34C04343C8") { 
			var hiddenName = objects[i].getAttribute("field");
		
			var hidden = opener.document.getElementById(hiddenName);	
			hidden.value = objects[i].GetStoreData();
		}
	}
	 opener.document.forms[0].submit();
	
}

function setSelectResult(elemName,data)
{
	var e = opener.document.getElementsByName(elemName)[0];
	if(e.value == "" || e.value == null)
	{
	   e.value = data;	
	}
	else
	{
	   e.value += "," + data;
	}
}

/**
*	委托传参数用
	TODO
*/
function processwtbutton(select,isaccepthidden)
{
	var val = select.selectedIndex;
	var value = select.options[val].text;
	//alert(value);
	var onclick = (document.getElementsByName("wtbutton")[0].onclick);
	isaccepthidden.value = value;
	//alert(onclick.toString());
	var str = onclick.replace("isaccept=", "haha");
//	.replace("isaccept=", "isaccept=" + value);
	//alert(str);
}

//输入框不为空
function checkselectid()
{
  var a =document.forms[0].selectedid.value;
      if(a==null || a == "")
      {
		    alert('请选择后进行操作')
         return false;
	  }
	  return true;
    
}

// 判断输入的金额
function isMoney(obj)
{
   var str=obj.value;
   if(str=="") return false;
   if(!isNum(str))
   {
     alert("只能输入数字！");
     obj.value = "";
     obj.focus();
     return;
   }
}

//检查结束是否大于开始
function checkArea() {
    var se = getInput('start');
    var ee = getInput('end');
    if (se === null || ee === null) {
        return true;
    }
    if (se.value > ee.value) {
        window.alert("\u7ed3\u675f\u65f6\u95f4\u4e0d\u80fd\u5927\u4e8e\u5f00\u59cb\u65f6\u95f4");
        se.focus();
        return false;
    }
    return true;
}

//得到有某项标记的元素
function getInput(attrName) {
    var ele = document.forms[0].elements;
    for (var i = 0; i < ele.length; i += 1) {
        var e = ele[i];
        var attr = e.getAttribute(attrName);
        if (attr !== null && attr !== "") {
            return e;
        }
    }
    return null;
}
//选择流程
function setMutiwindowreturns()
{
  window.returnValue=document.forms[0].result.value;
  window.close();
}

//特殊提交，子本页面使用
function ttSubmint() {
	var objects = document.body.getElementsByTagName("object");
	var i;
	for(i = 0; i < objects.length; i++) {
		var classid = objects[i].getAttribute("classid");
		if(classid == "clsid:49C1B3F0-4F6D-4907-9CE8-CD34C04343C8") { 
			var h = objects[i].field;
			var hiddenName = objects[i].getAttribute("field");
			//alert(objects[i].id);
			//alert(hiddenName);
			var hidden = document.getElementById(hiddenName);		
		    //alert( objects[i].GetStoreData().substring(0, 30));
			hidden.value = objects[i].GetStoreData();           
	
			}
	}
	
document.forms[0].submit();
}


function deletehandwrite(f)
{
  var hiddenname =  f.getAttribute("field");
  document.forms[0].deletehw.value=hiddenname;
  ttSubmint();
}

//点聚空间使用
function setSessionAndAddress(session,address)
{
    var objects = document.body.getElementsByTagName("object");
	var i;
	for(i = 0; i < objects.length; i++) {
		var classid = objects[i].getAttribute("classid");
		if(classid == "clsid:49C1B3F0-4F6D-4907-9CE8-CD34C04343C8") { 
			objects[i].SetSessionID(session);
			objects[i].SetHttpAddr(address);
		}
	}
}
//手写签名
 function  handwrite(ctrlname,layerName)
 {

   ctrlname.SetDivName(layerName);
   ctrlname.SetSignData(joinInputValue());

    ctrlname.HandWriteEx(2,0x0000FF,400,300);
  var layerObj = document.getElementById(layerName);
   if(ctrlname.GetPosW() > 0) {
		layerObj.style.width = ctrlname.GetPosW() + "px";
	}
   if(ctrlname.GetPosH() > 0) {
		layerObj.style.height = ctrlname.GetPosH() + "px";
	}
   ttSubmint();
 }
 
 
 //加盖印章,参数 印章控件、签名隐藏域
function addmanyseal(ctrlname,layerName)
{
 ctrlname.SetDivName(layerName);
   ctrlname.SetSignData(joinInputValue());
//盖章
ctrlname.AddSealCtrl();
var layerObj = document.getElementById(layerName);
   if(ctrlname.GetPosW() > 0) {
		layerObj.style.width = ctrlname.GetPosW() + "px";
	}
   if(ctrlname.GetPosH() > 0) {
		layerObj.style.height = ctrlname.GetPosH() + "px";
	}
   ttSubmint();
}
 
 
 
 //显示印章，签名数据
function showdata() {
 
    var objects = document.body.getElementsByTagName("object");
	var i;
	for(i = 0; i < objects.length; i++) {
	    var obj = objects[i];
		var classid = obj.classid;
		if(classid == "clsid:49C1B3F0-4F6D-4907-9CE8-CD34C04343C8") { 
			var hiddenName = obj.field;
			var layerName = obj.layer;
			var layer = document.getElementById(layerName);
			var hidden = document.getElementById(hiddenName);	
			//alert(obj.id);
                  //   alert(hiddenName );
                  //   alert(layerName );
                  //   alert(hidden.value);
			
                       obj.SetDivName(layerName);
			obj.SetStoreData(hidden.value);
	     if(obj.GetPosW() > 0) {
		   layer.style.width = obj.GetPosW() + "px";
	       } 
         if(obj.GetPosH() > 0) {
		   layer.style.height = obj.GetPosH() + "px";
	      }
		   
	  }
	}
 }

//刷新前一个页面，关闭本页面
function refurbishAndClose()
{
   opener.location.reload();
   window.close();
}
//设置公章私章，点聚控件使用
function setgongsizhang(f)
{
  if(f.id =="公章" )
  {
  document.forms[0].gongsizhang.value = "1";
  } 
  else if(f.id == "私章")
 {
 document.forms[0].gongsizhang.value = "2";
 }
}


function uploadSealFile(fileName)
{
   try
   {
    
   }
   catch(e)
   {
    alert("文件不存在或无权访问文件。");
    return;
   }
  
document.forms[0].zhuan.style.display="block";
document.forms[0].action.value="tijiao";
document.forms[0].submit();

}




//对签名进行认证
function verifySign(ctrlname,sign)
{
  alert();
  if(sign.length>0)
  {
  
  ctrlname.SetSignData(joinInputValue());
  ctrlname.SetStoreData(sign); 
  ctrlname.VerifyDoc();//  返回值　:-1.未设置数据．０，未通过．１．通过．
  }
  else
  {
   alert("没有签名数据");
  }
}

// 把将input 中的内容串联起来，其中标签是sign="sign"
function joinInputValue()
{
  var result = "";
  for(var i = 0; i < document.forms[0].elements.length; i++)
  {
    var element = document.forms[0].elements[i];  
    if(((element.type == "text")||(element.type == "textarea"))
     &&(element.sign=="sign"))
    {
      result = result + element.value;
    }
  }
  return result;
}




//加盖印章,参数 印章控件、签名隐藏域
function addseal(ctrlname,hiddenField)
{

ctrlname.SetDivName("layer1");
//设置签名数据

ctrlname.SetSignData(joinInputValue());
//盖章

ctrlname.AddSealCtrl();
if(document.all.DHtmlSeal1.GetPosW() > 0) {
		document.all.layer1.style.width = document.all.DHtmlSeal1.GetPosW() + "px";
	}
if(document.all.DHtmlSeal1.GetPosH() > 0) {
		document.all.layer1.style.height = document.all.DHtmlSeal1.GetPosH() + "px";
	}

//设置隐藏域的签名
var ret = ctrlname.GetStoreData();

 if(ret != null && ret != "#signdata#" && ret != "")
 {
  hiddenField.value += ret;

  document.forms[0].event.value="saveseal";

document.forms[0].submit();
  } 
}


function showseal(f)
{
document.forms[0].DHtmlSeal1.SetDivName("Layer1");
document.forms[0].DHtmlSeal1.SetStoreData(document.forms[0].sign.value);
if(document.all.DHtmlSeal1.GetPosW() > 0) {
		document.all.Layer1.style.width = document.all.DHtmlSeal1.GetPosW() + "px";
	}
if(document.all.DHtmlSeal1.GetPosH() > 0) {
		document.all.Layer1.style.height = document.all.DHtmlSeal1.GetPosH() + "px";
	}
}





function deleteseal()
{
  document.forms[0].event.value="deleteseal";
ttSubmint();
}

//删除上传的个人印章 
function deleteSeal(f)
{
	if(window.confirm("您真的要删除印章吗？")){
		document.forms[0].deleteid.value=f;
		document.forms[0].submit();
	  }
	 else
	 {
	    return;
	 }
}



function uploadFile(fileName,maxSize)
{
//   try
//   {
//   var fso, f, s;
//   fso = new ActiveXObject("Scripting.FileSystemObject");
//   f = fso.GetFile(fileName);
//   if(f.size-maxSize*1048576>0)
//   {
//    alert("上传的文件太大。");
//    return;
//   }
//   }
//   catch(e)
//   {
//    alert("文件不存在或无权访问文件。");
//    return;
//   }
document.forms[0].zhuan.style.display="block";
document.forms[0].action.value="confirm";
document.forms[0].submit()
}

function uploadImageFile(fileName,maxSize)
{
   try
   {
 
   }
   catch(e)
   {
    alert("文件不存在或无权访问文件。");
    return;
   }
document.forms[0].zhuan.style.display="block";
document.forms[0].action.value="confirm";
document.forms[0].submit()
}


//上传文件，无大小限制
function uploadunlimitfile(f,uploadfilename)
{
	  
    if( uploadfilename == null || uploadfilename == "")
    {
    	alert("请选择文件!");
    	return;
    }
    var ele =f.elements;
    var tip = "";
    for(var i = 0; i < ele.length; i++)
    {
       if(ele[i].notnull == "notnull")
       {
          if(ele[i].value == "")
          {
            tip += ele[i].cname+",";
          }
       }
    }
    if(tip!="")
    {
       tip = tip.substring(0, tip.length - 1);
       alert(tip + "不能为空。");
    }
    else
    {
       f.zhuan.style.display="block";
       f.action.value="confirm";
       f.submit();
    }
}



/**
* 个人文件夹文件上传的各种判断
* @param file 文件上传框元素
* @param maxSize 上传文件不能超过的大小
* @return void
*/
function doFileUpload(file,maxSize)
{
   //如果没有选择文件
   if(file.value == null || file.value == "")
   {
      //弹出提示信息并返回
      alert("请选择要上传的文件");
      return;
   }
   //校验上传文件是否超过了规定大小
   try
   {
   var fso, f, s;
   //fso = new ActiveXObject("Scripting.FileSystemObject");
   //f = fso.GetFile(file.value);
   //if(f.size-maxSize>0)
   //{
    //alert("上传的文件太大。");
    //return;
   //}
   }
   catch(e)
   {alert("test");
    alert("无权访问文件!\r\n可能是您禁用了ActiveX控件，或安全设置过高");
    return;
   }
   document.forms[0].action.value="addfile";
   document.forms[0].submit();
   document.getElementById("zhuan").style.display="block";
}
// 把textarea每行前面的空格去掉
function procTextArea()
{
  for(var i = 0; i < document.forms[0].elements.length; i++)
  {
    var element = document.forms[0].elements[i];
    if(element.type == "textarea")
    {
      var result = "";
      var source = element.value;
      for(var j = 0; j < source.length; j++)
      {
        if(source.charAt(j)  != ' ' && source.charAt(j)  != '\t')
        {
          result += source.charAt(j);
        }
      }
      element.value = result;
    }
  }
}

// 询问用户是否确认删除
function confirmDelete(url)
{
  if(window.confirm("您真的要删除这一项吗？"))
  {
    window.open(url);
  }
}

// 询问用户是否确认修改
function confirmModify(url)
{
  if(window.confirm("确实要修改此项？"))
  {
    window.open(url);
  }
}

// 询问用户是否确认该操作
function confirmOperater(url)
{
if(window.confirm("确定要进行该操作吗？"))
  {
    window.open(url);
  }
}

// 以最大化方式打开窗口
function openMaxWindow(url)
{
  //var height=740;
  //var width=1024;
  var top=0;
  var left=0;
  //if(screen.availWidth>1024){
	//left=(screen.availWidth-1024)/2-2
  //}

 // if(screen.availHeight>800){
	//top=(screen.height-800)/2-2
  //}
//2007年3月2日，注释掉上面几行，将页面修改为适合屏幕大小
  var win = window.open(url, "_blank", "toolbar=no, menubar=no, scrollbars=auto, resizable=no,location=no, status=no, resizable=yes");
  win.moveTo(left,top);
  win.resizeTo(screen.availWidth, screen.availHeight);
  win.focus();
}

// 向文本筐中追加内容
function append(area, hidden)
{
var s = window.showModalDialog("appendWithUserAndDate.jsp");
area.value=hidden.value + s;
}

// 判断一个字串是否全数字
function isNumber(str)
{
  if (str == "") return false;
  for(var i = 0; i < str.length; i++)
  {
    if(str.charAt(i) < '0' || str.charAt(i) > '9' )
    {
      return false;
    }
  }
  return true;
}

// 判断一个字串是否数字与标点"."
function isNum(str)
{
  if (str == "") return false;
  for(var i = 0; i < str.length; i++)
  {
    if(str.charAt(i) < '0' || str.charAt(i) > '9' )
    {

      if(str.charAt(i) !='.')
      {
        return false;
      }
    }
  }
  return true;
}

// 判断一个字串是否数字与标点","
function isNumber1(str)
{
  if (str == "") return false;
  for(var i = 0; i < str.length; i++)
  {
    if(str.charAt(i) < '0' || str.charAt(i) > '9' )
    {
      if(str.charAt(i) !=',')
      {
        return false;
      }
    }
  }
  return true;
}

// 判断一个字串是否数字与标点":"
function isNumber2(str)
{
  if (str == "") return false;
  for(var i = 0; i < str.length; i++)
  {
    if(str.charAt(i) < '0' || str.charAt(i) > '9' )
    {
      if(str.charAt(i) !=':')
      {
        return false;
      }
    }
  }
  return true;
}

// 判断输入的数字
function checkNumber(obj)
{
   var str=obj.value;
   if(str=="") return false;
   if(!isNumber2(str))
   {
     alert("输入的数字不合法！");
     obj.value = "";
     obj.focus();
     return;
   }
}
// 判断输入的数字
function checkNumber2(obj)
{
   var str=obj.value;
   alert(str);
   if(str=="") return false;
   if(!isNumber2(str))
   {
     alert("输入的数字不合法！");
     obj.value = "";
     obj.focus();
     return;
   }
}

// 日期到月
function checkNum(obj)
{
  var str=obj.value;
  if(str=="")
  {
    obj.value = "";
    obj.focus();
    return;
  }
  if(!isNumber(str))
  {
    alert("输入的数字不合法,请输入数字！");
    obj.value = "";
    obj.focus();
    return;
  }
  else
  {
    if(str.length < 8 )
    {
      alert("输入的数字长度小于8！");
      obj.value = "";
      obj.focus();
      return;
    }
  }
}

// 检查输入的人数,年数
function checkNumren(obj)
{
   var str=obj.value;
   if(str=="")
   {
    obj.value = "";
    obj.focus();
    return;
   }
   if(!isNumber(str))
   {
    alert("输入的数字不合法,请输入数字  ！");
    obj.value = "";
    obj.focus();
    return;
   }
   else
   {
     if(str.length > 2 )
     {
      alert("输入的数字长度不能大于2  ！");
      obj.value = "";
      obj.focus();
      return;
    }
  }
}

// 判断书的邮编
function checkNumyoubian(obj)
{
   var str=obj.value;
   if(str=="")
   {
    obj.value = "";
    obj.focus();
    return;
   }
   if(!isNumber(str))
   {
    alert("输入的数字不合法,请输入数字  ！");
    obj.value = "";
    obj.focus();
    return;
   }
   else
   {
     if(str.length > 6)
     {
      alert("输入的数字长度不能大于6,请重新输入  ！");
      obj.value = "";
      obj.focus();
      return;
    }
  }
}

// 日期到日
function checkNumdate(obj)
{
  var str=obj.value;
  if(str=="")
  {
    obj.value = "";
    obj.focus();
    return;
  }
  if(!isNumber(str)&&str.length<8)
    {
      alert("输入的日期不合法  ！");
      obj.value = "";
      obj.focus();
      return;
    }
}

// 获得当前时间yyyy-MM-dd
 function getNowDate(obj)
  {
var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }    date=window.showModalDialog("timeOfNow.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
obj.value=date.substring(0,10);
}

// 获得当前时间HH:mm:ss
 function getNowTime(obj)
  {
var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  date=window.showModalDialog("timeOfNow1.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
  obj.value=date.substring(11,20);
}


// 提交日历
function chooseCalendar(a,b)
{
  b.value = a.name;
  document.forms[0].submit();
}

//
function showTable(tableObject,argument)
{
  if(argument.statues=="show")
  {
    tableObject.style.display="none";
    argument.value="打开";
    argument.statues="hidden";
    argument.src="../imagine/mainclosea.gif";
  }
  else
  {
    tableObject.style.display="block";
    argument.value="关闭";
    argument.statues="show";
    argument.src="../imagine/mainopena.gif";
  }
}

function thisPageSubmit(f)
{
   if(window.event.keyCode == 13)
   {
      checknotnull2(f);
   }
}

// 主页面显示模板上"打开"与"关闭"按钮的效果切换
function changeMouseOverColor(argument)
{
  if(argument.statues=="show")
  {
    argument.src="../imagine/maincloseb.gif";
  }
  else
  {
    argument.src="../imagine/mainopenb.gif";
  }
}

// 主页面显示模板上"打开"与"关闭"按钮的效果切换
function changeMouseOutColor(argument)
{
  if(argument.statues=="show")
  {
    argument.src="../imagine/mainclosea.gif";
  }
  else
  {
    argument.src="../imagine/mainopena.gif";
  }
}

// 判断列表筐第n行，第n列是否数字
function listCheck(f)
{
  var str;
  for(var i = 0; i < f.length; i++)
  {
    if(f.elements(i).type == "text")
    {
      var name=f.elements(i).name;
      if(name.indexOf(".pagenumber")!=-1||name.indexOf(".rownumber")!=-1)
      {
      str = f.elements(i).value;
      if(!isNumber(str))
      {
        alert("请输入数字！");
        f.elements(i).value = "";
        f.elements(i).focus();
        return;
      }
      else
      {
        if(str.charAt(0)=='0'||str.charAt(0)=='-')
        {
          alert("您输入的数字不合法！");
          f.elements(i).value = "";
          f.elements(i).focus();
          return;
        }
      }
      }
    }
  }
  f.submit();
}




/**
 * 从列表source中移动选择的人员到列表target中
 * @param source
 * @param target
 * @param result 用于参数传递的结果
 */
function move(source, target)
{
  var i = 0;
  for(i = 0; i < source.options.length; i++)
  {
    if(source.options(i).selected == true)
	  {
      var oOption2 = document.createElement('OPTION');
      oOption2.text = source.options(i).text;
      target.add(oOption2);
      source.remove(i);
      i--;
    }
  }
}

/**
 * 移动source中的所有选择项到target中
 * @return
 */
function moveAll(source, target)
{
  var i = 0;
  for(i = 0; i < source.options.length; i++)
  {
    var oOption2 = document.createElement('OPTION');
    oOption2.text = source.options(i).text;
    target.add(oOption2);
    source.remove(i);
    i--;
  }
}

/**
 * 把列表中的所有选择项添加到文本输入域中
 */
function listToText(source, target)
{
  // 将目标清空
  target.value = "";
  // 将源的内容添加到目标中，用','分割
  var i = 0;
  for(i = 0; i < source.options.length; i++)
  {
    if(i != 0)
    {
      target.value += ",";
    }
    target.value += source.options(i).text;
  }
}






/**
 * 设置选择项有变化
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setAlterItem(result, item)
{
  var source = result.value;
  var target = item.name;
  var resourceName = document.forms[0].resourcename.value;
 
  if(resourceName != null)
  {
     setAlterItemResouece(result,item);
  }
  else
  {
  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {
    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {
    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }
  // 设置结果
  result.value = source;
  }
}


function setAlterItemForPost(result, item)
{
  var source = result.value;
  var target = item.name;

 // var resourceName = document.forms[0].resourcename.value;
 // if(resourceName != null)
 // {
 //    setAlterItemResouece(result,item);
 // }


  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {
    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }
  // 设置结果
  result.value = source;

}

/**
 * 设置选择项有变化
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setAlterItemForNews(result, item)
{
  var source = result.value;
  var target = item.name;
 // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {
    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }

  // 设置结果
  result.value = source;

 }



/**
 * 设置选择项有变化
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setCheckAlterItem(result, context)
{
  var source = result.value;
  var target = context
 // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {
    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }
  // 设置结果
  result.value = source;
 }
/**
 * 设置选择项有变化
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setAlterItemResouece(result, item)
{
  var source = result.value;
  var target = item.name;
  var resourceName = document.forms[0].resourcename.value;
  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {
    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {
    var start = resourceName.indexOf(target);
    if(start != -1)
    {
    var end = resourceName.lastIndexOf("_",start);
    var ends = resourceName.lastIndexOf(",",start);
    var newvalue = resourceName.substring(ends+1,end);
    var lastIndex = resourceName.lastIndexOf(",");
    var length = resourceName.length;
    var typename = resourceName.substring(lastIndex+1,length);
    var message =  typename + " '" + newvalue + "' 有子，您真的要将其及其所有子选中吗？";
       if(window.confirm(message))
       {
         // 将变化项添加到变化集合中
         if(source != "")
          {
              source += ',';
          }
             source += target;
       }
       else
        {
           item.checked = false;
         }
    }
    else
    {
    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
    }
  }
  // 设置结果
  result.value = source;
}
/**
 * 设置选择项有变化,并提交
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setAlterItemAndSubmit(result, item)
{

  var source = result.value;
  var target = item.name;

  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {

    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }

  // 设置结果
  result.value = source;
  orientation();

  //设置action，
  document.forms[0].checked.value = "checked" ;
  document.forms[0].submit();
  }



/**
 * 设置选择项有变化,并提交
 * @param result 所有有变化的选择项的集合，用","分隔。
 * @param item 要设置的选择项。
 */
function setAlterItemAndSubmitForDepartment(result, item)
{

  var source = result.value;
  var target = item.name;

  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {

    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }

  // 设置结果
  result.value = source;
  orientation();


  document.forms[0].submit();
  }



function setwithotherAlterItem(result, item,other)
{
  var source = result.value;
  var target = item.name;
  // 在变化集合中找
  var index = indexOf(source, target);
  // 没找到
  if(index != -1)
  {

 var oth=new Number(other.value);
 var tempt=new Number(item.value);
other.value=oth-tempt;

    // 得到变化项的长度
    var length = index + target.length;
    if(length != source.length)
    {
      length += 1;
    }
    // 从变化集合中删除变化项
    source = source.substring(0, index) + source.substring(length);
    // 删除最后的','
    if(source.charAt(source.length - 1) == ',')
    {
      source = source.substring(0, source.length - 1);
    }
  }
  // 找到了
  else
  {

 var oth=new Number(other.value);
 var tempt=new Number(item.value);
other.value=oth+tempt;
    // 将变化项添加到变化集合中
    if(source != "")
    {
      source += ',';
    }
    source += target;
  }
  // 设置结果
  result.value = source;
}






/**
 * 得到选择项在所有选择内容中的字符串位置。
 * @param source 已选择内容字符串
 * @param target 选择项名称
 * @return 字符串位置，没有找到，返回-1
 */
function indexOf(source, target)
{
  // 在已选择内容中找选择项
  var index = source.indexOf(target);
  while(index != -1)
  {
    // 如果找到的选择项前后都是','，说明是一个完整的选择项，返回
    var end = index + target.length;
    if((index == 0 || source.charAt(index - 1) == ',') &&
      (end == source.length || source.charAt(end) == ','))
    {
      return index;
    }
    // 否则，继续查找
    index = source.indexOf(target, index + 1);
  }
  return index;
}
//删除地址栏中的next
function deleteNext()
{
//删除后的地址栏中的前半部分
var  firststring;
//删除后的地址栏中的后半部分
var  laststring;
//首先得到地址栏中的内容　
var next=window.location.href;
//得到option的点
 var con=next.indexOf(".option");
if(con!=-1)
{

var pre=next.lastIndexOf("?",con);
var p=next.lastIndexOf("&",con);
if(pre!=-1)
{

firststring=next.substring(0,pre+1);


}
if(p!=-1)
{
firststring=next.substring(0,p);

}
if(pre!=-1&&p!=-1)
{
first=next.substring(0,p);



}
var last=next.indexOf("&",con);

if(pre!=-1&&last!=-1)
{
 laststring=next.substring(last+1,next.length);


}
if(p!=-1&&last!=-1)
{
laststring=next.substring(last,next.length);

}
if(p!=-1&&pre!=-1&&last!=-1)
{
laststring=next.substring(last,next.length);
}
window.location.href=firststring+laststring;
}


}

function  tijiao(a,re)
{
  a.href=a.href+"&"+"test="+re.value;
}

// 用户修改密码的输入检查
function passwordcheck()
{
  if(document.forms[0].newPassword.value.length<6||document.forms[0].affirmPassword.value.length<=6)
  {
    alert("你的密码必须大于5位 ！");
  }
  else
  {
    if(document.forms[0].newPassword.value!=document.forms[0].affirmPassword.value)
    {
      alert("你的密码不一致 ！");
      document.forms[0].newPassword.value="";
      document.forms[0].affirmPassword.value="";
    }
    else
    {
     document.forms[0].submit();
    }
  }
}

//输入框不为空，带提交
function checknotnull(f)
{
  if(checkNotNullWithoutSubmit(f) == true) {
    f.submit();
  }
}

//查询提交
function searchchecknotnull(f)
{
    f.submit();
}

//代表时间段的对象
function TimeSegment(name) {
  this.name = name;
}

//从数组中找到给定名字的时间段
function getTimeSegment(segments, name) {
  var i = -1;
  for(i in segments) {
    if(segments[i].name == name) {
      return segments[i];
    }
  }
  var segment = new TimeSegment(name);
  segments[i + 1] = segment;
  return segment;
}

//得到页面上所有开始时间与结束时间对
function getTimeSegments(form) {
  var segments = new Array();  
  var ele = form.elements;
  var tip = "";
  for(var i = 0; i < ele.length; i++)
  {
    //有开始标记，在数组中找到对象，设置开始时间
    if(ele[i].timestart != undefined) {
      segment = getTimeSegment(segments, ele[i].timestart);
      segment.timestart = ele[i].value;      
    }
    //有结束标记，在数组中找到对象，设置结束时间
    else if(ele[i].timeend != undefined) {
      segment = getTimeSegment(segments, ele[i].timeend);
      segment.timeend = ele[i].value;      
    }
  }
  return segments;
}

//检查时间段是否合法
function checkTimeSegment(segment) {
  if(segment.timestart > segment.timeend) {
    alert(segment.name + "：开始时间不能大于结束时间，请重新选择！");
    return false;
  }
  return true;
}

//检查开始时间是否小于结束时间
function flowCheckTimeSegment(f) {
  var segments = getTimeSegments(document.forms[0]);
  for(i in segments) {
    if(checkTimeSegment(segments[i]) == false) {
      return false;
    }
  }
  return true;  
}

//流程流转输入框不为空
function flowchecknotnull(f)
{
  var ele =f.elements;
  var tip = "";
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        tip += ele[i].cname+",";
      }
    }
  }
  if(tip!="")
  {
    tip = tip.substring(0, tip.length - 1);
    alert(tip + "不能为空。");
    return false;
  }
  else
  {
    return true;
  }
}

//检查流程中的输入内容
function flowCheck(f) {
  if(flowchecknotnull(f) == false) {
    return false;
  }
  if(flowCheckTimeSegment(f) == false) {
    return false;
  }
  return true;
}

//输入框不为空
function onerecord(f)
{
  var ele =f.elements;
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        alert("不能为空，请重新输入！");
        ele[i].focus();
        return;
      }
    }
  }
  if(window.confirm("确认该项操作吗？"))
  {
    f.onerecord.value = "onerecord";
    f.submit();
  }
}


//输入框不为空
function checknotnull2(f)
{
  var ele =f.elements;
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        alert("用户名和密码不能为空，请重新输入！");
        ele[i].focus();
        return;
      }
    }
  }
  document.forms[0].submit();
}

//输入框不为空
function checknotnullforlogin(f)
{
  var ele =f.elements;
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
       alert("您输入的用户名或密码不正确！");
        ele[i].focus();
        return;
      }
    }
  }
  document.forms[0].submit();
}

//只检查不允许为空，不提交，返回是否检查成功
function checkNotNullWithoutSubmit(f) {
  var ele =f.elements;
  var tip = "";
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        tip += ele[i].cname+",";
      }
    }
  }
  if(tip!="")
  {
    tip = tip.substring(0, tip.length - 1);
    alert(tip + "不能为空。");
    return false;
  }
  return true;
}

function processfirstsubmit(f,str)
{
  var ele =f.elements;
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        alert("不能为空，请重新输入！");
	var obj=f.reallysubmit;
        if(obj!="")
        {
          obj.value="";
        }
        ele[i].focus();
        return;
      }
    }
  }
  document.forms[0].reallysubmit.value='true';
  window.open(str);
}

//设置错误
function wrongmessagebox()
{
  alert("您输入的用户名或密码不正确！");
}

//设置成功
function passwordupdate()
{
  alert("您的设置已成功！");

    opener.location.reload();
  //opener.top.left.location.reload();
  window.close();
}



function submitCheck()
{
var ele =document.forms[0].elements;
   //检查长度
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].minlength!=null&&ele[i].minlength!="")
    {
      if(ele[i].value.length<ele[i].minlength)
      {
      alert("长度不能少于"+ele[i].minlength);
      ele[i].focus();
      return;
      }
    }
  }
  //检查空
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].notnull == "notnull")
    {
      if(ele[i].value == "")
      {
        alert("不能为空!请重新输入  ！");
	    ele[i].focus();
        return;
      }
    }
  }
  //检查数字
  for(var j=0;j<ele.length;j++)
  {
  if(ele[j].number=="number")
    {
	  var str=ele[j].value;
      if(!isNum(str))
	   {
	      alert("输入的数字不合法  ！");
          ele[j].value = "";
          ele[j].focus();
          return;
	   }
     }
  }
  document.forms[0].submit();
}

//用户编辑模板中的判断
function checkAllIsNull()
{
  if(document.forms[0].name.value.length<1)
  {
    alert("中文名不能为空！");
  }
  else if(document.forms[0].ename.value.length<1)
  {
    alert("登陆名不能为空！");
  }
   else
  {
    document.forms[0].submit();
  }
}

function transtree(a,hide)
{
  hide.value=a.name;
  	NS = (document.layers) ? 1 : 0;
	IE = (document.all) ? 1: 0;
	if(IE) { diffY = document.body.scrollTop; diffX = document.body.scrollLeft; }
	if(NS) { diffY = self.pageYOffset; diffX = self.pageXOffset; }
  for(var i = 0; i < hide.form.elements.length; i++)
  {
    var element = hide.form.elements[i];
    if(element.type == "hidden")
    {
      if(element.id == "xlocation")
      {
        element.value = diffX;
      }
      else if(element.id == "ylocation")
      {
        element.value = diffY;
      }
    }
  }
  hide.form.submit();
}

function reallsubmit()
{
  document.forms[0].reallysubmit.value="reall";
  document.forms[0].submit();
}

function selectedsubmit()
{

  document.forms[0].reallysubmit.value="reall";
  document.forms[0].submit();
}

function selectedsubmit2()
{
	 document.forms[0].reallysubmit.value="reall";
  document.forms[0].submit();
  window.close();

}

function doEmptey(a)
{
  a.value="";
}

// 设置输入焦点为用户名
function setFocus()
{
  document.forms[0].loginUser.focus();
}

//
function settradeinputvalue(obj,t,form)
{
  var url="page.jsp?templatename="+t;
  var temp=window.showModalDialog(url, null, "dialogWidth:800px; dialogHeight:600px; dialogLeft:180px; dialogTop:80px");
  if(temp !=""&& isNumber1(temp))
  {
    obj.value=temp;
    if(form!="")
    {
      form.submit();
    }
  }
}

//从打开的windows模态对话筐中把值传给obj
function selectedValuef(obj,t)
{

  var temp=window.showModalDialog(t, null, "dialogWidth:500px; dialogHeight:375px; center:yes");
  if(temp !="")
  {
    obj.value=temp;
  }
}

//从打开的windows模态对话筐中把值传给obj
function selectedValue(obj,t)
{
  var temp=window.showModalDialog(t, null, "dialogWidth:500px; dialogHeight:375px; dialogLeft:150px; dialogTop:100px");
  if(temp !="")
  {
    obj.value=temp;
  }
}

function setwindowreturn()
{
  if(document.forms[0].resultdarpent.value.indexOf(",")!=-1)
  {
    alert("你不能多选  ！");
    return;
  }
  window.returnValue=document.forms[0].resultdarpent.value;
  window.close();
}

function setMutiwindowreturn()
{
  window.returnValue=document.forms[0].resultdarpent.value;
  window.close();
}
function setMutiwindowreturns()
{
  window.returnValue=document.forms[0].result.value;
  window.close();
}
//设置选择内容，可以多选
function setWindowReturnForMultable()
{
  window.returnValue=document.forms[0].resultdarpent.value;
  window.close();
}

function testtest(a,b,c)
{
  alert(a);
  document.all(a).style="display:display";
}

//处理标签选择，所有标签必须有type="tab"属性
//div:要显示标签
function tabClick(div)
{
  //对于每一个元素
  var elements = document.all;
  for(var i = 0; i < elements.length; i++)
  {
    //如果是标签
    if(elements[i].type == "tab")
    {
      //隐藏
      elements[i].style.display = "none";
    }
  }
  //显示要显示的标签
  div.style.display="block";
}
function setthirdValue(a,b,c)
{
c.value=a.value+"-"+b.value;
}

//设置树选中的节点并提交
function setTreeSelected(selectedid, treeForm)
{
   orientation();
  document.forms[0].selectedid.value = selectedid;
  document.forms[0].submit();
}

function setvaluebyselected(source,a,b)
{
var value = source.options[source.selectedIndex].value;

if(value=="按件")
{
tabClick(a)
}
else
{

tabClick(b)
}




}

 function tested()
  {
    opener.document.forms[0].sellsmen.value=document.all('returnvalue').value;

  window.close();

  }



function tabsubmit(obj)
{

document.forms[0].tab.value=obj;
 document.tabform.submit();

}

//初始化
function init()
{
  var es = document.forms[0].elements;
  document.forms[0].result.value = "";
  for(var i = 0; i < es.length; i++)
  {
    if(es[i].type == "select")
    {
      if(document.forms[0].result.value != "")
      {
        document.forms[0].result.value += ","
      }
      document.forms[0].result.value += es[i].name + "-" + es[i].value;
    }
  }

}


function submitresult(x,y,z,p,q,a,b,c,f,str)
{

checkprocessdef(x,y,z,p,q)


if(getsuplit(a,b,c))
{

 processfirstsubmit(f,str)
}
}



//验证身分证
function datefromID(sex,sele,IDid,birth)
{
if(IDid.value=="")
{

return;
}
if(!isNumber(IDid.value))
{
alert("请您正确填写身份证 ！");
IDid.value="";

IDid.focus();

return;

}

if(sele.options[sele.selectedIndex].text=="身份证")
{

var lastBit = IDid.value.substring(IDid.value.length - 1,IDid.value.length );

if( sex.options[sex.selectedIndex].text == '男')
{
	if((lastBit != '1') && (lastBit != '3') && (lastBit != '5') && (lastBit != '7') && (lastBit != '9'))
	{
	alert("请您正确填写男性身份证 ！");
        IDid.value="";
         birth.value="";
        IDid.focus();
	return;
	}
}

if( sex.options[sex.selectedIndex].text == '女')
{
	if((lastBit != '0')&&(lastBit != '2')&&(lastBit != '4')&&(lastBit != '6')&&(lastBit != '8'))
	{
	alert("请您正确填写女性身份证 ！");
         IDid.value="";
         birth.value="";
          IDid.focus();
       return;
	}
}


/////
   var IDlength123=IDid.value.length;
   if(IDlength123==15)
   {
     var y=IDid.value.substring(0,6)+19;

	 var p=y+IDid.value.substring(6,15);
	//求和的结果
	var h=0;
	//2的n次方
	var w=1;
	//对于已经添加年的17位身份证号
	for(var i=1;i<=17;i++)
	{
	   //取一位
	   var s=p.charAt(17-i);

	   w*=2;
	   var xx=w%11;
	   h+=xx*s;

	}

	var wwww=h%11;
	var ai;
	if(wwww==0)
	{ai=1;}
	else if(wwww==1)
	{ai=0;}
	else if(wwww==2)
	{ai="x";}
	else if(wwww==3)
	{ai=9;}
	else if(wwww==4)
	{ai=8;}
	else if(wwww==5)
	{ai=7;}
	else if(wwww==6)
	{ai=6;}
	else if(wwww==7)
	{ai=5;}
	else if(wwww==8)
	{ai=4;}
	else if(wwww==9)
	{ai=3;}
	else if(wwww==10)
	{ai=2;}

	IDid.value=p+ai;

	IDlength123=IDid.value.length;

   }
   if(IDlength123==18)
  {
   birth.value=IDid.value.substring(6,14);
  // var currentdate=new Date().getYear();

 //  var subdateyear=IDid.value.substring(6,10);
 //  age.value=currentdate-subdateyear;

  }
   else{
   alert("输入的身份证号不正确 ！");
   return;
   }
}

}

// 按回车键后登录
function loginonkey()
{
  if(window.event.keyCode ==13)
  {
    document.forms[0].submit();
  }
}

// 选择日历
function chooseCalendar(a,b)
{
  b.value=a.name;
  document.forms[0].submit();
}

function checkvalue(obj)
{
   var str=obj.value;
   if(!isNum(str))
   {
    alert("你输入的数字不正确!");
    obj.value = "";
    obj.focus();
    return;
   }
   else
  {
var temp = new Number(str);
if(temp>1)
{
alert("输入的值不能大于1!");
    obj.value = "";
    obj.focus();
    return;
}
 }
}



// 判断两次输入的内容是否一致
function checkrepair(a,b)
{
  var atemp = a.value;
  var btemp = b.value;
  if(atemp!=btemp)
  {
    alert("两次输入的号码不一致，请重新输入。");
    b.value="";
    a.focus();
  }
}

//验证是否是身份证号码
function datefromshen(a,b)
{
  var temp = a.value;
  if(temp=="身份证")
  {
    if(b.value.length != 15 && b.value.length != 18)
    {
      alert("您输入的身份证号码的位数不正确！");
      b.value="";
      b.focus();
    }
  }
}

//聊天室中选择用户
function chatselectuser(a)
{
  top.right.document.forms[0].sayto.value=a.username;
  top.right.document.forms[0].useridsayto.value=a.userid;
}

// 聊天室中设置是否是悄悄话
function chatprivateselect(a)
{
  if(a.value == "false")
  {
    a.value="true";
  }
  else
  {
    a.value ="false";
  }
}

// 聊天室中滚动条的定位
function scrollgoto()
{
  document.body.scrollTop=10000;
}

//聊天室中的xmlhttp请求
function sendxmlhttp(s)
{
  var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  xmlhttp.Open("POST", "s", false);
  xmlhttp.Send("<timesheet>b</timesheet>");
  divPublic.innerHTML=divPublic.innerHTML+xmlhttp.responseText;
  setTimeout("send()",3000);
}

//
function setResult(result,radio)
{
  result.value=radio.value;
}

// 打开一个窗口
function openResult(url,result)
{
  url=url+'&amp;result='+result.value;
  window.open(url, "_blank", "scrollbars=yes");
}

// 打开另一个窗口
function gotoanotherurl(obj,tname)
{
  var href="page.jsp?templatename="+tname+"&keyword="+obj.value;
  window.open(href);
}

//
function reallsubmit2()
{
  if(this.document.all("result").value.length<2)
    {
      alert("您没有选择人！");
      return;
    }

  if(this.document.all("result").value.length>8)
    {
      alert("您一次只能转发一个活动！");
      return;
    }
 document.forms[0].reallysubmit.value="reall";
 document.forms[0].submit();
}

function checkActivityNull()
{
  if(this.document.all("result").value.length<2)
    {
      alert("您没有选择活动！");
      return;
    }
}
function conformStopProcess()
 {
    if(window.confirm("该活动终止后不能被重启，您真的要继续吗？"))
       {
          this.document.all("action").value="stopProcess";
          document.forms[0].submit();
       }
 }
function conformStopActivity()
 {
 if(this.document.all("result").value.length<2)
  {
   alert("您没有选择活动！");
   return;
  }
    if(window.confirm("该活动终止后不能被重启，您真的要继续吗？"))
       {
          this.document.all("action").value="stopActivity";
          document.forms[0].submit();
       }
 }
function suspendProcess()
{

this.document.all("action").value="suspendProcess";
document.forms[0].submit();
}
function resumeProcess()
{

this.document.all("action").value="resumeProcess";
document.forms[0].submit();
}

function suspendActivity()
{
checkActivityNull();
this.document.all("action").value="suspendActivity";
document.forms[0].submit();
}

function resumeActivity()
{
checkActivityNull();
this.document.all("action").value="resumeActivity";
document.forms[0].submit();
}

function callbackActivity()
{
checkActivityNull();
this.document.all("action").value="callbackActivity";
document.forms[0].submit();
}

function setTransmitID()
{
  if(this.document.all("result").value.length<2)
    {
      alert("您没有选择需要操作的活动！");
      return;
    }
  if(this.document.all("result").value.indexOf(",") != -1)
    {
      alert("您一次只能转发一个活动！");
      return;
    }
    this.document.all("action").value="transmitActivity";

var nexturl="page.jsp?templatename=转发人员选择&amp;activityID="+this.document.all("result").value;
  window.open(nexturl,'_blank','toolbar=no,menubar=no,location=no,scrollbars=yes,top=115,left=210,width=804,height=596');
  document.forms[0].submit();
}

//如果是功能
function setFunctionType(lalye,linktype,pagenames,processnames,link)
{
 lalye.style.display="block";
 linktype.value="function";
 pagenames.disabled=false;
 processnames.disabled=true;
 link.value="";
 link.readOnly=true;
}

//如果是流程
function setProcessType(lalye,linktype,pagenames,processnames,link)
{
 lalye.style.display="block";
 linktype.value="process";
 pagenames.disabled=true;
 processnames.disabled=false;
 link.value="";
 link.readOnly=true;
}

//如果是自定义的链接
function setDefineType(lalye,linktype,pagenames,processnames,link)
{
 lalye.style.display="block";
 linktype.value="defineself";
 pagenames.disabled=true;
 processnames.disabled=true;
 link.readOnly=false;
}

//
function checkFunctionNull2()
{
  if(document.forms[0].functionlink.value!=null&&document.forms[0].functionlink.value!="")
  {
    document.all["add"].style.display="none";
  }
  else
  {
    document.all["add"].style.display="block";
  }
}



//日历
 var  days = new Array();
    var  aDate ;
    var  dateObj;
  //点击下一年触发的事件
   function nextyear()
   {
        var i = aDate.getYear();
		i++;
		aDate.setYear(i);
		useDateSetArray();
		showDate();
   }
   //点击上一年触发的事件
   function previousyear()
   {
       var i = aDate.getYear();
	   if(i!=2000)
	   {
		i--;
		}
		aDate.setYear(i);
		useDateSetArray();
		showDate();
   }
   //点击下个月触发的事件
   function  nextmonth()
   {
       var i = aDate.getMonth();
		i++;
		aDate.setMonth(i);
		useDateSetArray();
		showDate();
   }
  //点击上个月触发的事件
  function previousmonth()
  {

       var i = aDate.getMonth();
	i--;
	aDate.setMonth(i);
	useDateSetArray();
	showDate();
  }
  //把日期设为这个月的第一天，便于计算
  function setFristDayOfMonth()
  {
     //获得当前日期
     aDate = new Date();
     //把日期设为这个月的第一天
     aDate.setDate(1);
     //用日期格式化日期数组
     useDateSetArray();
     //把日期设置的日期层中
     showDate();
  }
  function useDateSetArray()
  {
         //这个月的天数
	 var dayNumber = 31;
         //得到选择的年份
	 var year = aDate.getYear();
         //得到选择的天
	 var dayOfWeek = aDate.getDay();
	 //得到选择的月
         var month = aDate.getMonth();
	  //如果是小月付30天
          if(month==3 || month ==5 || month  ==8 || month ==10)
	  {
	     dayNumber = 30;
	  }
          //如果是二月
	  if(month==1)
	 {
                //如果是闰年
	            if(year%100 == 0 &&  year%400 ==0)
		    {
			           dayNumber = 29;
			}
                      //如果不是闰年
			if(year%100 == 0 &&  year%400 !=0)
			{
			            dayNumber = 28;
			 }
		   //如果是闰年
                   if(year%100 != 0 &&  year%4 == 0)
			 {
			         dayNumber = 29;
			  }
                        //如果不是闰年
			  if(year%100 != 0 &&  year%4 != 0)
			  {
			           dayNumber = 28;
			   }
	 }
	   //一个月中的第一周的前面几个位置清空
	   for(var i= 0; i<dayOfWeek;i++)
		  {
		     days[i] ="";
		  }
              //设置天
		  for(var i = 0; i < dayNumber; i++)
		  {

                       days[i+dayOfWeek] ="" +(i + 1);

		  }
                  //一个月中的最后一周的后面几个位置清空

		  for(var i=dayNumber+dayOfWeek; i < 42;i++)
		  {
		     days[i] ="";
		  }

  }

//显示设置日期
function showDate()
  {
         //当前日期
         var now = new Date();
         //天
         var dayofmonth;
	 //选择的日期中的月份
         var  monthofdate=document.all("monthofdate");
	 //选择的日期中的年份
        var yearofdate = document.all("yearofdate");
	 //把月份设置到页面中
	   monthofdate.innerHTML= aDate.getMonth()+1+"月";
	  //把年份设置的页面中
          yearofdate.innerHTML=aDate.getYear()+"年";
	  //把天设置的页面中
	  for(var i = 0 ;i <42 ; i++)
	  {
             dayofmonth = document.all("dayofmonth_"+i);
             dayofmonth.innerHTML = days[i];
              //如果选择的日期和当前日期相同，突出显示
             if(now.getYear()==aDate.getYear()&&now.getMonth()==aDate.getMonth()&&now.getDate()==days[i])
             {
                dayofmonth.bgcolor="#000000";
             }
	     days[i] ="";
          }

  }
//选择日期事件
function onclickday(obj)
{
  //选中的月
  var month = aDate.getMonth()+1;
  //选中的日
  var dayOfMonth = obj.innerHTML;
  //用两位数表示月
  if(month<10)
  {
    month="0"+month;
  }
  //用两位数表示日
  if(dayOfMonth < 10)
 {
   dayOfMonth = "0"+dayOfMonth;
 }
 //把日期设置给原对象
 dateObj.value=""+aDate.getYear()+"-"+month+"-"+dayOfMonth;
 //日期层隐藏
 document.all("datepart").style.visibility="hidden";
}
//启动选择日期层
function statrdate(obj)
{
   var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  //记住原对象
  dateObj = obj;
  //初始化日期对象
   //获得当前日期
     aDate = new Date();
     //把日期设为这个月的第一天
     aDate.setDate(1);
     //用日期格式化日期数组
     useDateSetArray();
     //把日期设置的日期层中
     showDate();
  //设置日期层的位置
   document.all("datepart").style.left=event.x+document.body.scrollLeft;
  document.all("datepart").style.top=event.y+document.body.scrollTop;
  //设置日期层为显示状态
  document.all("datepart").style.visibility="visible";
}

//论坛帖子选择表情
function selectFace(obj)
{
  document.forms[0].f_face.value=obj.value;
}

//会员头像
function selectPortrait(obj)
{
  document.forms[0].result.value=obj.value;
}

// 往文本筐中追加内容
function append2(area, hidden)
{
  var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  if(hidden.value == "")
  {
    hidden.value = area.value;
  }
  var s = window.showModalDialog("append.jsp");
  area.value=hidden.value + s;
}
function appendapp(area)
{
  var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  var s = window.showModalDialog("append.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
  area.value= s;
}
function appendNameAndDate(area)
{
var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  var s = window.showModalDialog("appendWithUserAndDate.jsp","","dialogWidth:300px;dialogHeight:200px;center:yes");

  area.value= area.value + s + "\n";
  var i=area.value.indexOf("undefined");
  if(i>=0)
  {
     area.value=area.value.substring(0,i);
  }
}

//判断是不是合法的email地址
function isRightEmail(email)
{
  var str=email.value;
  var length=str.length;
  var a=str.indexOf("@");
  var b=str.lastIndexOf(".");
  if(a<1||b==length-1||b-a<2)
  {
    email.value="";
    alert("不是合法的email，请重新输入！");
  }
}
//是功能时添加子的按钮变灰
function checkFunctionNull()
{
if(document.forms[0].functionlink.value!=null&&document.forms[0].functionlink.value!="")
{
     var img=document.all("addfunction").replaceimg;
     document.all("addfunction").src=img;
     document.all("addfunction").onclick="";

}
}
//选择日期
function calendarSelect(obj)
{
   var url = document.location.href;
   //如果是只读状态直接返回
   if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
   var name=obj.name;
   var date=window.open("calendarSelect.jsp?item="+name,"","fullscreen=yes,scrollbars");
   date.blur();
   date.resizeTo(195,175);
   date.moveTo(200,200);
   date.focus();
}

// 获得当前时间yyyy-MM-dd hh:00
 function getTimeOfNow(obj)
  {
var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
 var date=window.showModalDialog("timeOfNow.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
obj.value=date;
}
// 获得当前用户名和日期
 function getUserNameAndDate(obj)
  {
  var url = document.location.href;
    //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }    var date=window.showModalDialog("userNameAndDate.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
obj.value=date;
}
//宝鸡工程中的督办提醒
function superviseAwake()
{
  window.open("page.jsp?templatename=督办提醒表显示模板","_blank", "status=no,toolbar=no,menubar=no,location=no,top=100,left=150,width=495,height=309");
}
//宝鸡工程中的督办流程中没有填写办结报告的提醒
function noReturnAwake()
{
  window.open("page.jsp?templatename=无办结报告提醒表显示模板","_blank", "status=no,toolbar=no,menubar=no,location=no,top=100,left=150,width=495,height=309");
}

//执行人员选择器的查询
function searchUser(searchtype)
{
document.all('searchtype').value=searchtype.name;
document.forms[0].submit();
}
//判断b的值是否大于a的值
function stringCompare(a,b)
{
  //如果数据不空
  if(a.value!=""&&b.value!="")
  {
    //取得长度小的做循环的长度
    var length= a.value.length;
    if(a.value.length>b.value.length)
    {
      length=b.value.length;
    }
    var aChar;
    var bChar;
    for(var i=0;i<length;i++)
    {
       //取得单个字符的字符值
       aChar=a.value.charCodeAt(i);
       bChar=b.value.charCodeAt(i);
       //用字符值的大小做判断
       if(aChar>bChar)
       {
         alert("结束时间不能小于开始时间，请重新选择！");
         b.value="";
         return false;
       }
       if(aChar<bChar)
       {
         return false;
       }
    }
    //能走到这说明，前length位相等，比较长度
    if(b.value.length>a.value.length)
    {
       alert("数据不合法，请重新输入！");
         b.value="";
         return false;
    }
  }
}
//用户修改密码时的判断
function checkPassword()
{
  if(document.all('oldPassword').value.length<6
   ||document.all('newPassword').value.length<6
    ||document.all('affirmPassword').value.length<6)
  {
    alert("用户密码不能小于6位！");
    return false;
  }
  else if(document.forms[0].newPassword.value != document.forms[0].affirmPassword.value)
  {
    document.forms[0].newPassword.value="";
    document.forms[0].affirmPassword.value="";
    alert("两次输入的密码不一致，请重新输入！")
  }
  else
  {
    document.forms[0].submit();
  }
}
//写入ekey
function writeEkey(content)
{
	if(content!="")
	{
          if(content.length<100)
		{
		this.document.BSEkey.WriteEkey(content);
		}
	}
}
//读ekey中的数据
function readEkey()
{
 this.document.all("ekeyuser").value= this.document.BSEkey.ReadEkey();
}

//检查上传的文件地址是否为空
function checkuploadfile(src,obj)
{
if(document.forms[0].file.value=="")
{
  if(window.confirm("你没有选择文件 "));
  {
   window.close();
  }
}
else
{
  inProcessUpload(src,obj)
}
}
//文件开始上传时要显示的信息
function inProcessUpload(src,obj)
{
  obj.style.visibility="visible";
  src.style.visibility="hidden";
}
//用多选框做单选的动作
function setSingleItem(result, item)
{
  if(result.value == item.name)
  {
    result.value ="";
  }
  else
  {
  result.value = item.name;
  }
   //找到所有的多选框，设置成未选中状态
   var ele =document.forms[0].elements;
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].type == "checkbox")
    {
        if(ele[i].name != item.name)
        {
            ele[i].checked="";
        }
    }
  }
}

//看全选框是否选择
function IsSelect(form,comid,obj)
{
  if(obj.checked==false)
  {
    selectNo(form,comid);
  }
  else
  {
    selectAll(form,comid);
  }
}


//看全选框是否选择
function IsSelectForPost(form,comid,obj)
{

  if(obj.checked==false)
  {
    selectNo(form,comid);
  }
  else
  {
    selectAllForPost(form,comid);
  }
}


//看全选框是否选择
function IsSelectForNews(form,comid,obj)
{
  if(obj.checked==false)
  {
    selectNo(form,comid);
  }
  else
  {
    selectAllForNews(form,comid);
  }
}
//看全选框是否选择::应用于资源管理
function IsSelectResource(form,comid,obj)
{
  //得到obj的顺序
  var order = obj.order;
  if(obj.checked==false)
  {
    selectNoResource(form,comid,order);
  }
  else
  {
    selectAllResource(form,comid,order);
  }
}

//全选
function selectAll(form,comid)
{
  var elements = form.elements;
  var str="";
  //清除comid的内容
  comid.value = "";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      e.checked=true;
      if(e.name!="selectall")
      {
        setAlterItem(comid, e);
      }
    }
  }
}


//全选
function selectAllForPost(form,comid)
{
  var elements = form.elements;
  var str="";
  //清除comid的内容
   comid.value = "";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      e.checked=true;
      if(e.name!="selectall")
      {
        setAlterItemForPost(comid, e);

      }
    }
  }
}



//全选
function selectAllForNews(form,comid)
{
  var elements = form.elements;
  var str="";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      e.checked=true;
      if(e.name!="selectall")
      {
        setAlterItemForNews(comid, e);
      }
    }
  }
}

//全选::应用于资源管理
function selectAllResource(form,comid,order)
{
  var elements = form.elements;
  var str="";
  comid.value = "";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      if(e.order==order)
      {
       e.checked=true;
      if(e.name!="selectall")
      {
        setAlterItem(comid, e);
      }
      }
    }
  }
}

//全不选
function selectNo(form,comid)
{
  var elements = form.elements;
  var str="";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      e.checked=false;
    }
  }
  comid.value="";
}

//全不选::应用于资源管理
function selectNoResource(form,comid,order)
{
  var elements = form.elements;
  var str="";
  for(var i=0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.type=="checkbox")
    {
      if(e.order==order)
      {
      e.checked=false;
      }
    }
  }
  comid.value="";
}

// 询问用户是否确认退出系统
function confirmExit()
{
 if(window.confirm("您确定要退出陕西省水利厅电子政务系统吗？"))
  {
    return true;
}
 else
 {
    return false;
  }
}

//询问用户是否确认删除,非彻底删除
function confirmNotRealDelete(comid)
{
	var elements = document.forms[0].elements;
	var flag = true;
	for(var i = 0; i < elements.length; i++) {
		var e = elements[i];
		if (e.name == comid.value) {
			if (e.value != "") {
				flag = false;
        		if(window.confirm("您真的要删除所选项吗？删除后邮件将保存到垃圾箱中！"))
      			{
       			   document.forms[0].action.value="deleteselected";
         	       document.forms[0].submit();
                }
			}
		}
	}
	if(flag)
  	{
   		alert("请先选择需要删除的记录，再进行删除！");
  	}
}

//询问用户是否确认删除(批量删除使用)
function confirmDeleteSelected(comid)
{
  var elements = document.forms[0].elements;
  var flag = true;
  for(var i = 0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.name==comid.value)
    {
      if(e.value!="")
      {
        flag = false;
        if(window.confirm("您真的要删除所选项吗？删除后将无法恢复！"))
        {
          document.forms[0].action.value="deleteselected";
          document.forms[0].submit();
        }
      }
    }
  }
  if(flag)
  {
    alert("请先选择需要删除的记录，再进行删除！");
  }
}


//给选中的实体添加删除标记 isdeleted="true"
function adddeletemarker(comid)
{
   var elements = document.forms[0].elements;
  var flag = true;
  for(var i = 0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.name==comid.value)
    {
      if(e.value!="")
      {
        flag = false;
        if(window.confirm("您真的要删除所选项吗？删除后将无法恢复！"))
        {
          document.forms[0].action.value="adddeletemarker";
          document.forms[0].submit();
        }
      }
    }
  }
  if(flag)
  {
    alert("请先选择需要删除的记录，再进行删除！");
  }
}


//询问用户是否确认删除(批量删除使用)
function confirmDeleteOfEnd(title,hao)
{
  var post = title;
  var id = hao;
  //得到有子得id号
   var hasChildIDS = document.forms[0].resourcename.value;

  //如果无子
   if(hasChildIDS.indexOf(post) == -1)
   {
     window.open("delete.jsp?id=" + id + "&amp;tablename=t_oapost");
   }
   //如果有子
   else
   {
        //提示
        if(window.confirm("你选中的资源下面有子，你确定要删除吗？"))
        {
          window.open("delete.jsp?id=" + id + "&amp;tablename=t_oapost");
        }
   }
}



function confirmDeleteSelectedForPost(comid)
{

 var elements = document.forms[0].elements;
  for(var i = 0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.name==comid.name)
    {

      if(e.value!="")
      {

        if(window.confirm("您真的要删除所选项吗？删除后将无法恢复！"))
        {
          document.forms[0].action.value="deleteselected";
          document.forms[0].submit();
        }
      }
      else
      {
        alert("请先选择需要删除的记录，再进行删除！");
      }
    }
  }
}


//询问用户是否确认删除(批量删除使用)
function confirmDeleteResource(comid)
{
  var elements = document.forms[0].elements;
  for(var i = 0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.name==comid.value)
    {
      if(e.value!="")
      {
        if(window.confirm("您真的要删除所选的记录吗？删除后将无法恢复！"))
        {
          document.forms[0].action.value="deleteselected";
          document.forms[0].submit();
        }
      }
      else
      {
        alert("请先选择需要删除的记录，再进行删除！");
      }
    }
  }
}

//根据option的index设置action的值
function setActionByOption(object)
{

  var index = object.selectedIndex;
  if(index==0)
  {
   document.forms[0].action.value = "firstoption";
  }
  else
  {
    document.forms[0].action.value = "otheroption";
  }

  document.forms[0].submit();
}


//根据option的index设置action的值
function setActionByOption2(object)
{

  var index = object.selectedIndex;
  if(index==0)
  {
   document.forms[0].action.value = "firstoption";
  }
  else
  {
    document.forms[0].action.value = "otheroption";
  }
  object.options[object.selectedIndex].selected.value = "true";
  document.forms[0].submit();
}

function orientation()
{
  	NS = (document.layers) ? 1 : 0;
	IE = (document.all) ? 1: 0;
	if(IE) { diffY = document.body.scrollTop; diffX = document.body.scrollLeft; }
	if(NS) { diffY = self.pageYOffset; diffX = self.pageXOffset; }
  for(var i = 0; i < document.forms[0].elements.length; i++)
  {
    var element = document.forms[0].elements[i];
    if(element.type == "hidden")
    {
      if(element.id == "xlocation")
      {
        element.value = diffX;
      }
      else if(element.id == "ylocation")
      {
        element.value = diffY;
      }
    }
  }
}

//获得当前时间，精确到秒 格式未;HH:MM:SS
// 获得当前时间yyyy-MM-dd
 function getNowTime(obj)
  {
  var url = document.location.href;
  //如果是只读状态直接返回
  if(url.indexOf("readonly=readonly")>0)
  {
    return false;
  }
  date=window.showModalDialog("timeOfNow1.jsp","","dialogWidth:0px;dialogHeight:0px;center:no");
  obj.value=date.substring(11,19);
}

//检查用户输入的时间 时间格式必须未HH:MM:SS
function checkInputTime(f)
{
   checkNumber(f);
}

function showfiltrate(inherit)
{
  if(inherit.options[inherit.selectedIndex].text =="否")
    {
      document.forms[0].action.value=inherit.name+"false";
    }
  else
    {
      document.forms[0].action.value=inherit.name+"true";
    }
  document.forms[0].submit();
}

function setRightType(ch,action)
{
  orientation();
  if(ch.checked==true)
    {
      action.value=ch.name+"true";
    }
  else
    {
      action.value=ch.name+"false";
    }
  document.forms[0].submit();
}

//是不是纯整数
function isInteger(number)
{
	if(!isNumber(number))
	{
		alert("请输入整数!");
		return false;
	}
	return true;
}

//返回下一个页面的选择值
function selectNode(obj,str)
{
  var v = window.showModalDialog("page.jsp?templatename="+str,"","dialogWidth:800px;dialogHeight:600px;center:yes");

  if(v!=null)
  {
    obj.value = v;
  }
}
//根据树中所选择的节点返回节点名称
function setReturnValue()
{
var value;
  	if(document.forms[0].result.value != null
    	||document.forms[0].result.value != "")
    {
      value = document.forms[0].result.value;
	}
	else
	{
       alert("result is null");
	}

   window.returnValue = value;
   window.close();
}

//论坛选择头像按钮
function selectHead(obj)
{
  var v = window.showModalDialog("page.jsp?templatename=会员头像编辑模板","","dialogWidth:626px;dialogHeight:470px;dialogLeft:210px;dialogTop:115px");

  if(v != null)
  {
    obj.value = v;
  }
}
//LOGO选择按钮
function selectLogo(obj)
{
  var v = window.showModalDialog("page.jsp?templatename=logo编辑模板","","dialogWidth:250px; dialogHeight:180px; center:yes");

  if(v != null)
  {
    obj.value = v;
  }
}
//在右下方打开窗口
function lowerRightOpen(url)
{
  var win = window.open(url, "right", "scrollbars=yes");
  win.focus();
}


//在右下方打开窗口
function openerlowerRightOpen(url)
{
  var win = opener.open(url, "right", "scrollbars=yes");
  win.focus();
}

//占用情况查看模板用来进行时间选择
function setcalendarpreviou()
{
	 this.document.forms[0].action="previou";
	 this.document.forms[0].submit();
}


//设置选择条件
function setselectoption(object)

{
  var index = object.selectedIndex;
  if(index==0)
  {
   document.forms[0].action.value = "firstoption";
  }
  else
  {
    document.forms[0].action.value = "otheroption";
  }
   object.condvalue=object.options[object.selectedIndex].text;

  document.forms[0].submit();
}


//用于人员选择器
function setconditionaction(name)
{
	 name.value='search';

	document.forms[0].submit();
}

//设置删除日志
function deleteOperateLog()
{
  document.forms[0].deleteLogs.value='yes';
  if(window.confirm("您真的要清除一年以前的日志吗？该操作将无法恢复。"))
  {
    document.forms[0].submit();
  }
}

//论坛退出
function exitForum(obj1,obj2)
{
  obj1.value='exit';
  if(window.confirm(obj2))
  {
    document.forms[0].submit();
  }
}

function exitFrame(obj)
{
  if(window.confirm(obj))
  {
    window.parent.close();
  }
}
//用户已存在
function wrongUserMessageBox()
{
  alert("该用户名已存在！");
}
//组织已存在
function wrongOrganizationMessageBox()
{
  alert("该组织已存在！");
}

function confirmOperate(obj)
{
  if(window.confirm(obj))
  {
    document.forms[0].submit();
    return true;
  }
  return false;
}

function cutUserAndRole(obj)
{
  if(window.confirm(obj))
  {
    document.forms[0].deleteid.value="userid";document.forms[0].submit();
  }
}
//设置页面selectedresult隐藏域得值
function setSelected(result)
{
  document.forms[0].selectedresult.value=result;
}

//个人文件夹里面判断修改删除文件夹时是否选择了文件夹,如果用户还没有根目录，就同意创建一个
function readyToGo(url,where,how)
{
	var unexpand = top.contents.document.getElementsByTagName("unexpand").item(0);
	var expand = top.contents.document.getElementsByTagName("expand").item(0);
	var curexpand = top.contents.document.getElementsByTagName("curexpand").item(0);
	var leaf = top.contents.document.getElementsByTagName("leaf").item(0);
	var curunexpand = top.contents.document.getElementsByTagName("curunexpand").item(0);
	var curleaf = top.contents.document.getElementsByTagName("curleaf").item(0);
	//如果有根目录了
	if(expand || unexpand || curexpand || leaf || curunexpand || curleaf)
	{
		//用户没有选择要操作的文件夹
		if(url.indexOf("nodeid")>=0 || url.indexOf("null")>=0)
		{
			alert("请先选择文件夹");
			return;
		}
		//选择了
		else
		{
			window.open(url,where,how);
			return;
		}

	}
	else //无根目录
	{
		//如果是创建目录，同意创建
		if(url.indexOf("parentid")>=0)
		{
			window.open(url,where,how);
			return;
		}
		else
		{
			alert("请先创建一个根目录");
			return;
		}
	}
}

function readyToDelete(url)
{
	if(url.indexOf("nodeid")>=0 || url.indexOf("null")>=0)
	{
		alert("请先选择要删除的文件夹");
		return;
	}
	else
	{
		if(confirm("                ------- 警告  -------                "+"\r\n\r\n"+
		           "执行该操作会将此文件夹永久删除。"+"\r\n\r\n"+
				   "您确定这样做吗？"))
		{
			window.open(url,"_blank","toolbar=no,menubar=no,location=center,top=0,left=0,width=1,height=2");
		}
	}
}

// 判断列表筐第n行，第n列是否数字
function numberListCheck(f)
{
  var size=0;
  for(var i = 0; i < f.length; i++)
  {
    if(f.elements(i).type == "text")
    {
      size++;
    }
  }
  var str;
  for(var i = 0; i < f.length; i++)
  {
    if(f.elements(i).type == "text")
    {
      str = f.elements(i).value;
      if(!isNumber(str))
      {
        alert("请输入数字！");
        f.elements(i).value = "";
        f.elements(i).focus();
        return;
      }
      else
      {
        if(str.charAt(0)=='0'||str.charAt(0)=='-')
        {
          alert("您输入的数字不合法！");
          f.elements(i).value = "";
          f.elements(i).focus();
          return;
        }
      }
     if(str-size>0)
     {
       alert("您输入的数字太大！");
       f.elements(i).focus();
       return;
      }
    }
  }
  f.submit();
}

//判断是不是手机号码列表
function isMobileNumberList(str)
{
    var arrayList = str.split(",");
	for(i=0;i<arrayList.length;i++)
	{
		var phoneNumber = arrayList[i];
		//如果不是手机号码
		if(!(phoneNumber.length==11/* && phoneNumber.indexOf("13")==0*/))
		{
			return false;
		}
	}
	return true;
}

function setHelpFolder(obj)
{
  if(obj.style.display=="none")
  {
    obj.style.display="block";
  }
  else
  {
    obj.style.display="none";
  }
}

//询问用户是否确认删除( 邮件彻底删除使用)
function confirmDeleteMail(comid)
{
  var elements = document.forms[0].elements;
  for(var i = 0;i<elements.length;i++)
  {
    var e = elements[i];
    if(e.name==comid.value)
    {
      if(e.value!="")
      {
        if(window.confirm("您真的要删除所选的记录吗？删除后将无法恢复！"))
        {
          document.forms[0].action.value="deletedmail";
          document.forms[0].submit();
        }
      }
      else
      {
        alert("请先选择需要删除的记录，再进行删除！");
      }
    }
  }
 }

 //新闻模块使用，根据选择的模板设置页面上的上传附件和图片按钮



 function setButtons(sele)
 {
 	//得到选中的模板名
	if(sele != null)
	{
 	 var a = sele.options[sele.selectedIndex].text
	}
	//如果是不带附件的
  	if(a != null && a.indexOf('附件') > 0)
  	{
	 document.forms[0].attachment.style.display = "block";

  	}
	//带附件
	else
	{

	    //删除附件按钮
	    document.forms[0].attachment.style.display = "none";
	}
	//如果是不带图片的
  	if(a != null&&a.indexOf('图片') >  0)
  	{
	 	//删除图片按钮
        document.forms[0].addimage.style.display = "block";
	}
	//如果是带图片的
	else
	{
	    //删除图片按钮
        document.forms[0].addimage.style.display = "none";


	}
 }


//快捷工具条设置使用，办断选择的工具个数是否超过最大限制
function checkmaxnumber()
{
var number  = 0;
  for(var i = 0; i < document.forms[0].elements.length; i++)
  {
    var element = document.forms[0].elements[i];
    if(element.type == "checkbox" )
    {
       if(element.checked == true)
         {
		 number= number + 1;
      }
    }
  }
  if(number > 6)
  {
   alert("快捷工具最多为六个！");
   return;
  }
  else
  {
    document.forms[0].action.value='goto';
    document.forms[0].reallysubmit.value="reall";
    document.forms[0].submit();
  }

}
function checkDocumentName()
{
if(document.forms[0].filename.value!=""&&document.forms[0].name.value!="")
{
document.forms[0].action.value="confirm";
document.forms[0].submit();
}
else
{
alert("模板名和上传路径都不能为空。");
}
}

// 以最大化方式打开带工具条、地址栏的窗口
function openMaxUrlWindow(url)
{
  var height = screen.availHeight;
  if(screen.availHeight == screen.height)
  {
     height -= 50;
  }
  var win = window.open(url, "_top");
  win.moveTo(0, 0);
  win.resizeTo(screen.availWidth, height);
  win.focus();
}

//作用：载入iWebOffice
function load(web_url,record_id,file_name,file_type,user_name,edit_type,show_type,template_name,form_name){
	

  //以下属性必须设置，实始化iWebOffice
  form_name.weboffice.WebUrl=web_url;    //WebUrl:系统服务器路径，与服务器文件交互操作，如保存、打开文档，重要文件
  form_name.weboffice.RecordID=record_id; //RecordID:本文档记录编号
  form_name.weboffice.FileName=file_name;   //FileName:文档名称
  form_name.weboffice.Template=template_name;   //Template:模板编号
  form_name.weboffice.FileType=file_type;   //FileType:文档类型  .doc  .xls  .wps
  form_name.weboffice.UserName=user_name;  //UserName:操作用户名，痕迹保留需要
  form_name.weboffice.EditType=edit_type;  //EditType:编辑类型  方式一、方式二  <参考技术文档>                                     //第二位可以为0,1 其中:0不可批注,1可以批注。可以参考iWebOffice2006的EditType属性，详细参考技术白皮书
  form_name.weboffice.ShowType=show_type;          //文档显示方式  1:表示文字批注  2:表示手写批注  0:表示文档核稿
  // form_name.weboffice.WebLoadTemplate();  	 //打开该文档    交互OfficeServer  调出文档OPTION="LOADFILE"    调出模板   OPTION="LOADTEMPLATE"     <参考技术文档>
 }


function   multiplication(obj1,obj2,obj3)
{
	var value1 = obj1.value;
	var value2 = obj2.value;
	if(value1 == null  || value1 == "")
	{
		value1 = 0;
	}
	if(value2 == null || value2=="")
	{
		value2 = 0;
	}
	var sum = parseFloat(value1) * parseInt(value2);
	obj3.value = sum;
}

//东软项目 检查输入的是否是数字，并计算数字
function checkAndSum(obj1,obj2,obj3)
{
	if(!isNum(obj1.value))
	{
		alert("请输入数字");
		obj1.focus();
		return false;
		
	}
	multiplication(obj1,obj2,obj3);
}



//东软项目 检查obj1的数值是否 超过了  obj2的数值
function checkMaxNumber(obj1,obj2)
{
	 var value1 = parseFloat(obj1.value);
	 if(value1 <=0)
	 {
	 	alert("输入数量必须大于0");
	    return false;
	 }
	 var value2 = parseFloat(obj2.value);
	 if(value1 > value2)
	 {
	 	alert("可输入的最大数为: " + value2);
	 	obj1.focus();
	 	obj1.value = value2;
	 	return false;
	}
	return true;
}




//检查默认桌面设置是否输入相同的数字
function checkInputSameNumber(elem)
{
  //得到输入元素的名称和输入值
  var elemName = elem.name;
  var elemValue = elem.value;
  //验证是否已输入数字
  for(var i = 0; i < document.forms[0].elements.length; i++)
  {
    var element = document.forms[0].elements[i];
    if(element.type == "text"  && element.name != elemName)
    {
      var va = element.value;
      if(elemValue == va)
      {
       elem.focus();
        //输入项重复
        alert('您输入了重复的值!');
        return ;
      }
    }
  }
}



function todocedit()
{
  
  var templatefilename = document.forms[0].templateFileName.value;
  var parentid = document.forms[0].parentid.value;
  url = "docedit.jsp?parentid="+parentid+"&amp;templateFileName="+templatefilename+   "&amp;sub=confirm";
  window.open(url,'_blank','status=no,toolbar=no,menubar=no,location=no,top=0,left=0,width=1015,height=768');
}
//催办
function cuiban()
{
var ids=document.getElementById("result").value;
if(ids=="")
{
  alert("请先选择活动，然后再进行催办。");
  return;
}
if(ids.indexOf(",")!=-1)
{
  alert("一次操作只能对一个活动进行催办。");
  return;
}
window.open("page.jsp?ids="+ids+"&amp;templatename=崔办类型选择模板","_blank","toolbar=no,menubar=no,location=center,top=200,left=260,width=495,height=309");
}
/**
 * 判断输入的一组数据是否重复
 */
function isRepeat(r){
	var ele =r.elements;
	for(var i = 0; i < ele.length - 1; i++){
		for(var j = i+1; j < ele.length; j++){
			if(ele[i].value == ele[j].value){
				alert("序号不能重复");
				return true;
			}else if(i == ele.length-2){
				return false;
			}
		}
	}
}
/**
 * 判断两参数是否相同
 */
function isSameness(p1,p2){
	if(p1 == p2){
		return true;
	}
	alert("两次输入的值不一致！");
	return false;
}


/**
 * 检查元素的值的长度是否等于参数
 */
function checklength(f){
	var ele = f.elements;
  var tip = "";
  for(var i = 0; i < ele.length; i++)
  {
    if(ele[i].limitlen != null && ele[i].limitlen > 0 )
    { 
     var len = ele[i].limitlen;
      if(ele[i].value.length != len)
      {
        tip +=  ele[i].cname +"必须为" + len + "位! ";
      }
    }
  }
  
  if(tip!="")
  {
    alert(tip);
    return false;
  }
  else
  {
    return true;
  }
}


/**
*资料归还提交
*/
function datumreturn(datumid)
{
   var id = datumid;
  if(window.confirm("是否归还？"))
  {
    document.forms[0].returnid.value = id;
    document.forms[0].action.value='return';
    document.forms[0].submit();
  }
}
