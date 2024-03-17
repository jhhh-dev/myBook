package com.my.mybook_backend.fileUpload;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<File, Integer>{
	
	Optional<File> findByName(String fileName);

}
