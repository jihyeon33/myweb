package kr.or.myweb.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.myweb.dto.BankAccountDto;
import kr.or.myweb.dto.LoanDto;
import kr.or.myweb.dto.StockDto;

import static kr.or.myweb.dao.MyWalletDaoSqls.*;

@Repository
public class MyWalletDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<BankAccountDto> b_rowMapper = BeanPropertyRowMapper.newInstance(BankAccountDto.class);
	private RowMapper<StockDto> s_rowMapper = BeanPropertyRowMapper.newInstance(StockDto.class);
	private RowMapper<LoanDto> l_rowMapper = BeanPropertyRowMapper.newInstance(LoanDto.class);
	
	public MyWalletDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	//selectNowTime
	public String selectNowTime() {
		String time = jdbc.queryForObject(SELECT_NOW_TIME, Collections.emptyMap(), String.class);
		return time;
	}
	//select bank Cnt
	public int selectBankTotalCnt() {
		int cnt =0;
		cnt = jdbc.queryForObject(SELECT_BANK_TOTAL_COUNT, Collections.emptyMap(), Integer.class);
		return cnt;
	}
	//select bank list
	public List<BankAccountDto> selectBankAccounts(Integer start,Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		List<BankAccountDto> accounts = jdbc.query(SELECT_BANK_LIST, params, b_rowMapper);
		return accounts;
	}
	//select stock Cnt
	public int selectStockTotalCnt() {
		int totalCnt = jdbc.queryForObject(SELECT_STOCK_TOTAL_CNT,Collections.emptyMap(), Integer.class);
		return totalCnt;
	}
	//select stock list
	public List<StockDto> selectStockList(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start",start);
		params.put("limit",limit);
		List<StockDto> stocklist = jdbc.query(SELECT_STOCK_LIST, params,s_rowMapper);
		return stocklist;
	}
	//select loan totalCnt
	public int selectLoanTotalCnt() {
		int totalCnt = jdbc.queryForObject(SELECT_LOAN_TOTAL_CNT,Collections.emptyMap(), Integer.class);
		return totalCnt;
	}
	//select loan list
	public List<LoanDto> selectLoanList(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start",start);
		params.put("limit",limit);
		List<LoanDto> loanlist = jdbc.query(SELECT_LOAN_LIST, params,l_rowMapper);
		return loanlist;
	}
}
