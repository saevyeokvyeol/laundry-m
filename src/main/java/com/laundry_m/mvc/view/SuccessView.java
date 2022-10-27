package com.laundry_m.mvc.view;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.laundry_m.mvc.controller.FavoriteController;
import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Favorite;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
import com.laundry_m.mvc.vo.PayLog;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Review;
import com.laundry_m.mvc.vo.StatisticsDetail;
import com.laundry_m.mvc.vo.StatisticsTotal;
import com.laundry_m.mvc.vo.Users;

public class SuccessView {
	private static DecimalFormat won = new DecimalFormat("#,###");
	private static Scanner sc = new Scanner(System.in);
	private static FavoriteController favoriteController = new FavoriteController();
	
	private static String getTel(String tel) {
		StringBuffer sb = new StringBuffer();
		sb.append(tel);
		sb.insert(3, '-');
		sb.insert(8, '-');
		return sb.toString();
	}
	
	private static String getLaunTel(String tel) {
		StringBuffer sb = new StringBuffer();
		sb.append(tel);
		sb.insert(2, '-');
		sb.insert(6, '-');
		return sb.toString();
	}
	
	private static String getDate(Timestamp timestamp) {
		return timestamp.toLocaleString();
	}
	
	private static String getAccountNumber(String accountNumber) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(accountNumber);
		buffer.insert(4, "-");
		buffer.insert(8, "-");
		return buffer.toString();
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	public static void printMetapay(Metapay metapay) {
		System.out.println("< " + metapay.getUserId() + " 님의 메타페이 가입 정보 >");
		System.out.println("현재 잔액: " + won.format(metapay.getMetapayBalance()));
		System.out.println("가입일: " + getDate(metapay.getMetapayDate()) + "\n");
		
		System.out.println("< 연결된 계좌 목록: " + metapay.getPayAccount().size() + "개 >");
		printPayAccount(metapay.getPayAccount());
	}
	
	public static void printPayAccount(List<PayAccount> payAccounts) {
		String[] bank = {"", "농협", "국민", "우리", "하나"};
		for (PayAccount account : payAccounts) {
			System.out.println((payAccounts.indexOf(account) + 1) + ". 계좌 코드: " + account.getPayAccountId() + " | " + bank[account.getBankId().intValue()] + " | " + getAccountNumber(account.getPayAccountNumber()));
		}
	}
	
