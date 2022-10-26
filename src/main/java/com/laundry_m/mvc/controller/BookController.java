package com.laundry_m.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laundry_m.mvc.service.BookService;
import com.laundry_m.mvc.service.BookServiceImpl;
import com.laundry_m.mvc.service.LaundryService;
import com.laundry_m.mvc.service.LaundryServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

public class BookController {
	private BookService bookService = new BookServiceImpl();
	private LaundryService laundryService = new LaundryServiceImpl();
	private Session session = Session.getInstance();

	/**
	 * 예약 등록: 예약 인서트
	 * @param: Book book(점포 아이디, 회원 아이디, 옷 수량, 예약 참고 사항(선택), 결제 방법, 총 가격, 예약 상세 리스트(옷 아이디, 천 아이디, 가격))
	 * */
	public void makeBook(Book book) {
		try {
			Users users = (Users) session.getAttribute("loginUser");
			book.setUserId(users.getUserId());
			bookService.makeBook(book);
			SuccessView.printMessage("예약이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 예약 완료: 예약 상태 업데이트
	 * @param: Long bookId
	 * */
	public void updateBookState(Book book) {
		try {
			bookService.updateBookState(book);
			SuccessView.printMessage(book.getBookId() + "번 예약 상태가 업데이트 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 예약 완료: 예약 상태 업데이트
	 * @param: Long bookId
	 * */
	public void updateBookComplete(Long bookId) {
		try {
			bookService.updateBookComplete(bookId);
			SuccessView.printMessage(bookId + "번 예약이 완료 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 전체 예약 검색
	 * */
	public void searchBookAll() {
		try {
			List<Book> books = bookService.searchBookAll();
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 날짜별 예약 검색
	 * */
	public void searchBookByDate(String date) {
		try {
			List<Book> books = bookService.searchBookByDate(date);
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 유저 아이디로 예약 검색
	 * @param: Book book(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호 이상만 검색))
	 * */
	public void searchBookByUserId(Long start, Long end) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", users.getUserId());
			map.put("start", start);
			map.put("end", end);
			List<Book> books = bookService.searchBookByUserId(map);
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Long start, Long end
	 * */
	public void searchBookByLaundryId(Long start, Long end) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Laundry laundry = laundryService.selectByUserId(users.getUserId());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("laundryId", laundry.getLaundryId());
			map.put("start", start);
			map.put("end", end);
			List<Book> books = bookService.searchBookByLaundryId(map);
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}