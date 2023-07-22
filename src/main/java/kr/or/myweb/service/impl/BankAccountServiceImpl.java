package kr.or.myweb.service.impl;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.BankAccountDao;
import kr.or.myweb.dto.BankAccountDto;
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
    @Override
	public List<BankAccountDto> getAccountList(Integer start,Integer limit){
//		List<BankAccountDto> accountList = new ArrayList<BankAccountDto>();
		List<BankAccountDto> accountList = bankAccountDao.selectBankAccounts(start, limit);
		return accountList;
	}
	@Override
	public int getAccountsTotalCnt() {
		int cnt = bankAccountDao.selectCnt();
		return cnt;
	}
	@Override
	public BankAccountDto getAccountByAccountId(String accountId) {
		BankAccountDto account = bankAccountDao.selectByAccountId(accountId);
		return account;
	}
}
