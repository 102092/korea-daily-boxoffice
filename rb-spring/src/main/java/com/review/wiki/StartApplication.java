package com.review.wiki;
//import com.review.wiki.ReviewsRepository;
//import com.review.wiki.JdbcReviewsRepository;

import java.util.List; 
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.context.ConfigurableApplicationContext; 
import org.springframework.jdbc.core.JdbcTemplate;




@SpringBootApplication 
public class StartApplication{
	
	public static List RT_List(){
		
		List<Map<String, Object>> a = list2;
		return a;
	}
	
	static List<Map<String, Object>> list2;
	
	public static void main(String[] args) { 
		
		try (ConfigurableApplicationContext ctx = SpringApplication.run(StartApplication.class, args)) { 
			StartApplication m = ctx.getBean(StartApplication.class); m.method(); } 
		
		SpringApplication.run(StartApplication.class, args);
	
	} 
	
	@Autowired private JdbcTemplate jdbc; public void method() 
	{ 
		
	list2 = this.jdbc.queryForList("SELECT CONTENTS FROM REVIEWS"); 
	 
	list2.forEach(System.out::println); 
	
//	System.out.println(list2.get(0));
//	System.out.println(list2.get(1));
//	System.out.println(list2.get(2));
//	System.out.println(list2.get(3));
	 Object abc = list2.get(0).values();
	 String a = abc.toString();
     System.out.println(a);
	} 
	
	}
	


//@SpringBootApplication
//public class StartApplication implements CommandLineRunner{
//
//	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    static private ReviewsRepository reviewsRepository;
//                  // Test JdbcTemplate
//    
//    
//    //private ReviewsRepository reviewsRepository;
//
//    public static void main(String[] args) {
//    	log.info("uaaaaa");
//        SpringApplication.run(StartApplication.class, args);
//        log.info("bbbbb");
//    }
//
//    @Override
//    public void run(String... args) {
//    
//    	log.info("StartApplication...");
//        runJDBC();
//    }
//
//    void runJDBC() {
//
//        log.info("Creating tables for testing...");
//
////        log.info("[SAVE]");
////        Reviews.forEach(ReviewsVO -> {
////            log.info("Saving...{}", ReviewsVO.getName());
////            ReviewsRepository.save(ReviewsVO);
////        });
//
//        // count
//        log.info("[COUNT] Total Reviews: {}", reviewsRepository.count());
//
//
//
//        // find all
//        log.info("[FIND_ALL] {}", reviewsRepository.findAll());
//
//    }
//
//
//	
//}
