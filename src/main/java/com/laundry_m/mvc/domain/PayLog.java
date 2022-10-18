package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PayLog {
	
	private Long payLogId;
	
	private Metapay metapay;
	
	private PayCategory payCategory;
	
	private PayAccount payAccount;
	
	private Long payLogAmount;
	
	private LocalDateTime payLogInsertDate;

	
	@Builder
	public PayLog(Long payLogId, Metapay metapay, PayCategory payCategory, PayAccount payAccount, Long payLogAmount,
			LocalDateTime payLogInsertDate) {
		super();
		this.payLogId = payLogId;
		this.metapay = metapay;
		this.payCategory = payCategory;
		this.payAccount = payAccount;
		this.payLogAmount = payLogAmount;
		this.payLogInsertDate = payLogInsertDate;
	}

	
	
	
}