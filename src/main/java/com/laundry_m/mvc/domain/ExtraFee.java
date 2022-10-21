package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExtraFee {
	private Long extraFeeId;
	private Long fabricId;
	private Long laundryId;
	private int fabricFee;
	private char extraFeeOperation;
	
	private Fabric fabric;
	private Laundry laundry;
	
	@Builder
	public ExtraFee(Long extraFeeId, Long fabricId, Long laundryId, int fabricFee, char extraFeeOperation,
			Fabric fabric, Laundry laundry) {
		super();
		this.extraFeeId = extraFeeId;
		this.fabricId = fabricId;
		this.laundryId = laundryId;
		this.fabricFee = fabricFee;
		this.extraFeeOperation = extraFeeOperation;
		this.fabric = fabric;
		this.laundry = laundry;
	}
	
	
	
}
