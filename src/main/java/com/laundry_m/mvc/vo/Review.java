package com.laundry_m.mvc.vo;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Review {
	
	private Long reviewId;
	private String userId;
	private User user;
	
	private Long bookId;
	private String reviewContent;
	private Long reviewRate;
	
	private LocalDateTime reviewInsertDate;
	
	private LocalDateTime reviewUpdateDate;

	@Builder
	public Review(Long reviewId, String userId, User user, Long bookId, String reviewContent, Long reviewRate,
			LocalDateTime reviewInsertDate, LocalDateTime reviewUpdateDate) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.user = user;
		this.bookId = bookId;
		this.reviewContent = reviewContent;
		this.reviewRate = reviewRate;
		this.reviewInsertDate = reviewInsertDate;
		this.reviewUpdateDate = reviewUpdateDate;
	}


	
	
	
}