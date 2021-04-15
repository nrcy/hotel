package top.nrcynet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import top.nrcynet.dao.bean.ResultModel;
import top.nrcynet.dao.bean.ResultModel.GetDataResult;
import top.nrcynet.dao.bean.ResultModel.GetResult;
import top.nrcynet.dao.bean.User;
import top.nrcynet.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ResultModel resultModel;

    @JsonView(GetResult.class)
    @RequestMapping("/login")
    public ResultModel login(HttpServletRequest request, HttpServletResponse response){

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (name == "" || password == ""){
        	resultModel.setResult(false);
            return resultModel;
        }
        
        boolean result = false;
        
        try {
        	result = userService.login(name, password);
        }catch(Exception e) {
        	resultModel.setResult(false);
        	return resultModel;
        }

        if (result) {

        	
        	
            Cookie cookie = new Cookie("name_uuid", name);

            cookie.setMaxAge(60 * 60 * 24 * 10);
            cookie.setPath("/");

            response.addCookie(cookie);
            
            HttpSession session = request.getSession();
            session.setAttribute("loginState", true);
            
            resultModel.setResult(true);
        }else {
        	resultModel.setResult(false);
        }
        return resultModel;
    }

    @JsonView(GetResult.class)
    @RequestMapping("/register")
    public ResultModel register(@RequestParam(name = "name") String name,
                           @RequestParam(name = "password") String password){

    	resultModel.setResult(false);

        boolean value = userService.register(name, password);

        if (value) {
        	resultModel.setResult(true);
        }

        return resultModel;
    }

    @JsonView(GetResult.class)
    @RequestMapping("/verificationName")
    public ResultModel verificationName(@RequestParam(name = "name") String name){

    	resultModel.setResult(true);

        boolean value = userService.verificationName(name);

        if (value) {
            return resultModel;
        }
        resultModel.setResult(false);
        return resultModel;
    }

    @JsonView(GetResult.class)
    @RequestMapping("/set_user_password")
    public ResultModel setUserPassword(@RequestParam("name") String name,
                                  @RequestParam("password") String password){

        boolean result = userService.setUserPasswordByName(name, password);

        if (result) {
        	resultModel.setResult(true);
        }else {
        	resultModel.setResult(false);
        }
        return resultModel;
    }

    @JsonView(GetDataResult.class)
    @RequestMapping("/information")
    public ResultModel userInformation(@CookieValue(value = "name_uuid", defaultValue = "") String name){
        User user = userService.userInformation(name);

        resultModel.setObject(user);
        resultModel.setResult(true);

        return resultModel;
    }

}
