package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Adjust;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.PayLog;

import util.DbUtil;

public class BookDaoImpl implements BookDao {
	private MetapayDao metapayDao = new MetapayDaoImpl();
	private LaundryDao laundryDao = new LaundryDaoImpl();
	
	/**
	 * 예약 등록: 예약 인서트
	 * @param: Book book(점포 아이디, 회원 아이디, 옷 수량, 예약 참고 사항(선택), 결제 방법, 총 가격, 예약 상세 리스트(옷 아이디, 천 아이디, 가격))
	 * @return: int(등록한 레코드 수)
	 * */
	@Override
	public int insertBook(Book book) throws SQLException {
		// 세션을 생성합니다.
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			// DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			// 세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			result = session.insert("bookMapper.insertBook");
			if (result == 1) state = true;
			
			// 트랜잭션이 필요한 경우 트랜잭션 메소드를 호출합니다.
			for (BookLine bookLine : book.getBookLine()) {
				int re = this.insertBookLine(session, bookLine);
				throw new SQLException("예약에 오류가 발생했습니다.");
			}
			
			if (book.getBookMethodId() == 2) {
				PayLog payLog = PayLog.builder().laundryId(book.getLaundryId()).build();
				int re = metapayDao.payMetapay(session, book.getUserId(), payLog);
				throw new SQLException("메타페이 결제에 오류가 발생했습니다.");
			}
		} finally {
			// 세션을 닫습니다.
			DbUtil.sessionClose(session, state);
		}
		// 결과를 리턴합니다.
		return result;
		
		// 끝!
	}
	
	/**
	 * 예약 등록: 예약 상세 리스트 인서트
	 * @param: BookLine bookLine(옷 아이디, 천 아이디, 가격))
	 * @return: int(등록한 레코드 수)
	 * */
	@Override
	public int insertBookLine(SqlSession session, BookLine bookLine) throws SQLException {
		int result = session.insert("bookMapper.insertBook", bookLine);
		return result;
	}
	
	/**
	 * 예약 상태 갱신
	 * @param: Book book(예약 번호, 예약 상태 번호)
	 * @return: int(등록한 레코드 수)
	 * */
	@Override
	public int updateBookState(Book book) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("bookMapper.updateBookState", book);
			if (result == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}
	
	/**
	 * 예약 완료: 예약 상태 업데이트
	 * @param: Long bookId
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int updateBookComplete(Long bookId) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("bookMapper.updateBookComplete", bookId);
			
			Book book = this.searchBookByBookId(bookId);
			Adjust adjust = Adjust.builder().bookId(bookId)
					.laundryId(book.getLaundryId()).build();
			int re = this.insertAdjust(session, adjust);

			if (result == 1) state = true;
			if (re != 1) state = false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}
	
	/**
	 * 예약 완료: 정산 테이블 인서트
	 * @param: Long bookId
	 * @return: int(등록한 레코드 수)
	 * */
	@Override
	public int insertAdjust(SqlSession session, Adjust adjust) throws SQLException{
		int result = session.insert("bookMapper.insertAdjust", adjust);
		return result;
	}
	
	/**
	 * 예약 취소
	 * @param: Long bookId
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int updateBookCanceled(Long bookId) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("bookMapper.updateBookCanceled", bookId);
			if (result == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}
	
	/**
	 * 전체 예약 검색
	 * @return: List<Book>
	 * */
	@Override
	public List<Book> searchBookAll() throws SQLException {
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
	 * 날짜로 예약 검색
	 * @return: List<Book>
	 * */
	@Override
	public List<Book> searchBookByDate(String date) throws SQLException {
		SqlSession session = null;
		List<Book> books = null;
		try {
			session = DbUtil.getSession();
			books = session.selectList("bookMapper.searchBookByDate", date);
		} finally {
			DbUtil.sessionClose(session);
		}
		return books;
	}
	
	/**
	 * 유저 아이디로 예약 검색
	 * @param: Book book(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	@Override
	public List<Book> searchBookByUserId(Book book) throws SQLException {
		SqlSession session = null;
		List<Book> books = null;
		try {
			session = DbUtil.getSession();
			books = session.selectList("bookMapper.searchBookByUserId", book);
		} finally {
			DbUtil.sessionClose(session);
		}
		return books;
	}
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Book book(점포 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호만 검색))
	 * @return: List<Book>
	 * */
	@Override
	public List<Book> searchBookByLaundryId(Book book) throws SQLException {
		SqlSession session = null;
		List<Book> books = null;
		try {
			session = DbUtil.getSession();
			books = session.selectList("bookMapper.searchBookByLaundryId", book);
		} finally {
			DbUtil.sessionClose(session);
		}
		return books;
	}
	
	/**
	 * 예약 아이디로 예약 검색
	 * @param: Long bookId
	 * @return: Book
	 * */
	@Override
	public Book searchBookByBookId(Long bookId) throws SQLException {
		SqlSession session = null;
		Book book = null;
		try {
			session = DbUtil.getSession();
			book = session.selectOne("bookMapper.searchBookByBookId", bookId);
		} finally {
			DbUtil.sessionClose(session);
		}
		return book;
	}

}
