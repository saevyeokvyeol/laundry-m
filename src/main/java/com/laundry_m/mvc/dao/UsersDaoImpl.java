package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.vo.Users;

public class UsersDaoImpl implements UsersDao{

	@Override
	public int insertUser(Users users) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(Users users) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users loginUser(String userId, String userPwd) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserId(Users users) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserType(Users users) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
