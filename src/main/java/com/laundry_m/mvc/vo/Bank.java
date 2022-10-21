package com.laundry_m.mvc.vo;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
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