package com.laundry_m.mvc.laundry_m.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.User;

public interface UserDao {

	/*회원 가입*/
	int insertUser(User user) throws SQLException;
	
	/*회원정보수정*/
	int updateUser(User user) throws SQLException;

	/*로그인*/
	int loginUser(String userId, String userPwd) throws SQLException;
	
	/* 전체 유저 검색 */
	List<User> selectAllUser() throws SQLException;
	
	/*   유저 아이디로 검색 */
	List<User> selectByUserId(String userId) throws SQLException;
	
	/* 유저 타입으로 검색 */
	List<User> selectByUserType(String userType) throws SQLException;	
	
}
