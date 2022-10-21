package com.laundry_m.mvc.controller;

import com.laundry_m.mvc.service.BookService;
import com.laundry_m.mvc.service.BookServiceImpl;
import com.laundry_m.mvc.view.FailView;

public class BookController {
	private BookService bookService = new BookServiceImpl();
	
	public void updateBookComplete(Long bookId) {
		try {
			bookService.updateBookComplete(bookId);
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}