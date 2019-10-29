package com.snack.review.model.movie;

import java.util.List;

public class TmbdMovie {
	private Long popularity;
	private Long id;
	private boolean video;
	private Long vote_count;
	private Long vote_average;
	private String title;
	private String release_date;
	private String original_language;
	private String original_title;
	private List<Integer> genre_ids;
	private String backdrop_path;
	private boolean adult;
	private String overview;
	private String poster_path;

	public TmbdMovie() {
	};

	public TmbdMovie(Long popularity, Long id, boolean video, Long vote_count, Long vote_average, String title,
			String release_date, String original_language, String original_title, List<Integer> genre_ids,
			String backdrop_path, boolean adult, String overview, String poster_path) {
		this.popularity = popularity;
		this.id = id;
		this.video = video;
		this.vote_count = vote_count;
		this.vote_average = vote_average;
		this.title = title;
		this.release_date = release_date;
		this.original_language = original_language;
		this.original_title = original_title;
		this.genre_ids = genre_ids;
		this.backdrop_path = backdrop_path;
		this.adult = adult;
		this.overview = overview;
		this.poster_path = poster_path;
	}

	public Long getPopularity() {
		return popularity;
	}

	public Long getId() {
		return id;
	}

	public boolean isVideo() {
		return video;
	}

	public Long getVote_count() {
		return vote_count;
	}

	public Long getVote_average() {
		return vote_average;
	}

	public String getTitle() {
		return title;
	}

	public String getRelease_date() {
		return release_date;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public List<Integer> getGenre_ids() {
		return genre_ids;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public boolean isAdult() {
		return adult;
	}

	public String getOverview() {
		return overview;
	}

	public String getPoster_path() {
		return poster_path;
	}

}
