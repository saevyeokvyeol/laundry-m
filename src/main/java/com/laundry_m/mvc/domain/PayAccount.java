package com.laundry_m.mvc.domain;



import lombok.Builder;
import lombok.Getter;

@Getter
public class PayAccount {
	
	private Long payAccountId;
	
	private Metapay metapay;
	
	private Bank bank;
	
	private String payAccountNumber;
	private String payAccountQuitState;
	

	@Builder
	public PayAccount(Long payAccountId, Metapay metapay, Bank bank, String payAccountNumber,
			String payAccountQuitState) {
		super();
		this.payAccountId = payAccountId;
		this.metapay = metapay;
		this.bank = bank;
		this.payAccountNumber = payAccountNumber;
		this.payAccountQuitState = payAccountQuitState;
	}

}