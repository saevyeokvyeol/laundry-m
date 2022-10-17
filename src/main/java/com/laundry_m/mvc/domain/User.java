package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;

@Entity
public class User {
	
	@Id
	private String userId;
	
	private String userPwd;
	private String userPhone;
	private String userType;
	private String userAddress;
	
	@Builder
	public User(String userId, String userPwd, String userPhone, String userType, String userAddress) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userPhone = userPhone;
		this.userType = userType;
		this.userAddress = userAddress;
	}
	
	

}