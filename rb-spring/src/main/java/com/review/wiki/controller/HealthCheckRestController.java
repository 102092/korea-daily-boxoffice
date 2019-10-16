package com.review.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.review.wiki.model.api.response.ApiResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static com.review.wiki.model.api.response.ApiResult.OK;


@RestController
@RequestMapping("api/_hcheck")
@Api(tags= "헬스체크 Api")
public class HealthCheckRestController {

    @GetMapping
    @ApiOperation(value = "헬스체크 (API 토큰 필요없음)")
    public ApiResult<Long> healthCheck() {
        return OK(System.currentTimeMillis());
    }

}
