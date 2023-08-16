package kr.or.myweb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.MyWalletDao;
import kr.or.myweb.dto.BankAccountDto;
import kr.or.myweb.dto.LoanDto;
import kr.or.myweb.dto.StockDto;
import kr.or.myweb.service.MyWalletService;
@Service
public class MyWalletServiceImpl implements MyWalletService {
	private final MyWalletDao myWalletDao;
	
	@Autowired
	public MyWalletServiceImpl(MyWalletDao myWalletDao) {
		this.myWalletDao= myWalletDao;
	}
	
    @Override
	public String getTime(){
		return myWalletDao.selectNowTime();
	}
	@Override
	public BigDecimal getTotalAmount() {
		BigDecimal totalAmount = new BigDecimal(0);
		
		int bankTotalcnt = myWalletDao.selectBankTotalCnt();
		List<BankAccountDto> bankAll = myWalletDao.selectBankAccounts(0, bankTotalcnt);
		
		int stockTotalCnt = myWalletDao.selectStockTotalCnt();
		List<StockDto> stockAll= myWalletDao.selectStockList(0, stockTotalCnt);
		
		int loanTotalCnt = myWalletDao.selectLoanTotalCnt();
		List<LoanDto> loanAll = myWalletDao.selectLoanList(0, loanTotalCnt);
		
		for(BankAccountDto dto : bankAll) {
			totalAmount = totalAmount.add(dto.getBalance());
		}
		for(StockDto dto : stockAll) {
			totalAmount= totalAmount.add(dto.getPrchsAmnt());
		}
		for(LoanDto dto: loanAll) {
			totalAmount= totalAmount.subtract(dto.getAmount());
		}

		return totalAmount;
	}
}
