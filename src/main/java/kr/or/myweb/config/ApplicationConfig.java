package kr.or.myweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages= {"kr.or.myweb.dao","kr.or.myweb.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
