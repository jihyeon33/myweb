package kr.or.myweb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.myweb.dto.LoanDto;

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
	//selectCnt
	//selectOne
	//insertOne
	//updateOne
	//deleteOne
}
