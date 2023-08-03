/** autor: mjh
 *  since: 2023.7.25
 */ 
$(document).ready(function(){
	$(document).on("click","#rgstrBtn",function(){
		var item=$('input[name=item]').val();
		var prchsAmnt=$('input[name=amount]').val();
		var rtnQnty=$('input[name=volume]').val();
		if(confirm("매수 항목:"+item+", 매수 단가:"+prchsAmnt+", 매수 수량:"+rtnQnty+" >>>위 내용이 맞습니까?")){
			stockItemCheck(item,prchsAmnt,rtnQnty);
		}
	});
})
function stockItemCheck(item,prchsAmnt,rtnQnty){
	console.log(item);
	var data={'item':item}
	$.ajax({
		url:"stockItemCheck.json",
		type:"post",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			if(rslt.flag==1){  //1:존재
				alert("이미 등록되어있는 주식항목입니다. 해당 주식의 업데이트 페이지에서 업데이트 부탁드립니다.");
			}else{ //0:신규
				alert("등록 가능한 신규항목입니다. 등록하겠습니다.");
				stockRegister(item,prchsAmnt,rtnQnty);
			}
		}
	})
}
function stockRegister(item,prchsAmnt,rtnQnty){
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
