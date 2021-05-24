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
		return "PreferenceDto [category=" + category + ", name=" + name + ", weight=" + weight + "]";
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public PreferenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PreferenceDto(String category, String name, int weight) {
		super();
		this.category = category;
		this.name = name;
		this.weight = weight;
	}
	private String category;
	private String name;
	public int weight;

	
	
}
