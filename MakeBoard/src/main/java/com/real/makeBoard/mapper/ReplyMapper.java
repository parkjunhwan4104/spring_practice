package com.real.makeBoard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.real.makeBoard.vo.ReplyVO;


@Mapper
public interface ReplyMapper {
	
	public void insert(ReplyVO replyVO);
	
	public void delete(Long rno);
	
	public List<ReplyVO> getListByBNO(Long bno);
	
	public void modify(ReplyVO replyVO);
	
	public ReplyVO getReplyByRno(Long rno);
	

}
