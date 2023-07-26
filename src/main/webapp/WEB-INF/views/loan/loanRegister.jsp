<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>xx님 반값습니다.</div>
	<div>
		대출하신 정보를 입력해 주세요.
		<p><input type="text" name="lender" value="대출처"/></p>
		<p><input type="text" name="lender" value="대출금"/></p>
		<p><input type="text" name="lender" value="상환예정일"/></p>
		<button type="button" id="registerBtn">추가하기</button>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/loan/loanRegister.js"></script>
</body>
</html>