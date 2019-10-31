package com.snack.review.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.snack.review.model.api.API;

@Configuration
public class ServiceConfigure {

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

	@Bean
	public API api() {
		return new API(kobisKey, kobisDailyUrl, kobisInfoUrl, tmdbKey, tmdbSearch, tmdbPoster);

	}

}
