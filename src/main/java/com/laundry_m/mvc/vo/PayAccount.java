package com.laundry_m.mvc.vo;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class PayAccount {
	
	private Long payAccountId;
	private Long metapayId;
	private Long bankId;
	private String payAccountNumber;
	private String payAccountQuitState;
	
	private Metapay metapay;
	private Bank bank;

	@Builder
	public PayAccount(Long payAccountId, Long metapayId, Long bankId, String payAccountNumber,
			String payAccountQuitState,Metapay metapay, Bank bank) {
		super();
		this.payAccountId = payAccountId;
		this.metapayId = metapayId;
		this.bankId = bankId;
		this.payAccountNumber = payAccountNumber;
		this.payAccountQuitState = payAccountQuitState;
		this.metapay = metapay;
		this.bank = bank;
	}

}