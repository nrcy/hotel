package top.nrcynet.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.service.CacheService;
import top.nrcynet.service.RoomService;
import top.nrcynet.service.UserService;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/get_room")
    public String getOneRoom(@RequestParam("type") String type){
        Room room = roomService.getOneRoom(type);
        return JSON.toJSONString(room);

    }

    @RequestMapping("/reserve")
    public String reserve(@RequestParam("roomId") String roomId,
                          @RequestParam("breakfast") String breakfast,
                          @CookieValue("name") String username){

        Boolean value = roomService.reserve(roomId, username, breakfast);
        if (value){
            return "{\"result\":\"true\"}";
        }
        return "{\"result\":\"false\"}";
    }

    @RequestMapping("/have_history")
    public String haveHistory(@CookieValue("name") String name){
        String json = "";
        boolean result = cacheService.haveHistory(name);

        if (result){
            json = "{\"result\":\"true\"}";
        }else {
            json = "{\"result\":\"false\"}";
        }

        return json;
    }

    @RequestMapping("/history")
    public String history(@CookieValue("name") String username){
        Cache cache = cacheService.history(username);
        String roomId = cache.getRoomId().toString();
        String price = cache.getPrice().toString();
        String json = "{\"roomId\":\"" + roomId + "\",\"price\":\"" + price + "\"}";
        return json;
    }

    @RequestMapping("/pay")
    public String pay(@CookieValue("name") String name){
        String json = "";

        boolean result = roomService.checkOut(name);

        if (result) {
            json = "{\"result\":\"true\"}";
        }else {
            json = "{\"result\":\"false\"}";
        }

        return json;
    }

}
