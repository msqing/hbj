$(function(){
		
		//自动下拉
		$('#key, .start, .end').focus(function(){
			var hidevalue = $(this).attr('hidevalue');
			if(hidevalue == this.value){
				this.value = '';
			}
		}).blur(function(){
			var hidevalue = $(this).attr('hidevalue');
			if(this.value == ''){
				this.value = hidevalue;
			}
		}).autocomplete({
			source: "ajaxSearch.do",
			minLength: 2,
			select: function( event, ui ) {
			}
		}).keyup(function(e){
			inputKeyup(this);
			if(e.keyCode == 13){
				var objId = $(this).attr('id');
				if(objId == 'key'){
					search();
				} else if(objId.indexOf('location') > 0){
					bus();
				} else if(objId.indexOf('place') > 0){
					car();
				}
			}
		});
		
		$('.exchange').click(function(){
			var prevInput = $(this).prev().find('input');
			var nextInput = $(this).next().find('input');
			var prevValue = prevInput.val();
			var prevHideValue = prevInput.attr('hidevalue');
			var nextValue = nextInput.val();
			var nextHideValue = nextInput.attr('hidevalue');
			if(prevValue != '' && prevValue != prevHideValue){
				nextInput.val(prevValue);
			} else {
				nextInput.val(nextHideValue);
			}
			if(nextValue != '' && nextValue != nextHideValue){
				prevInput.val(nextValue);
			} else {
				prevInput.val(prevHideValue);
			}
			prevInput.keyup();
			nextInput.keyup();
		});
		
	});

function inputKeyup(obj){
	var hidevalue = $(obj).attr('hidevalue');
	if($(obj).val() != '' && $(obj).val() != hidevalue){
		$(obj).css('color', '#000000');
	} else {
		$(obj).css('color', '#bfbfbf');
	}
}