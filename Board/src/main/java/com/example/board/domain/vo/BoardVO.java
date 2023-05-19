package com.example.board.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;


// VO의 목적은 테이블에 있는 컬럼들과 1대1 매핑이 될 수 있게끔 매핑 구조를 만드는 것
@Component
@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String updateDate;
	
}
