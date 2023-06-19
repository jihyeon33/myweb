package kr.or.myweb.config;

import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

public class DBConfig implements TransactionManagementConfigurer {

	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return null;
	}

}
