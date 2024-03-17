package com.my.mybook_backend.filePathUpload;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long>{
	
	//Optional 반ㅎ환할 값이 없을 수도 있는
	Optional<FileData> findByName(String fileName);

}
