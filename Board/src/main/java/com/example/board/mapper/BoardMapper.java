package com.example.board.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileVO;

@Mapper
public interface BoardMapper {

		//@Select("SELECT * FROM TBL_BOARD")
		public List<BoardVO> getList(Criteria criteia);
		
		public void insert(BoardDTO boardDTO);
		
		public BoardVO getOne(Long bno);

		public int delete(Long bno);

		public int update(BoardVO boardVO); //외부에서 전달되는 것은 수정이 완료된 boardVO임

		public int getTotal(Criteria criteria);
		
		public List<FileVO> getFiles(Long bno);
}
