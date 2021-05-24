package com.ssafy.happyhouse.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.PreferenceDto;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.UserServiceImpl;

import io.jsonwebtoken.Claims;

@CrossOrigin(origins = "*", allowedHeaders = "X-AUTH-TOKEN",maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(value = "/checkDuplicate/{user_id}",method = RequestMethod.GET)
	private String checkDuplicate(@PathVariable("user_id") String user_id) {
//		System.out.println(user_id);
		String str = userService.duplicateCheck(user_id);
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
	
//	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
//	@PostMapping("/enroll")
//	public ResponseEntity<String> enroll(@RequestParam(value = "email",required = false) String email,
//			@RequestParam(value = "password",required = false) String pass, 
//			@RequestParam(value = "checkedPrefers",required = false)String[] arr) {
//		
//		System.out.println(email);
//		System.out.println(pass);
//		//왜 null이냐고 도대체
//		
//		UserDto userDto = new UserDto();
//		userDto.setUser_id(email);
//		userDto.setUser_pass(pass);
//		userDto.setUser_nickname("aa");
//		
//		System.out.println(userDto);
//		
//		String result = userService.enroll(userDto, arr);
//		
//		return new ResponseEntity<String>(result,HttpStatus.OK);
//	}
	
	
	
	@GetMapping("")
	public ResponseEntity<UserDto> getUserInfo(Principal principal){
		
		String user_id = principal.getName();
		
		UserDto userDto = userService.getUserInfo(user_id);
//		System.out.println(userDto);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/enroll")
//	public ResponseEntity<String> enroll(@RequestBody UserDto userDto,@RequestParam(name = "checkedPrefers",required = false) String[] arr){	
	public ResponseEntity<String> enroll(@RequestBody String str) throws ParseException{	
//		System.out.println(userDto);
//		for (String string : arr) {
//			System.out.println(string);
//		}
		
		List<PreferenceDto> pList = new ArrayList<PreferenceDto>();
		
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        System.out.println(jsonObject.get("user_id"));
        System.out.println(jsonObject.get("user_pass"));
        System.out.println(jsonObject.get("checkedPrefers"));
		JSONObject checkedPrefers = (JSONObject) jsonObject.get("checkedPrefers");
		
		JSONArray cafe = (JSONArray) checkedPrefers.get("cafe");
		for (int i = 0; i < cafe.size(); i++) {
			JSONObject cafeObject = (JSONObject) cafe.get(i);
			System.out.println(cafeObject.get("name"));
			pList.add(new PreferenceDto("커피전문점",(String)cafeObject.get("name")));
		}
		
		JSONArray conveninence = (JSONArray) checkedPrefers.get("convenience");
		for (int i = 0; i < conveninence.size(); i++) {
			JSONObject convObject = (JSONObject) conveninence.get(i);
			pList.add(new PreferenceDto("편의점",(String)convObject.get("name")));
		}
		
		UserDto userDto = new UserDto();
		
		userDto.setUser_id((String)jsonObject.get("user_id"));
		userDto.setUser_pass((String)jsonObject.get("user_pass"));
		userDto.setCheckedPrefers(pList);
		
		System.out.println(userDto);
		
		
		String result = userService.enroll(userDto);
		return new ResponseEntity<String>("ss",HttpStatus.OK);
	}
	
	@PutMapping()
	public ResponseEntity<String> update(Principal principal,@RequestBody UserDto userDto){
		
		String user_id = principal.getName();
		userDto.setUser_id(user_id);
//		System.out.println("update="+userDto);
		String result = userService.update(userDto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<String> delete(Principal principal){
		String user_id = principal.getName();
		
		String result = userService.delete(user_id);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
