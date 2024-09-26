package com.portfolioBo.user.controller;

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

import com.portfolioBo.category.dto.CategoryDto.ActiveCategoryListResult;
import com.portfolioBo.common.Paging;
import com.portfolioBo.product.controller.ProductController;
import com.portfolioBo.product.dto.ProductDto.ProductDetailResult;
import com.portfolioBo.product.dto.ProductDto.ProductListResult;
import com.portfolioBo.product.dto.ProductRequest.ProductListRequest;
import com.portfolioBo.product.dto.ProductRequest.ProductUpdateRequest;
import com.portfolioBo.product.dto.ProductServiceDto.ProductListServiceDto;
import com.portfolioBo.product.dto.ProductServiceDto.ProductUpdateServiceDto;
import com.portfolioBo.product.service.ProductService;
import com.portfolioBo.user.dto.UserDto.UserDetailResult;
import com.portfolioBo.user.dto.UserDto.UserListResult;
import com.portfolioBo.user.dto.UserRequest.UserListRequest;
import com.portfolioBo.user.dto.UserRequest.UserUpdateRequest;
import com.portfolioBo.user.dto.UserServiceDto.UserListServiceDto;
import com.portfolioBo.user.dto.UserServiceDto.UserUpdateServiceDto;
import com.portfolioBo.user.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;

    @Value("${user.paging.page.size}")
    private int pagingSize;
    
    @Value("${user.paging.pagelist.size}")
    private int pagingListSize;
    
    @GetMapping("/list")
    public String list(Model model,@Valid @ModelAttribute UserListRequest userListRequest) {
    	try {
        	UserListServiceDto userListServiceDto=new UserListServiceDto(userListRequest);
        	Paging Paging=new Paging(userListRequest.getPage(), pagingSize,pagingListSize);
        	userListServiceDto.setPaging(Paging);
        	List<UserListResult> result=userService.getUserList(userListServiceDto);
        	model.addAttribute("userList", result);
        	model.addAttribute("paging", Paging);
        	model.addAttribute("search", userListRequest);
            return "/user/list"; 
    	}catch(Exception e) {
    		log.error("유저목록을 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "유저목록을 불러오는데 실패했습니다");
    		return "/error";
    	}

    }
    @GetMapping("/detail")
    public String userDetail(@RequestParam(value = "userId", required = false) String userId, Model model) {
    	try {
            	UserDetailResult user=userService.getUserDetail(userId);
            	model.addAttribute("user", user);
            return "/user/detail";
    	}catch(Exception e) {
    		log.error("유저정보를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "유저정보를 불러오는데 실패했습니다");
    		return "/error";
    	}
    }
    @PostMapping("/update")
    public String userUpdate(@Valid @ModelAttribute UserUpdateRequest userUpdateRequest, Model model) {
    	try {
    		UserUpdateServiceDto userUpdateServiceDto=new UserUpdateServiceDto(userUpdateRequest);
    		boolean result=userService.updateUser(userUpdateServiceDto);
            return "redirect:/user/list";
    	}catch(Exception e) {
    		log.error("유저수정에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "유저수정에 실패했습니다");
    		return "/error";
    	}
    }
    
    
}
