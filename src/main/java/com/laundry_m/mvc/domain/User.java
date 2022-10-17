package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Builder;

@Entity
public class User {
	
	@Id
	private String userId;
	
	private String userPwd;
	private String userPhone;
	private String userType;
	private String userAddress;
	
	@OneToOne(mappedBy = "user")
	private Laundry laundry;

	@OneToMany(mappedBy = "user")
	private List<Review> review;
	
	@OneToMany(mappedBy = "user")
	private List<Metapay> metapay;
	
	@OneToMany(mappedBy = "user")
	private List<Report> report;
	
	@OneToMany(mappedBy = "user")
	private List<Book> book;

	@Builder
	public User(String userId, String userPwd, String userPhone, String userType, String userAddress, Laundry laundry,
			List<Review> review, List<Metapay> metapay, List<Report> report, List<Book> book) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userType = userType;
		this.userAddress = userAddress;
		this.laundry = laundry;
		this.review = review;
		this.metapay = metapay;
		this.report = report;
		this.book = book;
	}
	
	

}