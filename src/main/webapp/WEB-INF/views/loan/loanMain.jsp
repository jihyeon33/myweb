<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	loanMain 입니다.
	<div>xx님 반갑습니다.</div>
	<div>xx님이 갚아야 할 총 대출잔액은 xx입니다.</div>
	<div id = "loanlist">
	</div>
	<div>
		신규로 대출하신 내역이 있으십니까? 추가 등록 페이지에서 변경사항을 등록해주세요.
		<a href="loanRegister.do">등록하기</a>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/loan/loanMain.js"></script>
</body>
</html>