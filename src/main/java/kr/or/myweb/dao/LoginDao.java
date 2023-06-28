package kr.or.myweb.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.myweb.dto.LoginDto;
import static kr.or.myweb.dao.LoginDaoSqls.*;

@Repository
public class LoginDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<LoginDto> rowMapper = BeanPropertyRowMapper.newInstance(LoginDto.class);
	public LoginDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public LoginDto getUser(String id, String password) {
		Map<String,String> params = new HashMap<>();
		params.put("userId",id);
		params.put("password",password);
		LoginDto loginDto = new LoginDto();
		try{
			loginDto  = jdbc.queryForObject(SELECT_ONE_USER, params, rowMapper);
		}catch(EmptyResultDataAccessException e){
			loginDto = null;
		}
		return loginDto;
	}

}
