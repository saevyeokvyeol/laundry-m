package com.laundry_m.mvc.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;

@Entity
public class Metapay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metapay_id_seq")
	@SequenceGenerator(name = "metapay_id_seq", allocationSize = 1, sequenceName = "metapay_id_seq" )
	private Long metapayId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private String metapayBalance;
	private String metapayPassword;
	
	@Builder
	public Metapay(Long metapayId, User user, String metapayBalance, String metapayPassword) {
		super();
		this.metapayId = metapayId;
		this.user = user;
		this.metapayBalance = metapayBalance;
		this.metapayPassword = metapayPassword;
	}
	
	
	

}