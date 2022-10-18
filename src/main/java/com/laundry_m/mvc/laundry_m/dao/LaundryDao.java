package com.laundry_m.mvc.laundry_m.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Clothes;
import com.laundry_m.mvc.domain.ExtraFee;
import com.laundry_m.mvc.domain.Fabric;
import com.laundry_m.mvc.domain.Fee;
import com.laundry_m.mvc.domain.Laundry;

public interface LaundryDao {
	/* 세탁소 가입 */
	int insertLaundry(Laundry laundry) throws SQLException;

	/* 세탁소 수정 */
	int updateLaundry(Laundry laundry) throws SQLException;

	/* 가격 입력 */
	int insertFee(Fee fee) throws SQLException;

	/* 가격 수정 */
	int updateFee(Fee fee) throws SQLException;

	/* 옷 추가 */
	int insertClothes(Clothes clothes) throws SQLException;

	/* 천 추가 */
	int insertFabric(Fabric fabric) throws SQLException;

	/* 추가가격 추가 */
	int insertExtraFee(ExtraFee extrafee) throws SQLException;

	/* 추가가격 수정 */
	int updateFee(ExtraFee extrafee) throws SQLException;

	/* 추가가격 삭제 */
	int deleteFee(ExtraFee extrafee) throws SQLException;

	/* 세탁소 이름 찾기 */
	List<Laundry> selectByNameLaundry(String Laundry_name) throws SQLException;

	/* 세탁소 주소 찾기 */
	List<Laundry> selectByAddressLaundry(String Laundry_address) throws SQLException;

}