package kr.or.myweb.controller;

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
    
    @GetMapping(path = "/test")
    public String test(ModelMap model) throws Exception {
        String time = bankAccountService.getTime();
        model.addAttribute("time", time);
        return "list";
    }
    @GetMapping(path = "/bank/bankMain.do")
    public String test(HttpSession httpSession, RedirectAttributes rttr,ModelMap model) throws Exception {

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
    public BankAccountDto accountRegister(BankAccountDto bankAccountDto){
    	BankAccountDto dto = new BankAccountDto();
    	System.out.println(bankAccountDto.getAccountId());
    	System.out.println(bankAccountDto.getBankName());
    	System.out.println(bankAccountDto.getBalance());
        
    	dto.setBankName(bankAccountDto.getBankName());
    	dto.setAccountId(bankAccountDto.getAccountId());
    	dto.setBalance(bankAccountDto.getBalance());
    	
        
        return dto;
    }
}
