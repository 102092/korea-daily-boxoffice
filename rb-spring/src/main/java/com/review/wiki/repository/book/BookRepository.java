package com.review.wiki.repository.book;

import java.util.Optional;

import com.review.wiki.model.book.Book.Item;

public interface BookRepository {

	Optional<Item> findBytitl(String title);

	Item save(Item item);
}
