package kr.or.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.mapper.BankAccountMapper;
import kr.or.myweb.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountMapper bankAccountMapper;

    @Autowired
    public BankAccountServiceImpl(BankAccountMapper bankAccountMapper){
        this.bankAccountMapper = bankAccountMapper;
    }
    @Override
	public String getTime() throws Exception{
		return bankAccountMapper.getTime();
	}
}
