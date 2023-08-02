console.log("bankMain.js파일입니다.");
$(document).ready(function(){
	jsonTest();
	jsonTest2();
	showAccountList();
	//update 버튼
	$(document).on("click","#updateBtn",function(e){

		//var balance = $("input[name=balance]").val();		
		var balance =e.target.parentElement.children[1].children[0].value;
		var selectedIdx= e.target.parentElement.children[0].children[0].selectedIndex;
		var selectedOption = e.target.parentElement.children[0].children[0].options[selectedIdx].value;
		
		if(selectedOption=='plus'){
			if(confirm("잔액에서 "+balance+"원 더하겠습니다.")){
				balancePlus(e);
			}			
		}else{					
			if(confirm("잔액에서 "+balance+"원을 빼겠습니다.")){
				balanceMinus(e);
			}
		}					
	});
	//delete 버튼
	$(document).on("click","#deleteBtn",function(e){
		var accountId = e.target.parentElement.parentElement.parentElement.getAttribute('accountId');
		var data={'accountId':accountId};
		if(confirm(accountId+"를 삭제하시겠습니까?")){
			$.ajax({
				url:"accountDelete.json",
				type:"post",
				data:JSON.stringify(data),
				dataType:"json",
				contentType:"application/json",
				success:function(rslt){
					alert(rslt+'건 삭제 되었습니다.');
					showAccountList();
				}		
			});			
		}	
	});
	//register 버튼
	$(document).on("click","#registerBtn",function(e){
		//계좌번호 동일여부 유효성 체크
		confirm("취소");
		$.ajax({
			url:"accountCheck.json",
			type:"get",
			data:"",
			dataType:"json",
			contentType:"application/json",
			success:function(rslt){
				if(rslt==1){ //1:있음
					alert("이미 등록되어있는 계좌번호 입니다. 다른 계좌번호를 입력해 주세요.");
				}else{ //0:없음
					alert("등록 가능한 계좌정보 입니다. 감사합니다.");
				}
				
			}
		});
	});
});
function jsonTest(){
	$.ajax({
		url:"jsonViewTEST.json",
		type:"get",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
		}
	})	
}
function jsonTest2(){
	$.ajax({
		url:"jsonViewTEST2.json",
		type:"get",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
		}
	})	
}
function showAccountList(){
	$.ajax({
		url:"accountlist.json",
		type:"get",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			
			//html  그리기
			var html ='';		
			for(var i=0; i<rslt.length;i++){
				html
				+='<div class="card" style="width: 24rem;" accountId='+rslt[i].accountId+'>'
				+	'<div class="card-header">'+rslt[i].bankName+'은행 ('+rslt[i].accountId+') : '+rslt[i].balance+'원'+'</div>'
				+	'<ul class="list-group list-group-flush">'
				+		'<li class="list-group-item">'
				+			'<p>'
				+				'<select name="updateOption">'
				+					'<option value="plus">더하기</option>'
				+					'<option value="minus">빼기</option>'
				+				'</select>'
				+			'</p>'
				+			'<p>금액 : <input type="text" name="balance" value="예) 510000"/></p>'
				+			'<a href="#" id="updateBtn">업데이트하기</a><br/>'
				+		'</li>'
				+		'<li class="list-group-item">'
				+			'<a href="#" id="deleteBtn">삭제하기</a>'
				+		'</li>'
				+	'</ul>'
				+'</div>';
			}
			
			$('#accountlist').html(html);
		}
	})
}
function balancePlus(e){
	var balance = e.target.parentElement.children[1].children[0].value;	
	var accountId = e.target.parentElement.parentElement.parentElement.getAttribute('accountId');
	
	var data ={
		'balance': balance,
		'accountId': accountId
	};
	$.ajax({
		url:"balancePlus.json",
		type:"post",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			showAccountList();
		}
	})
	
}
function balanceMinus(e){
	var balance = e.target.parentElement.children[1].children[0].value;
	var accountId = e.target.parentElement.parentElement.parentElement.getAttribute('accountId');

	var data ={
		'balance': balance,
		'accountId': accountId
	};
	$.ajax({
		url:"balanceMinus.json",
		type:"post",
		data:JSON.stringify(data),
		dataType:"json",
		contentType:"application/json",
		success:function(rslt){
			console.log(rslt);
			showAccountList();
		}
	})	
}