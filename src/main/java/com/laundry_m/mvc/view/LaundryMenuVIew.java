package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.FavoriteController;
import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Laundry;

public class LaundryMenuVIew {
	private static Scanner sc = new Scanner(System.in);
	private static LaundryController laundryController = new LaundryController();
	private static FavoriteController favoriteController = new FavoriteController();
	private static Session session = Session.getInstance();

	
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
				//laundryController.insertLaundry(laundry);
				
			} catch (Exception e) {
				FailView.errorMessage("세탁소 등록에 실패했어요");
			}
		}
	}
	
	/**
	 * 세탁 방법 추천 메뉴
	 * */
	public static void recomWashMethod() {
		
		Fabric fabric = null;
		
		boolean run = true;
		while (run) {
			try {
				System.out.println("세탁하실 옷 종류를 선택하세요");
				String[] clothes = {"","상의/자켓","하의","스커트","와이셔츠/남방","티셔츠","블라우스","원피스","스웨터/가디건","봄가을점퍼/아웃도어","코트","가죽/모피의류","겨울패딩/점퍼","넥타이","스카프/목도리","이불/침구류","커튼/카페트","한복류","모자","가방/기타가죽제품","운동화/스니커즈류"};
				for(int i = 1 ; i <= clothes.length ; i++) {
					System.out.println(i+"."+ clothes[i]);
					if(i == 20) break;
				}
				System.out.println("=========================");
				System.out.print("옷 종류 선택 : ▶ ");
				int clothesId = Integer.parseInt(sc.nextLine());
				
				String[] fabrics = {"","면","니트","레이온","데님","실크/쉬폰","린넨","퍼","앙고라","가죽"};
				for(int i = 1 ; i <= fabrics.length ; i++) {
					System.out.println(i+"."+ fabrics[i]);
					if(i == 9) break;
				}
				
				System.out.println("=========================");
				System.out.print("옷감 종류 선택 : ▶ ");
				int fabricId = Integer.parseInt(sc.nextLine());
				String washMethod = laundryController.selectWashByFabric(fabricId);
				System.out.println();
				System.out.println("♣ 이 옷은 " + washMethod + " 으로 세탁하는걸 추천드려요 ♣");
				
				System.out.println("회원님의 근처에서 가장 저렴한 세탁소를 추천드릴게요 :) ");
				System.out.println();
				//전체 세탁소 돌면서 옷 + 옷감 가격 구한다
				laundryController.selectByLowestByLaundry(clothesId, fabricId);
				
				System.out.println();
				System.out.println("위 세탁소로 바로 예약하시겠어요? (Y/N)");
				session.getAttribute("laundry");
				session.getAttribute("distance");
				
				System.out.print("▶");
				String answer = sc.nextLine();
				if(answer == "Y") {
					//예약하기로 이동
					break;
				}
				//취소
				break;
				
			} catch (Exception e) {
				FailView.errorMessage("세탁소 검색에 실패했어요");
			}
		}
	}
	
	
	/**
	 * 내 근처 세탁소 찾기 메뉴 - 예약으로 이동
	 * */
	public static void findLaundry() {
		
		Long laundryId = null;
		
		boolean run = true;
		while(run) {
			
			try {
				laundryController.selectByMyLaundry();
				
				System.out.println("\n" + "[ 1. 예약하기 | 2. 단골 세탁소 등록 | 3. 뒤로가기 ]");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
				case 1:
					System.out.println();
					System.out.println("☞ 예약하실 세탁소 고유번호를 입력해주세요");
					System.out.print("▶ ");
					laundryId = Long.parseLong(sc.nextLine());
					
					System.out.println("☞ 해당 세탁소로 바로 예약하시겠어요? (Y/N)");
					System.out.print("▶ ");
					String answer = sc.nextLine();
					if(answer == "Y") {
						//예약하기로 이동
						break;
					}
					//취소
					
					break;
				case 2:
					try {
						System.out.println("즐겨찾기 추가할 세탁소 번호를 입력해주세요");
						System.out.print("▶ ");
						Long laundryid = Long.parseLong(sc.nextLine());
						Favorite favorite = favoriteController.existFavoriteByLaundryId(laundryid);
						if(favorite == null) {
							Favorite favorites = Favorite.builder().laundryId(laundryid).build();
							favoriteController.addFavorite(favorites);
							break;
						}else {
							FailView.errorMessage("이미 즐겨찾기 목록에 있습니다");
						}
					} catch (Exception e) {
						FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
					}
					break;
				case 3:	
					run = false;
					break;
				
				}
				
			} catch (Exception e) {
				FailView.errorMessage("주변 세탁소를 찾지 못했어요 :( ");
			}
		}
		
		
	}
	
	/**
	 * 세탁소 이름으로 찾기 - 예약으로 이동
	 * */
	public static void selectByLaundryName() {
		
		Long laundryId = null;
		boolean run = true;
		while(run) {
		
			try {
				System.out.println("검색할 세탁소 이름을 입력해주세요");
				System.out.print("▶ ");
				String laundryName = sc.nextLine();
				laundryController.selectByNameLaundry(laundryName);
				
				System.out.println("\n" + "[ 1. 예약하기 | 2. 단골 세탁소 등록 | 3. 뒤로가기 ]");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
				case 1:
					System.out.println();
					System.out.println("☞ 예약하실 세탁소 고유번호를 입력해주세요");
					System.out.print("▶ ");
					laundryId = Long.parseLong(sc.nextLine());
					
					System.out.println("☞ 해당 세탁소로 바로 예약하시겠어요? (Y/N)");
					System.out.print("▶ ");
					String answer = sc.nextLine();
					if(answer == "Y") {
						//예약하기로 이동
						break;
					}
					//취소
					
					break;
				case 2:
					try {
						System.out.println("즐겨찾기 추가할 세탁소 번호를 입력해주세요");
						System.out.print("▶ ");
						Long laundryid = Long.parseLong(sc.nextLine());
						Favorite favorite = favoriteController.existFavoriteByLaundryId(laundryid);
						if(favorite == null) {
							Favorite favorites = Favorite.builder().laundryId(laundryid).build();
							favoriteController.addFavorite(favorites);
							break;
						}else {
							FailView.errorMessage("이미 즐겨찾기 목록에 있습니다");
						}
					} catch (Exception e) {
						FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
					}
					break;
				case 3:	
					run = false;
					break;
				
				}
			} catch (Exception e) {
				FailView.errorMessage("에러가 발생했어요 :( ");
			}
		
		}
	}
	
	/**
	 * 세탁소 위치로 찾기 - 예약으로 이동 
	 * */
	public static void selectByLaundryLocation() {
		
		Long laundryId = null;
		boolean run = true;
		while(run) {
		
			try {
				System.out.println("검색할 구를 입력해주세요");
				System.out.print("▶ ");
				String laundryLocation= sc.nextLine();
				laundryController.selectByAddressLaundry(laundryLocation);
				
				System.out.println("\n" + "[ 1. 예약하기 | 2. 단골 세탁소 등록 | 3. 뒤로가기 ]");
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
				case 1:
					System.out.println();
					System.out.println("☞ 예약하실 세탁소 고유번호를 입력해주세요");
					System.out.print("▶ ");
					laundryId = Long.parseLong(sc.nextLine());
					
					System.out.println("☞ 해당 세탁소로 바로 예약하시겠어요? (Y/N)");
					System.out.print("▶ ");
					String answer = sc.nextLine();
					if(answer == "Y") {
						//예약하기로 이동
						break;
					}
					//취소
					break;
					
				case 2:
					System.out.println();
					System.out.println("☞ 단골으로 등록하실 세탁소 고유번호를 입력해주세요");
					System.out.print("▶ ");
					laundryId = Long.parseLong(sc.nextLine());
					//단골 등록으로 이
					
					break;
				case 3:	
					run = false;
					break;
				
				}
			} catch (Exception e) {
				FailView.errorMessage("에러가 발생했어요 :( ");
			}
		
		}
	}
	
	/**
	 * 사장님 아이디로 검색
	 * */
	public static void selectByLaundryUserId() {
		
		try {
			System.out.println("검색할 사장님 아이디를 입력해주세요");
			System.out.print("▶ ");
			String userId = sc.nextLine();
			laundryController.selectByUserId(userId);
			
		} catch (Exception e) {
			FailView.errorMessage("에러가 발생했어요 :( ");
		}
		
		
	}
	
	
}
