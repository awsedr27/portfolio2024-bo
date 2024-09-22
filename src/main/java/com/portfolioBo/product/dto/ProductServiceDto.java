package com.portfolioBo.product.dto;

import org.springframework.web.multipart.MultipartFile;

import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductSaveRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductUpdateRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class ProductServiceDto {
    @Getter
    @Setter
	public static class ProductListServiceDto {
	    private Integer productId;
	    private String name;
	    private String useYn;
	    private Integer price;
	    private String categoryName;
	    private Paging paging;
	    public ProductListServiceDto() {
	    	
	    }
		public ProductListServiceDto(ProductListRequest request) {
			this.productId = request.getProductId();
			this.name = request.getName();
			this.useYn = request.getUseYn();
			this.price = request.getPrice();
			this.categoryName = request.getCategoryName();
		}
	    
	}
    
    @Getter
    @Setter
	public static class ProductSaveServiceDto {
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private Integer categoryId;
        private Integer quantity;
        private MultipartFile imageFile;
	    public ProductSaveServiceDto() {
	    	
	    }
		public ProductSaveServiceDto(ProductSaveRequest request) {
			this.name = request.getName();
			this.description = request.getDescription();
			this.useYn = request.getUseYn();
			this.price = request.getPrice();
			this.categoryId = request.getCategoryId();
			this.quantity=request.getQuantity();
			this.imageFile=request.getImageFile();
		}
	    
	}
    @Getter
    @Setter
	public static class ProductUpdateServiceDto {
    	private Integer productId;
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private Integer categoryId;
        private Integer quantity;
        private MultipartFile imageFile;


	    public ProductUpdateServiceDto() {
	    	
	    }
		public ProductUpdateServiceDto(ProductUpdateRequest request) {
			this.productId=request.getProductId();
			this.name = request.getName();
			this.description = request.getDescription();
			this.useYn = request.getUseYn();
			this.price = request.getPrice();
			this.categoryId = request.getCategoryId();
			this.quantity=request.getQuantity();
			this.imageFile=request.getImageFile();

		}
	    
	}
}
