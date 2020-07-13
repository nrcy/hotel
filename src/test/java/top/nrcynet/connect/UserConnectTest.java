package top.nrcynet.connect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.mapper.UserMapper;

public class UserConnectTest {

	private UserMapper userMapper;
	private ApplicationContext context;
	
	public UserConnectTest() {
		String path = "applicationContext.xml";
		
		context = new ClassPathXmlApplicationContext(path);
		
		userMapper = (UserMapper) context.getBean("userMapper");
	}
	
	@Test
	public void selectUserByName() {
//		User user = userMapper.selectUserByName("tim");
//		System.out.println(user);
	}
	
	@Test
	public void updateUserConsumptionByName() {
//		userMapper.updateUserConsumptionByName("tim", 0);
	}
	
	@Test
	public void register() {
//		userMapper.register("bob", 123);
	}
	
	@Test
	public void login() {
//		User user = userMapper.login("tom", 123456);
//		System.out.println(user);
	}
	
	@Test
	public void updateUserPasswordByName() {
//		userMapper.updateUserPasswordByName("bob", 123456);
	}
	
}
