package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.UserDto;

public interface StoreMapper {
	
	public int getCategory(@Param("name")String id);
	
	public int getStoreCount(UserDto userDto,@Param("lat") String lat,@Param("lng") String lng,@Param("dong") String dong);

	public int getEachCount(@Param("name")String str,@Param("lat") String lng,@Param("lng")String lat,@Param("dong") String dong);
	
	public int getWeight(@Param("id")String id,@Param("name") String storeName);
}
