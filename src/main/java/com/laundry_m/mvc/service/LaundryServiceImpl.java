package com.laundry_m.mvc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laundry_m.mvc.dao.LaundryDao;
import com.laundry_m.mvc.dao.LaundryDaoImpl;
import com.laundry_m.mvc.exception.DuplicationException;
import com.laundry_m.mvc.exception.InvalidUserException;
import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotFilledInException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

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
		int result = laundryDao.updateLaundry(laundry);
		if(result != 1) {
			throw new SQLException("세탁소 수정에 실패하였습니다.");
		}
	}

	public void insertClothes(Clothes clothes)
			throws SQLException, NotLoginException, NotExistException, NotFilledInException {
		int result = laundryDao.insertClothes(clothes);
		if(result != 1 ) {
			throw new SQLException("옷 등록에 실패하였습니다");
		}

	}

	public void insertFee(Fee fee) throws SQLException, NotExistException, NotFilledInException {
		int result = laundryDao.insertFee(fee);
		if(result != 1 ) {
			throw new SQLException("가격 등록에 실패하였습니다");
		}

	}

	public void updateFee(Fee fee) throws SQLException, NotExistException, NotFilledInException {
		int result = laundryDao.updateFee(fee);
		if(result != 1 ) {
			throw new SQLException("가격 수정에 실패하였습니다");
		}
	}

	public void insertFabric(Fabric fabric) throws SQLException {
		int result = laundryDao.insertFabric(fabric);
		if(result != 1 ) {
			throw new SQLException("천 등록에 실패하였습니다");
		}

	}

	public void insertExtraFee(ExtraFee extraFee) throws SQLException, NotLoginException, NotFilledInException {
		int result = laundryDao.insertExtraFee(extraFee);
		if(result != 1 ) {
			throw new SQLException("추가 가격 등록에 실패하였습니다");
		}

	}

	public void updateExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, NotLoginException {
		int result = laundryDao.updateExtraFee(extraFee);
		if(result != 1 ) {
			throw new SQLException("추가 가격 수정에 실패하였습니다");
		}

	}

	public void deleteExtraFee(ExtraFee extraFee) throws SQLException, NotExistException, InvalidUserException {
		int result = laundryDao.deleteExtraFee(extraFee);
		if(result != 1 ) {
			throw new SQLException("추가 가격 삭제에 실패하였습니다");
		}
	}

	public List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException, NotLoginException {
		return laundryDao.selectByNameLaundry(LaundryName);
	}

	public List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException, NotLoginException {
		return laundryDao.selectByAddressLaundry(LaundryAddress);
	}

	public Laundry selectByLowestByLaundry(Long clothesId, Long FabricId)
			throws SQLException, NotExistException, NotLoginException {
		return laundryDao.selectByLowestByLaundry(clothesId, FabricId);
	}

	@Override
	public int clothesfabricFee(Long laundryId, Long clothesId, Long fabricId)
			throws SQLException, NotExistException, NotLoginException {
		return laundryDao.clothesfabricFee(laundryId, clothesId, fabricId);
	}

	@Override
	public Laundry selectByUserId(String userId) throws SQLException, NotExistException, NotLoginException {
		return laundryDao.selectByUserId(userId);
	}

	@Override
	public int userBetweenLaun(Users users, Laundry laundry)
			throws SQLException, NotLoginException, NotExistException {
		
		return laundryDao.userBetweenLaun(users, laundry);
	}

	@Override
	public List<Laundry> selectByMyLaundry(String userAddress) throws SQLException, NotExistException, NotLoginException {
		
		return laundryDao.selectByMyLaundry(userAddress);
	}

}
