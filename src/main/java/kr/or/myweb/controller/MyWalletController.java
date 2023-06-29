package kr.or.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.myweb.dto.LoginDto;
import kr.or.myweb.service.BankAccountService;

@Controller
public class MyWalletController {
	@Autowired
	BankAccountService bankAccountService;
	@GetMapping(path="/main.do")
	public String doMain(HttpSession session, ModelMap model) {
		String time =bankAccountService.getTime();
		LoginDto loginDto= (LoginDto) session.getAttribute("loginDto");
		String userName=loginDto.getUserId();
		model.addAttribute("time", time);
		model.addAttribute("userName", userName);
		return "main";
	}

}
