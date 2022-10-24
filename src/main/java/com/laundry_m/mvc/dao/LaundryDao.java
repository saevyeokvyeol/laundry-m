package com.laundry_m.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.laundry_m.mvc.exception.NotExistException;
import com.laundry_m.mvc.exception.NotLoginException;
import com.laundry_m.mvc.vo.Clothes;
import com.laundry_m.mvc.vo.ExtraFee;
import com.laundry_m.mvc.vo.Fabric;
import com.laundry_m.mvc.vo.Fee;
import com.laundry_m.mvc.vo.Laundry;
import com.laundry_m.mvc.vo.Users;

public interface LaundryDao {
	/** 
	 * 	세탁소 등록: 세탁소 인서트
	 * 	@param : Laundry laundry(세탁소 점포아이디, 아이디, 점포 이름, 점포 번호, 수거비용)
	 * 	@return : int(등록한 레코드 수)
	 *  */
	int insertLaundry(Laundry laundry) throws SQLException;

	/** 
	 *  세탁소 갱신
	 *  @param : Laundry laundry(세탁소 이름, 전화번호, 세탁소 주소)
	 *  @return : int(등록한 레코드 수)
	 *  */
	int updateLaundry(Laundry laundry) throws SQLException;

	/** 
	 *  가격 등록
	 *  @param : Fee fee(가격 번호, 세탁소아이디, 옷 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	int insertFee(Fee fee) throws SQLException;

	/** 가격 갱신
	 *  @param : Fee fee(세탁소 아이디, 옷 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	int updateFee(Fee fee) throws SQLException;

	/** 
	 *  옷 인서트
	 *  @param : Clothes clothes(옷 아이디, 옷 이름)
	 *  @return : int(등록한 레코드 수)
	 *  */
	int insertClothes(Clothes clothes) throws SQLException;

	/** 
	 * 	천 인서트
	 *   @param : Fabric fabric(천 아이디, 천이름, 세탁방법)
	 *   @return : int(등록한 레코드 수)
	 * */
	int insertFabric(Fabric fabric) throws SQLException;

	/** 
	 *  추가가격 인서트
	 *  @param : ExtraFee extraFee(추가가격 아이디, 천아이디, 점포 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 *  */
	int insertExtraFee(ExtraFee extraFee) throws SQLException;

	/** 
	 *  추가가격 수정: extra_fee 테이블 레코드 update
	 *  @param : ExtraFee extraFee(천아이디, 점포 아이디, 가격)
	 *  @return : int(등록한 레코드 수)
	 * */
	int updateExtraFee(ExtraFee extraFee) throws SQLException;

	/** 
	 * 	추가가격 삭제
	 *  @param : Long extraFeeId
	 *  */
	int deleteExtraFee(ExtraFee extraFee) throws SQLException;

	/**
	 *  세탁소 이름으로 찾기
	 *  @param : String LaundryName
	 *  @return : List<Laundry>
	 * */
	List<Laundry> selectByNameLaundry(String LaundryName) throws SQLException;
	
	/**
	 *  세탁소 주소로 찾기
	 *  @param : String LaundryAddress
	 *  @return : List<Laundry>
	 * */
	List<Laundry> selectByAddressLaundry(String LaundryAddress) throws SQLException;
	
	/**
	 *  옷 가격 최저가 세탁소 검색
	 *  1. 옷 가격 검색 시 가격
	 *  2. 천 가격 검색 시 가격
	 *  3. 두 가격을 더한 값 order by 첫번째 값에 대한 점포아이디
	 *  @param : Long feeId, Long extraFeeId
	 *  @return : Laundry
	 * */
	Laundry selectByLowestByLaundry(Long clothesId, Long FabricId) throws SQLException;
	
	/**
	 * 특정 세탁소에서 옷 + 재질 가격 더하는 메소드
	 * */
	int clothesfabricFee(Long laundryId,int clothesId, int fabricId) throws SQLException;
	
	/**
	 * 세탁소 아이디로 찾기
	 * */
	Laundry selectByUserId(String userId) throws SQLException;
	
	/**
	 * 회원 주소 - 세탁소 주소 사이 거리 구하기
	 * */
	int userBetweenLaun(Users users, Laundry laundry) throws SQLException;
	
	/**
	 * 사용자 위치에서 세탁소 찾기
	 * */
	List<Laundry> selectByMyLaundry(String userAddress) throws SQLException, NotExistException, NotLoginException;

	/**
	 * 천으로 세탁 방법 찾기
	 * */
	Fabric selectWashByFabric(int fabricId) throws SQLException, NotExistException, NotLoginException;

	
}