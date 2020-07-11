package top.nrcynet.dao.connect;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.mapper.CoreMapper;

import java.util.List;

@Repository
public class Connect implements CoreMapper {

    @Autowired
    private SqlSession sqlSession;

    public User selectUserByName(String name) {
        return sqlSession.getMapper(CoreMapper.class).selectUserByName(name);
    }

    public void updateUserConsumptionByName(String name, Integer consumption) {
        sqlSession.getMapper(CoreMapper.class).updateUserConsumptionByName(name, consumption);
    }

    public void register(String name, Integer password) {
        sqlSession.getMapper(CoreMapper.class).register(name, password);
    }

    public User login(String name, Integer password) {
        return sqlSession.getMapper(CoreMapper.class).login(name, password);
    }

    public void updateUserPasswordByName(String name, Integer password) {
        sqlSession.getMapper(CoreMapper.class).updateUserPasswordByName(name, password);
    }

    public Room selectRoomByFloorAndNum(Integer floor, Integer num) {
        return sqlSession.getMapper(CoreMapper.class).selectRoomByFloorAndNum(floor, num);
    }

    public List<Room> selectExistRoomByType(Integer type) {
        return sqlSession.getMapper(CoreMapper.class).selectExistRoomByType(type);
    }

    public void setRoomStatusByFloorAndNum(Integer floor, Integer num, Integer status) {
        sqlSession.getMapper(CoreMapper.class).setRoomStatusByFloorAndNum(floor, num, status);
    }

    public void insert(String name, String breadkfast, Integer roomId, Integer price) {
        sqlSession.getMapper(CoreMapper.class).insert(name, breadkfast, roomId, price);
    }

    public void delete(String name) {
        sqlSession.getMapper(CoreMapper.class).delete(name);
    }

    public Cache selectCacheByName(String name) {
        return sqlSession.getMapper(CoreMapper.class).selectCacheByName(name);
    }
}
