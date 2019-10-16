package com.review.wiki.service.book;

import org.springframework.stereotype.Service;

import com.review.wiki.repository.book.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	

}
