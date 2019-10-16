package com.review.wiki.security;

public class NaverKey {
	
	private final String nclientId;
	
	private final String nclientScret;
	
	private final String url;

	public NaverKey(String nclientId, String nclientScret, String url) {
		this.nclientId = nclientId;
		this.nclientScret = nclientScret;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public String getNclientId() {
		return nclientId;
	}

	public String getNclientScret() {
		return nclientScret;
	}
	
	
	

}
