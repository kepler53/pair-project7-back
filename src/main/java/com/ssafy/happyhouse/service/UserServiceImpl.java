package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import lombok.RequiredArgsConstructor;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.mapper.UserMapper;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService , UserService {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println(username);
//		if ("user_id".equals(username)) {
//			return new User("user_id", "$2a$10$jCvWm3NXDRFs/EfuI4h4.u0ZxNocv.ZkgEy6qbjVXrfQ5.KzLfhAe",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		UserDto userdto = template.getMapper(UserMapper.class).selectUser(username);
//		System.out.println(userdto);
		if(userdto!=null) {
			return new User(userdto.getUser_id(),userdto.getUser_pass(),new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username : " + username);
		}
		
	}

	@Override
	public String duplicateCheck(String id) {
		System.out.println(id);
		int result = template.getMapper(UserMapper.class).duplicateCheck(id);
		if(result >0) {
			return "cannot use";
		}else {
			return "can use";
		}
		
	}
}