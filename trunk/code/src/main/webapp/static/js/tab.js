// JavaScript Document
function stopPropagation(e) {  
    e = e || window.event;  
    if(e.stopPropagation) { //W3C阻止冒泡方法  
        e.stopPropagation();  
    } else {  
        e.cancelBubble = true; //IE阻止冒泡方法  
    }  
}  
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
			
			var speed=(json[attr]-cur)/10;
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

window.onload=function() {
	//------------变量区----------
	//输入框变量
	var oForm=document.getElementById('form');
	var aSearchList=getClass(oForm,'div','search_list');
	var aTabButton=getClass(oForm,'div','tab_button');
	var aSuggestButton=getClass(oForm,'div','suggest_button');
	var aSuggestList=getClass(oForm,'ul','suggest_list');
	var aSuggestText=[];
	aSuggestText=getClass(oForm,'li','suggest_text');

	
	//下拉菜单变量
	var oMenu=document.getElementById('menu');
	var aMenu=getClass(oMenu,'li','menu');
	var aSubMenu=oMenu.getElementsByTagName('ul');
	
	//图片展示变量
	var oShowBox=document.getElementById('show_box');
	var aViewList=getClass(oShowBox,'div','view_list');
	var aBigImg=[];
	var aTitle=[];
	var aInfo=[];
	var aLeftCol=[];
	var aMiddleCol=[];
	var aRightCol=[];

	var oButtonBox=document.getElementById('image_button');
	var oPrev=getClass(oButtonBox,'p','prev')[0];
	var oNext=getClass(oButtonBox,'p','next')[0];
	var oButtonList=oButtonBox.getElementsByTagName('ul')[0];
	var aButtonList=oButtonList.getElementsByTagName('li');
	var aSmallImg=[];
	var aSubTitle=[];
	var now=0;
	var oBorder=getClass(oButtonBox,'img','border')[0];
	
	
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
	for(var i=0;i<aMenu.length;i++)
	{
		aMenu[i].index=i;
		aMenu[i].style.cursor='pointer';
		aMenu[i].style.backgroundPosition=-129*aMenu[i].index+'px'+' 10px';
		aMenu[i].onmouseover=function(e){
			this.style.backgroundColor='#0b2d43';
			this.style.color='#fff';
			this.style.backgroundImage='url(static/images/menu_hover.gif)';
			aSubMenu[this.index].style.display='block';			
			stopPropagation(e);  
		};
		aMenu[i].onmouseout=function(e){
			this.style.backgroundColor='';
			this.style.color='#000';
			this.style.backgroundImage='url(static/images/menu.gif)';
			aSubMenu[this.index].style.display='none';			
		    stopPropagation(e);  
		};			
	}
	
	
	//初始化数组
	for(var i=0;i<aViewList.length;i++) {
	    aTitle.push(aViewList[i].getElementsByTagName('h2')[0]);
		aBigImg.push(aViewList[i].getElementsByTagName('img')[0]);
	    aInfo.push(aViewList[i].getElementsByTagName('div')[1]);
	}
	
	for(var i=0;i<aButtonList.length;i++) {
	    aSmallImg.push(aButtonList[i].getElementsByTagName('img')[0]);
	    aSubTitle.push(aButtonList[i].getElementsByTagName('h3')[0]);
		aLeftCol.push(getClass(aInfo[i],'p','left_col')[0]);
		aMiddleCol.push(getClass(aInfo[i],'p','middle_col')[0]);
		aRightCol.push(getClass(aInfo[i],'p','right_col')[0]);
	}
	
	

	for(var i=0;i<aViewList.length;i++) {
		aViewList[i].style.position='absolute';
		aViewList[i].style.left=0;
		aViewList[i].style.top=0;
		
		aTitle[i].style.left=-1100+'px';
		aBigImg[i].style.left=-1100+'px';
		aInfo[i].style.left=-3000+'px';
		aMiddleCol[i].style.paddingLeft=50+'px';
		aMiddleCol[i].style.paddingLeft=10+'px';
		aRightCol[i].style.paddingLeft=10+'px';
		aTitle[i].style.opacity=0;
		aTitle[i].style.filter='alpha(opacity:0)';
		aBigImg[i].style.opacity=0;
		aBigImg[i].style.filter='alpha(opacity:0)';
		aInfo[i].style.opacity=0;
		aInfo[i].style.filter='alpha(opacity:0)';
		
		
		aTitle[0].style.left=50+'px';
		aBigImg[0].style.left=0;
		aInfo[0].style.left=1100+'px';
		aMiddleCol[0].style.paddingLeft=300+'px';
		aMiddleCol[0].style.paddingLeft=600+'px';
		aRightCol[0].style.paddingLeft=900+'px';

	}
	

	//图片切换
	
	function tab()
	{
		for(var i=0;i<aViewList.length;i++)
		{
			
			startMove(aBigImg[i],{'left':-1100,'opacity':0});
			startMove(aTitle[i],{'left':-1100,'opacity':0});
			startMove(aInfo[i],{'left':-3000,'opacity':0});
			startMove(aLeftCol[i],{'paddingLeft':300});
			startMove(aMiddleCol[i],{'paddingLeft':600});
			startMove(aRightCol[i],{'paddingLeft':900});
			
			//小图默认样式
			aSmallImg[i].style.width=150+'px';
			aSubTitle[i].style.display='block';
			startMove(aSmallImg[i],{'opacity':30});

			aTitle[now].style.opacity=0;
			aTitle[now].style.filter='alpha(opacity:0)';
			aBigImg[now].style.opacity=0;
			aBigImg[now].style.filter='alpha(opacity:0)';
			aInfo[now].style.opacity=0;
			aInfo[now].style.filter='alpha(opacity:0)';
			aTitle[now].style.left=1100+'px';
			aBigImg[now].style.left=1100+'px';
			aInfo[now].style.left=1100+'px';
			
			startMove(aTitle[now],{'left':50,'opacity':100});
			startMove(aBigImg[now],{'left':0,'opacity':100});
			startMove(aInfo[now],{'left':0,'opacity':100});
			startMove(aLeftCol[now],{'paddingLeft':10});
			startMove(aMiddleCol[now],{'paddingLeft':10});
			startMove(aRightCol[now],{'paddingLeft':10});
			aSubTitle[now].style.display='none';
			startMove(aSmallImg[now],{'opacity':100});
			startMove(oBorder,{left:160*now+5});
		}
	};
	
	tab();
		
	/*****箭头点击*******/
	oPrev.onclick=function() {
		startMove(oButtonList,{'left':0});
	};
	oNext.onclick=function() {
		startMove(oButtonList,{'left':-160});
	};
	
	
	//自动切换
	var timer=setInterval(function() {
		now++;
		if(now==aViewList.length)
		{
			now=0;
		}
		tab();
	},8000);
 
	
	for(var i=0;i<aButtonList.length;i++) {
		aButtonList[i].index=i;
		aButtonList[i].onmouseover=function() {
			//clearInterval(timer);

			if(now==this.index) 
			{
				return;
			}
			else
			{
			    aSubTitle[this.index].style.display='none';
			    startMove(aSmallImg[this.index],{'opacity':100});
			}
		};
		aButtonList[i].onmouseout=function() {
			if(now==this.index)
			{
				return;
			}
			aSubTitle[this.index].style.display='block';
			startMove(aSmallImg[this.index],{'opacity':30});
		}
		aButtonList[i].onclick=function() {
			clearInterval(timer);
			//清除上一个运动
			var end = setInterval(function(){},1);
			var start = (end -100)>0?end-100:0;
			for(var i=start;i<=end;i++){
				clearInterval(i);
			}
			timer=setInterval(function() {
				now++;
				if(now==aViewList.length)
				{
					now=0;
				}
				tab();
			},8000);
 
			now=this.index;
			tab();
			startMove(oBorder,{left:160*now+5});

		}
	}
}