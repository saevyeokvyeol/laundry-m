package com.laundry_m.mvc.domain;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
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