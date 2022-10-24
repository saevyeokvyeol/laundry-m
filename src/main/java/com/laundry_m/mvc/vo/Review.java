package com.laundry_m.mvc.vo;

import java.sql.Timestamp;
import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Review {
	
	private Long reviewId;
	private String userId;
	private Users users;

	private Long laundryId;
	private Long bookId;
	private String reviewContent;
	private Long reviewRate;
	private Timestamp reviewInsertDate;
	private Timestamp reviewUpdateDate;
	
	private Laundry laundry;
	private Book book;
	

	@Builder

	public Review(Long reviewId, String userId, Long laundryId, Long bookId, String reviewContent, Long reviewRate,
			Timestamp reviewInsertDate, Timestamp reviewUpdateDate, Users users, Laundry laundry, Book book) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.laundryId = laundryId;
		this.bookId = bookId;
		this.reviewContent = reviewContent;
		this.reviewRate = reviewRate;
		this.reviewInsertDate = reviewInsertDate;
		this.reviewUpdateDate = reviewUpdateDate;
		this.users = users;
		this.laundry = laundry;
		this.book = book;
	}


	
	
	
}