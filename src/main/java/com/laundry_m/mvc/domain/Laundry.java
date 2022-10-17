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
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Laundry {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "laundry_id_seq")
	@SequenceGenerator(sequenceName = "laundry_id_seq" , allocationSize = 1 , name = "laundry_id_seq")
	private Long laundryId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String  laundryName;
	
	private String laundryTel;
	
	private String laundryAddress;
	
	private int laundryDeliveryFee;
	
}
