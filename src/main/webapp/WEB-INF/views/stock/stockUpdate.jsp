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
'<span id="item">${stockDto.item}</span>'에 대하여 업데이트 합니다.
</div>

<div>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">항목</th>
	      <th scope="col">보유수량</th>
	      <th scope="col">총 매수금액</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">${stockDto.item}</th>
	      <td><span id="rtnQnty"></span></td>
	      <td><span id="prchsAmnt"></span></td>
	    </tr>
	  </tbody>
	</table>
</div>

<div class="p-3 mb-2 bg-info text-dark bg-opacity-50">
	추가로 매수한 정보를 입력해 주세요. ('매수 단가' 입력란에는 주식의 1개 가격을 입력하심 됩니다.)
	<p>매수 단가 : <input type="text" name="amount" value="예시) 120000"/>원</p>
	<p>매수 수량 : <input type="text" name="volume" value="예시) 3"/>개</p>
	<a href="#" id="buyBtn">완료</a>
</div>

<div class="p-3 mb-2 bg-info text-dark bg-opacity-50">
	매도한 정보를 입력해 주세요. ('매도 단가' 입력란에는 주식의 1개 가격을 입력하심 됩니다.)
	<p>매도 단가 : <input type="text" name="amount" value="예시) 120000"/>원</p>
	<p>매도 수량 : <input type="text" name="volume" value="예시) 3"/>개</p>
	<a href="#" id="sellBtn">완료</a>
</div>

<a href="stockMain.do">stock메인 페이지로 이동하기</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../resources/static/js/stock/stockUpdate.js"></script>
</body>
</html>