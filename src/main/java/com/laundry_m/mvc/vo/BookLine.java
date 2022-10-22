package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class BookLine {
	private Long bookLineId;
	private Long bookId;
	private Long clothesId;
	private Long fabricId;
	private int bookLineFee;
	
	private Book book;
	private Clothes clothes;
	private Fabric fabric;
	
	@Builder
	public BookLine(Long bookLineId, Long bookId, Long clothesId, Long fabricId, int bookLineFee, Book book, Clothes clothes, Fabric fabric) {
		super();
		this.bookLineId = bookLineId;
		this.bookId = bookId;
		this.clothesId = clothesId;
		this.fabricId = fabricId;
		this.bookLineFee = bookLineFee;
		this.book = book;
		this.clothes = clothes;
		this.fabric = fabric;
	}
	
	
}
