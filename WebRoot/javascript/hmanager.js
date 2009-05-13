var root_path="..";


//***********************************************************************************************************************

function httpGet(sUrl)
{
var sErrXML="<?xml version=\"1.0\" encoding=\"GBK\" ?><xml><msg>link error</msg><data></data></xml>";
var activex=getXmlHttp();
var oXML;
try
{
activex.Open("GET",sUrl,false);
activex.send();
oXML=activex.responseXML.documentElement;
if(oXML==null || !oXML.childNodes.length){throw "";}
}
catch(e)
{
activex=getXmlDocument();
activex.loadXML(sErrXML);
oXML=activex.documentElement;
}
return oXML;
}

function getXmlHttp()
{
var activex;
try
{
activex=new ActiveXObject("Microsoft.XMLHTTP");
activex.abort();
}
catch(e)
{
activex=new ActiveXObject("Msxml2.XMLHTTP");
}
return activex;
}

function getXmlDocument()
{
var activex=new ActiveXObject("Microsoft.XMLDOM");
if (activex==null || activex.documentElement==null || activex.documentElement.childNodes==null)
  {
   activex=new ActiveXObject("Msxml2.DOMDocument");
   //activex=new ActiveXObject("Msxml2.DOMDocument.3.0");
  }
return activex;
}
