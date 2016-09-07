// JavaScript Document
function stopPropagation(e) {  
    e = e || window.event;  
    if(e.stopPropagation) { //W3C阻止冒泡方法  
        e.stopPropagation();  
    } else {  
        e.cancelBubble = true; //IE阻止冒泡方法  
    }  
} 
//获取样式
function getStyle(obj,attr)
{
	if(obj.currentStyle) {
		return obj.currentStyle[attr];
	}
	else
	{
		return document.defaultView.getComputedStyle(obj,false)[attr];
	}
};
//运动框架
function startMove(obj,json,fnEnd)
{
	clearInterval(obj.timer);
	obj.timer=setInterval(function () {
		var bStop=true;
		
		for(var attr in json)
		{
			var cur=0;
			if(attr=='opacity')
			{
				cur=parseFloat(getStyle(obj,attr))*100;
				cur=parseInt(cur);
			}
			else
			{
			cur=parseInt(getStyle(obj,attr));
			}
			
			var speed=(json[attr]-cur)/5;
			speed=speed>0?Math.ceil(speed):Math.floor(speed);
			
			if(cur!==json[attr])
			    bStop=false;
			
			if(attr=='opacity')
			{
				obj.style.filter='alpha(opacity:'+(cur+speed)+')';
				obj.style.opacity=(cur+speed)/100;
			}
			else
			{
				obj.style[attr]=cur+speed+'px';
			}
		}
		
		if(bStop)
		{
			clearInterval(obj.timer);
			if(fnEnd) fnEnd();
		}
	},30);
};
function getClass(obj,tag,className) {
	var aClass=[];
	var aTag=obj.getElementsByTagName(tag);
	for(var i=0;i<aTag.length;i++) {
	  if(aTag[i].className.match(className)) {
		  aClass.push(aTag[i]);
	  }
	}
	return aClass;	
};
function pageWidth(){
    return window.innerWidth != null ? window.innerWidth : document.documentElement && document.documentElement.clientWidth ? document.documentElement.clientWidth : document.body != null ? document.body.clientWidth : null;
};

$(function() {
	//输入框变量
	var oForm=document.getElementById('form');
	var aSearchList=getClass(oForm,'div','search_list1');
	var aTabButton=getClass(oForm,'div','tab_button');
	var aSuggestButton=getClass(oForm,'div','suggest_button');
	var aSuggestList=getClass(oForm,'ul','suggest_list');
	var aSuggestText=[];
	aSuggestText=getClass(oForm,'li','suggest_text');

	//输入框切换
	for(var i=0;i<aTabButton.length;i++){
		aTabButton[i].index=i;
		aTabButton[i].onclick=function() {
			for(var j=0;j<aTabButton.length;j++) {
				aTabButton[j].className='tab_button';
			}
			this.className='current tab_button';
			for(var j=0;j<aSearchList.length;j++) {
				aSearchList[j].style.display='none';
			}
			aSearchList[this.index].style.display='block';
		}
	}
	//显示输入提示
	document.onclick=function ()
	{
		for(var i=0;i<aSuggestList.length;i++)
		{
			aSuggestList[i].style.display='none';
		}
	};
	for(var i=0;i<aSuggestButton.length;i++){
		aSuggestButton[i].index=i;
		aSuggestButton[i].onclick=function(e){
			aSuggestList[this.index].style.display='block';
			aSuggestList[this.index].style.width=this.parentNode.parentNode.offsetWidth-8+'px';
		    stopPropagation(e);  
		}		
	}
	//提示值
	for(var i=0;i<aSuggestText.length;i++){
		aSuggestText[i].onclick=function(){
			var oParentInput=this.parentNode.parentNode.parentNode.getElementsByTagName('input')[0];
			oParentInput.style.color='#000';
			if(this.innerText){
				oParentInput.value=this.innerText;
			}
			else if(this.textContent){
				oParentInput.value=this.textContent;
			}
		};
	}

	//菜单鼠标事件
	try{
		var aMenu=document.getElementById('menu').getElementsByTagName('li');
		for(var i=0;i<aMenu.length;i++)
		{
			aMenu[i].onmouseover=function(){
				this.style.backgroundColor='#217bad';
				this.getElementsByTagName('a')[0].style.color='#fff';
				this.getElementsByTagName('a')[0].style.backgroundImage='url(static/images/menu_2_hover.gif)';
			};
			aMenu[i].onmouseout=function(){
				this.style.backgroundColor='';
				this.getElementsByTagName('a')[0].style.color='#555';
				this.getElementsByTagName('a')[0].style.backgroundImage='url(static/images/menu_2.gif)';
			};			
		}
	}catch(e){}

	
	
	
	var oFull=document.getElementById('full_screen');
	oFull.onclick=function(){
		if(this.parentNode.offsetWidth==950){
			startMove(this.parentNode,{width:1300});
		}
		else
		{
			startMove(this.parentNode,{width:950});
		}
	}
});