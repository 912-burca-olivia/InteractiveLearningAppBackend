package com.demo.filemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileServiceFactory {

	@Autowired
	@Qualifier("fileServiceImpl")
	private FileService nativeFileService;


	@Value("${storage.mode}")
	private String STORAGE_MODE;

	public FileService getInstance() {
		FileService fileServiceInstance = null;
		switch (STORAGE_MODE) {
		case FileService.STORAGE_MODE_NATIVE:
			fileServiceInstance = nativeFileService;
			break;
		default:
			fileServiceInstance = nativeFileService;
			break;
		}
		return fileServiceInstance;
	}

	public String getFileSeparator() {
		return FileServiceImpl.PATH_SEPARATOR;
	}

}
