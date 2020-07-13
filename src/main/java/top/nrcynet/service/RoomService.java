package top.nrcynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.mapper.CacheMapper;
import top.nrcynet.dao.mapper.RoomMapper;
import top.nrcynet.dao.mapper.UserMapper;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomService {

    @Autowired
    private RoomMapper roomMapper;
    
    @Autowired
    private CacheMapper cacheMapper;
    
    @Autowired
    private UserMapper userMapper;

    /**
     *  查看存在房间
      * @param type 单人间 ：1 双人间：2
     */
    public Room getOneRoom(String type){

        List<Room> rooms = roomMapper.selectExistRoomByType(new Integer(type));
        if (rooms.size() >= 1){
            return rooms.get(0);
        }
        return null;

    }

    /**
     *
     * 入住
     * @param
     *
     */
    public Boolean reserve(String roomIdString, String username, String breakfast){
        try {
            Integer roomId = new Integer(roomIdString);
            Integer floor = roomId / 100;
            Integer num = roomId % 100;

            Room room = roomMapper.selectRoomByFloorAndNum(floor, num);

            roomMapper.setRoomStatusByFloorAndNum(floor, num, 1);
            Integer price = room.getPrice();
            if (breakfast.equals("true")){
                price += 10;
                breakfast = "y";
            }else {
                breakfast = "n";
            }
            cacheMapper.insert(username, breakfast, roomId, price);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 退房
     */
    public boolean checkOut(String username){
        try {
            Cache cache = cacheMapper.selectCacheByName(username);

            Integer roomId = cache.getRoomId();

            Integer floor = roomId / 100;
            Integer num = roomId % 100;

            Integer cachePrice = cache.getPrice();

            User user = userMapper.selectUserByName(username);

            Integer price = cachePrice + user.getConsumption();

            userMapper.updateUserConsumptionByName(username, price);
            roomMapper.setRoomStatusByFloorAndNum(floor, num, 0);
            cacheMapper.delete(username);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
