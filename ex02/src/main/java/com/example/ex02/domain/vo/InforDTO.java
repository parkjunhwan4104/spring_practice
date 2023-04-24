package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component; 

import lombok.Data;

@Component // spring에 등록
@Data
public class InforDTO {
	private String name;
	private int age;
}
