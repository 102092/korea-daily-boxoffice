package com.review.wiki.controller.post;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.review.wiki.configure.support.Pageable;
import com.review.wiki.model.api.request.post.PostingRequest;
import com.review.wiki.model.api.response.ApiResult;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.post.Writer;
import com.review.wiki.model.user.User;
import com.review.wiki.security.JwtAuthentication;
import com.review.wiki.service.post.PostService;

import java.util.List;

import static com.review.wiki.model.api.response.ApiResult.OK;


@RestController
@RequestMapping("api")
public class PostRestController {
	
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "post")
    public ApiResult<Post> posting(@AuthenticationPrincipal JwtAuthentication authentication,
                                   @RequestBody PostingRequest request) {
        return OK(postService.write(request.newPost(authentication.id, new Writer(authentication.email))));
    }

    @GetMapping(path = "user/{userId}/post/list")
    public ApiResult<List<Post>> posts(
    		@AuthenticationPrincipal JwtAuthentication authentication,
    		@PathVariable Long userId, Pageable pageable) {
        return OK(postService.findAll(Id.of(User.class, userId), authentication.id, pageable.offset(), pageable.limit()));
    }


}
