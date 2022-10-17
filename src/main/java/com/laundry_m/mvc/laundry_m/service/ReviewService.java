package com.laundry_m.mvc.laundry_m.service;

import java.sql.SQLException;

import com.laundry_m.mvc.domain.Review;
import com.laundry_m.mvc.laundry_m.exception.InvalidUserException;
import com.laundry_m.mvc.laundry_m.exception.NotExistException;
import com.laundry_m.mvc.laundry_m.exception.NotFilledInException;
import com.laundry_m.mvc.laundry_m.exception.NotLoginException;

public interface ReviewService {
	/**
	 * 리뷰 작성
	 * @param: Review review(유저 아이디, 예약 번호, 리뷰 내용, 별점)
	 * @return: Review review
	 * @exception: NotLoginException(로그인하지 않고 리뷰 작성을 시도할 경우 오류)
	 * 			   NotExistException(유저 아이디와 예약 번호가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 예약을 소유하지 않은 회원이 리뷰를 입력할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	Review createReview(Review review) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 리뷰 수정
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	 * @return: Review review
	 * @exception: NotLoginException(로그인하지 않고 리뷰 수정을 시도할 경우 오류)
	 * 			   NotExistException(리뷰 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 리뷰를 소유하지 않은 회원이 리뷰를 수정할 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류: 리뷰 아이디 필수, 리뷰 내용과 별점 둘 중 하나는 반드시 입력)
	 * */
	Review modifyReview(Review review) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
	
	/**
	 * 리뷰 삭제
	 * @param: Long reviewId
	 * @return: Review review
	 * @exception: NotLoginException(로그인하지 않고 리뷰 삭제를 시도할 경우 오류)
	 * 			   NotExistException(리뷰 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InvalidUserException(해당 리뷰를 소유하지 않은 회원이 리뷰를 삭제할 경우 오류)
	 * */
	Review deleteReview(Long reviewId) throws SQLException, NotLoginException, NotExistException, InvalidUserException, NotFilledInException;
}
