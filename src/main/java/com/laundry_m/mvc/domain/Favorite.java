package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Favorite {
	
	private Long favoriteId;
	private String userId;
	private Long laundryId;
	
	private User user;
	private Laundry laundry;
	
	@Builder
	public Favorite(Long favoriteId, String userId, Long laundryId, User user, Laundry laundry) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.laundryId = laundryId;
		this.user = user;
		this.laundry = laundry;
	}
	
	
	
}
