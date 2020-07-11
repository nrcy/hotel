package top.nrcynet.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.Cache;

public class CaCheServiceTest {

    private CacheService cacheService;

    public CaCheServiceTest(){
        String path = "applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        cacheService = (CacheService) context.getBean("cacheService");
    }

    @Test
    public void history(){
//        Cache cache = cacheService.history("tom");
//        System.out.println(cache);
    }

    @Test
    public void haveHistory(){
//        boolean result = cacheService.haveHistory("tim");
//        System.out.println(result);
    }
}
