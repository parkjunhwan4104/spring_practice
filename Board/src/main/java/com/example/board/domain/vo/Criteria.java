package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Criteria {  //페이징을 하기 위해 필요한 클래스
	
	private int pageNum; //현재 페이지
	private int amount;  // 각 페이지에 뿌져질 게시물 개수
	private String type; //검색이 뭐에 해당하는지 ex) 제목, 내용, 글쓴이
	private String keyword; 
	
	
	public Criteria() { //디폴트 값으로 한 페이지당 10개씩으로
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	public Criteria(int pageNum, int amount, String type, String keyword) {
		this.pageNum=pageNum;
		this.amount=amount;
		this.type=type;
		this.keyword=keyword;
	}
	
	public String getParams() { //게시물 상세보기 클릭 시 뒤로 가기를 할 때 그 전에 있던 이전 페이지를 기억해야하므로 쿼리파라미터로 pageNum을 기억하도록 해줌
		//즉 ?부터 시작해서 ?pageNum=~ 이러한 형식으로 붙여줌
		
		UriComponentsBuilder builder=UriComponentsBuilder.fromPath("").queryParam("pageNum",this.pageNum);
		return builder.toUriString();
	}
	
	public String[] getTypes() {
		// "TCW".split("") --> 3칸 배열 [T][C][W]로 됨
		return type==null? new String[] {} : type.split("");
	}
	
}

	
