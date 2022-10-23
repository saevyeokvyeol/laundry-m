package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

import util.DbUtil;

public class LaundryDaoImpl implements LaundryDao {

	@Override
	public int insertLaundry(Laundry laundry) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			
			result = session.insert("laundryMapper.insertLaundry");
			if(result == 1) state = true;
			
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

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

	@Override
	public int insertFee(Fee fee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.insertFee", fee);
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

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

	@Override
	public int insertFabric(Fabric fabric) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.insertFabric");
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	@Override
	public int insertExtraFee(ExtraFee extraFee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.insertExtraFee");
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	@Override
	public int updateFee(ExtraFee extraFee) throws SQLException {
		SqlSession session = null;
		int result = 0;
		boolean state = false;
		
		try {
			session = DbUtil.getSession();
			result = session.update("laundryMapper.updateFee", extraFee);
			
			if(result == 1) state = true;
		
		} finally {
			DbUtil.sessionClose(session, state);
		}
		
		return result;
	}

	@Override
	public int deleteFee(ExtraFee extraFee) throws SQLException {
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

	@Override
	public List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByNameLaundry");
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	@Override
	public List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByAddressLaundry");
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	@Override
	public List<Laundry> selectByLowestByLaundry(Long feeId, Long FabricId) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByLowestByLaundry");
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	@Override
	public int clothesfabricFee(Long laundryId, Long clothesId, Long fabricId) throws SQLException {
		SqlSession session = null;
		Laundry laundry = null;
		int totalFee = 0;
		
		try {
			session = DbUtil.getSession();
			//세탁소 고유번호로 세탁소를 구해온다 - 세탁소별 옷 가격
			laundry = session.selectOne("laundryMapper.selectByLaundryId", laundryId);
			
			//세탁소 고유번호 + 옷 고유번호로 옷 종류 별 가격 구한다.
			Fee fee = Fee.builder().laundryId(laundryId).clothesId(clothesId).build();
			int resultClothesFee = fee.getClothesFee();
			
			//옷감 고유번호 + 세탁소 고유번호로 추가 가격 구한다.
			ExtraFee extraFee = ExtraFee.builder().laundryId(laundryId).fabricId(fabricId).build();
			int resultExtraFee = extraFee.getFabricFee();
			
			totalFee = resultClothesFee + resultExtraFee;
			
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return totalFee;
	}

	@Override
	public List<Laundry> selectByLaundryId(String LaundryId) throws SQLException {
		SqlSession session = null;
		List<Laundry> laundries = null;
		
		try {
			session = DbUtil.getSession();
			laundries = session.selectList("laundryMapper.selectByLaundryId");
		} finally {
			DbUtil.sessionClose(session);
		}
		
		return laundries;
	}

	@Override
	public double userBetweenLaun(Users users, Laundry laundry) throws SQLException {
		
		//회원의 위도, 경도 구한다
		double userLatit =  users.getUserLatitude(); //위도
		double userLong = users.getUserLongitude(); //경도
		
		//세탁소의 위도, 경도 구한다
		double laundryLatit = laundry.getLaundryLatitude(); //위도
		double laundryLong = laundry.getLaundryLongitude(); //경도
		
		//경도 - 경도
		double theta = userLong - laundryLong;
        double dist = Math.sin(deg2rad(userLatit))* Math.sin(deg2rad(laundryLatit)) 
        			+ Math.cos(deg2rad(userLatit)) * Math.cos(deg2rad(laundryLatit))*Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60*1.1515*1609.344;

        return dist; //단위 meter
		
	}
	
	//10진수를 radian(라디안)으로 변환
    private static double deg2rad(double deg){
        return (deg * Math.PI/180.0);
    }
    //radian(라디안)을 10진수로 변환
    private static double rad2deg(double rad){
        return (rad * 180 / Math.PI);
    }

}
