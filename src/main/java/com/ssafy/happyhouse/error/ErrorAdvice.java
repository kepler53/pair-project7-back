package com.ssafy.happyhouse.error;

import java.sql.SQLSyntaxErrorException;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;

@ControllerAdvice
public class ErrorAdvice {

	@ExceptionHandler(ExpiredJwtException.class)
	public ResponseEntity<String> expriedJwt(){
		System.out.println("여기서 안잡아???");
		return new ResponseEntity<String>("token만료",HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgument(){
		System.out.println("token 없어");
		return new ResponseEntity<String>("token이 없어",HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> badcredential(){
		System.out.println("여기서 안잡아??? BadCredentialsException");
		return new ResponseEntity<String>("비밀 번호 불일치",HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<String> parseException(){
		System.out.println("parse exception 일어났어");
		return new ResponseEntity<String>("파싱 문제",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SQLSyntaxErrorException.class)
	public ResponseEntity<String> nullException(){
		System.out.println("널 값을 넣었어");
		return new ResponseEntity<String>("선호하는 것을 하나 이상 택해주세요",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
