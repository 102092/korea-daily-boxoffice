package com.review.wiki.controller.authentication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.wiki.error.UnauthorizedException;
import com.review.wiki.model.api.response.ApiResult;
import com.review.wiki.security.AuthenticationRequest;
import com.review.wiki.security.AuthenticationResult;
import com.review.wiki.security.JwtAuthenticationToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.review.wiki.model.api.response.ApiResult.OK;

@RestController
@RequestMapping("api/auth")
@Api(tags = "인증 APIs")
public class AuthenticationRestController {

	private final AuthenticationManager authenticationManager;

	public AuthenticationRestController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping
	@ApiOperation(value = "사용자 로그인 (API 토큰 필요없음)")
	public ApiResult<AuthenticationResult> authentication(@RequestBody AuthenticationRequest authRequest)
			throws UnauthorizedException {
		try {
			JwtAuthenticationToken authToken = new JwtAuthenticationToken(authRequest.getPrincipal(), authRequest.getCredentials());
			
			Authentication authentication = authenticationManager.authenticate(authToken);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			return OK((AuthenticationResult) authentication.getDetails());
			
		} catch (AuthenticationException e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
}
