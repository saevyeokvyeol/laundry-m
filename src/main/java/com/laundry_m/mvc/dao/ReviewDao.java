package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Review;

public interface ReviewDao {
	/**
	 * 리뷰 작성
	 * @param: Review review(유저 아이디, 예약 번호, 리뷰 내용, 별점)
	 * @return: int(등록한 레코드 수)
	 * */
	int createReview(Review review) throws SQLException;

	/**
	 * 리뷰 수정
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	 * @return: int(수정한 레코드 수)
	 * */
	int modifyReview(Review review) throws SQLException;

	/**
	 * 리뷰 삭제
	 * @param: Long reviewId
	 * @return: int(삭제한 레코드 수)
	 * */
	int deleteReview(Long reviewId) throws SQLException;

	/**
	 * 전체 리뷰 검색
	 * @return: List<Review>
	 * */
	List<Review> searchReviewAll() throws SQLException;

	/**
	 * 유저 아이디로 리뷰 검색
	 * @param: String userId
	 * @return: List<Review>
	 * */
	List<Review> searchReviewByUserId(String userId) throws SQLException;

	/**
	 * 점포 아이디로 리뷰 검색
	 * @param: Long laundryId
	 * @return: List<Review>
	 * */
	List<Review> searchReviewByLaundryId(Long laundryId) throws SQLException;

	/**
	 * 예약 번호로 리뷰 검색
	 * @param: Long bookId
	 * @return: Review
	 * */
	Review searchReviewByBookId(Long bookId) throws SQLException;

	/**
	 * 리뷰 번호로 리뷰 검색
	 * @param: Long reviewId
	 * @return: Review
	 * */
	Review searchReviewByReviewId(Long reviewId) throws SQLException;
}