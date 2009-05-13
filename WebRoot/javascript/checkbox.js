
function setCheckbox(trc){
	var checkBox = trc.parentNode.childNodes[0].childNodes[0];
	if (checkBox.checked){
		checkBox.checked = false;
	}else{
		checkBox.checked = true;
	}
	setID(checkBox);
}

function setID(p){
	var oldColor=p.style.backgroundColor;
	getTopNode(p).style.backgroundColor=p.checked?"#C0D1E4":oldColor;
}

function getTopNode(pNode){
	if(pNode.tagName=="TR"){
		return pNode;
	}else{
		return getTopNode(pNode.parentNode);
	}
}

function checkAll(){
	var length = document.list.elements.length;
	var tocheck = document.list.allbox.checked;
	for (var i=0; i<length; i++){ 
		if (document.list.elements[i].name.indexOf("sid") != -1){ 
			document.list.elements[i].checked = tocheck; 
			setID(document.list.elements[i]);			
		}
	}
}

