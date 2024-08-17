package com.portfolioBo.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.category.service.CategoryService;
import com.portfolioBo.common.Paging;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductDetailResult;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductSaveRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductUpdateRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductSaveServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;
import com.portfolioBo.product.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
    @Value("${product.paging.page.size}")
    private int pagingSize;
    
    @Value("${product.paging.pagelist.size}")
    private int pagingListSize;

    @GetMapping("/list")
    public String list(Model model,@Valid @ModelAttribute ProductListRequest productListRequest) {
    	try {
        	ProductListServiceDto productListServiceDto=new ProductListServiceDto(productListRequest);
        	Paging Paging=new Paging(productListRequest.getPage(), pagingSize,pagingListSize);
        	productListServiceDto.setPaging(Paging);
        	List<ProductDto> result=productService.getProductList(productListServiceDto);
        	model.addAttribute("product", result);
        	model.addAttribute("paging", Paging);
        	model.addAttribute("search", productListRequest);
            return "/product/list"; 
    	}catch(Exception e) {
    		log.error("상품목록을 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "상품목록을 불러오는데 실패했습니다");
    		return "/error";
    	}

    }
    
    @GetMapping("/detail")
    public String productDetail(@RequestParam(value = "productId", required = false) Integer productId, Model model) {
    	try {
        	List<ActiveCategoryListResult> categoryList=categoryService.getActiveCategoryList();
        	model.addAttribute("categories", categoryList);
            if (productId != null) {
            	ProductDetailResult product=productService.getProductDetail(productId); //상품 수정 시
            	model.addAttribute("product", product);
            }else {
                model.addAttribute("product", new ProductDetailResult());	//상품 등록 시 
            }
            return "/product/detail";
    	}catch(Exception e) {
    		log.error("상품정보를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "상품정보를 불러오는데 실패했습니다");
    		return "/error";
    	}
    }
    
    @PostMapping("/save")
    public String productSave(@Valid @ModelAttribute ProductSaveRequest productSaveRequest, Model model) {
    	try {
    		ProductSaveServiceDto productSaveServiceDto=new ProductSaveServiceDto(productSaveRequest);
    		boolean result=productService.saveProduct(productSaveServiceDto);
            return "redirect:/product/list";
    	}catch(Exception e) {
    		log.error("상품등록에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "상품등록에 실패했습니다");
    		return "/error";
    	}
    }
    
    @PostMapping("/update")
    public String productUpdate(@Valid @ModelAttribute ProductUpdateRequest productUpdateRequest, Model model) {
    	try {
    		ProductUpdateServiceDto productSaveServiceDto=new ProductUpdateServiceDto(productUpdateRequest);
    		boolean result=productService.updateProduct(productSaveServiceDto);
            return "redirect:/product/list";
    	}catch(Exception e) {
    		log.error("상품수정에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "상품수정에 실패했습니다");
    		return "/error";
    	}
    }
    
}
