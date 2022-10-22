package com.laundry_m.mvc.controller;

import java.util.List;

import com.laundry_m.mvc.service.ReviewService;
import com.laundry_m.mvc.service.ReviewServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Review;
import com.laundry_m.mvc.vo.Users;

public class ReviewController {
	private ReviewService reviewService = new ReviewServiceImpl();
	private Session session = Session.getInstance();

	/**
	 * 리뷰 작성
	 * 
	 * @param: Review review(유저 아이디, 예약 번호, 리뷰 내용, 별점)
	 * @return: int(등록한 레코드 수)
	 */
	public void createReview(Review review) {
		try {
			//로그인 세션
			Users users = (Users) session.getAttribute("loginUser");
			review.setUserId(users.getUserId());
			reviewService.createReview(review);
			SuccessView.printMessage("예약이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}

	}

	/* 블럭 지정 후 Ctrl + Shift + \
	 * /** 리뷰 수정
	 * 
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	 * 
	 * public void modifyReview(Review review) {
	 * 
	 * }
	 * 
	 *//**
		 * 리뷰 삭제
		 * 
		 * @param: Long reviewId
		 */
	/*
	 * public void deleteReview(Long reviewId) {
	 * 
	 * 
	 * }
	 * 
	 *//**
		 * 전체 리뷰 검색
		 * 
		 * @return: List<Review>
		 */
	/*
	 * public List<Review> searchReviewAll() { return null; }
	 * 
	 *//**
		 * 유저 아이디로 리뷰 검색
		 * 
		 * @param: String userId
		 */
	/*
	 * public List<Review> searchReviewByUserId(String userId){ return null;
	 * 
	 * }
	 * 
	 *//**
		 * 점포 아이디로 리뷰 검색
		 * 
		 * @param: Long laundryId
		 * @return: List<Review>
		 */
	/*
	 * public List<Review> searchReviewByLaundryId(){ return null;
	 * 
	 * }
	 * 
	 *//**
		 * 예약 번호로 리뷰 검색
		 * 
		 * @param: Long bookId
		 * @return: Review
		 */
	/*
	 * public Review searchReviewByBookId(Long bookId) {
	 * 
	 * return null; }
	 * 
	 *//**
		 * 리뷰 번호로 리뷰 검색
		 * 
		 * @param: Long reviewId
		 * @return: Review
		 *//*
			 * 
			 * public Review searchReviewByReviewId(Long reviewId) { return null;
			 * 
			 * }
			 * 
			 */
}
