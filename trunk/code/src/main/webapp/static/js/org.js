 $(function(){
	 $('#committee_id').change(function(){
		 var committeeId = this.value;
		 $.ajax({
			url: 'ajaxBranchList.do',
			data: 'committee.id=' + committeeId,
			success:function(html){
				$('#branchContainer').html(html);
			}
		 });
	 });
 }); 
