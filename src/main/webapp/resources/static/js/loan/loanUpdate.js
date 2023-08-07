/** author: mjh
 *  since: 2023.08.08
 */
$(document).ready(function(){
	$(document).on("click","#moreBtn",function(e){
		$('#more').show();
		$('#repay').hide();
	})
	$(document).on("click","#repayBtn",function(e){
		$('#repay').show();
		$('#more').hide();	
	})	
	$(document).on("click","#moreUpdateBtn",function(e){
		more(e);
	})
	$(document).on("click","#repayUpdateBtn",function(e){
		repay(e);
	})
});
function more(e){
	var data={};
	$.ajax({
		url:"",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){}
	})
}
function repay(e){
	var data={};
	$.ajax({
		url:"",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){}
	})	
}