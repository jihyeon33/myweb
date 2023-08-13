package kr.or.myweb.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {
    
	//private String driverClassName="com.mysql.jdbc.Driver";  //로컬
	//private String url="jdbc:mysql://localhost:3306/mywebdb?useUnicode=true&characterEncoding=utf8&useSSL=false";   //로컬
	//private String url="jdbc:mysql://awseb-e-bf2qcttc27-stack-awsebrdsdatabase-9zwub6ihotoc.c2nmwwkpyqga.ap-northeast-2.rds.amazonaws.com:3306/mywebdb?useUnicode=true&characterEncoding=utf8&useSSL=false"; //aws elastic beanstalk
	//private String userName="mywebuser";  //로컬
	//private String password="myweb123#";  //로컬
	
	private String driverClassName="org.mariadb.jdbc.Driver";  //카페24
	private String url="jdbc:mariadb://umj7-003.cafe24.com:3306/twinhks1?useUnicode=true&characterEncoding=utf8&useSSL=false";  //카페24
	private String userName="twinhks1";     //카페24	
	private String password="twin532899";   //카페24

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return transactionManger();
	}
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}
}
