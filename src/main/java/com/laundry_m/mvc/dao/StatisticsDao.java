package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.laundry_m.mvc.vo.StatisticsDetail;
import com.laundry_m.mvc.vo.StatisticsTotal;

public interface StatisticsDao {
	/**
	 * 총 매출, 일별 매출, 세탁소별 매출, 회원별 매출의 전체 통계
	 * @param: Map<String, Object> map(날짜, 세탁소 아이디, 회원별 매출 중 하나가 있으면 해당 컬럼으로 검색, 없으면 총 매출 검색)
	 * @return: StatisticsTotal
	 * */
	StatisticsTotal searchTotalStatistics(Map<String, Object> map) throws SQLException;

	/**
	 * 총 매출, 일별 매출, 세탁소별 매출, 회원별 매출의 상품별 통계
	 * @param: Map<String, Object> map(날짜, 세탁소 아이디, 회원별 매출 중 하나가 있으면 해당 컬럼으로 검색, 없으면 총 매출 검색)
	 * @return: List<StatisticsDetail>
	 * */
	List<StatisticsDetail> searchDetailStatistics(Map<String, Object> map) throws SQLException;
}
