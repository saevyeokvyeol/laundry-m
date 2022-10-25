package com.laundry_m.mvc.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Fee {
	private Long feeId;
	private Long laundryId;
	private int clothesId;
	private int clothesFee;
	
	private Laundry laundry;
	private Clothes clothes;
	
	
	@Builder
	public Fee(Long feeId, Long laundryId, int clothesId, int clothesFee, Laundry laundry, Clothes clothes) {
		super();
		this.feeId = feeId;
		this.laundryId = laundryId;
		this.clothesId = clothesId;
		this.clothesFee = clothesFee;
		this.laundry = laundry;
		this.clothes = clothes;
	}
	
	
	
}
