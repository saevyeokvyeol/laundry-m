package com.laundry_m.mvc.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Clothes {
	private int clothesId;
	private String clothesName;
	private List<BookLine> bookLine;
	private List<Fee> fee;
	
	@Builder
	public Clothes(int clothesId, String clothesName) {
		super();
		this.clothesId = clothesId;
		this.clothesName = clothesName;
	}
}
