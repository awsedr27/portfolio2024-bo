package com.portfolioBo.review.service;

import java.util.List;

import com.portfolioBo.review.dto.ReviewDto;
import com.portfolioBo.review.dto.ReviewDto.ReviewDetailResult;
import com.portfolioBo.review.dto.ReviewDto.ReviewListResult;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewListServiceDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewUpdateServiceDto;

public interface ReviewService {

	List<ReviewListResult> getReviewList(ReviewListServiceDto reviewListServiceDto);

	ReviewDetailResult getReviewDetail(Integer reviewId);

	int updateReview(ReviewUpdateServiceDto reviewReplySaveServiceDto);

}
