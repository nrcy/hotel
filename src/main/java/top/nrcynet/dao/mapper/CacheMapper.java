package top.nrcynet.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.nrcynet.dao.bean.Cache;

@Repository
public interface CacheMapper {

    void insert(@Param("name") String name,
                @Param("breakfast") String breadkfast,
                @Param("roomId") Integer roomId,
                @Param("price") Integer price);

    void delete(@Param("name") String name);

    Cache selectCacheByName(@Param("name") String name);


}
