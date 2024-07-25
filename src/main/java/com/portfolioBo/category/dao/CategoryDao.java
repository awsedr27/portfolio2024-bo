package com.portfolioBo.category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.category.dto.CategoryDto.CategoryListCntQuery;
import com.portfolioBo.category.dto.CategoryDto.CategoryListQuery;
import com.portfolioBo.category.dto.CategoryDto.CategorySaveQuery;
import com.portfolioBo.category.dto.CategoryDto.CategoryUpdateQuery;

@Mapper
public interface CategoryDao {
	
	List<ActiveCategoryListResult> selectActiveCategoryList();

	CategoryDto selectActiveCategory(Integer categoryId);
	
	int selectCategoryListCnt(CategoryListCntQuery categoryListCntQuery);
	
	List<CategoryDto> selectCategoryList(CategoryListQuery categoryListQuery);

	CategoryDto selectCategory(Integer cateogryId);

	int insertCategory(CategorySaveQuery categorySaveQuery);

	int updateCategory(CategoryUpdateQuery categoryUpdateQuery);

}
