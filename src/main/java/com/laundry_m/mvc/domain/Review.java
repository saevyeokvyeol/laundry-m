package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_id_seq")
	@SequenceGenerator(name = "review_id_seq", allocationSize = 1, sequenceName = "review_id_seq")
	private Long reviewId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private Long bookId;
	private String reviewContent;
	private Long reviewRate;
	
	@CreationTimestamp
	private LocalDateTime reviewInsertDate;
	
	@UpdateTimestamp
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