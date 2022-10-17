package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;


@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_id_seq")
	@SequenceGenerator(name = "bank_id_seq", allocationSize = 1, sequenceName = "bank_id_seq" )
	private Long bankId;
	
	private String bankName;

	@Builder
	public Bank(Long bankId, String bankName) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
	}
	
	

}