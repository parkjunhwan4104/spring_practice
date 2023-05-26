package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	
	//게시글 댓글 전체 조회
	
	//json타입으로 전송하기 위해서 MediaType.APPLICATION_JSON_UTF8_VALUE을 추가하고 url에서 조회할떄는 /replies/{bno}.json으로 조회하면 됨
	@GetMapping(value="/{bno}",produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})  //replyService.findAllByBNO(bno)이 값을 xml방식으로 전송하겠다는 거
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno) {  //데이터가 HEADER에 담겨서 오면 @RequestBody를 사용하고 URL에 담겨서 오면 @PathVariable 사용
		log.info("getList......:"+bno);
		return new ResponseEntity<>(replyService.findAllByBNO(bno),HttpStatus.OK);  
	}
	
	
	// 댓글 1개 조회
	@GetMapping(value="/{bno}/{rno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE}) //게시글 댓글 전체 조회처럼 2개의 리턴타입 작성이 아닌 이렇게 1개로 하면 url뒤에 json을 붙이지 않아도 json으로 리턴됨
	public ReplyVO getReply(@PathVariable("rno") Long rno,@PathVariable("bno")Long bno) {
		log.info("getReply......:"+rno);
		return replyService.findByRNO(rno);  //일반 문자열을 전달하거나 어떤 데이터만 전달할때는 굳이 ResponseEntity으로 작성하지 않아도 되지만 header에 뭔가를 담아야할때는 ResponseEntity을 사용해야함
	}
	
	//댓글 삭제
	@DeleteMapping(value="/{bno}/{rno}",produces= {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable Long rno,@PathVariable("bno")Long bno) {
		log.info("remove......" +rno);
		return replyService.removeByRNO(rno)?"success":"fail";
		
	}
	
	
	//댓글 수정
	//PUT: 자원의 전체 수정, 자원 내 모든 필드를 전달해야함
	//PATCH: 자원의 일부 수정, 수정할 필드만 전송
	
	@PutMapping(value="/{bno}/{rno}", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable Long rno,@PathVariable("bno")Long bno, @RequestBody ReplyVO replyVO) {
		replyVO.setBno(bno);
		replyVO.setRno(rno);
		
		return replyService.modify(replyVO)?"success":"fail";
	}
	
	
	
	
}
