/** author: mjh
 *  since: 2023.7.27"
 */
$(document).ready(function(){
	$(document).on("click","#registerBtn",function(e){
		var lender=$('input[name=lender]').val();
		var amount=$('input[name=amount]').val();
		var repayDate=$('input[name=repayDate]').val();
		var data={'lender':lender,'amount':amount,'repayDate':repayDate}

		$.ajax({
			url:"loanRegister.json",
			type:"post",
			data:JSON.stringify(data),
			dataType:"json",
			contentType:"application/json",
			success:function(rslt){
				console.log(rslt);
				alert("성공적으로 등록 되었습니다.");
			}
		});
	})
})