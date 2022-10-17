package com.laundry_m.mvc.laundry_m.exception;

/**
 * 입력이 필요한 필드가 비어있을 경우 발생하는 오류
 * */
public class NotFilledInException extends Exception {
	public NotFilledInException() {}

	public NotFilledInException(String message) {
		super(message);
	}
}
