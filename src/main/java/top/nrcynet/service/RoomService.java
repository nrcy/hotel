package top.nrcynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.connect.Connect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomService {

    @Autowired
    private Connect connect;

    /**
     *  查看存在房间
      * @param type 单人间 ：1 双人间：2
     */
    public Room getOneRoom(String type){

        List<Room> rooms = connect.selectExistRoomByType(new Integer(type));
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

            Room room = connect.selectRoomByFloorAndNum(floor, num);

            connect.setRoomStatusByFloorAndNum(floor, num, 1);
            Integer price = room.getPrice();
            if (breakfast.equals("true")){
                price += 10;
                breakfast = "y";
            }else {
                breakfast = "n";
            }
            connect.insert(username, breakfast, roomId, price);
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
            Cache cache = connect.selectCacheByName(username);

            Integer roomId = cache.getRoomId();

            Integer floor = roomId / 100;
            Integer num = roomId % 100;

            Integer cachePrice = cache.getPrice();

            User user = connect.selectUserByName(username);

            Integer price = cachePrice + user.getConsumption();

            connect.updateUserConsumptionByName(username, price);
            connect.setRoomStatusByFloorAndNum(floor, num, 0);
            connect.delete(username);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
