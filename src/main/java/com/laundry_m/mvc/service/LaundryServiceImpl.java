package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundry_m.mvc.dao.LaundryDao;
import com.laundry_m.mvc.dao.LaundryDaoImpl;
import com.laundry_m.mvc.domain.Clothes;
import com.laundry_m.mvc.domain.ExtraFee;
import com.laundry_m.mvc.domain.Fabric;
import com.laundry_m.mvc.domain.Fee;
import com.laundry_m.mvc.domain.Laundry;
import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;

@Service
public class LaundryServiceImpl implements LaundryService {
	
	private LaundryDao laundryDao = new LaundryDaoImpl();

	public void insertLaundry(Laundry laundry)
			throws SQLException, NotLoginException, DuplicationException, NotExistException, NotFilledInException {
		int result = laundryDao.insertLaundry(laundry);
		if(result != 1) {
			throw new SQLException("세탁소 등록에 실패하였습니다.");
		}

	}

	public void updateLaundry(Laundry laundry)
			throws SQLException, NotLoginException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	public void insertClothes(Clothes clothes)
			throws SQLException, NotLoginException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	public void insertFee(Fee fee) throws SQLException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	public void updateFee(Fee fee) throws SQLException, NotExistException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	public void insertFabric(Fabric fabric) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void insertExtraFee(ExtraFee extraFee) throws SQLException, NotLoginException, NotFilledInException {
		// TODO Auto-generated method stub

	}

	public void updateExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, NotLoginException {
		// TODO Auto-generated method stub

	}

	public void deleteExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, InvalidUserException {
		// TODO Auto-generated method stub

	}

	public List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Laundry> selectByLowestByLaundry(Long feeId, Long FabricId)
			throws SQLException, NotExistException, NotLoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
