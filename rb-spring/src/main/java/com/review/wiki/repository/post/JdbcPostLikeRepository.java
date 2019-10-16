package com.review.wiki.repository.post;

import java.sql.PreparedStatement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.user.User;

@Repository
public class JdbcPostLikeRepository implements PostLikeRepository {

	private final JdbcTemplate jdbcTemplate;

	public JdbcPostLikeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void like(Id<User, Long> userId, Id<Post, Long> postId) {
		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO likes(seq,user_seq,post_seq) VALUES (null,?,?)");
			ps.setLong(1, userId.value());
			ps.setLong(2, postId.value());
			return ps;
		});

	}

}
