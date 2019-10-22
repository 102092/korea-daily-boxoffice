package com.review.wiki.model.api.request.book;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BookRequest {

//	title         varchar(50) NOT NULL,
//	  link          varchar(250) NOT NULL,
//	  image         varchar(250) NOT NULL,
//	  author        varchar(10) NOT NULL,
//	  isbn          varchar(50) NOT NULL,
//	  comment_count int NOT NULL DEFAULT 0,
//	  create_at     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
	
	private String title;
	private String image;
	private String author;
	private String isbn;
	private String comment_count;
	private String create_at;
	
	protected BookRequest() {}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getComment_count() {
		return comment_count;
	}

	public String getCreate_at() {
		return create_at;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("title", title)
				.append("image", image)
				.append("isbn", isbn)
				.append("comment_count", comment_count)
				.append("create_at", create_at)
				.toString();
	};
	
	
	
}
