package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.vo.Users;

public interface UsersDao {

	/**
	 * 회원 가입 : 회원 인서트
	 * @param : User user(회원 아이디, 비밀번호, 연락처, 회원타입, 주소, 이름)	 
	 * @return : int(등록한 레코드 수)
	 * */
	int insertUser(Users users) throws SQLException;
	
	/** 
	 * 회원정보수정
	 * @param : User user(회원 아이디, 비밀번호, 연락처, 회원타입, 주소, 이름)
	 * @return : User user
	 * */
	int updateUser(Users users) throws SQLException;

	/** 
	 * 로그인
	 * @param : User user(회원 아이디, 비밀번호)
	 * @return : User user
	 * */
	Users loginUser(String userId, String userPwd) throws SQLException;
	
	/** 
	 * 전체 유저 검색 
	 * @param : User user
	 * @return : List<User>
	 * */
	List<Users> selectAllUser() throws SQLException;
	
	/** 
	 *  회원 아이디로 검색
	 *  @param : User user(회원 아이디, 회원 이름(선택 - 없을 경우 모든 회원 아이디 검색, 해당 이름만 검색))
	 *  @return : List<User> 
	 *  */
	List<Users> selectByUserId(Users users) throws SQLException;
	
	/** 
	 *  회원 타입으로 검색
	 *  @param : User user(회원 타입, 회원 이름(선택 - 없을 경우 모든 회원 타입 검색, 해당 이름만 검색))
	 *  @return : List<User> 
	 *  */
	List<Users> selectByUserType(Users users) throws SQLException;	
	 
}