package com.my.mybook_backend.filePathUpload;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FileData")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //protected 수준의 기본 생성자 -> 외부에서 호출할 수 없게 -> 왜??
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String type;
	private String filePath;
	
	@Builder
	public FileData(String name, String type, String filePath) {
		this.name = name;
		this.type = type;
		this.filePath = filePath;
	}
}
