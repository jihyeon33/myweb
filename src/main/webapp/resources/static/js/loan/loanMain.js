/** author : mjh
 *  since : 2023.7.26
 */
$(document).ready(function(){
	showLoanList();
	$(document).on("click","#id",function(e){
		
	});
})
function showLoanList(){
	$.ajax({
		url:"loanlist.json",
		type:"get",
		contentTyp:"application/json",
		success:function(rslt){
			console.log(rslt);
			var html="<ul>";
			for(var i=0;i<rslt.length;i++){
				html+="<li>"+i+1+"."+rslt[i].lender+" 대출금: "+rslt[i].amount+" 상환예정일: "+rslt[i].repayDate+" <a href='loanUpdate.do'>업데이트하기</a></li>";
			}
			html+="</ul>";
			$("#loanlist").html(html);
		}
	})
	
}