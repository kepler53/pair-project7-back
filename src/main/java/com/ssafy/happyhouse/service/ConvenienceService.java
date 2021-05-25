package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.HouseInfoDto;

public interface ConvenienceService {

	public HouseInfoDto getConvenienceScore(String id, String lat, String lng, String dong);

}
