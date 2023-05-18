package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {  //페이징을 하기 위해 필요한 클래스
	
	private int pageNum; //현재 페이지
	private int amount;  // 각 페이지에 뿌져질 게시물 개수

	public Criteria() { //디폴트 값으로 한 페이지당 10개씩으로
		this(1,10);
	}
}
