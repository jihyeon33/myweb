/** author: mjh
 *  since: 2023.7.27"
 */
$(document).ready(function(){
	$(document).on("click","#registerBtn",function(e){
		alert("등록하기버튼입니다.");
		var lender=$('input[name=lender]').val();
		var amount=$('input[name=amount]').val();
		var repayDate=$('input[name=repayDate]').val();
		var data={'lender':lender,'amount':amount,'repayDate':repayDate}
		console.log(lender,amount,repayDate);
		$.ajax({
			url:"loanRegister/"+lender,
			type:"post",
			data:JSON.stringify(data),
			dataType:"json",
			contentType:"application/json",
			success:function(rslt){
				console.log(rslt);
			}
		});
	})
})