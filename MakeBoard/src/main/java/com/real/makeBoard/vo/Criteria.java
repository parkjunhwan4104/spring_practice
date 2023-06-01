package com.real.makeBoard.vo;

import lombok.Data;

@Data
public class Criteria {
	
	private int currentPageNum;
	private int amount;
	
	public Criteria(int currentPageNum, int amount) {
		this.currentPageNum=currentPageNum;
		this.amount=amount;
	}
	
	public Criteria() {
		this(1,5);
	}

}
