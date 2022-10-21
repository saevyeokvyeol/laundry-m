package com.laundry_m.mvc.view;

import com.laundry_m.mvc.controller.BookController;

public class Test {

	public static void main(String[] args) {
		BookController bookController = new BookController();
		bookController.updateBookComplete(1L);
	}

}