package com.laundry_m.mvc.view;

import java.util.Scanner;

import com.laundry_m.mvc.controller.BookController;
import com.laundry_m.mvc.controller.ReviewController;
import com.laundry_m.mvc.vo.Review;


public class ReviewMenuView {
	private static Scanner sc = new Scanner(System.in);
	private static ReviewController reviewController = new ReviewController();
	private static BookController bookController = new BookController();
	
	/**
	 * 리뷰 입력폼 메뉴
	 * */
	public static void reviewForm() {
		boolean run = true;
		Long starRate;
		while (run) {
			try {
				System.out.println("리뷰 작성할 예약번호를 입력해주세요");
				System.out.print("▶ ");
				System.out.println();
				bookController.searchBookByUserId(10L, 10L); //수정
				Long bookId = Long.parseLong(sc.nextLine());
				do {
					System.out.println("\n" + " 해당 주문 완료 건에 ★(별점)을 입력해주세요.");
					System.out.print("▶ ★x");
					starRate = (long) Integer.parseInt(sc.nextLine());
					if((starRate > 6) || (starRate < 0)) {
						System.out.println("별점은 0~5 까지 입력해주세요.");
					}
				}while(starRate>5);
				
				System.out.println("\n" + " 리뷰를 입력해주세요");
				System.out.print("▶ ");
				String content = sc.nextLine();

				Review reviews = Review.builder().bookId(bookId)
						.reviewRate(starRate)
						.reviewContent(content).build();
				
				reviewController.createReview(reviews);
				break;
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}

	//리뷰 수정 form
	public static void reviewUpdateForm() {
		boolean run = true;
		Long starRate;
		while (run) {
		try {
			System.out.println("업데이트할 리뷰 번호를 입력해주세요.");
			reviewController.searchReviewByUserId(); //수정 요청
			System.out.print("▶ ");
			Long reviewId = (long)Integer.parseInt(sc.nextLine());
				do {
					System.out.println("\n" + " 해당 주문 완료 건에 ★(별점)을 입력해주세요.");
					System.out.print("▶ ★x");
					starRate = (long) Integer.parseInt(sc.nextLine());
					if((starRate > 6) || (starRate < 0)) {
						System.out.println("별점은 0~5 까지 입력해주세요.");
					}
				}while(starRate>5 && starRate >= 0);
				
				System.out.println("\n" + " 리뷰를 입력해주세요");
				System.out.print("▶ ");
				String content = sc.nextLine();

				Review reviews = Review.builder().reviewId(reviewId)
						.reviewRate(starRate)
						.reviewContent(content).build();
				
				reviewController.modifyReview(reviews);
				break;
			} catch (Exception e) {
				FailView.errorMessage("오류가 발생했습니다.\n다시 한 번 시도해주세요.");
			}
		}
	}

}
