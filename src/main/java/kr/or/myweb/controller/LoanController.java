package kr.or.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.myweb.dto.LoanDto;
import kr.or.myweb.dto.LoginDto;
import kr.or.myweb.service.LoanService;

@Controller
public class LoanController {
	private final LoanService loanService;
	@Autowired
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	@GetMapping(path="/loan/loanMain.do")
	public String doLoanMain(HttpSession httpSession) {
		return "loan/loanMain";
	}
	@GetMapping(path="/loan/loanlist.json")
	@ResponseBody
	public List<LoanDto> jsonLoanList(){
		int totalCnt =  loanService.getLoanTotalCnt();
		List<LoanDto> loanlist = loanService.getLoanList(0,totalCnt);
		return loanlist;
	}
	@GetMapping(path="/loan/loanUpdate/{id}")
	public String doLoanUpdate(HttpSession httpsession, @PathVariable("id")Long id) {
		System.out.println(id);
		return "loan/loanUpdate";
	}
	@PutMapping(path="/loan/loanUpdate/{id}")
	public String putLoanUpdate(@PathVariable("id")String id, @RequestBody LoanDto loanDto ) {
		return "jsonView";
	}
	@GetMapping(path="/loan/loanRegister")
	public String loanRegister(HttpSession httpsession) {		
		return "loan/loanRegister";
	}
	@PostMapping(path="loan/loanRegister/{lender}")
	public String postLoanRegister(HttpSession httpsession,@PathVariable("lender")String lender, @RequestBody LoanDto loandto){
		System.out.println("postLoanRegister");
		
		LoginDto loginDto= (LoginDto) httpsession.getAttribute("loginDto");
		Long userId = loginDto.getId();
		loandto.setUserId(userId);
		
		System.out.println(lender);
		System.out.println(loandto.getLender());
		System.out.println(loandto.getAmount());
		System.out.println(loandto.getRepayDate());

		Long id = loanService.registerLoan(loandto);
		return "jsonView";
	}
}
