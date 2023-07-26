package kr.or.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.myweb.dto.LoanDto;
import kr.or.myweb.service.LoanService;

@Controller
public class LoanController {
	private final LoanService loanService;
	@Autowired
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	@GetMapping(path="/loan/loanMain.do")
	public String doLoanMain() {
		return "loan/loanMain";
	}
	@GetMapping(path="/loan/loanlist.json")
	@ResponseBody
	public List<LoanDto> jsonLoanList(){
		int totalCnt =  loanService.getLoanTotalCnt();
		List<LoanDto> loanlist = loanService.getLoanList(0,totalCnt);
		return loanlist;
	}
	@GetMapping(path="/loan/loanUpdate.do")
	public String doLoanUpdate() {
		return "loan/loanUpdate";
	}
	@GetMapping(path="/loan/loanRegister.do")
	public String doLoanRegister() {
		return "loan/loanRegister";
	}

}
