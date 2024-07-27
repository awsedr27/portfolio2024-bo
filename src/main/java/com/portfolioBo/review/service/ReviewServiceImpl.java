package com.portfolioBo.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolioBo.category.dto.CategoryDto;
import com.portfolioBo.exception.CustomException;
import com.portfolioBo.product.dto.ProductDto;
import com.portfolioBo.product.dto.ProductDto.ProductUpdateQuery;
import com.portfolioBo.review.dao.ReviewDao;
import com.portfolioBo.review.dto.ReviewDto;
import com.portfolioBo.review.dto.ReviewDto.ReviewListCntQuery;
import com.portfolioBo.review.dto.ReviewDto.ReviewListQuery;
import com.portfolioBo.review.dto.ReviewDto.ReviewUpdateQuery;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewListServiceDto;
import com.portfolioBo.review.dto.ReviewServiceDto.ReviewUpdateServiceDto;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;

	@Override
	public List<ReviewDto> getReviewList(ReviewListServiceDto reviewListServiceDto) {
		ReviewListQuery reviewListQuery=new ReviewListQuery(reviewListServiceDto);
		int listCnt=reviewDao.selectReviewListCnt(new ReviewListCntQuery(reviewListServiceDto));
		reviewListQuery.getPaging().setTotalRecordCount(listCnt);
		return reviewDao.selectReviewList(reviewListQuery);
	}

	@Override
	public ReviewDto getReviewDetail(Integer reviewId) {
		return reviewDao.selectReview(reviewId);
	}

	@Override
	public int updateReview(ReviewUpdateServiceDto reviewUpdateServiceDto) {
		ReviewDto review=reviewDao.selectReview(reviewUpdateServiceDto.getReviewId());
		if(review==null) {
			throw new CustomException("유효하지않은 리뷰아이디입니다");
		}
		ReviewUpdateQuery reviewUpdateQuery=new ReviewUpdateQuery(reviewUpdateServiceDto);
		return reviewDao.updateReview(reviewUpdateQuery);
	}

}
