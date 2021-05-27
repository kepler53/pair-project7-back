package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;

public interface HouseService {
	
	public String addHouseDeal(HouseDealDto houseDealDto); 
	
	public String getScore();

	public String addHouseRent(HouseRentDto houseRentDto);

}
