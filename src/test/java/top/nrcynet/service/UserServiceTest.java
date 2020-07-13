package top.nrcynet.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.User;

//这是UserService的测试类
public class UserServiceTest {

    public UserService userService;
	private ApplicationContext context;

    public UserServiceTest(){
        String path = "applicationContext.xml";
        context = new ClassPathXmlApplicationContext(path);
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
//        boolean result = userService.login("tom", "123");
//        System.out.println(result);
    }

    @Test
    public void register(){
//        boolean result = userService.register("tom", "1234");
//        System.out.println(result);
    }

    @Test
    public void verificationName(){
//        boolean result = userService.verificationName("alice");
//        System.out.println(result);
    }
}
