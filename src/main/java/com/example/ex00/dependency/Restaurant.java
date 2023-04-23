package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor  //레스트롱 안에 쉐프가 있어야하므로
public class Restaurant {
	
	private final Chef chef;
}
