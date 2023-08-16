/** author : mjh
 *  since : 2023.7.26
 */
$(document).ready(function(){
	showLoanList();
	$(document).on("click","#updateBtn",function(e){
		var loanId = $('input[name="listGroupRadio"]:checked').val();
		location.href = "loanUpdate/"+loanId;		
	});
	$(document).on("click","#deleteBtn",function(e){
		deleteLoan(e);
	});
})
function showLoanList(){
	$.ajax({
		url:"loanlist.json",
		type:"get",
		contentTyp:"application/json",
		success:function(rslt){
			console.log(rslt);
			var totalamount =rslt.totalAmount;
			$('#totalamount').text(totalamount);
			var list =rslt.loanlist;
			var html='<ul class="list-group">';
			for(var i=0;i<list.length;i++){
				html+='<li class="list-group-item">'
				+'<input class="form-check-input me-1" type="radio" name="listGroupRadio" value="'+list[i].id+'" id="'+i+1+'Radio" checked>'
				+'<label class="form-check-label" for="'+i+1+'Radio">'+list[i].lender+" 대출금: "+list[i].amount+" 상환예정일: "+list[i].repayDate+'</label>  '
				+'<a href="#" id="deleteBtn" loanId="'+list[i].id+'">삭제하기</a>'
				+'</li>';
			}
			html+="</ul>";
			$("#loanlist").html(html);
		}
	})
	
}
function deleteLoan(e){
	alert("삭제클릭");
	var loanId = e.target.getAttribute('loanId');
	console.log(loanId);
	$.ajax({
		url:"loanDelete/"+loanId,
		type:"delete",
		contentType:"application/json",
		success:function(rslt){
			alert("성공적으로 삭제하였습니다.");
			console.log(rslt);
			showLoanList();
		}
	})
}