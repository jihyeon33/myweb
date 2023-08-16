package kr.or.myweb.dao;

public class MyWalletDaoSqls {
	public static final String SELECT_NOW_TIME = "select sysdate() from dual";
	public static final String SELECT_BANK_TOTAL_COUNT="select count(*) from bank_account";
	public static final String SELECT_BANK_LIST="select id, account_id, bank_name, balance, reg_date, update_date from bank_account order by id desc limit :start, :limit";
	public static final String SELECT_STOCK_TOTAL_CNT="select count(*) from stock_holding";
	public static final String SELECT_STOCK_LIST="select id, user_id, item, rtn_qnty, prchs_amnt, reg_date, update_date from stock_holding order by id desc limit :start, :limit";
	public static final String SELECT_LOAN_TOTAL_CNT="select count(*) from loan_amount";
	public static final String SELECT_LOAN_LIST="select id, user_id, lender, amount, repay_date, reg_date, update_date from loan_amount order by id desc limit :start, :limit";
}
