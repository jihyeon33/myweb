package kr.or.myweb.service;

import java.util.List;

import kr.or.myweb.dto.BankAccountDto;

public interface BankAccountService {
	public String getTime();
	public List<BankAccountDto> getAccountList(Integer start,Integer limit);	
	public int getAccountsTotalCnt();
	public BankAccountDto getAccountByAccountId(String accountId);
}
