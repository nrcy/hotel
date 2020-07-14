package top.nrcynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import top.nrcynet.dao.bean.Cache;
import top.nrcynet.dao.bean.ResultModel;
import top.nrcynet.dao.bean.ResultModel.GetDataResult;
import top.nrcynet.dao.bean.ResultModel.GetResult;
import top.nrcynet.dao.bean.Room;
import top.nrcynet.service.CacheService;
import top.nrcynet.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CacheService cacheService;
    
    @Autowired
    private ResultModel resultModel;
    
    @JsonView(GetDataResult.class)
    @RequestMapping("/get_room")
    public ResultModel getOneRoom(@RequestParam("type") String type){
    	
    	try {
    		Room room = roomService.getOneRoom(type);
    		
    		resultModel.setObject(room);
    		resultModel.setResult(true);
    		
    	}catch(Exception e) {
    		resultModel.setObject(null);
    		resultModel.setResult(false);
    	}
    	
        return resultModel;

    }

    @JsonView(GetResult.class)
    @RequestMapping("/reserve")
    public ResultModel reserve(@RequestParam("roomId") String roomId,
                          @RequestParam("breakfast") String breakfast,
                          @CookieValue(value = "name", defaultValue = "") String username){

    	Boolean value = roomService.reserve(roomId, username, breakfast);

        if (value){
        	resultModel.setResult(true);
        }else {
        	resultModel.setResult(false);
        }
        return resultModel;
    }

    @JsonView(GetResult.class)
    @RequestMapping("/have_history")
    public ResultModel haveHistory(@CookieValue(value = "name", defaultValue = "") String name){
    	
        boolean result = cacheService.haveHistory(name);

        if (result){
        	resultModel.setResult(true);
        }else {
        	resultModel.setResult(false);
        }

        return resultModel;
    }

    @JsonView(GetDataResult.class)
    @RequestMapping("/history")
    public ResultModel history(@CookieValue(value = "name", defaultValue = "") String username){
        Cache cache = cacheService.history(username);
        if(cache != null) {
        	resultModel.setResult(true);
        	resultModel.setObject(cache);
        }else {
        	resultModel.setResult(false);
        	resultModel.setObject(null);
        }
        return resultModel;
    }

    @JsonView(GetResult.class)
    @RequestMapping("/pay")
    public ResultModel pay(@CookieValue(value = "name", defaultValue = "") String name){

        boolean result = roomService.checkOut(name);

        if (result) {
        	resultModel.setResult(true);
        }else {
        	resultModel.setResult(false);
        }

        return resultModel;
    }

}
