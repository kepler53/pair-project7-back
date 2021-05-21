package com.ssafy.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor //need default constructor for JSON Parsing
@AllArgsConstructor
public class UserDto {

	
	private String user_id;
	private String user_pass;
	private String user_nickname;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_pass=" + user_pass + ", user_nickname=" + user_nickname + "]";
	}
	public UserDto(String user_id, String user_pass, String user_nickname) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;
		this.user_nickname = user_nickname;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
