package kr.or.myweb.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.StockDao;
import kr.or.myweb.dto.StockDto;
import kr.or.myweb.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	private final StockDao stockDao;
	@Autowired
	public StockServiceImpl(StockDao stockDao) {
		this.stockDao=stockDao;
	}
	@Override
	public int getTotalStockCnt() {
		int totalCnt = stockDao.selectStockTotalCnt();
		return totalCnt;
	}
	@Override
	public List<StockDto> getStockList(Integer start, Integer limit) {
		List<StockDto> stocklist= stockDao.selectStockList(start, limit);
		return stocklist;
	}
	@Override
	public int deleteStock(Long id) {
		int cnt= stockDao.deleteStockOne(id);
		return cnt;
	}
	@Override
	public Long registerStock(StockDto stockDto) {
		Long id = stockDao.insertStockOne(stockDto);
		return id;
	}
	@Override
	public BigDecimal getTotalAmount() {
		int totalCnt = stockDao.selectStockTotalCnt();
		List<StockDto> stocklist= stockDao.selectStockList(0, totalCnt);
		BigDecimal amount =new BigDecimal("0");
		for (StockDto dto: stocklist) {
			amount=amount.add(dto.getPrchsAmnt());
		}
		return amount;
	}
	@Override
	public List<StockDto> getTotalStockList() {
		int totalcnt = stockDao.selectStockTotalCnt();
		List<StockDto> stocklist= stockDao.selectStockList(0, totalcnt);
		return stocklist;
	}
	@Override
	public int stockBuy(StockDto stockDto) {
		StockDto stock = stockDao.selectStockOne(stockDto.getItem());
		
		int rtnQnty =stock.getRtnQnty()+stockDto.getRtnQnty(); //기존 보유수량+매수량
		BigDecimal buyAmount = stockDto.getPrchsAmnt().multiply(new BigDecimal(stockDto.getRtnQnty())); //매수금액=매수단가x매수량
		BigDecimal prchsAmnt = stock.getPrchsAmnt().add(buyAmount); //기존 매수금액 + 추가 매수금액
		
		stockDto.setRtnQnty(rtnQnty);
		stockDto.setPrchsAmnt(prchsAmnt);
		int cnt = stockDao.updateStockOne(stockDto);
		return cnt;
	}
	@Override
	public int stockSell(StockDto stockDto) {
		StockDto stock = stockDao.selectStockOne(stockDto.getItem());
		
		int rtnQnty =stock.getRtnQnty()-stockDto.getRtnQnty(); //기존 보유수량-매도량		
		BigDecimal sellAmount = stockDto.getPrchsAmnt().multiply(new BigDecimal(stockDto.getRtnQnty())); //매도금액=매도단가x매도량
		BigDecimal prchsAmnt = stock.getPrchsAmnt().subtract(sellAmount); //기존 매수금액 - 매도금액	

		stockDto.setRtnQnty(rtnQnty);
		stockDto.setPrchsAmnt(prchsAmnt);
		int cnt = stockDao.updateStockOne(stockDto);
		return cnt;
	}
	@Override
	public StockDto getStockOne(String item) {
		StockDto stock = stockDao.selectStockOne(item);
		return stock;
	}

}
