package com.review.wiki.repository.post;

import java.util.List;
import java.util.Optional;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Comment;
import com.review.wiki.model.post.Post;

public interface CommentRepository {

	Comment save(Comment comment);

	void update(Comment comment);

	Optional<Comment> findById(Long seq);

	List<Comment> findAll(Id<Post, Long> postId);

}
