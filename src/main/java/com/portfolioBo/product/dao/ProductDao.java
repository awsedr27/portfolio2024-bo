package com.portfolioBo.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductDetailResult;
import com.portfolioBo.product.dto.ProductDto.ProductListCntQuery;
import com.portfolioBo.product.dto.ProductDto.ProductListQuery;
import com.portfolioBo.product.dto.ProductDto.ProductSaveQuery;
import com.portfolioBo.product.dto.ProductDto.ProductUpdateQuery;

@Mapper
public interface ProductDao {
	
	ProductDto selectProduct(Integer productId);
	
	ProductDetailResult selectProductDetail(Integer productId);
	
	int selectProductListCnt(ProductListCntQuery productListQuery);

	List<ProductDto> selectProductList(ProductListQuery productListQuery);

	int insertProduct(ProductSaveQuery productSaveQuery);

	int updateProduct(ProductUpdateQuery productUpdateQuery);

}
