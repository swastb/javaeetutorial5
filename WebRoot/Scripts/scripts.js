
/*written by joelee@51js
*/
    var tmpElement=null;
    var dragElement=null;
    var downX,downY,tmp_o_x,tmp_o_y;
    var refElement=null;
    var dragActive=0;
    var draging=0;
function readyDrag(){
    dragActive=1;
    if(event.srcElement.tagName!="DIV")
        return;
    dragElement=event.srcElement.parentNode;
    tmpElement=dragElement.cloneNode(true);
    tmpElement.style.filter="alpha(opacity=90)";
    tmpElement.style.zIndex=2;
    dragElement.style.zIndex=1;
    tmpElement.style.position="absolute";
    if(dragElement.parentNode.tagName!="BODY"){
        dragElement.style.left=dragElement.offsetLeft+dragElement.parentNode.style.pixelLeft;
        dragElement.style.top=dragElement.offsetTop+dragElement.parentNode.style.pixelTop;
    }
    downX=event.clientX;
    downY=event.clientY;
    tmp_o_x=dragElement.style.pixelLeft;
    tmp_o_y=dragElement.style.pixelTop;
    tmpElement.style.visibility="hidden";
    document.body.appendChild(tmpElement);
    document.onmousemove=startDrag;
    }
    document.onmouseup=endDrag;
function startDrag(){
    if(dragActive==1&&event.button==1&&dragElement!=null&&tmpElement!=null){
        tmpElement.style.visibility="visible";
        tmpElement.style.left=tmp_o_x+event.clientX-downX;
        tmpElement.style.top=tmp_o_y+event.clientY-downY;
        dragElement.style.backgroundColor="#CCCCCC";
        document.body.style.cursor="move";
        draging=1;
    }
}
function endDrag(){
    if(dragActive==1&&tmpElement!=null){
        if(draging==1){
            dragElement.removeNode(true);
            draging=0;
        }
        tmpElement.style.filter="alpha(opacity=100)";
        tmpElement.style.zIndex=1;
        document.body.style.cursor="default";
        if(refElement!=null&&refElement.parentNode!=null&&refElement.parentNode.tagName!="BODY"){
            tmpElement.style.width=refElement.parentNode.style.width;
            tmpElement.style.position="";
            refElement.parentNode.insertBefore(tmpElement,refElement);
        }
    }
    dragElement=null;
    tmpElement=null;
    dragActive=0;
}
function readyInsert(){
    if(dragActive==1){
        var element=event.srcElement;
        if(element==dragElement)return;
        if(element.tagName!="DIV")
            return;
        if(element.className=="dragBar"||element.className=="textSheet"||element.className=="blankBar")
            element=element.parentNode;
        element.style.backgroundColor="#CCCCCC";
        element.style.filter="alpha(opacity=50)";
        refElement=element;
    }
}
function failInsert(){
    var element=event.srcElement;
    if(element.tagName!="DIV")
        return;
    try{
        if(element.className=="dragBar"||element.className=="textSheet"||element.className=="blankBar")
            element=element.parentNode;
    }catch(e){}
    element.style.filter="alpha(opacity=100)";
    element.style.backgroundColor="#FFFFFF";
    refElement=null;
}
document.onselectstart=function(){return false}