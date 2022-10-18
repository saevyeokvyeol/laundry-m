package com.laundry_m.mvc.laundry_m.service;

import java.sql.SQLException;
import java.util.List;
import com.laundry_m.mvc.domain.User;
import com.laundry_m.mvc.laundry_m.exception.DuplicationException;
import com.laundry_m.mvc.laundry_m.exception.NotExistException;
import com.laundry_m.mvc.laundry_m.exception.NotLoginException;

public interface UserService {
	/* 
	 * 회원가입
	 * @param : User user(회원 아이디, 비밀번호, 연락처, 회원타입, 주소)
	 * @return : User user
	 * @exception : DuplicationException(아이디가 이미 존재할 경우 오류)
	 * 				NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 */
	void insertUser(User user) throws SQLException, DuplicationException, NotExistException;
	
	/* 
	 * 로그인
	 * @param : User user(회원아이디, 비밀번호)
	 * @return : User user
	 * @exception : NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 * 				
	 *  */
	User loginUser(String userId, String userPwd) throws SQLException, NotExistException;
	
	/* 
	 * 회원 정보 수정 
	 * @param : User user 
	 * @return : User user(회원비밀번호, 연락처, 주소)
	 * @exception : NotLoginException(로그인 하지 않았을 경우 오류)
	 * 
	 * */
	User updateUser(User user) throws SQLException, NotLoginException;
	
	/*
	 * 전체 유저 검색
	 * @param : User user
	 * @return : List<User>
	 */
	List<User> selectAllUser() throws SQLException;
	
	/* 
	 *  유저 아이디로 검색
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<User> 
	 *  @exception : NotExistException(아이디 DB에 존재하지 않을 경우 오류)
	 * */
	List<User> selectByUserId(String userId) throws SQLException, NotExistException;
	
	/* 
	 *  유저 타입으로 검색
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<User> 
	 *  @exception : NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 * */
	List<User> selectByUserType(String userType) throws SQLException, NotExistException;
}
