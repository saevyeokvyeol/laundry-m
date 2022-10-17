package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private String payAccountQuitState;
	
	@OneToMany(mappedBy = "payAccount")
	private List<PayLog> payLog;

	@Builder
	public PayAccount(Long payAccountId, Metapay metapay, Bank bank, String payAccountNumber,
			String payAccountQuitState, List<PayLog> payLog) {
		super();
		this.payAccountId = payAccountId;
		this.metapay = metapay;
		this.bank = bank;
		this.payAccountNumber = payAccountNumber;
		this.payAccountQuitState = payAccountQuitState;
		this.payLog = payLog;
	}

}