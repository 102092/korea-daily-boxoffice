package com.review.wiki.model.api.request.post;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.review.wiki.model.api.post.Post;
import com.review.wiki.model.api.post.Writer;
import com.review.wiki.model.commons.Id;
import com.review.wiki.model.user.User;

public class PostingRequest {

    private String contents;

    protected PostingRequest() {}

    public String getContents() {
        return contents;
    }

    public Post newPost(Id<User, Long> userId, Writer writer) {
        return new Post(userId, writer, contents);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("contents", contents)
                .toString();
    }

}
