package com.snack.review.model.movie;

public class KobisMovie {

	private BoxOfficeResult boxOfficeResult;

	public KobisMovie() {
	};

	public KobisMovie(BoxOfficeResult boxOfficeResult) {

		this.boxOfficeResult = boxOfficeResult;
	}

	public BoxOfficeResult getBoxOfficeResult() {
		return boxOfficeResult;
	}

}
