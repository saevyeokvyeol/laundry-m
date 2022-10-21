package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.dao.BookDao;
import com.laundry_m.mvc.dao.BookDaoImpl;
import com.laundry_m.mvc.domain.Book;
import com.laundry_m.mvc.exception.InsufficientBalanceException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;

import util.DbUtil;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	/**
	 * 예약 등록
	 * 1. 예약을 인서트한다.
	 * 2. 예약 상세 리스트를 인서트한다.
	 * 3. 만일 메타페이를 사용한다면 메타페이 거래 내역을 추가한다.
	 * 
	 * @param: Book book(점포 아이디, 회원 아이디, 옷 수량, 예약 참고 사항(선택), 결제 방법, 총 가격, 예약 상세 리스트(옷 아이디, 천 아이디, 가격))
	 * @exception: NotLoginException(로그인하지 않고 예약을 시도할 경우 오류)
	 * 			   NotExistException(점포 아이디나 회원 아이디 등이 DB에 존재하지 않을 경우 오류)
	 * 			   InsufficientBalanceException(메타페이 사용 시 잔액이 거래 금액보다 클 경우 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void makeBook(Book book) throws SQLException, NotLoginException, NotExistException,
			InsufficientBalanceException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	/**
	 * 예약 상태 갱신
	 * @param: Book book(예약 번호, 예약 상태 번호)
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 점포를 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void updateBookState(Book book)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	/**
	 * 예약 완료
	 * 1. 예약 상태를 업데이트한다.
	 * 2. 해당 예약을 정산 테이블에 인서트한다.
	 * 
	 * @param: Long bookId
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약을 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * */
	@Override
	public void updateBookComplete(Long bookId)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		int result = bookDao.updateBookComplete(bookId);
		
		if (result != 1) throw new SQLException("예약 완료 처리에 실패했습니다.");
	}
	
	/**
	 * 예약 취소
	 * @param: Long bookId
	 * @exception: NotLoginException(로그인하지 않고 변경을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약이나 세탁소를 소유하지 않은 회원이 변경을 시도할 경우 오류)
	 * */
	@Override
	public void updateBookCanceled(Book book)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 전체 예약 검색
	 * @return: List<Book>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   InvalidUserException(관리자가 아닐 경우 오류)
	 * */
	@Override
	public List<Book> searchBookAll() throws SQLException, NotLoginException, InvalidUserException {
		SqlSession session = null;
		List<Book> books = null;
		try {
			session = DbUtil.getSession();
			books = session.selectList("bookMapper.searchBookAll");
		} finally {
			DbUtil.sessionClose(session);
		}
		return books;
	}
	
	/**
	 * 유저 아이디로 예약 검색
	 * @param: Book book(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(회원이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(관리자나 해당 회원이 아닐 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public List<Book> searchBookByUserId(Book book)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		List<Book> books = bookDao.searchBookByUserId(book);
		return books;
	}
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Book book(점포 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(점포가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(관리자가 아니거나 해당 점포를 소유하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public List<Book> searchBookByLaundryId(Book book)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		List<Book> books = bookDao.searchBookByLaundryId(book);
		return books;
	}
	
	/**
	 * 예약 아이디로 예약 검색
	 * @param: Long bookId
	 * @return: Book
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(관리자나 해당 회원이 아니거나 해당 점포를 소유하지 않을 경우 오류)
	 * */
	@Override
	public Book searchBookByBookId(Long bookId)
			throws SQLException, NotLoginException, NotExistException, InvalidUserException {
		Book book = bookDao.searchBookByBookId(bookId);
		
		if (book == null) throw new NotExistException("해당 예약 내역을 찾을 수 없습니다.");
		
		return book;
	}

}
