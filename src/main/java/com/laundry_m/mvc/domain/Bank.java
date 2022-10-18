package com.laundry_m.mvc.domain;



import lombok.Builder;
import lombok.Getter;

@Getter
public class Bank {
	
	private Long bankId;
	
	private String bankName;

	@Builder
	public Bank(Long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	
	

}