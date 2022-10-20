package com.laundry_m.mvc.laundry_m.service;

import java.sql.SQLException;

import com.laundry_m.mvc.domain.Metapay;
import com.laundry_m.mvc.domain.PayLog;
import com.laundry_m.mvc.laundry_m.exception.DuplicationException;
import com.laundry_m.mvc.laundry_m.exception.InsufficientBalanceException;
import com.laundry_m.mvc.laundry_m.exception.NotExistException;
import com.laundry_m.mvc.laundry_m.exception.NotFilledInException;
import com.laundry_m.mvc.laundry_m.exception.NotLoginException;

public interface MetapayService {
	/**
	 * 메타페이 가입
	 * @param: Metapay metapay(사용자 ID, 메타페이 비밀번호, 메타페이 계좌(메타페이 번호, 은행 id, 계좌번호))
	 * @return: Metapay metapay
	 * @exception: DuplicationException(아이디에 해당하는 메타페이가 이미 존재할 경우 오류)
	 * 			   NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(로그인한 아이디나 은행 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	Metapay joinMetapay(Metapay metapay) throws SQLException, DuplicationException, NotLoginException, NotExistException, NotFilledInException;
	
	/**
	 * 메타페이 충전
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @return: PayLog payLog
	 * @exception: NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(메타페이 아이디나 계좌 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	PayLog chargeMetapay(String userId, PayLog payLog) throws SQLException, NotLoginException, NotExistException, NotFilledInException;
	
	/**
	 * 메타페이 인출
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @return: PayLog payLog
	 * @exception: NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(메타페이 아이디나 계좌 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InsufficientBalanceException(메타페이 잔액이 거래 금액보다 클 경우 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	PayLog withdrawMetapay(String userId, PayLog payLog) throws SQLException, NotLoginException, NotExistException, InsufficientBalanceException, NotFilledInException;
	
	/**
	 * 메타페이 계좌 연동
	 * @param: PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @return: PayLog payLog
	 * @exception: NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(메타페이 아이디나 계좌 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InsufficientBalanceException(메타페이 잔액이 거래 금액보다 클 경우 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
}
