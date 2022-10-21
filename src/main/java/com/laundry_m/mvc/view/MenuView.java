package com.laundry_m.mvc.view;

import java.util.Scanner;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 시작 메뉴
	 * : 회원가입을 하거나 로그인을 통해 각 롤에 맞는 메뉴로 입장
	 * */
	public static void menuView() {
		while (true) {
			try {
				System.out.println("\n" + "[ 1. 회원가입 | 2. 로그인 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 일반 고객 메인 메뉴
	 * : 세탁소를 찾거나 마이페이지로 이동
	 * */
	public static void customerMenu() {
		while (true) {
			try {
				System.out.println("\n" + "[ 1. 세탁소 찾기 | 2. 단골 세탁소 | 3. 세탁 방법 추천 | 4. 마이페이지 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 4 :
					
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 세탁소 검색 메뉴
	 * : 세탁소 검색으로 진입
	 * */
	public static void laundrySearchMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 내 근처 세탁소 찾기 | 2. 이름으로 찾기 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 일반 회원 마이페이지 메뉴
	 * */
	public static void customerMypageMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 진행 중인 예약 내역 | 2. 지난 이용 내역 | 3. 내 리뷰 관리 | 4. 내 정보 수정 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 세탁소 사장님 메인 메뉴
	 * : 세탁소를 찾거나 마이페이지로 이동
	 * */
	public static void laundryMenu() {
		while (true) {
			try {
				System.out.println("\n" + "[ 1. 내 세탁소 보기 | 2. 예약 내역 조회 | 3. 리뷰 조회 | 4. 매출 통계 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 4 :
					
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 사장님 세탁소 관리 메뉴
	 * */
	public static void laundryManageMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 세탁소 정보 보기 | 2. 세탁소 정보 수정 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 사장님 예약 관리 메뉴
	 * */
	public static void laundryBookManageMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 진행 중인 예약 보기 | 2. 예약 상태별 보기 | 3. 예약 상태 변경 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
		
	/**
	 * 관리자 메뉴
	 * */
	public static void adminMenu() {
		while (true) {
			try {
				System.out.println("\n" + "[ 1. 회원 관리 | 2. 사장님 관리 | 3. 예약 관리 | 4. 매출 통계 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 4 :
					
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 관리자 회원 관리 메뉴
	 * */
	public static void adminUserMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 아이디로 검색 | 2. 이름으로 검색 | 3. 주소로 검색 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 관리자 사장님 관리 메뉴
	 * */
	public static void adminLaundryMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 세탁소 이름으로 검색 | 2. 세탁소 위치로 검색 | 3. 사장님 아이디로 검색 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 관리자 예약 관리 메뉴
	 * */
	public static void adminBookMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 날짜로 예약 검색 | 2. 날짜별 예약 통계 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 관리자 매출 관리 메뉴
	 * */
	public static void adminProfitMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 총 매출 통계 | 2. 일별 매출 통계 | 3. 품목별 매출 통계 | 4. 세탁소별 매출 통계 | 5. 회원별 매출 통계 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					
					break;
				case 2 :
					
					break;
				case 3 :
					
					break;
				case 4 :
					
					break;
				case 5 :
					
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
	
	/**
	 * 프로그램 종료 메소드
	 * */
	public static void exit() {
		System.out.println("런드리엠이 종료되었습니다.");
		System.out.println("이용해주셔서 감사합니다.");
		System.exit(0);
	}
}
