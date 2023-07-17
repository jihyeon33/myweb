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
});