package kr.or.myweb.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.myweb.config.ApplicationConfig;
import kr.or.myweb.dto.BankAccountDto;

public class BankAccountDaoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		BankAccountDao bankAccountDao = ac.getBean(BankAccountDao.class);
		
		//insert  테스트 성공
/*		BankAccountDto accountDto = new BankAccountDto();
		accountDto.setAccountId("476***-0*-168***");
		accountDto.setBankName("우리");
		accountDto.setRegDate(new Timestamp(System.currentTimeMillis()));
		
		Long id = bankAccountDao.insertBankAccount(accountDto);
		System.out.println(id);*/
		
		//selectCnt  테스트성공
/*		int count = bankAccountDao.selectCnt();	
		System.out.println(count); */
		
		//delete 테스트성공
/*		int cnt = bankAccountDao.deleteByAccountId("476***-0*-168***");
		System.out.println(cnt);*/
		
		//selectAll 테스트성공
		List<BankAccountDto> accounts= new ArrayList<>();
		accounts = bankAccountDao.selectBankAccounts(0, 3);
		for(BankAccountDto dto : accounts) {
			System.out.println(dto.getId());
		}
	}

}
