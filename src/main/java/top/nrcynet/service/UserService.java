package top.nrcynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nrcynet.dao.bean.User;
import top.nrcynet.dao.connect.Connect;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private Connect connect;

    /**
     *
     * @param name 验证姓名是否重复
     * @return true：姓名不存在，false：姓名存在
     */
    public boolean verificationName(String name){

        User user = connect.selectUserByName(name);

        if (user == null) {
            return true;
        }
        return false;

    }


    /**
     *
     * @param name 姓名
     * @param password 密码
     * @return true:注册成功，false，注册失败
     */
    public boolean register(String name, String password){

        User user = connect.selectUserByName(name);
        if (user == null) {
            connect.register(name, new Integer(password));
            return true;
        }
        return false;

    }

    public boolean login(String name, String password){

        User user = connect.login(name, new Integer(password));

        if (user != null) {
            return true;
        }else {
            return false;
        }
    }

    //    改密码
    public boolean setUserPasswordByName(String name,
                                         String password){
        try {
            connect.updateUserPasswordByName(name, new Integer(password));
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User userInformation(String name){
        User user = null;
        try {
            user = connect.selectUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

}
