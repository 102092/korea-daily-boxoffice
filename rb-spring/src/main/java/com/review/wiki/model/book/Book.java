package com.review.wiki.model.book;

import java.time.LocalDateTime;
import java.util.List;

public class Book {

	private String lastBuildDate;
	private int total;
	private int start;
	private int display;
	private List<Item> items;

	public String getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(String lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	static public class Item {
		private Long seq;
		private String title;
		private String link;
		private String image;
		private String author;
		private String price;
		private String discount;
		private String publisher;
		private String pubdate;
		private String isbn;
		private String description;
		private LocalDateTime createAt;

		public Item() {}

		public Item(Long seq, String title, String link, String image, String author, String price, String discount,
				String publisher, String pubdate, String isbn, String description, LocalDateTime createAt) {

			this.seq = seq;
			this.title = title;
			this.link = link;
			this.image = image;
			this.author = author;
			this.price = price;
			this.discount = discount;
			this.publisher = publisher;
			this.pubdate = pubdate;
			this.isbn = isbn;
			this.description = description;
			this.createAt = createAt;
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

		public String getImage() {
			return image;
		}

		public String getAuthor() {
			return author;
		}

		public String getPrice() {
			return price;
		}

		public String getDiscount() {
			return discount;
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

		static public class Builder {
			private Long seq;
			private String title;
			private String link;
			private String image;
			private String author;
			private String price;
			private String discount;
			private String publisher;
			private String pubdate;
			private String isbn;
			private String description;
			private LocalDateTime createAt;

			public Builder() {
			}

			public Builder(Item item) {
				this.seq = item.seq;
				this.title = item.title;
				this.link = item.link;
				this.image = item.image;
				this.author = item.author;
				this.price = item.price;
				this.discount = item.discount;
				this.publisher = item.publisher;
				this.pubdate = item.pubdate;
				this.isbn = item.isbn;
				this.description = item.description;
				this.createAt = item.createAt;
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

			public Builder image(String image) {
				this.image = image;
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

			public Builder discount(String discount) {
				this.discount = discount;
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

			public Item build() {
				return new Item(seq, title, link, image, author, price, discount, publisher, pubdate, isbn, description,
						createAt);
			}
		}
	}

}
