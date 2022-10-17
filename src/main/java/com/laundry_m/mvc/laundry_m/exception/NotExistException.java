package com.laundry_m.mvc.laundry_m.exception;

/**
 * DB에 해당하는 정보가 없을 때 발생하는 오류
 * 단순 검색이 아닌, 반드시 필요한 연관관계 정보가 없을 경우 사용
 * */
public class NotExistException extends Exception {
	public NotExistException() {}

	public NotExistException(String message) {
		super(message);
	}
}
