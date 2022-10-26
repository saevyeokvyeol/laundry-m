package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.UsersController;
import com.laundry_m.mvc.vo.Users;

public class adminUserMenu {
	private static UsersController usersController = new UsersController();
	private static Scanner sc = new Scanner(System.in);
	
	private final static String ID = "^[0-9a-zA-Z]*$";
	private final static String NAME = "^[가-힣]*$";
	
	public static void selectByUserId() {
		String id = null;
		while (true) {
			System.out.println();
			System.out.println("검색할 아이디를 입력해주세요.");
			System.out.print("▶ ");
			id = sc.nextLine();
			if (id.length() > 6) {
				System.out.println("아이디는 6글자 이내로 입력해주세요.");
			} else if (!id.matches(ID)) {
				System.out.println("아이디는 알파벳 소문자와 숫자만 입력해주세요.");
			} else {
				break;
			}
		}
		Users user = Users.builder().userId(id).build();
		usersController.selectByUserId(user);		
	}

	public static void selectByUserName() {
		try {
			String name = null;
			while (true) {
				System.out.println();
				System.out.println("검색할 이름을 입력해주세요.");
				System.out.print("▶ ");
				name = sc.nextLine();
				if (!name.matches(NAME)) {
					System.out.println("이름은 한글로 입력해주세요.");
				} else {
					break;
				}
			}
			Users user = Users.builder().userName(name).build();
			usersController.selectByUserName(user);		
		} catch (Exception e){
			e.printStackTrace();
			
		}
		
	}

	public static void selectByUserAddress() {
		String address = null;
		try {
			System.out.println();
			System.out.println("검색할 주소 키워드를 입력해주세요.");
			System.out.print("▶ ");
			address = sc.nextLine();
			usersController.selectByUserAddress(address);	
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
}
