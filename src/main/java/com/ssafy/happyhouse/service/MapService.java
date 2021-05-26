package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;

public interface MapService {
	
	public List<HouseDealDto> getHouseList(String dong);
	
	public List<HouseRentDto> getHouseRentList(String dong);

}
