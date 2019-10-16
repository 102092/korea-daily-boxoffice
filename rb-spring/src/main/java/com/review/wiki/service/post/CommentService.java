package com.review.wiki.service.post;

import com.review.wiki.error.NotFoundException;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Comment;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.user.User;
import com.review.wiki.repository.post.CommentRepository;
import com.review.wiki.repository.post.PostRepository;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Collections.emptyList;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {

	private final PostRepository postRepository;

	private final CommentRepository commentRepository;

	public CommentService(PostRepository postRepository, CommentRepository commentRepository) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}

	@Transactional
	public Comment write(Id<Post, Long> postId, Id<User, Long> postWriterId, Id<User, Long> userId, Comment comment) {
		checkArgument(comment.getPostId().equals(postId), "comment.postId must equals postId");
		checkArgument(comment.getUserId().equals(userId), "comment.userId must equals userId");
		checkNotNull(comment, "comment must be provided.");

		return findPost(postId, postWriterId, userId).map(post -> {
			post.incrementAngGetComments();
			postRepository.update(post);

			return save(comment);
		}).orElseThrow(() -> new NotFoundException(Post.class, postId, userId));
	}

	@Transactional(readOnly = true)
	public List<Comment> findAll(Id<Post, Long> postId, Id<User, Long> postWriterId, Id<User, Long> userId) {
		return findPost(postId, postWriterId, userId)
				.map(post -> commentRepository.findAll(postId))
				.orElse(emptyList());
	}

	private Optional<Post> findPost(Id<Post, Long> postId, Id<User, Long> postWriterId, Id<User, Long> userId) {
		checkNotNull(postId, "postId must be provided.");
		checkNotNull(postWriterId, "postWriterId must be provided.");
		checkNotNull(userId, "userId must be provided.");

		return postRepository.findById(postId, postWriterId, userId);
	}

	private Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@SuppressWarnings("unused")
	private void update(Comment comment) {
		commentRepository.update(comment);
	}

}
