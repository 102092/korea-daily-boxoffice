package com.snack.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/_hcheck")
public class HealthCheckRestController {

	@GetMapping
    public Long healthCheck() {
        return System.currentTimeMillis();
    }

}
