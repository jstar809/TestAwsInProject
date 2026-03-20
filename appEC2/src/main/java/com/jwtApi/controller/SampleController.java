/*
 * package com.jwtApi.controller;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * java.util.stream.Collector; import java.util.stream.Collectors;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.jwtApi.dto.SampleDTO; import com.jwtApi.utill.LocalUploader;
 * import com.jwtApi.utill.S3Uploader;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api/sample") public class SampleController {
 * 
 * private final LocalUploader localUploader; private final S3Uploader
 * s3Uploader;
 * 
 * public SampleController(LocalUploader localUploader ,S3Uploader s3Uploader) {
 * this.localUploader = localUploader; this.s3Uploader = s3Uploader; }
 * 
 * @GetMapping("/getArr") public String[] getArr() { return new String[] {"AAA"
 * ,"BBB" , "CCC"}; }
 * 
 * 
 * @PostMapping("/upload") public List<String> upload(SampleDTO sampleDTO){
 * MultipartFile[] files =sampleDTO.getFiles();
 * 
 * List<String> uploadPathList = new ArrayList<>();
 * 
 * for(MultipartFile file : files) {
 * uploadPathList.addAll(localUploader.uploadLocal(file)); } List<String>
 * s3Paths = uploadPathList.stream().map(fileName -> { return
 * s3Uploader.upload(fileName); }).collect(Collectors.toList());
 * 
 * 
 * return s3Paths;
 * 
 * }
 * 
 * 
 * }
 */