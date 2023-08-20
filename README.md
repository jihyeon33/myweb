##### 배포 링크 : http://twinhks1.cafe24.com/login/login.do
##### 소스코드 (깃허브 주소) : https://github.com/jihyeon33/myweb
##### 관련 기록 (개인 블로그 주소) : https://jihyeon33.tistory.com/category/%ED%8F%AC%ED%8A%B8%ED%8F%B4%EB%A6%AC%EC%98%A4%20%28%EC%9B%B9%20%EA%B0%9C%EB%B0%9C%29/%EA%B3%84%EC%A2%8C%EA%B4%80%EB%A6%AC%20%EC%9B%B9%EC%95%A0%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98
##### 화면 설계서 (ppt자료로 첨부) : [myWallet 기획서.pptx](https://github.com/jihyeon33/myweb/files/12378453/myWallet.pptx)

###  ERD:
- database : twinhks1
- table : user, bank_account, stock_holding, loan_amount

<img src="https://github.com/jihyeon33/myweb/assets/61914526/b2238262-01b3-48ed-9d5f-71174b945aad" width="450"/>

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

<img src="https://github.com/jihyeon33/myweb/assets/61914526/68cc7bd4-8268-4711-b33e-ff837b1d4be0" width="650"/>



##### 두번째 화면
- GET - /main.do : 메인 화면

<img src="https://github.com/jihyeon33/myweb/assets/61914526/da740e4c-bed4-4830-b3db-4285db2a9b3d" width="650"/>



##### Bank 화면
- GET - /bank/bankMain.do : bank메인 화면
- GET - /bank/accountlist.json : 전체 계좌리스트 조회 ajax
- POST - /bank/accountRegister.json : 신규 계좌 등록 ajax
- POST - /bank/balancePlus.json : 계좌 잔액 업데이트(더하기) ajax
- POST - /bank/balanceMinus.json : 계좌 잔액 업데이트(빼기) ajax
- POST - /bank/accountDelete.json : 계좌 삭제 ajax
- POST - /bank/accountCheck.json : 계좌번호 동일 여부 유효성 체크 ajax
 
<img src="https://github.com/jihyeon33/myweb/assets/61914526/ae45ec3d-7d0e-4c07-9fd4-9830dbcf6227" width="650"/>

##### Stock 화면
- GET - /stock/stockMain.do : stock메인 화면
- GET - /stock/stockList.json : 전체 주식 리스트 조회 ajax
- DELETE - /stock/stockDelete.json :  해당 주식 삭제 ajax
- GET - /stock/stockUpdate.do?item={해당 아이템} : 해당 주식 업데이트 화면으로 이동
- GET - /stock/stockRegister.do : 주식 신규 등록 화면으로 이동

<img src="https://github.com/jihyeon33/myweb/assets/61914526/89394928-e6ef-43d3-b01f-79d21badb58f" width="650"/>



##### stock 업데이트 화면
- GET - /stock/stockUpdate.do?item={해당 아이템} : 해당 주식 업데이트 화면
- GET - /stock/stockInfo.json?item={해당 아이템} : 해당 주식 정보 조회 ajax
- PUT - /stock/bought.json : 주식 매수 정보 업데이트 ajax
- PUT - /stock/sold.json : 주식 매도 정보 업데이트 ajax

<img src="https://github.com/jihyeon33/myweb/assets/61914526/6efae5f3-da94-4b40-a1ad-5595122db0f3" width="650"/>
<img src="https://github.com/jihyeon33/myweb/assets/61914526/e0fb2d3e-94b0-4dc6-af4f-dee502bef1a0" width="650"/>


##### stock 신규 등록 화면
- GET - /stock/stockRegister.do : 주식 신규 등록 화면
- POST - /stock/stockRegister.json : 신규 주식 등록 ajax
- POST - /stock/stockItemCheck.json : 주식 항목 기등록 여부 체크 ajax

<img src="https://github.com/jihyeon33/myweb/assets/61914526/9b884fac-b320-4c8f-8b0e-237c44288450" width="650"/>


##### loan 부터는 Restful api를 지키려 노력함.
##### loan 화면
- GET - /loan/loanMain : 대출 메인화면
- GET - /loan/loanlist.json : 전체 대출 리스트 조회 ajax
- GET - /loan/loanUpdate/{id} : 해당 대출 업데이트 화면으로 이동
- GET - /loan/loanRegister : 신규 대출 내역 등록 화면으로 이동
- DELETE - /loan/loanDelete/{id} : 해당 대출 내역 삭제

<img src="https://github.com/jihyeon33/myweb/assets/61914526/c8c0b69e-bdaa-432a-b48c-2572be7c1b9f" width="650"/>



##### loan 업데이트 화면
- GET - /loan/loanUpdate/{id} : 해당 대출 업데이트 화면
- GET - loan/loanUpdate/getLoan.json?id={id} : 해당 대출항목 정보 조회 ajax
- PUT - /loan/loanUpdate/{id} : 해당 대출 정보 업데이트 (추가 대출/ 대출 상환)  ajax

<img src="https://github.com/jihyeon33/myweb/assets/61914526/5a4afd78-360b-4524-9aff-9bbb8c884113" width="650"/>
<img src="https://github.com/jihyeon33/myweb/assets/61914526/e6c5ff94-6402-42f1-a4f8-4308450722fc" width="650"/>
<img src="https://github.com/jihyeon33/myweb/assets/61914526/1c3283fa-1b83-406e-ac81-1a89408f4067" width="650"/>


##### loan 신규등록 화면
- GET - /loan/loanRegister : 신규 대출 내역 등록 화면
- POST - loan/loanRegister.json : 신규 대출 내역 등록 ajax
  
<img src="https://github.com/jihyeon33/myweb/assets/61914526/5631d64d-0dc3-4064-aa65-73dd7e0087fb" width="650"/>
