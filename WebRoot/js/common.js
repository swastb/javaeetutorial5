
function setFocus(focusName)
{
	var obj = document.getElementById(focusName);
	obj.focus();
}

function notNull()
{ 
	if(event.keyCode==32)
	{
		event.returnValue=false; 
	}
}

function getLen(str) 
{ 
	var len=0; 
	if (str != null && str.length>0) {
		for (var i=0;i<str.length;i++) { 
			char = str.charCodeAt(i); 
			if(!(char>255)) { 
 	 			len = len + 1; 
    		} else { 
 	    		len = len + 2; 
			} 
		} 
	}
	return len;
}
