package com.laundry_m.mvc.laundry_m.service;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.domain.Clothes;
import com.laundry_m.mvc.domain.ExtraFee;
import com.laundry_m.mvc.domain.Fabric;
import com.laundry_m.mvc.domain.Fee;
import com.laundry_m.mvc.domain.Laundry;
import com.laundry_m.mvc.laundry_m.exception.DuplicationException;
import com.laundry_m.mvc.laundry_m.exception.NotExistException;
import com.laundry_m.mvc.laundry_m.exception.NotLoginException;

public interface laundryService {
	/**
	 *  세탁소 등록: laundry 테이블 레코드 insert
	 * @param : Laundry laundry(세탁소 점포아이디, 아이디, 점포 이름, 점포 번호, 수거비용)
	 * @return : Laundry laundry
	 * @exception : DuplicationException(세탁소 id가 이미 존재할 경우 오류)
	 * 				NotLoginException(로그인 하지 않고 세탁소 가입할 경우 오류)
	 * 				NotExistException(점주 로그인 id, 세탁소 id DB에 존재하지 않을 경우 오류)
	 */
	Laundry insertLaundry(Laundry laundry) throws SQLException, NotLoginException, DuplicationException, NotExistException;
	
	/**
	 *  세탁소 수정: laundry 테이블 레코드 update
	 *  @param : Laundry laundry(세탁소 이름, 전화번호, 세탁소 주소)
	 *  @return : Laundry laundry
	 *  @exception : NotloginException(로그인 하지 않고 세탁소 수정할 경우 오류)
	 *  			 NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 */
	Laundry updateLaundry(Laundry laundry) throws SQLException, NotLoginException, NotExistException;
	
	/**
	 *  가격 추가: fee 테이블 레코드 insert
	 *  @param : Fee fee(가격 번호, 세탁소아이디, 옷 아이디, 가격)
	 *  @return : Fee fee
	 */	
	Fee insertFee(Fee fee) throws SQLException;
	
	/**
	 *  가격 수정: fee 테이블 레코드 update
	 *  @param : Fee fee(세탁소 아이디, 옷 아이디, 가격)
	 *  @return : Fee fee
	 *  @exception : NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 */	
	Fee updateFee(Fee fee) throws SQLException, NotExistException;
	
	/**
	 *  옷 추가: clothes 테이블 레코드 insert
	 *  @param : Clothes clothes(옷 아이디, 옷 이름)
	 */	
	Clothes insertClothes(Clothes clothes) throws SQLException;
	
	/**
	 *  천 추가: fabric 테이블 레코드 insert
	 *  @param : Fabric fabric(천 아이디, 천이름, 세탁방법)
	 *  @exception : 
	 */
	Fabric insertFabric(Fabric fabric) throws SQLException;
	
	/**
	 *  추가가격 추가: extra_fee 테이블 레코드 insert
	 *  @param : ExtraFee extraFee(추가가격 아이디, 천아이디, 점포 아이디, 가격)
	 */
	ExtraFee insertExtraFee(ExtraFee extrafee) throws SQLException;
	
	/**
	 *  추가가격 수정: extra_fee 테이블 레코드 update
	 *  @param : ExtraFee extraFee(천아이디, 점포 아이디, 가격)
	 *  @exception : NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 */
	ExtraFee updateFee(ExtraFee extrafee) throws SQLException, NotExistException;
	
	/**
	 *  추가가격 삭제: extra_fee 테이블 레코드 delete
	 *  @exception : NotExistException(세탁소 DB에 존재하지 않을 경우 오류)
	 */
	ExtraFee deleteFee(ExtraFee extrafee) throws SQLException, NotExistException;

	/* 
	 *  세탁소 이름으로 찾기
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<Laundry>
	 *  @exception : NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 * */
	List<Laundry> selectByNameLaundry(String Laundry_name) throws SQLException, NotExistException;
	
	/* 
	 *  세탁소 주소로 찾기
	 *  @param : keyword(검색어), keyfield(컬럼명)
	 *  @return : List<Laundry>
	 *  @exception : NotExistException(아아디 DB에 존재하지 않을 경우 오류)
	 * */
	List<Laundry> selectByAddressLaundry(String Laundry_address) throws SQLException;
	
	
	
	
	
	
	
	
	
	
	

}