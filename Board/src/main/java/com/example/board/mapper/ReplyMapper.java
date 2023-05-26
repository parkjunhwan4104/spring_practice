package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	public int insert(ReplyVO replyVO); // 삽입 시 1개만 삽입 되기때문에 삽입이 되는 건수가 1일 때 제대로 삽입이 된것이고 0이면 안된 것
	
	public ReplyVO select(Long rno);
	
	public int delete(Long rno);
	
	public int update(ReplyVO replyVO);

	public int deleteAll(Long bno); //게시글의 댓글 모두 삭제

	public List<ReplyVO> selectAll(@Param("cri")Criteria criteria,@Param("bno")Long bno);
}
