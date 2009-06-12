function copyright(){
	
document.writeln("	<a href=\"http:\/\/www.jQuery.com\/\" title=\"jQuery官网\" target=\"_blank\" class=\"topnav\">jQuery官网<\/a>");
document.writeln("	<span class=\"topnav\">|<\/span>");
document.writeln("	<a href=\"http:\/\/jquery.org.cn\/\" title=\"jQuery中文网站\" target=\"_blank\" class=\"topnav\">jQuery中文网站<\/a>");
document.writeln("	<span class=\"topnav\">|<\/span>");
document.writeln("	<a href=\"http:\/\/www.cn-cuckoo.com\/\" title=\"1.1版译者\" target=\"_blank\" class=\"topnav\">为之漫笔<\/a>");
document.writeln("	<span class=\"topnav\">|<\/span>");
document.writeln("	<a href=\"http:\/\/shawphy.com\/\" title=\"1.2版翻译整理者\" target=\"_blank\" class=\"topnav\">Shawphy<\/a>");
document.writeln("    <span class=\"topnav\">|<\/span>");
document.writeln("	<a href=\"http:\/\/www.51toria.cn\" title=\"CHM文档制作者:一揪\" target=\"_blank\" class=\"topnav\">CHM文档制作者<\/a> ");
document.writeln("	<span class=\"topnav\">|<\/span>");
document.writeln("	<a href=\"http:\/\/dl.getdropbox.com/u/81097/jQueryAPI_CHM.CHM\" title=\"\" target=\"_blank\" class=\"topnav\">CHM最新版本下载<\/a> ");
	
	}
	
function updataTime(){
	
document.writeln("* :selected细微调整");
document.writeln("- :selected中重复示例代码");
document.writeln("+ jQuery.ajax中增加dataFilter参数");
document.writeln("");
document.writeln("2008-06-21 04:16:54 +0800");
document.writeln("* pretend的第一个示例结果错误");
document.writeln("");
document.writeln("2008-06-19 19:52:29 +0800");
document.writeln("* insertBefore 和 insertAfter 示例说明翻译错误。");
document.writeln("+ 事件>load 增加注释");
document.writeln("");
document.writeln("2008-06-18 00:05:15 +0800");
document.writeln("+ $.ajax中新增3个参数，jsonp,password,scriptCharset");
document.writeln("");
document.writeln("2008-06-17 19:43:30 +0800");
document.writeln("* 核心>数据缓存> 第三部分应该 \"removeDate(name)\"");
document.writeln("* 修改date(name)里的代码注释一个小错误");
document.writeln("");
document.writeln("2008-06-11 19:26:37 +0800");
document.writeln("* toggle保持与官网同步");
document.writeln("");
document.writeln("2008-05-29 16:36:07 +0800");
document.writeln("+ 核心 部分 数据缓存");
document.writeln("+ 工具inArray函数");
document.writeln("* noConflict注释");
document.writeln("");
document.writeln("2008-05-27 22:48:24 +0800");
document.writeln("+ 更新ajax部分的内容，与官网保持一致");
document.writeln("");
document.writeln("2008-05-27 20:39:03 +0800");
document.writeln("* 对scroll的示例代码错误的修正");
document.writeln("* 由$(document).scroll();到$(window).scroll();");
document.writeln("");
document.writeln("");
document.writeln("2008-04-22 21:35:44 +0800");
document.writeln("* 修改一下小index示例");
document.writeln("");
document.writeln("2008-04-19 13:14:10 +0800");
document.writeln("");
document.writeln("* 修正agp001提出的siblings的示例代码错误");
document.writeln("* 翻译$.get中漏翻的一句");
document.writeln("- 删除$.post的空示例");
document.writeln("");
document.writeln("2008-03-29 13:14:02 +0800");
document.writeln("全文替换1.1遗留下的@符号");
document.writeln("");
document.writeln("jQuery(callback)		未翻译的翻译一下");
document.writeln("slice(start,[end])		未翻译的翻译一下");
document.writeln("parent(expr)			例子中删除个body");
document.writeln("append(content)			C要");
document.writeln("css(name)			删除多余的<hr \/>");
document.writeln("unbind([type],[data])		代码注释翻译");
document.writeln("change(fn)			未翻译的翻译一下");
document.writeln("click(fn)			常用的事件->几个事件的顺序");
document.writeln("dblclick(fn)			未翻译的翻译一下");
document.writeln("focus()				未翻译的翻译一下");
document.writeln("scroll(fn			修正");
document.writeln("submit(fn)			select->submit");
document.writeln("toggle()			删除多余的<hr \/>");
document.writeln("stop()				代码注释翻译");
	
	}
	
function checkVersion(num){
	var newNum = 900205;
	var z=/^\d{6}$/;
	if(z.test(num)){
		if(num == newNum){
			alert("你已经是最新版本了！");
		}else if(num > newNum){
			alert("怎么可能，我们还没出你这个版本，请仔细查看当前文档的版本号！");
		}else{
			if(confirm("现在最新版本号是" + newNum + "现在就下载?")){window.location.href="https://dl.getdropbox.com/u/81097/jQueryAPI_CHM.CHM"} 
		}
	}else{
		alert("请输入正确的版本号");
	}
}
if(confirm("现在最新版本号是900205现在就下载?")){window.location.href="https://dl.getdropbox.com/u/81097/jQueryAPI_CHM.CHM"} 