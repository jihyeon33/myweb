package kr.or.myweb.wallet.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.myweb.wallet.config.ApplicationConfig;
import kr.or.myweb.wallet.dao.RoleDao;
import kr.or.myweb.wallet.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao roleDao= ac.getBean(RoleDao.class);
		Role role = new Role();
		role.setRoleId(201);
		//update
		role.setDescription("programmer3");		
		int updatecnt = roleDao.update(role);
		System.out.println(updatecnt+"건 수정하였습니다.");
	}

}
