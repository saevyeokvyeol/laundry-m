package com.laundry_m.mvc.vo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Laundry {
	private Long laundryId;
	private String userId;
	private String laundryName;
	private String laundryTel;
	private String laundryAddress;
	private int laundryDeliveryFee;
	private String laundryAccountNumber;
	private Long laundryLatitude;
	private Long laundryLongitude;
	
	private Users user;
	private List<Book> book;
	private List<Fee> fee;
	private List<ExtraFee> extraFee;
	private List<Adjust> adjust;
	private List<Favorite> favorite;
	
	@Builder
	public Laundry(Long laundryId, String userId, String laundryName, String laundryTel, String laundryAddress,
			int laundryDeliveryFee, String laundryAccountNumber, Long laundryLatitude, Long laundryLongitude, Users user,
			List<Book> book, List<Fee> fee, List<ExtraFee> extraFee, List<Adjust> adjust, List<Favorite> favorite) {
		super();
		this.laundryId = laundryId;
		this.userId = userId;
		this.laundryName = laundryName;
		this.laundryTel = laundryTel;
		this.laundryAddress = laundryAddress;
		this.laundryDeliveryFee = laundryDeliveryFee;
		this.laundryAccountNumber = laundryAccountNumber;
		this.laundryLatitude = laundryLatitude;
		this.laundryLongitude = laundryLongitude;
		this.user = user;
		this.book = book;
		this.fee = fee;
		this.extraFee = extraFee;
		this.adjust = adjust;
		this.favorite = favorite;
	}
	
	
	
}
