package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Entity
public class PayLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_log_id_seq")
	@SequenceGenerator(name = "pay_log_id_seq", allocationSize = 1, sequenceName = "pay_log_id_seq" )
	private int payLogId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "metapay_id")
	private Metapay metapay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_category_id")
	private PayCategory payCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_account_id")
	private PayAccount payAccount;

	@Builder
	public PayLog(int payLogId, Metapay metapay, PayCategory payCategory, PayAccount payAccount) {
		super();
		this.payLogId = payLogId;
		this.metapay = metapay;
		this.payCategory = payCategory;
		this.payAccount = payAccount;
	}
	
	
}
