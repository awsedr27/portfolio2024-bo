package com.portfolioBo.category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.category.dto.CategoryRequest.CategoryListRequest;
import com.portfolioBo.category.dto.CategoryRequest.CategorySaveRequest;
import com.portfolioBo.category.dto.CategoryRequest.CategoryUpdateRequest;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryListServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategorySaveServiceDto;
import com.portfolioBo.category.dto.CategoryServiceDto.CategoryUpdateServiceDto;
import com.portfolioBo.category.service.CategoryService;
import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductSaveRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductUpdateRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
    @Value("${category.paging.page.size}")
    private int pagingSize;
    
    @Value("${category.paging.pagelist.size}")
    private int pagingListSize;
	
    @GetMapping("/list")
    public String categoryList(Model model,@Valid @ModelAttribute CategoryListRequest categoryListRequest ) {
    	try {
    		CategoryListServiceDto categoryListServiceDto=new CategoryListServiceDto(categoryListRequest);
        	Paging Paging=new Paging(categoryListRequest.getPage(), pagingSize,pagingListSize);
        	categoryListServiceDto.setPaging(Paging);
        	List<CategoryDto> result=categoryService.getCategoryList(categoryListServiceDto);
        	model.addAttribute("categoryList", result);
        	model.addAttribute("paging", Paging);
        	model.addAttribute("search", categoryListRequest);
            return "/category/list"; 
    	}catch(Exception e) {
    		log.error("카테고리 목록을 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "카테고리 목록을 불러오는데 실패했습니다");
    		return "/error";
    	}

    }
    
    @GetMapping("/detail")
    public String categoryDetail(@RequestParam(value = "categoryId", required = false) Integer categoryId, Model model) {
    	try {
            if (categoryId != null) {
            	CategoryDto category=categoryService.getCategory(categoryId);
            	model.addAttribute("category", category);
            }else {
                model.addAttribute("category", new CategoryDto());	//상품 등록 시 
            }
            return "/category/detail";
    	}catch(Exception e) {
    		log.error("카테고리 정보를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "카테고리 정보를 불러오는데 실패했습니다");
    		return "/error";
    	}
    }
    
    @PostMapping("/save")
    public String categorySave(@Valid @ModelAttribute CategorySaveRequest categorySaveRequest, Model model) {
    	try {
    		CategorySaveServiceDto categorySaveServiceDto=new CategorySaveServiceDto(categorySaveRequest);
    		int result=categoryService.saveCategory(categorySaveServiceDto);
            return "redirect:/category/list";
    	}catch(Exception e) {
    		log.error("카테고리 등록에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "카테고리 등록에 실패했습니다");
    		return "/error";
    	}
    }
    
    @PostMapping("/update")
    public String categoryUpdate(@Valid @ModelAttribute CategoryUpdateRequest categoryUpdateRequest, Model model) {
    	try {
    		CategoryUpdateServiceDto categoryUpdateServiceDto=new CategoryUpdateServiceDto(categoryUpdateRequest);
    		int result=categoryService.updateProduct(categoryUpdateServiceDto);
            return "redirect:/category/list";
    	}catch(Exception e) {
    		log.error("카테고리 수정에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "카테고리 수정에 실패했습니다");
    		return "/error";
    	}
    }
}
