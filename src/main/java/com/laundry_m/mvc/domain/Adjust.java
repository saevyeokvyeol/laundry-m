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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class Adjust {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "adjust_id_seq")
	@SequenceGenerator(sequenceName = "adjust_id_seq" , allocationSize = 1 , name = "adjust_id_seq")
	private Long adjustId;
	
	@CreationTimestamp
	private LocalDateTime adjust_insert_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laundry_id")
	private Laundry laundry;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookState_id")
	private Book book;
	
	@Builder
	public Adjust(Long adjustId, LocalDateTime adjust_insert_date, Laundry laundry, Book book) {
		super();
		this.adjustId = adjustId;
		this.adjust_insert_date = adjust_insert_date;
		this.laundry = laundry;
		this.book = book;
	}
}
