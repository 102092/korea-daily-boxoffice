package com.review.wiki;

import com.review.wiki.ReviewsVO;

import java.util.List;
import java.util.Optional;

public interface ReviewsRepository {
	
	int count();

    int save(ReviewsVO ReviewsVO);

    List<ReviewsVO> findAll();


    
}
