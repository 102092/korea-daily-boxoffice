package com.review.wiki.repository.book;

import java.util.Optional;

import com.review.wiki.model.book.NaverBook;

public interface BookRepository {
	Optional<NaverBook> findBookByQuery(String query);
}
