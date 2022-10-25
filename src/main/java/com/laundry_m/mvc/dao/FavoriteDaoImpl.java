package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Favorite;

import util.DbUtil;

public class FavoriteDaoImpl implements FavoriteDao {

	@Override
	public int addFavorite(Favorite favorite) throws SQLException {
		//세션을 생성합니다.
				SqlSession session = null;
				int result = 0;
				boolean state = false;
				
				try {
					//DbUtil에서 세션을 가져옵니다.
					session = DbUtil.getSession();
					
					//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
					result = session.insert("favoriteMapper.addFavorite", favorite);
					if(result == 1) state = true;
					
				}finally {
					//세션을 닫습니다.
					DbUtil.sessionClose(session, state);
				}
				//결과를 리턴합니다.
				return result;
	}

	@Override
	public int deleteFavorite(Long favoriteId) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			result = session.delete("favoriteMapper.deleteFavorite", favoriteId);
			if(result == 1) state = true;		
			
		}finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	@Override
	public List<Favorite> searchFavoriteByUserId(String userId) throws SQLException {
		SqlSession session = null;
		List<Favorite> favorites = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			favorites = session.selectList("favoriteMapper.searchFavoriteByUserId", userId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return favorites;
	}

	@Override
	public List<Favorite> searchFavoriteByLaundryId(Long laundryId) throws SQLException {
		SqlSession session = null;
		List<Favorite> favorites = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			favorites = session.selectList("favoriteMapper.searchFavoriteByLaundryId", laundryId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return favorites;
	}

}
