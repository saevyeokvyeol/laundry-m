package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

import util.DbUtil;

public class LaundryDaoImpl implements LaundryDao {

	/** 
	 * 	세탁소 등록: 세탁소 인서트
	 * 	@param : Laundry laundry(세탁소 점포아이디, 아이디, 점포 이름, 점포 번호, 수거비용)
	 * 	@return : int(등록한 레코드 수)
	 *  */
	@Override
	public int insertLaundry(SqlSession session, Laundry laundry) throws SQLException {
		int result = session.insert("laundryMapper.insertLaundry", laundry);
		
		return result;
	}

	/** 
	 *  세탁소 갱신
	 *  @param : Laundry laundry(세탁소 이름, 전화번호, 세탁소 주소)
	 *  @return : int(등록한 레코드 수)
	 *  */
	@Override
	public int updateLaundry(Laundry laundry) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.updateLaundry", laundry);
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/** 
	 *  가격 등록
	 *  @param : Fee fee(가격 번호, 세탁소아이디, 옷 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	@Override
	public int insertFee(SqlSession session, Fee fee) throws SQLException {
		
		int result = session.insert("laundryMapper.insertFee", fee);
		return result;
	}

	/** 가격 갱신
	 *  @param : Fee fee(세탁소 아이디, 옷 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	@Override
	public int updateFee(Fee fee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.updateFee", fee);
			if(result == 1) state = true;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/** 
	 *  옷 인서트
	 *  @param : Clothes clothes(옷 아이디, 옷 이름)
	 *  @return : int(등록한 레코드 수)
	 *  */
	@Override
	public int insertClothes(Clothes clothes) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.insertClothes");
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/** 
	 * 	천 인서트
	 *   @param : Fabric fabric(천 아이디, 천이름, 세탁방법)
	 *   @return : int(등록한 레코드 수)
	 * */
	@Override
	public int insertFabric(Fabric fabric) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.insertFabric", fabric);
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/** 
	 *  추가가격 인서트
	 *  @param : ExtraFee extraFee(추가가격 아이디, 천아이디, 점포 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 *  */
	@Override
	public int insertExtraFee(SqlSession session, ExtraFee extraFee) throws SQLException {
		int result = session.update("laundryMapper.insertExtraFee", extraFee);
		return result;
	}

	/** 
	 *  추가가격 수정: extra_fee 테이블 레코드 update
	 *  @param : ExtraFee extraFee(천아이디, 점포 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	@Override
	public int updateExtraFee(ExtraFee extraFee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.updateExtraFee", extraFee);
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/** 
	 * 	추가가격 삭제
	 *  @param : Long extraFeeId
	 *  */
	@Override
	public int deleteExtraFee(ExtraFee extraFee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.deleteFee", extraFee);
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	/**
	 *  세탁소 이름으로 찾기
	 *  @param : String LaundryName
	 *  @return : List<Laundry>
	 * */
	@Override
	public List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByNameLaundry", LaundryName);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	/**
	 *  세탁소 주소로 찾기
	 *  @param : String LaundryAddress
	 *  @return : List<Laundry>
	 * */
	@Override
	public List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByAddressLaundry" , LaundryAddress);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	/**
	 *  옷 가격 최저가 세탁소 검색
	 *  1. 옷 가격 검색 시 가격
	 *  2. 천 가격 검색 시 가격
	 *  3. 두 가격을 더한 값 order by 첫번째 값에 대한 점포아이디
	 *  @param : Long feeId, Long extraFeeId
	 *  @return : Laundry
	 * */
	@Override
	public Laundry selectByLowestByLaundry(String userAddress, int clothesId, int FabricId) throws SQLException {
		SqlSession session = null;
		Laundry laundry = null;
		
		try {
			session = DbUtil.getSession();
			
			String str = userAddress;
			str = str.trim();
			String [] newStr = str.split("\\s+");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("clothesId", clothesId);
			map.put("FabricId", FabricId);
			map.put("userAddress", newStr[1] );
			
			laundry = session.selectOne("laundryMapper.selectByLowestByLaundry", map);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundry;
	}

	/**
	 * 특정 세탁소에서 옷 + 재질 가격 더하는 메소드
	 * */
	@Override
	public int clothesfabricFee(Long laundryId, int clothesId, int fabricId) throws SQLException {
		SqlSession session = null;
		int totalFee = 0;
		
		try {
			session = DbUtil.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("laundryId", laundryId);
			map.put("clothesId", clothesId);
			map.put("fabricId", fabricId);
			totalFee = session.selectOne("laundryMapper.selectFeeByLaundryId", map);
			
		} finally {
			DbUtil.sessionClose(session);
		}

		return totalFee;
	}

	/**
	 * 세탁소 아이디로 찾기
	 * */
	@Override
	public Laundry selectByUserId(String userId) throws SQLException {
		SqlSession session = null;
		Laundry laundry = null;
		
		try {
			session = DbUtil.getSession();
			laundry = session.selectOne("laundryMapper.selectByLaundryId", userId);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundry;
	}

	/**
	 * 회원 주소 - 세탁소 주소 사이 거리 구하기
	 * */
	@Override
	public int userBetweenLaun(Users users, Laundry laundry) throws SQLException {
		
		//회원의 위도, 경도 구한다

		double userLatit =  users.getUserLatitude(); //위도
		double userLong = users.getUserLongtitude(); //경도

		//세탁소의 위도, 경도 구한다
		double laundryLatit = laundry.getLaundryLatitude(); //경도
		double laundryLong = laundry.getLaundryLongtitude(); //위도
		
		//경도 - 경도
		double theta = userLong - laundryLong;
        double dist = (Math.sin(deg2rad(userLatit)) * Math.sin(deg2rad(laundryLatit))) 
        			+ (Math.cos(deg2rad(userLatit)) * Math.cos(deg2rad(laundryLatit))) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;

        return (int)(dist / 1000); //단위 km
	}
	
	//10진수를 radian(라디안)으로 변환
    private static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }


	/**
	 * 사용자 위치에서 세탁소 찾기
	 * */
	@Override
	public List<Laundry> selectByMyLaundry(String userAddress) throws SQLException, NotExistException, NotLoginException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			
			//사용자 주소에서 '구'만 가져온다
			String str = userAddress;
			str = str.trim();
			String [] newStr = str.split("\\s+");
			
			laundries = session.selectList("laundryMapper.selectByMyLaundry" , newStr[1]);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	/**
	 * 천으로 세탁 방법 찾기
	 * */
	@Override
	public Fabric selectWashByFabric(int fabricId) throws SQLException, NotExistException, NotLoginException {
		SqlSession session = null;
		Fabric fabric = null;
		
		try {
			session = DbUtil.getSession();
			fabric = session.selectOne("laundryMapper.selectWashByFabric" , fabricId);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return fabric;
	}

	@Override
	public Laundry selectAllFee(Long laundryId) throws SQLException, NotExistException, NotLoginException {
		SqlSession session = null;
		Laundry feeList = null;
		
		try {
			session = DbUtil.getSession();
			feeList = session.selectOne("laundryMapper.selectAllFee", laundryId);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return feeList;
		
	}

	@Override
	public Laundry selectAllExtraFees(Long laundryId) throws SQLException, NotExistException, NotLoginException {
		SqlSession session = null;
		Laundry extraFeeList = null;
		
		try {
			session = DbUtil.getSession();
			extraFeeList = session.selectOne("laundryMapper.selectAllExtraFees", laundryId);
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return extraFeeList;
		
	}

}
