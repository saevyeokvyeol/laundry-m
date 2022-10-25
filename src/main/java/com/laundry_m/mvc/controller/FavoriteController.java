package com.laundry_m.mvc.controller;

import java.util.List;

import com.laundry_m.mvc.service.FavoriteService;
import com.laundry_m.mvc.service.FavoriteServiceImpl;
import com.laundry_m.mvc.service.LaundryService;
import com.laundry_m.mvc.service.LaundryServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Review;
import com.laundry_m.mvc.vo.Users;

public class FavoriteController {
	private FavoriteService favoriteService = new FavoriteServiceImpl();
	private LaundryService laundryService = new LaundryServiceImpl();
	private Session session = Session.getInstance();
	
	/**
	 * 즐겨찾기 추가
	 * @param: Favorite favorite(유저 아이디, 점포 아이디)
	 * @return : int(등록한 레코드 수)
	 * */
	public void addFavorite(Favorite favorite) {
		try {
			Users users = (Users) session.getAttribute("loginUser");
			favorite.setUserId(users.getUserId());
			favoriteService.addFavorite(favorite);
			SuccessView.printMessage("즐겨찾기가 등록되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 즐겨찾기 삭제
	 * @param: Long favoriteId
	 * @exception: NotLoginException(로그인하지 않고 삭제를 시도할 경우 오류)
	 * 			   NotExistException(즐겨찾기 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(세탁소 운영 회원이 즐겨찾기를 시도할 경우 오류)
	 * */
	void deleteFavorite(Long favoriteId) {
		 try {
				//로그인 세션
				favoriteService.deleteFavorite(favoriteId);
				SuccessView.printMessage("리뷰가 삭제되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				FailView.errorMessage(e.getMessage());
			}
		
	}

	/**
	 * 유저 아이디로 즐겨찾기 검색
	 * @param: Long userId
	 * @return: List<Favorite>
	 * */
	public void searchFavoriteByUserId() {
		try {
			  Users users = (Users)session.getAttribute("loginUser");
			  Laundry laundrys = laundryService.selectByUserId(users.getUserId());
			  List<Favorite> favorites = favoriteService.searchFavoriteByUserId(users.getUserId());
			  SuccessView.printFavorite(favorites, laundrys);
		  }catch(Exception e) {
			  e.printStackTrace();
			  FailView.errorMessage(e.getMessage());
		  }
		
	}

	/**
	 * 점포 아이디로 즐겨찾기 검색
	 * @param: Long laundryId
	 * @return: List<Favorite>
	 * */
	public void searchFavoriteByLaundryId(Long laundryId){
		try {
			  List<Favorite> favorites = favoriteService.searchFavoriteByLaundryId(laundryId);
			  SuccessView.printFavoritebyLaundryId(favorites);
		  }catch(Exception e) {
			  e.printStackTrace();
			  FailView.errorMessage(e.getMessage());
		  }
	}

}
