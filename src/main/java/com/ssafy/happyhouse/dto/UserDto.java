package com.ssafy.happyhouse.dto;

import java.util.List;

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
	private String user_admin;
	
	private List<PreferenceDto> checkedPrefers;
	
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

	
	public List<PreferenceDto> getCheckedPrefers() {
		return checkedPrefers;
	}
	public void setCheckedPrefers(List<PreferenceDto> checkedPrefers) {
		this.checkedPrefers = checkedPrefers;
	}
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_pass=" + user_pass +
				", user_admin= " + user_admin +
				", checkedPrefers=" + checkedPrefers + "]";
	}
	public UserDto(String user_id, String user_pass, String user_nickname, List<PreferenceDto> checkedPrefers) {
		super();
		this.user_id = user_id;
		this.user_pass = user_pass;

		this.checkedPrefers = checkedPrefers;
	}
	
	public String getUser_admin() {
		return user_admin;
	}
	public void setUser_admin(String user_admin) {
		this.user_admin = user_admin;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
