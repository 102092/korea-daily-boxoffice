package com.review.wiki;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Controller
public class ChartController {
 
    @RequestMapping("/RT") // 수업에서 배운 파이차트
    public String test() throws Exception {
    	
    	try {
            
            RCaller caller = new RCaller();
            caller.setRscriptExecutable("Rscript.exe 의 경로 복사하기.");
            RCode code = new RCode();
            code.clear();
            
            File file;
            file = code.startPlot();
            System.out.println(file);
            code.addRCode("x=c(1,4,3,5,6,10)");
            code.addRCode("plot(x)");
            code.endPlot();
            
            caller.setRCode(code);
            caller.runOnly();
            code.showPlot(file);
            
         } catch (Exception e) {
            // TODO: handle exception
         }
  
        return "Rserve_test";
    }
    
   
}
