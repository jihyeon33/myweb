package kr.or.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyWalletController {
	@GetMapping(path="/main.do")
	public String doMain() {
		return "main";
	}

}
