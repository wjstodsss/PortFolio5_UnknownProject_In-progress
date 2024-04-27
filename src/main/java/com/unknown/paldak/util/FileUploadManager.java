package com.unknown.paldak.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadManager {
    public static String uploadFiles(MultipartFile[] uploadFiles, String uploadPath) {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        StringBuilder imageURLs = new StringBuilder(); // 업로드된 파일 경로들을 저장할 StringBuilder
        
        for (MultipartFile multipartFile : uploadFiles) {
            String originalFilename = multipartFile.getOriginalFilename();
            String uploadedFilePath = uploadPath + "/" + originalFilename;
            
            try { 
                multipartFile.transferTo(new File(uploadedFilePath)); // 파일을 업로드
                imageURLs.append(originalFilename).append(";"); // 업로드된 파일의 경로를 StringBuilder에 추가
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return imageURLs.toString(); // 업로드된 파일들의 경로를 반환
    }
}