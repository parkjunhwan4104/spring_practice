package com.real.makeBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {

	
	
	@GetMapping("/add")
	public void showAdd() {}
	
	@GetMapping("/list")
	public void showList() {
		
		
	}

	
	
}
