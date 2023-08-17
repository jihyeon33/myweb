##### 배포 링크 : http://twinhks1.cafe24.com/login/login.do
##### 소스코드 (깃허브 주소) : https://github.com/jihyeon33/myweb
##### 관련 기록 (개인 블로그 주소) : https://jihyeon33.tistory.com/category/%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4%20%28%EC%9B%B9%20%EA%B0%9C%EB%B0%9C%29/%EA%B3%84%EC%A2%8C%EA%B4%80%EB%A6%AC%20%EC%9B%B9%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98
##### 화면 설계서 (ppt자료로 첨부) :[포트폴리오.pptx](https://github.com/jihyeon33/resume/files/12367865/mywallet.pptx)

###  ERD:
- database : twinhks1
- table : user, bank_account, stock_holding, loan_amount

<img src="https://github.com/jihyeon33/resume/assets/61914526/1bb4dfa5-5e01-48d1-9554-e27146c5105e" width="450"/>

### 프로젝트 구조:
- Back-end
  - java Spring framework
  - 구조 : model-view-controller (MVC), controller-service-dao
  - java → jdbcTemplate ← db
- Front-end
  - jsp, javaScript, bootstrap
- DB
  - Mysql , MariaDB
- Server
  - apacheTomcat 8.5.84
- Hosting
   - PAAS 서비스 사용
   - 카페24 > ‘Tomcat Jsp 호스팅’ 서비스 구매 (Tompcat +jdk + mariaDB)


### 화면 구성 및 기능:

##### 첫 화면
- GET - /login/login.do :로그인 화면
- POST -/login/login.do :로그인 처리
- POST -/login/logout.do : 로그아웃 처리

<img src="https://github.com/jihyeon33/resume/assets/61914526/bf7c7114-4f4d-4aed-a5fa-c8746ad08b30" width="650"/>



##### 두번째 화면
- GET - /main.do : 메인 화면

<img src="https://github.com/jihyeon33/resume/assets/61914526/3d02cc57-1449-4c9c-837f-553d2fd0419f" width="650"/>



##### Bank 화면
- GET - /bank/bankMain.do : bank메인 화면
- GET - /bank/accountlist.json : 전체 계좌리스트 조회 ajax
- POST - /bank/accountRegister.json : 신규 계좌 등록 ajax
- POST - /bank/balancePlus.json : 계좌 잔액 업데이트(더하기) ajax
- POST - /bank/balanceMinus.json : 계좌 잔액 업데이트(빼기) ajax
- POST - /bank/accountDelete.json : 계좌 삭제 ajax
- POST - /bank/accountCheck.json : 계좌번호 동일 여부 유효성 체크 ajax
 
<img src="https://github.com/jihyeon33/resume/assets/61914526/798de7d1-f18b-4e01-baaa-44a0177ba969" width="650"/>

##### Stock 화면
- GET - /stock/stockMain.do : stock메인 화면
- GET - /stock/stockList.json : 전체 주식 리스트 조회 ajax
- DELETE - /stock/stockDelete.json :  해당 주식 삭제 ajax
- GET - /stock/stockUpdate.do?item={해당 아이템} : 해당 주식 업데이트 화면으로 이동
- GET - /stock/stockRegister.do : 주식 신규 등록 화면으로 이동

<img src="https://github.com/jihyeon33/resume/assets/61914526/77a09640-9578-46e2-ab16-c870cc978550" width="650"/>



##### stock 업데이트 화면
- GET - /stock/stockInfo.json?item={해당 아이템} : 해당 주식 정보 조회 ajax
- PUT - /stock/bought.json : 주식 매수 정보 업데이트 ajax
- PUT - /stock/sold.json : 주식 매도 정보 업데이트 ajax

<img src="https://github.com/jihyeon33/resume/assets/61914526/34cb52f7-5a81-43a0-bafe-200c305e8da7" width="650"/>
<img src="https://github.com/jihyeon33/resume/assets/61914526/93f9aa12-e76b-4b06-b285-078ac1a3da3e" width="650"/>


##### stock 신규 등록 화면
- POST - /stock/stockRegister.json : 신규 주식 등록 ajax
- POST - /stock/stockItemCheck.json : 주식 항목 기등록 여부 체크 ajax
  
<img src="https://github.com/jihyeon33/resume/assets/61914526/598835c1-58e0-44cb-94e9-a7a8094ee7f0" width="650"/>



##### loan 화면
- GET - /loan/loanMain : 대출 메인화면
- GET - /loan/loanlist.json : 전체 대출 리스트 조회 ajax
- GET - /loan/loanUpdate/{id} : 해당 주식 업데이트 화면으로 이동
- GET - /loan/loanRegister : 신규 대출 내역 등록 화면으로 이동

<img src="https://github.com/jihyeon33/resume/assets/61914526/6396e6a7-8d7b-4862-a84c-720b5f631ad5" width="650"/>



##### loan 업데이트 화면
- GET - loan/loanUpdate/getLoan.json?id={id} : 해당 대출항목 정보 조회 ajax
- PUT - /loan/loanUpdate/{id} : 해당 대출 정보 업데이트 (추가 대출/ 대출 상환)  ajax

<img src="https://github.com/jihyeon33/resume/assets/61914526/07287da0-1dfa-4aec-921f-3e9a631c9921" width="650"/>
<img src="https://github.com/jihyeon33/resume/assets/61914526/b93f6ade-38c2-4379-b281-e4c384326e7d" width="650"/>
<img src="https://github.com/jihyeon33/resume/assets/61914526/e0cef215-a425-4026-b514-8bf5a0a3d1fa" width="650"/>


##### loan 신규등록 화면
- POST - loan/loanRegister.json : 신규 대출 내역 등록 ajax

<img src="https://github.com/jihyeon33/resume/assets/61914526/3f8a3ac5-ccfd-41c4-af8f-ded2fe3c5e01" width="650"/>
