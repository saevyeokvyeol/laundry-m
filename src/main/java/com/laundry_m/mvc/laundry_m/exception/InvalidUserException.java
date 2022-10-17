package com.laundry_m.mvc.laundry_m.exception;

/**
 * 유효하지 않은 사용자가 접근했을 때 발생하는 오류
 * */
public class InvalidUserException extends Exception {
	public InvalidUserException() {}

	public InvalidUserException(String message) {
		super(message);
	}
}
