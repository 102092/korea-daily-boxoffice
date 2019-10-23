package com.review.wiki.service.post;


import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.post.Writer;
import com.review.wiki.model.user.Email;
import com.review.wiki.model.user.User;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostServiceTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired 
    private PostService postService;
    
    private Id<Post, Long> postId;
    
    private Id<User, Long> writerId;

    private Id<User, Long> userId;

    @BeforeAll
    void setUp() {
        postId = Id.of(Post.class,1L);
        writerId = Id.of(User.class,1L);
        userId = Id.of(User.class,2L);
    }

    @Test
    @Order(1)
    void 포스트를_작성한다() {
        Writer writer = new Writer(new Email("test00@gmail.com"), "test");
        String contents = randomAlphabetic(40);
        Post post = postService.write(new Post(writerId, writer, contents));
        assertThat(post, is(notNullValue()));
        assertThat(post.getSeq(), is(notNullValue()));
        assertThat(post.getContents(), is(contents));
        log.info("Written post: {}", post);
    }

    @Test
    @Order(2)
    void 포스트를_수정한다() {
        Post post = postService.findById(postId, writerId, userId).orElse(null);
        assertThat(post, is(notNullValue()));
        String contents = randomAlphabetic(40);
        post.modify(contents);
        postService.modify(post);
        assertThat(post.getContents(), is(contents));
        log.info("Modified post: {}", post);
    }

    @Test
    @Order(3)
    void 포스트_목록을_조회한다() {
        List<Post> posts = postService.findAll(writerId, userId, 0, 20);
        assertThat(posts, is(notNullValue()));
        assertThat(posts.size(), is(4));
    }
    
    @Test
    @Order(4)
    void 포스트를_삭제한다() {
        Post post = postService.findById(postId, writerId, userId).orElse(null);
        assertThat(post, is(notNullValue()));
    	postService.remove(post);
        List<Post> posts = postService.findAll(writerId, userId, 0, 20);
        assertThat(posts.size(), is(3));
    	
    }
}