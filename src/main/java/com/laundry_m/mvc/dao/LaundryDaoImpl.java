package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Clothes;
import com.laundry_m.mvc.domain.ExtraFee;
import com.laundry_m.mvc.domain.Fabric;
import com.laundry_m.mvc.domain.Fee;
import com.laundry_m.mvc.domain.Laundry;

public class LaundryDaoImpl implements LaundryDao {

	@Override
	public int insertLaundry(Laundry laundry) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateLaundry(Laundry laundry) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertFee(Fee fee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFee(Fee fee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertClothes(Clothes clothes) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertFabric(Fabric fabric) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertExtraFee(ExtraFee extraFee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFee(ExtraFee extraFee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFee(ExtraFee extraFee) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Laundry> selectByLowestByLaundry(Long feeId, Long FabricId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
