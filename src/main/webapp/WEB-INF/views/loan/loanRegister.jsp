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
	    <li><a class="dropdown-item" href="#">Logout</a></li>
	  </ul>
	</div>
	
	<div class="p-3 mb-2 bg-info text-dark bg-opacity-50">
		대출하신 정보를 입력해 주세요.
		<p><input type="text" name="lender" value="대출처"/></p>
		<p><input type="text" name="amount" value="대출금"/></p>
		<p><input type="text" name="repayDate" value="상환예정일"/> 2023-08-10 00:00:00 와 같은 형식으로 자리수를 채워 입력해주세요.</p>
		<button type="button" id="registerBtn">추가하기</button>
	</div>
	<a href="loanMain">loanMain 페이지로 이동하기</a>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/loan/loanRegister.js"></script>
</body>
</html>