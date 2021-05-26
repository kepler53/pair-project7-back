package com.ssafy.happyhouse.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.dto.HouseRentDto;
import com.ssafy.happyhouse.mapper.HouseMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public List<HouseDealDto> getHouseList(String dong) {
		// TODO Auto-generated method stub
		return template.getMapper(HouseMapper.class).getHouseList(dong);
	}

	@Override
	public List<HouseRentDto> getHouseRentList(String dong) {
		
		List<HouseRentDto> rentList = template.getMapper(HouseMapper.class).getHouseRentList(dong);
		
		return rentList;
	}
}
