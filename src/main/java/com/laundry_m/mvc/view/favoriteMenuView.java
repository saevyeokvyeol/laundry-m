package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.FavoriteController;
import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.controller.UsersController;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.vo.Favorite;

public class favoriteMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static FavoriteController favoriteController = new FavoriteController();
	private static LaundryController laundryController = new LaundryController();
	private static UsersController usersController = new UsersController();
	private static Session session = Session.getInstance();
	
/*
	public static void searchFavoriteByLaundryAddress() {
			try {
				LaundryMenuVIew.findLaundry();
				System.out.println("즐겨찾기 추가할 세탁소 번호를 입력해주세요");
				System.out.print("▶ ");
				Long laundryid = Long.parseLong(sc.nextLine());
				Favorite favorite = favoriteController.existFavoriteByLaundryId(laundryid);
				if(favorite == null) {
					Favorite favorites = Favorite.builder().laundryId(laundryid).build();
					favoriteController.addFavorite(favorites);
				}else {
					FailView.errorMessage("이미 즐겨찾기 목록에 있습니다");
				}
				
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
	}

	public static void searchFavoriteByLaundryName() {
		boolean run = true;
			try {
				LaundryMenuVIew.selectByLaundryName();
				System.out.println("즐겨찾기 추가할 세탁소 번호를 입력해주세요");
				System.out.print("▶ ");
				Long laundryid = Long.parseLong(sc.nextLine());
				Favorite favorites = Favorite.builder().laundryId(laundryid).build();
				favoriteController.addFavorite(favorites);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}
*/
	public static void deleteFavorite() {
		try {
			System.out.println("삭제할 즐겨찾기 번호를 입력해주세요.");
			favoriteController.searchFavoriteByUserId();
			System.out.print("▶ ");
			Long favoriteId = (long)Integer.parseInt(sc.nextLine());
			favoriteController.deleteFavorite(favoriteId);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}

	public static void searchFavoriteList() {
		try {
			favoriteController.searchFavoriteByUserId();
				System.out.println("1. 예약하기 |  2. 즐겨찾기 삭제하기 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
					case 1:
						System.out.println("예약으로 이동할 세탁소 번호를 입력해주세요.");
						System.out.print("▶ ");
						Long laundryId = (long)Integer.parseInt(sc.nextLine());
						BookMenuView.bookForm(laundryId);
						break;
					case 2:
						favoriteMenuView.deleteFavorite();
						break;
					}
		} catch (Exception e) {
			FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}


}
