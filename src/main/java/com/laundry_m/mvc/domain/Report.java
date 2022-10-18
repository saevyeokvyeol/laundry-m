package com.laundry_m.mvc.domain;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Report {
	
	private Long reportNo;
	
	private User user;
	
	private Long laundaryId;

	@Builder
	public Report(Long reportNo, User user, Long laundaryId) {
		super();
		this.reportNo = reportNo;
		this.user = user;
		this.laundaryId = laundaryId;
	}
	
	

}