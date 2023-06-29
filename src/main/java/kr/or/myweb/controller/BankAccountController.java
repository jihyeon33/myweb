package kr.or.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "bank/bankMain";
    }
}
