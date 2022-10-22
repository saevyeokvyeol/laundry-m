package com.laundry_m.mvc.controller;

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
}