<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
		${loginDto.userId}님이 보유하신 계좌는 총 <span id="totalCnt">${totalCnt}</span>개 입니다. <br/>
		보유 잔액은 총 <span id="totalBalance">${totalBalance}</span>원 입니다.
	</div>
	
	<div id="accountlist"></div>

	<div class="p-3 mb-2 bg-warning text-dark bg-opacity-50">
		계좌를 추가로 등록하시겠습니까?
		<p>은행 : 
			<select name="bankName">
				<option value="국민">국민은행</option>
				<option value="신한">신한은행</option>
				<option value="우리">우리은행</option>
				<option value="농협">농협은행</option>
				<option value="수협">수협은행</option>
				<option value="부산">부산은행</option>
				<option value="광주">광주은행</option>
				<option value="카카오">카카오뱅크</option>
			</select>
		</p>
		<p>계좌 번호 : <input type="text" name="accountId"/></p>
		<p>잔액 : <input type="text" name="balance" value="예) 510000"/></p>
		<input type="button" value="등록하기" id="registerBtn"/>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="../resources/static/js/bank/bankMain.js"></script>
</body>
</html>