	public static void printUserBook(List<Book> books) {
		String[] clothes = {"","상의/자켓","하의","스커트","와이셔츠/남방","티셔츠","블라우스","원피스","스웨터/가디건","봄가을점퍼/아웃도어","코트","가죽/모피의류","겨울패딩/점퍼","넥타이","스카프/목도리","이불/침구류","커튼/카페트","한복류","모자","가방/기타가죽제품","운동화/스니커즈류"};
		String[] fabric = {"","면","니트","레이온","데님","실크/쉬폰","린넨","퍼","앙고라","가죽"};
		
		if (books == null || books.size() == 0) {
			System.out.println("예약 내역이 존재하지 않습니다.");
		} else {
			for (Book book : books) {
				System.out.print(book.getBookId() + " | " + book.getUserId() + " | " + book.getLaundry().getLaundryName() + " | " + book.getBookCount() + "벌 | " + won.format(book.getBookTotalFee()) + "원 | " + book.getBookMethod().getBookMethodName() + " | " + getDate(book.getBookInsertDate()) + " | " + book.getBookState().getBookStateName());
				if (book.getBookMemo() != null) {
					System.out.println(" | " + book.getBookMemo());
				} else {
					System.out.println();
				}
				for (BookLine bookLine : book.getBookLine()) {
					System.out.println("  └ " + clothes[bookLine.getClothesId()] + " | " + fabric[bookLine.getFabricId()] + " | " + won.format(bookLine.getBookLineFee()) + "원");
				}
				System.out.println();
			}
		}
	}

	
	public static void printLaundryList(List<Laundry> laundries , List<Integer> distances) {
		//(번호) 나와의 거리 | 세탁소 이름 | 세탁소 주소 | 세탁소 번호 | 배달료
		int i = 0;
		System.out.println( "  "+"고유번호 " +" | 나와의 거리 " + " | " + "    상호명    " + " | " + "     주소     " + " | " + "    연락처    " +  " | "  + "  배달비" );
		for(Laundry laundry : laundries) {
			System.out.println("  "+ laundry.getLaundryId() + "     |    " + distances.get(i) + "km    | " + laundry.getLaundryName() + " | " + laundry.getLaundryAddress() + " | " + getLaunTel(laundry.getLaundryTel()) +  " | "  + won.format(laundry.getLaundryDeliveryFee()) + "원");

			i++;
		}
	}
	
	
	public static void printLaundry(Laundry laundry, int distance) {
		System.out.println( "  "+"고유번호 " +" | 나와의 거리 " + " | " + "    상호명    " + " | " + "     주소     " + " | " + "    연락처    " +  " | "  + "  배달비" );
		System.out.println("  "+ laundry.getLaundryId() + "     |    "+ distance + "km    | " + laundry.getLaundryName() + " | " + laundry.getLaundryAddress() + " | " + getLaunTel(laundry.getLaundryTel()) +  " | "  + won.format(laundry.getLaundryDeliveryFee()) + "원");

	}
	public static void printUserReview(List<Review> reviews) {
		if(reviews == null || reviews.size()==0) {
			System.out.println("작성하신 리뷰가 없습니다");
			System.out.println("");		
		}else {System.out.print("리뷰번호   |   ID   |  세탁소ID  |  예약 번호  | 별점 | 리뷰내용 ");
				System.out.println("");
			for(Review review : reviews) 
				System.out.println("" +review.getReviewId() + " | " + review.getUserId() + " | " + review.getLaundryId() + " | " + review.getBookId() + " | " + review.getReviewRate() + " | " + review.getReviewContent());
				System.out.println("");
		}
	}
	
	public static void printStatisticsTotal(StatisticsTotal total) {
		System.out.println("총 예약 건: " +  won.format(total.getBookCount()) + "건");
		if (total.getBookTotalFee() == null) {
			System.out.println("총 예약 가격: 0원");
		} else {			
			System.out.println("총 예약 가격: " + won.format(total.getBookTotalFee()) + "원");
		}
	}
	
	public static void printStatisticsDetail(List<StatisticsDetail> details) {
		System.out.println();
		String[] clothes = {"","상의/자켓","하의","스커트","와이셔츠/남방","티셔츠","블라우스","원피스","스웨터/가디건","봄가을점퍼/아웃도어","코트","가죽/모피의류","겨울패딩/점퍼","넥타이","스카프/목도리","이불/침구류","커튼/카페트","한복류","모자","가방/기타가죽제품","운동화/스니커즈류"};
		for (StatisticsDetail detail : details) {
			System.out.println(clothes[detail.getClothesId()] + " : " + detail.getCount() + "건");
		}
	}
	
	public static void printWashMethod(Laundry laundry) {
		System.out.println("");
	}
	
	public static void printMyLaundry(Users users, Laundry laundry) {
		System.out.println(users.getUserName() + "님의 세탁소 정보를 조회합니다.");
		System.out.println("     "+laundry.getLaundryName()+"     ");
		
		System.out.println("[주소]" + laundry.getLaundryAddress());
		System.out.println("[번호]" + getLaunTel(laundry.getLaundryTel()));
		System.out.println("[배달요금]" + laundry.getLaundryDeliveryFee());
		
	}

