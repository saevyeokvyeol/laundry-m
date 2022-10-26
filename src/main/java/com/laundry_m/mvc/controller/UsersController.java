package com.laundry_m.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
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

	public void insertUser(Users users) {
		try {
			usersService.makeUser(users);
			SuccessView.printMessage("\n" + users.getUserName() + "님, 가입이 완료되었습니다.\n로그인 후 서비스를 이용해주세요.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public void logout() {
		session.removeAll();
		MenuView.menuView();
	}
	
	public Users selectByLoginUserId() {
		Users sessionUser = (Users)session.getAttribute("loginUser");
		try {
			Users findUser = usersService.selectByUserId(sessionUser);
			return findUser;
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotExistException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotLoginException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		return null;
	}

	
	public void selectByUserId(Users user) {
		try {
			Users findUser = usersService.selectByUserId(user);
			SuccessView.printUserInfo(findUser);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotExistException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotLoginException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public void selectByUserName(Users user) {
		try {
			List<Users> userList = usersService.selectByUserName(user);
			SuccessView.printUserInfoList(userList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotExistException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotLoginException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	public void updateUserInfo(Users updateUser) {
		try {
			usersService.updateUserInfo(updateUser);
			SuccessView.printMessage("\n" + updateUser.getUserName() + "님의 정보가 성공적으로 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotLoginException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotFilledInException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	public void selectByUserAddress(String address) {
		try {
			List<Users> userList = usersService.selectByUserAddress(address);
			SuccessView.printUserInfoList(userList);
		} catch (SQLException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotLoginException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		} catch (NotExistException e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
}
