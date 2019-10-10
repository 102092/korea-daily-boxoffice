package com.review.wiki;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello, the time at the server is now " + new Date() + "\n";
	}
	
//    @RequestMapping("/test")
//    public String test() throws Exception {
//        return "test";
//    }
//    
//    @RequestMapping("/test2")
//    public String abcd() throws Exception {
//        return "test2";
//    }
    
}