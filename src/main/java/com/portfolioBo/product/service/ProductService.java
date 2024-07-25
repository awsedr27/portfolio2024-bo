package com.portfolioBo.product.service;

import java.util.List;

import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

public interface ProductService {
	
	List<ProductDto> getProductList(ProductListServiceDto productServiceDto) throws Exception;

	ProductDto getProduct(Integer productId) throws Exception;

	int saveProduct(ProductSaveServiceDto productSaveServiceDto) throws Exception;

	int updateProduct(ProductUpdateServiceDto productSaveServiceDto) throws Exception;

}
