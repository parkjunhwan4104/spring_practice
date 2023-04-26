package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class WorkController {
	

	@GetMapping("/checkIn")
	public String checkIn() {
		
		return "work/checkIn";
	}
	
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c=Calendar.getInstance(); //현재 시간
		
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		
		boolean lateCondition=hour>=9 && minute>0; // 지각 조건
		
		if(lateCondition) {
			return "work/late";
		}
		
		return "work/getToWork";
	}
	
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		Calendar c=Calendar.getInstance(); //현재 시간
		
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		
		boolean leaveCondition=hour>=18 && minute>=0; //퇴근 가능 조건

		if(leaveCondition) {
			return "work/leaveWork";
		}
		
		return "work/needToWork";
	}
}

