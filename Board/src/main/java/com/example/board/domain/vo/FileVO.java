package com.example.board.domain.vo;

import lombok.Data;

@Data
public class FileVO {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType; //이미지면 true, 이미지가 아니면 false
}
