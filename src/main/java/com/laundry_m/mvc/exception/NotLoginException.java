package com.laundry_m.mvc.exception;

/**
 * 로그인하지 않았을 시 발생하는 오류
 * */
public class NotLoginException extends Exception {
	public NotLoginException() {}

	public NotLoginException(String message) {
		super(message);
	}
}
