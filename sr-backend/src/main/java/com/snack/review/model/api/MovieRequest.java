package com.snack.review.model.api;

public class MovieRequest {
	private String title;
	private String subtitle;
	private String openAt;
	private String status;
	private String audits;
	private String showTimes;
	private String nations;
	private String directors;
	private String genres;
	private String distributor;
	private String poster;

	public MovieRequest(String title, String subtitle, String openAt, String status, String audits, String showTimes,
			String nations, String directors, String genres, String distributor, String poster) {
		this.title = title;
		this.subtitle = subtitle;
		this.openAt = openAt;
		this.status = status;
		this.audits = audits;
		this.showTimes = showTimes;
		this.nations = nations;
		this.directors = directors;
		this.genres = genres;
		this.distributor = distributor;
		this.poster = poster;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public void setOpenAt(String openAt) {
		this.openAt = openAt;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAudits(String audits) {
		this.audits = audits;
	}

	public void setShowTimes(String showTimes) {
		this.showTimes = showTimes;
	}

	public void setNations(String nations) {
		this.nations = nations;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getOpenAt() {
		return openAt;
	}

	public String getStatus() {
		return status;
	}

	public String getAudits() {
		return audits;
	}

	public String getShowTimes() {
		return showTimes;
	}

	public String getNations() {
		return nations;
	}

	public String getDirectors() {
		return directors;
	}

	public String getGenres() {
		return genres;
	}

	public String getDistributor() {
		return distributor;
	}

	public String getPoster() {
		return poster;
	}

}
