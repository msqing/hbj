function search(term){
	var hidevalue = $('#key').attr('hidevalue');
	var key;
	if(term){
		key = term;
	} else {
		key = $('#key').val();
	}
	if(key != '' && key != hidevalue){
		location.href = 'api.do?term=' + encodeURIComponent(key);
	}
}
function bus(){
	var start = $('#start_location').val();
	var end = $('#end_location').val();
	start = $.trim(start);
	end = $.trim(end);
	if(start != '' && end != ''){
		location.href = 'api.do?startLocation=' + encodeURIComponent(start) + '&endLocation=' + encodeURIComponent(end);
	}
}
function car(){
	var start = $('#start_place').val();
	var end = $('#end_place').val();
	start = $.trim(start);
	end = $.trim(end);
	if(start != '' && end != ''){
		location.href = 'api.do?startPlace=' + encodeURIComponent(start) + '&endPlace=' + encodeURIComponent(end);
	}
}

$(function(){
	$('.menu').click(function(){
		search($(this).find('span').html());
	});
	$('.menu li').click(function(){
		search($(this).html());
		return false;
	});
	$('.big_pic h2').click(function(){
		search($(this).text());
	}).css('cursor', 'pointer');
});
