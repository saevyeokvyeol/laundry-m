package com.laundry_m.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import com.laundry_m.mvc.service.LaundryService;
import com.laundry_m.mvc.service.LaundryServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

public class LaundryController {
	
	private LaundryService laundryService = new LaundryServiceImpl();
	private Session session = Session.getInstance();
	
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
	
	/**
	 * 세탁소 정보 수정
	 * */
	public void updateLaundry(Laundry laundry) {
		
		try {
			laundryService.updateLaundry(laundry);
			SuccessView.printMessage("세탁소 수정 성공");
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 가격 등록
	 * */
	public void insertFee(Fee fee) {
		try {
			laundryService.insertFee(fee);
			SuccessView.printMessage("세탁소 가격 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 가격 수정
	 * */
	public void updateFee(Fee fee) {
		try {
			laundryService.updateFee(fee);
			SuccessView.printMessage("세탁소 가격 수정 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 옷 등록
	 * */
	public void insertClothes(Clothes clothes) {
		try {
			laundryService.insertClothes(clothes);
			SuccessView.printMessage("세탁소 옷 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * 세탁소 천 등록
	 * */
	public void insertFabric(Fabric fabric) {
		try {
			laundryService.insertFabric(fabric);
			SuccessView.printMessage("세탁소 천 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 추가 가격 등록
	 * */
	public void insertExtraFee(ExtraFee extraFee) {
		try {
			laundryService.insertExtraFee(extraFee);
			SuccessView.printMessage("세탁소 추가 가격 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 추가 가격 수정
	 * */
	public void updateFee(ExtraFee extraFee) {
		try {
			laundryService.updateExtraFee(extraFee);
			SuccessView.printMessage("세탁소 추가 가격 수정 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 추가 가격 삭제
	 * */
	public void deleteFee(ExtraFee extraFee) {
		try {
			laundryService.deleteExtraFee(extraFee);
			SuccessView.printMessage("세탁소 추가 가격 삭제 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 이름으로 찾기
	 * */
	public void selectByNameLaundry(String LaundryName) {
		
		List<Double> distanceList = new ArrayList<Double>();
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			List<Laundry> list = laundryService.selectByNameLaundry(LaundryName);
			
			for(Laundry laundry : list) {
				//각각의 세탁소별 유저와의 거리 구한다
				double distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			SuccessView.printLaundryList(list, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 주소로 찾기
	 * */
	public void selectByAddressLaundry(String LaundryAddress) {
		
		List<Double> distanceList = new ArrayList<Double>();
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			List<Laundry> list = laundryService.selectByAddressLaundry(LaundryAddress);
			
			for(Laundry laundry : list) {
				//각각의 세탁소별 유저와의 거리 구한다
				double distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			SuccessView.printLaundryList(list, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 아이디로 찾기
	 * */
	public void selectByLaundryId(String LaundryId) {
		
		List<Double> distanceList = new ArrayList<Double>();
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			List<Laundry> list = laundryService.selectByLaundryId(LaundryId);
			
			for(Laundry laundry : list) {
				//각각의 세탁소별 유저와의 거리 구한다
				double distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			SuccessView.printLaundryList(list, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 옷 가격 최저가 세탁소 검색
	 * */
	public void selectByLowestByLaundry(Long clothesId, Long FabricId) {
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Laundry laundry = laundryService.selectByLowestByLaundry(clothesId, FabricId);
			
			double distance = laundryService.userBetweenLaun(users, laundry);
			
			SuccessView.printLaundry(laundry, distance);
			
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
}
	
	