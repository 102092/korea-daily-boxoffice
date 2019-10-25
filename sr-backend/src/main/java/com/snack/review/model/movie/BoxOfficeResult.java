package com.snack.review.model.movie;

import java.util.List;

public class BoxOfficeResult {

	private String boxofficeType;
	private String showRange;
	private List<DailyBoxOfficeList> dailyBoxOfficeList;

	public BoxOfficeResult() {
	};

	public BoxOfficeResult(String boxofficeType, String showRange, List<DailyBoxOfficeList> dailyBoxOfficeList) {
		this.boxofficeType = boxofficeType;
		this.showRange = showRange;
		this.dailyBoxOfficeList = dailyBoxOfficeList;
	}

	public String getBoxofficeType() {
		return boxofficeType;
	}

	public String getShowRange() {
		return showRange;
	}

	public List<DailyBoxOfficeList> getDailyBoxOfficeList() {
		return dailyBoxOfficeList;
	}

}
