package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	
	
	public String duplicateCheck(String id);
//	public String enroll(UserDto userdto,String[] arr);
	public String enroll(UserDto userDto);
	public String update(UserDto userDto);
	public UserDto getUserInfo(String id);
}
