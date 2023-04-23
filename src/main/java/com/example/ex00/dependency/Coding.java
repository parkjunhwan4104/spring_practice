package com.example.ex00.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@Getter
//@AllArgsConstructor //원하는 필드만이 아닌 모든 것이 주입됨
@RequiredArgsConstructor  //필요한 애들만 초기화 할 수 있도록 함(final을 붙이거나 notnull어노테이션을 붙인 애들만 초기화를 해줌
public class Coding {
	
	//	Computer computer; ==> 의존성이 생기는 거
	// Computer computer=new Computer(); ==> 결합성이 단단해져서 new Computer()에 해당하는 것만 사용할 수 있음
	
	
	// 필드 주입
	// 굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하기 않기 때문에 StackOverFlow가 발생
	// 기본적으로 필드 주입 시 final을 붙일 수 없기 때문에 다른 곳에서 변경 가능(롬복안에 생성자를 초기화 해주므로 final을 붙여도 오류가 안나지만 안붙이는게 맞음, 즉 data 어노테이션이 없어지면 오류가 남)
	// 필드 주입 자체만 사용한다면 final을 붙이면 오류가 난다. (@data를 붙이지 않고 필드주입 시)
	// 기존에 @data 어노테이션을 붙였을 때는 생성자를 통해 값을 받기 때문에 final을 붙여서 값이 할당되었다고 생각해 에러가 안 난다.
	
	//1
		@Autowired //편하게 주입받을 수 있음 new 필요 x
    private final Computer computer; //외부에서 직접 접근하지 않게 하기위해 private, 외부에서 다른 값이 들어오지 않도록 final을 붙임
    
	
	//2
   /*@Autowired
    @NonNull
    private Computer computer;
    */
    
    
    //생성자 주입
    // 순환 참조시 컴파일러가 인지 가능하여 오류를 발생시킬 수 있음
    // 메모리에 할당하면서 초기값으로 주입되므로 final 키워드가 사용가능, 다른 곳에서 변형 불가능
    // 의존성 주입이 되지 않으면 객체가 생성되지 않음
    // 메모리에 올리고 나서 주입받는 필드 주입과 setter 주입과 달리 메모리에 올리면서 주입받는 것은 생성자 주입(올리면서 예외발생하면 에러발생)
	// 3가지 필드 주입 중에 가장 안전하고 많이 쓰이는 것이 생성자 주입임	
    /*
    @Autowired
    public Coding(Computer computer) {
    	super();
    	this.computer=computer;
    }
    */
    
    //Setter 주입
    // 굉장히 편하게 주입할 수 있으나 순환 참조(무한 루프)시 오류가 발생하기 않기 때문에 StackOverFlow가 발생
 	// final을 붙일 수 없기 때문에 다른 곳에서 변경 가능(롬복안에 생성자를 초기화 해주므로 final을 붙여도 오류가 안나지만 안붙이는게 맞음
	//즉 data 어노테이션이 없어지면 오류가 남)
 	// 외부에서 직접 주입이 가능함.(public)
	// 많이 사용되지는 않음
    /*
    @Autowired
	public void setComputer(Computer computer) {
		this.computer=computer;
	}
	*/
    
    
	
}
