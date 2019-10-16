package com.review.wiki;

import java.io.File;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Controller
public class RController {
	
	


	@RequestMapping("/RT") //R연산 
    public String test() throws Exception {
    
        return "Rserve_test";
    }
    
   
    @RequestMapping("/RT2") // 그래프띄우기
    public String Rtest2() throws Exception {
  
        return "Rserve_test2";
    }
    
    @RequestMapping("/RT3") // 워드클라우드
    public String Rtest3() throws Exception {
  
        return "Rserve_test3";
    }
    
}
