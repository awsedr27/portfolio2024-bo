package com.portfolioBo.review.controller;

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

import com.portfolioBo.common.Paging;
import com.portfolioBo.review.dto.ReviewDto;
import com.portfolioBo.review.dto.ReviewRequest.ReviewListRequest;
import com.portfolioBo.review.dto.ReviewRequest.ReviewUpdateRequest;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewListServiceDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewUpdateServiceDto;
import com.portfolioBo.review.service.ReviewService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/review")
@Slf4j
public class ReviewController {

    @Value("${review.paging.page.size}")
    private int pagingSize;
    
    @Value("${review.paging.pagelist.size}")
    private int pagingListSize;
    
    @Autowired
    ReviewService reviewService;
    
    @GetMapping("/list")
    public String reviewList(Model model,@Valid @ModelAttribute ReviewListRequest reviewListRequest) {
    	try {
    		ReviewListServiceDto reviewListServiceDto=new ReviewListServiceDto(reviewListRequest);
        	Paging Paging=new Paging(reviewListRequest.getPage(), pagingSize,pagingListSize);
        	reviewListServiceDto.setPaging(Paging);
        	List<ReviewDto> result=reviewService.getReviewList(reviewListServiceDto);
        	model.addAttribute("reviewList", result);
        	model.addAttribute("paging", Paging);
        	model.addAttribute("search", reviewListRequest);
            return "/review/list"; 
    	}catch(Exception e) {
    		log.error("리뷰정보를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "리뷰정보를 불러오는데 실패했습니다");
    		return "/error";
    	}

    }
    @GetMapping("/detail")
    public String reviewDetail(@RequestParam(value = "reviewId", required = true) Integer reviewId, Model model) {
    	try {
            	ReviewDto review=reviewService.getReviewDetail(reviewId); 
            	model.addAttribute("review", review);

            return "/review/detail";
    	}catch(Exception e) {
    		log.error("리뷰 상세를 불러오는데 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "리뷰 상세를 불러오는데 실패했습니다");
    		return "/error";
    	}
    }
    @PostMapping("/update")
    public String reviewUpdate(@Valid @ModelAttribute ReviewUpdateRequest reviewUpdateRequest, Model model) {
    	try {
    		ReviewUpdateServiceDto reviewUpdateServiceDto=new ReviewUpdateServiceDto(reviewUpdateRequest);
    		int result=reviewService.updateReview(reviewUpdateServiceDto);
            return "redirect:/review/list";
    	}catch(Exception e) {
    		log.error("리뷰 수정에 실패했습니다."+e.toString());
    		model.addAttribute("errorMessage", "리뷰 수정에 실패했습니다");
    		return "/error";
    	}
    }
    
    
}
