package com.jwtApi.utill;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Component
public class LocalUploader {

	private final static Logger log = LoggerFactory.getLogger(LocalUploader.class);
	
	private String uploadPath = "D:\\study\\springBoot\\uploadFile";
	
	
	public List<String> uploadLocal (MultipartFile file){
		if(file == null || file.isEmpty()) {
			return null;
		}
		
		String uuid = UUID.randomUUID().toString();
		String saveFileName = uuid +"_"+file.getOriginalFilename();
		
		Path savePath = Paths.get(uploadPath , uuid);
		
		List<String > savePathList = new ArrayList<>();
		
		try {
			file.transferTo(savePath);
			
			savePathList.add(savePath.toFile().getAbsolutePath());
			
			if(Files.probeContentType(savePath).startsWith("image")) {
				File thumbFile = new File(uploadPath+"S_"+saveFileName);
				
				savePathList.add(thumbFile.getAbsolutePath());
				
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return savePathList;
	}
}
