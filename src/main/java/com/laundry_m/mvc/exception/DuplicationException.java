package com.laundry_m.mvc.exception;

/**
 * DB에 ID 등 유니크한 값이 이미 존재할 경우 발생하는 오류
 * */
public class DuplicationException extends Exception {
	public DuplicationException() {}

	public DuplicationException(String message) {
		super(message);
	}
}
