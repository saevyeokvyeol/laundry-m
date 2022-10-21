package com.laundry_m.mvc.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Fee {
	private Long feeId;
	private Long laundryId;
	private Long clothesId;
	private int clothesFee;
	
	private Laundry laundry;
	private Clothes clothes;
	
	
	@Builder
	public Fee(Long feeId, Long laundryId, Long clothesId, int clothesFee, Laundry laundry, Clothes clothes) {
		super();
		this.feeId = feeId;
		this.laundryId = laundryId;
		this.clothesId = clothesId;
		this.clothesFee = clothesFee;
		this.laundry = laundry;
		this.clothes = clothes;
	}
	
	
	
}
