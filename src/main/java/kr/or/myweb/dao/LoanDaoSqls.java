package kr.or.myweb.dao;

public class LoanDaoSqls {
	//selectlist
	public static final String SELECT_LIST ="select id, user_id, lender, amount, repay_date, reg_date, update_date from loan_amount order by id desc limit :start, :limit";	
	//selectCnt
	public static final String SELECT_TOTAL_CNT ="select count(*) from loan_amount";
	//selectOne
	public static final String SELECT_ONE_BY_ITEM ="select id, user_id, lender, amount, repay_date, reg_date, update_date from loan_amount where lender=:lender";
	//updateOne
	public static final String UPDATE_ONE_BY_ITEM ="update loan_amount set amount=:amount, repay_date=:repayDate, update_date =sysdate() where lender=:lender";
	//deleteOne
	public static final String DELETE_ONE_BY_ITEM ="delete from loan_amount where lender=:lender";
	
}
