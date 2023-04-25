package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.UserVO;

@Controller
public class TaskController {
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "task/task01/login";
	}
	
	@PostMapping("/login")
	//외부에서 전달받은 아이디와 패스워드를 매개변수로 받는다
	public String login(UserVO userVO, Model model) {
		
		model.addAttribute("id",userVO.getId());
		
		if(userVO.getId().equals("admin")) {
			// 아이디가 admin일 경우 admin.jsp로 이동
			return "task/task01/admin";
		}
		else {
			// 아이디가 admin이 아닐경우 user.jsp로 이동
			return "task/task01/user";
		}
		
	}

}
