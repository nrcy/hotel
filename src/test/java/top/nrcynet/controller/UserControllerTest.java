package top.nrcynet.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//这是UserController的测试类
public class UserControllerTest {

    private UserController userController;

    public UserControllerTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
//        userController = (UserController) context.getBean("userController");
    }

    @Test
    public void information(){
//        String json = userController.userInformation("tom");
//        System.out.println(json);
    }

    @Test
    public void setUserPassword(){
//        String json = userController.setUserPassword("tom", "123456");
//        System.out.println(json);
    }

    @Test
    public void verificationName(){
//        String json = userController.verificationName("qerqer");
//        System.out.println(json);
    }

    @Test
    public void register(){
//        String json = userController.register("alice", "1234567");
//        System.out.println(json);
    }

    @Test
    public void login(){

    }
}
