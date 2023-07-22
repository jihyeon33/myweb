package kr.or.myweb.service.impl;

import java.math.BigDecimal;
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
	@Override
	public void updateBalance(String option, String accountId, BigDecimal balance) {
    	BankAccountDto account = bankAccountDao.selectByAccountId(accountId);
    	BigDecimal nowBalance = account.getBalance();

    	if(option=="plus") {  //더하기일경우
    		nowBalance = nowBalance.add(balance);
    	}else { //빼기일경우
    		nowBalance = nowBalance.subtract(balance);
    	}   	
		bankAccountDao.updateBalance(accountId,nowBalance);
		return;
	}
	@Override
	public Long registerAccount(BankAccountDto bankAccountDto) {
		Long id = bankAccountDao.insertBankAccount(bankAccountDto);
		return id;
	}
	@Override
	public int deleteAccount(String accountId) {
		int cnt = bankAccountDao.deleteByAccountId(accountId);
		return cnt;
	};
}
