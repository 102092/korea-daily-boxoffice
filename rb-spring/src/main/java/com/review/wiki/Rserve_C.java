package com.review.wiki;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.review.wiki.StartApplication;


public class Rserve_C {

    public REXP x = null;
    public RConnection c = null;
    public String retStr = "";
    public List<Map<String, Object>> a = StartApplication.RT_List();
    
    public String returnRClass() throws RserveException, REXPMismatchException{

            c = new RConnection();
            x = c.eval("1+2");
//            Set<String> abc = a.get(0).keySet();
//            System.out.println(abc);
            retStr = x.asString();

        return retStr;
    }
}