	public static void printFavorite(List<Favorite> favorites) {
		try {
			if(favorites == null || favorites.size()==0) {
				System.out.println("즐겨찾기 한 세탁소가 없습니다");
				System.out.println("");
			}else {
				System.out.print("   사용자아이디    |    세탁소이름    |    세탁소ID    |   즐겨찾기 번호");
				System.out.println("");
				for(Favorite favorite : favorites) {
					System.out.println("" + favorite.getUserId() + " | " + favorite.getLaundry().getLaundryName() + " | " + favorite.getLaundryId() + " | " + favorite.getFavoriteId() );
					System.out.println("");
				}
				System.out.println("1. 예약하기 |  2. 즐겨찾기 삭제하기 | 3. 뒤로가기");
				System.out.print("▶ ");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					System.out.println("예약으로 이동할 세탁소 번호를 입력해주세요.");
					System.out.print("▶ ");
					Long laundryId = (long)Integer.parseInt(sc.nextLine());
					BookMenuView.bookForm(laundryId);
					break;
				case 2:
					System.out.println("삭제할 즐겨찾기 번호를 입력해주세요.");
					System.out.print("▶ ");
					Long favoriteId = (long)Integer.parseInt(sc.nextLine());
					favoriteController.deleteFavorite(favoriteId);
					break;
				case 3:
					break;
				}
			}
		} catch (Exception e) {
			FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
		}
		
	}
	
	public static void printUserInfo(Users users) {
		System.out.println();
		System.out.println("[이름] " + users.getUserName());
		System.out.println("[아이디] " + users.getUserId());
		System.out.println("[전화번호] " + users.getUserPhone());
		System.out.println("[주소] " + users.getUserAddress());
		System.out.println("[회원타입] " + users.getUserType());
		System.out.println("[삭제여부] " + users.getUserState());
	}
	
	public static void printUserInfoList(List<Users> userList) {
		for(Users user : userList) {
			System.out.println();
			System.out.println("[이름] " + user.getUserName());
			System.out.println("[아이디] " + user.getUserId());
			System.out.println("[전화번호] " + user.getUserPhone());
			System.out.println("[주소] " + user.getUserAddress());
			System.out.println("[회원타입] " + user.getUserType());
			System.out.println("[삭제여부] " + user.getUserState());
		}
	}
	
	public static void printAdminReview(List<Review> reviews) {
		if(reviews == null || reviews.size()==0) {
			System.out.println("작성된 리뷰가 없습니다");
			System.out.println("");		
		}else {
			System.out.print("리뷰번호 | ID | 예약번호 | 별점 | 수정날짜 | 리뷰내용");
			System.out.println("");
			for(Review review : reviews) 
				System.out.println("" +review.getReviewId() + " | " + review.getUserId() + " | " + review.getLaundryId() + " | " + review.getBookId() + " | " + review.getReviewRate() + " | " + review.getReviewContent());
				System.out.println("");
		}
	}
	
	public static void printPayLog(List<PayLog> payLogs) {
		if (payLogs == null || payLogs.size() == 0) {
			System.out.println("메타페이 거래 내역이 존재하지 않습니다.");
		} else {
			int i = 1;
			for (PayLog log : payLogs) {
				System.out.print(i++ + ". " + log.getPayCategory().getPayCategoryName() + " | ");
				if (log.getPayCategoryId() == 2) {
					System.out.print(log.getLaundry().getLaundryName() + " | ");
				} else {
					System.out.print(getAccountNumber(log.getPayAccount().getPayAccountNumber()) + " | ");
				}
				System.out.println(getDate(log.getPayLogInsertDate()));
			}
		}
	}
	
	public static void printLaundryFee(List<Fee> feeList) {
		for(Fee fee : feeList) {
			System.out.println(fee.getClothes().getClothesName() + " : " + fee.getClothesFee() );
		}
	}
	
	public static void printLaundryExFee(List<ExtraFee> exfeeList) {
		for(ExtraFee exfee : exfeeList) {
			System.out.println(exfee.getFabric().getFabricName() + " : " + exfee.getFabricFee() );
		}
	}
	
	public static void printOnlyLaundry(Laundry laundry) {
		System.out.println( "  "+"고유번호 " + " | " + "    상호명    " + " | " + "     주소     " + " | " + "    연락처    " +  " | "  + "  배달비" );
		System.out.println("  "+ laundry.getLaundryId() + "     |    " + laundry.getLaundryName() + "    | " + laundry.getLaundryAddress() + " | " + getLaunTel(laundry.getLaundryTel()) +  " | "  + won.format(laundry.getLaundryDeliveryFee()) + "원");

	}
	
	
}
