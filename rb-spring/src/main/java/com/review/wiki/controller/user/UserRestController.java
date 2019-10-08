package com.review.wiki.controller.user;

import com.review.wiki.error.NotFoundException;
import com.review.wiki.model.api.request.user.JoinRequest;
import com.review.wiki.model.api.response.ApiResult;
import com.review.wiki.model.api.response.user.JoinResult;
import com.review.wiki.model.user.ConnectedUser;
import com.review.wiki.model.user.Email;
import com.review.wiki.model.user.Role;
import com.review.wiki.model.user.User;
import com.review.wiki.security.JWT;
import com.review.wiki.security.JwtAuthentication;
import com.review.wiki.service.user.UserService;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.review.wiki.model.api.response.ApiResult.OK;

@RestController
@RequestMapping("api")
public class UserRestController {

	private final JWT jwt;

	private final UserService userService;

	public UserRestController(JWT jwt, UserService userService) {
		this.jwt = jwt;
		this.userService = userService;
	}

    @PostMapping(path = "user/exists")
    public ApiResult<Boolean> checkEmail(
            @RequestBody
            Map<String, String> request
    ) {
        Email email = new Email(request.get("address"));
        return OK(userService.findByEmail(email).isPresent());
    }

    @PostMapping(path = "user/join")
    public ApiResult<JoinResult> join(@RequestBody JoinRequest joinRequest) {
        User user = userService.join(
                joinRequest.getName(),
                new Email(joinRequest.getPrincipal()),
                joinRequest.getCredentials()
        );
        String apiToken = user.newApiToken(jwt, new String[]{Role.USER.value()});
        return OK(new JoinResult(apiToken, user));
    }

    @GetMapping(path = "user/me")
    public ApiResult<User> me(@AuthenticationPrincipal JwtAuthentication authentication) {
        return OK(
                userService.findById(authentication.id)
                        .orElseThrow(() -> new NotFoundException(User.class, authentication.id))
        );
    }

    @GetMapping(path = "user/connections")
    public ApiResult<List<ConnectedUser>> connections(@AuthenticationPrincipal JwtAuthentication authentication) {
        return OK(userService.findAllConnectedUser(authentication.id));
    }
}
