package com.ssafy.happyhouse.service;

import org.apache.ibatis.session.SqlSessionException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public String addHouseDeal(HouseDealDto houseDealDto) {
		int result = template.getMapper(HouseMapper.class).addHouseDeal(houseDealDto);
		if(result >0) {
			return "됐어";
		}
		else {
			throw new SqlSessionException();
		}
	}

}
