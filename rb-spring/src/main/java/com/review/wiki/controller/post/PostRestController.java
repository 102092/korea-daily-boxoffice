package com.review.wiki.controller.post;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import com.review.wiki.configure.support.Pageable;
import com.review.wiki.error.NotFoundException;
import com.review.wiki.model.api.request.post.CommentRequest;
import com.review.wiki.model.api.request.post.PostingRequest;
import com.review.wiki.model.api.response.ApiResult;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Comment;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.post.Writer;
import com.review.wiki.model.user.User;
import com.review.wiki.security.JwtAuthentication;
import com.review.wiki.service.post.CommentService;
import com.review.wiki.service.post.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import static com.review.wiki.model.api.response.ApiResult.OK;


@RestController
@RequestMapping("api")
@Api(tags = "포스팅 APIs")
public class PostRestController {
	
    private final PostService postService;
    
    private final CommentService commentService;

    public PostRestController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @PostMapping(path = "post")
    @ApiOperation(value = "포스트 작성")
    public ApiResult<Post> posting(@AuthenticationPrincipal JwtAuthentication authentication,
                                   @RequestBody PostingRequest request) {
        return OK(postService.write(request.newPost(authentication.id, new Writer(authentication.email))));
    }

    @GetMapping(path = "user/{userId}/post/list")
    @ApiOperation(value = "포스트 목록 조회")
    public ApiResult<List<Post>> posts(
    		@AuthenticationPrincipal JwtAuthentication authentication,
    		@ApiParam(value = "조회대상자 PK (본인 또는 친구)", example = "userId : 1")
    		@PathVariable Long userId,
    		Pageable pageable) {
        return OK(postService.findAll(Id.of(User.class, userId), authentication.id, pageable.offset(), pageable.limit()));
    }
    
   @PostMapping(path = "user/{userId}/post/{postId}/like")
   @ApiOperation(value = "포스트 좋아요")
   public ApiResult<Post> Like(
		   @AuthenticationPrincipal JwtAuthentication authentication,
		   @ApiParam(value = "조회대상자 PK (본인 또는 친구)", example = "userId : 1")
   		   @PathVariable Long userId,
		   @ApiParam(value = "대상포스트 PK (본인 또는 친구)", example = "postId : 1")
   		   @PathVariable Long postId,
   		   @RequestBody CommentRequest request
		   ){
	   return OK(postService.like(
			   Id.of(Post.class, postId),
			   Id.of(User.class, userId),
			   authentication.id
			   ).orElseThrow(() -> new NotFoundException(Post.class, Id.of(Post.class, postId), Id.of(User.class, userId))));
   }
   
   
   @PostMapping(path = "user/{userId}/post/{postId}/comment")
   public ApiResult<Comment> comment(
           @AuthenticationPrincipal JwtAuthentication authentication,
           @PathVariable
           @ApiParam(value = "조회대상자 PK (본인 또는 친구)", example = "userId : 1")
           Long userId,
           @PathVariable
           @ApiParam(value = "대상 포스트 PK", example = "postId : 1")
           Long postId,
           @RequestBody CommentRequest request
   ) {
       return OK(commentService.write(
               Id.of(Post.class, postId),
               Id.of(User.class, userId),
               authentication.id,
               request.newComment(authentication.id, Id.of(Post.class, postId), new Writer(authentication.email, authentication.name))
       ));
   }
   
   @GetMapping(path = "user/{userId}/post/{postId}/comment/list")
   public ApiResult<List<Comment>> comments(
           @AuthenticationPrincipal JwtAuthentication authentication,
           @PathVariable
           @ApiParam(value = "조회대상자 PK (본인 또는 친구)", example = "userId : 1")
           Long userId,
           @PathVariable
           @ApiParam(value = "대상 포스트 PK", example = "postId: 1")
           Long postId
   ) {
       return OK(commentService.findAll(
               Id.of(Post.class, postId),
               Id.of(User.class, userId),
               authentication.id
       ));
   }


}
