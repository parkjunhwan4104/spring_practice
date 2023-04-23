package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component //해당 객체를 Spring에서 관리하도록 설정
@Data //롬복에서 getter, setter, equal등을 다 지원해줌
public class Computer {
    int data;
}
