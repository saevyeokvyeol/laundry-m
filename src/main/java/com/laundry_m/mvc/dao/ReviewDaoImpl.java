package com.laundry_m.mvc.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Review;

import util.DbUtil;

public class ReviewDaoImpl implements ReviewDao {
	
	/* private ReviewDao reviewDao = new ReviewDaoImpl(); */
	
	/**
	 * 리뷰 작성
	 * @param: Review review(유저 아이디, 예약 번호, 리뷰 내용, 별점)
	 * @return: int(등록한 레코드 수)
	 * */
	@Override
	public int createReview(Review review) throws SQLException {
		//세션을 생성합니다.
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			result = session.insert("ReviewMapper.createReview", review);
			if(result == 1) state = true;
			
		}finally {
			//세션을 닫습니다.
			DbUtil.sessionClose(session, state);
		}
		//결과를 리턴합니다.
		return result;
	}

	/**
	 * 리뷰 수정
	 * @param: Review review(리뷰 아이디, 리뷰 내용, 별점)
	 * @return: int(수정한 레코드 수)
	 * */
	@Override
	public int modifyReview(Review review) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			result = session.update("reviewMapper.modifyReview", review);
			if(result == 1) state = true;		
			
		}finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	/**
	 * 리뷰 삭제
	 * @param: Long reviewId
	 * @return: int(삭제한 레코드 수)
	 * */
	@Override
	public int deleteReview(Long reviewId) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			result = session.delete("reviewMapper.deleteReview", reviewId);
			if(result == 1) state = true;		
			
		}finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	/**
	 * 전체 리뷰 검색
	 * @return: List<Review>
	 * */
	@Override
	public List<Review> searchReviewAll() throws SQLException {
		SqlSession session = null;
		List<Review> reviews = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			reviews = session.selectList("reviewMapper.listAllReviewList");
		}finally {
			DbUtil.sessionClose(session);
		}
		return reviews;
	}

	/**
	 * 유저 아이디로 리뷰 검색
	 * @param: String userId
	 * @return: List<Review>
	 * */
	@Override
	public List<Review> searchReviewByUserId(String userId) throws SQLException {
		SqlSession session = null;
		List<Review> reviews = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			reviews = session.selectList("reviewMapper.searchReviewByUserId", userId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return reviews;
	}

	/**
	 * 점포 아이디로 리뷰 검색
	 * @param: Long laundryId
	 * @return: List<Review>
	 * */
	@Override
	public List<Review> searchReviewByLaundryId(Long laundryId) throws SQLException {
		SqlSession session = null;
		List<Review> reviews = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			reviews = session.selectList("reviewMapper.searchReviewByLaundryId", laundryId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return reviews;
	}

	/**
	 * 예약 번호로 리뷰 검색
	 * @param: Long bookId
	 * @return: Review 
	 * */
	@Override
	public Review searchReviewByBookId(Long bookId) throws SQLException {
		SqlSession session = null;
		Review reviews = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			reviews = session.selectOne("reviewMapper.searchReviewByBookId", bookId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return reviews;
	}

	/**
	 * 리뷰 번호로 리뷰 검색
	 * @param: Long reviewId
	 * @return: Review
	 * */
	@Override
	public Review searchReviewByReviewId(Long reviewId) throws SQLException {
		SqlSession session = null;
		Review reviews = null;
		try {
			//DbUtil에서 세션을 가져옵니다.
			session = DbUtil.getSession();
			
			//세션으로 DB와 연결되어 매퍼 쿼리문을 실행합니다.
			reviews = session.selectOne("reviewMapper.searchReviewByReviewId", reviewId);
		}finally {
			DbUtil.sessionClose(session);
		}
		return reviews;
	}

}
