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

}
