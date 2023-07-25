package kr.or.myweb.dao;

public class StockDaoSqls {
	//selectlist
	public static final String SELECT_LIST ="select id, user_id, item, rtn_qnty, prchs_amnt, reg_date, update_date from stock_holding order by id desc limit :start, :limit";	
	//selectCnt
	public static final String SELECT_TOTAL_CNT ="select count(*) from stock_holding";
	//selectOne
	public static final String SELECT_ONE_BY_ITEM ="select id, user_id, item, rtn_qnty, prchs_amnt, reg_date, update_date from stock_holding where item=:item";
	//updateOne
	public static final String UPDATE_ONE_BY_ITEM ="update stock_holding set rtn_qnty=:rtnQnty, prchs_amnt=:prchsAmnt, update_date =sysdate() where item=:item";
	//deleteOne
	public static final String DELETE_ONE_BY_ITEM ="delete from stock_holding where id=:id";
	
}
