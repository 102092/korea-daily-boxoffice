package com.review.wiki;

import com.review.wiki.ReviewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewsRepository implements ReviewsRepository {
	
	// Spring Boot will create and configure DataSource and JdbcTemplate
		// To use it, just @Autowired
	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public int count() {
	        return jdbcTemplate
	                .queryForObject("select count(*) from REVIEWS", Integer.class);
	    }

	    @Override
	    public int save(ReviewsVO ReviewsVO) {
	        return jdbcTemplate.update(
	                "insert into REVIEWS (seq, contents) values(?,?)",
	                ReviewsVO.getSeq(), ReviewsVO.getContents());
	    }



	    @Override
	    public List<ReviewsVO> findAll() {
	        return jdbcTemplate.query(
	                "select * from REVIEWS",
	                (rs, rowNum) ->
	                        new ReviewsVO(
	                                rs.getString("seq"),
	                                rs.getString("contents")
	                        )
	        );
	    }

}
