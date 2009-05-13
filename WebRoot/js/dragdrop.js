/* Copyright (c) 2006 Yahoo! Inc. All rights reserved. */
YAHOO.util.DragDrop=function(id,_2)
{
	if(id){
		this.init(id,_2);
	}
};

YAHOO.util.DragDrop.prototype={
	id:null,
	dragElId:null,
	handleElId:null,
	invalidHandleTypes:null,
	startPageX:0,
	startPageY:0,
	groups:null,
	locked:false,
	lock:function(){
		this.locked=true;
	},
	unlock:function(){
		this.locked=false;
	},
	isTarget:true,
	padding:null,
	_domRef:null,
	__ygDragDrop:true,
	constrainX:false,
	constrainY:false,
	minX:0,
	maxX:0,
	minY:0,
	maxY:0,
	maintainOffset:false,
	xTicks:null,
	yTicks:null,
	primaryButtonOnly:true,
	b4StartDrag:function(x,y){},
	startDrag:function(x,y){},
	b4Drag:function(e){},
	onDrag:function(e){},
	onDragEnter:function(e,id){},
	b4DragOver:function(e){},
	onDragOver:function(e,id){},
	b4DragOut:function(e){},
	onDragOut:function(e,id){},
	b4DragDrop:function(e){},
	onDragDrop:function(e,id){},
	b4EndDrag:function(e){},
	endDrag:function(e){},
	b4MouseDown:function(e){},
	onMouseDown:function(e){},
	onMouseUp:function(e){},
	getEl:function(){
		if(!this._domRef){
			this._domRef=this.DDM.getElement(this.id);
		}
		return this._domRef;
	},
	getDragEl:function(){
		return this.DDM.getElement(this.dragElId);
	},
	init:function(id,_6){
		this.initTarget(id,_6);
		YAHOO.util.Event.addListener(id,"mousedown",this.handleMouseDown,this,true);
	},
	initTarget:function(id,_7){
		this.DDM=YAHOO.util.DDM;
		this.padding=[0,0,0,0];
		this.groups={};
		this.id=id;
		this.setDragElId(id);
		this.invalidHandleTypes={a:"a"};
		this.handleElId=id;
		if(document&&document.body){
			this.setInitPosition();
		}this.addToGroup((_7)?_7:"default");
	},
	setPadding:function(_8,_9,_10,_11){
		if(!_9&&0!==_9){
			this.padding=[_8,_8,_8,_8];
		}else{
			if(!_10&&0!==_10){
				this.padding=[_8,_9,_8,_9];
			}else{
				this.padding=[_8,_9,_10,_11];
			}
		}
	},
	setInitPosition:function(_12,_13){
		var el=this.getEl();
		if(!this.DDM.verifyEl(el)){
			return;
		}
		var dx=_12||0;
		var dy=_13||0;
		var p=YAHOO.util.Dom.getXY(el);
		this.initPageX=p[0]-dx;
		this.initPageY=p[1]-dy;
		this.lastPageX=p[0];
		this.lastPageY=p[1];
		this.setStartPosition(p);
	},
	setStartPosition:function(pos){
		var p=pos||YAHOO.util.Dom.getXY(this.getEl());
		this.startPageX=p[0];
		this.startPageY=p[1];
	},
	addToGroup:function(_19){
		this.groups[_19]=true;
		this.DDM.regDragDrop(this,_19);
	},
	setDragElId:function(id){
		this.dragElId=id;
	},
	setHandleElId:function(id){
		this.handleElId=id;
		this.DDM.regHandle(this.id,id);
	},
	setOuterHandleElId:function(id){
		YAHOO.util.Event.addListener(id,"mousedown",this.handleMouseDown,this,true);
		this.setHandleElId(id);
	},
	unreg:function(){
		YAHOO.util.Event.removeListener(this.id,"mousedown",this.handleMouseDown);
		this._domRef=null;this.DDM._remove(this);
	},
	isLocked:function(){
		return (this.DDM.isLocked()||this.locked);
	},
	handleMouseDown:function(e,oDD){
		var EU=YAHOO.util.Event;
		var _22=e.which||e.button;
		if(this.primaryButtonOnly&&_22>1){
			return;
		}
		if(this.isLocked()){
			return;
		}
		this.DDM.refreshCache(this.groups);
		var pt=new YAHOO.util.Point(EU.getPageX(e),EU.getPageY(e));
		if(this.DDM.isOverTarget(pt,this)){
			var _24=EU.getTarget(e);
			if(this.isValidHandleChild(_24)&&(this.id==this.handleElId||this.DDM.handleWasClicked(_24,this.id))){
				this.setStartPosition();
				this.b4MouseDown(e);
				this.onMouseDown(e);
				this.DDM.handleMouseDown(e,this);
				this.DDM.stopEvent(e);
			}
		}
	},
	addInvalidHandleType:function(_25){
		var _26=_25.toUpperCase();
		this.invalidHandleTypes[_26]=_26;
	},
	removeInvalidHandleType:function(_27){
		var _28=_27.toUpperCase();
		this.invalidHandleTypes[_28]=null;
	},
	isValidHandleChild:function(_29){
		var _30=_29.nodeName;
		if(_30=="#text"){
			_30=_29.parentNode.nodeName;
		}
		return (!this.invalidHandleTypes[_30]);
	},
	setXTicks:function(_31,_32){
		this.xTicks=[];
		this.xTickSize=_32;
		var _33={};
		for(var i=this.initPageX;i>=this.minX;i=i-_32){
			if(!_33[i]){
				this.xTicks[this.xTicks.length]=i;_33[i]=true;
			}
		}
		for(i=this.initPageX;i<=this.maxX;i=i+_32){
			if(!_33[i]){
				this.xTicks[this.xTicks.length]=i;_33[i]=true;
			}
		}
		this.xTicks.sort(this.DDM.numericSort);
	},
	setYTicks:function(_35,_36){
		this.yTicks=[];
		this.yTickSize=_36;
		var _37={};
		for(var i=this.initPageY;i>=this.minY;i=i-_36){
			if(!_37[i]){
				this.yTicks[this.yTicks.length]=i;
				_37[i]=true;
			}
		}
		for(i=this.initPageY;i<=this.maxY;i=i+_36){
			if(!_37[i]){
				this.yTicks[this.yTicks.length]=i;_37[i]=true;
			}
		}
		this.yTicks.sort(this.DDM.numericSort);
	},
	setXConstraint:function(_38,_39,_40){
		this.leftConstraint=_38;
		this.rightConstraint=_39;
		this.minX=this.initPageX-_38;
		this.maxX=this.initPageX+_39;
		if(_40){
			this.setXTicks(this.initPageX,_40);
		}
		this.constrainX=true;
	},
	setYConstraint:function(iUp,_42,_43){
		this.topConstraint=iUp;
		this.bottomConstraint=_42;
		this.minY=this.initPageY-iUp;
		this.maxY=this.initPageY+_42;
		if(_43){
			this.setYTicks(this.initPageY,_43);
		}
		this.constrainY=true;
	},
	resetConstraints:function(){
		var dx=(this.maintainOffset)?this.lastPageX-this.initPageX:0;
		var dy=(this.maintainOffset)?this.lastPageY-this.initPageY:0;
		this.setInitPosition(dx,dy);
		if(this.constrainX){
			this.setXConstraint(this.leftConstraint,this.rightConstraint,this.xTickSize);
		}
		if(this.constrainY){
			this.setYConstraint(this.topConstraint,this.bottomConstraint,this.yTickSize);
		}
	},
	getTick:function(val,_45){
		if(!_45){
			return val;
		}else{
			if(_45[0]>=val){
				return _45[0];
			}else{
				for(var i=0;i<_45.length;++i){
					var _46=i+1;
					if(_45[_46]&&_45[_46]>=val){
						var _47=val-_45[i];
						var _48=_45[_46]-val;
						return (_48>_47)?_45[i]:_45[_46];
					}
				}
				return _45[_45.length-1];
			}
		}
	},
	toString:function(val,_49){
		return ("YAHOO.util.DragDrop {"+this.id+"}");
	}
};
if(!YAHOO.util.DragDropMgr){
	YAHOO.util.DragDropMgr=new function(){
		var _50=YAHOO.util;
		this.ids={};
		this.handleIds={};
		this.dragCurrent=null;
		this.dragOvers={};
		this.deltaX=0;
		this.deltaY=0;
		this.preventDefault=true;
		this.stopPropagation=true;
		this.initalized=false;
		this.locked=false;
		this.init=function(){};
		this.POINT=0;
		this.INTERSECT=1;
		this.mode=this.POINT;
		this._execOnAll=function(_51,_52){
			for(var i in this.ids){
				for(var j in this.ids[i]){
					var oDD=this.ids[i][j];
					if(!this.isTypeOfDD(oDD)){
						continue;}oDD[_51].apply(oDD,_52);
					}
				}
			};
			this._onLoad=function(){
				this._execOnAll("setInitPosition",[]);
				var EU=_50.Event;
				EU.addListener(document,"mouseup",this.handleMouseUp,this,true);
				EU.addListener(document,"mousemove",this.handleMouseMove,this,true);
				EU.addListener(window,"unload",this._onUnload,this,true);
				EU.addListener(window,"resize",this._onResize,this,true);
				this.initalized=true;
			};
			this._onResize=function(e){
				this._execOnAll("resetConstraints",[]);
			};
			this.lock=function(){
				this.locked=true;
			};
			this.unlock=function(){
				this.locked=false;
			};
			this.isLocked=function(){
				return this.locked;
			};
			this.locationCache={};
			this.useCache=true;
			this.clickPixelThresh=3;
			this.clickTimeThresh=1000;
			this.dragThreshMet=false;
			this.clickTimeout=null;
			this.startX=0;
			this.startY=0;
			this.regDragDrop=function(oDD,_54){
				if(!this.initialized){this.init();
			}
			if(!this.ids[_54]){
				this.ids[_54]={};
			}
			this.ids[_54][oDD.id]=oDD;
		};
		this._remove=function(oDD){
			for(var g in oDD.groups){
				if(g&&this.ids[g][oDD.id]){
					delete this.ids[g][oDD.id];
				}
			}
			delete this.handleIds[oDD.id];
		};
		this.regHandle=function(_56,_57){
			if(!this.handleIds[_56]){
				this.handleIds[_56]={};
			}
			this.handleIds[_56][_57]=_57;
		};
		this.isDragDrop=function(id){
			return (this.getDDById(id))?true:false;
		};
		this.getRelated=function(_58,_59){
			var _60=[];
			for(var i in _58.groups){
				for(j in this.ids[i]){
					var dd=this.ids[i][j];
					if(!this.isTypeOfDD(dd)){
						continue;
					}
					if(!_59||dd.isTarget){
						_60[_60.length]=dd;
					}
				}
			}
			return _60;
		};
		this.isLegalTarget=function(oDD,_62){
			var _63=this.getRelated(oDD);
			for(var i=0;i<_63.length;++i){
				if(_63[i].id==_62.id){
					return true;
				}
			}
			return false;
		};
		this.isTypeOfDD=function(oDD){
			return (oDD&&oDD.__ygDragDrop);
		};
		this.isHandle=function(_64,_65){
			return (this.handleIds[_64]&&this.handleIds[_64][_65]);
		};
		this.getDDById=function(id){
			for(var i in this.ids){
				if(this.ids[i][id]){
					return this.ids[i][id];
				}
			}
			return null;
		};
		this.handleMouseDown=function(e,oDD){
			this.dragCurrent=oDD;
			var el=oDD.getEl();
			this.startX=_50.Event.getPageX(e);
			this.startY=_50.Event.getPageY(e);
			this.deltaX=this.startX-el.offsetLeft;
			this.deltaY=this.startY-el.offsetTop;
			this.dragThreshMet=false;
			this.clickTimeout=setTimeout("var DDM=YAHOO.util.DDM;DDM.startDrag(DDM.startX, DDM.startY)",this.clickTimeThresh);
		};
		this.startDrag=function(x,y){
			clearTimeout(this.clickTimeout);
			if(this.dragCurrent){
				this.dragCurrent.b4StartDrag(x,y);
				this.dragCurrent.startDrag(x,y);
			}
			this.dragThreshMet=true;
		};
		this.handleMouseUp=function(e){
			if(!this.dragCurrent){
				return;
			}
			clearTimeout(this.clickTimeout);
			if(this.dragThreshMet){
				this.fireEvents(e,true);
			}else{}
			this.stopDrag(e);
			this.stopEvent(e);
		};
		this.stopEvent=function(e){
			if(this.stopPropagation){
				_50.Event.stopPropagation(e);
			}
			if(this.preventDefault){
				_50.Event.preventDefault(e);
			}
		};
		this.stopDrag=function(e){
			if(this.dragCurrent){
				if(this.dragThreshMet){
					this.dragCurrent.b4EndDrag(e);
					this.dragCurrent.endDrag(e);
				}
				this.dragCurrent.onMouseUp(e);
			}
			this.dragCurrent=null;
			this.dragOvers={};
		};
		this.handleMouseMove=function(e){
			if(!this.dragCurrent){
				return;
			}
			if(_50.Event.isIE&&!e.button){
				this.stopEvent(e);
				return this.handleMouseUp(e);
			}
			if(!this.dragThreshMet){
				var _66=Math.abs(this.startX-_50.Event.getPageX(e));
				var _67=Math.abs(this.startY-_50.Event.getPageY(e));
				if(_66>this.clickPixelThresh||_67>this.clickPixelThresh){
					this.startDrag(this.startX,this.startY);
				}
			}
			if(this.dragThreshMet){
				this.dragCurrent.b4Drag(e);
				this.dragCurrent.onDrag(e);
				this.fireEvents(e,false);
			}
			this.stopEvent(e);
		};
		this.fireEvents=function(e,_68){
			var dc=this.dragCurrent;
			if(!dc||dc.isLocked()){
				return;
			}
			var x=_50.Event.getPageX(e);
			var y=_50.Event.getPageY(e);
			var pt=new YAHOO.util.Point(x,y);
			var _70=[];
			var _71=[];
			var _72=[];
			var _73=[];
			var _74=[];
			for(var i in this.dragOvers){
				var ddo=this.dragOvers[i];
				if(!this.isTypeOfDD(ddo)){
					continue;
				}
				if(!this.isOverTarget(pt,ddo,this.mode)){
					_71.push(ddo);
				}
				_70[i]=true;
				delete this.dragOvers[i];
			}
			for(var _76 in dc.groups){
				if("string"!=typeof _76){
					continue;
				}
				for(i in this.ids[_76]){
					var oDD=this.ids[_76][i];
					if(!this.isTypeOfDD(oDD)){
						continue;
					}
					if(oDD.isTarget&&!oDD.isLocked()&&oDD!=dc){
						if(this.isOverTarget(pt,oDD,this.mode)){
							if(_68){
								_73.push(oDD);
							}else{
								if(!_70[oDD.id]){
									_74.push(oDD);
								}else{
									_72.push(oDD);
								}
								this.dragOvers[oDD.id]=oDD;
							}
						}
					}
				}
			}
			if(this.mode){
				if(_71.length>0){
					dc.b4DragOut(e,_71);
					dc.onDragOut(e,_71);
				}
				if(_74.length>0){
					dc.onDragEnter(e,_74);
				}
				if(_72.length>0){
					dc.b4DragOver(e,_72);
					dc.onDragOver(e,_72);
				}
				if(_73.length>0){
					dc.b4DragDrop(e,_73);
					dc.onDragDrop(e,_73);
				}
			}else{
				for(i=0;i<_71.length;++i){
					dc.b4DragOut(e,_71[i].id);
					dc.onDragOut(e,_71[i].id);
				}
				for(i=0;i<_74.length;++i){
					dc.onDragEnter(e,_74[i].id);
				}
				for(i=0;i<_72.length;++i){
					dc.b4DragOver(e,_72[i].id);
					dc.onDragOver(e,_72[i].id);
				}
				for(i=0;i<_73.length;++i){
					dc.b4DragDrop(e,_73[i].id);
					dc.onDragDrop(e,_73[i].id);
				}
			}
		};
		this.getBestMatch=function(dds){
			var _78=null;
			if(dds.length==1){
				_78=dds[0];
			}else{
				for(var i=0;i<dds.length;++i){
					var dd=dds[i];
					if(dd.cursorIsOver){
						_78=dd;
						break;
					}else{
						if(!_78||_78.overlap.getArea()<dd.overlap.getArea()){
							_78=dd;
						}
					}
				}
			}
			return _78;
		};
		this.refreshCache=function(_79){
			for(sGroup in _79){
				if("string"!=typeof sGroup){
					continue;
				}
				for(i in this.ids[sGroup]){
					var oDD=this.ids[sGroup][i];
					if(this.isTypeOfDD(oDD)){
						var loc=this.getLocation(oDD);
						if(loc){
							this.locationCache[oDD.id]=loc;
						}else{
							delete this.locationCache[oDD.id];
							oDD.unreg();
						}
					}
				}
			}
		};
		this.verifyEl=function(el){
			try{
				if(el){
					var _81=el.offsetParent;
					if(_81){
						return true;
					}
				}
			}catch(e){}
			return false;
		};
		this.getLocation=function(oDD){
			if(!this.isTypeOfDD(oDD)){
				return null;
			}
			var el=oDD.getEl();
			if(!this.verifyEl(el)){
				return null;
			}
			var _82=YAHOO.util.Dom.getXY(el);
			x1=_82[0];
			x2=x1+el.offsetWidth;
			y1=_82[1];
			y2=y1+el.offsetHeight;
			var t=y1-oDD.padding[0];
			var r=x2+oDD.padding[1];
			var b=y2+oDD.padding[2];
			var l=x1-oDD.padding[3];
			return new YAHOO.util.Region(t,r,b,l);
		};
		this.isOverTarget=function(pt,_87,_88){
			var loc=this.locationCache[_87.id];
			if(!loc||!this.useCache){
				loc=this.getLocation(_87);
				this.locationCache[_87.id]=loc;
			}
			_87.cursorIsOver=loc.contains(pt);
			_87.overlap=null;
			if(_88){
				var _89=YAHOO.util.Region.getRegion(this.dragCurrent.getDragEl());
				var _90=_89.intersect(loc);
				if(_90){
					_87.overlap=_90;
					return true;
				}else{
					return false;
				}
			}else{
				return _87.cursorIsOver;
			}
		};
		this._onUnload=function(e,me){
			this.unregAll();
		};
		this.unregAll=function(){
			if(this.dragCurrent){
				this.stopDrag();
				this.dragCurrent=null;
			}
			this._execOnAll("unreg",[]);
			for(i in this.elementCache){
				delete this.elementCache[i];
			}
			this.elementCache={};
			this.ids={};
		};
		this.elementCache={};this.getElWrapper=function(id){var _92=this.elementCache[id];if(!_92||!_92.el){_92=this.elementCache[id]=new this.ElementWrapper(document.getElementById(id));}return _92;};this.getElement=function(id){return document.getElementById(id);};this.getCss=function(id){var css=null;var el=document.getElementById(id);if(el){css=el.style;}return css;};this.ElementWrapper=function(el){this.el=el||null;this.id=this.el&&el.id;this.css=this.el&&el.style;};this.getPosX=function(el){return YAHOO.util.Dom.getX(el);};this.getPosY=function(el){return YAHOO.util.Dom.getY(el);};this.swapNode=function(n1,n2){if(n1.swapNode){n1.swapNode(n2);}else{var p=n2.parentNode;var s=n2.nextSibling;n1.parentNode.replaceChild(n2,n1);p.insertBefore(n1,s);}};this.getScroll=function(){var t,l;if(document.documentElement&&document.documentElement.scrollTop){t=document.documentElement.scrollTop;l=document.documentElement.scrollLeft;}else{if(document.body){t=document.body.scrollTop;l=document.body.scrollLeft;}}return {top:t,left:l};};this.getStyle=function(el,_97){if(el.style.styleProp){return el.style.styleProp;}else{if(el.currentStyle){return el.currentStyle[_97];}else{if(document.defaultView){return document.defaultView.getComputedStyle(el,null).getPropertyValue(_97);}}}};this.getScrollTop=function(){return this.getScroll().top;};this.getScrollLeft=function(){return this.getScroll().left;};this.moveToEl=function(_98,_99){var _100=YAHOO.util.Dom.getXY(_99);YAHOO.util.Dom.setXY(_98,_100);};this.getClientHeight=function(){return (window.innerHeight)?window.innerHeight:(document.documentElement&&document.documentElement.clientHeight)?document.documentElement.clientHeight:document.body.offsetHeight;};this.getClientWidth=function(){return (window.innerWidth)?window.innerWidth:(document.documentElement&&document.documentElement.clientWidth)?document.documentElement.clientWidth:document.body.offsetWidth;};this.numericSort=function(a,b){return (a-b);};this._timeoutCount=0;this._addListeners=function(){if(_50.Event&&document&&document.body){this._onLoad();}else{if(this._timeoutCount>500){}else{setTimeout("YAHOO.util.DDM._addListeners()",10);this._timeoutCount+=1;}}};this.handleWasClicked=function(node,id){if(this.isHandle(id,node.id)){return true;}else{var p=node.parentNode;while(p){if(this.isHandle(id,p.id)){return true;}else{p=p.parentNode;}}}return false;};};YAHOO.util.DDM=YAHOO.util.DragDropMgr;YAHOO.util.DDM._addListeners();}YAHOO.util.DD=function(id,_103){if(id){this.init(id,_103);}};YAHOO.util.DD.prototype=new YAHOO.util.DragDrop();YAHOO.util.DD.prototype.scroll=true;YAHOO.util.DD.prototype.autoOffset=function(_104,_105){var el=this.getEl();var _106=YAHOO.util.Dom.getXY(el);var x=_104-_106[0];var y=_105-_106[1];this.setDelta(x,y);};YAHOO.util.DD.prototype.setDelta=function(_107,_108){this.deltaX=_107;this.deltaY=_108;};YAHOO.util.DD.prototype.setDragElPos=function(_109,_110){var el=this.getDragEl();this.alignElWithMouse(el,_109,_110);};YAHOO.util.DD.prototype.alignElWithMouse=function(el,_111,_112){var _113=this.getTargetCoord(_111,_112);var _114=[_113.x,_113.y];YAHOO.util.Dom.setXY(el,_114);this.cachePosition(_113.x,_113.y);this.autoScroll(_113.x,_113.y,el.offsetHeight,el.offsetWidth);};YAHOO.util.DD.prototype.cachePosition=function(_115,_116){if(_115){this.lastPageX=_115;this.lastPageY=_116;}else{var _117=YAHOO.util.Dom.getXY(this.getEl());this.lastPageX=_117[0];this.lastPageY=_117[1];}};YAHOO.util.DD.prototype.autoScroll=function(x,y,h,w){if(this.scroll){var _120=this.DDM.getClientHeight();var _121=this.DDM.getClientWidth();var st=this.DDM.getScrollTop();var sl=this.DDM.getScrollLeft();var bot=h+y;var _125=w+x;var _126=(_120+st-y-this.deltaY);var _127=(_121+sl-x-this.deltaX);var _128=40;var _129=(document.all)?80:30;if(bot>_120&&_126<_128){window.scrollTo(sl,st+_129);}if(y<st&&st>0&&y-st<_128){window.scrollTo(sl,st-_129);}if(_125>_121&&_127<_128){window.scrollTo(sl+_129,st);}if(x<sl&&sl>0&&x-sl<_128){window.scrollTo(sl-_129,st);}}};YAHOO.util.DD.prototype.getTargetCoord=function(_130,_131){var x=_130-this.deltaX;var y=_131-this.deltaY;if(this.constrainX){if(x<this.minX){x=this.minX;}if(x>this.maxX){x=this.maxX;}}if(this.constrainY){if(y<this.minY){y=this.minY;}if(y>this.maxY){y=this.maxY;}}x=this.getTick(x,this.xTicks);y=this.getTick(y,this.yTicks);return {x:x,y:y};};YAHOO.util.DD.prototype.b4MouseDown=function(e){this.autoOffset(YAHOO.util.Event.getPageX(e),YAHOO.util.Event.getPageY(e));};YAHOO.util.DD.prototype.b4Drag=function(e){this.setDragElPos(YAHOO.util.Event.getPageX(e),YAHOO.util.Event.getPageY(e));};YAHOO.util.DDProxy=function(id,_132){if(id){this.forceCssPosition=false;this.init(id,_132);this.initFrame();}};YAHOO.util.DDProxy.prototype=new YAHOO.util.DD();YAHOO.util.DDProxy.frameDiv=null;YAHOO.util.DDProxy.dragElId="ygddfdiv";YAHOO.util.DDProxy.prototype.borderWidth=2;YAHOO.util.DDProxy.prototype.resizeFrame=true;YAHOO.util.DDProxy.prototype.centerFrame=false;YAHOO.util.DDProxy.createFrame=function(){var THIS=YAHOO.util.DDProxy;if(!document||!document.body){setTimeout(THIS.createFrame,50);return;}if(!THIS.frameDiv){THIS.frameDiv=document.createElement("div");THIS.frameDiv.id=THIS.dragElId;var s=THIS.frameDiv.style;s.position="absolute";s.visibility="hidden";s.cursor="move";s.border="2px solid #aaa";s.zIndex=999;document.body.appendChild(THIS.frameDiv);}};YAHOO.util.DDProxy.prototype.initFrame=function(){YAHOO.util.DDProxy.createFrame();this.setDragElId(YAHOO.util.DDProxy.dragElId);this.useAbsMath=true;};YAHOO.util.DDProxy.prototype.showFrame=function(_134,_135){var el=this.getEl();var s=this.getDragEl().style;if(this.resizeFrame){s.width=(parseInt(el.offsetWidth)-(2*this.borderWidth))+"px";s.height=(parseInt(el.offsetHeight)-(2*this.borderWidth))+"px";}if(this.centerFrame){this.setDelta(Math.round(parseInt(s.width)/2),Math.round(parseInt(s.width)/2));}this.setDragElPos(_134,_135);s.visibility="";};YAHOO.util.DDProxy.prototype.b4MouseDown=function(e){var x=YAHOO.util.Event.getPageX(e);var y=YAHOO.util.Event.getPageY(e);this.autoOffset(x,y);this.setDragElPos(x,y);};YAHOO.util.DDProxy.prototype.b4StartDrag=function(x,y){this.showFrame(x,y);};YAHOO.util.DDProxy.prototype.b4EndDrag=function(e){var s=this.getDragEl().style;s.visibility="hidden";};YAHOO.util.DDProxy.prototype.endDrag=function(e){var lel=this.getEl();var del=this.getDragEl();del.style.visibility="";lel.style.visibility="hidden";YAHOO.util.DDM.moveToEl(lel,del);del.style.visibility="hidden";lel.style.visibility="";};YAHOO.util.DDTarget=function(id,_138){if(id){this.initTarget(id,_138);}};YAHOO.util.DDTarget.prototype=new YAHOO.util.DragDrop();