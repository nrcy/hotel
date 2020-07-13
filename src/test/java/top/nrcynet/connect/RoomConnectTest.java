package top.nrcynet.connect;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.nrcynet.dao.bean.Room;
import top.nrcynet.dao.mapper.RoomMapper;

public class RoomConnectTest {

	private RoomMapper roomMapper;
	private ApplicationContext context;
	
	public RoomConnectTest() {
		String path = "applicationContext.xml";
		
		context = new ClassPathXmlApplicationContext(path);
		
		roomMapper = (RoomMapper) context.getBean("roomMapper");
	}
	
	@Test
	public void selectRoomByFloorAndNum() {
//		Room room = roomMapper.selectRoomByFloorAndNum(1, 5);
//		System.out.println(room);
	}
	
	@Test
	public void selectExistRoomByType() {
//		List<Room> rooms = roomMapper.selectExistRoomByType(1);
//		System.out.println(rooms);
	}
	
	@Test
	public void setRoomStatusByFloorAndNum() {
//		roomMapper.setRoomStatusByFloorAndNum(1, 4, 0);
	}
}
