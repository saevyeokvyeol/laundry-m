package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExtraFee {
	private Long extraFeeId;
	private Fabric fabric;
	private Laundry laundry;
	private int fabricFee;
	private char extraFeeOperation;
	
	@Builder
	public ExtraFee(Long extraFeeId, Fabric fabric, Laundry laundry, int fabricFee, char extraFeeOperation) {
		super();
		this.extraFeeId = extraFeeId;
		this.fabric = fabric;
		this.laundry = laundry;
		this.fabricFee = fabricFee;
		this.extraFeeOperation = extraFeeOperation;
	}
	
}
