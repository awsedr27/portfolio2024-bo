package com.portfolioBo.product.dto;

import java.sql.Timestamp;

import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String name;
    private String description;
    private String useYn;
    private Integer price;
    private Integer categoryId;
    private Integer quantity;
    private Timestamp createDate;
    private Timestamp modifyDate;
    
    @Getter
    @Setter
    public static class ProductListResult {
        private Integer productId;
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private String categoryName;
        private Integer quantity;
        private Timestamp createDate;
        private Timestamp modifyDate;
        private String imageUrl;
    }
    
    @Getter
    @Setter
    public static class ProductDetailResult {
        private Integer productId;
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private Integer categoryId;
        private Integer quantity;
        private Timestamp createDate;
        private Timestamp modifyDate;
        private String imageUrl;
    }
    
    @Getter
    @Setter
    public static class ProductListQuery {
        public ProductListQuery() {
        	
		}
        public ProductListQuery(ProductListServiceDto productServiceDto) {
			this.productId = productServiceDto.getProductId();
			this.name = productServiceDto.getName();
			this.useYn = productServiceDto.getUseYn();
			this.price = productServiceDto.getPrice();
			this.categoryName = productServiceDto.getCategoryName();
			this.paging=productServiceDto.getPaging();
		}
		private Integer productId;
        private String name;
        private String useYn;
        private Integer price;
        private String categoryName;
        private Paging paging;
        
    }
    
    @Getter
    @Setter
    public static class ProductListCntQuery {
        public ProductListCntQuery() {
        	
		}
        public ProductListCntQuery(ProductListServiceDto productServiceDto) {
			this.productId = productServiceDto.getProductId();
			this.name = productServiceDto.getName();
			this.useYn = productServiceDto.getUseYn();
			this.price = productServiceDto.getPrice();
			this.categoryName = productServiceDto.getCategoryName();
		}
		private Integer productId;
        private String name;
        private String useYn;
        private Integer price;
        private String categoryName;        
    }
    @Getter
    @Setter
    public static class ProductSaveQuery {
        public ProductSaveQuery() {
        	
		}
        public ProductSaveQuery(ProductSaveServiceDto productSaveServiceDto) {
			this.name = productSaveServiceDto.getName();
			this.description = productSaveServiceDto.getDescription();
			this.useYn = productSaveServiceDto.getUseYn();
			this.price = productSaveServiceDto.getPrice();
			this.categoryId = productSaveServiceDto.getCategoryId();
			this.quantity=productSaveServiceDto.getQuantity();
		}
        private Integer productId;
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private Integer categoryId;
        private Integer quantity;
    }
    
    @Getter
    @Setter
    public static class ProductUpdateQuery {
        public ProductUpdateQuery() {
        	
		}
        public ProductUpdateQuery(ProductUpdateServiceDto productUpdateServiceDto) {
        	this.productId=productUpdateServiceDto.getProductId();
			this.name = productUpdateServiceDto.getName();
			this.description = productUpdateServiceDto.getDescription();
			this.useYn = productUpdateServiceDto.getUseYn();
			this.price = productUpdateServiceDto.getPrice();
			this.categoryId = productUpdateServiceDto.getCategoryId();
			this.quantity=productUpdateServiceDto.getQuantity();
		}
        private Integer productId;
        private String name;
        private String description;
        private String useYn;
        private Integer price;
        private Integer categoryId;    
        private Integer quantity;
    }
    @Getter
    @Setter
	public static class ProductUpdateQuantityQuery {
	    private Integer productId;
	    private Integer quantity;
	    public ProductUpdateQuantityQuery() {
	    	
	    }
	    public ProductUpdateQuantityQuery(int productId,int quantity) {
	    	this.productId=productId;
	    	this.quantity=quantity;
	    }
	}
    
    
}
