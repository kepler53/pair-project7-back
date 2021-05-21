package com.ssafy.happyhouse.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.service.UserServiceImpl;

import io.jsonwebtoken.Claims;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userDetailsService;
	
	@RequestMapping(value = "/checkDuplicate/{user_id}",method = RequestMethod.GET)
	private String checkDuplicate(@PathVariable("user_id") String user_id) {
		System.out.println(user_id);
		String str = userDetailsService.duplicateCheck(user_id);
//		System.out.println(user_id);
//		String str = "너야";
		return str;
	}
	
//	@RequestMapping(value = "/insert",method = RequestMethod.POST)
//	private String insert() {
//		return "되는데";
//	}
	
	@GetMapping("/test")
	public String test(Principal principal) {
		
		System.out.println(principal.getName());
				
//		String name = claims.get("name", String.class);
//      System.out.println("name: " + name);
		String str = "aaa";
		return str;
	}
	
}
