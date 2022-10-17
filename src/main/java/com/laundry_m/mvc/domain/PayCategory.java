package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Entity
public class PayCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_category_id_seq")
	@SequenceGenerator(name = "pay_category_id_seq", allocationSize = 1, sequenceName = "pay_category_id_seq" )
	private Long payCategoryId;
	
	private String payCategoryName;

	@Builder
	public PayCategory(Long payCategoryId, String payCategoryName) {
		super();
		this.payCategoryId = payCategoryId;
		this.payCategoryName = payCategoryName;
	}
	
	

}