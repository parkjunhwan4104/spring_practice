package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //qulifier를 쓰기전에 스프링에 등록하기 위해 붙임
@Qualifier("laptop") @Primary   //laptop을 더 많이 사용하여 laptop을 디폴트로 주입받고 싶을 때
public class Laptop implements Computer {
	
	@Override
	public int getScreenWidth() {
		return 1920;
	}
}
