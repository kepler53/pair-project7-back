package com.ssafy.happyhouse.dto;

public class PreferenceDto {
	
//	String user_id;
	String convenience_name;
//	public String getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(String user_id) {
//		this.user_id = user_id;
//	}
	public String getConvenience_name() {
		return convenience_name;
	}
	public void setConvenience_name(String convenience_name) {
		this.convenience_name = convenience_name;
	}
	@Override
	public String toString() {
		return convenience_name;
	}
	public PreferenceDto(String convenience_name) {
		super();

		this.convenience_name = convenience_name;
	}
	public PreferenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
