package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InforDTO;
import com.example.ex02.domain.vo.StudentVO;

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
	
	@GetMapping("/ex04")
	// 만약 매개변수가 객체라면 해당 클래스 타입의 앞글자만 소문자로 변경된 값이 
	// 화면에서 사용할 key값임
	// ex) 매개변수의 타입이 InforDTO라면, 화면에서 사용시 key값은 inforDTO가 된다.
	// 만약 KEY값을 수정하거나 매개변수가 많아진다면,
	// 직접 requestScope에 담아서 전달해야한다.
	// 이 떄 request 객체를 직접 불러오지 않고 , Model이라는 데이터 전달자를 사용하게 된다.
	// 하지만 화면쪽에 전달할 데이터가 여러개가 아니라면 @ModleAttribute()를 사용하여 화면에 전달해준다.
	// @ModleAttribute("화면에서 사용할 key")
	public String ex04(@ModelAttribute("dto") InforDTO infoDTO) { //ModelAttribute 어노테이션을 이용하면 inforDTO를 dto로 바꿔서 ex04.jsp에서 dto를 사용할 수 있음
		log.info("-------------------------");
		log.info("ex04");
		log.info(infoDTO.toString()); // @Data 어노테이션이 toString()을 재정의함
		log.info("-------------------------");
		
		return "ex04";	
	}	
	
	@GetMapping("/ex05")
	public String ex05(InforDTO infoDTO, @ModelAttribute("gender") String gender) { //inforDTO는 디폴트라서 자동으로 보내짐
		log.info(infoDTO.toString());
		log.info("gender: "+gender);
		
		return "ex05";
	}
	
	
	@GetMapping("/ex06")
	//Model 객체는 파리미터로 request 객체를 받는다.
	//따라서 여러개의 데이터를 화면에 전달할 때 addAttribute(key,value)를 이용해 사용함.
	// 화면에서는 model에 설정한 key로 value를 사용할 수 있다.
	public String ex06(InforDTO infoDTO, String gender,Model model) { //Model은 request를 받기 위한 것.
		log.info(infoDTO.toString());
		log.info("gender: "+gender);
		
		model.addAttribute("gender",gender);
		model.addAttribute("dto",infoDTO);
		return "ex06";
	}
	
	@GetMapping("/ex07")
	// 외부에서 학생의 반호, 국어, 영어, 수학 점수를 모델 객체로 전달받는다.
	// 파라미터명과 매개변수에 선언된 모델객체의 필드명이 동일하면 자동으로 매핑된다
	public String ex07(StudentVO studentVO) { 
		
		log.info(studentVO.toString());
		
		return "ex/ex07";
	}
	
}
