package top.nrcynet.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.nrcynet.dao.bean.Cache;

//这是Cache的测试类
public class CacheServiceTest {

	private CacheService cacheService;
	private ApplicationContext context;

    public CacheServiceTest(){
        String path = "applicationContext.xml";

        context = new ClassPathXmlApplicationContext(path);
        
        cacheService = (CacheService) context.getBean("cacheService");
    }
    
    @Test
    public void history(){
//        Cache cache = cacheService.history("tim");
//        System.out.println(cache);
    }

    @Test
    public void haveHistory(){
//        boolean result = cacheService.haveHistory("tim");
//        System.out.println(result);
    }


}
