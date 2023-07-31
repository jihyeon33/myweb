package kr.or.myweb.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.myweb.dto.BankAccountDto;
import kr.or.myweb.dto.LoginDto;
import kr.or.myweb.service.BankAccountService;

@Controller
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }
///////TEST용 코드,, 정상 동작///////////////////////////////////////////////////////////////////////////////////////////////////    
    @GetMapping(path = "/test")
    public String test(ModelMap model) throws Exception {
        String time = bankAccountService.getTime();
        model.addAttribute("time", time);
        return "list";
    }
    @PostMapping(path="/bank/test.json")
    @ResponseBody
    public List<BankAccountDto> jsonTest(@RequestBody BankAccountDto bankAccountDto){
    	System.out.println(bankAccountDto.getAccountId());
    	System.out.println(bankAccountDto.getBankName());
    	System.out.println(bankAccountDto.getBalance());
        //List<BankAccountDto> list = new ArrayList<BankAccountDto>();
    	List<BankAccountDto> list = bankAccountService.getAccountList(0, 2);
        
        return list;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////    
    @GetMapping(path = "/bank/bankMain.do")
    public String doBankMain(HttpSession httpSession, RedirectAttributes rttr,ModelMap model) throws Exception {

		String time =bankAccountService.getTime();
		LoginDto loginDto= (LoginDto) httpSession.getAttribute("loginDto");
		String userName=loginDto.getUserId();
		model.addAttribute("time", time);
		model.addAttribute("userName", userName);
		
		//총 계좌 수
		int totalCnt= bankAccountService.getAccountsTotalCnt();
		//총 잔액
		BigDecimal totalBalance = new BigDecimal(0);
    	List<BankAccountDto> accountlist= bankAccountService.getAccountList(0, totalCnt);
    	for(BankAccountDto account :accountlist) {
    		totalBalance =totalBalance.add(account.getBalance());
    	}
    	model.addAttribute("totalCnt", totalCnt);
    	model.addAttribute("totalBalance", totalBalance);
		
        return "bank/bankMain"; 
    }
    @GetMapping(path="/bank/accountlist.json")
    @ResponseBody
    public List<BankAccountDto> jsonGetAccountlist(){
    	int totalAccountsCnt= bankAccountService.getAccountsTotalCnt();
    	List<BankAccountDto> accountlist= bankAccountService.getAccountList(0, totalAccountsCnt);
    	return accountlist;
    }
    @PostMapping(path="/bank/accountRegister.json")
    public String jsonAccountRegister(BankAccountDto bankAccountDto){
    	bankAccountService.registerAccount(bankAccountDto);
    	return "bank/bankMain";
    }

    @PostMapping(path="/bank/balancePlus.json")
    @ResponseBody
    public BigDecimal jsonBalancePlus(@RequestBody BankAccountDto bankAccountDto) {
    	BigDecimal balance= bankAccountDto.getBalance();
    	String accountId = bankAccountDto.getAccountId();
    	String option="plus";    	
    	bankAccountService.updateBalance(option,accountId,balance);
    	return balance;
    }
    @PostMapping(path="/bank/balanceMinus.json")
    @ResponseBody
    public BigDecimal jsonBalanceMinus(@RequestBody BankAccountDto bankAccountDto) {
    	BigDecimal balance= bankAccountDto.getBalance();
    	String accountId=bankAccountDto.getAccountId();
    	String option="minus";  	
    	bankAccountService.updateBalance(option, accountId, balance);
    	return balance;
    }
    @PostMapping(path="/bank/accountDelete.json")
    @ResponseBody
    public int jsonAccountDelete(@RequestBody BankAccountDto bankAccountDto) {
    	String accountId=bankAccountDto.getAccountId();
    	int cnt = bankAccountService.deleteAccount(accountId);
    	return cnt;
    	
    }
}
