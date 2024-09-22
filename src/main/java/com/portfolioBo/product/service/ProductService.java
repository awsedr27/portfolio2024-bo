package com.portfolioBo.product.service;

import java.util.List;

import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductDetailResult;
import com.portfolioBo.product.dto.ProductDto.ProductListResult;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

public interface ProductService {
	
	List<ProductListResult> getProductList(ProductListServiceDto productServiceDto) throws Exception;

	ProductDetailResult getProductDetail(Integer productId) throws Exception;

	boolean saveProduct(ProductSaveServiceDto productSaveServiceDto) throws Exception;

	boolean updateProduct(ProductUpdateServiceDto productSaveServiceDto) throws Exception;

}
