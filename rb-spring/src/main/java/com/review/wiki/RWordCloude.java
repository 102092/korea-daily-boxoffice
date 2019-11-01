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


//    public byte[] returnRImg() throws REngineException, REXPMismatchException {
//
////    	for(Map<String, Object> i : a){
////		    b += i.values().toString();
////		}
//
//        String device = "jpeg";
//        x = r.parseAndEval("try("+device+"('test2.jpg',quality=90))");
//
//        // ok, so the device should be fine - let's plot - replace this by any plotting code you desire ...
//
//        //r.parseAndEval("refinedStr <- " + b);
//        
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
//
////        r.parseAndEval("a<-c(1,2,3,4,5)");
////        r.parseAndEval("plot(a)");
////        
//
//        
//        
//        //graphics off
//        r.parseAndEval("graphics.off()");
//
//        // There is no I/O API in REngine because it's actually more efficient to use R for this
//        // we limit the file size to 1MB which should be sufficient and we delete the file as well
//        x = r.parseAndEval("r=readBin('test2.jpg','raw',1024*1024); unlink('test2.jpg'); r");
//
//        return x.asBytes();//img;
//    }
    
    
    public byte[] returnRImg() throws REXPMismatchException, REngineException{
        System.out.println("wordcloud  시작");

//			for(Map<String, Object> i : a){
//		    b += i.values().toString();
//		}
        
        b = "단순한 로맨스 영화가 아니다]] 연애와 직장, 모든것에 공감하며 미친듯이 웃다가- 현실적인 대사들에 뼈 후려맞고 살짝 아파하는 나를 발견...☆ 최근 본 코미디/로맨스 장르 영화 중 가장 잘 나온 듯]진짜 재밌어요.. 꼭보세요김래원 공효진 조합은 정말 최고 조연분들 연기도 최고!! 단순한 로맨틱 코미디 영화가 아니라 정말 현실적이고 많이 느낄수 있었어요 진짜 재밌게 잘봤습니다ㅠㅠ]공감이 별로안되는 ...생각보다 별로였어요. 이게 무슨 주변에 있는 평범한 연애라는건지;;; 술말고 맨정신엔 연애가 안되고 실연의 상처를 치유하기 힘든가요?]\r\n" + 
        		"술로 시작해서 술로 끝나는 영화공감할수가 없었고 술을 안마시면 극복못하고, 술 마시면 개가되어 실수하고, 그러다가 사랑이 싹트고?? 별로였어요ㅎㅎ]영화가 술 처먹다 끝나네요 ㅋㅋㅋ] 공효진이랑 김래원 케미 미쳤다 ㅋㅋㅋㅋ 입모양게임하는거 보고 웃겨 죽을뻔 ㅠㅠ 팍팍한 삶에 한줄기 빛과 소금같은 영화였습니다...☆] 이 영화, 흥행 스멜이 보통이 아니다! 오랜만에 지극히 현실적인 국내 로코작이 반가웠고, 사이다 여주인공 캐릭터의 대사와 그 캐릭터를 잘 살려낸 공효진의 연기력까지 최고♥]스토리가없어요. 영화에서 술냄새남. 요즘 저런 회사가 있나 싶을정도로 사람들 생각도 이상하고 가끔 웃긴장면 몇개 있지만 거의 노잼임.. 아무생각없이 시간때우고 싶으면 보세요.]\r\n" + 
        		"    등장인물들은 시종일관 무례하기 짝이 없고, 갑자기 서로 사랑이 싹트는 감정선도 이해 안가고, 여자남자섹스연애결혼 못해서 안달난 인간들만 천지인 저질그자체의 영화. 영화 끝까지 술이나 마시는데 이게 무슨 보통의 연애냐...] 와 역대급 로코가 등장했다. 김래원 공효진 강기영 코미디 빵빵터지고 현실감있는 스토리 최고! 이런 로코 많이 나왔으면 좋겠다]]음... 이게... 가장 보통의 연애라고? 음... 술 마시다 썸 시작해서 잠자리하고 술에서 술... 전남친은 바람에 전여친 집을 뒤집어 놓고... 이게 보통이야?] 솔직히 진짜 누구나 한번쯤 경험해봤던 가장 보통의 연애 ㅋㅋ 공감되는 대사도 많고 공효진 김래원 연기 찰떡!! ㅠㅠ]보통의 연애?바람펴서 헤어지는게 흔한 보통의 연애인가? 재미 1도 없고 주인공들 감정선 읽기도 어렵고 15세걸어놓고 선넘는 드립이 넘쳐나는데 댓글 알바들 겁나 많네]15세 아이들이 이런 영화보구 이런 말도 안되게 저속한게 사랑이라고 할까봐 걱정이에요ㅜ 모든게 술에서 시작해서 술로 끝나는 가벼운... 공효진 좋아해서 봤는데 실망이였어요~~] 처음에는 김래원 감정에 완전 공감되었다가 후반에는 공효진에 완전 이입되는....현실공감이라는 말이 진짜 찰떡인 영화!! 두번 보세요 세번 보세요ㅠㅍ]처음엔 불편했는데 뒤로 갈수록 불쾌해졌다.공효진 좋아해서 개봉첫날 예매해 봤는데 실망이다. 이런 연애가 요즘 말이되나? 술마시지 않으면 연앨 할 수 없나? 연애에 대한 모욕이다.]매일 술 퍼마시고 인사불성으로 사는 이런 사람들이 가장보통이라니 이 나라가 대한심민국일 수 밖에]공효진을 보는 건 언제나 시간 가는 줄 모르겠다만 그저 모든 스토리의 전개를 술 취한 것 하나에 기대어 이어가려는 게으른 각본과 연출. 술 취해서 몰랐다는 건 늘 성범죄에서도 쓰이는 변명이라 뒷맛도 매우 개운치 않...] 술, ㅅㅅ, 불륜 ... 이게 정말 보통의 연애라면 세상 이미 썩을대로 썩은거라 생각]사랑은 언제나 어렵다.]술먹고 주사 술먹고 주사 반복.]기대이상이네....대박이다..연애 할려는 사람이나 연애 하는중이거나 헤어진지 얼마 안된 사람도 충분히 공감가는 스토리입니다. 스토리 자체가 가벼워서 좋고 두 배우의 연기도 좋구요 그냥 마음놓고 보면 됩니다";
        
        
		System.out.println("RT3에서 DB 끌어오기 : " + b);
			
        String device = "jpeg";


        x = r.parseAndEval("try("+device+"('test.jpg',quality=90))");

      r.parseAndEval("library('wordcloud')");
      r.parseAndEval("library('RColorBrewer')");
      r.parseAndEval("library('KoNLP')");
      r.parseAndEval("library('stringr')");
     
     
      //r.parseAndEval("data <- readLines( 'C:/replay/R/comment1.txt')");
      
//      r.parseAndEval("setwd('C:/Users/student/Documents')");
      
//      r.parseAndEval("setwd('C:/Users/student/Documents/GitHub/snack-review-working/sr-frontend/src')");
      
      r.parseAndEval("data <- '" + b +"'");
    //  r.parseAndEval("data <- '[첫번째 리뷰입니다.][두번째 리뷰임.][세번째 리뷰 작성중.][지금 가장 어이없고 불쌍한거 야마일듯 ㅋㅋㅋ 케이지에서 왠 뽀시래기가 시비걸길래 내기에 응해줬더니 형제들이 케이지 털려고 습격하고 케이지 지키려고 싸웠더니 퍼그 원로들이 들이닥치고 원로 상대하려고 전신의태까지 했는데 이번에는 자신과 전혀 상관없는 성벽으로 워프됨 ㅋㅋㅋ 이번 에피소드는 본격 야마의 여행임 ㅋㅋㅋ][이젠 냥이와 댕댕이의 싸움이네ㅋㅋㅋㅋㅋㅋ][왜 아무도 밤이 가도 다리 쉽게 잘라버린건 말하지 않나 밤 개쎄구만..][로 포 비아 아스라챠는 가주가 아니라 하이랭커였네요][반전이다... 가주인줄알았는데 그냥 하이랭커 엿어..... 그럼 가주이름은 뭘까.......][나 밤이 다리 자르고 다음엔 오른팔이다 이러는줄 알고 밤 많이 거칠어졌는줄 ㅋㅋㅋㅋㅋ 야마네][밤 힘이 얼마나 세진 거야;;;;; 가시 시동시키면 하이랭커 다리 자르는 것 정도는 아무 것도 아니라는 건가]'");
//      r.parseAndEval("add_dic <- readLines( 'c:/commentdata/addNoun.txt')");
//      r.parseAndEval("for(i in 1:length(add_dic)){mergeUserDic(data.frame(add_dic[i], 'ncn'))}");

      r.parseAndEval("data <- str_replace_all(data, \"\\\\W\", \" \")");


      r.parseAndEval("data <- sapply(data, extractNoun, USE.NAMES = F)");

      
      r.parseAndEval("data_unlist <- unlist(data)");

      
      r.parseAndEval("wordcount <- table(data_unlist)");
      r.parseAndEval("wordcount_top <-head(sort(wordcount, decreasing = T),10)");
 
      r.parseAndEval("data_unlist <- Filter(function(x){nchar(x)>=2}, data_unlist)");
      
      
      r.parseAndEval("data_unlist<- gsub('[~!@#$%&*()_+=?<>^]','',data_unlist)");
     
      r.parseAndEval("data_unlist <- gsub(\"\\\\[\",\"\",data_unlist)");
      
      r.parseAndEval("data_unlist <- gsub(\"\\\\d+\", \"\", data_unlist)");
      
      r.parseAndEval("data_unlist <- gsub('공효', \"\", data_unlist)");
      r.parseAndEval("data_unlist <- gsub('김래원', \"\", data_unlist)");
      
      // 한글을 파싱을 못해서 유니코드로 변환 [ㄱ-ㅎ]=[\\u3131-\\u314e], (ㅜ|ㅠ)=()
      r.parseAndEval("data_unlist <- gsub(\"[\\u3131-\\u314e]\",\"\", data_unlist)");
      
      r.parseAndEval("data_unlist<- gsub(\"(\\u315C|\\u3160)\",\"\",data_unlist)");
      

      
      r.parseAndEval("wordcount <- table(data_unlist)");
      
      r.parseAndEval("wordcount_top <- head(sort(wordcount,decreasing=T),10)");
      
      
      r.parseAndEval("word <- \'C:/Users/student/Documents/GitHub/snack-review-working/sr-frontend/src/img/word2.png\'");
//      
      r.parseAndEval("png(word)");
//      
      r.parseAndEval("wordcloud(names(wordcount_top),freq=wordcount_top,scale=c(15,3),rot.per=0.1,min.freq=1,family='Malgun Gothic',random.order=F,random.color=T,colors=brewer.pal(12, 'Paired'))");
      
      
      
 
      r.parseAndEval("graphics.off()");  
    
    
    
      x = r.parseAndEval("r=readBin('test.jpg','raw',1024*1024); unlink('test.jpg'); r");
      System.out.println("x의 값은 : " + x);
      System.out.println("test.jpg의 값 : " + x);
      System.out.println("x의 byte값은 : " + x.asBytes());
    
      r.close();
      return x.asBytes();
      
     }
}