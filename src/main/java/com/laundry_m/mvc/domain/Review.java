package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Review {
	
	private Long reviewId;
	
	private User user;
	
	private Long bookId;
	private String reviewContent;
	private Long reviewRate;
	
	private LocalDateTime reviewInsertDate;
	
	private LocalDateTime reviewUpdateDate;

	@Builder
	public Review(Long reviewId, User user, Long bookId, String reviewContent, Long reviewRate,
			LocalDateTime reviewInsertDate, LocalDateTime reviewUpdateDate) {
		super();
		this.reviewId = reviewId;
		this.user = user;
		this.bookId = bookId;
		this.reviewContent = reviewContent;
		this.reviewRate = reviewRate;
		this.reviewInsertDate = reviewInsertDate;
		this.reviewUpdateDate = reviewUpdateDate;
	}
	
	
	
	
}