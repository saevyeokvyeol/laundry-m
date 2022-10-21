package com.laundry_m.mvc.vo;

import java.time.LocalDateTime;
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
	private LocalDateTime bookInsertDate;
	private LocalDateTime bookUpdateDate;
	private String bookMemo;
	private int bookMethodId;
	private Long bookTotalFee;
	
	private Users users;
	private Laundry laundry;
	
	private List<BookLine> bookLine;
	private List<Review> review;
	private List<Adjust> adjust;
	
	@Builder
	public Book(Long bookId, Long laundryId, String userId, Long bookStateId, int bookCount, LocalDateTime bookInsertDate,
			LocalDateTime bookUpdateDate, String bookMemo, int bookMethodId, Long bookTotalFee, Users users,
			Laundry laundry, List<BookLine> bookLine, List<Review> review, List<Adjust> adjust) {
		super();
		this.bookId = bookId;
		this.laundryId = laundryId;
		this.userId = userId;
		this.bookCount = bookCount;
		this.bookStateId = bookStateId;
		this.bookInsertDate = bookInsertDate;
		this.bookUpdateDate = bookUpdateDate;
		this.bookMemo = bookMemo;
		this.bookMethodId = bookMethodId;
		this.bookTotalFee = bookTotalFee;
		this.users = users;
		this.laundry = laundry;
		this.bookLine = bookLine;
		this.review = review;
		this.adjust = adjust;
	}


}
