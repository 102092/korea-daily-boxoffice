package com.review.wiki.security;


import static com.google.common.base.Preconditions.checkNotNull;

import com.review.wiki.model.user.User;

public class AuthenticationResult {
	
	private final String apiToken;

	private final User user;

	public AuthenticationResult(String apiToken, User user) {
		checkNotNull(apiToken, "apiToken must be provided.");
		checkNotNull(user, "user must be provided.");

		this.apiToken = apiToken;
		this.user = user;
	}

	public String getApiToken() {
		return apiToken;
	}

	public User getUser() {
		return user;
	}

}
