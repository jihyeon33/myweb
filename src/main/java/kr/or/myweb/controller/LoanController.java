package kr.or.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoanController {
	@GetMapping(path="/loan/loanMain.do")
	public String doLoanMain() {
		return "loan/loanMain";
	}
	@GetMapping(path="/loan/loanUpdate.do")
	public String doLoanUpdate() {
		return "loan/loanUpdate";
	}

}
