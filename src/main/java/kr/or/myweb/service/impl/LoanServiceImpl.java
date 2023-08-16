package kr.or.myweb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.LoanDao;
import kr.or.myweb.dto.LoanDto;
import kr.or.myweb.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService {
	private final LoanDao loanDao;
	@Autowired
	public LoanServiceImpl(LoanDao loanDao) {
		this.loanDao = loanDao;
	}
	@Override
	public int getLoanTotalCnt() {
		int totalCnt = loanDao.selectLoanTotalCnt();
		return totalCnt;
	}
	@Override
	public List<LoanDto> getLoanList(Integer start, Integer limit) {
		List<LoanDto> loanlist = loanDao.selectLoanList(start, limit);
		return loanlist;
	}
	@Override
	public Long registerLoan(LoanDto loanDto) {
		Long id = loanDao.insertLoanOne(loanDto);
		return id;
	}
	@Override
	public LoanDto getLoan(Long id) {
		LoanDto loanDto = loanDao.selectLoanOne(id);
		return loanDto;
	}
	@Override
	public int moreLoan(LoanDto loanDto) {
		LoanDto nowLoan= loanDao.selectLoanOne(loanDto.getId());
		BigDecimal amount = nowLoan.getAmount().add(loanDto.getAmount());
		
		LoanDto futureLoan = new LoanDto();
		futureLoan.setId(loanDto.getId());
		futureLoan.setAmount(amount);
		futureLoan.setRepayDate(loanDto.getRepayDate());
		
		int cnt = loanDao.updateLoanOne(futureLoan);
		return cnt;
	}
	@Override
	public int repayLoan(LoanDto loanDto) {
		LoanDto nowLoan= loanDao.selectLoanOne(loanDto.getId());
		BigDecimal amount = nowLoan.getAmount().subtract(loanDto.getAmount());
		
		LoanDto futureLoan = new LoanDto();
		futureLoan.setId(loanDto.getId());
		futureLoan.setAmount(amount);
		futureLoan.setRepayDate(nowLoan.getRepayDate());
		
		int cnt = loanDao.updateLoanOne(futureLoan);
		return cnt;
	}
	@Override
	public BigDecimal getLoanTotalAmount() {
		int totalCnt = loanDao.selectLoanTotalCnt();
		List<LoanDto> loanlist = loanDao.selectLoanList(0, totalCnt);
		BigDecimal totalAmount = new BigDecimal(0);
		for(LoanDto dto : loanlist) {
			totalAmount =totalAmount.add(dto.getAmount());
		}
		return totalAmount;
	}
	@Override
	public int deleteLoan(Long id) {
		int cnt = loanDao.deleteLoanOne(id);
		return cnt;
	}

}
