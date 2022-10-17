package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class BookLine {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "book_line_id_seq")
	@SequenceGenerator(sequenceName = "book_line_id_seq" , allocationSize = 1 , name = "book_line_id_seq")
	private Long bookLineId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clothes_id")
	private Clothes clothes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fabric_id")
	private Fabric fabric;
	
	private String clothesFabric;
	
	private int bookLineFee;
	

	@Builder
	public BookLine(Long bookLineId, Book book, Clothes clothes, Fabric fabric, String clothesFabric, int bookLineFee) {
		super();
		this.bookLineId = bookLineId;
		this.book = book;
		this.clothes = clothes;
		this.fabric = fabric;
		this.clothesFabric = clothesFabric;
		this.bookLineFee = bookLineFee;
	}
	
	
}
