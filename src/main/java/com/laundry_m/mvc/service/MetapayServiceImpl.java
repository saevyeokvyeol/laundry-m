package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.dao.MetapayDao;
import com.laundry_m.mvc.dao.MetapayDaoImpl;
import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InsufficientBalanceException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
import com.laundry_m.mvc.vo.PayLog;

public class MetapayServiceImpl implements MetapayService {
	private MetapayDao metapayDao = new MetapayDaoImpl();
	/**
	 * 메타페이 가입
	 * @param: Metapay metapay(사용자 ID, 메타페이 비밀번호, 메타페이 계좌(메타페이 번호, 은행 id, 계좌번호))
	 * @exception: DuplicationException(아이디에 해당하는 메타페이가 이미 존재할 경우 오류)
	 * 			   NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(로그인한 아이디나 은행 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void joinMetapay(Metapay metapay)
			throws SQLException, DuplicationException, NotLoginException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	/**
	 * 메타페이 충전
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @exception: NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(메타페이 아이디나 계좌 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void chargeMetapay(String userId, PayLog payLog)
			throws SQLException, NotLoginException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	/**
	 * 메타페이 인출
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @exception: NotLoginException(로그인하지 않고 메타페이에 가입할 경우 오류)
	 * 			   NotExistException(메타페이 아이디나 계좌 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   InsufficientBalanceException(메타페이 잔액이 거래 금액보다 클 경우 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void withdrawMetapay(String userId, PayLog payLog) throws SQLException, NotLoginException, NotExistException,
			InsufficientBalanceException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	/**
	 * 메타페이 계좌 연동
	 * @param: PayAccount payAccount(은행 id, 계좌 번호)
	 * @exception: NotLoginException(로그인하지 않고 메타페이 계좌를 연동할 경우 오류)
	 * 			   NotExistException(회원 아이디나 은행 아이디가 DB에 존재하지 않을 경우 오류)
	 * 			   NotFilledInException(필요한 필드가 입력되지 않았을 경우 오류)
	 * */
	@Override
	public void addMetapayAccount(PayAccount payAccount)
			throws SQLException, NotLoginException, NotExistException, NotFilledInException {
		int result = metapayDao.addMetapayAccount(null, payAccount);
		if (result != 1) throw new NotExistException("연동 계좌를 변경할 수 없습니다.\n잠시 뒤 다시 시도해주세요.");

	}

	/**
	 * 아이디로 메타페이 검색
	 * @param: String userId
	 * @exception: NotLoginException(로그인하지 않고 메타페이를 검색할 경우 오류)
	 * 			   NotExistException(회원 아이디가 DB에 존재하지 않을 경우 오류)
	 * */
	@Override
	public Metapay searchMetapayByUserId(String userId) throws SQLException, NotLoginException, NotExistException {
		Metapay metapay = metapayDao.selectMetapayByUserId(userId);
		if (metapay == null) throw new NotExistException("메타페이 가입자가 아닙니다.");
		return metapay;
	}

	/**
	 * 메타페이 아이디로 거래 내역 검색
	 * @param: Long metapayId
	 * @return: List<PayLog>
	 * @exception: NotLoginException(로그인하지 않고 메타페이를 검색할 경우 오류)
	 * 			   NotExistException(회원 아이디가 DB에 존재하지 않을 경우 오류)
	 * */
	@Override
	public List<PayLog> searchPayLogByMetapayId(Long metapayId) throws SQLException, NotLoginException, NotExistException {
		return metapayDao.searchPayLogByMetapayId(metapayId);
	}

}
