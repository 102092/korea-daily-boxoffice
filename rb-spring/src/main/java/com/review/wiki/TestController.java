package com.review.wiki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class TestController {
 
    @RequestMapping("/test")
    public String test() throws Exception {
        return "test";
    }
    
    @RequestMapping("/test2")
    public String test2() throws Exception {
        return "test2";
    }
    
    @RequestMapping("/abcd2")
    public @ResponseBody String abcd2() throws Exception {
        return "abcd2";
    }
}
