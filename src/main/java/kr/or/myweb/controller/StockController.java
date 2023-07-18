package kr.or.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {
	
	@GetMapping(path="/stock/stockMain.do")
	public String doStockMain() {
		return "stock/stockMain";
	}
	@GetMapping(path="/stock/stockRegister.do")
	public String doStockRegister() {
		return "stock/stockRegister";
	}

}
