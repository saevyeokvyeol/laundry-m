package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Review;

public interface ReviewService {
	/**
	 * 리뷰 작성
	 * @param: Review review(유저 아이디, 예약 번호, 리뷰 내용, 별점)
	 * @exception: NotLoginException(로그인하지 않고 리뷰 작성을 시도할 경우 오류)
	 * 			   NotExistException(유저 아이디와 예약 번호가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약을 소유하지 않은 회원이 리뷰를 입력할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	void createReview(Review review) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 리뷰 수정
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	 * @exception: NotLoginException(로그인하지 않고 리뷰 수정을 시도할 경우 오류)
	 * 			   NotExistException(리뷰 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 리뷰를 소유하지 않은 회원이 리뷰를 수정할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류: 리뷰 아이디 필수, 리뷰 내용과 별점 둘 중 하나는 반드시 입력)
	 * */
	void modifyReview(Review review) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 리뷰 삭제
	 * @param: Long reviewId
	 * @exception: NotLoginException(로그인하지 않고 리뷰 삭제를 시도할 경우 오류)
	 * 			   NotExistException(리뷰 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 리뷰를 소유하지 않은 회원이 리뷰를 삭제할 경우 오류)
	 * */
	void deleteReview(Long reviewId) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 전체 리뷰 검색
	 * @return: List<Review>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   InvalidUserException(관리자가 아닐 경우 오류)
	 * */
	List<Review> searchReviewAll() throws SQLException, NotLoginException, InvalidUserException;
	
	/**
	 * 유저 아이디로 리뷰 검색 / 회원이 작성한 리뷰 보기
	 * @param: String userId
	 * @return: List<Review>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(회원이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(관리자나 해당 회원이 아닐 경우 오류)
	 * */
	List<Review> searchReviewByUserId(String userId) throws SQLException, NotLoginException, NotExistException, InvalidUserException;
	
	/**
	 * 점포 아이디로 리뷰 검색
	 * @param: Long laundryId
	 * @return: List<Review>
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(세탁소가 DB에 존재하지 않을 경우 오류)
	 * */
	List<Review> searchReviewByLaundryId(String userId) throws SQLException, NotLoginException, NotExistException;
	
	/**
	 * 예약 번호로 리뷰 검색
	 * @param: Long bookId
	 * @return: Review
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(해당 예약이 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(예약하지 않은 회원이 조회할 경우 오류)
	 * */
	Review searchReviewByBookId(Review review) throws SQLException, NotLoginException, NotExistException, InvalidUserException;
	
	/**
	 * 리뷰 번호로 리뷰 검색
	 * @param: Long reviewId
	 * @return: Review
	 * @exception: NotLoginException(로그인하지 않고 검색을 시도할 경우 오류)
	 * 			   NotExistException(해당 리뷰가 DB에 존재하지 않을 경우 오류)
	 * */
	Review searchReviewByReviewId(Review review) throws SQLException, NotLoginException, NotExistException;
}