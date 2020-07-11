package top.nrcynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.connect.Connect;

@Service
@Transactional(rollbackFor = Exception.class)
public class CacheService {

    @Autowired
    private Connect connect;

    public Cache history(String name) {
        Cache cache = connect.selectCacheByName(name);

        return cache;
    }

    public boolean haveHistory(String name){
        Cache cache = connect.selectCacheByName(name);
        if (cache != null){
            return true;
        }
        return false;
    }


}
