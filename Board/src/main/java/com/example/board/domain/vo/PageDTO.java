package com.example.board.domain.vo;

import com.example.board.domain.vo.Criteria;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //기본생성자 생성
public class PageDTO { // 페이지에 대한 연산 결과를 제공하기 위한 클래스

	private int startPage; //현재페이지를 기준으로 가장 첫페이지
	private int endPage;  //현재 페이지를 기준으로 마지막 페이지
	private int realEndPage; //실제 마지막 페이지 번호
	private boolean prev,next; //페이지에 대한 이전버튼과 다음버튼의 존재 유무

	private int total; //전체 게시글 개수
	private Criteria criteria;
	
	public PageDTO(int total, Criteria criteria) {

		this.total = total;
		this.criteria = criteria;
		
		//ceil(실수 값): 올림처리, 페이지에 게시글이 한 개라도 있다면, 올림을 하여 해당 페이지를 표시하기 위함.
		
		this.endPage=(int)Math.ceil(criteria.getPageNum()/(double)criteria.getAmount())*criteria.getAmount();
		this.startPage= endPage- (criteria.getAmount()-1);
	}
	
	
}
