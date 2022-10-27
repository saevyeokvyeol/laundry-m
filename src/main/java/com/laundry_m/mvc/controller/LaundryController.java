package com.laundry_m.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

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
	public void insertLaundry(SqlSession session, Laundry laundry) {
		try {
			laundryService.insertLaundry(session, laundry);
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
	public void insertFee(SqlSession session, Fee fee) {
		try {
			laundryService.insertFee(session, fee);
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
			Laundry laundry = selectLaundryByLoginUserId();
			fee.setLaundryId(laundry.getLaundryId());
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
	public void insertExtraFee(SqlSession session, ExtraFee extraFee) {
		try {
			laundryService.insertExtraFee(session, extraFee);
			SuccessView.printMessage("세탁소 추가 가격 등록 성공");

		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 추가 가격 수정
	 * */
	public void updateExtraFee(ExtraFee extraFee) {
		try {
			Laundry laundry = selectLaundryByLoginUserId();
			extraFee.setLaundryId(laundry.getLaundryId());
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
		
		List<Integer> distanceList = new ArrayList<Integer>();
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			List<Laundry> list = laundryService.selectByNameLaundry(LaundryName);
			
			for(Laundry laundry : list) {
				//각각의 세탁소별 유저와의 거리 구한다
				int distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			
			//세션에 검색 결과 저장
			session.setAttribute("findByNameLaundry", list);
			session.setAttribute("findByNamedistance", distanceList);
			
			SuccessView.printLaundryList(list, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 주소로 찾기
	 * */
	public void selectByAddressLaundry(String LaundryAddress) {
		
		List<Integer> distanceList = new ArrayList<Integer>();
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			List<Laundry> list = laundryService.selectByAddressLaundry(LaundryAddress);
			
			for(Laundry laundry : list) {
				//각각의 세탁소별 유저와의 거리 구한다
				int distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			
			//세션에 검색 결과 저장
			session.setAttribute("findByAddressLaundry", list);
			session.setAttribute("findByAddressdistance", distanceList);
			
			SuccessView.printLaundryList(list, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 아이디로 찾기
	 * print in SuccessView
	 * */
	public void selectByUserId(String userId) {
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Laundry laundry = laundryService.selectByUserId(users.getUserId());
			
			
			int distance = laundryService.userBetweenLaun(users, laundry);
			
			SuccessView.printLaundry(laundry, distance);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 세탁소 사장님 아이디로 찾기
	 * */
	public void selectByLaundryOwnerId(String userId) {
		try {
			
			Laundry laundry = laundryService.selectByUserId(userId);
			
			SuccessView.printOnlyLaundry(laundry);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		
	}
	
	/**
	 * 세탁소 로그인된 아이디로 찾기
	 * return : laundry
	 * */
	public Laundry selectLaundryByLoginUserId() {
		Laundry laundry = new Laundry();
		try {
			Users user = (Users) session.getAttribute("loginUser");
			String id = user.getUserId();
			laundry = laundryService.selectByUserId(id);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return laundry;
	}
	
	
	/**
	 * 옷 가격 최저가 세탁소 검색
	 * */
	public void selectByLowestByLaundry(int clothesId, int FabricId) {
		
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Laundry laundry = laundryService.selectByLowestByLaundry(users.getUserAddress(),clothesId, FabricId);
			
			int distance = laundryService.userBetweenLaun(users, laundry);
			
			//세션에 검색 결과 저장
			session.setAttribute("lowestLaundry", laundry);
			session.setAttribute("distance", distance);
			
			SuccessView.printLaundry(laundry, distance);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 특정 세탁소에서 옷 + 재질 가격 더하기
	 * */
	public void clothesfabricFee(Long laundryId, int clothesId, int fabricId) {
		try {
			int result = laundryService.clothesfabricFee(laundryId, clothesId, fabricId);
			SuccessView.printMessage("총 가격 : "+ result);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 특정 세탁소에서 옷 + 재질 가격 더하기
	 * */
	public int searchLaundryFee(Long laundryId, int clothesId, int fabricId) {
		int result = 0;
		try {
			result = laundryService.clothesfabricFee(laundryId, clothesId, fabricId);
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	/**	
	 * 내 주소 기반으로 세탁소 찾기
	 * */
	public void selectByMyLaundry() {
		
		List<Integer> distanceList = new ArrayList<Integer>();

		try {
			Users users = (Users)session.getAttribute("loginUser");
			System.out.println("현재 " + users.getUserName() + "님의 주소를 기반으로 근처 세탁소를 검색합니다");
			System.out.println();
			
			List<Laundry> laundries = laundryService.selectByMyLaundry(users.getUserAddress());
			
			for(Laundry laundry : laundries) {
				int distance = laundryService.userBetweenLaun(users, laundry);
				distanceList.add(distance);
			}
			
			//세션에 검색 결과 저장
			session.setAttribute("nearByLaundry",laundries);
			session.setAttribute("mydistance", distanceList);
			
			SuccessView.printLaundryList(laundries, distanceList);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 천으로 세탁 방법 찾기
	 * */
	public String selectWashByFabric(int fabricId) {
		String washMethod = null;
		try {
			Fabric fabric = laundryService.selectWashByFabric(fabricId);
			washMethod = fabric.getFabricWashMethod();
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
		return washMethod;
	}
	
	/**
	 * 세탁소 정보 조회
	 * */
	public void selectLaundryAll() {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Laundry laundry = laundryService.selectByUserId(users.getUserId());
			
			SuccessView.printMyLaundry(users, laundry);
			
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 세탁소 상세 정보 보기 폼
	 * */
	public Map<List<Object>, String> laundryDetailForm(Long laundryId){
		
		Map<List<Object>, String> map = new HashMap<List<Object>, String>();
		
		List<Fee> feeList = this.selectAllFee(laundryId);
		List<ExtraFee> extraList = this.selectAllExtraFee(laundryId);
		
		
		
		return null;
	}
	
	
	/**
	 * 세탁소 상세 정보 보기 - 기본 메뉴, 가격
	 * */
	public List<Fee> selectAllFee(Long laundryId){
		Laundry laundry = null;
		
		try {
			laundry = laundryService.selectAllFee(laundryId);
			SuccessView.printLaundryFee(laundry.getFee());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
		return laundry.getFee();
	}
	
	/**
	 * 세탁소 추가 가격 메뉴 보기
	 * */
	public List<ExtraFee> selectAllExtraFee(Long laundryId){
		Laundry laundry = null;
		
		try {
			laundry = laundryService.selectAllExtraFees(laundryId);
			SuccessView.printLaundryExFee(laundry.getExtraFee());
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
		return laundry.getExtraFee();
	}
}
	
	