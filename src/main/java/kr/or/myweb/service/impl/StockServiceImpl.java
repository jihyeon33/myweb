package kr.or.myweb.service.impl;

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

}
