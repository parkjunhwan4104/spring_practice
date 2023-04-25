package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserVO {
	private String id;
	private String password;
}
