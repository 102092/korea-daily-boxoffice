package com.review.wiki.model.book;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.time.LocalDateTime;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Book {
	
	private final Long seq;
	 
	private final String title;

	private final String link;

	private final String imageUrl;

	private final String author;

	private final String price;

	private final String publisher;

	private final String pubdate;

	private final String isbn;

	private final String description;
	
	private final LocalDateTime createAt;

	public Book(Long seq, String title, String link, String imageUrl, String author, String price,
			String publisher, String pubdate, String isbn, String description, LocalDateTime createAt) {
		this.seq = seq;
		this.title = title;
		this.link = link;
		this.imageUrl = imageUrl;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.pubdate = pubdate;
		this.isbn = isbn;
		this.description = description;
		this.createAt = defaultIfNull(createAt, now());
	}

	public Long getSeq() {
		return seq;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getimageUrl() {
		return imageUrl;
	}

	public String getAuthor() {
		return author;
	}

	public String getPrice() {
		return price;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public String getPubdate() {
		return pubdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(seq, book.seq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seq);
    }

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("seq", seq)
				.append("title", title)
				.append("link", link)
				.append("imageUrl", imageUrl)
				.append("author", author)
				.append("price", price)
				.append("publisher", publisher)
				.append("pubdate", pubdate)
				.append("isbn", isbn)
				.append("description", description)
				.append("createAt", createAt)
				.toString();
	}
	
    static public class Builder {
    	private Long seq;
    	private String title;
    	private String link;
    	private String imageUrl;
    	private String author;
    	private String price;
    	private String publisher;
    	private String pubdate;
    	private String isbn;
    	private String description;
    	private LocalDateTime createAt;

        public Builder() {}

        public Builder(Book book) {
            this.seq = book.seq;
            this.title = book.title;
            this.link = book.link;
            this.imageUrl = book.imageUrl;
            this.author	= book.author;
            this.price = book.price;
            this.publisher = book.publisher;
            this.pubdate = book.pubdate;
            this.isbn = book.isbn;
            this.description = book.description;
            this.createAt = book.createAt;
         }

        public Builder seq(Long seq) {
            this.seq = seq;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder link(String link) {
            this.link = link;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        public Builder pubdate(String pubdate) {
            this.pubdate = pubdate;
            return this;
        }
        
        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        public Builder createAt(LocalDateTime createAt) {
            this.createAt = createAt;
            return this;
        }


        public Book build() {
            return new Book(seq, title, link, imageUrl, author, price, publisher, pubdate, isbn, description, createAt);
        }
    }

	

}
