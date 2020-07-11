package top.nrcynet.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.nrcynet.dao.bean.Cache;

public interface CacheMapper {

    void insert(@Param("name") String name,
                @Param("breakfast") String breadkfast,
                @Param("roomId") Integer roomId,
                @Param("price") Integer price);

    void delete(@Param("name") String name);

    Cache selectCacheByName(@Param("name") String name);


}
