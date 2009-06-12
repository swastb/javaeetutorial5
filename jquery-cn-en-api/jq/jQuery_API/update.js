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