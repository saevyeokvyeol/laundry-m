package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Book {
	
	private Long bookId;
	private Long laundryId;
	private String userId;
	private int bookCount;
	private LocalDateTime bookInsertDate;
	private LocalDateTime bookUpdateDate;
	private String bookMemo;
	private int bookMethod;
	private Long bookTotalFee;
	
	private User user;
	private Laundry laundry;
	
	private List<BookLine> bookLine;
	private List<Review> review;
	private List<Adjust> adjust;
	
	@Builder
	public Book(Long bookId, Long laundryId, String userId, int bookCount, LocalDateTime bookInsertDate,
			LocalDateTime bookUpdateDate, String bookMemo, int bookMethod, Long bookTotalFee, User user,
			Laundry laundry, List<BookLine> bookLine, List<Review> review, List<Adjust> adjust) {
		super();
		this.bookId = bookId;
		this.laundryId = laundryId;
		this.userId = userId;
		this.bookCount = bookCount;
		this.bookInsertDate = bookInsertDate;
		this.bookUpdateDate = bookUpdateDate;
		this.bookMemo = bookMemo;
		this.bookMethod = bookMethod;
		this.bookTotalFee = bookTotalFee;
		this.user = user;
		this.laundry = laundry;
		this.bookLine = bookLine;
		this.review = review;
		this.adjust = adjust;
	}
}
