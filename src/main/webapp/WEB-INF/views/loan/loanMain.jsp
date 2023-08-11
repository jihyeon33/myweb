<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="dropdown">
	  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	    ${loginDto.userId}님 반갑습니다.
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#">My page</a></li>
	    <li><a class="dropdown-item" href="logut.do">Logout</a></li>
	  </ul>
	</div>
	
	<div class="alert alert-info" role="alert">
		${loginDto.userId}님이 갚아야 할 총 대출잔액은 <span id="totalamount"></span>원 입니다.
	</div>
	<div id = "loanlist"></div>
	<div><button id='updateBtn'>업데이트하기</button></div>
	
	<div class="p-3 mb-2 bg-warning text-dark bg-opacity-50">
		신규로 대출하신 내역이 있으십니까? 추가 등록 페이지에서 변경사항을 등록해주세요.
		<a href="loanRegister">등록하기</a>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/loan/loanMain.js"></script>
</body>
</html>