package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.HouseRentDto;

public interface PreProcessMapper {
	
	public List<HouseRentDto> getHouseRent();
	
	public int updateHouseRent(@Param("lat")String lat, @Param("lng")String lng,@Param("address")String address);
}
