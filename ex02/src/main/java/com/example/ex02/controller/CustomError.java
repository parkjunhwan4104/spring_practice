package com.example.ex02.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //web.xml에 에러코드에 대한 경로를 잡아줬으므로 advice를 안 씀
public class CustomError {

	//어떤 경로의 에러든지 예외처리하기 위해
	
	@GetMapping("/error")
	public String goErrorPage(HttpServletRequest  request) {
		Object status=request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);// 발생한 에러코드가 무엇인지
		if(status!=null) {
			int statusCode=Integer.valueOf(status.toString());
			if(statusCode==HttpStatus.NOT_FOUND.value()) { //서버 request가 담고있는 에러코드와 NOT_FOUND에러의 값이 같을때 (404에러)
				return "error/404";
			}
			
		}
		return "error/500";
	}
}
