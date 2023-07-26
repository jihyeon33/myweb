package kr.or.myweb.service.impl;

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
		int totalCnt = loanDao.selectLoanCnt();
		return totalCnt;
	}
	@Override
	public List<LoanDto> getLoanList(Integer start, Integer limit) {
		List<LoanDto> loanlist = loanDao.getLoanList(start, limit);
		return loanlist;
	}

}
