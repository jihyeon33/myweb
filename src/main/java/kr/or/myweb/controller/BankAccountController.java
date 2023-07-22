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
    @PostMapping(path="/bank/accountRegister.do")
    @ResponseBody
    public BankAccountDto doAccountRegister(BankAccountDto bankAccountDto){
    	BankAccountDto dto = new BankAccountDto();
    	System.out.println(bankAccountDto.getAccountId());
    	System.out.println(bankAccountDto.getBankName());
    	System.out.println(bankAccountDto.getBalance());
        
    	dto.setBankName(bankAccountDto.getBankName());
    	dto.setAccountId(bankAccountDto.getAccountId());
    	dto.setBalance(bankAccountDto.getBalance());
    	
        
        return dto;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////    
    @GetMapping(path = "/bank/bankMain.do")
    public String doBankMain(HttpSession httpSession, RedirectAttributes rttr,ModelMap model) throws Exception {

		String time =bankAccountService.getTime();
		LoginDto loginDto= (LoginDto) httpSession.getAttribute("loginDto");
		String userName=loginDto.getUserId();
		model.addAttribute("time", time);
		model.addAttribute("userName", userName);
        //String myname= httpSession.getAttribute("loginDto");
		
		List<BankAccountDto> accountlist = new ArrayList<BankAccountDto>();
		accountlist = bankAccountService.getAccountList(0, 2);
		model.addAttribute("accountlist",accountlist);
        return "bank/bankMain"; 
    }
    @GetMapping(path="/bank/accountlist.json")
    @ResponseBody
    public List<BankAccountDto> getAccountlist(){
    	int totalAccountsCnt= bankAccountService.getAccountsTotalCnt();
    	List<BankAccountDto> accountlist= bankAccountService.getAccountList(0, totalAccountsCnt);
    	return accountlist;
    }
    @PostMapping(path="/bank/accountRegister.json")
    @ResponseBody
    public BankAccountDto accountRegister(@RequestBody BankAccountDto bankAccountDto) {
    	BankAccountDto dto= null;
    	return dto;
    }
    @PostMapping(path="/bank/balancePlus.json")
    @ResponseBody
    public BigDecimal balancePlus(@RequestBody BankAccountDto bankAccountDto) {
    	BigDecimal balance= bankAccountDto.getBalance();
    	String accountId = bankAccountDto.getAccountId();
    	System.out.println("전송된:"+balance);
    	System.out.println("전송된:"+accountId);
    	BankAccountDto account = bankAccountService.getAccountByAccountId(accountId);
    	BigDecimal balance2 = account.getBalance();
    	System.out.println("디비호출후:"+balance2);
    	balance = balance.add(balance2);
    	System.out.println("연산후:"+balance);
    	return balance;
    }
    @PostMapping(path="/bank/balanceMinus.json")
    public BigDecimal balanceMinus(@RequestBody BankAccountDto bankAccountDto) {
    	BigDecimal balance= bankAccountDto.getBalance();
    	return balance;
    }
}
