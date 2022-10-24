package com.laundry_m.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.BookController;
import com.laundry_m.mvc.controller.MetapayController;
import com.laundry_m.mvc.service.MetapayService;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;

public class MetapayMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static MetapayController metapayController = new MetapayController();
	
	/**
	 * 메타페이 가입 여부
	 * */
	public static void metapayCheck() {
		try {
			Metapay metapay = metapayController.metapayCheck();
			if (metapay == null) {
				System.out.println("\n메타페이 가입자가 아닙니다.\n지금 가입하시겠습니까?");
				System.out.println("[ 1. 예 | 2. 아니오]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
				case 1:
					joinMetapayForm();
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 메뉴를 선택했습니다.");
					break;
				}
			} else {
				System.out.println("메타페이 비밀번호를 입력해주세요.");
				System.out.print("▶ ");
				String password = sc.nextLine();
				if (metapay.getMetapayPassword().equals(password)) {
					MenuView.customerMetapayMenu();
				} else {
					System.out.println("비밀번호가 올바르지 않습니다.");
				}
			}
		} catch (Exception e) {
			FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}
	
	/**
	 * 메타페이 가입 메뉴
	 * */
	public static void joinMetapayForm() {
		try {
			System.out.println("\n결제 비밀번호를 입력해주세요.");
			System.out.print("▶ ");
			String metapayPassword = sc.nextLine();
			
			System.out.println("\n비밀번호를 다시 한 번 입력해주세요.");
			System.out.print("▶ ");
			String checkPassword = sc.nextLine();

			System.out.println("\n결제 계좌 은행을 선택해주세요.");
			System.out.println("[ 1. 농협 | 2. 국민 | 3. 우리 | 4. 하나 ]");
			Long bankId = (long) Integer.parseInt(sc.nextLine());

			System.out.println("\n결제 계좌 번호를 입력해주세요.");
			System.out.print("▶ ");
			String payAccountNumber = sc.nextLine();
			
			PayAccount payAccount = PayAccount.builder().bankId(bankId).payAccountNumber(payAccountNumber).build();
			List<PayAccount> payAccounts = new ArrayList<PayAccount>();
			payAccounts.add(payAccount);
			Metapay metapay = Metapay.builder().metapayPassword(metapayPassword).payAccount(payAccounts).build();
			metapayController.joinMetapay(metapay);
		} catch (Exception e) {
			FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}
	
	/**
	 * 메타페이 계좌 연동 해지
	 * */
	public static void deleteMetapayAccount() {
		System.out.println("\n해지할 계좌 코드를 입력해주세요.");
		System.out.println();
		metapayController.searchPayAccountByUserId();
		System.out.print("▶ ");
		Long payAccountId = (long) Integer.parseInt(sc.nextLine());
		metapayController.deleteMetapayAccount(payAccountId);
	}

}
