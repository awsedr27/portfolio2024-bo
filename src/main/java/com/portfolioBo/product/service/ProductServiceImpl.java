package com.portfolioBo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.category.dao.CategoryDao;
import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.common.CommonEnum;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.file.dao.FileDao;
import com.portfolioBo.file.dto.FileDto.FilesUseYnUpdateQuery;
import com.portfolioBo.file.dto.FileServiceDto.FileSaveServiceDto;
import com.portfolioBo.file.service.FileService;
import com.portfolioBo.product.dao.ProductDao;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductDetailResult;
import com.portfolioBo.product.dto.ProductDto.ProductListCntQuery;
import com.portfolioBo.product.dto.ProductDto.ProductListQuery;
import com.portfolioBo.product.dto.ProductDto.ProductListResult;
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
	
	@Autowired
	FileService fileService;
	
	@Autowired
	FileDao fileDao;

    
	@Override
	public List<ProductListResult> getProductList(ProductListServiceDto productServiceDto) {
		ProductListQuery productListQuery=new ProductListQuery(productServiceDto);
		int listCnt=productDao.selectProductListCnt(new ProductListCntQuery(productServiceDto));
		productListQuery.getPaging().setTotalRecordCount(listCnt);
		return productDao.selectProductList(productListQuery);
	}


	@Override
	public ProductDetailResult getProductDetail(Integer productId) {
		return productDao.selectProductDetail(productId);
	}


	@Override
	public boolean saveProduct(ProductSaveServiceDto productSaveServiceDto) throws Exception{		
		ProductSaveQuery productSaveQuery=new ProductSaveQuery(productSaveServiceDto);
		CategoryDto categoryDto=categoryDao.selectActiveCategory(productSaveQuery.getCategoryId());
		if(categoryDto==null) {
			throw new CustomException("유효하지않은 카테고리입니다");
		}
		productDao.insertProduct(productSaveQuery);
		FileSaveServiceDto fileSaveServiceDto=new FileSaveServiceDto(productSaveServiceDto);
		fileSaveServiceDto.setReferenceId(productSaveQuery.getProductId().toString());
		return fileService.saveImgFile(fileSaveServiceDto);
	}


	@Override
	public boolean updateProduct(ProductUpdateServiceDto productUpdateServiceDto) throws Exception {
		ProductDto product=productDao.selectProduct(productUpdateServiceDto.getProductId());
		if(product==null) {
			throw new CustomException("유효하지않은 상품아이디입니다");
		}
		ProductUpdateQuery productUpdateQuery=new ProductUpdateQuery(productUpdateServiceDto);
		CategoryDto categoryDto=categoryDao.selectActiveCategory(productUpdateQuery.getCategoryId());
		if(categoryDto==null) {
			throw new CustomException("유효하지않은 카테고리입니다");
		}
		productDao.updateProduct(productUpdateQuery);
		FileSaveServiceDto fileSaveServiceDto=new FileSaveServiceDto(productUpdateServiceDto);
		fileSaveServiceDto.setReferenceId(productUpdateQuery.getProductId().toString());
		
		FilesUseYnUpdateQuery filesUseYnUpdateQuery=new FilesUseYnUpdateQuery();
		filesUseYnUpdateQuery.setUseYn("N");
		filesUseYnUpdateQuery.setReferenceId(productUpdateQuery.getProductId().toString());
		filesUseYnUpdateQuery.setReferenceType(CommonEnum.FileReferenceType.PRODUCT_IMG.name());
		fileDao.updateAllFilesUseYnByReferenceId(filesUseYnUpdateQuery);
		return fileService.saveImgFile(fileSaveServiceDto);
	}

}
