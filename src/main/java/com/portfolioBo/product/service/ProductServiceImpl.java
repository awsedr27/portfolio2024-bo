package com.portfolioBo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.category.dao.CategoryDao;
import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.product.dao.ProductDao;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductListCntQuery;
import com.portfolioBo.product.dto.ProductDto.ProductListQuery;
import com.portfolioBo.product.dto.ProductDto.ProductSaveQuery;
import com.portfolioBo.product.dto.ProductDto.ProductUpdateQuery;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;

    
	@Override
	public List<ProductDto> getProductList(ProductListServiceDto productServiceDto) {
		ProductListQuery productListQuery=new ProductListQuery(productServiceDto);
		int listCnt=productDao.selectProductListCnt(new ProductListCntQuery(productServiceDto));
		productListQuery.getPaging().setTotalRecordCount(listCnt);
		return productDao.selectProductList(productListQuery);
	}


	@Override
	public ProductDto getProduct(Integer productId) {
		return productDao.selectProduct(productId);
	}


	@Override
	public int saveProduct(ProductSaveServiceDto productSaveServiceDto) throws Exception{
		ProductSaveQuery productSaveQuery=new ProductSaveQuery(productSaveServiceDto);
		CategoryDto categoryDto=categoryDao.selectActiveCategory(productSaveQuery.getCategoryId());
		if(categoryDto==null) {
			throw new CustomException("유효하지않은 카테고리입니다");
		}
		return productDao.insertProduct(productSaveQuery);
		
	}


	@Override
	public int updateProduct(ProductUpdateServiceDto productUpdateServiceDto) throws Exception {
		ProductDto product=productDao.selectProduct(productUpdateServiceDto.getProductId());
		if(product==null) {
			throw new CustomException("유효하지않은 상품아이디입니다");
		}
		ProductUpdateQuery productUpdateQuery=new ProductUpdateQuery(productUpdateServiceDto);
		CategoryDto categoryDto=categoryDao.selectActiveCategory(productUpdateQuery.getCategoryId());
		if(categoryDto==null) {
			throw new CustomException("유효하지않은 카테고리입니다");
		}
		return productDao.updateProduct(productUpdateQuery);
	}

}
