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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
	private LocalDateTime bookDate;
	
	private String bookMemo;
	
	private String bookMethod;
	
	
}
