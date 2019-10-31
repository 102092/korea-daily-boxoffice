package com.snack.review.service.movie;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.snack.review.model.api.API;
import com.snack.review.model.movie.DailyBoxOfficeList;
import com.snack.review.model.movie.KobisMovie;

@Service
public class MovieService {

	private Logger log = LoggerFactory.getLogger(getClass());

//	@Value("${api.kobis.key}")
//	private String kobisKey;
//
//	@Value("${api.kobis.daily-url}")
//	private String kobisDailyUrl;
//
//	@Value("${api.kobis.info-url}")
//	private String kobisInfoUrl;
//
//	@Value("${api.tmbd.key}")
//	private String tmbdKey;
//
//	@Value("${api.tmbd.search-url}")
//	private String tmbdSearch;
//
//	@Value("${api.tmbd.poster-url}")
//	private String tmbdPoster;

	@Autowired
	private final API api;

	public MovieService(API api) {
		this.api = api;
	}

	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = new GregorianCalendar(Locale.KOREA);
//	cal.add(Calendar.DATE, -1);

	public List<DailyBoxOfficeList> getDailyBoxOffice() {

		String y_date = format.format(cal.getTime());
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(5000);
		factory.setReadTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(factory);

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder.fromHttpUrl(api.getKobisDailyUrl() + "?" + "key=" + api.getKobisKey()
				+ "&targetDt=" + y_date + "&repNationCd=" + "K").build();

		ResponseEntity<KobisMovie> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity,
				KobisMovie.class);

		return resultMap.getBody().getBoxOfficeResult().getDailyBoxOfficeList();
	}

}
