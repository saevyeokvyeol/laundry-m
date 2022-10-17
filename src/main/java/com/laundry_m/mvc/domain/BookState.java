package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;

@Entity
public class BookState {
	@Id
	private int bookStateId;
	
	private String bookStateName;
	
	@OneToMany(mappedBy = "bookState")
	private List<Book> book;
	
	@Builder
	public BookState(int bookStateId, String bookStateName) {
		super();
		this.bookStateId = bookStateId;
		this.bookStateName = bookStateName;
	}
}
