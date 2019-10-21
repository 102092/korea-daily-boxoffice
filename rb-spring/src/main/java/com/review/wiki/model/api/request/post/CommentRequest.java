package com.review.wiki.model.api.request.post;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.review.wiki.model.commons.Id;
import com.review.wiki.model.post.Comment;
import com.review.wiki.model.post.Post;
import com.review.wiki.model.post.Writer;
import com.review.wiki.model.user.User;

import io.swagger.annotations.ApiModelProperty;

public class CommentRequest {
	
	@ApiModelProperty(value = "내용", required = true)
	private String contents;

	protected CommentRequest() {}

	public String getContents() {
		return contents;
	}

	public Comment newComment(Id<User, Long> userId, Id<Post, Long> postId, Writer writer) {
		return new Comment(userId, postId, writer, contents);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("contents", contents)
				.toString();
	}

}
