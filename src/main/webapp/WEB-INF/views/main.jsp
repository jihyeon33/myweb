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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<h1>Hello, Nice to meet you!</h1>
	<h2>접속하신 현재 시간은 ${time} 입니다.</h2>
	<div class="dropdown">
	  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	    ${userName}님 반갑습니다.
	  </button>
	  <ul class="dropdown-menu">
	    <li><a class="dropdown-item" href="#">My page</a></li>
	    <li><a class="dropdown-item" href="logut.do">Logout</a></li>
	  </ul>
	</div>
	<h3>어떤 서비스를 이용하고 싶으신가요?</h3>
	<div class="card" style="width: 18rem;">
	  <img src="..." class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title">Bank</h5>
	    <p class="card-text">manage your bank accounts.</p>
	    <a href="bank/bankMain.do" class="btn btn-primary">Go somewhere</a>
	  </div>
	</div>
</body>
</html>