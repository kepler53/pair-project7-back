package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.happyhouse.dto.JwtResponse;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.UserServiceImpl;
import com.ssafy.happyhouse.util.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/jwt")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userDetailsService;
	
	
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto userDto) throws Exception {

		
		authenticate(userDto.getUser_id(), userDto.getUser_pass());
		
//		System.out.println("여기 오니");
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(userDto.getUser_id());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		System.out.println(token);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			System.out.println("disabledException");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("BadCredentialsException");
			throw new Exception("INVALID_CREDENTIALS", e);
		} catch(Exception e) {
			System.out.println("여기 오니");
		}
	}
	//이부분에서 exception custom으로 처리해야하나?????

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
