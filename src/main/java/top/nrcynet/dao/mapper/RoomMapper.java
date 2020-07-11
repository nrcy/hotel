package top.nrcynet.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.nrcynet.dao.bean.Room;

import java.util.List;

public interface RoomMapper {

    Room selectRoomByFloorAndNum(@Param("floor") Integer floor,
                                 @Param("num") Integer num);

    List<Room> selectExistRoomByType(@Param("type") Integer type);

    void setRoomStatusByFloorAndNum(@Param("floor") Integer floor,
                                    @Param("num") Integer num,
                                    @Param("status") Integer status);

}
