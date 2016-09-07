	$(function(){
		$('input:text').css('width', '80%');
		$('textarea').css('width', '80%').css('height', '150px');
		$('#place_type').autocomplete({
			source: "typeList.do",
			minLength: 0
		}).click(function(){
			if($(this).val() == ''){
				$(this).autocomplete('search');
			}
		});
		$('#place_subType').autocomplete({
			source: "subTypeList.do",
			minLength: 0
		}).click(function(){
			if($(this).val() == '' && $('#place_type').val() != ''){
				$(this).autocomplete('search', 'isType:' + $('#place_type').val());
			}
		});
	});
	
	function check(){
		window._html = $('#ufile td:last').html();
		$('#ufile td:last').html('<div style="cursor:wait">正在校验...</div>');
		var obj = $('#place_type');
		if(obj.val() == ''){
			obj.focus();
			alert('一级分类不能为空');
			$('#ufile td:last').html(window._html);
			return false;
		}
		
		obj = $('#place_subType');
		if(obj.val() == ''){
			obj.focus();
			alert('二级分类不能为空');
			$('#ufile td:last').html(window._html);
			return false;
		}
		
		obj = $('#place_name');
		if(obj.val() == ''){
			obj.focus();
			alert('地点名称不能为空');
			$('#ufile td:last').html(window._html);
			return false;
		}
		
		obj = $('#place_address');
		if(obj.val() == ''){
			obj.focus();
			alert('地址不能为空');
			$('#ufile td:last').html(window._html);
			return false;
		}
		$('#ufile td:last').html('<div style="cursor:wait">正在提交...</div>');
		return true;
	}