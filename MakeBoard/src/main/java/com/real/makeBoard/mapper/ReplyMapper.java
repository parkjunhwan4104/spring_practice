package com.real.makeBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.real.makeBoard.vo.ReplyVO;


@Mapper
public interface ReplyMapper {
	
	public int insert(ReplyVO replyVO);
	
	public int delete(Long rno);
	
	public List<ReplyVO> getListByBNO(Long bno);
	
	public int modify(ReplyVO replyVO);
	
	public ReplyVO getReplyByRno(Long rno);
	

}
