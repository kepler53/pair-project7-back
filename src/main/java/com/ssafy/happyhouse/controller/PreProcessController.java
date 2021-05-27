package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.service.PreProcessService;

@CrossOrigin(origins = "*", allowedHeaders = "X-AUTH-TOKEN",maxAge = 3600)
@RestController
@RequestMapping("/preprocess")
public class PreProcessController {
	
	@Autowired
	private PreProcessService pservice;

	@GetMapping("")
	public ResponseEntity<String> preproces(){
		

		pservice.preproces();
		
		return new ResponseEntity<String>("",HttpStatus.OK);
	}
}
