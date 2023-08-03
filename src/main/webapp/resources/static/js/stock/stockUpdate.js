/** autor: mjh
 *  since: 2023.7.25
 */
var item =$("#item").text();
console.log(item);
$(document).ready(function(){
	showStock();
	$(document).on("click","#buyBtn",function(e){
		var prchsAmnt=e.target.parentElement.children[0].children[0].value;
		var rtnQnty= e.target.parentElement.children[1].children[0].value;
		alert(item+"을(를) "+prchsAmnt+"원 가격으로 "+rtnQnty+"개 매수한 내역을 업데이트 합니다.")
		bought(prchsAmnt,rtnQnty);
	});
	$(document).on("click","#sellBtn",function(e){
		var prchsAmnt=e.target.parentElement.children[0].children[0].value;
		var rtnQnty= e.target.parentElement.children[1].children[0].value;
		alert(item+"을(를) "+prchsAmnt+"원 가격으로 "+rtnQnty+"개 매도한 내역을 업데이트 합니다.")
		sold(prchsAmnt,rtnQnty);
	});
})
function showStock(){
	$.ajax({
		url:"stockInfo.json?item="+item,
		type:"get",
		contenType:"application/json",
		success:function(rslt){
			console.log(rslt);
			$("#rtnQnty").text(rslt.stock.rtnQnty);
			$("#prchsAmnt").text(rslt.stock.prchsAmnt);
		}
	});
}
function bought(prchsAmnt,rtnQnty){
	data={'item':item,'rtnQnty':rtnQnty,'prchsAmnt':prchsAmnt};
	$.ajax({
		url:"bought.json",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			alert("성공적으로 업데이트 하였습니다.");
			showStock();
		}
	});
	
}
function sold(prchsAmnt,rtnQnty){
	data={'item':item,'rtnQnty':rtnQnty,'prchsAmnt':prchsAmnt};
	$.ajax({
		url:"sold.json",
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			alert("성공적으로 업데이트 하였습니다.");
			showStock();
		}
	});
	
}