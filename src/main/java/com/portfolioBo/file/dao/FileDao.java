package com.portfolioBo.file.dao;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.file.dto.FileDto.FileSaveQuery;
import com.portfolioBo.file.dto.FileDto.FilesUseYnUpdateQuery;

@Mapper
public interface FileDao {

	int insertFile(FileSaveQuery imgFileSaveQuery);

	int updateAllFilesUseYnByReferenceId(FilesUseYnUpdateQuery filesUseYnUpdateQuery);
}
