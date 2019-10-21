package com.review.wiki.controller.book;



import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.review.wiki.model.book.Book;
import com.review.wiki.model.book.Book.Item;
import com.review.wiki.service.book.BookService;

@RestController
@RequestMapping("api")
public class BookRestController {

	private final BookService bookService;

	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	private static final String CLIENT_ID = "bLE2aSGt4XW7qhTwZjkJ";
	private static final String CLIENT_SECRET = "H72K7ES0JW";
	private static final String URL = "https://openapi.naver.com/v1/search/book_adv.json";

	private HttpEntity<?> headers;
	private RestTemplate template = new RestTemplate();

	@GetMapping(path = "book/{title}")
	public List<Item> findBookByAPI(@PathVariable String title) {
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
		headerMap.add("X-Naver-Client-Id", CLIENT_ID);
		headerMap.add("X-Naver-Client-Secret", CLIENT_SECRET);
		headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		this.headers = new HttpEntity<>(headerMap);
		String url = URL + "?d_titl=" + title + "&display=100";
		ResponseEntity<Book> responseEntity = template.exchange(url, HttpMethod.GET, headers, Book.class);
		Book book = responseEntity.getBody();
		return book.getItems();
		
	}
	
	@GetMapping(path = "book/{title}/{number}")
	public Item bookCreate(@PathVariable String title, 
			@PathVariable Integer number){
		MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
		headerMap.add("X-Naver-Client-Id", CLIENT_ID);
		headerMap.add("X-Naver-Client-Secret", CLIENT_SECRET);
		headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		this.headers = new HttpEntity<>(headerMap);
		String url = URL + "?d_titl=" + title + "&display=100";
		ResponseEntity<Book> responseEntity = template.exchange(url, HttpMethod.GET, headers, Book.class);
		Book book = responseEntity.getBody();
		
		return bookService.write(book.getItems().get(number));
		
	}


}
