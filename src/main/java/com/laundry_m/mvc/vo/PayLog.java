package com.laundry_m.mvc.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class PayLog {
	private Long payLogId;
	private Long metapayId;
	private int payCategoryId;
	private Long payAccountId;
	private Long payLogAmount;
	private Timestamp payLogInsertDate;
	private Long laundryId;
	private Metapay metapay;
	private PayCategory payCategory;
	private PayAccount payAccount;
	
	@Builder
	public PayLog(Long payLogId, Long metapayId, int payCategoryId, Long payAccountId, Long laundryId,
			Long payLogAmount, Timestamp payLogInsertDate, Metapay metapay, PayCategory payCategory,
			PayAccount payAccount) {
		super();
		this.payLogId = payLogId;
		this.metapayId = metapayId;
		this.payCategoryId = payCategoryId;
		this.payAccountId = payAccountId;
		this.payLogAmount = payLogAmount;
		this.laundryId = laundryId;
		this.payLogInsertDate = payLogInsertDate;
		this.metapay = metapay;
		this.payCategory = payCategory;
		this.payAccount = payAccount;
	}
}