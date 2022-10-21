package com.laundry_m.mvc.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class Favorite {
	
	private Long favoriteId;
	private String userId;
	private Long laundryId;
	
	private Users users;
	private Laundry laundry;
	
	@Builder
	public Favorite(Long favoriteId, String userId, Long laundryId, Users users, Laundry laundry) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.laundryId = laundryId;
		this.users = users;
		this.laundry = laundry;
	}
	
	
	
}
