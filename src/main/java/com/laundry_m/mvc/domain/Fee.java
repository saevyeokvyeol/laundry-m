package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Fee {
	private Long feeId;
	private Laundry laundry;
	private Clothes clothes;
	
	private int clothesFee;
	
	@Builder
	public Fee(Long feeId, Laundry laundry, Clothes clothes, int clothesFee) {
		super();
		this.feeId = feeId;
		this.laundry = laundry;
		this.clothes = clothes;
		this.clothesFee = clothesFee;
	}
}
