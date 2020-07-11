package top.nrcynet.connect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.connect.Connect;

public class UserConnectTest {

    private Connect connect;

    public UserConnectTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        connect = (Connect) context.getBean("connect");
    }

    @Test
    public void register(){
//        connect.register("tom", 123);
    }

    @Test
    public void login(){
//        User user = connect.login("tom", 123);
//        System.out.println(user);
    }

    @Test
    public void selectUserByName(){
//        User user = connect.selectUserByName("tom");
//        System.out.println(user);
    }

    @Test
    public void updateUserConsumptionByName(){
//        connect.updateUserConsumptionByName("tom", 123);
    }

    @Test
    public void updateUserPasswordByName(){
//        connect.updateUserPasswordByName("tom", 123456);
    }
}
