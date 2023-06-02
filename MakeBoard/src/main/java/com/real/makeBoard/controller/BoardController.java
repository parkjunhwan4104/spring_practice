package com.real.makeBoard.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
	public void showList(Criteria criteria,Model model) {
		
		List<BoardVO> boardList=boardService.getListByCriteria(criteria);

		PageDTO pageDTO=new PageDTO(criteria,boardService.getTotalNum(criteria));
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("pageDTO",pageDTO);
		
	}
	
	
	@GetMapping("/detail/{bno}")
	public String showDetail(Criteria criteria,@PathVariable("bno") Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		model.addAttribute("boardVO", boardVO);
		
		
		return "board/detail";
	}
	
	
	@GetMapping("/modify")
	public String showModify(Criteria criteria,Long bno,Model model) {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		model.addAttribute("boardVO",boardVO);
		
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String doModify(Criteria criteria,BoardVO boardVO) throws UnsupportedEncodingException {
		boardService.modify(boardVO);
		System.out.println("-------------------------"+criteria.getType());
		
		
		return "redirect:/board/detail/"+boardVO.getBno()+"?currentPageNum="+criteria.getCurrentPageNum()+"&type="+criteria.getType()+"&keyword="+URLEncoder.encode(criteria.getKeyword(), "UTF-8");
		//redirect 시에 한글 꺠짐을 방지하기 위해 +URLEncoder.encode(criteria.getKeyword(), "UTF-8");을 해야함
	}
	
	@GetMapping("/delete")
	public String doDelete(Criteria criteria,Long bno) throws UnsupportedEncodingException {
		
		BoardVO boardVO=boardService.getOne(bno);
		
		if(boardVO==null) {
			return "error/error";
		}
		
		boardService.delete(bno);
		
		return "redirect:/board/list?currentPageNum="+criteria.getCurrentPageNum()+"&type="+criteria.getType()+"&keyword="+URLEncoder.encode(criteria.getKeyword(), "UTF-8");
	}
	
	
}
