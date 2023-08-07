/** author : mjh
 *  since : 2023.7.26
 */
$(document).ready(function(){
	showLoanList();
	$(document).on("click","#updateBtn",function(e){
		var loanId = $('input[name="listGroupRadio"]:checked').val();
		location.href = "loanUpdate/"+loanId;		
	});
})
function showLoanList(){
	$.ajax({
		url:"loanlist.json",
		type:"get",
		contentTyp:"application/json",
		success:function(rslt){
			console.log(rslt);
			var html='<ul class="list-group">';
			for(var i=0;i<rslt.length;i++){
				html+='<li class="list-group-item">'
				+'<input class="form-check-input me-1" type="radio" name="listGroupRadio" value="'+rslt[i].id+'" id="'+i+1+'Radio" checked>'
				+'<label class="form-check-label" for="'+i+1+'Radio">'+rslt[i].lender+" 대출금: "+rslt[i].amount+" 상환예정일: "+rslt[i].repayDate+'</label>'
				+'</li>';
			}
			html+="</ul>";
			$("#loanlist").html(html);
		}
	})
	
}