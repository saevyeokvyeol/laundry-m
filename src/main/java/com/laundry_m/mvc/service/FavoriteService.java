package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Favorite;

public interface FavoriteService {
	/**
	 * 즐겨찾기 추가
	 * @param: Favorite favorite(유저 아이디, 점포 아이디)
	 * @exception: NotLoginException(로그인하지 않고 추가를 시도할 경우 오류)
	 * 			   NotExistException(점포 아이디나 회원 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   DuplicationException(점포 아이디와 회원 아이디에 일치하는 즐겨찾기가 이미 있을 경우 오류)
	 * 			   InvalidUserException(세탁소 운영 회원이 즐겨찾기를 시도할 경우 오류)
	 * */
	void addFavorite(Favorite favorite) throws SQLException, NotLoginException, NotExistException, DuplicationException, InvalidUserException;

	/**
	 * 즐겨찾기 삭제
	 * @param: Long favoriteId
	 * @exception: NotLoginException(로그인하지 않고 삭제를 시도할 경우 오류)
	 * 			   NotExistException(즐겨찾기 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(세탁소 운영 회원이 즐겨찾기를 시도할 경우 오류)
	 * */
	void deleteFavorite(Long favoriteId) throws SQLException, NotLoginException, NotExistException, InvalidUserException;

	/**
	 * 유저 아이디로 즐겨찾기 검색
	 * @param: Long userId
	 * @return: List<Favorite>
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * 			   InvalidUserException(해당 회원이 아닌 회원이 즐겨찾기를 검색할 경우 오류)
	 * */
	List<Favorite> searchFavoriteByUserId(String userId) throws SQLException, NotLoginException, NotExistException, InvalidUserException;

	/**
	 * 점포 아이디로 즐겨찾기
	 * @param: Long laundryId
	 * @return: List<Favorite>
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * */
	List<Favorite> searchFavoriteByLaundryId(Long laundryId) throws SQLException, NotLoginException;
	
	/**
	 * 점포 아이디 즐겨찾기 유무
	 * @param userId 
	 * @param: Long laundryId
	 * @return: List<Favorite>
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * */
	Favorite existFavoriteByLaundryId(Favorite favorite) throws SQLException, NotLoginException;
	
}