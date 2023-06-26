package kr.or.myweb.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.myweb.config.ApplicationConfig;
import kr.or.myweb.service.BankAccountService;

public class BankAccountServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		BankAccountService bankAccountService = ac.getBean(BankAccountService.class);
		
		String nowTime = bankAccountService.getTime();
		System.out.println("현재 시간은"+nowTime+"입니다.");
	}

}
