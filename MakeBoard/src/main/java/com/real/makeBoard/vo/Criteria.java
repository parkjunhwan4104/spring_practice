package com.real.makeBoard.vo;

import lombok.Data;

@Data
public class Criteria {
	
	private int currentPageNum;
	private int amount;
	private String keyword;
	private String type;
	
	public Criteria(int currentPageNum, int amount) {
		this.currentPageNum=currentPageNum;
		this.amount=amount;
	}
	
	public Criteria() {
		this(1,5);
	}
	
	public Criteria(int currentPageNum, int amount,String keyword,String type) {
		this.currentPageNum=currentPageNum;
		this.amount=amount;
		this.keyword=keyword;
		this.type=type;
	}
	
	public String[] getTypes() {
		
		return this.type==null?new String[] {}: this.type.split("");
	}

}
