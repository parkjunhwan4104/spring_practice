package com.example.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.PageDTO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시물 전체 목록
	@GetMapping("/list")
	public void getList(Criteria criteria,Model model) {
		log.info("/list");
		
		PageDTO pageDTO=new PageDTO(boardService.getTotal(),criteria);
		
		model.addAttribute("boardList",boardService.getList(criteria));
		model.addAttribute("pageDTO",pageDTO);
		
	
	}
	
	//게시물 등록 완료버튼을 눌렀을 때 => 등록행위
	@PostMapping("/register")
	public String register(BoardVO boardVO,RedirectAttributes rttr ,Model model) {
		log.info("/register:"+ boardVO );
		boardService.register(boardVO);
		
		//Flash라는 영역은 Session에 생기고, redirect로 전송할 때 request 영역이 초기화 된다.
		// 초기화 되기전에 Flash영역에 데이터를 저장해놓고, 초기화 된 후 Flash영역에서 데이터를 가지고 온다.
		// 데이터를 가져오면 Flash 영역에 있던 데이터는 없어진다
		rttr.addFlashAttribute("bno",boardVO.getBno()); //기존 모델 객체를 이용할떄는 redirect할때 reqeustScope가 없어져서 데이터를 전달할 수 없었지만
														// 	RedirectAttributes을 이용하여 세션에 데이터를 담아서 redirect할때에 데이터를 전달할 수 있도록 한다.
		return "redirect:/board/list";
	}
	
	//게시글 조회
	@GetMapping({"/read","/modify"})
	public void read(Long bno,HttpServletRequest request,Model model) {
	    String url=request.getRequestURI();
	    
		log.info(url.substring(url.lastIndexOf("/"))+":"+bno);
		
		model.addAttribute("board",boardService.get(bno));
	}
	
	// 게시글 삭제
	@GetMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr) {
		log.info("/remove: "+bno);
		
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list";
	}
	
	//게시글 수정
	@PostMapping("/modify")
	public String modify(BoardVO boardVO,RedirectAttributes rttr) {
		
		log.info("/modify:"+boardVO);
		
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/register")
	public void register(){
		
		
	}
	
	
	
	
	
}
