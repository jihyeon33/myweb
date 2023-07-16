console.log("bankMain.js파일입니다.");

//.do 화면이동

// .json 데이터교환 

var var1= 1;
var var2 = "second";

var controller = $.extend(new $.CommonObj(),{
	eventInit:function(){
		$(document).on("click","#id",function(e){
			
		});
	},onCreate :function(){
		
	},func1:function(){
		
	}
});
$(document).ready(function(){
	controller.init();
});
function func2(){
}