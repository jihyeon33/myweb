/** author: mjh
 *  since:2023.7.23
 */
$(document).ready(function(){
	showList();
	$(document).on("click","#deleteBtn",function(e){
		if(confirm("삭제 하시겠습니까?")){
			deleteOne(e);
		}
	});
	$(document).on("click","#updateBtn",function(e){
		var item= e.target.parentElement.parentElement.getAttribute('item');
		alert(item+"의 업데이트 페이지로 이동합니다.");
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
			$('#totalCnt').text(rslt.totalCnt);
			$('#totalAmount').text(rslt.totalAmount);
			
			var stocklist= rslt.stocklist;
			var html='';
			for(var i=0; i<stocklist.length; i++){
				html
				+='<tr item='+stocklist[i].item+'>'
				+'<th scope="row">'+stocklist[i].item+'</th>'
				+'<td>'+stocklist[i].rtnQnty+'</td>'
				+'<td>'+stocklist[i].prchsAmnt+'</td>'
				+'<td>'
				+'<a href="http://localhost:8080/myweb/stock/stockUpdate.do?item='+stocklist[i].item+'" id="updateBtn">업데이트하기</a><br/>'
				+'<a href="#" id="deleteBtn" itemId='+stocklist[i].id+'>삭제하기</a>'
				+'</td>'
				+'</tr>';
			}
			$("#stocklist > table> tbody").html(html);
		}
	});
}
function deleteOne(e){
	//ajax호출
	var id = e.currentTarget.getAttribute('itemId');
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