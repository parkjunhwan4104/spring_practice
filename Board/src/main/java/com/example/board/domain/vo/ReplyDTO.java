package com.example.board.domain.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //기본 생성자 생성
public class ReplyDTO {
	private List<ReplyVO> list;
	private int total;

}
