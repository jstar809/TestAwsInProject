package com.jwtApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwtApi.utill.S3Uploader;

@SpringBootTest
public class S3UploadTest {

	@Autowired
	S3Uploader s3Uploader;
	
	@Test
	public void uploadFileTest() {
		
		String filePath = "D:\\study\\springBoot\\uploadFile\\logo.png";
		try {
			System.out.println(s3Uploader.upload(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void deleFileTest() {
		String deleteFileName = "logo.png";
		s3Uploader.removeS3File(deleteFileName);
	}
	
}
