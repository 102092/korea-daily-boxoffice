package com.review.wiki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class TestController {
 
    @RequestMapping("/test") // 수업에서 배운 파이차트
    public String test() throws Exception {
        return "test";
    }
    
    @RequestMapping("/test2") // 원본 러시아 레이더 차트 
    public String test2() throws Exception {
        return "test2";
    }

    @RequestMapping("/test3") // 수정용 러시아 레이더 차트
    public String test3() throws Exception {
        return "test3";
    }
    
    @RequestMapping("/test4") // 새로운 레이더 차트
    public String test4() throws Exception {
        return "test4";
    }
    
    @RequestMapping("/abcd") // 워드클라우드 (호버가능)
    public String abcd() throws Exception {
        return "abcd";
    }
    
    @RequestMapping("/abcd2") // 워드클라우드2 (자동으로 움직임)
    //public @ResponseBody String abcd2() throws Exception {
    public String abcd2() throws Exception {
    	        return "abcd2";
    }
    
    @RequestMapping("/abcd3") // 워드클라우드1 + 2, 호버+ 오버워치데이터 
    public String abcd3() throws Exception {
        return "abcd3";
    }
}
