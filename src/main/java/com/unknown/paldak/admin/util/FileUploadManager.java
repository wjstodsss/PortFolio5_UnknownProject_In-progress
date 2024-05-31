package com.unknown.paldak.admin.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;

@Component
@RequiredArgsConstructor
public class FileUploadManager {
	private final UploadPathConfig uploadPathConfig;
	
    public Map<String, String> uploadFiles(MultipartFile[] uploadFiles) {
    	
    	Map<String, String> map = new HashMap<>();

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
            String uploadedFilePathT = dateDir + "/t_" + savedFilename;
            System.out.println("originalFilename = " + originalFilename);
            System.out.println("extension = " + extension);
            System.out.println("uuid = " + uuid);
            System.out.println("savedFilename = " + savedFilename);
            
            map.put("uuid", uuid);
            map.put("uuidT", "t_" + uuid);
            map.put("originalFilename", originalFilename);
            map.put("datePath", datePath);
            
            System.out.println("originalFilename = " + map.get("originalFilename"));
            System.out.println("uuid = " + map.get("uuid"));
            System.out.println("datePath = " + map.get("datePath"));
          
            try { 
            	multipartFile.transferTo(new File(uploadedFilePath)); // 파일을 업로드
            	FileOutputStream thumbnail = new FileOutputStream(new File(uploadedFilePathT)); // 파일을 업로드
            	Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
            	
                imageURLs.append(datePath).append("/").append(savedFilename).append(";"); // 업로드된 파일의 경로를 StringBuilder에 추가
                map.put("imageURLs", imageURLs.toString());
                System.out.println("imageURLs = " + imageURLs );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return map;
    }
    
    public boolean deleteFile(String imageUrl) {
        String filePath = uploadPathConfig.getUploadPath() + File.separator + imageUrl;
        
        System.out.println(uploadPathConfig.getUploadPath() + File.separator + imageUrl);
        File file = new File(filePath);

        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }
}