package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.laundry_m.mvc.vo.Favorite;

public interface FavoriteDao {
	/**
	 * 즐겨찾기 추가
	 * @param: Favorite favorite(유저 아이디, 점포 아이디)
	 * @return: int(등록된 레코드 수)
	 * */
	int addFavorite(Favorite favorite) throws SQLException;

	/**
	 * 즐겨찾기 삭제
	 * @param: Long favoriteId
	 * @return: int(삭제된 레코드 수)
	 * */
	int deleteFavorite(Long favoriteId) throws SQLException;

	/**
	 * 유저 아이디로 즐겨찾기 검색
	 * @param: Long userId
	 * @return: List<Favorite>
	 * */
	List<Favorite> searchFavoriteByUserId(String userId) throws SQLException;

	/**
	 * 점포 아이디로 즐겨찾기
	 * @param: Long laundryId
	 * @return: List<Favorite>
	 * */
	List<Favorite> searchFavoriteByLaundryId(Long laundryId) throws SQLException;
	
	/**
	 * 점포 아이디 즐겨찾기 유무
	 * @param: Favorite favorite
	 * @return: List<Favorite>
	 * */
	Favorite existFavoriteByLaundryId(Favorite favorite) throws SQLException;
	
}