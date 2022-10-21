package com.laundry_m.mvc.controller;

import org.springframework.stereotype.Controller;

import com.laundry_m.mvc.domain.Laundry;
import com.laundry_m.mvc.service.LaundryService;
import com.laundry_m.mvc.service.LaundryServiceImpl;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;

@Controller
public class LaundryController {
	
	
	private LaundryService laundryService = new LaundryServiceImpl();
	
	/**
	 * 세탁소 등록
	 * */
	public void insertLaundry(Laundry laundry) {
		try {
			laundryService.insertLaundry(laundry);
			SuccessView.printMessage("세탁소 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
	
	