package kr.or.myweb.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.myweb.dto.LoanDto;

import static kr.or.myweb.dao.LoanDaoSqls.*;

@Repository
public class LoanDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<LoanDto> rowMapper = BeanPropertyRowMapper.newInstance(LoanDto.class);
	public LoanDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("loan_amount").usingGeneratedKeyColumns("id");	
	}	
	//selectlist
	public List<LoanDto> selectLoanList(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start",start);
		params.put("limit",limit);
		List<LoanDto> loanlist = jdbc.query(SELECT_LIST, params,rowMapper);
		return loanlist;
	}
	//selectCnt
	public int selectLoanTotalCnt() {
		int totalCnt = jdbc.queryForObject(SELECT_TOTAL_CNT,Collections.emptyMap(), Integer.class);
		return totalCnt;
	}
	//selectOne
	public LoanDto selectLoanOne(Long id) {
		Map<String,Long> params = Collections.singletonMap("id", id);
		LoanDto loan = jdbc.queryForObject(SELECT_ONE_BY_ID, params, rowMapper);
		return loan;
	}
	//insertOne
	public Long insertLoanOne(LoanDto loanDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(loanDto);
		Long id = insertAction.executeAndReturnKey(params).longValue();
		return id;
	}
	//updateOne
	public int updateLoanOne(LoanDto loanDto) {
		Map<String,Object> params = new HashMap<>();
		params.put("id",loanDto.getId());
		params.put("amount", loanDto.getAmount());
		params.put("repayDate", loanDto.getRepayDate());
		int cnt = jdbc.update(UPDATE_ONE_BY_ID, params);
		return cnt;
	}
	//deleteOne
	public int deleteLoanOne(Long id) {
		Map<String,Long> params= Collections.singletonMap("id", id);
		int cnt = jdbc.update(DELETE_ONE_BY_ID, params);
		return cnt;
	}
}
