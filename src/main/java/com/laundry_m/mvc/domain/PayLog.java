package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;

@Entity
public class PayLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_log_id_seq")
	@SequenceGenerator(name = "pay_log_id_seq", allocationSize = 1, sequenceName = "pay_log_id_seq" )
	private Long payLogId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "metapay_id")
	private Metapay metapay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_category_id")
	private PayCategory payCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_account_id")
	private PayAccount payAccount;
	
	private Long payLogAmount;
	
	@CreationTimestamp
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