var _num = 1;
var _fileName = "file";
function _sFileName(s){
	if(s){
		_fileName=s;
	}
}
function additem(id){
	var row,cell,str; 
	row = document.getElementById(id).insertRow();
	if(row != null ){
		cell = row.insertCell();
		str="<input type="+'"'+"file"+'"'+" name=uploadFile["+_num+"]."+_fileName+" onkeydown="+'"'+"event.returnValue=false;"+'"'+" onpaste="+'"'+" return false"+'"'+"><input type="+'"'+"button"+'"'+" value="+'"'+"删除"+'"'+" onclick='deleteitem(this,"+'"'+id+'"'+");' class='button0'>";
		//alert(str);
		cell.innerHTML=str;
	}
	_num++;
}
function deleteitem(obj,id){
	var rowNum,curRow;
	curRow = obj.parentNode.parentNode;
	rowNum = eval("document.all."+id).rows.length - 1;
	eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex); 
}
function deleteFile(obj){
	var tr=document.getElementById("tr"+obj);
	var fileId=document.getElementById("hid"+obj);
	var fileName = document.getElementById("fileName"+obj);
	if(confirm("你确定要删除附件\""+fileName.value+"\"吗？")){
		tr.style.display='none';
		//删除文件
		try{
			_xh = _getXHO();
			if(_xh){
				var url = "docAttach.do?method=delete&id="+fileId.value;
				_xh.open("GET", url, true);
				_xh.onreadystatechange = new function(){};
				_xh.send(null);
			}
		}catch (e){
		}
	}
}
function _getXHO(){
	var _xh = null;
	if (window.ActiveXObject) {
		_xh = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){
		_xh = new XMLHttpRequest();
	}else{
		_xh = new ActiveXObject("Msxml2.XMLHTTP");
	}
	return _xh;
}