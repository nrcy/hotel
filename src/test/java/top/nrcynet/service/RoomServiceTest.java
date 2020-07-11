package top.nrcynet.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.Room;

public class RoomServiceTest {

    private RoomService roomService;

    public RoomServiceTest(){
        String path = "applicationContext.xml";

        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        roomService = (RoomService) context.getBean("roomService");
    }

    @Test
    public void getOneRoom(){
//        Room room = roomService.getOneRoom("1");
//        System.out.println(room);
    }

    @Test
    public void reserve(){
//        Boolean result = roomService.reserve("102", "tom", "y");
//        System.out.println(result);
    }

    @Test
    public void checkOut(){
//        boolean result = roomService.checkOut("tom");
//        System.out.println(result);
    }
}
