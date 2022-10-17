package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Fabric {
	@Id
	private int fabricId;
	
	private String fabricName;
	
	private String  fabricWashMethod;
	
}
