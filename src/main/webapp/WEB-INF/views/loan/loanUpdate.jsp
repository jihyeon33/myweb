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
<input type="hidden" id="loanId" value="${loandto.id}"/>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    ${loginDto.userId}님 반갑습니다.
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">My page</a></li>
    <li><a class="dropdown-item" href="#">Logout</a></li>
  </ul>
</div>
<div>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">대출처</th>
	      <th scope="col">대출금액</th>
	      <th scope="col">상환일자</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">${loandto.lender}</th>
	      <td><span id="amount">${loandto.amount}</span></td>
	      <td><span id="repayDate">${loandto.repayDate}</span></td>
	    </tr>
	  </tbody>
	</table>
</div>
<div>
	<nav class="navbar bg-light">
	  <form class="container-fluid justify-content-start">
	    <button class="btn btn-outline-success me-2" type="button" id="moreBtn">추가로 대출하셨나요?</button>
	    <button class="btn btn-outline-success me-2" type="button" id="repayBtn">대출을 상환하셨나요?</button>
	  </form>
	</nav>
</div>
<div class="p-3 mb-2 bg-success text-dark bg-opacity-50" style="display:none" id="more">
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">대출처:</span>
	  <input type="text" id="lender" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" value="${loandto.lender}">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text">대출금액:</span>
	  <input type="text" id="amount" class="form-control" aria-label="Amount (to the nearest dollar)">
	  <span class="input-group-text">원</span>
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text">상환 예정 일자:</span>
	  <input type="text" id="repayDate" class="form-control" aria-label="Amount (to the nearest dollar)">
	  <span class="input-group-text">2025-03-01 00:00:00와 같은 형식으로 년도 및 날짜를 자리수에 맞게 채워주세요.</span>
	</div>
	<button type="button" id="moreUpdateBtn">업데이트</button>
</div>
<div class="p-3 mb-2 bg-info text-dark bg-opacity-50" style="display:none" id="repay">
	<div class="input-group mb-3">
	  <span class="input-group-text" id="basic-addon1">대출처:</span>
	  <input type="text" id="lender" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" value="${loandto.lender}">
	</div>
	<div class="input-group mb-3">
	  <span class="input-group-text">상환금액:</span>
	  <input type="text" id="amount" class="form-control" aria-label="Amount (to the nearest dollar)">
	  <span class="input-group-text">원</span>
	</div>
	<button type="button" id="repayUpdateBtn">업데이트</button>
</div>
<a href="./../loanMain">loanMain 페이지로 이동하기</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script src="/myweb/resources/static/js/loan/loanUpdate.js"></script> -->
<script src="/resources/static/js/loan/loanUpdate.js"></script>
</body>
</html>