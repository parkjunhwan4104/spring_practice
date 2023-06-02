package com.real.makeBoard.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReplyVO {
	private Long rno;
	private Long bno;
	private String replyContent;
	private String writer;
	private String regDate;
	private String updateDate;

}
