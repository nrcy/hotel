package top.nrcynet.connect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.dao.connect.Connect;

import java.util.List;

public class RoomConnectTest {

    private Connect connect;

    public RoomConnectTest(){
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        connect = (Connect) context.getBean("connect");
    }

    @Test
    public void selectRoomByFloorAndNum(){
        Room room = connect.selectRoomByFloorAndNum(1, 2);
        System.out.println(room);
    }

    @Test
    public void selectExistRoomByType(){
        List<Room> rooms = connect.selectExistRoomByType(2);
        System.out.println(rooms);
    }

    @Test
    public void setRoomStatusByFloorAndNum(){
//        connect.setRoomStatusByFloorAndNum(1, 1, 0);
    }

}
