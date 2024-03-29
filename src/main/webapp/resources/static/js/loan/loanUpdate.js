/** author: mjh
 *  since: 2023.08.08
 */
var loanId=$('input[id=loanId]').val();
console.log(loanId);
$(document).ready(function(){
	$(document).on("click","#moreBtn",function(e){
		$('#more').show();
		$('#repay').hide();
	})
	$(document).on("click","#repayBtn",function(e){
		$('#repay').show();
		$('#more').hide();	
	})	
	$(document).on("click","#moreUpdateBtn",function(e){
		more(e);
	})
	$(document).on("click","#repayUpdateBtn",function(e){
		repay(e);
	})
});
function showLoan(){
	$.ajax({
		url:"getLoan.json?id="+loanId,
		type:"get",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			$('#amount').text(rslt.loandto.amount);
			$('#repayDate').text(rslt.loandto.repayDate);
		}
	})
}
function more(e){
	var option='m';
	var lender=e.target.parentElement.children[0].children[1].value;
	var amount=e.target.parentElement.children[1].children[1].value;
	var repayDate = e.target.parentElement.children[2].children[1].value;
	var data={'updateOption':option,'lender':lender,'amount':amount,'repayDate':repayDate};
	$.ajax({
		url:loanId,
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			alert("성공적으로 업데이트하였습니다.");
			showLoan();
		}
	})
}
function repay(e){
	var option='r';
	var lender=e.target.parentElement.children[0].children[1].value;
	var amount=e.target.parentElement.children[1].children[1].value;
	var data={'updateOption':option,'lender':lender,'amount':amount};
	$.ajax({
		url:loanId,
		type:"put",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			alert("성공적으로 업데이트하였습니다.");
			showLoan();
		}
	})	
}