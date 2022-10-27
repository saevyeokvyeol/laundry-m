package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.view.SuccessView;
import com.laundry_m.mvc.vo.BookLine;
import com.laundry_m.mvc.vo.Metapay;
import com.laundry_m.mvc.vo.PayAccount;
import com.laundry_m.mvc.vo.PayLog;

import util.DbUtil;

public class MetapayDaoImpl implements MetapayDao {
	/**
	 * 메타페이 가입
	 * @param: Metapay metapay(사용자 ID, 메타페이 비밀번호, 메타페이 계좌(메타페이 번호, 은행 id, 계좌번호))
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int joinMetapay(Metapay metapay) throws SQLException {
		SqlSession session = null;
		boolean state = false;
		int result = 0;
		try {
			session = DbUtil.getSession();
			result = session.insert("metapayMapper.joinMetapay", metapay);
			int re = this.addMetapayAccount(session, metapay.getPayAccount().get(0));
			
			if (result == 1 && re == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return result;
	}

	/**
	 * 메타페이 잔액 변경
	 * @param: SqlSession session, String userId, Long amount
	 * @result: int(수정된 레코드 수)
	 * */
	@Override
	public int updateMetapayBalance(SqlSession session, String userId, Long amount) throws SQLException {
		int result = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("amount", amount);
		result = session.insert("metapayMapper.updateMetapayBalance", map);
		
		return result;
	}

	/**
	 * 메타페이 충전
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int chargeMetapay(String userId, PayLog payLog) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 메타페이 인출
	 * @param: String userId, PayLog payLog(메타페이 번호, 메타페이 거래 종류, 계좌ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int withdrawMetapay(String userId, PayLog payLog) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 메타페이 결제
	 * @param: SqlSession session, String userId, PayLog payLog(세탁소ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int payMetapay(SqlSession session, String userId, PayLog payLog) throws SQLException {
		int result = 0;

		Metapay metapay = this.selectMetapayByUserId(userId);
		
		PayLog log = PayLog.builder().laundryId(payLog.getLaundryId())
				.metapayId(metapay.getMetapayId())
				.payCategoryId(payLog.getPayCategoryId())
				.payLogAmount(payLog.getPayLogAmount()).build();
		
		result = session.insert("metapayMapper.payMetapay", log);
		if (this.updateMetapayBalance(session, userId, payLog.getPayLogAmount() * -1) != 1)
			throw new SQLException("메타페이 결제에 오류가 발생했습니다.");

		return result;
	}
	
	/**
	 * 메타페이 결제 취소
	 * @param: SqlSession session, String userId, PayLog payLog(세탁소ID, 거래 금액)
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int payMetapayCancel(SqlSession session, String userId, PayLog payLog) throws SQLException {
		return 0;
	}

	/**
	 * 메타페이 계좌 연동
	 * @param: SqlSession session, PayAccount payAccount(메타페이 id, 은행 id, 계좌 번호)
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int addMetapayAccount(SqlSession session, PayAccount payAccount) throws SQLException {
		boolean flag = false;
		boolean state = false;
		int result = 0;
		
		try {
			if (session == null) {
				session = DbUtil.getSession();
				flag = true;
			}
			
			if (flag) {
				int re = this.deleteMetapayAccount(session, payAccount);
				if (re < 1) throw new SQLException("연동 계좌를 변경할 수 없습니다.\n잠시 뒤 다시 시도해주세요.");
			}
			
			result = session.insert("metapayMapper.addMetapayAccount", payAccount);
			
			if (result == 1) state = true;
		} finally {
			if (flag) DbUtil.sessionClose(session, state);
		}
		return result;
	}

	/**
	 * 메타페이 계좌 연동 해지
	 * @param: SqlSession session, PayAccount payAcount
	 * @result: int(등록된 레코드 수)
	 * */
	@Override
	public int deleteMetapayAccount(SqlSession session, PayAccount payAcount) throws SQLException {
		int result = session.update("metapayMapper.deleteMetapayAccount", payAcount);
		
		return result;
	}
	
	/**
	 * 아이디로 메타페이 검색
	 * @param: String userId
	 * @result: Metapay
	 * */
	@Override
	public Metapay selectMetapayByUserId(String userId) throws SQLException {
		SqlSession session = null;
		Metapay metapay = null;
		
		try {
			session = DbUtil.getSession();
			metapay = session.selectOne("metapayMapper.selectMetapayByUserId", userId);
		} finally {
			DbUtil.sessionClose(session);
		}
		return metapay;
	}
	
	/**
	 * 메타페이 아이디로 거래 내역 검색
	 * @param: Long metapayId
	 * @return: List<PayLog>
	 * */
	public List<PayLog> searchPayLogByMetapayId(Long metapayId) throws SQLException {
		SqlSession session = null;
		List<PayLog> payLogs = null;
		
		try {
			session = DbUtil.getSession();
			payLogs = session.selectList("metapayMapper.searchPayLogByMetapayId", metapayId);
		} finally {
			DbUtil.sessionClose(session);
		}
		return payLogs;
	}
}
