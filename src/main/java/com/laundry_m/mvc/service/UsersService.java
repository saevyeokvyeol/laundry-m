package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Users;

public interface UsersService {
	/**
	 * 회원가입
	 * 1. 회원을 인서트 한다.

	 * @param : User user(회원 아이디, 비밀번호, 연락처, 회원타입, 주소, 이름)
	 * @return 
	 * @exception : DuplicationException(아이디가 이미 존재할 경우 오류)
	 * 				NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 * 				NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 */
	void makeUser(Users users) throws SQLException, DuplicationException, NotExistException, NotFilledInException;
	
	/**
	 * 로그인
	 * @param : User user(회원아이디, 비밀번호)
	 * @return : User user
	 * @exception : NotExistException(아이디 DB에 존재하지 않을 경우 오류)
	 *  */
	public Users loginUser(Users users) throws SQLException, NotExistException;
	
	/**
	 * 회원 정보 수정 
	 * @param : User user
	 * @exception : NotLoginException(로그인 하지 않았을 경우 오류)
	 * 				NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * 
	 * */
	void updateUserInfo(Users users) throws SQLException, NotLoginException, NotFilledInException;
	
	/**
	 * 전체 유저 검색
	 * @return : List<User>
	 */
	List<Users> selectAllUser() throws SQLException;
	
	/**
	 *  회원 아이디로 검색
	 *  @param : User user(회원 아이디, 회원 이름(선택 - 없을 경우 모든 회원 아이디 검색, 해당 이름만 검색))
	 *  @return : User user 
	 *  @exception : NotExistException(회원 아이디 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	Users selectByUserId(Users users) throws SQLException, NotExistException, NotLoginException;
	
	/**
	 *  회원 타입으로 검색
	 *  @param : User user(회원 타입, 회원 이름(선택 - 없을 경우 모든 회원 타입 검색, 해당 이름만 검색))
	 *  @return : List<User> 
	 *  @exception : NotExistException(회원 타입 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	List<Users> selectByUserType(Users users) throws SQLException, NotExistException, NotLoginException;

	/**
	 *  회원 이름으로 검색
	 *  @param : User user
	 *  @return :List<Users>
	 *  @exception : NotExistException(회원 이름이 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	List<Users> selectByUserName(Users user) throws SQLException, NotExistException, NotLoginException;

	/**
	 *  회원 주소로 검색
	 *  @param : String
	 *  @return :List<Users>
	 *  @exception : NotExistException(회원 이름이 DB에 존재하지 않을 경우 오류)
	 *  			 NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * */
	List<Users> selectByUserAddress(String address) throws SQLException, NotExistException, NotLoginException;
}
