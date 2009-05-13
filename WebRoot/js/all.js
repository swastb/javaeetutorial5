var _postXmlHttpProcessPostChangeCallBack;
var _xmlHttpRequestObj;
function postXmlHttp( submitUrl, callbackFunc )
{
  _postXmlHttpProcessPostChangeCallBack = callbackFunc;
  if(window.createRequest)
  {
    try{
      _xmlHttpRequestObj=window.createRequest();
      _xmlHttpRequestObj.open('POST',submitUrl,true);
      _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
      _xmlHttpRequestObj.send();
    }
    catch(ee){}
  }
  else if(window.XMLHttpRequest)
  {
    _xmlHttpRequestObj=new XMLHttpRequest();
    _xmlHttpRequestObj.overrideMimeType('text/xml');
    _xmlHttpRequestObj.open('POST',submitUrl,true);
    _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
    _xmlHttpRequestObj.send("");
  }
  else if(window.ActiveXObject)
  {
    _xmlHttpRequestObj=new ActiveXObject("Microsoft.XMLHTTP");
    _xmlHttpRequestObj.open('POST',submitUrl,true);
    _xmlHttpRequestObj.onreadystatechange=postXmlHttpProcessPostChange;
    _xmlHttpRequestObj.send();
  }
};

function postXmlHttpProcessPostChange( )
{
  if( _xmlHttpRequestObj.readyState==4 && _xmlHttpRequestObj.status==200 )
  {
    setTimeout( _postXmlHttpProcessPostChangeCallBack, 2 );
  }
}
function loginCheck()
{
   var username = document.login.userName.value;
   var password = document.login.passWord.value;
   var submitURL="login?userName="+username+"&passWord="+password;
   postXmlHttp( submitURL, 'showMessage()' );
}
function showMessage()
{
  var err = document.getElementById("errMsg");
  if ( err != null )
  {  
     err.innerHTML = _xmlHttpRequestObj.responseText;
     err.style.display="block";
  }
}

function closePortlet(portlet_id,side)
{
   var submitURL="homepage?action=close&id="+portlet_id+"&side="+side;
   postXmlHttp( submitURL, 'closePortCalback("'+portlet_id+'","'+side+'")' );
}
function closePortCalback(portlet_id,side)
{
   var elem = document.getElementById("portlet_all_"+portlet_id+"_"+side);
   if (elem!=null)
     elem.parentNode.removeChild(elem);
}
function Toggle(item) {
   var max=item+"_max";
   var min=item+"_min";
   objMax=document.getElementById(max);
   objMin=document.getElementById(min);
   obj=document.getElementById(item);

   visible=(obj.style.display!="none")  
   if (visible) {
     obj.style.display="none";
     if ( objMax != null ) objMax.style.display="block";
     if ( objMin != null ) objMin.style.display="none";
   } else {
     obj.style.display="block";
     if ( objMax != null ) objMax.style.display="none";
     if ( objMin != null ) objMin.style.display="block";
   }
}
function submitData( submitURL )
{
   var  subURL = "homepage?action=change&"+submitURL;
   postXmlHttp( subURL,'');
}