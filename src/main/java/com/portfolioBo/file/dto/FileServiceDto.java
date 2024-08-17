package com.portfolioBo.file.dto;

import org.springframework.web.multipart.MultipartFile;

import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

import lombok.Getter;
import lombok.Setter;

public class FileServiceDto {
    @Getter
    @Setter
	public static class FileSaveServiceDto {
        private MultipartFile file;    
        private String referenceId;        
  
        public FileSaveServiceDto() {
        	
        }
        public FileSaveServiceDto(ProductSaveServiceDto rq) {
        	this.file=rq.getImageFile();
        }
		public FileSaveServiceDto(ProductUpdateServiceDto productUpdateServiceDto) {
			this.file=productUpdateServiceDto.getImageFile();
		}
	}
}
