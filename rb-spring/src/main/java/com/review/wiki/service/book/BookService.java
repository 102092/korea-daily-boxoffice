package com.review.wiki.service.book;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.review.wiki.model.book.Book;
import com.review.wiki.model.book.Book.Item;
import com.review.wiki.repository.book.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<Book> findByTitl(String title){
		
		return bookRepository.findBytitl(title);
		
	}
	
	@Transactional(readOnly = true)
	public Item write(Item item) {
		return save(item);
	}
	
	
	private Item save (Item item) {
		return bookRepository.save(item);
	}

}
