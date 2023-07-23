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
		if(confirm("xx항목에 대해 업데이트 하실 사항이 있으십니까?")){
			updateOne();
		}
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
		}
	});
}
function deleteOne(){
	//ajax호출
	var data={'item':item};
	$.ajax({
		url:"stockDelete.json",
		type:"delte",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		succes:function(rslt){
			console.log(rslt);
			showList();
		}
	});
}
function updateOne(){	
	//페이지 이동
	var data={'item':item};
	$.ajax({
		url:"stockUpdate.do",
		type:"get",
		data:JSON.stringify(data),
		dataType:"json",
		succes:function(){
			console.log("페이지 이동되었습니다.");
		}
	});
	
}