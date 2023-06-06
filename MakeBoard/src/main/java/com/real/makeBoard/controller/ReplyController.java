package com.real.makeBoard.controller;


import java.util.List;

import org.springframework.http.HttpStatus; 
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.real.makeBoard.Service.ReplyService;
import com.real.makeBoard.vo.ReplyVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
@Log4j
public class ReplyController {

	
	private final ReplyService replyService;
	
	@PostMapping(value="/add", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> doAdd(@RequestBody ReplyVO replyVO) {
		
		
		return replyService.insert(replyVO)?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(value="/{bno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno")Long bno){
		log.info("getList......:"+bno);
		List<ReplyVO> ReplyList=replyService.getListByBNO(bno);
		
		return new ResponseEntity<>(ReplyList,HttpStatus.OK);
		
	}
	
	
}
