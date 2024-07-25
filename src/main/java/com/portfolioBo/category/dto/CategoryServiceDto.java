package com.portfolioBo.category.dto;

import com.portfolioBo.category.dto.CategoryRequest.CategoryListRequest;
import com.portfolioBo.category.dto.CategoryRequest.CategorySaveRequest;
import com.portfolioBo.category.dto.CategoryRequest.CategoryUpdateRequest;
import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductRequest.ProductSaveRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductUpdateRequest;

import lombok.Getter;
import lombok.Setter;

public class CategoryServiceDto {
	
    @Getter
    @Setter
	public static class CategoryListServiceDto {
	    private Integer categoryId;
	    private String name;
	    private String useYn;
	    private Paging paging;
	    public CategoryListServiceDto() {
	    	
	    }
		public CategoryListServiceDto(CategoryListRequest request) {
			this.categoryId = request.getCategoryId();
			this.name = request.getName();
			this.useYn = request.getUseYn();
		}
	    
	}
    @Getter
    @Setter
	public static class CategorySaveServiceDto {
        private String name;
        private String description;
        private String useYn;
	    public CategorySaveServiceDto() {
	    	
	    }
		public CategorySaveServiceDto(CategorySaveRequest request) {
			this.name = request.getName();
			this.description = request.getDescription();
			this.useYn = request.getUseYn();
		}
	    
	}
    
    @Getter
    @Setter
	public static class CategoryUpdateServiceDto {
        private Integer categoryId;
        private String name;
        private String description;
        private String useYn;
	    public CategoryUpdateServiceDto() {
	    	
	    }
		public CategoryUpdateServiceDto(CategoryUpdateRequest request) {
			this.categoryId = request.getCategoryId();
			this.name = request.getName();
			this.description = request.getDescription();
			this.useYn = request.getUseYn();
		}
	    
	}
}
