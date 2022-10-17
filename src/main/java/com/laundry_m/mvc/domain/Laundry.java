package com.laundry_m.mvc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Entity
public class Laundry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "laundry_id_seq")
	@SequenceGenerator(sequenceName = "laundry_id_seq" , allocationSize = 1 , name = "laundry_id_seq")
	private Long laundryId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String  laundryName;
	
	private String laundryTel;
	
	private String laundryAddress;
	
	private int laundryDeliveryFee;
	
	private String laundryAccountNumber;
	
	@OneToMany(mappedBy = "laundry")
	private List<Book> book;
	
	@OneToMany(mappedBy = "laundry")
	private List<Fee> fee;
	
	@OneToMany(mappedBy = "laundry")
	private List<ExtraFee> extraFee;
	
	@OneToMany(mappedBy = "laundry")
	private List<Adjust> adjust;
	
	@OneToMany(mappedBy = "laundry")
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
