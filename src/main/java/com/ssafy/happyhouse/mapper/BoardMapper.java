package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardMapper {
	
	public int addBoard(BoardDto boardDto);
	
	public List<BoardDto> getBoardList();

	public int updateCnt(@Param("no") int no);
	
	public BoardDto getBoard(@Param("no") int no);

	public int updateBoard(BoardDto boardDto);

	public int deleteBoard(@Param("no")String no);

}
