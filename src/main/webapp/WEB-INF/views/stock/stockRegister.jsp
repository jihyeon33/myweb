<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
stockRegister 페이지 입니다.
	<div>
		매수 정보를 입력해 주세요. (매수 단가에는 1개 가격을 입력하심 됩니다.)
		<p>매수 항목 : <input type="text" name="item" value="예시) 넷플릭스"/></p>
		<p>매수 단가 : <input type="text" name="amount" value="예시) 120000"/>원</p>
		<p>매수 수량 : <input type="text" name="volume" value="예시) 3"/>개</p>
		<a href="#" id="rgstrBtn">등록하기</a>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/stock/stockRegister.js"></script>
</body>
</html>