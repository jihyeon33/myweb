package kr.or.myweb.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LoanDto {
	private Long id;  //pk
	private Long userId;  //사용자아이디
	private String lender;   //대출처
	private BigDecimal amount;  //대출금액
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp repayDate;  //상환예정일

	private Timestamp regDate;   //등록일자
	private Timestamp updateDate;  //최근업데이트일자
	private String updateOption;  // r:상환  m:추가대출
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
	public String getLender() {
		return lender;
	}
	public void setLender(String lender) {
		this.lender = lender;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Timestamp getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(Timestamp repayDate) {
		this.repayDate = repayDate;
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
	public String getUpdateOption() {
		return updateOption;
	}
	public void setUpdateOption(String updateOption) {
		this.updateOption = updateOption;
	}

}
