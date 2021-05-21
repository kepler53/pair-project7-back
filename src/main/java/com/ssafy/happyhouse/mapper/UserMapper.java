package com.ssafy.happyhouse.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;


import com.ssafy.happyhouse.dto.UserDto;

public interface UserMapper {

	public UserDto selectUser(@Param("user_id") String user_id);
	public int count();
	
	public int duplicateCheck(String user_id);
	
	public int addUser(UserDto userDto);
	public int updateUser(UserDto userDto);

	public int addPreference(UserDto userDto);
	public int deletePreference(String user_id);
	public UserDto getUserInfo(String id);
	
	
}
