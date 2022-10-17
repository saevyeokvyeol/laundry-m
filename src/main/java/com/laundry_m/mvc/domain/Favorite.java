package com.laundry_m.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Getter;

@Entity
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "favorite_id_seq")
	@SequenceGenerator(sequenceName = "favorite_id_seq" , allocationSize = 1 , name = "favorite_id_seq")
	private Long favoriteId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laundry_id")
	private Laundry laundry;
	
	@Builder
	public Favorite(Long favoriteId, User user, Laundry laundry) {
		super();
		this.favoriteId = favoriteId;
		this.user = user;
		this.laundry = laundry;
	}
	
}
