package com.real.makeBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.real.makeBoard.Service.BoardService;
import com.real.makeBoard.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/add")
	public void showAdd() {}
	
	@PostMapping("/add")
	public String doAdd(BoardVO boardVO) {
			boardService.add(boardVO);
			
			return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public String showList(Model model) {
		
		List<BoardVO> boardList=boardService.getList();
		
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	@GetMapping("/detail/{bno}")
	public String showDetail(@PathVariable("bno") Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		model.addAttribute("boardVO", boardVO);
		
		return "board/detail";
	}
	
	
	@GetMapping("/modify")
	public String showModify(Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		model.addAttribute("boardVO",boardVO);
		
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String doModify(BoardVO boardVO) {
		boardService.modify(boardVO);
		
		return "redirect:/board/detail/"+boardVO.getBno();
	}
	
	
}
