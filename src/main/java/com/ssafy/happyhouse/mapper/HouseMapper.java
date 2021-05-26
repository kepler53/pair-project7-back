package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;

public interface HouseMapper {
	
	public List<HouseDealDto> getHouseList(String dong);
	public int addHouseDeal(HouseDealDto houseDelDealDto);
	
	public List<HouseRentDto> getHouseRentList(String dong);
}
