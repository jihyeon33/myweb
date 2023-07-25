package kr.or.myweb.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockDto {
	private Long id;        //pk
	private Long userId;   //사용자 아이디
	private String item;    //항목
	private int rtnQnty;    //보유수량
	private BigDecimal prchsAmnt;  //매수금액
	private Timestamp regDate;     //등록일자
	private Timestamp updateDate;  //최근업데이트일자
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getRtnQnty() {
		return rtnQnty;
	}
	public void setRtnQnty(int rtnQnty) {
		this.rtnQnty = rtnQnty;
	}
	public BigDecimal getPrchsAmnt() {
		return prchsAmnt;
	}
	public void setPrchsAmnt(BigDecimal prchsAmnt) {
		this.prchsAmnt = prchsAmnt;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}
