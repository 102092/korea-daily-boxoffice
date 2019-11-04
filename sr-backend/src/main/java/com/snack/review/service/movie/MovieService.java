package com.snack.review.service.movie;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.snack.review.model.movie.KobisMovie;

@Service
public class MovieService {

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

	private final RestTemplate restTemplate;

	public MovieService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	HttpHeaders httpHeaders = new HttpHeaders();
	HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

	public KobisMovie getDailyBoxOffice(String targetDt, String repNationCd) {

		UriComponents builder = UriComponentsBuilder.fromHttpUrl(
				kobisDailyUrl + "?" + "key=" + kobisKey + "&targetDt=" + targetDt + "&repNationCd=" + repNationCd)
				.build();
		ResponseEntity<KobisMovie> dailyBoxOffice = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				httpEntity, KobisMovie.class);

		return dailyBoxOffice.getBody();
	}

	public Object getMovieInfo(String movieCd) {

		UriComponents builder = UriComponentsBuilder
				.fromHttpUrl(kobisInfoUrl + "?" + "key=" + kobisKey + "&movieCd=" + movieCd).build();

		ResponseEntity<Map> movieInfo = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity,
				Map.class);
		return movieInfo.getBody();

	}

	public Object getPoster(String language, String query, String year) {

		UriComponents builder = UriComponentsBuilder
				.fromHttpUrl(tmdbSearch + "?" + "api_key=" + tmdbKey + "&query=" + query + "&year=" + year).build();

		ResponseEntity<Map> tmdbPoster = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, httpEntity,
				Map.class);
		return tmdbPoster.getBody();

	}

}
