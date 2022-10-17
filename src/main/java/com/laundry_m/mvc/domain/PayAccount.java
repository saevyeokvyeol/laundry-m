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
public class PayAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_account_id_seq")
	@SequenceGenerator(name = "pay_account_id_seq", allocationSize = 1, sequenceName = "pay_account_id_seq" )
	private Long payAccountId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "metapay_id")
	private Metapay metapay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id")
	private Bank bank;
	
	private String payAccountNumber;

	@Builder
	public PayAccount(Long payAccountId, Metapay metapay, Bank bank, String payAccountNumber) {
		this.payAccountId = payAccountId;
		this.metapay = metapay;
		this.bank = bank;
		this.payAccountNumber = payAccountNumber;
	}
	
	

}