package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

public class LaundryMenuVIew {
	private static Scanner sc = new Scanner(System.in);
	private static LaundryController laundryController = new LaundryController();
	
	/**
	 * 세탁소 등록 폼
	 * */
	public static void laundryForm() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("등록하실 세탁소 정보를 입력해주세요.");
				System.out.print("세탁소 상호명 : ▶ ");
				String laundryName = sc.nextLine();
				
				System.out.print("세탁소 번호 : ▶ ");
				String laundryTel = sc.nextLine();
				
				System.out.print("세탁소 주소 : ▶ ");
				String laundryAddress = sc.nextLine();
				
				System.out.print("점주 계좌번호 : ▶ ");
				String laundryAccountNumber = sc.nextLine();
				
				Laundry laundry = Laundry.builder().laundryName(laundryName).laundryTel(laundryTel).laundryAddress(laundryAddress).laundryAccountNumber(laundryAccountNumber).build();
				laundryController.insertLaundry(laundry);
				
			} catch (Exception e) {
				FailView.errorMessage("세탁소 등록에 실패했어요");
			}
		}
	}
	
	
	
	/**
	 * 내 근처 세탁소 찾기 메뉴 - 예약으로 이동
	 * */
	public static void findLaundry(Users users) {
		System.out.println("현재 " + users.getUserName() + "님의 주소를 기반으로 세탁소를 검색합니다");
		
		try {
			laundryController.selectByAddressLaundry(users.getUserAddress());
			
		} catch (Exception e) {
			FailView.errorMessage("주변 세탁소를 찾지 못했어요 :( ");
		}
		
	}
	
	/**
	 * 세탁소 이름으로 찾기 - 예약으로 이동
	 * */
	public static void selectByLaundryName() {
		
		try {
			System.out.println("검색할 세탁소 이름을 입력해주세요");
			System.out.print("▶ ");
			String laundryName = sc.nextLine();
			laundryController.selectByNameLaundry(laundryName);
			
		} catch (Exception e) {
			FailView.errorMessage("에러가 발생했어요 :( ");
		}
		
		
	}

}
