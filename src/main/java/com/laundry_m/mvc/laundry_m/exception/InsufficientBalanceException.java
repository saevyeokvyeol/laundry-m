package com.laundry_m.mvc.laundry_m.exception;

/**
 * 잔액이 부족할 시 발생하는 오류
 * */
public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {}

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
