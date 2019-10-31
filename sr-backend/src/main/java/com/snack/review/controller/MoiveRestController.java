package com.snack.review.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.snack.review.model.movie.KobisMovie;


@RestController
@RequestMapping("/movies")
public class MoiveRestController {

	@Value("${api.kobis.key}")
	private String kobisKey;

	@Value("${api.kobis.daily-url}")
	private String kobisDailyUrl;

	@Value("${api.kobis.info-url}")
	private String kobisInfoUrl;

	@Value("${api.tmdb.key}")
	private String tmdbKey;

	@Value("${api.tmdb.search-url}")
	private String tmdbSearch;

	@Value("${api.tmdb.poster-url}")
	private String tmdbPoster;

	@GetMapping(path = "/dailyBoxOffice")
	public KobisMovie getDailyBoxOffice(@RequestParam(value = "targetDt") String targetDt,
			@RequestParam(value = "repNationCd") String repNationCd) {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder.fromHttpUrl(
				kobisDailyUrl + "?" + "key=" + kobisKey + "&targetDt=" + targetDt + "&repNationCd=" + repNationCd)
				.build();
		System.out.println(uri.toString());

		ResponseEntity<KobisMovie> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity,
				KobisMovie.class);
		return resultMap.getBody();
	}

	@GetMapping(path = "/movieInfo")
	public Object getMovieInfo(@RequestParam(value = "movieCd") String movieCd) {

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl(kobisInfoUrl + "?" + "key=" + kobisKey + "&movieCd=" + movieCd).build();

		ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
		return resultMap.getBody();

	}

	@GetMapping(path = "/tmdbPoster")
	public Object getPoster(
			@RequestParam(value = "language") String language,
			@RequestParam(value = "query") String query, 
			@RequestParam(value = "year") String year) {

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl(tmdbSearch + "?" + "api_key=" + tmdbKey + "&query=" + query + "&year=" + year).build();
		ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
		return resultMap.getBody();

	}

}
