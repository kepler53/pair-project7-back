package com.ssafy.happyhouse.dto;

public class BoardDto {
	

	private String board_title;
	private String board_regdate;
	private String board_content;
	private String user_id;
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "BoardDto [board_title=" + board_title + ", board_regdate=" + board_regdate + ", board_content="
				+ board_content + ", user_id=" + user_id + "]";
	}
	public BoardDto(String board_title, String board_regdate, String board_content, String user_id) {
		super();
		this.board_title = board_title;
		this.board_regdate = board_regdate;
		this.board_content = board_content;
		this.user_id = user_id;
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
}
