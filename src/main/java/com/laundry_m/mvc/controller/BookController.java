package com.laundry_m.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.service.BookService;
import com.laundry_m.mvc.service.BookServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.Users;

public class BookController {
	private BookService bookService = new BookServiceImpl();
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
	public void updateBookComplete(Long bookId) {
		try {
			bookService.updateBookComplete(bookId);
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
	 * 전체 예약 검색
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
	public void searchBookByUserId(Long bookStateId) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Book book = Book.builder().userId(users.getUserId()).bookStateId(bookStateId).build();
			List<Book> books = bookService.searchBookByUserId(book);
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 점포 아이디로 예약 검색
	 * @param: Book book(유저 아이디, 예약 상태 번호(선택 - 없을 경우 모든 예약 상태 검색, 있을 경우 해당 예약 상태 번호 이상만 검색))
	 * */
	public void searchBookByLaundryId(Long bookStateId) {
		try {
			Users users = (Users)session.getAttribute("loginUser");
			Book book = Book.builder().userId(users.getUserId()).bookStateId(bookStateId).build();
			List<Book> books = bookService.searchBookByLaundryId(book);
			SuccessView.printUserBook(books);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}