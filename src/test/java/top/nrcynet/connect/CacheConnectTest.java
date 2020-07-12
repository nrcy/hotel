package top.nrcynet.connect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.connect.Connect;

public class CacheConnectTest {

    private Connect connect;

    public CacheConnectTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        connect = (Connect) context.getBean("connect");
    }

    @Test
    public void insert(){
//        connect.insert("tom", "y", 101, 233);
    }

    @Test
    public void selectCacheByName(){
        Cache tom = connect.selectCacheByName("tom");
        System.out.println(tom);
    }

    @Test
    public void delete(){
//        connect.delete("tom");
    }

}
