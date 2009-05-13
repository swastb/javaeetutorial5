// cookies.js
// Javascript 1.2 or later
// Author: Yushin Hozumi (Studio RAIN)
// URL:http://www.studio-rain.biz/


function Cookie( document, name )
{
	this.document = document;
	this.name = name;
}

new Cookie();

Cookie.prototype.set = function( value, expires, path, domain, secure )
{
	this.document.cookie = this.name + "=" + escape( value ) +
    ( ( expires )? "; expires=" + expires.toGMTString() : "" ) +
    ( ( path )? "; path=" + path : "" ) +
    ( ( domain )? "; domain=" + domain : "" ) +
    ( ( secure )? "; secure" : "" );

	return this;
}

Cookie.prototype.get = function()
{
	var theCookies = this.document.cookie.split("; " );
	
	for( var i in theCookies )
	{
		var aCookie = theCookies[i];
		
		if( aCookie.split( "=" )[0] == this.name )
			return unescape( aCookie.split( "=" )[1] )
	}

	return null;
}

Cookie.prototype.remove = function()
{
	if( this.get() )
	{
		var expire = new Date;
		expire.setTime( expire.getTime() - ( 365 * 24 * 60 * 60 * 1000) );
		
		this.document.cookie = this.name + "=" +
//		( ( path )? "; path=" + path : "" ) +
//		( ( domain )? "; domain=" + domain : "" ) +
		"; expires=" + expire.toGMTString();
	}

	return this;
}

Cookie.parse  = function( document )
{
	if( !document || !document.cookie || document.cookie == "" )
		return null;
		
	var theCookieStrings = document.cookie.split("; " );
	var theCookies = new Object();
	
	for( var i in theCookieStrings )
	{
		aCookie = theCookieStrings[i];
		var theName = aCookie.split( "=" )[0];

		if( !theCookies[theName] )
			theCookies[theName] = new Cookie( document, theName );
	}	

	return theCookies;
}
