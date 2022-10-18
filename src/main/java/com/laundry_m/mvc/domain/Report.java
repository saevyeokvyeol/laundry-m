package com.laundry_m.mvc.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
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