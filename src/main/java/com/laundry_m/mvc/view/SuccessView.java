package com.laundry_m.mvc.view;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.List;

import com.laundry_m.mvc.vo.Book;
import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Review;

public class SuccessView {
	private static DecimalFormat won = new DecimalFormat("#,###");
	
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
			System.out.println((payAccounts.indexOf(account) + 1) + " 계좌 코드: " + account.getPayAccountId() + " | " + bank[account.getBankId().intValue()] + " | " + getAccountNumber(account.getPayAccountNumber()));
		}
	}
	
	public static void printUserBook(List<Book> books) {
		String[] clothes = {"","상의/자켓","하의","스커트","와이셔츠/남방","티셔츠","블라우스","원피스","스웨터/가디건","봄가을점퍼/아웃도어","코트","가죽/모피의류","겨울패딩/점퍼","넥타이","스카프/목도리","이불/침구류","커튼/카페트","한복류","모자","가방/기타가죽제품","운동화/스니커즈류"};
		String[] fabric = {"","면","니트","레이온","데님","실크/쉬폰","린넨","퍼","앙고라","가죽"};
		for (Book book : books) {
			System.out.print(book.getBookId() + " | " + book.getUserId() + " | " + book.getLaundry().getLaundryName() + " | " + book.getBookCount() + "벌 | " + won.format(book.getBookTotalFee()) + "원 | " + book.getBookMethod().getBookMethodName() + " | " + getDate(book.getBookInsertDate()) + " | " + book.getBookState().getBookStateName());
			if (book.getBookMemo() != null) {
				System.out.println(" | " + book.getBookMemo());
			} else {
				System.out.println();
			}
			for (BookLine bookLine : book.getBookLine()) {
				System.out.println("  └ " + clothes[bookLine.getClothesId().intValue()] + " | " + fabric[bookLine.getFabricId().intValue()] + " | " + won.format(bookLine.getBookLineFee()) + "원");
			}
			System.out.println();
		}
	}

	
	public static void printLaundryList(List<Laundry> laundries , List<Double> distances) {
		//(번호) 나와의 거리 | 세탁소 이름 | 세탁소 주소 | 세탁소 번호 | 배달료
		int i = 0;
		System.out.println( " 나와의 거리 " + " | " + "    상호명    " + " | " + "     주소     " + " | " + "    연락처    " +  " | "  + "     배달비" );
		for(Laundry laundry : laundries) {
			System.out.println( "(" + (i+1) + ") " + distances.get(i) + "km | " + laundry.getLaundryName() + " | " + laundry.getLaundryAddress() + " | " + getLaunTel(laundry.getLaundryTel()) +  " | "  + won.format(laundry.getLaundryDeliveryFee()) + "원" );
			i++;
		}
	}
	
	public static void printLaundry(Laundry laundry, double distance) {
		System.out.println( " 나와의 거리 " + " | " + "    상호명    " + " | " + "     주소     " + " | " + "    연락처    " +  " | "  + "     배달비" );
		System.out.println( distance + " | " + laundry.getLaundryName() + " | " + laundry.getLaundryAddress() + " | " + getLaunTel(laundry.getLaundryTel()) +  " | "  + won.format(laundry.getLaundryDeliveryFee()) + "원" );

	}
	public static void printUserReview(List<Review> reviews) {
		System.out.print("리뷰번호 | ID | 세탁소ID| 별점 | 리뷰내용 ");
		System.out.println("");
		for(Review review : reviews) {
			System.out.print(""+ review.getReviewId() + " | " + review.getUserId() + " | " + review.getLaundryId() + " | " + review.getBookId());
			if(review.getReviewContent() != null) {
				System.out.println("" +review.getReviewId() + " | " + review.getUserId() + " | " + review.getLaundryId() + " | " + review.getBookId() + " | " + review.getReviewRate() + " | " + review.getReviewContent());
				System.out.println("");
			}else {
				System.out.println("작성하신 리뷰가 없습니다");
				System.out.println("");
			}
		}
		

	}
}
