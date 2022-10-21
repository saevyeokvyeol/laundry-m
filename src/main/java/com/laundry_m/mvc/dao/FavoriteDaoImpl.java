package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.vo.Favorite;

public class FavoriteDaoImpl implements FavoriteDao {

	@Override
	public int addFavorite(Favorite favorite) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFavorite(Long favoriteId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Favorite> searchFavoriteByUserId(Long userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Favorite> searchFavoriteByLaundryId(Long laundryId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
