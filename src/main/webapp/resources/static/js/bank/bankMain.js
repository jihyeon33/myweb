console.log("bankMain.js파일입니다.");


/*var var1= 1;
var var2 = "second";

var controller = $.extend(new $.CommonObj(),{
	eventInit:function(){
		//.do 화면이동
		$(document).on("click","#id",function(e){
			alert("버튼을 클릭하셨습니다.");
		});
		// .json 데이터교환 
		$(document).on("click","#rgstrBtn",function(e){
			var data = { 
			"accountId": '476***-0*-167***'
			, "bankName": "국민"
			, "balance": 9900 };
			
			$.ajax({
				url:"/test.json",
				type:"post",
				data:data,
				dataType:"json",
				success:function(data){
					console.log("성공");
				},error:function(){
					
				}
			})
		});
	},onCreate :function(){
		
	},func1:function(){
		
	}
});
$(document).ready(function(){
	controller.init();
});
function func2(){
}*/
$(document).ready(function(){
	//test
	$(document).on("click","#rgstrBtn",function(e){
		var data = { 
		"accountId": '476***-0*-167***'
		, "bankName": "국민"
		, "balance": 9900 };
		
		$.ajax({
			url:"test.json",
			type:"post",
			data:JSON.stringify(data),
			contentType:"application/json",
			dataType:"json",
			success:function(rslt){
				console.log("성공");
				console.log(rslt);
			},error:function(){
				
			}
		})
	});
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
				showAccountList();
			}
		}
		
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
			var html ='<ul>';
			//for(data in rslt){
			for(var i=0; i<rslt.length;i++){
				html+='<li accountId='+rslt[i].accountId+'>'+rslt[i].bankName+'은행 ('+rslt[i].accountId+') : '+rslt[i].balance+' 원'
				//html+='<li>'+rslt[data].bankName+'은행 ('+rslt[data].accountId+') : '+rslt[data].balance+' 원'
				+'<p> <select name="updateOption">'
				+'<option value="plus">더하기</option>'
				+'<option value="minus">빼기</option>'
				+'</select></p>'
				+'<p>금액 : <input type="text" name="balance"/></p>'
				+'<a href="#" id="updateBtn">업데이트하기</a>';
				+'</li>';
			}
			html+='</ul>';
			$('#accountlist').html(html);
		}
	})
}
function balancePlus(){
	var accountId = $('div[id=accountlist]>ul>li').attr('accountId');
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
function balanceMinus(){}