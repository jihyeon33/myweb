package kr.or.myweb.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.myweb.dto.StockDto;
import kr.or.myweb.service.StockService;

@Controller
public class StockController {
	private final StockService stockService;
	
	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	@GetMapping(path="/stock/stockMain.do")
	public String doStockMain() {
		return "stock/stockMain";
	}
	@GetMapping(path="/stock/stockList.json")
	@ResponseBody
	public List<StockDto> getStockList(){
		int totalCnt = stockService.getTotalStockCnt();
		List<StockDto> stocklist = stockService.getStockList(0, totalCnt);
		return stocklist;
	}
	@DeleteMapping(path="/stock/stockDelete.json")
	@ResponseBody
	public int deleteStock(@RequestBody StockDto stockDto) {
		Long itemId = stockDto.getId();
		System.out.println(itemId);
		int cnt = stockService.deleteStock(itemId);
		System.out.println(cnt);
		return cnt;
	}
	@GetMapping(path="/stock/stockRegister.do")
	public String doStockRegister() {
		return "stock/stockRegister";
	}
	@PostMapping(path="/stock/stockRegister.json")
	@ResponseBody
	public int stockRegister(@RequestBody StockDto stockDto) {
		System.out.println("레지스터호출");
		System.out.println(stockDto.getItem());
		System.out.println(stockDto.getPrchsAmnt());
		System.out.println(stockDto.getRtnQnty());
		//총 매수금액 = 매수단가 x 매수량
		BigDecimal prchsAmnt = stockDto.getPrchsAmnt();
		int rtnQnty = stockDto.getRtnQnty();
		prchsAmnt= prchsAmnt.multiply(new BigDecimal(rtnQnty));
		
		stockDto.setPrchsAmnt(prchsAmnt);
		stockDto.setUserId(new Long(1));
		Long id = stockService.insertStock(stockDto);
		return 1;
	}
	@GetMapping(path="/stock/stockUpdate.do")
	public String doStockUpdate(@ModelAttribute StockDto stockDto) {
		String item = stockDto.getItem();
		System.out.println("요청들어옴");
		System.out.println(item);
		return "stock/stockUpdate";
	}
	@PutMapping(path="/stock/bought.json")
	public int stockBought() {
		return 0;
	}
	@PutMapping(path="/stock/sold.json")
	public int stockSold() {
		return 0;
	}


}
