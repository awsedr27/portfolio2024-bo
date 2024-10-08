package com.portfolioBo.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolioBo.review.dto.ReviewDto;
import com.portfolioBo.review.dto.ReviewDto.ReviewDetailResult;
import com.portfolioBo.review.dto.ReviewDto.ReviewListCntQuery;
import com.portfolioBo.review.dto.ReviewDto.ReviewListQuery;
import com.portfolioBo.review.dto.ReviewDto.ReviewListResult;
import com.portfolioBo.review.dto.ReviewDto.ReviewUpdateQuery;

@Mapper
public interface ReviewDao {

	int selectReviewListCnt(ReviewListCntQuery reviewListCntQuery);

	List<ReviewListResult> selectReviewList(ReviewListQuery reviewListQuery);

	ReviewDto selectReview(Integer reviewId);
	
	ReviewDetailResult selectReviewDetail(Integer reviewId);

	int updateReview(ReviewUpdateQuery reviewUpdateQuery);

}
