package kr.or.myweb.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.myweb.dto.LoginDto;
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
	public String doStockMain(HttpSession httpSession, Model model) {
		LoginDto loginDto= (LoginDto) httpSession.getAttribute("loginDto");
		String userName=loginDto.getUserId();
		model.addAttribute("userName", userName);
		return "stock/stockMain";
	}
	@GetMapping(path="/stock/stockList.json")
	public String jsonGetStockList(Model model){
		int totalCnt = stockService.getTotalStockCnt();
		List<StockDto> stocklist = stockService.getStockList(0, totalCnt);
		BigDecimal totalAmount = stockService.getTotalAmount();
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("stocklist", stocklist);
		model.addAttribute("totalAmount", totalAmount);
		return "jsonView";
	}
	@DeleteMapping(path="/stock/stockDelete.json")
	@ResponseBody
	public int jsonDeleteStock(@RequestBody StockDto stockDto) {
		Long itemId = stockDto.getId();
		int cnt = stockService.deleteStock(itemId);
		return cnt;
	}
	@GetMapping(path="/stock/stockRegister.do")
	public String doStockRegister(HttpSession httpsession) {
		return "stock/stockRegister";
	}
	@PostMapping(path="/stock/stockRegister.json")
	@ResponseBody
	public int jsonStockRegister(HttpSession httpsession, @RequestBody StockDto stockDto) {
		LoginDto loginDto= (LoginDto) httpsession.getAttribute("loginDto");
		Long userid=loginDto.getId();
		
		//총 매수금액 = 매수단가 x 매수량
		BigDecimal prchsAmnt = stockDto.getPrchsAmnt();
		int rtnQnty = stockDto.getRtnQnty();
		prchsAmnt= prchsAmnt.multiply(new BigDecimal(rtnQnty));
		
		stockDto.setPrchsAmnt(prchsAmnt);
		stockDto.setUserId(userid);
		Long id = stockService.registerStock(stockDto);
		return 1;
	}
	@GetMapping(path="/stock/stockUpdate.do")
	public String doStockUpdate(HttpSession httpsession,@ModelAttribute StockDto stockDto) {
		String item = stockDto.getItem();
		System.out.println("stockUpdate들어옴");
		System.out.println(item);
		return "stock/stockUpdate";
	}
	@PutMapping(path="/stock/bought.json")
	public String jsonStockBought(@RequestBody StockDto stockDto, Model model) {
		int cnt = stockService.stockBuy(stockDto);
		model.addAttribute("cnt", cnt);
		return "jsonView";
	}
	@PutMapping(path="/stock/sold.json")
	public String jsonStockSold(@RequestBody StockDto stockDto, Model model) {
		int cnt = stockService.stockSell(stockDto);
		model.addAttribute("cnt", cnt);
		return "jsonView";
	}
	@PostMapping(path="/stock/stockItemCheck.json")
	public String jsonStockItemCheck(@RequestBody StockDto stockDto, Model model) {
		int flag=0;
		List<StockDto> totallist= stockService.getTotalStockList();
		String item = stockDto.getItem();
		for(StockDto dto :totallist) {
			if(item.equals(dto.getItem())) {
				flag=1;
				break;
			}
		}
		model.addAttribute("flag", flag);
		return"jsonView";
	}
	@GetMapping(path="/stock/stockInfo.json")
	public String jsonStockInfo(@ModelAttribute StockDto stockDto, Model model) {
		StockDto stock = stockService.getStockOne(stockDto.getItem());
		model.addAttribute("stock", stock);
		return "jsonView";
	}
}
