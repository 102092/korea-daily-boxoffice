package com.review.wiki.service.post;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.review.wiki.error.NotFoundException;
import com.review.wiki.model.api.post.Post;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.user.User;
import com.review.wiki.repository.post.PostRepository;
import com.review.wiki.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class PostService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public PostService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Post write(Post post) {
        return save(post);
    }

    @Transactional
    public Post modify(Post post) {
        update(post);
        return post;
    }

    @Transactional(readOnly = true)
    public Optional<Post> findById(Id<Post, Long> postId) {
        checkNotNull(postId, "postId must be provided.");

        return postRepository.findById(postId);
    }

    @Transactional(readOnly = true)
    public List<Post> findAll(Id<User, Long> userId) {
        checkNotNull(userId, "userId must be provided.");

        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(User.class, userId));
        return postRepository.findAll(userId);
    }

    private Post save(Post post) {
        return postRepository.save(post);
    }

    private void update(Post post) {
        postRepository.update(post);
    }

}
