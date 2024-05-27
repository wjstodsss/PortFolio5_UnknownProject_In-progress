package com.unknown.paldak.admin.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FileUploadManager {
	private final UploadPathConfig uploadPathConfig;
	private final ServletContext servletContext;
	
    public String uploadFiles(MultipartFile[] uploadFiles) {
        File uploadDir = new File(uploadPathConfig.getUploadPath());
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        StringBuilder imageURLs = new StringBuilder(); // 업로드된 파일 경로들을 저장할 StringBuilder
        
        for (MultipartFile multipartFile : uploadFiles) {
        	
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateFormat.format(new Date());
            String datePath = currentDate.replace("-", File.separator);
            System.out.println("datePath = " + datePath );
            File dateDir = new File(uploadDir, datePath);
            if (!dateDir.exists()) {
                dateDir.mkdirs();
            }
            
            
            
            String originalFilename = multipartFile.getOriginalFilename();
      
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            String savedFilename = uuid + "_" + originalFilename;
            String uploadedFilePath = dateDir + "/" + savedFilename;
            System.out.println("originalFilename = " + originalFilename);
            System.out.println("extension = " + extension);
            System.out.println("uuid = " + uuid);
            System.out.println("savedFilename = " + savedFilename);
          
            try { 
            	multipartFile.transferTo(new File(uploadedFilePath)); // 파일을 업로드
                imageURLs.append(datePath).append("/").append(savedFilename).append(";"); // 업로드된 파일의 경로를 StringBuilder에 추가
                System.out.println("imageURLs = " + imageURLs );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return imageURLs.toString(); // 업로드된 파일들의 경로를 반환
    }
}