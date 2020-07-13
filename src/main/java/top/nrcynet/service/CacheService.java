package top.nrcynet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.mapper.CacheMapper;

@Service
@Transactional(rollbackFor = Exception.class)
public class CacheService {

    @Autowired
    private CacheMapper cacheMapper;

    public Cache history(String name) {
        Cache cache = cacheMapper.selectCacheByName(name);

        return cache;
    }

    public boolean haveHistory(String name){
        Cache cache = cacheMapper.selectCacheByName(name);
        if (cache != null){
            return true;
        }
        return false;
    }


}
