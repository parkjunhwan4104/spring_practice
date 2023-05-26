package com.example.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

//REST Controller의 경우  @Controller가 붙으면 viewResolver가 리턴에 관여를 하기에 컨트롤러를 쓰지 않음
@RestController  //페이지 이동이 없게
@RequiredArgsConstructor
@RequestMapping("/replies/*")
@Log4j
public class ReplyController {
	
	private final ReplyService replyService;
	
	
	//댓글 등록
	
	//consumes: 외부에서 전달받을 파라미터의 타입, produces: 해당 메소드에서 계산된 결과를 리턴할때의 타입을 써줌
	//@RequestBody: js에서 key,value로 이루어진 데이터를 consumes에 맞는 타입인 json으로 바꿔서 받기위해 필요함, json형식으로 전달된 데이터를 @RequestBody 뒤에 붙은 필드에 맞게 매핑해줌
	//이때 json데이터의 key값과 뒤에 붙은 필드의 이름인 ReplyVO이 같아야 매핑이 됨(이때 필드는 클래스 타입일때만 사용가능)
	@PostMapping(value="/new",consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {  //이 메소드의 리턴타입의 제네릭인 String은 MediaType.TEXT_PLAIN_VALUE의 타입과 같음
	// ResponseEntity을 쓰는 이유는 서버의 상태까지 알려주기 위함(성공했나 실패했나)	
		
		log.info("create.....:"+replyVO);
		return replyService.register(replyVO)? new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
}
