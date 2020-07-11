package top.nrcynet.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.nrcynet.dao.bean.User;
import top.nrcynet.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
//    public String login(@RequestParam(name = "name") String name,
//                        @RequestParam(name = "password") String password){
    public String login(HttpServletRequest request, HttpServletResponse response){

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (name == "" || password == ""){
            return "{\"result\":\"false\"}";
        }

        String data = "";

        boolean result = userService.login(name, password);

        if (result) {

            Cookie cookie = new Cookie("name", name);

            cookie.setMaxAge(60 * 60 * 24 * 10);
            cookie.setPath("/");

            response.addCookie(cookie);

            data = "{\"result\":\"true\"}";
        }else {
            data = "{\"result\":\"false\"}";
        }
        return data;
    }

    @RequestMapping("/register")
    public String register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password){

        String data = "{\"result\":\"false\"}";

        boolean value = userService.register(name, password);

        if (value) {
            data = "{\"result\":\"true\"}";
        }

        return data;
    }

    @RequestMapping("/verificationName")
    public String verificationName(@RequestParam(name = "name") String name){

        String data = "{\"result\":\"true\"}";

        boolean value = userService.verificationName(name);

        if (value) {
            return data;
        }
        data = "{\"result\":\"false\"}";
        return data;
    }

    @RequestMapping("/set_user_password")
    public String setUserPassword(@RequestParam("name") String name,
                                  @RequestParam("password") String password){
        String json = "";

        boolean result = userService.setUserPasswordByName(name, password);

        if (result) {
            json = "{\"result\":\"true\"}";
        }else {
            json = "{\"result\":\"false\"}";
        }
        return json;
    }

    @RequestMapping("/information")
    public String userInformation(@CookieValue("name") String name){
        User user = userService.userInformation(name);

        String json = JSON.toJSONString(user);

        return json;
    }

}
