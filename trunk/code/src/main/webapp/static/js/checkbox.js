 $(function(){
        //全部选中
	    $(".chk_all").click(function(){
		    if($(this).attr("checked")){
			    $(":checkbox").attr("checked", true);
		    } else {
			    $(":checkbox").attr("checked", false);
		    }
	    });
    	
	    //单个选中
	    $(".chk_single").click(function(){
		    if($(this).attr("checked") && $(".chk_single:checked").size() == $(".chk_single").size()){
			    $(".chk_all").attr("checked", true);
		    } else {
			    $(".chk_all").attr("checked", false);
		    }
	    });
    	
    	       
    });
    //单个删除
    function singleDelete(url, id){
        if(confirm("你确定删除这条记录吗？")){
            location = "{0}?ids={1}".format(url,encodeURIComponent(id)); 
        }
    }
    

    //批量删除按钮
    function batchDelete(url){
	    var chkSingle = $(".chk_single:checked");
	    if(chkSingle.size() > 0){
		    if(confirm("你确定要删除这些记录吗？")){
			    var ids = "";
			    chkSingle.each(function(i){
				    if(i > 0){
					    ids += ",";
				    }
				    ids += $(this).val();
			    });
	            location = "{0}?ids={1}".format(url, encodeURIComponent(ids)); 
		    }
	    } else {
		    alert("你没有选择任何对象");
	    }
    } 
