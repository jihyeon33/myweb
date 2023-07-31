console.log("bankMain.js파일입니다.");
$(document).ready(function(){
	showAccountList();
	//update 버튼
	$(document).on("click","#updateBtn",function(e){
		if($("select[name=updateOption] option:selected").val()=='plus'){
			if(confirm("xx원 맞으십니까?")){
				balancePlus();
			}

		}else{
			if(confirm("xx원 맞으십니까?")){
				balanceMinus();
			}
		}
		
	});
	//delete 버튼
	$(document).on("click","#deleteBtn",function(e){
		var accountId = $('div[id=accountlist]>div').attr('accountId');
		var data={'accountId':accountId};
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
	});
});
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
				+			'<p>금액 : <input type="text" name="balance"/></p>'
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
function balancePlus(){
	var accountId = $('div[id=accountlist]>div').attr('accountId');
	var balance = $("input[name=balance]").val();
	var data ={
		'balance': balance,
		'accountId': accountId
	};
	alert($("input[name=balance]").val());
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
function balanceMinus(){
	var accountId = $('div[id=accountlist]>div').attr('accountId');
	var balance = $("input[name=balance]").val();
	var data ={
		'balance': balance,
		'accountId': accountId
	};
	alert($("input[name=balance]").val());
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