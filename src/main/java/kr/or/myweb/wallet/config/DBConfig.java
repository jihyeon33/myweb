package kr.or.myweb.wallet.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	private String driverClassNam="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private String userName="connectuser";
	private String pswd="connect123!@#";
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassNam);
		dataSource.setUrl(url);
		dataSource.setUsername(url);
		dataSource.setPassword(pswd);
		return dataSource;
	}
}
