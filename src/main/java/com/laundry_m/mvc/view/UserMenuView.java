package com.laundry_m.mvc.view;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;

import com.laundry_m.mvc.controller.UsersController;
import com.laundry_m.mvc.vo.Users;

public class UserMenuView {
	private static Properties properties = new Properties();
	private static Scanner sc = new Scanner(System.in);
	private static UsersController usersController = new UsersController();
	
	private final static String ID = "^[0-9a-zA-Z]*$";
	//private final static String PASSWORD = "^[0-9]*$";
	private final static String NAME = "^[가-힣]*$";
	private final static String PHONE = "^[0-9]*$";
	static {
        String resource = "config/apiInfo.properties";
        
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void updateUserInfoForm() {
		boolean run = true;
		boolean run1 = true;
		while (run) {
			try {
				Users loginUserInfo = usersController.selectByUserId();
				System.out.println();
				System.out.println("이름 : " + loginUserInfo.getUserName());
				System.out.println("아이디 : " + loginUserInfo.getUserId());
				System.out.println("전화번호 : " + loginUserInfo.getUserPhone());
				System.out.println("주소 : " + loginUserInfo.getUserAddress());
				
				while (run1) {
					boolean run2 = true;
					System.out.println("\n" + "[ 1. 정보 수정 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
					System.out.print("▶ ");
					int menu = Integer.parseInt(sc.nextLine());
					switch(menu) {
						case 1 : 
							while (run2) {
								System.out.println("\n" + "[ 1. 이름 수정 | 2. 비밀번호 수정 | 3. 주소 수정 | 4. 전화번호 수정 | 8. 뒤로 가기 ]");
								System.out.print("▶ ");
								int menu1 = Integer.parseInt(sc.nextLine());
								switch(menu1) {
									case 1 :
										System.out.println("변경할 이름을 입력해주세요.");
										System.out.print("▶ ");
										String input = sc.nextLine();
										loginUserInfo.setUserName(input);
										usersController.updateUserInfo(loginUserInfo);
										break;
									case 2 :
										System.out.println("변경할 비밀번호를 입력해주세요.");
										System.out.print("▶ ");
										input = sc.nextLine();
										loginUserInfo.setUserPwd(input);
										usersController.updateUserInfo(loginUserInfo);
										break;
									case 3 :
										String address = null;
										double latitude = 0f;
										double longtitude = 0f;
										
										System.out.println("변경할 주소의 시/군/구 정보를 입력해주세요. (ex 송파구)");
										System.out.print("▶ ");
										StringBuffer buffer = new StringBuffer();
										buffer.append("서울특별시 ");
										String gu = sc.nextLine();
										
										if (!gu.equals("강남구")&&!gu.equals("강동구")&&!gu.equals("강서구")&&!gu.equals("강북구")&&!gu.equals("관악구")
												&&!gu.equals("광진구")&&!gu.equals("구로구")&&!gu.equals("금천구")&&!gu.equals("노원구")&&!gu.equals("동대문구")
												&&!gu.equals("도봉구")&&!gu.equals("동작구")&&!gu.equals("마포구")&&!gu.equals("서대문구")&&!gu.equals("성동구")
												&&!gu.equals("성북구")&&!gu.equals("서초구")&&!gu.equals("송파구")&&!gu.equals("영등포구")&&!gu.equals("용산구")
												&&!gu.equals("양천구")&&!gu.equals("은평구")&&!gu.equals("종로구")&&!gu.equals("중구")&&!gu.equals("중랑구")) {
											System.out.println("거주중인 구 정보를 정확히 입력해주세요.");
										} else {
											buffer.append(gu + " ");
											System.out.println("그 외 상세주소를 입력해주세요.");
											System.out.print("▶ ");
											buffer.append(sc.nextLine());
											address = buffer.toString();
											String lati = InsertUserView.getXYMapfromJson(InsertUserView.getKakaoApiFromAddress(address)).get("y");
											String longti = InsertUserView.getXYMapfromJson(InsertUserView.getKakaoApiFromAddress(address)).get("x");
											latitude = Double.parseDouble(lati);
											longtitude = Double.parseDouble(longti);
											break;
										}
										loginUserInfo.setUserAddress(address); 
										loginUserInfo.setUserLongtitude(longtitude);
										loginUserInfo.setUserLatitude(latitude);
										usersController.updateUserInfo(loginUserInfo);
										break;
									case 4 :
										System.out.println("변경할 전화번호를 입력해주세요.");
										System.out.print("▶ ");
										input = sc.nextLine();
										loginUserInfo.setUserPhone(input);
										usersController.updateUserInfo(loginUserInfo);
										break;
									case 8 : 
										run2 = false; 
										break;
								}
							}
							break;	
						case 8 :
							run1 = false;
							run = false;
							break;
						case 9 : 
							usersController.logout();
							break;
						case 0 : 
							MenuView.exit();
						default:
							System.out.println("메뉴를 잘못 선택하셨습니다.");
						}
					}
				
				}
				catch (Exception e) {
					e.printStackTrace();
					FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
				}
			}
		}
}
