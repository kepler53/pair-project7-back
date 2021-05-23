package com.ssafy.happyhouse.error;

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
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> badcredential(){
		System.out.println("여기서 안잡아??? BadCredentialsException");
		return new ResponseEntity<String>("비밀 번호 불일치",HttpStatus.UNAUTHORIZED);
	}
}
