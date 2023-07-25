/** author: mjh
 *  since:2023.7.23
 */
$(document).ready(function(){
	showList();
	$(document).on("click","#deleteBtn",function(e){
		if(confirm("삭제 하시겠습니까?")){
			deleteOne();
		}
	});
	$(document).on("click","#updateBtn",function(e){
		confirm("xx항목에 대해 업데이트 하실 사항이 있으십니까?");
	});
	
});
function showList(){
	//ajax 호출
	$.ajax({
		url:"stockList.json",
		type:"get",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			html="<ul>";
			for(var i=0; i<rslt.length; i++){
				html+='<li itemId='+rslt[i].id+'>'+rslt[i].item+' 보유수량:'+rslt[i].rtnQnty+', 총 매수금액:'+rslt[i].prchsAmnt
				+'<a href="http://localhost:8080/myweb/stock/stockUpdate.do?id='+rslt[i].id+'" id="updateBtn">업데이트하기</a><a href="#" id="deleteBtn">삭제하기</a></li>';
			}
			html+='</ul>';
			$("#stocklist").html(html);
		}
	});
}
function deleteOne(){
	//ajax호출
	var id = $('div[id=stocklist]>ul>li').attr('itemId');
	var data={'id': id };
	$.ajax({
		url:"stockDelete.json",
		type:"delete",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			alert(rslt+"건 삭제 되었습니다.");
			showList();
		}
	});
}