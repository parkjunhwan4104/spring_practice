package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.board.domain.vo.BoardVO;

@Mapper
public interface BoardMapper {

		//@Select("SELECT * FROM TBL_BOARD")
		public List<BoardVO> getList();
		
		public void insert(BoardVO board);
		
		public BoardVO getOne(Long bno);

		public int delete(Long bno);

		public int update(BoardVO boardVO); //외부에서 전달되는 것은 수정이 완료된 boardVO임
}
