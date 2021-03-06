package com.ssafy.happyhouse.controller;

import java.security.Principal;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "X-AUTH-TOKEN",maxAge = 3600)
@RequestMapping("/board")
public class BoardController {
	
	
	@Autowired
	private BoardService bservice;
	
	
	@PostMapping
	public ResponseEntity<String> addBoard(@RequestBody BoardDto boardDto, Principal principal) throws Exception{
		
		String name = principal.getName();
		
		boardDto.setUser_id(name);
		
		String result = bservice.addBoard(boardDto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<BoardDto>> getBoardList(){
		
		List<BoardDto> boardList = bservice.getBoardList();
//		System.out.println("여기왔니");
		return new ResponseEntity<List<BoardDto>>(boardList,HttpStatus.OK);
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<BoardDto> getBoardOne(@PathVariable("no")int no) throws SQLSyntaxErrorException{
		
		
		BoardDto boardDto = bservice.getBoard(no);
		
		return new ResponseEntity<BoardDto>(boardDto,HttpStatus.OK);
	}
	
	
	
	@PutMapping()
	public ResponseEntity<String> updateBoardOne(@RequestBody BoardDto boardDto, Principal principal) throws Exception{
		
		System.out.println(boardDto);
		
		String name = principal.getName();
		
		boardDto.setUser_id(name);
		
		String result = bservice.updateBoard(boardDto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<String> deleteBoardOne(@PathVariable("no") String no) throws Exception{
		
		String result = bservice.deleteBoard(no);
		
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	
}
