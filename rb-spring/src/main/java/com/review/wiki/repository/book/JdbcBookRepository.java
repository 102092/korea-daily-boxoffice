package com.review.wiki.repository.book;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.review.wiki.model.book.NaverBook;

@Repository
public class JdbcBookRepository implements BookRepository {

	@Override
	public Optional<NaverBook> findBookByQuery(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
