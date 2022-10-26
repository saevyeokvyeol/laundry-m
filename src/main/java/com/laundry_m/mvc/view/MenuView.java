package com.laundry_m.mvc.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.laundry_m.mvc.controller.BookController;
import com.laundry_m.mvc.controller.FavoriteController;
import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.controller.MetapayController;
import com.laundry_m.mvc.controller.ReviewController;
import com.laundry_m.mvc.controller.StatisticsController;
import com.laundry_m.mvc.controller.UsersController;

public class MenuView {
	private static Scanner sc = new Scanner(System.in);
	private static BookController bookController = new BookController();
	private static MetapayController metapayController = new MetapayController();
	private static UsersController usersController = new UsersController();
	private static ReviewController reviewController = new ReviewController();
	private static StatisticsController statisticsController = new StatisticsController();
	private static LaundryController laundryController = new LaundryController();
	private static FavoriteController favoriteController = new FavoriteController();
	
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
					InsertUserView.insertUserForm();
					break;
				case 2 :
					System.out.print("\n아이디 입력 > ");
					String loginId = sc.nextLine();
					System.out.print("비밀번호 입력 > ");
					String loginPwd = sc.nextLine();
					usersController.loginUser(loginId, loginPwd);
					break;
				case 0 : 
					MenuView.exit();
				default:
					System.out.println("메뉴를 잘못 선택하셨습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
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
					laundrySearchMenu();
					break;
				case 2 :
					favoriteMenu();
					break;
				case 3 :
					LaundryMenuVIew.recomWashMethod();
					break;
				case 4 :
					customerMypageMenu();
					break;
				case 9 : 
					usersController.logout();
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
					LaundryMenuVIew.findLaundry();
					break;
				case 2 :
					LaundryMenuVIew.selectByLaundryName();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
	 * 알아서 써주세요><
	 * */
	public static void laundryDetail(String keyword) {
		System.out.println();
	}
	
	
	/**
	 * 일반 회원 마이페이지 메뉴
	 * */
	public static void customerMypageMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 진행 중인 예약 내역 | 2. 지난 이용 내역 | 3. 내 리뷰 관리 | 4. 내 정보 확인 & 수정 | 5. 메타페이 관리 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					bookController.searchBookByUserId(1L, 7L);
					break;
				case 2 :
					bookController.searchBookByUserId(8L, 10L);
					break;
				case 3 :
					reviewpageMenu();
					break;
				case 4 :
					UserMenuView.updateUserInfoForm();
					break;
				case 5 :
					MetapayMenuView.metapayCheck();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
	 * 일반 리뷰 마이페이지 메뉴
	 * */
	public static void reviewpageMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 내가 쓴 리뷰 리스트 | 2. 리뷰 쓰기 | 3. 리뷰 수정 | 4.리뷰 삭제 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					reviewController.searchReviewByUserId();
					break;
				case 2 :
					ReviewMenuView.reviewForm();
					break;
				case 3 :
					ReviewMenuView.reviewUpdateForm();
					break;
				case 4 :
					ReviewMenuView.deleteForm();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
	 * 일반 회원 메타페이 메뉴
	 * */ 
	public static void customerMetapayMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 내 메타페이 정보 보기 | 2. 최근 거래 내역 보기 | 3. 연결 계좌 변경 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					metapayController.searchMetapayByUserId();
					break;
				case 2 :
					
					break;
				case 3 :
					MetapayMenuView.addMetapayAccount();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
	}/**
	 * 일반 회원 단골 세탁소 메뉴
	 * */
	public static void favoriteMenu() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 내 단골세탁소 리스트 | 2. 내 근처 단골세탁소 추가 | 3. 이름으로 단골세탁소 추가 | 4. 단골세탁소 삭제 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					favoriteMenuView.searchFavoriteList();
					break;
				case 2 :
					favoriteMenuView.searchFavoriteByLaundryAddress();
					break;
				case 3 :
					favoriteMenuView.searchFavoriteByLaundryName();
					break;
				case 4 :
					favoriteMenuView.deleteFavorite();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
				System.out.println("\n" + "[ 1. 내 세탁소 관리 | 2. 예약 내역 조회 | 3. 리뷰 조회 | 4. 매출 통계 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					laundryManageMenu();
					break;
				case 2 :
					laundryBookManageMenu();
					break;
				case 3 :
					reviewController.searchReviewByLaundryId();
					break;
				case 4 :
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("laundryId", 0L);
					statisticsController.searchStatistics(map);
					break;
				case 9 : 
					usersController.logout();
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
					laundryController.selectLaundryAll();
					break;
				case 2 :
					laundryUpdateView.laundryInfoUpdateForm();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
					bookController.searchBookByLaundryId(1L, 7L);
					break;
				case 2 :
					BookMenuView.searchBookByLaundryIdAndBookStateId();
					break;
				case 3 :
					BookMenuView.updateBookState();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
				System.out.println("\n" + "[ 1. 회원 관리 | 2. 사장님 관리 | 3. 예약 관리 | 4. 세탁소 통계 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					adminUserMenu();
					break;
				case 2 :
					adminLaundryMenu();
					break;
				case 3 :
					adminBookMenu();
					break;
				case 4 :
					adminProfitMenu();
					break;
				case 9 : 
					usersController.logout();
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
					adminUserMenu.selectByUserId();
					break;
				case 2 :
					adminUserMenu.selectByUserName();
					break;
				case 3 :
					adminUserMenu.selectByUserAddress();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
					LaundryMenuVIew.selectByLaundryName();
					break;
				case 2 :
					LaundryMenuVIew.selectByLaundryLocation();
					break;
				case 3 :
					LaundryMenuVIew.selectByLaundryUserId();
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
				System.out.println("\n" + "[ 1. 전체 예약 검색 | 2. 날짜로 예약 검색 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					bookController.searchBookAll();
					break;
				case 2 :
					System.out.println("\n" + "검색할 날짜를 입력해주세요. (ex.20221021)");
					while (true) {
						System.out.print("▶ ");
						String date = sc.nextLine();
						if (date.length() == 8 && Integer.parseInt(date) > 0) {
							bookController.searchBookByDate(date);
							break;
						} else {
							System.out.println("날짜는 YYYYMMDD 형식으로 입력해주세요.");
						}
					}
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
				System.out.println("\n" + "[ 1. 총 매출 통계 | 2. 일별 매출 통계 | 3. 세탁소별 매출 통계 | 4. 회원별 매출 통계 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				Map<String, Object> map = new HashMap<String, Object>();
				switch(menu) {
				case 1 :
					statisticsController.searchStatistics(map);
					break;
				case 2 :
					System.out.println("\n" + "날짜를 입력해주세요.");
					System.out.print("▶ ");
					String date = sc.nextLine();
					map.put("date", date);
					statisticsController.searchStatistics(map);
					break;
				case 3 :
					System.out.println("\n" + "세탁소 아이디를 입력해주세요.");
					System.out.print("▶ ");
					Long laundryId = (long) Integer.parseInt(sc.nextLine());
					map.put("laundryId", laundryId);
					statisticsController.searchStatistics(map);
					break;
				case 4 :
					System.out.println("\n" + "유저 아이디를 입력해주세요.");
					System.out.print("▶ ");
					String userId = sc.nextLine();
					map.put("userId", userId);
					statisticsController.searchStatistics(map);
					break;
				case 8 :
					run = false;
					break;
				case 9 : 
					usersController.logout();
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
		System.out.println("런드리M이 종료되었습니다.");
		System.out.println("이용해주셔서 감사합니다.");
		System.exit(0);
	}
}
