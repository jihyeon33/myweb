/** autor: mjh
 *  since: 2023.7.25
 */ 
$(document).ready(function(){
	$(document).on("click","#rgstrBtn",function(e){
		//ajax 호출
		$.ajax({
			url:"stockRegister.json",
			type:"post",
			data:"",
			dataType:"",
			contentType:"",
			success:function(rslt){
			}
		});
	});
})
