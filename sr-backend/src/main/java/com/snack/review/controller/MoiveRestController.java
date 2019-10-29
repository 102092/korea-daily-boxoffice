package com.snack.review.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snack.review.model.movie.BoxOfficeResult;
import com.snack.review.model.movie.DailyBoxOfficeList;
import com.snack.review.model.movie.Movie;

@RestController
@RequestMapping("/movies")
public class MoiveRestController {

	@Value("${api.kobis.key}")
	private String apiKey;

	@Value("${api.kobis.url}")
	private String apiUrl;

	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = new GregorianCalendar(Locale.KOREA);
	Movie movie = new Movie();
	
	@GetMapping(path = "/test")
	public Object callAPI() throws JsonProcessingException {
//		System.out.println(apiKey);
//		System.out.println(apiUrl);
		cal.add(Calendar.DATE, -1);
		String y_date = format.format(cal.getTime());
//		System.out.println(y_date);
		HashMap<String, Object> result = new HashMap<String, Object>();

		String jsonInString = "";
//		try {
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			factory.setConnectTimeout(5000); // 타임아웃 설정 5초
			factory.setReadTimeout(5000);// 타임아웃 설정 5초
			RestTemplate restTemplate = new RestTemplate(factory);

			HttpHeaders header = new HttpHeaders();
			HttpEntity<?> entity = new HttpEntity<>(header);

			UriComponents uri = UriComponentsBuilder.fromHttpUrl(apiUrl + "?" + "key=" + apiKey + "&targetDt=" + y_date)
					.build();

//			 이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
			ResponseEntity<Movie> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Movie.class);
//			result.put("statusCode", resultMap.getStatusCodeValue()); // http status code를 확인
//			result.put("header", resultMap.getHeaders()); // 헤더 정보 확인
//			result.put("body", resultMap.getBody()); // 실제 데이터 정보 확인

			// 데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
			ObjectMapper mapper = new ObjectMapper();
			jsonInString = mapper.writeValueAsString(resultMap.getBody().equals(BoxOfficeResult.class));

			
			

//		} catch (HttpClientErrorException |
//
//				HttpServerErrorException e) {
//			result.put("statusCode", e.getRawStatusCode());
//			result.put("body", e.getStatusText());
//			System.out.println(e.toString());
//
//		} catch (Exception e) {
//			result.put("statusCode", "999");
//			result.put("body", "excpetion오류");
//			System.out.println(e.toString());
//		}

		return resultMap.getBody();
	}
}
