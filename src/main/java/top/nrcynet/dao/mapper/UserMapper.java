package top.nrcynet.dao.mapper;

import org.apache.ibatis.annotations.Param;
import top.nrcynet.dao.bean.User;

public interface UserMapper {


    User selectUserByName(String name);

    void updateUserConsumptionByName(@Param("name") String name,
                                     @Param("consumption") Integer consumption);

    void register(@Param("name") String name,
                  @Param("password") Integer password);

    User login(@Param("name") String name,
               @Param("password") Integer password);

    void updateUserPasswordByName(@Param("name") String name,
                                  @Param("password") Integer password);

}
