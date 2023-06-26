package kr.or.myweb.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@MapperScan(value="kr.or.myweb.mapper")
public class DBConfig implements TransactionManagementConfigurer {
	
    private final ApplicationContext applicationContext;
    @Autowired
    DBConfig(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    
	private String driverClassName="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/mywebdb?useUnicode=true&characterEncoding=utf8&useSSL=false";
	private String userName="mywebuser";
	private String password="myweb123#";	

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
	
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("kr.or.myweb.dto");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
