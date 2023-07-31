package kr.or.myweb.dao;

public class BankAccountSqls {
	public static final String SELECT_ALL = "select id, account_id, bank_name, balance, reg_date, update_date from bank_account order by id desc limit :start, :limit";
	public static final String DELETE_BY_ACCOUNT_ID = "delete from bank_account where account_id= :accountId";
	public static final String SELECT_TOTAL_COUNT = "select count(*) from bank_account";
	public static final String SELECT_NOW_TIME = "select sysdate() from dual";
	public static final String SELECT_BY_ACCOUNT_ID="select id, account_id, bank_name, balance, reg_date, update_date from bank_account where account_id= :accountId";
	public static final String UPDATE_BY_ACCOUNT_ID="update bank_account set balance= :balance where account_id = :accountId";
}
