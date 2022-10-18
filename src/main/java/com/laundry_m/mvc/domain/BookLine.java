package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookLine {
	private Long bookLineId;
	private Book book;
	private Clothes clothes;
	private Fabric fabric;
	private String clothesFabric;
	private int bookLineFee;

	@Builder
	public BookLine(Long bookLineId, Book book, Clothes clothes, Fabric fabric, String clothesFabric, int bookLineFee) {
		super();
		this.bookLineId = bookLineId;
		this.book = book;
		this.clothes = clothes;
		this.fabric = fabric;
		this.clothesFabric = clothesFabric;
		this.bookLineFee = bookLineFee;
	}
	
	
}
