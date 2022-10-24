package com.laundry_m.mvc.controller;

import java.util.List;
import java.util.Map;

import com.laundry_m.mvc.service.LaundryService;
import com.laundry_m.mvc.service.LaundryServiceImpl;
import com.laundry_m.mvc.service.StatisticsService;
import com.laundry_m.mvc.service.StatisticsServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.StatisticsDetail;
import com.laundry_m.mvc.vo.StatisticsTotal;
import com.laundry_m.mvc.vo.Users;

public class StatisticsController {
	private StatisticsService statisticsService = new StatisticsServiceImpl();
	private LaundryService laundryService = new LaundryServiceImpl();
	private Session session = Session.getInstance();

	public void searchStatistics(Map<String, Object> map) {
		try {
			if (map.get("laundryId") != null && (int)map.get("laundryId") == 0) {
				Users users = (Users)session.getAttribute("loginUser");
				// 유저 아이디로 런드리 찾기
				Laundry laundry = laundryService.selectByUserId(users.getUserId());
				map.put("laundryId", laundry.getLaundryId());
			}
			StatisticsTotal statisticsTotal = statisticsService.searchTotalStatistics(map);
			List<StatisticsDetail> statisticsDetails = statisticsService.searchDetailStatistics(map);
			SuccessView.printStatisticsTotal(statisticsTotal);
			SuccessView.printStatisticsDetail(statisticsDetails);
			
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}
