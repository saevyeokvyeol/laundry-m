package com.laundry_m.mvc.controller;

import com.laundry_m.mvc.service.UsersService;
import com.laundry_m.mvc.service.UsersServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.MenuView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.Users;

public class UsersController {
	private UsersService usersService = new UsersServiceImpl();
	private Session session = Session.getInstance();
	
		public void loginUser(String userId, String userPwd) {
		try {
			Users users = Users.builder().userId(userId).userPwd(userPwd).build();
			Users loginUser = usersService.loginUser(users);
			session.setAttribute("loginUser", loginUser);
			if (loginUser.getUserType().equals("관리자")) {
				new MenuView().adminMenu();
			} else if (loginUser.getUserType().equals("점주")){
				SuccessView.printMessage("< 런드리엠에 오신 것을 환영합니다, " + loginUser.getUserName() + "님 >");
				new MenuView().laundryMenu();
			} else {
				SuccessView.printMessage("< 런드리엠에 오신 것을 환영합니다, " + loginUser.getUserName() + "님 >");
				new MenuView().customerMenu();
			}
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		
	}


}
