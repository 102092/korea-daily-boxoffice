package com.review.wiki.repository.post;

import java.util.List;
import java.util.Optional;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.user.User;

public interface PostRepository {
	
    Post save(Post post);

    void update(Post post);
    
    void delete(Post post);

    Optional<Post> findById(Id<Post, Long> postId, Id<User, Long> writerId, Id<User, Long> userId);

    List<Post> findAll(Id<User, Long> writerId, Id<User, Long> userId, long offset, int limit);


}
