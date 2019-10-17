package com.review.wiki;

import java.util.List;
import java.util.Map;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.review.wiki.StartApplication;


public class RWordCloude {

    public RConnection r = null;
    public REXP x = null;
    public String retStr = "";
    
    public List<Map<String, Object>> a = StartApplication.RT_List();
    		
    public String b = "";
	 
	 
    

    public RWordCloude() throws RserveException {
        this.r = new RConnection();

    }


    public byte[] returnRImg() throws REngineException, REXPMismatchException {

//    	for(Map<String, Object> i : a){
//		    b += i.values().toString();
//		}

        String device = "jpeg";
        x = r.parseAndEval("try("+device+"('test2.jpg',quality=90))");

        // ok, so the device should be fine - let's plot - replace this by any plotting code you desire ...

        //r.parseAndEval("refinedStr <- " + b);
        
//        r.parseAndEval("refinedStr <- '[첫번째 리뷰입니다.][두번째 리뷰임.][세번째 리뷰 작성중.][지금 가장 어이없고 불쌍한거 야마일듯 ㅋㅋㅋ 케이지에서 왠 뽀시래기가 시비걸길래 내기에 응해줬더니 형제들이 케이지 털려고 습격하고 케이지 지키려고 싸웠더니 퍼그 원로들이 들이닥치고 원로 상대하려고 전신의태까지 했는데 이번에는 자신과 전혀 상관없는 성벽으로 워프됨 ㅋㅋㅋ 이번 에피소드는 본격 야마의 여행임 ㅋㅋㅋ][이젠 냥이와 댕댕이의 싸움이네ㅋㅋㅋㅋㅋㅋ][왜 아무도 밤이 가도 다리 쉽게 잘라버린건 말하지 않나 밤 개쎄구만..][로 포 비아 아스라챠는 가주가 아니라 하이랭커였네요][반전이다... 가주인줄알았는데 그냥 하이랭커 엿어..... 그럼 가주이름은 뭘까.......][나 밤이 다리 자르고 다음엔 오른팔이다 이러는줄 알고 밤 많이 거칠어졌는줄 ㅋㅋㅋㅋㅋ 야마네][밤 힘이 얼마나 세진 거야;;;;; 가시 시동시키면 하이랭커 다리 자르는 것 정도는 아무 것도 아니라는 건가]'");
//        r.parseAndEval("library(KoNLP)");
//        r.parseAndEval("library(rJava)");
//        r.parseAndEval("nouns<- extractNoun( refinedStr )");
//        r.parseAndEval("nouns[1:10]");
//        
//        r.parseAndEval("nouns <-nouns[nchar(nouns) > 1]");
//        r.parseAndEval("wordT <- sort(table(nouns), decreasing=T)[1:10]");
//        r.parseAndEval("library(wordcloud2)");
//        r.parseAndEval("wordcloud2(wordT, size=0.5, shape='diamond')");

        r.parseAndEval("a<-c(1,2,3,4,5)");
        r.parseAndEval("plot(a)");
        

        
        
        //graphics off
        r.parseAndEval("graphics.off()");

        // There is no I/O API in REngine because it's actually more efficient to use R for this
        // we limit the file size to 1MB which should be sufficient and we delete the file as well
        x = r.parseAndEval("r=readBin('test2.jpg','raw',1024*1024); unlink('test2.jpg'); r");

        return x.asBytes();//img;
    }
}