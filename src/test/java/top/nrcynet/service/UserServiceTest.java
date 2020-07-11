package top.nrcynet.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.User;

public class UserServiceTest {

    public UserService userService;

    public UserServiceTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void userInformation(){
//        User user = userService.userInformation("tom");
//        System.out.println(user);
    }

    @Test
    public void setUserPasswordByName(){
//        boolean result = userService.setUserPasswordByName("tom", "123");
//        System.out.println(result);

    }

    @Test
    public void login(){
//        boolean result = userService.login("tom435", "123");
//        System.out.println(result);
    }

    @Test
    public void register(){
//        boolean result = userService.register("tim", "1234");
//        System.out.println(result);
    }

    @Test
    public void verificationName(){
//        boolean result = userService.verificationName("alice");
//        System.out.println(result);
    }
}
