<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
스톡 메인 페이지입니다.
xx님 반갑습니다.
<div>
xx님은 총 x개 종목을 보유하고 계십니다.
총 매수금액: xx원
</div>
<div id="stocklist">
	<ul>
		<li> 애플 보유수량:xx 매수금액:xx</li>
		<li> 테슬라 보유수량:xx 매수금액:xx</li>
		<li> ARKK ETF 보유수량:xx 매수금액:xx</li>
	</ul>
</div>

<div>
신규 매수하신 항목이 있으십니까?<br/>
등록하기 페이지에서 신규항목을 등록해 주세요.<br/>
<a href="stockRegister.do">등록하기</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../resources/static/js/stock/stockMain.js"></script>
</body>
</html>