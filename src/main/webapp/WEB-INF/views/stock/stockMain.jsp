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
    ${userName}님 반갑습니다.
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">My page</a></li>
    <li><a class="dropdown-item" href="logut.do">Logout</a></li>
  </ul>
</div>

<div class="alert alert-info" role="alert">
${userName}님은 총 <span id="totalCnt">${totalCnt}</span>개 종목을 보유하고 계십니다.
총 매수금액: <span id="totalAmount">${totalAmount}</span>원
</div>

<div id="stocklist">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">항목</th>
	      		<th scope="col">보유수량</th>
	      		<th scope="col">총 매수금액</th>
	      		<th scope="col"></th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  	</tbody>
	</table>
</div>

<div class="card w-75">
  <div class="card-body">
    <p class="card-text">
    신규 매수하신 항목이 있으십니까?<br/>
    등록하기 페이지에서 신규항목을 등록해 주세요.<br/>
    </p>
    <a href="stockRegister.do" class="btn btn-primary">등록하기</a>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="../resources/static/js/stock/stockMain.js"></script>
</body>
</html>