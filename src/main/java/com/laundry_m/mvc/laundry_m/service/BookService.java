package com.laundry_m.mvc.laundry_m.service;

import java.sql.SQLException;

import com.laundry_m.mvc.domain.Book;
import com.laundry_m.mvc.laundry_m.exception.InsufficientBalanceException;
import com.laundry_m.mvc.laundry_m.exception.InvalidUserException;
import com.laundry_m.mvc.laundry_m.exception.NotExistException;
import com.laundry_m.mvc.laundry_m.exception.NotFilledInException;
import com.laundry_m.mvc.laundry_m.exception.NotLoginException;

public interface BookService {
	/**
	 * 예약 등록
	 * 1. 예약을 인서트한다.
	 * 2. 예약 상세 리스트를 인서트한다.
	 * 3. 만일 메타페이를 사용한다면 메타페이 거래 내역을 추가한다.
	 * 
	 * @param: Book book(점포 아이디, 회원 아이디, 옷 수량, 예약 참고 사항(선택), 결제 방법, 총 가격,
	 * 					예약 상세 리스트(옷 아이디, 천 아이디, 가격))
	 * @return: Book book
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * 			   NotExistException(점포 아이디나 회원 아이디 등이 DB에 존재하지 않을 경우 오류)
	 * 			   InsufficientBalanceException(메타페이 사용 시 잔액이 거래 금액보다 클 경우 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	Book makeBook(Book book) throws SQLException, NotLoginException, NotExistException, InsufficientBalanceException, NotFilledInException;
	
	/**
	 * 예약 상태 갱신
	 * @param: Book book(예약 번호, 예약 상태 번호)
	 * @return: Book book
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 점포를 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	Book updateBookState(Book book) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 예약 완료
	 * 1. 예약 상태를 업데이트한다.
	 * 2. 세탁소의 총 가격과 정산 가능 금액에 예약의 총 가격을 추가한다.
	 * 
	 * @param: Long bookId
	 * @return: Book book
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약을 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * */
	Book updateBookComplete(Book book) throws SQLException, NotLoginException, NotExistException, InvalidUserException;
	
	/**
	 * 예약 취소
	 * @param: Long bookId
	 * @return: Book book
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약이나 세탁소를 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * */
	Book updateBookCanceled(Book book) throws SQLException, NotLoginException, NotExistException, InvalidUserException;
}