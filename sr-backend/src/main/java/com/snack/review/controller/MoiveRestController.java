package com.snack.review.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.snack.review.model.movie.KobisMovie;
import com.snack.review.service.movie.MovieService;

@RestController
@RequestMapping("/movies")
public class MoiveRestController {

	private final MovieService movieService;

	public MoiveRestController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping(path = "/dailyBoxOffice")
	public KobisMovie getDailyBoxOffice(
			@RequestParam(value = "targetDt") String targetDt,
			@RequestParam(value = "repNationCd") String repNationCd) {
		return movieService.getDailyBoxOffice(targetDt, repNationCd);

	}

	@GetMapping(path = "/movieInfo")
	public Object getMovieInfo(@RequestParam(value = "movieCd") String movieCd) {

		return movieService.getMovieInfo(movieCd);
	}

	@GetMapping(path = "/tmdbPoster")
	public Object getPoster(
			@RequestParam(value = "language") String language,
			@RequestParam(value = "query") String query, 
			@RequestParam(value = "year") String year) {

		return movieService.getPoster(language, query, year);
	}

}
