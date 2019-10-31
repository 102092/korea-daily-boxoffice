package com.snack.review.model.api;

public class API {

	private final String kobisKey;

	private final String kobisDailyUrl;

	private final String kobisInfoUrl;

	private final String tmbdKey;

	private final String tmbdSearch;

	private final String tmbdPoster;

	public API(String kobisKey, String kobisDailyUrl, String kobisInfoUrl, String tmbdKey, String tmbdSearch,
			String tmbdPoster) {
		super();
		this.kobisKey = kobisKey;
		this.kobisDailyUrl = kobisDailyUrl;
		this.kobisInfoUrl = kobisInfoUrl;
		this.tmbdKey = tmbdKey;
		this.tmbdSearch = tmbdSearch;
		this.tmbdPoster = tmbdPoster;
	}

	public String getKobisKey() {
		return kobisKey;
	}

	public String getKobisDailyUrl() {
		return kobisDailyUrl;
	}

	public String getKobisInfoUrl() {
		return kobisInfoUrl;
	}

	public String getTmbdKey() {
		return tmbdKey;
	}

	public String getTmbdSearch() {
		return tmbdSearch;
	}

	public String getTmbdPoster() {
		return tmbdPoster;
	}

}
