package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.dao.UsersDao;
import com.laundry_m.mvc.dao.UsersDaoImpl;
import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Users;

public class UsersServiceImpl implements UsersService{
	private UsersDao usersDao = new UsersDaoImpl();

	@Override
	public void makeUser(Users users)
			throws SQLException, DuplicationException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loginUser(String userId, String userPwd) throws SQLException, NotExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInfo(Users users) throws SQLException, NotLoginException, NotFilledInException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> selectAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserId(Users users) throws SQLException, NotExistException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserType(Users users) throws SQLException, NotExistException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}
}
