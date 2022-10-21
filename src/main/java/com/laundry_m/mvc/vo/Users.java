package com.laundry_m.mvc.vo;



import lombok.Builder;
import lombok.Getter;

@Getter
public class Users {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userType;
	private String userAddress;
	private String userState;
	private Long userLatitude;
	private Long userLongitude;
	
	@Builder
	public Users(String userId, String userPwd, String userName, String userPhone, String userType, String userAddress,
			String userState, Long userLatitude, Long userLongitude) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userType = userType;
		this.userAddress = userAddress;
		this.userState = userState;
		this.userLatitude = userLatitude;
		this.userLongitude = userLongitude;
	}
	
}