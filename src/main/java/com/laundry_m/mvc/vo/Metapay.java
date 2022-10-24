package com.laundry_m.mvc.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Metapay {
	
	private Long metapayId;
	private String userId;
	private String metapayBalance;
	private String metapayPassword;
	private Timestamp metapayDate;
	private Timestamp metapayUpdateDate;
	
	private Users user;
	private List<PayAccount> payAccounts;
	
	@Builder
	public Metapay(Long metapayId, String userId, String metapayBalance, String metapayPassword,
			Timestamp metapayDate, Timestamp metapayUpdateDate, Users user, List<PayAccount> payAccounts) {
		super();
		this.metapayId = metapayId;
		this.userId = userId;
		this.metapayBalance = metapayBalance;
		this.metapayPassword = metapayPassword;
		this.metapayDate = metapayDate;
		this.metapayUpdateDate = metapayUpdateDate;
		this.user = user;
		this.payAccounts = payAccounts;
	}
}