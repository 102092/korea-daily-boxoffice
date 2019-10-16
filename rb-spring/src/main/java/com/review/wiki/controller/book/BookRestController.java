package com.review.wiki.controller.book;


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

import com.review.wiki.model.book.NaverBook;
import com.review.wiki.model.book.NaverBook.Item;

@RestController
@RequestMapping("api")
public class BookRestController {
		
	
	private static final String CLIENT_ID = "bLE2aSGt4XW7qhTwZjkJ";
	private static final String CLIENT_SECRET = "H72K7ES0JW";
	private static final String URL = "https://openapi.naver.com/v1/search/book_adv.json";
    
   
    private HttpEntity<?> headers;
    private RestTemplate template = new RestTemplate();


	@GetMapping(path = "book/{title}")
	public Item findBookByQuery(@PathVariable String title) {
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<>();
        headerMap.add("X-Naver-Client-Id", CLIENT_ID);
        headerMap.add("X-Naver-Client-Secret", CLIENT_SECRET);
        headerMap.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        this.headers = new HttpEntity<>(headerMap);
        String url = URL + "?d_titl=" + title + "&display=10";
        ResponseEntity<NaverBook> responseEntity = template.exchange(url, HttpMethod.GET, headers, NaverBook.class);
        NaverBook body = responseEntity.getBody();
        return body.getItems().get(0); 
	}

}
