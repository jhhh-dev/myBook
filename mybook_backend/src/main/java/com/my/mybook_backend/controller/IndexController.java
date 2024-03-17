package com.my.mybook_backend.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.my.mybook_backend.filePathUpload.FileDataService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IndexController {
	private final FileDataService fileDataService;
	
    @GetMapping("/hello")
    public String test() {
        return "Hello, world!";
    }
    
    //파일 경로 저장임
    @PostMapping("/fileUpload")
    public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
    	String uploadImage = fileDataService.uploadImageToFileSystem(file);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }
    
    //파일 다운로드
    @GetMapping("/file/{fileName}")
    public ResponseEntity<?> fileDownload(@PathVariable("fileName") String fileName) throws IOException{
    	byte[] download = fileDataService.downloadImageFromFileSystem(fileName);
    	
    	return ResponseEntity.status(HttpStatus.OK)
    				.contentType(MediaType.valueOf("image/png"))
    				.body(download);
    }
}
