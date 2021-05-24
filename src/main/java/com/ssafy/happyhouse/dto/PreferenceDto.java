package com.ssafy.happyhouse.dto;

public class PreferenceDto {
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "PreferenceDto [category=" + category + ", name=" + name + "]";
	}
	private String category;
	private String name;
	public PreferenceDto(String category, String name) {
		super();
		this.category = category;
		this.name = name;
	}
	public PreferenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
