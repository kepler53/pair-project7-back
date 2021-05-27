package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;
import com.ssafy.happyhouse.dto.ConvenienceDto;

public interface HouseMapper {
	
	public List<HouseDealDto> getHouseList(String dong);
	public int addHouseDeal(HouseDealDto houseDelDealDto);
	
	public List<HouseRentDto> getHouseRentList(String dong);
	
	public int addHouseRent(HouseRentDto houserentDto);
	
	public int getCoffee(@Param("lat")String lat, @Param("lng")String lng,@Param("name")String name);

	public int getConv(@Param("lat")String lat, @Param("lng")String lng);

	public int getSchool(@Param("lat")String lat, @Param("lng")String lng);

	public int getStation(@Param("lat")String lat, @Param("lng")String lng);

	public int getPolice(@Param("lat")String lat, @Param("lng")String lng);

	public int updateJisu(@Param("no")int no,@Param("jisu")int jisu);
	
	public int insertConv(ConvenienceDto convDto);
	
	
	
	
}
