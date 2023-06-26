package kr.or.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.BankAccountDao;
import kr.or.myweb.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountDao bankAccountDao;

    @Autowired
    public BankAccountServiceImpl(BankAccountDao bankAccountDao){
        this.bankAccountDao = bankAccountDao;
    }
    @Override
	public String getTime(){
		return bankAccountDao.selectNowTime();
	}
}
