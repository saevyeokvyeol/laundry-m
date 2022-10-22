package com.laundry_m.mvc.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Book {
	
	private Long bookId;
	private Long laundryId;
	private String userId;
	private Long bookStateId;
	private int bookCount;
	private Timestamp bookInsertDate;
	private Timestamp bookUpdateDate;
	private String bookMemo;
	private int bookMethodId;
	private Long bookTotalFee;
	
	private Users users;
	private Laundry laundry;
	private BookState bookState;
	private Review review;
	private Adjust adjust;
	private BookMethod bookMethod;
	
	private List<BookLine> bookLine;

	
	@Builder
	public Book(Long bookId, Long laundryId, String userId, Long bookStateId, int bookCount, Timestamp bookInsertDate,
			Timestamp bookUpdateDate, String bookMemo, int bookMethodId, Long bookTotalFee, Users users,
			Laundry laundry, BookState bookState, Review review, Adjust adjust, BookMethod bookMethod,
			List<BookLine> bookLine) {
		super();
		this.bookId = bookId;
		this.laundryId = laundryId;
		this.userId = userId;
		this.bookStateId = bookStateId;
		this.bookCount = bookCount;
		this.bookInsertDate = bookInsertDate;
		this.bookUpdateDate = bookUpdateDate;
		this.bookMemo = bookMemo;
		this.bookMethodId = bookMethodId;
		this.bookTotalFee = bookTotalFee;
		this.users = users;
		this.laundry = laundry;
		this.bookState = bookState;
		this.review = review;
		this.adjust = adjust;
		this.bookMethod = bookMethod;
		this.bookLine = bookLine;
	}
	
}
