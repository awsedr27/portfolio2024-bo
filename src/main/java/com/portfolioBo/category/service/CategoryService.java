package com.portfolioBo.category.service;

import java.util.List;

import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryListServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategorySaveServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryUpdateServiceDto;

public interface CategoryService {
	List<ActiveCategoryListResult> getActiveCategoryList()  throws Exception;

	List<CategoryDto> getCategoryList(CategoryListServiceDto categoryListServiceDto)  throws Exception;

	CategoryDto getCategory(Integer cateogryId)  throws Exception;

	int saveCategory(CategorySaveServiceDto categorySaveServiceDto)  throws Exception;

	int updateProduct(CategoryUpdateServiceDto categoryUpdateServiceDto) throws Exception;
}
