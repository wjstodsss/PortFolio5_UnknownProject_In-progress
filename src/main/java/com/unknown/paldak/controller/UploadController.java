package com.unknown.paldak.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	// 업로드 폼을 보여주는 GET 요청을 처리하는 핸들러
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload from");
	}

	// 업로드된 파일을 처리하는 메서드
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
		// 업로드된 파일을 저장할 폴더 경로
		String uploadFolder = "C:\\project\\board_paging_form_upload_sample\\src\\main\\webapp\\resources\\upload";

		for (MultipartFile multipartFile : uploadFile) {
			log.info("---------------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("upload File Size : " + multipartFile.getSize());

			// 실제로 파일을 저장하기 위한 File 객체 생성
			File savaFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try { // 파일을 지정된 경로에 저장
				multipartFile.transferTo(savaFile);
			} catch (Exception e) { // 파일 저장 중 예외 발생 시 에러 메시지 출력
				e.printStackTrace();
			}
		}
	}
}