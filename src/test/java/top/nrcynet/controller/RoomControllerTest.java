package top.nrcynet.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.nrcynet.dao.bean.ResultModel;

//这是RoomController的测试类
public class RoomControllerTest {

    private RoomController roomController;

    public RoomControllerTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        roomController = (RoomController) context.getBean("roomController");
    }

    @Test
    public void getOneRoom(){
//        ResultModal room = roomController.getOneRoom("1");
//        System.out.println(room);
    }

    @Test
    public void reserve(){
//        String json = roomController.reserve("101", "y", "tim");
//        System.out.println(json);
    }

    @Test
    public void hasHistory(){
//        String json = roomController.haveHistory("tom");
//        System.out.println(json);
    }

    @Test
    public void history(){
//        String json = roomController.history("tom");
//        System.out.println(json);
    }

    @Test
    public void pay(){
//        String json = roomController.pay("tom");
//        System.out.println(json);
    }
}
