package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.StatisticsDetail;
import com.laundry_m.mvc.vo.StatisticsTotal;

import util.DbUtil;

public class StatisticsDaoImpl implements StatisticsDao {

	/**
	 * 총 매출, 일별 매출, 세탁소별 매출, 회원별 매출의 전체 통계
	 * @param: Map<String, Object> map(날짜, 세탁소 아이디, 회원별 매출 중 하나가 있으면 해당 컬럼으로 검색, 없으면 총 매출 검색)
	 * @return: Map<String, Object>
	 * */
	@Override
	public StatisticsTotal searchTotalStatistics(Map<String, Object> map) throws SQLException {
		SqlSession session = null;
		StatisticsTotal statisticsTotal = null;
		try {
			session = DbUtil.getSession();
			statisticsTotal = session.selectOne("statisticsMapper.searchTotalStatistics", map);
		} finally {
			DbUtil.sessionClose(session);
		}
		return statisticsTotal;
	}

	/**
	 * 총 매출, 일별 매출, 세탁소별 매출, 회원별 매출의 상품별 통계
	 * @param: Map<String, Object> map(날짜, 세탁소 아이디, 회원별 매출 중 하나가 있으면 해당 컬럼으로 검색, 없으면 총 매출 검색)
	 * @return: List<StatisticsDetail>
	 * */
	@Override
	public List<StatisticsDetail> searchDetailStatistics(Map<String, Object> map) throws SQLException {
		SqlSession session = null;
		List<StatisticsDetail> statisticsDetail = null;
		try {
			session = DbUtil.getSession();
			statisticsDetail = session.selectList("statisticsMapper.searchDetailStatistics", map);
		} finally {
			DbUtil.sessionClose(session);
		}
		return statisticsDetail;
	}

}
