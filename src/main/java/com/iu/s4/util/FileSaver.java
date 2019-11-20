package com.iu.s4.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileSaver {
	// 3. IO Stream 사용
	public String save3(String realPath,MultipartFile multipartFile) throws Exception {
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		file = new File(realPath,fileName);
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return fileName;
	}
	// 2. MultipartFile transferTo 메서드 사용
	public String save2(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 저장할 파일명
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		file = new File(realPath,fileName);
		multipartFile.transferTo(file);
		return fileName;
	}
	
	// 1. Spring에서 제공하는 FileCopyUtils 클래스의 copy메서드를 사용하는 방법
	public String save(String realPath, MultipartFile multipartFile) throws Exception {
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca = Calendar.getInstance();
		Long name= ca.getTimeInMillis();
		int index = multipartFile.getOriginalFilename().lastIndexOf(".");
		String fileName = name + multipartFile.getOriginalFilename().substring(index);
		file = new File(realPath, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
}
