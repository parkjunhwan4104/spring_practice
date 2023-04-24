package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InforDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*")  //ex로 시작하는 모든 경로는 이 컨트롤러로 들어오도록 함
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic",method= {RequestMethod.GET,RequestMethod.POST}) //GET과 POST 둘다 들어오게 하려면 이런방식으로 작성
	public void basic(HttpServletRequest req) {  //사용자가 요청을 했을 때 request 객체를 req로 전달받게 함
		log.info("basic. "+req.getMethod());  //request로 받은 메소드의 형태가 무엇인지 알 수 있음
	}
	
	@RequestMapping  //부모경로에서 디폴트로 실행하기 위해 /ex/만 브라우저에서 url로 치면 basci2가 실행됨
	public void basic2() {
		log.info("basic2");
		
	}
	
	@GetMapping("/basicOnlyGet") //get을 사용
	public void basic3() {
		
		log.info("basic3");
	}
	
	/*
	@GetMapping("/ex01")
	외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑함
	public void ex01(String name, int age) { // ex01이라는 요청을 할 때에 이 2개의 파라미터가 자동으로 각 각 name,age로 들어가서 전달됨, request.getParameter를 사용하지 않게됨
		log.info("ex01..."+ name+ ", "+age);
	}
	*/
	
	@GetMapping("/ex01")
	public void ex01(InforDTO infoDTO) {//각각의 파라미터로 적기보다는 객체로 받아 해당 정보를 얻도록 함 
		log.info("ex01..."+ infoDTO.getName()+ ", "+infoDTO.getAge());
	}

	@GetMapping("/ex02")
	//외부에서 전달된 파라미터의 이름과 매개변수가 다를경우 @RequestParam을 사용하여 어디로 전달받을 지 알려준다.
	public void ex02(@RequestParam("data1") String name,@RequestParam("data2") int age) {//파라미터 이름이 data1으로 들어왔다면 name에 담게 됨, 따라서 파라미터 명과 데이터 명이 다르면 이런식으로 처리
		log.info("ex02..."+ name+ ", "+age);
	
	//return 값이 없고 void로 하면 디폴트로 요청한 경로가 됨 즉 ex/ex02.jsp를 찾게 됨
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {// 쿼리스트링으로 ex03?data=1&data=20을 입력하면 datas의 원소로 1과 20이 들어옴
		log.info("datas: "+datas);
		
		return "ex03";
	}
	
	
}
