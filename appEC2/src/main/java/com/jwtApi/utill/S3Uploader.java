package com.jwtApi.utill;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

//@Component
public class S3Uploader {
	private final static Logger log = LogManager.getLogger();
	
	@Value("${cloud.aws.s3.bucket}")
	public String bucket;
	
	private final AmazonS3Client amazonS3Client;
	
	
	
	public S3Uploader(AmazonS3Client amazonS3Client) {
		this.amazonS3Client =  amazonS3Client;
	}
	
	public String upload(String filePath ) throws RuntimeException{
		
		File targetFile = new File(filePath);
		String uploadUrl = pusS3(targetFile, targetFile.getName());
		
		return uploadUrl;
		
	}
	
	private String pusS3(File upLoadFile , String FileName) throws RuntimeException{
		
		amazonS3Client.putObject(new PutObjectRequest(bucket, FileName, upLoadFile).withCannedAcl(CannedAccessControlList.PublicRead));
		
		return amazonS3Client.getUrl(bucket, FileName).toString();
		
	}
	
	public void removeS3File(String fileName) {
		final DeleteObjectRequest deleteObjectRequest =new DeleteObjectRequest(bucket, fileName);
		
		amazonS3Client.deleteObject(deleteObjectRequest);
	}
	
}
