package com.example.ex02.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.Product;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class WorkController {
	
// 직원들의 근무시간을 체크하여 출근과 퇴근 체크
	@GetMapping("/checkIn")
	public String checkIn() {
		
		return "work/checkIn";
	}
	
	@GetMapping("/getToWork")
	public String getToWork(@ModelAttribute("name") String name) {
		Calendar c=Calendar.getInstance(); //현재 시간
		
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		
		boolean lateCondition=hour>=9 && minute>0; // 지각 조건
		
		if(lateCondition) {
			return "work/late";
		}
		
		return "work/getToWork";
	}
	
	@GetMapping("/leaveWork")
	public String leaveWork(@ModelAttribute("name") String name) {
		Calendar c=Calendar.getInstance(); //현재 시간
		
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int minute=c.get(Calendar.MINUTE);
		
		boolean leaveCondition=hour>=18 && minute>=0; //퇴근 가능 조건

		if(leaveCondition) {
			return "work/leaveWork";
		}
		
		return "work/needToWork";
	}
	
// 상품의 바코드를 입력받고 해당 상품명을 출력한다.	
	
	@GetMapping("/market")
	public String goMarget() {
		return "market/market";
	}
	
	@PostMapping("/cashier")
	public String getProduct(String barcode,Model model) {
		
		String productName=null;
		
		switch(barcode) {
		
			case "11":
				productName="오땅";
				break;
				
			case "22":
				productName="바나나우유";
				break;
				
			case "33":
				productName="벌꿀 피자";
				break;
				
			case "44":
				productName="치킨";
				break;	
				
			default:
				productName="없는 상품";
				break;
		
		
		}
		model.addAttribute("productName",productName);
		return "market/cashier";
		
	}
	

// 선택한 할인율을 해당 상품에 적용
// 버튼을 여러 개 만들어서 클리된 할인율만큼의 가격 적용
	
	
	@GetMapping("/sale")
	public String goChangeSale() {
		
		return "market/sale";
	}
	
	
	@PostMapping("/change")
	public String change(String productNum,String salePercent,Model model) {
		
		double salePercentToDouble=(Integer.parseInt(salePercent))*0.01;
				
		Product product=new Product();
		String productName=null;
		int productPrice=0;
		
		int discountedPrice;
		
		switch(productNum) {
		
		case "1":
			productName="오땅";
			productPrice=4500;			
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			break;
		case "2":
			productName="바나나 우유";
			productPrice=1700;			
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			break;
		case "3":
			productName="피자";
			productPrice=24500;			
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			break;
		case "4":
			productName="치킨";
			productPrice=21500;			
			product.setProductName(productName);
			product.setProductPrice(productPrice);
			break;
			
		default:
			break;
		}
		discountedPrice=(int)Math.round(product.getProductPrice()*(1-salePercentToDouble));
		
		model.addAttribute("num",productNum);
		model.addAttribute("name",product.getProductName());
		model.addAttribute("price",discountedPrice);
		
		
		return "market/showChange";
		
	}
	
	
	@PostMapping("/usePoint")
	public String usePoint(String productName,String productNumber, String productPrice,Model model) {
		model.addAttribute("productName", productName);
		model.addAttribute("productNumber",productNumber);
		model.addAttribute("productPrice",productPrice);
		
		return "market/usePoint";
	}
	
	@PostMapping("/use")
	public String use(String saledProductName,String saledProductPrice,String saledProductNumber,String productNum,Integer point,Model model) {
		
		Product product=new Product();
		
		if(!saledProductNumber.equals(productNum))	{
							
			String productName=null;
			int productPrice=0;
					
			switch(productNum) {
			
			case "1":
				productName="오땅";
				productPrice=4500;			
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				break;
			case "2":
				productName="바나나 우유";
				productPrice=1700;			
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				break;
			case "3":
				productName="피자";
				productPrice=24500;			
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				break;
			case "4":
				productName="치킨";
				productPrice=21500;			
				product.setProductName(productName);
				product.setProductPrice(productPrice);
				break;
				
			default:
				break;
			}
		}
		else {
			
			product.setProductName(saledProductName);
			product.setProductPrice(Integer.parseInt(saledProductPrice));
			
		}
		
		int cash=product.getProductPrice()-point; //포인트를 뺀 현금으로 결제할 나머지 가격
		if(point>product.getProductPrice()) {
			point=product.getProductPrice();
			cash=0;
		}
		
		
		model.addAttribute("product", product);
		model.addAttribute("productNum", productNum);
		model.addAttribute("point", point);
		model.addAttribute("cash",cash);
		
		return "market/payment";
	}
	
}

