/** autor: mjh
 *  since: 2023.7.25
 */ 
$(document).ready(function(){
	$(document).on("click","#updateBtn",function(e){
		//if 매수 : bought()
		//else 매도 : sold()
	});
})
function bought(){
	data={};
	$.ajax({
		url:"bought.json",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
		}
	});
	
}
function sold(){
	$.ajax({
		url:"sold.json",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
		}
	});
	
}