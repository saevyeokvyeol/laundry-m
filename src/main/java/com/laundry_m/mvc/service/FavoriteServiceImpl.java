package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.dao.FavoriteDao;
import com.laundry_m.mvc.dao.FavoriteDaoImpl;
import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Review;

import util.DbUtil;

public class FavoriteServiceImpl implements FavoriteService{
	private FavoriteDao favoriteDao = new FavoriteDaoImpl();

	/**
	 * 즐겨찾기 추가
	 * @param: Favorite favorite(유저 아이디, 점포 아이디)
	 * @exception: NotLoginException(로그인하지 않고 추가를 시도할 경우 오류)
	 * 			   NotExistException(점포 아이디나 회원 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   DuplicationException(점포 아이디와 회원 아이디에 일치하는 즐겨찾기가 이미 있을 경우 오류)
	 * 			   InvalidUserException(세탁소 운영 회원이 즐겨찾기를 시도할 경우 오류)
	 * */
	@Override
	public void addFavorite(Favorite favorite)
			throws SQLException, NotLoginException, NotExistException, DuplicationException, InvalidUserException {
		int result = favoriteDao.addFavorite(favorite);
		if(result != 1) {
			throw new SQLException("즐겨찾기 등록에 실패했습니다.");
		}
		
	}
	
	/**
	 * 즐겨찾기 삭제
	 * @param: Long favoriteId
	 * @exception: NotLoginException(로그인하지 않고 삭제를 시도할 경우 오류)
	 * 			   NotExistException(즐겨찾기 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(세탁소 운영 회원이 즐겨찾기를 시도할 경우 오류)
	 * */
	@Override
	public void deleteFavorite(Long favoriteId)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		int result = favoriteDao.deleteFavorite(favoriteId);
		if(result != 1) {
			throw new SQLException("즐겨찾기 삭제에 실패하였습니다.");
		}
		
	}
	
	/**
	 * 유저 아이디로 즐겨찾기 검색
	 * @param: Favorite favorite
	 * @return: List<Favorite>
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * 			   InvalidUserException(해당 회원이 아닌 회원이 즐겨찾기를 검색할 경우 오류)
	 * */
	@Override
	public List<Favorite> searchFavoriteByUserId(String userId)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		List<Favorite> favorites = favoriteDao.searchFavoriteByUserId(userId);
		return favorites;
	}
	
	/**
	 * 점포 아이디로 즐겨찾기
	 * @param: Favorite favorite
	 * @return: List<Favorite>
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * */
	@Override
	public List<Favorite> searchFavoriteByLaundryId(Long laundryId) throws SQLException, NotLoginException {
		List<Favorite> favorites = favoriteDao.searchFavoriteByLaundryId(laundryId);
		return favorites;
	}

}
