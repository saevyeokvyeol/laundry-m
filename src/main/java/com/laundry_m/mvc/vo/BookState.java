package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class BookState {
	private int bookStateId;
	private String bookStateName;
	private List<Book> book;
	
	@Builder
	public BookState(int bookStateId, String bookStateName, List<Book> book) {
		super();
		this.bookStateId = bookStateId;
		this.bookStateName = bookStateName;
		this.book = book;
	}
}
