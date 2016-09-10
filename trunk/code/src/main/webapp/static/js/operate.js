$(function(){
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth() + 1;
	var day = time.getDate();
	var hour = time.getHours();
	var minute = time.getMinutes();
	var second = time.getSeconds();
	$('.PBtime').text(decodeURI('%E5%8F%91%E5%B8%83%E6%97%A5%E6%9C%9F%EF%BC%9A') + year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second);
	
})

function showList(url){
	if(!$('#check').is(':checked')){
		alert(decodeURI('%E8%AF%B7%E5%8B%BE%E9%80%89%E6%88%91%E5%B7%B2%E9%98%85%E7%9F%A5'));
		return;
	}
	window.open(url);
}
