package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.dao.FileDAO;
import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;
import com.example.board.domain.vo.FileVO;

@Service
public class BoardServiceImpl implements BoardService { //코드를 재사용하고 결합을 느슨하게 하기위해 인터페이스를 사용함, 재사용하지 않으면 단순히 클래스로만 구현함

	@Autowired
	BoardDAO boardDAO;
	
	@Autowired
	FileDAO fileDAO;
	
	@Override
	public void register(BoardDTO boardDTO) {
		boardDAO.register(boardDTO);
		
		for(FileVO file: boardDTO.getFiles()) {
			FileDTO fileDTO=new FileDTO();
			fileDTO.setUuid(file.getUuid());
			fileDTO.setUploadPath(file.getUploadPath());
			fileDTO.setFileName(file.getFileName());
			fileDTO.setFileType(file.isFileType());
			fileDTO.setBno(boardDTO.getBno());  //이미 위에서 board.register을 할때 insert 쿼리가 진행되는데 이 때 insert안에 select가 먼저 실행되어 bno가 이미 만들어진후 게시글이 추가되므로 bno가 존재하게됨
			fileDAO.register(fileDTO);
		}
	}

	@Override
	public BoardVO get(Long bno) {
			
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		return boardDAO.modify(boardVO);  //업데이트가 되었을 때 true
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);  //delete가 되었으면 true
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		
		return boardDAO.getList(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		
		return boardDAO.getTotal(criteria);
	}

	@Override
	public List<FileVO> getFiles(Long bno) {
		// TODO Auto-generated method stub
		return boardDAO.getFiles(bno);
	}

}
