package kr.or.myweb.service;

import java.util.List;

import kr.or.myweb.dto.StockDto;

public interface StockService {
	public int getTotalStockCnt();
	public List<StockDto> getStockList(Integer start, Integer limit);
	public int deleteStock(Long item);

}
