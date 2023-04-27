package com.example.ex02.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //원하는 시점에 들어가서 로직에대한 주도권을 가져올 수 있도록함 (500에러나 404에러 예외처리할때)
@Log4j
public class CommonExceptionAdvice {
	
	/*
	
	@ExceptionHandler(Exception.class) //어떤 예외가 발생했을 때 무엇을 실행시킬건지 설정하도록 함
	public String except(Exception e,Model model) {
		log.error("Exception..." +e.getMessage());
		model.addAttribute("exception", e);
		
		log.error(model.toString());
		
		return "error/500"; //500 에러 예외처리
	}
	
	@ExceptionHandler(NoHandlerFoundException.class) //NoHandlerFoundException을 캐치해 404 예외처리를 할 수 있도록
	@ResponseStatus(HttpStatus.NOT_FOUND)  //현재 서버의 상태를 전달해줌
	public String except404(NoHandlerFoundException e) {
		return "error/404";
	}
	
	*/
}
