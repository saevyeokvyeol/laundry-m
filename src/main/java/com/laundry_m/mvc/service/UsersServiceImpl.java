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
		int result = usersDao.insertUser(users);
		if(result != 1) { throw new NotExistException("가입 실패하였습니다. 다시 시도해주세요."); }
	}
	
	@Override
	public Users loginUser(Users users) throws SQLException, NotExistException {
		Users loginUser = usersDao.loginUser(users);
		if(users == null) { throw new NotExistException("아이디 혹은 비밀번호가 올바르지 않습니다."); }
		return loginUser;
	}

	
	/**
	 * 회원 정보 수정 
	 * @param : User user
	 * @exception : NotLoginException(로그인 하지 않았을 경우 오류)
	 * 				NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * 
	 * */
	@Override
	public void updateUserInfo(Users users) throws SQLException, NotLoginException, NotFilledInException {
		int result = usersDao.updateUser(users);
	}

	@Override
	public List<Users> selectAllUser() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users selectByUserId(Users users) throws SQLException, NotExistException, NotLoginException {
		Users loginUser = usersDao.selectByUserId(users);
		return loginUser;
	}

	@Override
	public List<Users> selectByUserType(Users users) throws SQLException, NotExistException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> selectByUserName(Users user) throws SQLException, NotExistException, NotLoginException {
		List<Users> userList = usersDao.selectByUserName(user);
		if(userList == null) { throw new NotExistException("존재하지 않는 회원 이름입니다."); }
		return userList;
	}

	@Override
	public List<Users> selectByUserAddress(String address) throws SQLException, NotExistException, NotLoginException {
		List<Users> userList = usersDao.selectByUserAddress(address);
		if(userList == null) { throw new NotExistException(address + "에 거주중인 회원이 없습니다."); }
		return userList;
	}

	

	
}
