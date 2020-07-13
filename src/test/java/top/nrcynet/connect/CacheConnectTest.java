package top.nrcynet.connect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.mapper.CacheMapper;

public class CacheConnectTest {

	private CacheMapper cacheMapper;
	private ApplicationContext context;
	
	public CacheConnectTest() {
		String path = "applicationContext.xml";
		
		context = new ClassPathXmlApplicationContext(path);
		
		cacheMapper = (CacheMapper) context.getBean("cacheMapper");
	}
	
	@Test
	public void insert() {
//		cacheMapper.insert("tom", "y", 106, 123);
	}
	
	@Test
	public void selectCacheByName() {
//		Cache cache = cacheMapper.selectCacheByName("tom");
//		System.out.println(cache);
	}
	
	@Test
	public void delete() {
//		cacheMapper.delete("tom");
	}
	
}
