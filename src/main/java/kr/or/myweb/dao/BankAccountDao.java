package kr.or.myweb.dao;

//import java.util.ArrayList;
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

import kr.or.myweb.dto.BankAccountDto;
import static kr.or.myweb.dao.BankAccountSqls.*;
@Repository
public class BankAccountDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<BankAccountDto> rowMapper = BeanPropertyRowMapper.newInstance(BankAccountDto.class);
	
	public BankAccountDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("bank_account").usingGeneratedKeyColumns("id");
	}
	//select
	public List<BankAccountDto> selectBankAccounts(Integer start,Integer limit){
//		List<BankAccountDto> accounts = new ArrayList<BankAccountDto>();
		Map<String,Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		List<BankAccountDto> accounts = jdbc.query(SELECT_ALL, params, rowMapper);
		return accounts;
	}
	//insert
	public Long insertBankAccount(BankAccountDto bankAccountDto) {
		Long id ;
		SqlParameterSource params= new BeanPropertySqlParameterSource(bankAccountDto);
		id = insertAction.executeAndReturnKey(params).longValue();
		return id;
	}
	//delete
	public int deleteByAccountId(String accountId) {
		int cnt =0;
		Map<String,String> params = Collections.singletonMap("accountId", accountId);
		cnt = jdbc.update(DELETE_BY_ACCOUNT_ID, params);
		return cnt;
	}
	//update
	
	//selectCnt
	public int selectCnt() {
		int cnt =0;
		cnt = jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
		return cnt;
	}
	//selectNowTime
	public String selectNowTime() {
		String time = jdbc.queryForObject(SELECT_NOW_TIME, Collections.emptyMap(), String.class);
		return time;
	}
	//selectByAccountId
	public BankAccountDto selectByAccountId(String accountId) {
		Map<String,String> params = Collections.singletonMap("accountId", accountId);
		BankAccountDto bankAccountDto = jdbc.queryForObject(SELECT_BY_ACCOUNT_ID, params, rowMapper);
		return bankAccountDto;
	}

}
