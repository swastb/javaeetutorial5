    var draged=false;
    tdiv=null;
function dragStart(){
    ao=event.srcElement;//�1�7�0�1�1�7�1�7�0�4�1�7�0�6
    if((ao.tagName=="TD")||(ao.tagName=="TR"))ao=ao.offsetParent;//�1�7ж�1�7�0�2�1�7�1�7�1�7�1�7�1�7�1�7�1�7ж�1�7�0�6�1�7�1�3�1�7�1�7�1�7�1�7�1�6�1�7�1�7�1�7ao
    else return;
    draged=true;
    tdiv=document.createElement("div");//�1�7�1�7�1�7�1�7�1�7�1�7tdiv
    tdiv.innerHTML=ao.outerHTML;//�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�2�1�7�1�7�1�7ж�1�7�0�6�1�7�1�3�1�7�1�7�1�7�1�7�1�7
    tdiv.style.display="block";//�1�7�1�7�1�7�1�7tdiv�1�7�0�0�1�7�1�7�1�7�1�7�1�7
    tdiv.style.position="absolute";
    tdiv.style.filter="alpha(opacity=70)";
    tdiv.style.cursor="move";
    tdiv.style.width=ao.offsetWidth;
    tdiv.style.height=ao.offsetHeight;
    tdiv.style.top=getInfo(ao).top;
    tdiv.style.left=getInfo(ao).left;
    document.body.appendChild(tdiv);//�1�7�1�7�0�7�1�7�1�7�1�7�1�7�1�7tdiv
    lastX=event.clientX;//�1�7�0�1�1�7�1�7�1�7�1�7�1�7�1�7�1�7x,y�1�7�1�7�1�7
    lastY=event.clientY;
	//topp.value=tdiv.style.top;
	//left.value=tdiv.style.left;
    lastLeft=tdiv.style.left;//�1�7�0�1�1�7�1�7�0�4�1�7�0�6�1�7�1�7�1�7�1�7�1�7�0�1�1�7�1�7�1�7�1�7,�1�7�1�7λ�0�2px,�1�7�1�7�1�7�1�7�0�8�1�7�1�7parseInt()�1�7�1�7�1�7�1�74�0�8�1�7�1�7�0�2�1�7�1�7�1�7�1�7
							 //�1�7�1�7�1�7�1�7parseInt(numString),�1�7�1�7�1�7�1�7�1�7�1�7�1�7�1�9�1�7�1�7�1�7�1�7�1�7 numString �1�7е�1�7�1�7�1�7�1�7�1�7�0�5�1�7�1�7�0�0�1�7�1�7�1�7�1�7�1�7,�1�7�0�7�1�7�0�8�1�7�1�7�0�2�1�7�1�7�1�7�1�7:�1�7�1�7parseInt("12abc")=12
    lastTop=tdiv.style.top;
    try{
        ao.dragDrop();    
    }catch(e){}
}
function draging(){//�1�7�1�7�0�8:�1�7ж�1�7MOUSE�1�7�1�7λ�1�7�0�0�1�7�0�0�1�7�1�7�1�7�1�7�1�7�1�7�0�6�1�7�0�2�1�7�1�7�1�7�1�7�1�7
    if(!draged)return;
    var tX=event.clientX;//�1�7�0�1�1�7�1�7�1�7�7�4�0�2�1�7�1�7x,y�1�7�1�7�1�7
    var tY=event.clientY;
	//alert(lastLeft+","+lastY);
	//x.value=tX;
	//y.value=tY;
    tdiv.style.left=parseInt(lastLeft)+tX-lastX;//�1�7�1�7�1�7�1�7tdiv�1�7�0�8�1�7�1�7�1�7�1�7�0�1�1�7�1�7�1�7�1�7
    tdiv.style.top=parseInt(lastTop)+tY-lastY;
    for(var i=0;i<parentTable.cells.length;i++){
        var parentCell=getInfo(parentTable.cells[i]);
        if(tX>=parentCell.left&&tX<=parentCell.right&&tY>=parentCell.top&&tY<=parentCell.bottom){
            var subTables=parentTable.cells[i].getElementsByTagName("table");
            if(subTables.length==0){
                if(tX>=parentCell.left&&tX<=parentCell.right&&tY>=parentCell.top&&tY<=parentCell.bottom){
                    parentTable.cells[i].appendChild(ao);
                }
                break;
            }
            for(var j=0;j<subTables.length;j++){
                var subTable=getInfo(subTables[j]);
                if(tX>=subTable.left&&tX<=subTable.right&&tY>=subTable.top&&tY<=subTable.bottom){
                    parentTable.cells[i].insertBefore(ao,subTables[j]);
                    break;
                }else{
                	parentTable.cells[i].appendChild(ao);
                }    
            }
        }
    }
}

function dragEnd(){
    if(!draged)return;
    draged=false;
    mm=ff(150,15);
    change();
}
function getInfo(o){//�0�0�1�7�1�7�1�7�1�7�1�7,�0�0�1�7�1�7�1�7�1�7�1�7�0�5�1�7�1�7�1�7�0�2�1�7�1�7�1�7�1�7�1�7
    var to=new Object();
    to.left=to.right=to.top=to.bottom=0;
    var twidth=o.offsetWidth;
    var theight=o.offsetHeight;
    while(o!=document.body){
        to.left+=o.offsetLeft;
        to.top+=o.offsetTop;
        o=o.offsetParent;
    }
        to.right=to.left+twidth;
        to.bottom=to.top+theight;
    return to;
}
function ff(aa,ab){    //�1�7�1�7GOOGLE�1�7�1�7�0�04,�1�7�1�7�1�7�1�7�0�8�1�7λ�1�7�1�7
    var ac=parseInt(getInfo(tdiv).left);
    var ad=parseInt(getInfo(tdiv).top);
    var ae=(ac-getInfo(ao).left)/ab;
    var af=(ad-getInfo(ao).top)/ab;
    return setInterval(function()
				{
					if(ab<1){
                            clearInterval(mm);
                            tdiv.removeNode(true);
                            ao=null;
                            return
                    	    }
                    ab--;
                    ac-=ae;
                    ad-=af;
                    tdiv.style.left=parseInt(ac)+"px";
                    tdiv.style.top=parseInt(ad)+"px"
                }
,aa/ab)
}
function inint(){//�1�7�1�7�0�3�1�7�1�7
    for(var i=0;i<parentTable.cells.length;i++){//�0�7�1�7�1�7�1�7�1�7�1�7�0�0�1�7�1�7�1�7table�0�6�1�7�1�0�0�5�1�7�1�7�1�7
        var subTables=parentTable.cells[i].getElementsByTagName("table");
        for(var j=0;j<subTables.length;j++){
            if(subTables[j].className!="dragTable")break;//�1�7�1�7�1�7�1�7�1�7б�1�7�1�7�1�7�1�7�1�7�0�2dragtable�1�7�0�4�1�7�1�7�1�7�1�7з�1�7�1�7�1�7
            subTables[j].rows[0].className="dragTR";//�1�7�0�0�0�9�1�7�1�7�1�7и�1�7�1�7�1�7�1�7�1�7�1�7�1�7�0�6�1�7�1�3�1�7�1�7�1�7�1�7�1�7�0�2dragTR
            subTables[j].rows[0].attachEvent("onmousedown",dragStart);//�1�7�1�7�1�7�1�7�7�7�1�7�1�7�0�2�0�4�1�7�1�7dragStart�1�7�1�7�1�7�1�7
            subTables[j].attachEvent("ondrag",draging);//
            subTables[j].attachEvent("ondragend",dragEnd);
        }
    }
}
inint();
