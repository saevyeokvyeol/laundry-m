package com.laundry_m.mvc.controller;

import com.laundry_m.mvc.service.MetapayService;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
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
	
	public Metapay metapayCheck() {
		Metapay metapay = null;
		try {
			Users users = (Users)session.getAttribute("loginUser");
			metapay = metapayService.searchMetapayByUserId(users.getUserId());
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return metapay;
	}
	
	public void searchMetapayByUserId() {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Metapay metapay = metapayService.searchMetapayByUserId(users.getUserId());
			SuccessView.printMetapay(metapay);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void searchPayAccountByUserId() {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Metapay metapay = metapayService.searchMetapayByUserId(users.getUserId());
			SuccessView.printPayAccount(metapay.getPayAccounts());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void deleteMetapayAccount(Long payAccountId) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Metapay metapay = metapayService.searchMetapayByUserId(users.getUserId());
			PayAccount payAccount = PayAccount.builder().metapayId(metapay.getMetapayId())
					.payAccountId(payAccountId).build();
			metapayService.deleteMetapayAccount(payAccount);
			SuccessView.printMessage("계좌 번호 " + payAccountId + "가 정상적으로 연결 해지되었습니다.");
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
