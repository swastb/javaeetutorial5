/*
 * jQuery 中文参考文档 脚本
 *
 * Copyright (c) 2008 Shawphy (shawphy.com)
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * $Id: jquery-doc.js 193 2009-01-30 16:05:42Z Shawphy $
 * 
 */

jQuery(function($) {
	$("#sidebar>h2").click(function(){
		$(this).next().toggle().siblings("ul").hide();
		return false;
	});
	$("#sidebar ul ul li h2").click(function(){
		$("#content").empty().css("top",$(document).scrollTop());
		$(this).parent().clone().children()
			.find('.longdesc,.desc:not(:has(.longdesc))').each(function(){
				$(this).html("<p>"
					+ $(this).children("pre").html()
						.replace(/\n\s*\n/g,"</p><p>")
						.replace(/&lt;/g,"<")
						.replace(/&gt;/g,">")
						.replace(/&amp;/g,"&")
						.replace(/'''(.*?)'''/g,"<strong>$1</strong>")
					+"</p>");
			}).end().appendTo("#content");
	});
});