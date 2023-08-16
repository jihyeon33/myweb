package kr.or.myweb.service;

import java.math.BigDecimal;
import java.util.List;

import kr.or.myweb.dto.LoanDto;

public interface LoanService {
	public int getLoanTotalCnt();
	public List<LoanDto> getLoanList(Integer start, Integer limit);
	public Long registerLoan(LoanDto loanDto);
	public LoanDto getLoan(Long id);
	public int moreLoan(LoanDto loanDto);
	public int repayLoan(LoanDto loanDto);
	public BigDecimal getLoanTotalAmount();
	public int deleteLoan(Long id);
}
