package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;

@Getter
public class Metapay {
	
	private Long metapayId;
	private String userId;
	private String metapayBalance;
	private String metapayPassword;
	
	private LocalDateTime metapayInsertDate;
	private LocalDateTime metapayUpdateDate;
	
	private User user;
	
	@Builder
	public Metapay(Long metapayId, String userId, String metapayBalance, String metapayPassword,
			LocalDateTime metapayInsertDate, LocalDateTime metapayUpdateDate, User user) {
		super();
		this.metapayId = metapayId;
		this.userId = userId;
		this.metapayBalance = metapayBalance;
		this.metapayPassword = metapayPassword;
		this.metapayInsertDate = metapayInsertDate;
		this.metapayUpdateDate = metapayUpdateDate;
		this.user = user;
	}
}