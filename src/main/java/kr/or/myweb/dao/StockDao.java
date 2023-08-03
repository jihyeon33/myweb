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

import kr.or.myweb.dto.StockDto;
import static kr.or.myweb.dao.StockDaoSqls.*;

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
	public List<StockDto> selectStockList(Integer start, Integer limit){
		Map<String,Integer> params = new HashMap<>();
		params.put("start",start);
		params.put("limit",limit);
		List<StockDto> stocklist = jdbc.query(SELECT_LIST, params,rowMapper);
		return stocklist;
	}
	//selectCnt
	public int selectStockTotalCnt() {
		int totalCnt = jdbc.queryForObject(SELECT_TOTAL_CNT,Collections.emptyMap(), Integer.class);
		return totalCnt;
	}
	//selectOne
	public StockDto selectStockOne(String item) {
		Map<String,String> params = Collections.singletonMap("item", item);
		StockDto stock = jdbc.queryForObject(SELECT_ONE_BY_ITEM, params, rowMapper);
		return stock;
	}
	//insertOne
	public Long insertStockOne(StockDto stockDto) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(stockDto);
		Long cnt = insertAction.executeAndReturnKey(params).longValue();
		return cnt;
	}
	//updateOne
	public int updateStockOne(StockDto stockDto) {
		Map<String,Object> params = new HashMap<>();
		params.put("item", stockDto.getItem());
		params.put("rtnQnty", stockDto.getRtnQnty());
		params.put("prchsAmnt", stockDto.getPrchsAmnt());
		int cnt = jdbc.update(UPDATE_ONE_BY_ITEM, params);
		return cnt;
	}
	//deleteOne
	public int deleteStockOne(Long id) {
		Map<String,Long> params= Collections.singletonMap("id", id);
		int cnt = jdbc.update(DELETE_ONE_BY_ITEM, params);
		return cnt;
	}
}
