package kr.or.myweb.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(path="/loan/loanMain")
	public String doLoanMain(HttpSession httpSession) {
		return "loan/loanMain";
	}
	@GetMapping(path="/loan/loanlist.json")
	public String jsonLoanList(Model model){
		int totalCnt =  loanService.getLoanTotalCnt();
		List<LoanDto> loanlist = loanService.getLoanList(0,totalCnt);
		BigDecimal totalAmount = loanService.getLoanTotalAmount();
		model.addAttribute("loanlist",loanlist);
		model.addAttribute("totalAmount",totalAmount);
		return "jsonView";
	}
	@GetMapping(path="/loan/loanUpdate/{id}")
	public String doLoanUpdate(HttpSession httpsession, @PathVariable("id")Long id,Model model) {
		System.out.println(id);
		LoanDto loandto = loanService.getLoan(id);
		model.addAttribute("loandto", loandto);
		return "loan/loanUpdate";
	}
	@PutMapping(path="/loan/loanUpdate/{id}")
	public String putLoanUpdate(@PathVariable("id")String id, @RequestBody LoanDto loanDto, Model model) {
		System.out.println(id);
		System.out.println(loanDto.getUpdateOption());
		System.out.println(loanDto.getLender());
		System.out.println(loanDto.getAmount());
		System.out.println(loanDto.getRepayDate());
		loanDto.setId(Long.parseLong(id));
		int cnt=0;
		if(loanDto.getUpdateOption().equals("m")) {  //추가대출 :m
			cnt =loanService.moreLoan(loanDto);
		}else {  //상환 :p
			cnt =loanService.repayLoan(loanDto);
		}
		model.addAttribute("cnt", cnt);
		return "jsonView";
	}
	@GetMapping(path="/loan/loanRegister")
	public String loanRegister(HttpSession httpsession) {		
		return "loan/loanRegister";
	}
	@PostMapping(path="loan/loanRegister.json")
	public String jsonLoanRegister(HttpSession httpsession, @RequestBody LoanDto loandto){		
		LoginDto loginDto= (LoginDto) httpsession.getAttribute("loginDto");
		Long userId = loginDto.getId();
		loandto.setUserId(userId);

		Long id = loanService.registerLoan(loandto);
		return "jsonView";
	}
	@GetMapping(path="loan/loanUpdate/getLoan.json")
	public String jsonGetLoan(@RequestParam("id")Long id, Model model) {
		System.out.println(id);
		LoanDto loandto = loanService.getLoan(id);
		System.out.println(loandto.getRepayDate());
		model.addAttribute("loandto", loandto);
		return "jsonView";
	}
}
