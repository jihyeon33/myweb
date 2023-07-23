package kr.or.myweb.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.myweb.dto.StockDto;

@Repository
public class StockDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<StockDto> rowMapper = BeanPropertyRowMapper.newInstance(StockDto.class);
	
	public StockDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("stock_holding").usingGeneratedKeyColumns("id");
	}
	//selectlist
	//selectCnt
	//selectOne
	//insertOne
	//updateOne
	//deleteOne


}
