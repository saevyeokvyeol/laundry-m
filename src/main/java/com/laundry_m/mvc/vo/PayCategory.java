package com.laundry_m.mvc.vo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class PayCategory {
	
	private Long payCategoryId;
	private String payCategoryName;

	@Builder
	public PayCategory(Long payCategoryId, String payCategoryName) {
		super();
		this.payCategoryId = payCategoryId;
		this.payCategoryName = payCategoryName;
	}
	
	

}