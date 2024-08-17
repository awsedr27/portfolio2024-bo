package com.portfolioBo.file.service;

import java.io.IOException;

import com.portfolioBo.file.dto.FileServiceDto.FileSaveServiceDto;

public interface FileService {
	
	boolean saveImgFile(FileSaveServiceDto rq) throws IllegalStateException, IOException;

}
