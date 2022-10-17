package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;

@Entity
public class Clothes {
	@Id
	private int clothesId;
	
	private String clothesName;
	
	@OneToMany(mappedBy = "clothes")
	private List<BookLine> bookLine;
	
	@OneToMany(mappedBy = "clothes")
	private List<Fee> fee;
	
	@Builder
	public Clothes(int clothesId, String clothesName) {
		super();
		this.clothesId = clothesId;
		this.clothesName = clothesName;
	}
}
