package com.laundry_m.mvc.controller;

import java.util.List;

import com.laundry_m.mvc.service.ReviewService;
import com.laundry_m.mvc.service.ReviewServiceImpl;
import com.laundry_m.mvc.session.Session;
import com.laundry_m.mvc.view.FailView;
import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.Laundry;
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
			SuccessView.printMessage("리뷰가 등록되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}

	}

	  /** 리뷰 수정
	    @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	    **/
	    public void modifyReview(Review review) {
	    	try {
				//로그인 세션
				Users users = (Users) session.getAttribute("loginUser");
				review.setUserId(users.getUserId());
				reviewService.modifyReview(review);
				SuccessView.printMessage("리뷰가 수정되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				FailView.errorMessage(e.getMessage());
			}
	    }
	  
	 /**
		 * 리뷰 삭제
		 * @param: Long reviewId
		 */
	  public void deleteReview(Long reviewId) {
		  try {
				//로그인 세션
				reviewService.deleteReview(reviewId);
				SuccessView.printMessage("리뷰가 삭제되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				FailView.errorMessage(e.getMessage());
			}

	  }
	  
	 /**
	 * 전체 리뷰 검색
	 * @return: List<Review>
	 */
	 public void searchReviewAll() { 
		 try {
			 List<Review> reviews = reviewService.searchReviewAll();
			 SuccessView.printUserReview(reviews);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		  }
	  
	 /**
		 * 유저 아이디로 리뷰 검색
		 * @param: String userId
		 */
	
	  public void searchReviewByUserId(){ 
		  try {
			  Users users = (Users)session.getAttribute("loginUser");
			  List<Review> reviews = reviewService.searchReviewByUserId(users.getUserId());
			  SuccessView.printUserReview(reviews);
		  }catch(Exception e) {
			  e.printStackTrace();
			  FailView.errorMessage(e.getMessage());
		  }
	  }
	  
	 /**
	 * 점포 아이디로 리뷰 검색
	 * @param: Long laundryId
	 */
	  public void searchReviewByLaundryId(){ 
		  try {
			  Laundry laundry = (Laundry)session.getAttribute("selectByUserId");
			  List<Review> reviews = reviewService.searchReviewByLaundryId(laundry.getLaundryId());
			  SuccessView.printUserReview(reviews);
		  }catch(Exception e) {
			  e.printStackTrace();
			  FailView.errorMessage(e.getMessage());
		  }
	  }
	  
	 /**
		 * 예약 번호로 리뷰 검색 - 정산 완료시 예약 번호에 맞는 리뷰 있으면 리뷰 보기 창/ 없으면 리뷰 작성 하러 가기
		 * 
		 * @param: Long bookId
		 * @return: Review
		 */
	
	  public Review searchReviewByBookId(Long bookId) {
	 
		  return null; 
	  }
	  
	 /**
		 * 리뷰 번호로 리뷰 검색 - 정산 완료 예약 - 리뷰 선택 시 리뷰 볼 수 있게 이동
		 * 
		 * @param: Long reviewId
		 * @return: Review
		 */
			  
	  public Review searchReviewByReviewId(Long reviewId) { 
		  return null;
	  
	  }
			  
			 
}
