package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Fabric {
	private int fabricId;
	private String fabricName;
	private String  fabricWashMethod;
	
	private List<ExtraFee> extraFee;
	private List<BookLine> bookLine;
	
	@Builder
	public Fabric(int fabricId, String fabricName, String fabricWashMethod,List<ExtraFee> extraFee, List<BookLine> bookLine) {
		super();
		this.fabricId = fabricId;
		this.fabricName = fabricName;
		this.fabricWashMethod = fabricWashMethod;
		this.extraFee = extraFee;
		this.bookLine = bookLine;
	}
	
}
