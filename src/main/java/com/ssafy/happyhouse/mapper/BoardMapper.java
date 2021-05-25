package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardMapper {
	
	public int addBoard(BoardDto boardDto);
	
	public List<BoardDto> getBoardList();

}
