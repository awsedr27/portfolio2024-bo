package com.portfolioBo.review.service;

import java.util.List;

import com.portfolioBo.review.dto.ReviewDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewListServiceDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewUpdateServiceDto;

public interface ReviewService {

	List<ReviewDto> getReviewList(ReviewListServiceDto reviewListServiceDto);

	ReviewDto getReviewDetail(Integer reviewId);

	int updateReview(ReviewUpdateServiceDto reviewReplySaveServiceDto);

}
