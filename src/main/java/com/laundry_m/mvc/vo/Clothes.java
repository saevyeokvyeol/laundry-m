package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Clothes {
	private int clothesId;
	private String clothesName;
	private List<BookLine> bookLine;
	private List<Fee> fee;
	
	@Builder
	public Clothes(int clothesId, String clothesName,List<BookLine> bookLine, List<Fee> fee) {
		super();
		this.clothesId = clothesId;
		this.clothesName = clothesName;
		this.bookLine = bookLine;
		this.fee = fee;
	}
}
