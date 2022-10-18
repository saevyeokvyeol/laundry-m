package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Metapay {
	
	private Long metapayId;
	
	private User user;
	
	private String metapayBalance;
	private String metapayPassword;
	
	private LocalDateTime metapayDate;
	
	private LocalDateTime metapayUpdateDate;
	
	@Builder
	public Metapay(Long metapayId, User user, String metapayBalance, String metapayPassword) {
		super();
		this.metapayId = metapayId;
		this.user = user;
		this.metapayBalance = metapayBalance;
		this.metapayPassword = metapayPassword;
	}
	
	
	

}