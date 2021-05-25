package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.PreferenceDto;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.mapper.StoreMapper;
import com.ssafy.happyhouse.mapper.UserMapper;

@Service
public class ConvenienceServiceImpl implements ConvenienceService {

	@Autowired
	private SqlSessionTemplate template;
	
	
	float[] weights = new float[]{0,0.35f,0.25f,0.15f,0,10f,0,05f,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	
	@Override
	public HouseInfoDto getConvenienceScore(String id, String lat, String lng,String dong) {
		
		float score = 0.0f;

		UserDto userDto = template.getMapper(UserMapper.class).getUserInfo(id);
		
		List<PreferenceDto> pList = userDto.getCheckedPrefers();
		
		int categoryCnt = template.getMapper(StoreMapper.class).getCategory(id);
		
//		System.out.println(categoryCnt);
		
		float categoryPercent = 100/categoryCnt;
		
//		System.out.println(pList.size());
		
//		for (PreferenceDto preferenceDto : pList) {
//			System.out.println(preferenceDto);
//		}
		
		int countList = template.getMapper(StoreMapper.class).getStoreCount(userDto, lng, lat,dong); //전체 갯수
		
		Map<String, Integer> sebu = new HashMap<String, Integer>();
		//카페 갯수
		for (int i = 0; i < pList.size(); i++) {
			if(pList.get(i).getCategory().equals("커피전문점")) {
				String str = pList.get(i).getName();
				
				int weight = template.getMapper(StoreMapper.class).getWeight(id, pList.get(i).getName());
				
				int result = template.getMapper(StoreMapper.class).getEachCount(str,lng,lat,dong);
				if(result>0) {
					score += categoryPercent*weights[weight];
					System.out.println(score);
					
				}
				sebu.put(pList.get(i).getName(), result);
			}
			else if(pList.get(i).getCategory().equals("편의점")) {
				String str = pList.get(i).getName();
				int weight = template.getMapper(StoreMapper.class).getWeight(id, pList.get(i).getName());
				
				int result = template.getMapper(StoreMapper.class).getEachCount(str,lng,lat,dong);
				if(result>0) {
					score += categoryPercent*weights[weight];
					System.out.println(score);
				}
				
				sebu.put(pList.get(i).getName(), result);
			}
		}
		
		for(String key : sebu.keySet()){
            int value = sebu.get(key);
            System.out.println(key+" : "+value);
 
        }
		System.out.println(score);
//		System.out.println(countList);
		
		String scoreVal = String.valueOf(score);
		
		HouseInfoDto houseInfo = new HouseInfoDto(scoreVal,sebu);
		
		
		
		return houseInfo;
	}

}
