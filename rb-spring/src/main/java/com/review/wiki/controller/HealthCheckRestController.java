package com.review.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.wiki.model.api.response.ApiResult;

import static com.review.wiki.model.api.response.ApiResult.OK;


@RestController
@RequestMapping("api/_hcheck")
public class HealthCheckRestController {

    @GetMapping
    public ApiResult<Long> healthCheck() {
        return OK(System.currentTimeMillis());
    }

}
