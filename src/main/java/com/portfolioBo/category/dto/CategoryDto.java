package com.portfolioBo.category.dto;

import java.sql.Timestamp;

import com.portfolioBo.category.dto.CategoryServiceDto.CategoryListServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategorySaveServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryUpdateServiceDto;
import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    private String name;
    private String description;
    private String useYn;
    private Timestamp createDate;
    private Timestamp modifyDate;
    
    @Getter
    @Setter
    public static class ActiveCategoryListResult{
    	private Integer categoryId;
        private String name;
    }
    
    @Getter
    @Setter
    public static class CategoryListQuery {
        public CategoryListQuery() {
        	
		}
        public CategoryListQuery(CategoryListServiceDto categoryListServiceDto) {
			this.categoryId = categoryListServiceDto.getCategoryId();
			this.name = categoryListServiceDto.getName();
			this.useYn = categoryListServiceDto.getUseYn();
			this.paging=categoryListServiceDto.getPaging();
		}
        private Integer categoryId;
        private String name;
        private String useYn;
        private Paging paging;
        
    }
    
    @Getter
    @Setter
    public static class CategoryListCntQuery {
        public CategoryListCntQuery() {
        	
		}
        public CategoryListCntQuery(CategoryListServiceDto categoryListServiceDto) {
			this.categoryId = categoryListServiceDto.getCategoryId();
			this.name = categoryListServiceDto.getName();
			this.useYn = categoryListServiceDto.getUseYn();
		}
        private Integer categoryId;
        private String name;
        private String useYn;   
    }
    @Getter
    @Setter
    public static class CategorySaveQuery {
        public CategorySaveQuery() {
        	
		}
        public CategorySaveQuery(CategorySaveServiceDto categorySaveServiceDto) {
			this.name = categorySaveServiceDto.getName();
			this.description = categorySaveServiceDto.getDescription();
			this.useYn = categorySaveServiceDto.getUseYn();
		}
        private String name;
        private String description;
        private String useYn;  
    }
    
    @Getter
    @Setter
    public static class CategoryUpdateQuery {
        public CategoryUpdateQuery() {
        	
		}
        public CategoryUpdateQuery(CategoryUpdateServiceDto categoryUpdateServiceDto) {
        	this.categoryId = categoryUpdateServiceDto.getCategoryId();
			this.name = categoryUpdateServiceDto.getName();
			this.description = categoryUpdateServiceDto.getDescription();
			this.useYn = categoryUpdateServiceDto.getUseYn();
			
		}
        private Integer categoryId;     
        private String name;
        private String description;
        private String useYn;
    }
}
