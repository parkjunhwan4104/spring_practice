package com.real.makeBoard.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDTO {
	
	private int total;
	private int lastPageNum;
	private int startPage; //현재페이지를 기준으로 가장 첫페이지
	private int endPage;  //현재 페이지를 기준으로 마지막 페이지
	private Criteria criteria;
	private boolean prev;
	private boolean next;
	
	
	public PageDTO(Criteria criteria,int total) {
		this.criteria=criteria;
		this.total=total;
		
		
		this.endPage=(int)Math.ceil(criteria.getCurrentPageNum()/(double)criteria.getAmount())*criteria.getAmount();
		this.startPage= endPage- (criteria.getAmount()-1);
				
		this.lastPageNum=(int)Math.ceil((total/(double)criteria.getAmount()));
		
		this.prev= this.startPage>1;
		this.next= this.endPage<this.lastPageNum;
		
		if(this.endPage>this.lastPageNum) {
			this.endPage=this.lastPageNum;
		}
		
		if((this.endPage%(this.criteria.getAmount()))!=0) {
			this.startPage=this.endPage-(this.endPage%this.criteria.getAmount())+1;
		}
	}
	
	

}
