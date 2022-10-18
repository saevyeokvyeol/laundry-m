package com.laundry_m.mvc.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Favorite {
	
	private Long favoriteId;
	private User user;
	private Laundry laundry;
	
	@Builder
	public Favorite(Long favoriteId, User user, Laundry laundry) {
		super();
		this.favoriteId = favoriteId;
		this.user = user;
		this.laundry = laundry;
	}
	
}
