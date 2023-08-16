package kr.or.myweb.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.myweb.service.MyWalletService;

@Controller
public class MyWalletController {
	@Autowired
	MyWalletService myWalletService;
	@GetMapping(path="/main.do")
	public String doMain(HttpSession session, ModelMap model) {
		String time =myWalletService.getTime();
		model.addAttribute("time", time);
		
		BigDecimal totalAmount = myWalletService.getTotalAmount();
		model.addAttribute("totalAmount", totalAmount);
		return "main";
	}

}
