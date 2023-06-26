package kr.or.myweb.mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan
public interface BankAccountMapper {
	
	public String getTime() throws Exception;

}
