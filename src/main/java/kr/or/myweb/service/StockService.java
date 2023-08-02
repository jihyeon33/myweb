package kr.or.myweb.service;

import java.math.BigDecimal;
import java.util.List;

import kr.or.myweb.dto.StockDto;

public interface StockService {
	public int getTotalStockCnt();
	public List<StockDto> getStockList(Integer start, Integer limit);
	public int deleteStock(Long item);
	public Long registerStock(StockDto stockDto);
	public BigDecimal getTotalAmount();

}
