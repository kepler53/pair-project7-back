package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDealDto;

public interface MapService {
	
	public List<HouseDealDto> getHouseList(String dong);

}
