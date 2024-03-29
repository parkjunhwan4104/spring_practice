package com.example.board.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class FileController {

	@PostMapping(value="/upload",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody  //RestController가 아닌 일반 컨트롤러에서 REST로 사용해야할 때 작성하는 것으로 viewResolver를 통해 확장자를 붙이지 않고 리턴값을 그대로 json데이터로 보내겠다는 것 
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] multipartFiles) {
		log.info("upload/////////");

		List<FileVO> files=new ArrayList<FileVO>();
		String uploadDirectory="C:/upload";
		String uploadDatePath=getDirectoryForm();

		File uploadPath=new File(uploadDirectory,uploadDatePath); //2개를 string을 합치도록함
		log.info("uploadPath:"+uploadPath);

		if(!uploadPath.exists()) { //업로드path가 존재하지 않을 떄, 즉 처음 디렉토리 생성
			uploadPath.mkdirs();  //년월일 폴더 3개를 만드므로 mkdirs를 사용
		}

		for(MultipartFile multipartFile:multipartFiles) {
			log.info("----------------");
			log.info("uploadFileName:"+multipartFile.getOriginalFilename());
			log.info("uploadFileSize:"+multipartFile.getSize());

			FileVO fileVO=new FileVO();

			String originalFileName=multipartFile.getOriginalFilename();
			String fileName=null;


			UUID uuid=UUID.randomUUID();
			fileName=uuid.toString()+"_"+originalFileName;

			fileVO.setFileName(originalFileName);
			fileVO.setUuid(uuid.toString());
			fileVO.setUploadPath(uploadDatePath);

			try {
				File file=new File(uploadPath,fileName);			
				multipartFile.transferTo(file); // 해당 경로에 파일 업로드

				InputStream in=new FileInputStream(file); //업로드한 파일의 경로를 읽어옴

				if(checkImageType(file)) { //업로드된 파일이 이미지라면
					fileVO.setFileType(true);
					FileOutputStream out=new FileOutputStream(new File(uploadPath,"t_"+fileName));//썸네일 이미지임을 알려주기 위해 구분점인 t_을 준다
					Thumbnailator.createThumbnail(in,out,100,100);
					in.close();
					out.close();
				}

				files.add(fileVO);

			}catch(IllegalStateException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<List<FileVO>>(files,HttpStatus.OK);
	}

	private String getDirectoryForm() { //현재 시간을 기준으로 년월일을 경로의 포맷으로 만들어 리턴
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
		Date today=new Date();
		return simpleDateFormat.format(today);
	}

	private boolean checkImageType(File file) throws IOException {
		String contentType=Files.probeContentType(file.toPath()); //파일의 종류에 대한 정보를 담고 있는 것이 probeCOntentType임
		return contentType.startsWith("image");	
	}

	@GetMapping("/display")  //우리가 원하는 파일을 불러올수 있도록 하는 메소드
	@ResponseBody
	public ResponseEntity<byte[]> display(String fileName){
		log.info("fileName:"+fileName);

		File file=new File("C:/upload/"+fileName);
		log.info("file: "+file);

		ResponseEntity<byte[]> result=null;
		HttpHeaders header = new HttpHeaders();
		try {

			header.add("Content-Type",Files.probeContentType(file.toPath()));
			result=new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e) {
			log.info("초비상!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
		}

		return result;
	}

	@GetMapping(value="/download",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> download(String fileName) {
		Resource resource=new FileSystemResource("C:/upload/"+fileName);
		if(!resource.exists()) { //경로가 존재하지 않으면
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		else {
			HttpHeaders header=new HttpHeaders();
			String resourceName=resource.getFilename();
			resourceName=resourceName.substring(resourceName.indexOf("_")+1);  //uuid 제거



			try {
				header.add("Content-Disposition", "attachment; filename="+new String(resourceName.getBytes("UTF-8"),"ISO-8859-1"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
		}

	}

	@PostMapping("/deleteFile")
	@ResponseBody
	public String deleteFiles(@RequestParam("fileName")String fileName,@RequestParam("fileType")boolean fileType) { //해당 경로의 파일이 이미지면 썸네일까지 지워야하므로 type가 필요

		File file= null;
		try {
			file = new File("C:/upload/"+URLDecoder.decode(fileName,"UTF-8"));

			System.gc();
			System.runFinalization();  //쓰지 않는 열려있는 파일이 있으면 다 닫게해줌
			
			file.delete();			
			
			if(fileType) { //이미지 파일의 경우에는 위에서 썸네일 부터 지우고 아래에서 원본파일을 제거
				file= new File(file.getPath().replace("t_", ""));
				file.delete();
			}
			
		}catch (UnsupportedEncodingException e) {

				e.printStackTrace();
		}
		return "deleted";
		
	}

}
