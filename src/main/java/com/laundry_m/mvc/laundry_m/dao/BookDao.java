package com.laundry_m.mvc.laundry_m.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Book;
import com.laundry_m.mvc.domain.BookLine;

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
	int insertBook(BookLine bookLine) throws SQLException;
	
	/**
	 * 예약 상태 갱신
	 * @param: Book book(예약 번호, 예약 상태 번호)
	 * @return: int(등록한 레코드 수)
	 * */
	int updateBookState(Book book) throws SQLException;
	
	/**
	 * 예약 완료: 예약 상태 업데이트
	 * @param: Long bookId
	 * */
	int updateBookComplete(Long bookId) throws SQLException;
	
	/**
	 * 예약 취소
	 * @param: Long bookId
	 * */
	int updateBookCanceled(Book book) throws SQLException;
	
	/**
	 * 전체 예약 검색
	 * @return: List<Book>
	 * */
	List<Book> searchBookAll() throws SQLException;
	
	/**
	 * 유저 아이디로 예약 검색
	 * @param: Book book(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	List<Book> searchBookByUserId(Book book) throws SQLException;
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Book book(점포 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	List<Book> searchBookByLaundryId(Book book) throws SQLException;
}