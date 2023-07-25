/** autor: mjh
 *  since: 2023.7.25
 */ 
$(document).ready(function(){
	$(document).on("click","#rgstrBtn",function(e){
		var item=$('input[name=item]').val();
		var prchsAmnt=$('input[name=amount]').val();
		var rtnQnty=$('input[name=volume]').val();
		if(confirm("매수 항목:"+item+"<br/>매수 단가:"+prchsAmnt+"<br/>매수 수량:"+rtnQnty+"<br/>위 내용이 맞습니까?")){
			var data={'item':item, 'prchsAmnt':prchsAmnt, 'rtnQnty':rtnQnty}
			//ajax 호출
			$.ajax({
				url:"stockRegister.json",
				type:"post",
				data:JSON.stringify(data),
				dataType:"json",
				contentType:"application/json",
				success:function(rslt){
					console.log(rslt);
				}
			});			
		}
	});
})
