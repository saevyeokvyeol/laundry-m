package com.laundry_m.mvc.controller;

import com.laundry_m.mvc.service.MetapayService;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.Users;

public class MetapayController {
	private MetapayService metapayService;
	private Session session = Session.getInstance();

	public void joinMetapay(Metapay metapay) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			metapay.setUserId(users.getUserId());
			metapayService.joinMetapay(metapay);
			SuccessView.printMessage("메타페이 가입이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void searchMetapayByUserId() {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			metapayService.searchMetapayByUserId(users.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public boolean MetapayApplicable() {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Metapay metapay = metapayService.searchMetapayByUserId(users.getUserId());
			if (metapay != null) return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
	}
}
