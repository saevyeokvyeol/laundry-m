package com.laundry_m.mvc.view;

import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.FavoriteController;
import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Review;

public class favoriteMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static FavoriteController favoriteController = new FavoriteController();
	private static LaundryController laundryController = new LaundryController();
	private static Session session = Session.getInstance();
	
	public static void searchFavoriteByLaundryAddress() {
		boolean run = true;
			try {
				LaundryMenuVIew.findLaundry();
				System.out.println("즐겨찾기 추가할 번호를 입력해주세요");
				System.out.print("▶ ");
				Long laundryid = Long.parseLong(sc.nextLine());
				Laundry laundry = ((List<Laundry>)session.getAttribute("laundry")).get((int) (laundryid - 1));
				Favorite favorites = Favorite.builder().laundryId(laundry.getLaundryId()).build();
				
				favoriteController.addFavorite(favorites);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
	}

	public static void searchFavoriteByLaundryName(String keyword) {
		boolean run = true;
			try {
				LaundryMenuVIew.selectByLaundryName();
				System.out.println("즐겨찾기 추가할 번호를 입력해주세요");
				System.out.print("▶ ");
				Long laundryid = Long.parseLong(sc.nextLine());
				Laundry laundry = ((List<Laundry>)session.getAttribute(keyword)).get((int) (laundryid - 1));
				Favorite favorites = Favorite.builder().laundryId(laundry.getLaundryId()).build();
				
				favoriteController.addFavorite(favorites);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
	}

	public static void deleteFavorite() {
		boolean run = true;
		Long starRate;
		try {
			System.out.println("삭제할 리뷰 번호를 입력해주세요.");
			favoriteController.searchFavoriteByUserId();
			System.out.print("▶ ");
			Long favoriteId = (long)Integer.parseInt(sc.nextLine());

			favoriteController.deleteFavorite(favoriteId);
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}

}
