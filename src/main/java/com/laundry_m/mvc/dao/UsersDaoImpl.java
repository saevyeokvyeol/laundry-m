package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.PayLog;
import com.laundry_m.mvc.vo.Users;

import util.DbUtil;

public class UsersDaoImpl implements UsersDao{
	private LaundryDao laundryDao = new LaundryDaoImpl();

	@Override
	public int insertUser(Users users) throws SQLException {
		int result = -1;
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			result = session.insert("usersMapper.insertUser", users);
			
			if (users.getUserType().equals("점주")) {
				Laundry laundry = users.getLaundry();
				int re = laundryDao.insertLaundry(session, laundry);
				if (re != 1) throw new SQLException("입력해주세요^^;");
				for (Fee fee : laundry.getFee()) {
					re = laundryDao.insertFee(session, fee);
					if (re != 1) throw new SQLException("입력해주세요^^;");
				}
				for (ExtraFee extraFee : laundry.getExtraFee()) {
					re = laundryDao.insertExtraFee(session, extraFee);
					if (re != 1) throw new SQLException("입력해주세요^^;");
				}
			}
			if (result == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	@Override
	public int updateUser(Users users) throws SQLException {
		int result = -1;
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			result = session.insert("usersMapper.updateUser", users);
			if (result == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	@Override
	public Users loginUser(Users users) throws SQLException {
		SqlSession session = null;
		Users loginUser = null;
		try {
			session = DbUtil.getSession();
			// id pw 일치하면
			loginUser = session.selectOne("usersMapper.loginUser", users);
		} finally {
			DbUtil.sessionClose(session);
		}
		return loginUser;
	}

	@Override
	public List<Users> selectAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users selectByUserId(Users users) throws SQLException {
		SqlSession session = null;
		Users user = null;
		try {
			session = DbUtil.getSession();
			user = session.selectOne("usersMapper.selectByUserId", users);
		} finally {
			DbUtil.sessionClose(session);
		}
		return user;
	}

	@Override
	public List<Users> selectByUserType(Users users) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserName(Users users) throws SQLException {
		SqlSession session = null;
		List<Users> userList = null;
		try {
			session = DbUtil.getSession();
			userList = session.selectList("usersMapper.selectByUserName", users);
		} finally {
			DbUtil.sessionClose(session);
		}
		return userList;
	}

	@Override
	public List<Users> selectByUserAddress(String address) throws SQLException {
		SqlSession session = null;
		List<Users> userList = null;
		try {
			session = DbUtil.getSession();
			userList = session.selectList("usersMapper.selectByUserAddress", address);
		} finally {
			DbUtil.sessionClose(session);
		}
		return userList;
	}

}
