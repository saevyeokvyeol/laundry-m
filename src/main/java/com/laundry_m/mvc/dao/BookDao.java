package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Adjust;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;

import util.DbUtil;

public interface BookDao {
	/**
	 * 예약 등록: 예약 인서트
	 * @param: Book book(점포 아이디, 회원 아이디, 옷 수량, 예약 참고 사항(선택), 결제 방법, 총 가격, 예약 상세 리스트(옷 아이디, 천 아이디, 가격))
	 * @return: int(등록한 레코드 수)
	 * */
	int insertBook(Book book) throws SQLException;
	
	/**
	 * 예약 등록: 예약 상세 리스트 인서트
	 * @param: BookLine bookLine(옷 아이디, 천 아이디, 가격))
	 * @return: int(등록한 레코드 수)
	 * */
	int insertBookLine(SqlSession session, BookLine bookLine) throws SQLException;
	
	/**
	 * 예약 상태 갱신
	 * @param: Book book(예약 번호, 예약 상태 번호)
	 * @return: int(등록한 레코드 수)
	 * */
	int updateBookState(Book book) throws SQLException;
	
	/**
	 * 예약 완료: 예약 상태 업데이트
	 * @param: Long bookId
	 * @return: int(수정한 레코드 수)
	 * */
	int updateBookComplete(Long bookId) throws SQLException;
	
	/**
	 * 예약 완료: 정산 테이블 인서트
	 * @param: Long bookId
	 * @return: int(등록한 레코드 수)
	 * */
	int insertAdjust(SqlSession session, Adjust adjust) throws SQLException;
	
	/**
	 * 예약 취소
	 * @param: Long bookId
	 * @return: int(수정한 레코드 수)
	 * */
	int updateBookCanceled(Long bookId) throws SQLException;
	
	/**
	 * 전체 예약 검색
	 * @return: List<Book>
	 * */
	List<Book> searchBookAll() throws SQLException;
	
	/**
	 * 날짜로 예약 검색
	 * @param: String date
	 * @return: List<Book>
	 * */
	public List<Book> searchBookByDate(String date) throws SQLException;
	
	/**
	 * 유저 아이디로 예약 검색
	 * @param: Map<String, Object> map(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	List<Book> searchBookByUserId(Map<String, Object> map) throws SQLException;
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Map<String, Object> map(점포 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	List<Book> searchBookByLaundryId(Map<String, Object> map) throws SQLException;
	
	/**
	 * 예약 아이디로 예약 검색
	 * @param: Long bookId
	 * @return: Book
	 * */
	Book searchBookByBookId(Long bookId) throws SQLException;
}