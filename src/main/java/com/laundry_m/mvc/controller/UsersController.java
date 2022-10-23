package com.laundry_m.mvc.controller;

import com.laundry_m.mvc.service.UsersService;
import com.laundry_m.mvc.service.UsersServiceImpl;
import com.laundry_m.mvc.session.Session;

public class UsersController {
	private UsersService userService = new UsersServiceImpl();
	private Session session = Session.getInstance();


}
