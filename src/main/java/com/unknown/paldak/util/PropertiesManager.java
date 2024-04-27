package com.unknown.paldak.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesManager {
	public void setProperty(String key, String value) {
        try {
            // 설정 파일 로드
            Properties properties = new Properties();
            properties.setProperty(key, value);

            // 설정 파일 저장
            OutputStream outputStream = new FileOutputStream("uploadPathConfig.properties");
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public String getProperty(String key) {
        try {
            // 설정 파일 로드
            ClassPathResource resource = new ClassPathResource("config.properties");
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            // 특정 키에 대한 값을 가져오기
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
