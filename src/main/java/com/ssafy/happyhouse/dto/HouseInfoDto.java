package com.ssafy.happyhouse.dto;

import java.util.Map;

public class HouseInfoDto {
	
	private String score;
	private Map<String, Integer> list;
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Map<String, Integer> getList() {
		return list;
	}
	public void setList(Map<String, Integer> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "HouseInfoDto [score=" + score + ", list=" + list + "]";
	}
	public HouseInfoDto(String score, Map<String, Integer> list) {
		super();
		this.score = score;
		this.list = list;
	}
	public HouseInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
