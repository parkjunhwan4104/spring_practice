package com.example.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class FileController {
	
	@PostMapping(value="/upload",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody  //RestController가 아닌 일반 컨트롤러에서 REST로 사용해야할 때 작성하는 것으로 viewResolver를 통해 확장자를 붙이지 않고 리턴값을 그대로 json데이터로 보내겠다는 것 
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] uploadFiles){
		log.info("upload/////////");
		
		List<FileVO> files=new ArrayList<FileVO>();
		String uploadDirectory="F:\\upload";
	}
	
	public String getDirectoryForm() { //현재 시간을 기준으로 년월일을 경로의 포맷으로 만들어 리턴
		
	}
	
}
