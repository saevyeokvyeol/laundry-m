package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.ReviewController;
import com.laundry_m.mvc.vo.Review;


public class ReviewMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static ReviewController reviewController = new ReviewController();
	
	/**
	 * 리뷰 폼 메뉴
	 * */
	public static void reviewForm(Long bookId) {
		boolean run = true;
		Long starRate;
		while (run) {
			try {
				do {
					System.out.println("\n" + " 해당 주문 완료 건에 ★(별점)을 입력해주세요.");
					System.out.print("▶ ★x");
					starRate = (long) Integer.parseInt(sc.nextLine());
					if((starRate > 6) || (starRate < 0)) {
						System.out.println("별점은 0~5 까지 입력해주세요.");
					}
				}while(starRate>=5);
				
				System.out.println("\n" + " 리뷰를 입력해주세요");
				System.out.print("▶ ");
				String content = sc.nextLine();

				Review review = Review.builder().bookId(bookId)
						.reviewRate(starRate)
						.reviewContent(content).build();
				
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}
}
