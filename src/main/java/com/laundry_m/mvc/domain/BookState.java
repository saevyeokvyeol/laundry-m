package com.laundry_m.mvc.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookState {
	private int bookStateId;
	private String bookStateName;
	private List<Book> book;
	
	@Builder
	public BookState(int bookStateId, String bookStateName) {
		super();
		this.bookStateId = bookStateId;
		this.bookStateName = bookStateName;
	}
}
