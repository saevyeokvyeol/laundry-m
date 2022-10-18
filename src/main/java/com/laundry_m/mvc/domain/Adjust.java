package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Adjust {
	
	private Long adjustId;
	private LocalDateTime adjust_insert_date;
	private Laundry laundry;
	private Book book;
	
	@Builder
	public Adjust(Long adjustId, LocalDateTime adjust_insert_date, Laundry laundry, Book book) {
		super();
		this.adjustId = adjustId;
		this.adjust_insert_date = adjust_insert_date;
		this.laundry = laundry;
		this.book = book;
	}
}
