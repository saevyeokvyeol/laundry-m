package com.laundry_m.mvc.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.LaundryController;
import com.laundry_m.mvc.controller.UsersController;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;
import com.laundry_m.mvc.vo.Laundry.LaundryBuilder;

public class laundryUpdateView {
	private static UsersController usersController = new UsersController();
	private static LaundryController laundryController = new LaundryController();
	private static Scanner sc = new Scanner(System.in);
	
	private final static String ID = "^[0-9a-zA-Z]*$";
	//private final static String PASSWORD = "^[0-9]*$";
	private final static String NAME = "^[가-힣]*$";
	private final static String PHONE = "^[0-9]*$";
	private final static String SELECTNUM = "^[0-9]*$";
	
	public static void laundryInfoUpdateForm() {
		boolean run = true;
		while (run) {
			try {
				System.out.println("\n" + "[ 1. 세탁소 정보 수정 | 2. 세탁소 기본 가격 정보 수정 | 3. 소재별 추가 가격 정보 수정 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1 :
					updateLaundry();
					break;
				case 2 :
					updateFee();
					break;
				case 3 :
					updateExtraFee();
					break;
				case 8 :
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
			} catch (Exception e) {
				e.printStackTrace();
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
		
	}
	
	/**
	 * 세탁소 가격 변경 
	 * */
	private static void updateFee() {
		boolean run = true;
		while (run) {
			System.out.println("변경하실 정보를 선택해주세요.");
			System.out.println("[ 1. 상의/자켓     | 2. 하의        | 3. 스커트       | 4. 와이셔츠/남방      | 5. 티셔츠          ]");
			System.out.println("[ 6. 블라우스      | 7. 원피스       | 8. 스웨터/가디건  | 9. 봄가을점퍼/아웃도어  | 10. 코트          ]");
			System.out.println("[ 11. 가죽/모피의류 | 12. 겨울패딩/점퍼 | 13. 넥타이      | 14. 스카프/목도리     | 15.이불/침구류      ]");
			System.out.println("[ 16. 커튼/카페트  | 17. 한복류      | 18. 모자       | 19. 가방/기타가죽제품   | 20. 운동화/스니커즈류 ]");
			System.out.println("[ 0. 뒤로 가기 ]");
			System.out.print("▶ ");
			int clothesId = Integer.parseInt(sc.nextLine());
			if(clothesId == 0) {
				run = false;
				break;
			}
			System.out.println("가격을 입력해주세요.");
			int inputFee = Integer.parseInt(sc.nextLine());
			
			Fee fee = Fee.builder().clothesId(clothesId).clothesFee(inputFee).build();
			laundryController.updateFee(fee);
		}
	}

	/**
	 * 세탁소 추가 가격 변경 
	 * */
	private static void updateExtraFee() {
		
		boolean run = true;
		boolean run1 = true;
		boolean run2 = true;
		int fabricId = 0;
		char operation = 0;
		int inputFee = 0;
		
		while (run) {
			while (true) {
				System.out.println("변경하실 정보를 선택해주세요.");
				System.out.println("[ 1. 면   | 2. 니트  | 3. 레이온  | 4. 데님  | 5. 실크/쉬폰 ]");
				System.out.println("[ 5. 린넨  | 6. 퍼   | 7. 앙고라  | 8. 가죽  | 0. 뒤로 가기 ]");
				System.out.print("▶ ");
				String fabricIdString = sc.nextLine();
				if (!fabricIdString.matches(SELECTNUM)) {
					System.out.println("정확한 번호를 선택해주세요.");
				} else {
					fabricId = Integer.parseInt(fabricIdString);
					break;
				}
			}
			if (fabricId==0) {
				run = false;
				break;
			}
			while(run1) {
				System.out.println("운영 여부를 입력해주세요.");
				System.out.println("[ 1. 운영  | 2. 미운영  ]");
				System.out.print("> ");
				int op = Integer.parseInt(sc.nextLine());
				if (op!=1 && op!=2) {
					System.out.print("정확한 번호를 선택해주세요. >");
				} else {
					if(op == 1) {
						operation = 'Y';
						while(run2) {
							System.out.println("가격을 입력해주세요.");
							System.out.print("> ");
							String input = sc.nextLine();
							if (input.matches(SELECTNUM)) {
								inputFee = Integer.parseInt(input);
								run2 = false;
								break;
							}
						}
						run1 = false;
					} else {
						inputFee = 0;
						operation = 'N';
						run1 = false;
					}	
				}
			}
			
			ExtraFee extraFee = ExtraFee.builder().fabricId(fabricId).fabricFee(inputFee).extraFeeOperation(operation).build();
			laundryController.updateExtraFee(extraFee);
			run1 = true;
			run2 = true;
		}
			
		
		
	}


	/**
	 * 세탁소 정보 변경 메뉴
	 * */
	private static void updateLaundry() {
		boolean run = true;
		while (run) {
			try {
			System.out.println("변경하실 정보를 선택해주세요.");
			System.out.println("[ 1. 세탁소 이름 | 2. 세탁소 전화번호 | 3. 세탁소 주소 | 4. 점주 계좌 | 8. 뒤로 가기 | 9. 로그아웃 | 0. 종료 ]");
			System.out.print("▶ ");
			int menu = Integer.parseInt(sc.nextLine());
			//Users users = (Users) session.getAttribute("loginUser");
			Laundry loginLaundry = laundryController.selectLaundryByLoginUserId();
			switch(menu) {
				case 1 : 
					String name = null;
					while (true) {
						System.out.print("변경할 이름을 입력해주세요. > ");
						name = sc.nextLine();
						break;
					}
					loginLaundry.setLaundryName(name);
					laundryController.updateLaundry(loginLaundry);
					break;
					
				case 2 :
					String tel = null;
					while (true) {
						System.out.print("변경할 전화번호를 입력해주세요. > ");
						tel = sc.nextLine();
						if (!tel.matches(PHONE) || tel.length() < 12 == false) {
							System.out.println("전화번호는 -없이 숫자 11자리 이하로 입력해주세요.\n");
						} else {
							break;
						}
					}
					loginLaundry.setLaundryTel(tel); 
					laundryController.updateLaundry(loginLaundry);
					break;
					
				case 3 :
					String address = null;
					double latitude = 0f;
					double longtitude = 0f;
					while (true) {
						System.out.println("변경할 세탁소 주소를 입력해주세요. ");
						System.out.println("세탁소를 운영중인 구를 입력해주세요 > ");
						StringBuffer buffer = new StringBuffer();
						buffer.append("서울특별시 ");
						String gu = sc.nextLine();
						if (!gu.equals("강남구")&&!gu.equals("강동구")&&!gu.equals("강서구")&&!gu.equals("강북구")&&!gu.equals("관악구")
								&&!gu.equals("광진구")&&!gu.equals("구로구")&&!gu.equals("금천구")&&!gu.equals("노원구")&&!gu.equals("동대문구")
								&&!gu.equals("도봉구")&&!gu.equals("동작구")&&!gu.equals("마포구")&&!gu.equals("서대문구")&&!gu.equals("성동구")
								&&!gu.equals("성북구")&&!gu.equals("서초구")&&!gu.equals("송파구")&&!gu.equals("영등포구")&&!gu.equals("용산구")
								&&!gu.equals("양천구")&&!gu.equals("은평구")&&!gu.equals("종로구")&&!gu.equals("중구")&&!gu.equals("중랑구")) {
							System.out.println("구 정보를 정확히 입력해주세요. \n");
						} else {
							buffer.append(gu + " ");
							System.out.println("그 외 상세주소를 입력해주세요(도로명주소) > ");
							buffer.append(sc.nextLine());
							address = buffer.toString();
							
							String lati = InsertUserView.getXYMapfromJson(InsertUserView.getKakaoApiFromAddress(address)).get("y");
							String longti = InsertUserView.getXYMapfromJson(InsertUserView.getKakaoApiFromAddress(address)).get("x");
							latitude = Double.parseDouble(lati);
							longtitude = Double.parseDouble(longti);
							break;
						}
					}
					loginLaundry.setLaundryAddress(address);
					loginLaundry.setLaundryLatitude(latitude);
					loginLaundry.setLaundryLongtitude(latitude);
					laundryController.updateLaundry(loginLaundry);
					break;
						
				case 4 :
					String account = null;
					while (true) {
						System.out.print("변경할 계좌를 입력해주세요. > ");
						account = sc.nextLine();
						if (!account.matches(PHONE) || account.length() == 13 == false) {
							System.out.println("계좌번호는 -없이 숫자 13자리로 입력해주세요.\n");
						} else {
							break;
						}
					}
					loginLaundry.setLaundryAccountNumber(account);
					laundryController.updateLaundry(loginLaundry);
					break;
					
				case 8 :
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
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
			
		}
			
	}
	
}
