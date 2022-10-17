package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "book_id_seq")
	@SequenceGenerator(sequenceName = "book_id_seq" , allocationSize = 1 , name = "book_id_seq")
	private Long bookId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laundry_id")
	private Laundry laundry;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookState_id")
	private Book book;
	
	private int bookCount;
	
	@CreationTimestamp
	private LocalDateTime bookInsertDate;
	
	@UpdateTimestamp
	private LocalDateTime bookUpdateDate;
	
	private String bookMemo;
	
	private String bookMethod;
	
	@OneToMany(mappedBy = "book")
	private List<BookLine> bookLine;
	
	@OneToMany(mappedBy = "book")
	private List<Review> review;
	
	@OneToMany(mappedBy = "book")
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
