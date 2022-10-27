package com.laundry_m.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.service.FavoriteService;
import com.laundry_m.mvc.service.FavoriteServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Users;

public class FavoriteController {
	private FavoriteService favoriteService = new FavoriteServiceImpl();
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
	public void deleteFavorite(Long favoriteId) {
		 try {
				//로그인 세션
				favoriteService.deleteFavorite(favoriteId);
				SuccessView.printMessage("즐겨찾기가 삭제되었습니다.");
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
			  List<Favorite> favorites = favoriteService.searchFavoriteByUserId(users.getUserId());
			 if(favorites==null || favorites.size()==0) {
			 }
			  SuccessView.printFavorite(favorites);
			  
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
			  SuccessView.printFavorite(favorites);
		  }catch(Exception e) {
			  e.printStackTrace();
			  FailView.errorMessage(e.getMessage());
		  }
	}
	/**
	 * 점포 아이디 즐겨찾기 유무
	 * @param: Long laundryId
	 * */
	public Favorite existFavoriteByLaundryId(Long laundryId){
		Favorite resultFavorite = null;
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Favorite favorite = Favorite.builder().userId(users.getUserId()).laundryId(laundryId).build();
			resultFavorite = favoriteService.existFavoriteByLaundryId(favorite);
		  }catch(Exception e) {
			  return null;
		  }
		 return resultFavorite;
	}
}
