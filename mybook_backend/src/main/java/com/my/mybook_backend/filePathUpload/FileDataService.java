package com.my.mybook_backend.filePathUpload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
//@RequiredArgsConstructor 필수 필드를 기준으로 생성자 생성하는 것 final 선언된 것 기준으로 생성자 생성함
public class FileDataService {
	@Autowired
	private FileDataRepository fileDataRepository;
	private final String FOLDER_PATH = "D://FileData//"; //파일경로입니다
	
	public String uploadImageToFileSystem(MultipartFile file) throws IllegalStateException, IOException {
		log.info("upload file: {}", file.getOriginalFilename());
		String filePath = FOLDER_PATH + file.getOriginalFilename();
		
		FileData fileData = fileDataRepository.save(
									FileData.builder()
											.name(file.getOriginalFilename())
											.type(file.getContentType())
											.filePath(filePath)
											.build());
		//업로드된 파일을 클라이언트로부터 받아서 지정된 경로에 저장하는 역할
		file.transferTo(new File(filePath));
		
		if(fileData != null) {
			return "file upload 잘됨... 음...다르게는 못하나 : " + filePath;
		}
		
		return null;
	}
	
	//파일 다운로드
	public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
		//Optional 에 값이 있을 경우 값 반환. 없을 경우 런타임에러. // RuntimeException::new는 RuntimeException 클래스의 기본 생성자
		FileData fileData = fileDataRepository.findByName(fileName).orElseThrow(RuntimeException::new);
		
		String filePath = fileData.getFilePath();
		
		System.out.println("download fileData : " + fileData);
		System.out.println("download filePath : " + filePath);
		
		//해당 경로의 파일의 바이트로 읽어드림
		return Files.readAllBytes(new File(filePath).toPath());
	}
}
