package com.laundry_m.mvc.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
import com.laundry_m.mvc.vo.PayLog;

public interface MetapayDao {
	/**
	 * 메타페이 가입
	 * @param: Metapay metapay(사용자 ID, 메타페이 비밀번호, 메타페이 계좌(메타페이 번호, 은행 id, 계좌번호))
	 * @result: int(등록된 레코드 수)
	 * */
	int joinMetapay(Metapay metapay) throws SQLException;
	
	/**
	 * 메타페이 잔액 변경
	 * @param: SqlSession session, String userId, Long amount
	 * @result: int(수정된 레코드 수)
	 * */
	int updateMetapayBalance(SqlSession session, String userId, Long amount) throws SQLException;
	
	/**
	 * 메타페이 충전
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	int chargeMetapay(String userId, PayLog payLog) throws SQLException;
	
	/**
	 * 메타페이 인출
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	int withdrawMetapay(String userId, PayLog payLog) throws SQLException;
	
	/**
	 * 메타페이 결제
	 * @param: SqlSession session, String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	int payMetapay(SqlSession session, String userId, PayLog payLog) throws SQLException;
	
	/**
	 * 메타페이 결제 취소
	 * @param: SqlSession session, String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	int payMetapayCancel(SqlSession session, String userId, PayLog payLog) throws SQLException;
	
	/**
	 * 메타페이 계좌 연동
	 * @param: SqlSession session, PayAccount payAccount(메타페이 id, 은행 id, 계좌 번호)
	 * @result: int(등록된 레코드 수)
	 * */
	int addMetapayAccount(SqlSession session, PayAccount payAccount) throws SQLException;
	
	/**
	 * 메타페이 계좌 연동 해지
	 * @param: PayAccount payAcount
	 * @result: int(등록된 레코드 수)
	 * */
	int deleteMetapayAccount(PayAccount payAcount) throws SQLException;
	
	/**
	 * 아이디로 메타페이 검색
	 * @param: String userId
	 * @result: Metapay
	 * */
	Metapay selectMetapayByUserId(String userId) throws SQLException;
}
