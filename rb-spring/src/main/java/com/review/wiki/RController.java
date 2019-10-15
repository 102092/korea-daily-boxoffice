package com.review.wiki;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Controller
public class RController {
 
    @RequestMapping("/RT") // 수업에서 배운 파이차트
    public String test() throws Exception {
    
        return "Rserve_test";
    }
    
   
    @RequestMapping("/RT2") 
    public String Rtest2() throws Exception {
  
        return "Rserve_test2";
    }
    
}
