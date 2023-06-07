package kr.or.myweb.wallet.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kr.or.myweb.wallet.dto.Role;
import static kr.or.myweb.wallet.dao.RoleDaoSqls.*;
@Repository
public class RoleDao {
	private NamedParameterJdbcTemplate jdbc;
	public RoleDao(DataSource dataSource) {
		this.jdbc= new NamedParameterJdbcTemplate(dataSource);
	}
	public List<Role> selectAll(){
		return null;
	}
	public int insert(Role role) {
		return 0;
	}

	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		int cnt =jdbc.update(UPDATE, params);
		return cnt;
	}
	public int deleteById(int id) {
		return 0;
	}
	public int selectById(int id) {
		return 0;
	}
}
