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
import com.real.makeBoard.vo.Criteria;
import com.real.makeBoard.vo.PageDTO;

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
	public String showList(Criteria criteria,Model model) {
		
		List<BoardVO> boardList=boardService.getList(criteria);
		
		PageDTO pageDTO=new PageDTO(criteria,boardService.getTotalNum());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO",pageDTO);
		
		System.out.println("-----------start:"+pageDTO.getStartPage());
		System.out.println("-----------end:"+pageDTO.getEndPage());
		
		System.out.println("---cri-----"+criteria.getCurrentPageNum());
		System.out.println("---cria-----"+criteria.getAmount());
		
		return "board/list";
	}
	
	@GetMapping("/detail/{bno}")
	public String showDetail(@PathVariable("bno") Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		model.addAttribute("boardVO", boardVO);
		
		return "board/detail";
	}
	
	
	@GetMapping("/modify")
	public String showModify(Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		model.addAttribute("boardVO",boardVO);
		
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String doModify(BoardVO boardVO) {
		boardService.modify(boardVO);
		
		return "redirect:/board/detail/"+boardVO.getBno();
	}
	
	@GetMapping("/delete")
	public String doDelete(Long bno) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	
}
