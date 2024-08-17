package com.portfolioBo.file.dto;

import lombok.Getter;
import lombok.Setter;

public class FileDto {
    @Getter
    @Setter
    public static class FileSaveQuery {
        private String fileId;             
        private String fileName;        
        private String fileType;         
        private long fileSize;           
        private String filePath;         
        private String referenceId;        
        private String referenceType;  
    }
    
    @Getter
    @Setter
    public static class FilesUseYnUpdateQuery{
    	private String useYn;
        private String referenceId;        
        private String referenceType;
    }
}
