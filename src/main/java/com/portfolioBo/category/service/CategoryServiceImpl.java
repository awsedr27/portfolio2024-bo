package com.portfolioBo.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.category.dao.CategoryDao;
import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.category.dto.CategoryDto.CategoryListCntQuery;
import com.portfolioBo.category.dto.CategoryDto.CategoryListQuery;
import com.portfolioBo.category.dto.CategoryDto.CategorySaveQuery;
import com.portfolioBo.category.dto.CategoryDto.CategoryUpdateQuery;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryListServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategorySaveServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryUpdateServiceDto;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductSaveQuery;
import com.portfolioBo.product.dto.ProductDto.ProductUpdateQuery;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public List<ActiveCategoryListResult> getActiveCategoryList() throws Exception {
		return categoryDao.selectActiveCategoryList();
	}

	@Override
	public List<CategoryDto> getCategoryList(CategoryListServiceDto categoryListServiceDto) throws Exception {
		CategoryListQuery categoryListQuery=new CategoryListQuery(categoryListServiceDto);
		int listCnt=categoryDao.selectCategoryListCnt(new CategoryListCntQuery(categoryListServiceDto));
		categoryListQuery.getPaging().setTotalRecordCount(listCnt);
		return categoryDao.selectCategoryList(categoryListQuery);
	}

	@Override
	public CategoryDto getCategory(Integer cateogryId) throws Exception {
		return categoryDao.selectCategory(cateogryId);
	}

	@Override
	public int saveCategory(CategorySaveServiceDto categorySaveServiceDto) throws Exception {
		CategorySaveQuery categorySaveQuery=new CategorySaveQuery(categorySaveServiceDto);
		return categoryDao.insertCategory(categorySaveQuery);
	}

	@Override
	public int updateProduct(CategoryUpdateServiceDto categoryUpdateServiceDto)throws Exception {
		CategoryDto category=categoryDao.selectCategory(categoryUpdateServiceDto.getCategoryId());
		if(category==null) {
			throw new CustomException("유효하지않은 카테고리 아이디입니다");
		}
		CategoryUpdateQuery categoryUpdateQuery=new CategoryUpdateQuery(categoryUpdateServiceDto);
		return categoryDao.updateCategory(categoryUpdateQuery);
	}





}
