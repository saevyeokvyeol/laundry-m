package com.laundry_m.mvc.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Laundry {
	private Long laundryId;
	private User user;
	private String  laundryName;
	private String laundryTel;
	private String laundryAddress;
	private int laundryDeliveryFee;
	private String laundryAccountNumber;
	private List<Book> book;
	private List<Fee> fee;
	private List<ExtraFee> extraFee;
	private List<Adjust> adjust;
	private List<Favorite> favorite;
	
	@Builder
	public Laundry(Long laundryId, User user, String laundryName, String laundryTel, String laundryAddress, int laundryDeliveryFee
			, String laundryAccountNumber) {
		super();
		this.laundryId = laundryId;
		this.user = user;
		this.laundryName = laundryName;
		this.laundryTel = laundryTel;
		this.laundryAddress = laundryAddress;
		this.laundryDeliveryFee = laundryDeliveryFee;
		this.laundryAccountNumber = laundryAccountNumber;
	}
}
