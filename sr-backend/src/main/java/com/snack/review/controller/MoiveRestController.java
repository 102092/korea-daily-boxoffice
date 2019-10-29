package com.snack.review.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.snack.review.model.movie.DailyBoxOfficeList;
import com.snack.review.model.movie.KobisMovie;

@RestController
@RequestMapping("/movies")
public class MoiveRestController {

	@Value("${api.kobis.key}")
	private String kobisKey;

	@Value("${api.kobis.url}")
	private String kobisUrl;

	@Value("${api.tmbd.key}")
	private String tmbdKey;

	@Value("${api.tmbd.search-url}")
	private String tmbdSearch;

	@Value("${api.tmbd.poster-url}")
	private String tmbdPoster;

	DailyBoxOfficeList dailyBoxOfficeList = new DailyBoxOfficeList();

	@GetMapping(path = "/dailyBoxOffice")
	public List<DailyBoxOfficeList> getDailyBoxOffice() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = new GregorianCalendar(Locale.KOREA);
		cal.add(Calendar.DATE, -1);

		String y_date = format.format(cal.getTime());
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder.fromHttpUrl(kobisUrl + "?" + "key=" + kobisKey + "&targetDt=" + y_date)
				.build();

		ResponseEntity<KobisMovie> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity,
				KobisMovie.class);
		KobisMovie MovieBody = resultMap.getBody();
		dailyBoxOfficeList = MovieBody.getBoxOfficeResult().getDailyBoxOfficeList().get(1);
		return MovieBody.getBoxOfficeResult().getDailyBoxOfficeList();
	}

	@GetMapping(path = "/test")
	public Object test() {

		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder
				.fromHttpUrl(tmbdSearch + "?" + "api_key=" + tmbdKey + "&language=" + "ko-KR" + "&query="
						+ dailyBoxOfficeList.getMovieNm() + "&year=" + dailyBoxOfficeList.getOpenDt().substring(0, 4))
				.build();

		ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);

		return resultMap.getBody().get("results");
	}

}
