package com.laundry_m.mvc.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Fabric {
	private int fabricId;
	private String fabricName;
	private String  fabricWashMethod;
	private List<ExtraFee> extraFee;
	private List<BookLine> bookLine;
	
	@Builder
	public Fabric(int fabricId, String fabricName, String fabricWashMethod) {
		super();
		this.fabricId = fabricId;
		this.fabricName = fabricName;
		this.fabricWashMethod = fabricWashMethod;
	}
	
}
