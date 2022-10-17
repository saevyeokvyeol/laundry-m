package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;

@Entity
public class Fabric {
	@Id
	private int fabricId;
	
	private String fabricName;
	
	private String  fabricWashMethod;
	
	@OneToMany(mappedBy = "fabric")
	private List<ExtraFee> extraFee;
	
	@OneToMany(mappedBy = "fabric")
	private List<BookLine> bookLine;
	
	@Builder
	public Fabric(int fabricId, String fabricName, String fabricWashMethod) {
		super();
		this.fabricId = fabricId;
		this.fabricName = fabricName;
		this.fabricWashMethod = fabricWashMethod;
	}
	
}
