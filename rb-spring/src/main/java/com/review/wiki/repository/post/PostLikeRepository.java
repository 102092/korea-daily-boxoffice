package com.review.wiki.repository.post;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.user.User;

public interface PostLikeRepository {

	void like(Id<User, Long> userId, Id<Post, Long> postId);

}
