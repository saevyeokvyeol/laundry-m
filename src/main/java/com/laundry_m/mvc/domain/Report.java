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
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_no_seq")
	@SequenceGenerator(name = "report_no_seq", allocationSize = 1, sequenceName = "report_no_seq" )
	private int reportNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	//laundary 추가시 변경
	private int laundaryId;

	@Builder
	public Report(int reportNo, User user, int laundaryId) {
		super();
		this.reportNo = reportNo;
		this.user = user;
		this.laundaryId = laundaryId;
	}
	
	

}
