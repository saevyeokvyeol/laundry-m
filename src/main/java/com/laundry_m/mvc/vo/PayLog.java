package com.laundry_m.mvc.vo;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PayLog {
	private Long payLogId;
	private Long metapayId;
	private int payCategoryId;
	private Long payAccountId;
	private Long laundryId;
	private Long payLogAmount;
	private LocalDateTime payLogInsertDate;
	
	private Metapay metapay;
	private PayCategory payCategory;
	private PayAccount payAccount;
	
	@Builder
	public PayLog(Long payLogId, Long metapayId, int payCategoryId, Long payAccountId, Long laundryId,
			Long payLogAmount, LocalDateTime payLogInsertDate, Metapay metapay, PayCategory payCategory,
			PayAccount payAccount) {
		super();
		this.payLogId = payLogId;
		this.metapayId = metapayId;
		this.payCategoryId = payCategoryId;
		this.payAccountId = payAccountId;
		this.laundryId = laundryId;
		this.payLogAmount = payLogAmount;
		this.payLogInsertDate = payLogInsertDate;
		this.metapay = metapay;
		this.payCategory = payCategory;
		this.payAccount = payAccount;
	}
}