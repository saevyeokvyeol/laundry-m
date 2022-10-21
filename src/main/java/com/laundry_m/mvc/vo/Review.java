package com.laundry_m.mvc.vo;

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
<<<<<<< Updated upstream
	private User user;
	
=======
	private Long laundryId;
>>>>>>> Stashed changes
	private Long bookId;
	private String reviewContent;
	private Long reviewRate;
	private LocalDateTime reviewInsertDate;
	private LocalDateTime reviewUpdateDate;
	
	private Users users;
	private Laundry laundry;
	private Book book;
	

	@Builder
<<<<<<< Updated upstream
	public Review(Long reviewId, String userId, User user, Long bookId, String reviewContent, Long reviewRate,
			LocalDateTime reviewInsertDate, LocalDateTime reviewUpdateDate) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.user = user;
=======
	public Review(Long reviewId, String userId, Long laundryId, Long bookId, String reviewContent, Long reviewRate,
			LocalDateTime reviewInsertDate, LocalDateTime reviewUpdateDate, Users users, Laundry laundry, Book book) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.laundryId = laundryId;
>>>>>>> Stashed changes
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