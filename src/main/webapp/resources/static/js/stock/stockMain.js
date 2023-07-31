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
			var html='';
			for(var i=0; i<rslt.length; i++){
				html
				+='<tr>'
				+'<th scope="row">'+rslt[i].item+'</th>'
				+'<td>'+rslt[i].rtnQnty+'</td>'
				+'<td>'+rslt[i].prchsAmnt+'</td>'
				+'<td>'
				+'<a href="http://localhost:8080/myweb/stock/stockUpdate.do?id='+rslt[i].id+'" id="updateBtn">업데이트하기</a>'
				+'<a href="#" id="deleteBtn" itemId='+rslt[i].id+'>삭제하기</a>'
				+'</td>'
				+'</tr>';
			}
			$("#stocklist > table> tbody").html(html);
		}
	});
}
function deleteOne(e){
	var target= e.currentTarget;
	//ajax호출
	var id = target.getAttribute('itemId');
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