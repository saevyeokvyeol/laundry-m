package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class BookMethod {
	private int bookMethodId;
	private String bookMethodName;
	private List<Book> book;
	
	@Builder
	public BookMethod(int bookMethodId, String bookMethodName, List<Book> book) {
		super();
		this.bookMethodId = bookMethodId;
		this.bookMethodName = bookMethodName;
		this.book = book;
	}
}
