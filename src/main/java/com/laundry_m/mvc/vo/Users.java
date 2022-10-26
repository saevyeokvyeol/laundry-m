package com.laundry_m.mvc.vo;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Users {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userType;
	private String userAddress;
	private String userState;
	private Double userLatitude;
	private Double userLongtitude;
	
	private Laundry laundry;
	
	@Builder
	public Users(String userId, String userPwd, String userName, String userPhone, String userType, String userAddress,
			String userState, Double userLatitude, Double userLongtitude,Laundry laundry) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userType = userType;
		this.userAddress = userAddress;
		this.userState = userState;
		this.userLatitude = userLatitude;
		this.userLongtitude = userLongtitude;
		this.laundry = laundry;
	}
	
	
}