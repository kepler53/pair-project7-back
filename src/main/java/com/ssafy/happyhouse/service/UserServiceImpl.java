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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.mapper.UserMapper;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService , UserService {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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

//	@Override
//	public String enroll(UserDto userDto, String[] arr) {
//		int result1 = template.getMapper(UserMapper.class).addUser(userDto);
////		int result2 = template.getMapper(UserMapper.class).addPreference(userDto.getUser_id(), arr);
//		System.out.println("result1은 "+result1);
////		System.out.println("result2은 "+result2);
//		if(result1 >0) {
//			return "됐어";
//		}else {
//			return "안됐어";
//		}
//		
//	}
	//transcation을 사용해야하는 부분 : 회원을 등록하고 회원의 관심사를 추가적으로 등록해야한다.
	@Override
	public String enroll(UserDto userDto) {
		
		userDto.setUser_pass(passwordEncoder.encode(userDto.getUser_pass()));
//		System.out.println("패스워드는"+userDto.getUser_pass());
		int result1 = template.getMapper(UserMapper.class).addUser(userDto);
		int result2 = template.getMapper(UserMapper.class).addPreference(userDto);
		System.out.println("result2는" + result2);
		if(result1 >0) {
			return "됐어";
		}else {
			return "안됐어";
		}
	}

	@Override
	public String update(UserDto userDto) {
		int result = template.getMapper(UserMapper.class).deletePreference(userDto.getUser_id());
		
		
		userDto.setUser_pass(passwordEncoder.encode(userDto.getUser_pass()));
		int result2 = template.getMapper(UserMapper.class).updateUser(userDto);
		int result3 = template.getMapper(UserMapper.class).addPreference(userDto);
		
//		System.out.println("result는"+result);
//		System.out.println("result2는"+result2);
//		System.out.println("result3는"+result3);
		if(result>0 &&result2>0&& result3>0) {
			return "됐어";
		}else {
			return "안됐어";
		}
	}

	
	
	
	
	
	
	
	
}