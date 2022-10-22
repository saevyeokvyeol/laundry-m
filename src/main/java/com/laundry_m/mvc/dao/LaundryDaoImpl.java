package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;

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

}