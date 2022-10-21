package com.laundry_m.mvc.vo;

import java.time.LocalDateTime;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Metapay {
	
	private Long metapayId;
	private String userId;
	private String metapayBalance;
	private String metapayPassword;
	private LocalDateTime metapayDate;
	private LocalDateTime metapayUpdateDate;
	
	private Users user;
	
	@Builder
	public Metapay(Long metapayId, String userId, String metapayBalance, String metapayPassword,
			LocalDateTime metapayDate, LocalDateTime metapayUpdateDate, Users user) {
		super();
		this.metapayId = metapayId;
		this.userId = userId;
		this.metapayBalance = metapayBalance;
		this.metapayPassword = metapayPassword;
		this.metapayDate = metapayDate;
		this.metapayUpdateDate = metapayUpdateDate;
		this.user = user;
	}
}