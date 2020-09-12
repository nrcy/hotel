package top.nrcynet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UrlController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("room")
    public String room(HttpServletRequest request,
                       HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();

        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                	if(session.getAttribute("loginState") == null) {
                		session.setAttribute("loginState", true);
                	}
                    return "room";
                }
            }
        }
        return "redirect: login";
    }

}
