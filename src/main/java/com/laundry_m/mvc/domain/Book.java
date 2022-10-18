package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Book {
	
	private Long bookId;
	private Laundry laundry;
	private User user;
	private Book book;
	private int bookCount;
	private LocalDateTime bookInsertDate;
	private LocalDateTime bookUpdateDate;
	private String bookMemo;
	private String bookMethod;
	private List<BookLine> bookLine;
	private List<Review> review;
	private List<Adjust> adjust;
	
	@Builder
	public Book(Long bookId, Laundry laundry, User user, Book book, int bookCount, LocalDateTime bookInsertDate
			, LocalDateTime bookUpdateDate, String bookMemo, String bookMethod) {
		super();
		this.bookId = bookId;
		this.laundry = laundry;
		this.user = user;
		this.book = book;
		this.bookCount = bookCount;
		this.bookInsertDate = bookInsertDate;
		this.bookUpdateDate = bookUpdateDate;
		this.bookMemo = bookMemo;
		this.bookMethod = bookMethod;
	}
	
}
